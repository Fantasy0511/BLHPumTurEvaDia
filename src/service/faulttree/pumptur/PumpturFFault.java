package service.faulttree.pumptur;

import service.faulttree.FloatTreement;

public class PumpturFFault {
	/*
	 * QueryFaultTreeAction af= new QueryFaultTreeAction() ; int No=af.getNo(); long
	 * time=af.getEndTime();
	 */

	// 迷宫环温度异常

	public double getMgTFault(long time, int No) {

		if (No == 1) {
			FloatTreement float100 = new FloatTreement();
			double p1 = float100.FloatTree(1, time, 100, 200);
			return p1;
		} else if (No == 2) {
			FloatTreement float100 = new FloatTreement();
			double p1 = float100.FloatTree(2, time, 100, 200);
			return p1;
		} else if (No == 3) {
			FloatTreement float100 = new FloatTreement();
			double p1 = float100.FloatTree(3, time, 100, 200);
			return p1;
		} else if (No == 4) {
			FloatTreement float100 = new FloatTreement();
			double p1 = float100.FloatTree(4, time, 100, 200);
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}

	// 轴承振摆异常
	public double getBearingVFault(long time, int No) {

		if (No == 1) {
			FloatTreement float200 = new FloatTreement();
			double p1 = float200.FloatTree(1, time, 100, 200);
			return p1;
		} else if (No == 2) {
			FloatTreement float200 = new FloatTreement();
			double p1 = float200.FloatTree(2, time, 100, 200);
			return p1;
		} else if (No == 3) {
			FloatTreement float200 = new FloatTreement();
			double p1 = float200.FloatTree(3, time, 100, 200);
			return p1;
		} else if (No == 4) {
			FloatTreement float200 = new FloatTreement();
			double p1 = float200.FloatTree(4, time, 100, 200);
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}

}
