package service.assess.pumptur.three;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

public class Vibration3 {
	// 3号机组水泵水轮机振动得分

	public List<Number> getVibration3(long time) {
		DecimalFormat df = new DecimalFormat("#.0");
		List<Number> singleList = new ArrayList<>();

		// 主轴X轴摆动跳闸

		BoolAssess bool766 = new BoolAssess();
		int U1 = bool766.BooleanAssess(766, time);

		// 主轴Y轴摆动跳闸
		BoolAssess bool767 = new BoolAssess();
		int U2 = bool767.BooleanAssess(767, time);

		// 主轴X轴位移
		FloatAssessment float775 = new FloatAssessment();
		int U3 = float775.FloatAssess(775, time, 800, 0);
		// 主轴Y轴位移
		FloatAssessment float776 = new FloatAssessment();
		int U4 = float776.FloatAssess(776, time, 800, 0);

		// 水导轴承X轴摆动跳闸

		BoolAssess bool763 = new BoolAssess();
		int U5 = bool763.BooleanAssess(763, time);

		// 水导轴承Y轴摆动跳闸
		BoolAssess bool764 = new BoolAssess();
		int U6 = bool764.BooleanAssess(764, time);

		// 水导轴承Z轴摆动跳闸
		BoolAssess bool765 = new BoolAssess();
		int U7 = bool765.BooleanAssess(765, time);

		// 水导轴承X轴摆动速率
		FloatAssessment float777 = new FloatAssessment();
		int U8 = float777.FloatAssess(777, time, 20, 0);
		// 水导轴承Y轴摆动速率
		FloatAssessment float778 = new FloatAssessment();
		int U9 = float778.FloatAssess(778, time, 20, 0);
		// 水导轴承Z轴摆动速率
		FloatAssessment float779 = new FloatAssessment();
		int U10 = float779.FloatAssess(779, time, 20, 0);

		double score = (U1 + U2 + U3 + U4 + U5 + U6 + U7 + U8 + U9 + U10) / 10;
		score = Double.parseDouble(df.format(score));

		singleList.add(U1);
		singleList.add(U2);
		singleList.add(U3);
		singleList.add(U4);
		singleList.add(U5);
		singleList.add(U6);
		singleList.add(U7);
		singleList.add(U8);
		singleList.add(U9);
		singleList.add(U10);
		singleList.add(score);
		return singleList;

	}
}
