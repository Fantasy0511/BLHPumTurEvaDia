package bll.predict;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import libsvm.svm_model;
import libsvm.svm_node;
import util.LangUtil;
import util.PathUtil;
import bll.predict.svm.DataNormalize;
import bll.predict.svm.SvmPredict;
import bll.predict.svm.SvmPredictOne;
import bll.predict.svm.SvmTrain;

/**
 * 采用SVM预测，调用的是libsvm中的相关函数
 * 
 * @author dragon
 * 
 */
public class TendencyPredict {
	private List<Double> stepOutput; // 反归一化后的未来预测值，个数与stepNum对应
	private Vector<Double> finalResult; // 反归一化后的拟合结果
	private PredictTransfer transfer;
	private PredictInput input;

	public void predictMain(PredictInput input, int stepNum) throws IOException {
		String filePath = PathUtil.getWebRealBasePath() + "/data/predict/";
		String[] trainArg = { filePath + "model" }; // 存放训练后的模型
		String[] predictArg = { filePath + "predictData", filePath + "ouput" };

		this.input = input;
		transfer = new PredictTransfer(input);
		svm_model model = SvmTrain.main(trainArg, transfer.getNormalized_vx(),
				transfer.getNormalized_vy());// 模型训练

		Vector<Double> normalizedOutput = new Vector<Double>();// 训练样本拟合预测
		normalizedOutput = SvmPredict.main(model, transfer.getNormalized_vx(),
				transfer.getNormalized_vy(), predictArg);

		finalResult = DataNormalize.inverse_normalize_y(normalizedOutput,
				transfer.getMax_min_y());// 对预测结果进行反归一化

		svm_node[] lastInput = inputCreate(transfer.getLen(), input.getData());// 读取输入的最后len个样本以进行未来值的预测，读完后进行归一化
		svm_node[] normalizedLastInput = DataNormalize.normalize_x_one(
				lastInput, transfer.getMax_min_x());

		List<Double> normalizedStepOutput = new ArrayList<Double>();// 定义归一化的预测结果值
		for (int stepNo = 1; stepNo <= stepNum; stepNo++) {
			if (stepNo == 1) {
				Vector<svm_node[]> inputData = new Vector<svm_node[]>();
				inputData.addElement(normalizedLastInput);
				Vector<Double> output = SvmPredictOne.main(model, inputData,
						predictArg);
				normalizedStepOutput.add(output.get(0));
			} else {
				Vector<svm_node[]> inputData = new Vector<svm_node[]>();
				inputData.addElement(inputCreate_mutiStep(normalizedLastInput,
						normalizedStepOutput));
				Vector<Double> output = SvmPredictOne.main(model, inputData,
						predictArg);
				normalizedStepOutput.add(output.get(0));
			}
		}
		stepOutput = DataNormalize.inverse_normalize_y_list(
				normalizedStepOutput, transfer.getMax_min_y());

		System.out.println("以下输出svm为所有样本历史数据的拟合情况");// 输出预测样本的拟合结果
		/*for (int i = 0; i < finalResult.size(); i++)
			System.out.println("实际值为： " + transfer.getVy().get(i)
					+ "      预测值为： " + finalResult.get(i));*/
	}

	/**
	 * 所有的历史拟合值+未来预测值，用于画图
	 * 
	 * @param finalResult
	 *            反归一化后的历史拟合结果
	 * @param StepOutput
	 *            反归一化后的未来预测值，个数与stepNum对应
	 */
	public Vector<Double> getAllPredictValues() {
		Vector<Double> allPredictValues = new Vector<Double>();
		for (int i = 0; i < finalResult.size(); i++)
			allPredictValues.add(LangUtil.keepDigits(finalResult.get(i), 3));
		for (int i = 0; i < stepOutput.size(); i++)
			allPredictValues.add(LangUtil.keepDigits(stepOutput.get(i), 3));
		return allPredictValues;
	}
	
	
	public Vector<Double> getFinalResult() {
		Vector<Double> result = new Vector<>();
		for (Double d : finalResult) {
			result.add(LangUtil.keepDigits(d.doubleValue(), 3));
		}
		return result;
	}
	
	/**
	 * 获得与输入长度一直的输出，把前几位的嵌入维度补充上
	 * */
	public Vector<Double> getcompleteResult() {
		Vector<Double> result = new Vector<>();
		for (int i=0;i<transfer.getLen();i++) {
			result.add(LangUtil.keepDigits(this.getInput().getData()[i], 3));
		}
		for (int i = 0; i < finalResult.size(); i++)
			result.add(LangUtil.keepDigits(finalResult.get(i), 3));
		for (int i = 0; i < stepOutput.size(); i++)
			result.add(LangUtil.keepDigits(stepOutput.get(i), 3));
		return result;
	}


	public List<Double> getStepOutput() {
		return stepOutput;
	}

	public PredictTransfer getTransfer() {
		return transfer;
	}

	public PredictInput getInput() {
		return input;
	}

	/**
	 * 将原始数据的最后len个样本
	 * 
	 * @param len
	 * @param datas
	 * @return
	 */
	private svm_node[] inputCreate(int len, double[] datas) {
		svm_node[] input = new svm_node[len];
		for (int j = 0; j < len; j++) {
			input[j] = new svm_node();
			input[j].index = j + 1;
			input[j].value = Double.valueOf(datas[datas.length - len + j]);
		}
		return input;
	}

	/**
	 * 将最后len个样本进行归一化后的一个svm_node[]与预测得到的list进行组合得到多步预测的输入样本
	 * 
	 * @param normalizedLastInput
	 *            最后len个样本归一化值
	 * @param normalizedStepOutput
	 *            预测值的list
	 * @return
	 */
	private svm_node[] inputCreate_mutiStep(svm_node[] normalizedLastInput,
			List<Double> normalizedStepOutput) {
		int size = normalizedLastInput.length;
		svm_node[] input = new svm_node[size];
		int n = normalizedStepOutput.size(); // 此时的输入样本中包含的预测值个数
		int j = 0;
		for (; j < size - n; j++) {
			input[j] = new svm_node();
			input[j].index = j + 1;
			input[j].value = normalizedLastInput[n + j].value;
		}
		for (int k = 0; k < n; k++) {
			input[j + k] = new svm_node();
			input[j + k].index = j + k + 1;
			input[j + k].value = normalizedStepOutput.get(k);
		}
		return input;
	}
}
