package service.assess.pumptur.one.temperature;

import bll.BoolAssess;

//发电机转子温度得分
public class GeneratorRotor1 {

	public int GeneratorRotor(long time) {
        //转子温度
		BoolAssess bool99 = new BoolAssess();
		int U1 = bool99.BooleanAssess(99, time);
		//转子温度
		BoolAssess bool100 = new BoolAssess();
		int U2 = bool100.BooleanAssess(100, time);

		int a = (U1 + U2) / 2;
		return a;
		
		

	}
	
}