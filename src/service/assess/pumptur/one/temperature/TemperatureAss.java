package service.assess.pumptur.one.temperature;

import service.assess.pumptur.son.Temperatureresult1;

//温度总得分
public class TemperatureAss {
	public Temperatureresult1 getTemperatureAss(long time){
	//转子温度
	GeneratorRotor1 GR=new GeneratorRotor1();
	int U1=GR.GeneratorRotor(time);
	//上、下迷宫环温度
	LabyrinthRing1 LR=new LabyrinthRing1();
	int U2=LR.LabyrinthRing(time);
	//下导轴承温度
	LowerBearing1 LB=new LowerBearing1();
	int U3=LB.LowerBearing(time);
	//定子线圈温度
	StatorCoil1 SC=new StatorCoil1();
	int U4=SC.StatorCoil(time);
	//定子铁芯温度
	StatorCore1 SCR=new StatorCore1();
	int U5=SCR.StatorCore(time);
	// 推力轴承发电温度
	ThrustBearing1 TB=new ThrustBearing1();
	int U6=TB.ThrustBearing(time);
	// 上导轴承温度
	UpperBearing1 UB=new UpperBearing1();
	int U7=UB.UpperBearing(time);
	// 水导轴承温度
	WaterBearing1 WB=new WaterBearing1();
	int U8=WB.WaterBearing(time);
	
	int a=(U1+U2+U3+U4+U5+U6+U7+U8)/8;
	
	System.out.println("**************************");
	System.out.println("1号机组水泵水轮机温度状态总得分及各项");
	System.out.println("转子温度："+U1);
	System.out.println("上、下迷宫环温度："+U2);
	System.out.println("下导轴承温度："+U3);
	System.out.println("定子线圈温度："+U4);
	System.out.println("推力轴承发电温度："+U5);
	System.out.println("上导轴承温度："+U6);
	System.out.println("水导轴承温度："+U7);
	System.out.println("平均分："+a);
	System.out.println("**************************");
	
	Temperatureresult1 temperatureresult = new Temperatureresult1
			(U1, U2, U3, U4, U5, U6, U7, U8, a);
	return temperatureresult;
	
	
	
	}

}
