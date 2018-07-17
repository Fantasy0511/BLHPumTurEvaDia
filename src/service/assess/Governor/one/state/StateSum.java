package service.assess.Governor.one.state;

import java.util.ArrayList;
import java.util.List;

//调速油系统性能状态得分
public class StateSum {
	/**
	 * 油压、油泵油位、油泵油温、压油泵油位、压油泵油压
	 */
	public List<Number> getStateSum(long time) {
		
		List<Number> oilStateList = new ArrayList<>();
		OilPressure OP = new OilPressure();
		int U1 = OP.OilPressure(time);

		OilTankOilLevel OTOL = new OilTankOilLevel();
		int U2 = OTOL.OilTankOilLevel(time);

		OilTankOilTemperature OTOT = new OilTankOilTemperature();
		int U3 = OTOT.OilTankOilTemperature(time);

		PressureOilLevel POL = new PressureOilLevel();
		int U4 = POL.PressureOilLevel(time);

		PressureTankPressure PTP = new PressureTankPressure();
		int U5 = PTP.PressureTankPressure(time);

		double score = (U1 + U2 + U3 + U4 + U5) / 5;
		System.out.println("%%%%%%%%%%%%%");
		System.out.println("油系统底层指标得分");
		System.out.println("油压："+U1);
		System.out.println("油泵油位："+U2);
		System.out.println("油泵油温："+U3);
		System.out.println("油压油泵油位："+U4);
		System.out.println("压油泵油压："+U5);
		System.out.println("综合得分："+score);
		System.out.println("%%%%%%%%%%%%%");
		oilStateList.add(U1);
		oilStateList.add(U2);
		oilStateList.add(U3);
		oilStateList.add(U4);
		oilStateList.add(U5);
		oilStateList.add(score);
		return oilStateList;
	}

	public static void main(String[] args) {
		StateSum a = new StateSum();
		System.out.println(a.getStateSum(1441400000));
	}

}
