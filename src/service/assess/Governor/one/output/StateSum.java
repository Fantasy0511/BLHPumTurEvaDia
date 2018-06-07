package service.assess.Governor.one.output;

import service.assess.Governor.one.state.OilPressure;
import service.assess.Governor.one.state.OilTankOilLevel;
import service.assess.Governor.one.state.OilTankOilTemperature;
import service.assess.Governor.one.state.PressureOilLevel;
import service.assess.Governor.one.state.PressureTankPressure;

//调速油系统性能状态得分
public class StateSum {
	public double StateSum(long time){
		OilPressure OP=new OilPressure();
		int U1=OP.OilPressure(time);
		
		OilTankOilLevel OTOL=new OilTankOilLevel();
		int U2=OTOL.OilTankOilLevel(time);
		
		OilTankOilTemperature OTOT=new OilTankOilTemperature();
		int U3=OTOT.OilTankOilTemperature(time);
		
		PressureOilLevel  POL= new PressureOilLevel();
		int U4=POL.PressureOilLevel(time);
		
		PressureTankPressure PTP=new PressureTankPressure();
		int U5=PTP.PressureTankPressure(time);
		 
		double score=(U1+U2+U3+U4+U5)/5;
		return score;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StateSum a=new StateSum();
		System.out.println(a.StateSum(1441400000));
	}

}
