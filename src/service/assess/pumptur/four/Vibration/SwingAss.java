package service.assess.pumptur.four.Vibration;

//振动总得分
public class SwingAss {

	public int getSwingAssResult(long time) {

		LowerBracket LB = new LowerBracket();
		int U1 = LB.LowerBracket(time);

		lowerguidebearing LGB = new lowerguidebearing();
		int U2 = LGB.lowerguidebearing(time);

		UpperBracket UB = new UpperBracket();
		int U3 = UB.UpperBracket(time);

		UpperGuideBearing UGB = new UpperGuideBearing();
		int U4 = UGB.UpperGuideBearing(time);

		WaterGuideBearing WGB = new WaterGuideBearing();
		int U5 = WGB.WaterGuideBearing(time);

		MainShaft MS = new MainShaft();
		int U6 = MS.MainShaft(time);

		int a = (U1 + U2 + U3 + U4 + U5 + U6) / 6;
		return a;
	}

	public static void main(String[] args) {

		SwingAss a = new SwingAss();
		System.out.println(a.getSwingAssResult(1441400000));
	}

}
