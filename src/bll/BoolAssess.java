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
		int sumValue=value.size();
		if (sumValue==0) {
			int score = 96;
			return score;
		}
		else {
			
		for (int i=0;i<value.size()-1;i++) {
			if ((value.get(i) == 0&&value.get(i+1) == 0)||
					(value.get(i) == 1&&value.get(i+1) == 0)) {
				num++;           /*bool类型的故障value值每出现一次，num就加一*/
			}
		}
		int score = 96-5*num;
		if (score<20) {
			score=23;
			
		}
		return score;
		}
	}
}
