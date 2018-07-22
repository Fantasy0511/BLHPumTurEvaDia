package service.assess.pumptur.one.Vibration1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//振动总得分
public class SwingAss {

	public List<Number> getSwingAssResult(long time) {

		DecimalFormat df = new DecimalFormat("#.0");

		List<Number> singleList = new ArrayList<>();
		// 下机架振动
		LowerBracket1 LB = new LowerBracket1();
		int U1 = LB.LowerBracket(time);
		// 下导轴承振动
		lowerguidebearing1 LGB = new lowerguidebearing1();
		int U2 = LGB.lowerguidebearing(time);
		// 上机架振动
		UpperBracket1 UB = new UpperBracket1();
		int U3 = UB.UpperBracket(time);
		// 上导轴承振动
		UpperGuideBearing1 UGB = new UpperGuideBearing1();
		int U4 = UGB.UpperGuideBearing(time);
		// 水导轴承振动
		WaterGuideBearing1 WGB = new WaterGuideBearing1();
		int U5 = WGB.WaterGuideBearing(time);
		// 主轴振动
		MainShaft1 MS = new MainShaft1();
		int U6 = MS.MainShaft(time);

		double score = (U1 + U2 + U3 + U4 + U5 + U6) / 6;
		score = Double.parseDouble(df.format(score));

		singleList.add(U1);
		singleList.add(U2);
		singleList.add(U3);
		singleList.add(U4);
		singleList.add(U5);
		singleList.add(U6);
		singleList.add(score);
		return singleList;
	}

}