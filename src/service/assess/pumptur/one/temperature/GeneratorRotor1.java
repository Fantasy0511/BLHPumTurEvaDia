package service.assess.pumptur.one.temperature;

import bll.BoolAssess;

//发电机转子温度得分
public class GeneratorRotor1 {

	public int GeneratorRotor(long time) {
        //转子温度
		BoolAssess bool1059 = new BoolAssess();
		int U1 = bool1059.BooleanAssess(1059, time);
		//转子温度
		BoolAssess bool1060 = new BoolAssess();
		int U2 = bool1060.BooleanAssess(1060, time);

		int a = (U1 + U2) / 2;
		return a;
		
		

	}
	
}