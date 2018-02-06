package service.assess.Governor.one.FaultSignal;

import bll.BoolAssess;

//调速器调速油箱阻塞
public class OilTank {
	public int getOilTank(long time) {

		BoolAssess bool214 = new BoolAssess();
		int U1 = bool214.BooleanAssess(214, time);
		return U1;
	}
}