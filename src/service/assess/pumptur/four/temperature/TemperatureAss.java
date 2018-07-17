package service.assess.pumptur.four.temperature;

import service.assess.pumptur.son.Temperatureresult1;

//温度总得分
public class TemperatureAss {
	public Temperatureresult1 getTemperatureAss(long time) {
		GeneratorRotor GR = new GeneratorRotor();
		int U1 = GR.GeneratorRotor(time);

		LabyrinthRing LR = new LabyrinthRing();
		int U2 = LR.LabyrinthRing(time);

		LowerBearing LB = new LowerBearing();
		int U3 = LB.LowerBearing(time);

		StatorCoil SC = new StatorCoil();
		int U4 = SC.StatorCoil(time);

		StatorCore SCR = new StatorCore();
		int U5 = SCR.StatorCore(time);

		ThrustBearing TB = new ThrustBearing();
		int U6 = TB.ThrustBearing(time);

		UpperBearing UB = new UpperBearing();
		int U7 = UB.UpperBearing(time);

		WaterBearing WB = new WaterBearing();
		int U8 = WB.WaterBearing(time);

		int a = (U1 + U2 + U3 + U4 + U5 + U6 + U7 + U8) / 8;
		Temperatureresult1 temperatureresult = new Temperatureresult1
				(U1, U2, U3, U4, U5, U6, U7, U8, a);
		return temperatureresult;
	}
}
