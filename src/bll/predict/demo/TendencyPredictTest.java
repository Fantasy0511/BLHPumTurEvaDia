package bll.predict.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import libsvm.svm_model;
import libsvm.svm_node;
import util.PathUtil;
import bll.predict.svm.DataNormalize;
import bll.predict.svm.SvmPredict;
import bll.predict.svm.SvmTrain;

/**
 * 此类为对预测代码进行模块化改进前的测试类。
 * 
 * @author 付文龙
 * 
 */
public class TendencyPredictTest {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException { // svm_problem
		String filePath = PathUtil.getWebRealBasePath() + "/data/predict/";
		String trainDataPath = filePath + "trainData2";
		BufferedReader fp = new BufferedReader(new FileReader(trainDataPath));
		String[] datas = null;
		String line = fp.readLine();
		if (line == null)
			System.out.println("文件中没有数据！！！！");
		else if (line.length() > 50)
			datas = line.split(",");
		else {
			List<String> mid = new ArrayList<String>();
			do {
				mid.add(line);
				line = fp.readLine();
			} while (line != null);
			datas = new String[mid.size()];
			for (int i = 0; i < mid.size(); i++) {
				datas[i] = mid.get(i);
			}
		}

		System.out.println("数据总长度为：" + datas.length);
		// 上面的代码得到用于预测的所有输入数据，下面的代码则将数据转换为SVM可以识别的格式（node）
		int len = 8;// 单步预测，根据前8个样本预测1个
		int N = datas.length - len;// 可供训练的样本个数

		Vector<Double> vy = new Vector<Double>(); // 重构后的输出矩阵
		Vector<svm_node[]> vx = new Vector<svm_node[]>(); // 重构后的输入矩阵

		for (int i = 0; i < N; i++) {
			svm_node[] x = new svm_node[len];
			for (int j = 0; j < len; j++) {
				x[j] = new svm_node();
				x[j].index = j + 1;
				x[j].value = Double.valueOf(datas[i + j]);
			}
			vx.addElement(x);
			vy.addElement(Double.valueOf(datas[len + i]));
		}

		String[] trainArg = { filePath + "model" }; // 存放训练后的模型
		String[] predictArg = { filePath + "predictData", filePath + "ouput" };

		double[][] max_min_x = DataNormalize.cal_max_min_x(vx);
		double[] max_min_y = DataNormalize.cal_max_min_y(vy);
		Vector<svm_node[]> normalized_vx = DataNormalize.normalize_x(vx,
				max_min_x);
		Vector<Double> normalized_vy = DataNormalize.normalize_y(vy, max_min_y);
		Vector<Double> normalizedPredictOutput = new Vector<Double>();
		try {
			svm_model model = SvmTrain.main(trainArg, normalized_vx,
					normalized_vy);
			normalizedPredictOutput = SvmPredict.main(model, normalized_vx,
					normalized_vy, predictArg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Vector<Double> finalResult = DataNormalize.inverse_normalize_y(
				normalizedPredictOutput, max_min_y);

		for (int i = 0; i < finalResult.size(); i++) {
			System.out.println("实际值为： " + vy.get(i) + "      预测值为： "
					+ finalResult.get(i));
		}
	}
}
