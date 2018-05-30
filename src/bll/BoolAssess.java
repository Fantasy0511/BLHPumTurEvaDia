package bll;

import java.util.List;

import dao.assess.DaoAssessment;

public class BoolAssess {
	private DaoAssessment as;

	public BoolAssess() {
		super();
		this.as = new DaoAssessment();
	}

	// bool型专用方法
	public int BooleanAssess(int id, long time) {
		int num = 0;
		List<Double> value = as.queBool("bool", id, time);

		for (Double h : value) {
			if (h == 1.0) {
				num++;
			}
		}
		int score = 96 - num * 20;
		num = 0;
		if (score < 0) {
			score = 0;
		}
		return score;
	}

	public DaoAssessment getAs() {
		return as;
	}

}
