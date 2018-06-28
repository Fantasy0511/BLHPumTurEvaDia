package service.faulttree.Genmotor;

import service.faulttree.BoolTree;

public class GenMotorFaultDay {
	// 转频过高
	public int getRotateFFault(long time, int No) {

		int flag = 0;
		if (No == 1) {

			BoolTree bool87 = new BoolTree();
			flag = bool87.BooleanTreeDay(87, time);
			return flag;
		} else if (No == 2) {
			BoolTree bool404 = new BoolTree();
			flag = bool404.BooleanTreeDay(404, time);
			return flag;
		} else if (No == 3) {
			BoolTree bool727 = new BoolTree();
			flag = bool727.BooleanTreeDay(727, time);

			return flag;
		} else if (No == 4) {
			BoolTree bool1049 = new BoolTree();
			flag = bool1049.BooleanTreeDay(1049, time);

			return flag;
		} else {
			return flag;
		}
	}
	// 空冷器故障

	public int getACoolerFault(long time, int No) {
		int flag = 0;
		if (No == 1) {
			BoolTree bool307 = new BoolTree();
			flag = bool307.BooleanTreeDay(307, time);
			return flag;
		} else if (No == 2) {
			BoolTree bool634 = new BoolTree();
			flag = bool634.BooleanTreeDay(634, time);
			return flag;
		} else if (No == 3) {
			BoolTree bool953 = new BoolTree();
			flag = bool953.BooleanTreeDay(953, time);
			return flag;
		} else if (No == 4) {
			BoolTree bool1279 = new BoolTree();
			flag = bool1279.BooleanTreeDay(1279, time);
			return flag;
		} else {
			return flag;
		}
	}
	// 转子绝缘损坏

	public int getRoInsulationFault(long time, int No) {
		int flag = 0;
		if (No == 1) {
			BoolTree bool85 = new BoolTree();
			flag = bool85.BooleanTreeDay(85, time);
			return flag;
		} else if (No == 2) {
			BoolTree bool402 = new BoolTree();
			flag = bool402.BooleanTreeDay(402, time);
			return flag;
		} else if (No == 3) {
			BoolTree bool725 = new BoolTree();
			flag = bool725.BooleanTreeDay(725, time);
			return flag;
		} else if (No == 4) {
			BoolTree bool1047 = new BoolTree();
			flag = bool1047.BooleanTreeDay(1047, time);
			return flag;
		} else {

			return flag;
		}
	}

	// 转频振动
	public int getZhuanPin(long time, int No) {
		int flag = 0;
		if (No == 1) {
			BoolTree bool26 = new BoolTree();
			flag = bool26.BooleanTreeDay(26, time);
			return flag;
		} else if (No == 2) {
			BoolTree bool338 = new BoolTree();
			double p1 = bool338.BooleanTreeDay(338, time);
			BoolTree bool339 = new BoolTree();
			double p2 = bool339.BooleanTreeDay(339, time);
			p1 = p1 + p2;

			if (p1 > 0) {
				flag = 1;
			}
			return flag;
		} else if (No == 3) {
			BoolTree bool661 = new BoolTree();
			double p1 = bool661.BooleanTreeDay(661, time);
			BoolTree bool662 = new BoolTree();
			double p2 = bool662.BooleanTreeDay(662, time);
			p1 = p1 + p2;

			if (p1 > 0) {
				flag = 1;
			}
			return flag;
		} else if (No == 4) {
			BoolTree bool984 = new BoolTree();
			double p1 = bool984.BooleanTreeDay(984, time);
			BoolTree bool985 = new BoolTree();
			double p2 = bool985.BooleanTreeDay(985, time);
			p1 = p1 + p2;

			if (p1 > 0) {
				flag = 1;
			}
			return flag;
		} else {

			return flag;
		}
	}

	// 极频振动

	public int getJiPin(long time, int No) {
		int flag = 0;
		if (No == 1) {

			return flag;
		} else if (No == 2) {
			BoolTree bool340 = new BoolTree();
			flag = bool340.BooleanTreeDay(340, time);
			return flag;
		} else if (No == 3) {
			BoolTree bool663 = new BoolTree();
			flag = bool663.BooleanTreeDay(663, time);
			return flag;
		} else if (No == 4) {
			BoolTree bool986 = new BoolTree();
			flag = bool986.BooleanTreeDay(986, time);
			return flag;
		} else {
			return flag;
		}
	}

	// 励磁电源异常

	public int getExcitePowerFault(long time, int No) {
		int flag = 0;
		if (No == 1) {
			BoolTree bool285 = new BoolTree();
			flag = bool285.BooleanTreeDay(285, time);
			return flag;
		} else if (No == 2) {
			BoolTree bool608 = new BoolTree();
			flag = bool608.BooleanTreeDay(608, time);
			return flag;
		} else if (No == 3) {
			BoolTree bool924 = new BoolTree();
			flag = bool924.BooleanTreeDay(924, time);
			return flag;
		} else if (No == 4) {
			BoolTree bool1251 = new BoolTree();
			flag = bool1251.BooleanTreeDay(1251, time);
			return flag;
		} else {

			return flag;
		}
	}

	// 风扇故障

	public int getFanFault(long time, int No) {
		int flag = 0;
		if (No == 1) {
			BoolTree bool279 = new BoolTree();
			flag = bool279.BooleanTreeDay(279, time);
			return flag;
		} else if (No == 2) {
			BoolTree bool602 = new BoolTree();
			flag = bool602.BooleanTreeDay(602, time);
			return flag;
		} else if (No == 3) {
			BoolTree bool927 = new BoolTree();
			flag = bool927.BooleanTreeDay(927, time);
			return flag;
		} else if (No == 4) {
			BoolTree bool1245 = new BoolTree();
			flag = bool1245.BooleanTreeDay(1245, time);
			return flag;
		} else {

			return flag;
		}
	}

}
