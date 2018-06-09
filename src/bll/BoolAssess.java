package bll;

import java.util.ArrayList;

import dao.assess.DaoAssessment;
import util.DataUtils;

public class BoolAssess {
	int num = 0;

	// bool型专用方法
	public int BooleanAssess(int id, long time) {
		DaoAssessment as = new DaoAssessment();
		DataUtils data = as.queBool("bool", id, time);
		ArrayList<Double> value = data.getValue();

		for (Double h : value) {
			if (h == 1.0) {
				num++;           /*bool类型的故障value值每出现一次，num就加一*/
			}
		}
		int score = 96 - num * 20;
		num = 0;
		if (score < 0) {
			score = 0;
		}
		return score;
	}

}
