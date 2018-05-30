package service.assess.pumptur.one.temperature;



//温度总得分
public class test21 {
	public int test2(long time){
	GeneratorRotor1 GR=new GeneratorRotor1();
	int U1=GR.GeneratorRotor(time);
	
	LabyrinthRing1 LR=new LabyrinthRing1();
	int U2=LR.LabyrinthRing(time);
	
	LowerBearing1 LB=new LowerBearing1();
	int U3=LB.LowerBearing(time);
	
	StatorCoil1 SC=new StatorCoil1();
	int U4=SC.StatorCoil(time);
	
	StatorCore1 SCR=new StatorCore1();
	int U5=SCR.StatorCore(time);
	
	ThrustBearing1 TB=new ThrustBearing1();
	int U6=TB.ThrustBearing(time);
	
	UpperBearing1 UB=new UpperBearing1();
	int U7=UB.UpperBearing(time);
	
	WaterBearing1 WB=new WaterBearing1();
	int U8=WB.WaterBearing(time);
	
	int a=(U1+U2+U3+U4+U5+U6+U7+U8)/8;
	return a;
	}
//public static void main(String[] args) {
//		
//		test2 a=new test2();
//		System.out.println(a.test2(1441400000));
//	}
}
