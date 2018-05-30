package bll;

import java.util.List;

import dao.assess.DaoAssessment;

public class FloatAssessment {
	private DaoAssessment assessment;

	public FloatAssessment() {
		super();
		this.assessment = new DaoAssessment();
	}

	// float型数据专用方法
	public int FloatAssess(int id, long time, double Hlimite, double Llimite) {
		double li = 0.0;

		List<Double> value = assessment.queFloat("float", id, time);
		for (Double d : value) {
			System.out.println(d);
			double C2 = Hlimite;
			double C1 = Llimite;
			double interval = C2 - C1;// 区间大小
			double mid = (C2 + C1) / 2;// 区间中点
			if (0 < d && d < 2) {
				li = 0.0;
			} else {
				if (d > mid - 0.4 * interval && d < mid + 0.4 * interval)
					li = 0.0;
				else if (d <= mid - 0.4 * interval && d >= C1)
					li = (mid - 0.4 * interval - d)
							/ (mid - 0.4 * interval - C1);
				else if (d >= mid + 0.4 * interval && d <= C2)
					li = (d - (mid + 0.4 * interval))
							/ (C2 - (mid + 0.4 * interval));
				else
					li = 1.0;
			}
		}
		System.out.println(li);
		int a = (int) (98 - 40 * li);

		return a;
	}

	public DaoAssessment getAssessment() {
		return assessment;
	}
	
}
