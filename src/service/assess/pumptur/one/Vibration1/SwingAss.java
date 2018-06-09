package service.assess.pumptur.one.Vibration1;
//振动总得分
public class SwingAss {

	public int getSwingAssResult(long time){
		
		
		LowerBracket1 LB=new LowerBracket1();
		int U1=LB.LowerBracket(time);
		
		lowerguidebearing1 LGB=new lowerguidebearing1();
		int U2=LGB.lowerguidebearing(time);
		
		UpperBracket1 UB=new UpperBracket1();
		int U3=UB.UpperBracket(time);
		
		
		
		UpperGuideBearing1 UGB=new UpperGuideBearing1();
		int U4=UGB.UpperGuideBearing(time);
		

		WaterGuideBearing1   WGB=new WaterGuideBearing1();
		int U5=WGB.WaterGuideBearing(time);
		
		
		MainShaft1 MS=new MainShaft1();
		int U6=MS.MainShaft(time);
		
		int a=(U1+U2+U3+U4+U5+U6)/6;
		return a;
	}
	
	
}
