package bll;

import java.util.ArrayList;

import dao.assess.DaoAssessment;
import util.DataUtils;

public class BoolAssess {
	
	
	// bool型专用方法
	public int BooleanAssess(int id, long time) {
		DaoAssessment as = new DaoAssessment();
		DataUtils data = as.queBool("bool", id, time);
		ArrayList<Double> value = data.getValue();
		int sumValue=value.size();
		if (value.size()==0||sumValue==0) {
			return 100;
		}
		else {
		int num = 0;	
		for (int i=0;i<value.size()-1;i++) {
			if ((value.get(i) == 0&&value.get(i+1) == 1)||
					(value.get(i) == 1&&value.get(i+1) == 0)) {
				num++;           /*bool类型的故障value值每出现一次，num就加一*/
			}
		}
		int score = 100-5*num;
		if (score<30) {
			score=30;
			
		}
		return score;
		}
	}
}
