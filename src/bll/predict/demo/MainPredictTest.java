package bll.predict.demo;

import java.io.IOException;

import bll.predict.PredictInput;
import bll.predict.TendencyPredict;
import bll.predict.dao.AssessPredictData;

public class MainPredictTest {
	public static void main(String[] arg) throws IOException {
		int unitNo = 1;
		String objStr = "TotalState";
		int stepNum = 3;
		PredictInput input = AssessPredictData.read("float_201602",unitNo, objStr,(long)1455552000);
		TendencyPredict predict = new TendencyPredict();
		predict.predictMain(input, stepNum);

		System.out.println();
		for (int i = 0; i < stepNum; i++) {
			System.out.println("预测的未来第  " + (i + 1) + " 个值为:  "
					+ predict.getStepOutput().get(i));
		}
		System.out.println("FinalResult().size()="
				+ predict.getFinalResult().size());
		System.out.println("StepOutput().size()="
				+ predict.getStepOutput().size());
		System.out.println("AllPredictValues().size()="
				+ predict.getAllPredictValues().size());
		System.out.println("结束！！！");
	}
}
