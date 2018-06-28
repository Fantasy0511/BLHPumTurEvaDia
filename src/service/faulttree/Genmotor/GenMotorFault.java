package service.faulttree.Genmotor;

import service.faulttree.BoolTree;

public class GenMotorFault {

	public double getRotateFFault(long time, int No) {

		// 转频过高
		if (No == 1) {
			BoolTree bool87 = new BoolTree();
			double p1 = bool87.BooleanTree(87, time);
			return p1;
		} else if (No == 2) {
			BoolTree bool404 = new BoolTree();
			double p1 = bool404.BooleanTree(404, time);
			return p1;
		} else if (No == 3) {
			BoolTree bool727 = new BoolTree();
			double p1 = bool727.BooleanTree(727, time);

			return p1;
		} else if (No == 4) {
			BoolTree bool1049 = new BoolTree();
			double p1 = bool1049.BooleanTree(1049, time);

			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}
	// 空冷器故障

	public double getACoolerFault(long time, int No) {

		if (No == 1) {
			BoolTree bool307 = new BoolTree();
			double p1 = bool307.BooleanTree(307, time);
			return p1;
		} else if (No == 2) {
			BoolTree bool634 = new BoolTree();
			double p1 = bool634.BooleanTree(634, time);
			return p1;
		} else if (No == 3) {
			BoolTree bool953 = new BoolTree();
			double p1 = bool953.BooleanTree(953, time);
			return p1;
		} else if (No == 4) {
			BoolTree bool1279 = new BoolTree();
			double p1 = bool1279.BooleanTree(1279, time);
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}
	// 转子绝缘损坏

	public double getRoInsulationFault(long time, int No) {

		if (No == 1) {
			BoolTree bool85 = new BoolTree();
			double p1 = bool85.BooleanTree(85, time);
			return p1;
		} else if (No == 2) {
			BoolTree bool402 = new BoolTree();
			double p1 = bool402.BooleanTree(402, time);
			return p1;
		} else if (No == 3) {
			BoolTree bool725 = new BoolTree();
			double p1 = bool725.BooleanTree(725, time);
			return p1;
		} else if (No == 4) {
			BoolTree bool1047 = new BoolTree();
			double p1 = bool1047.BooleanTree(1047, time);
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}

	// 转频振动
	public double getZhuanPin(long time, int No) {

		if (No == 1) {
			BoolTree bool26 = new BoolTree();
			double p1 = bool26.BooleanTree(26, time);

			return p1;
		} else if (No == 2) {
			BoolTree bool338 = new BoolTree();
			double p1 = bool338.BooleanTree(338, time);
			BoolTree bool339 = new BoolTree();
			double p2 = bool339.BooleanTree(339, time);
			p1 = p1 + p2;

			if (p1 > 0.9) {
				p1 = 0.9;
			}
			return p1;
		} else if (No == 3) {
			BoolTree bool661 = new BoolTree();
			double p1 = bool661.BooleanTree(661, time);
			BoolTree bool662 = new BoolTree();
			double p2 = bool662.BooleanTree(662, time);
			p1 = p1 + p2;

			if (p1 > 0.9) {
				p1 = 0.9;
			}
			return p1;
		} else if (No == 4) {
			BoolTree bool984 = new BoolTree();
			double p1 = bool984.BooleanTree(984, time);
			BoolTree bool985 = new BoolTree();
			double p2 = bool985.BooleanTree(985, time);
			p1 = p1 + p2;

			if (p1 > 0.9) {
				p1 = 0.9;
			}
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}

	// 极频振动

	public double getJiPin(long time, int No) {

		if (No == 1) {

			double p1 = 0;
			return p1;
		} else if (No == 2) {
			BoolTree bool340 = new BoolTree();
			double p1 = bool340.BooleanTree(340, time);
			return p1;
		} else if (No == 3) {
			BoolTree bool663 = new BoolTree();
			double p1 = bool663.BooleanTree(663, time);
			return p1;
		} else if (No == 4) {
			BoolTree bool986 = new BoolTree();
			double p1 = bool986.BooleanTree(986, time);
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}

	// 励磁电源异常

	public double getExcitePowerFault(long time, int No) {

		if (No == 1) {
			BoolTree bool285 = new BoolTree();
			double p1 = bool285.BooleanTree(285, time);
			return p1;
		} else if (No == 2) {
			BoolTree bool608 = new BoolTree();
			double p1 = bool608.BooleanTree(608, time);
			return p1;
		} else if (No == 3) {
			BoolTree bool924 = new BoolTree();
			double p1 = bool924.BooleanTree(924, time);
			return p1;
		} else if (No == 4) {
			BoolTree bool1251 = new BoolTree();
			double p1 = bool1251.BooleanTree(1251, time);
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}

	// 风扇故障

	public double getFanFault(long time, int No) {

		if (No == 1) {
			BoolTree bool279 = new BoolTree();
			double p1 = bool279.BooleanTree(279, time);
			return p1;
		} else if (No == 2) {
			BoolTree bool602 = new BoolTree();
			double p1 = bool602.BooleanTree(602, time);
			return p1;
		} else if (No == 3) {
			BoolTree bool927 = new BoolTree();
			double p1 = bool927.BooleanTree(927, time);
			return p1;
		} else if (No == 4) {
			BoolTree bool1245 = new BoolTree();
			double p1 = bool1245.BooleanTree(1245, time);
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}

}
