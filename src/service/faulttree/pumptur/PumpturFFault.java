package service.faulttree.pumptur;

import service.faulttree.FloatTreement;

public class PumpturFFault {
	/*
	 * QueryFaultTreeAction af= new QueryFaultTreeAction() ; int No=af.getNo(); long
	 * time=af.getEndTime();
	 */

	// 冷却水流量低

	public double getWaterFLFault(long time, int No) {

		if (No == 1) {
			
			FloatTreement float303 = new FloatTreement();
			double p1 = float303.FloatTree(303, time, 452, 200);
			System.out.println(p1);
			return p1;
		} else if (No == 2) {
			FloatTreement float522 = new FloatTreement();
			double p1 = float522.FloatTree(522, time, 452, 200);
			return p1;
		} else if (No == 3) {
			FloatTreement float752 = new FloatTreement();
			double p1 = float752.FloatTree(752, time, 452, 200);
			return p1;
		} else if (No == 4) {
			FloatTreement float958 = new FloatTreement();
			double p1 = float958.FloatTree(958, time, 452, 200);
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}

	// 冷却水水温高
	public double getWaterTHFault(long time, int No) {

		if (No == 1) {
			FloatTreement float307 = new FloatTreement();
			double p1 = float307.FloatTree(307, time, 70, 0);
			return p1;
		} else if (No == 2) {
			FloatTreement float526 = new FloatTreement();
			double p1 = float526.FloatTree(526, time, 70, 0);
			return p1;
		} else if (No == 3) {
			FloatTreement float756 = new FloatTreement();
			double p1 = float756.FloatTree(756, time, 70, 0);
			return p1;
		} else if (No == 4) {
			FloatTreement float962 = new FloatTreement();
			double p1 = float962.FloatTree(962, time, 70, 0);
			return p1;
		} else {
			double p1 = 0;
			return p1;
		}
	}

	// 冷却水水压异常
		public double getWaterPLFault(long time, int No) {

			if (No == 1) {
				FloatTreement float304 = new FloatTreement();
				double p1 = float304.FloatTree(304, time, 16, 3);
				FloatTreement float305 = new FloatTreement();
				double p2 = float305.FloatTree(305, time, 16, 3);
				p1=(p1+p2)/2;
				return p1;
			} else if (No == 2) {
				FloatTreement float523 = new FloatTreement();
				double p1 = float523.FloatTree(523, time, 16, 3);
				FloatTreement float524 = new FloatTreement();
				double p2 = float524.FloatTree(524, time, 16, 3);
				p1=(p1+p2)/2;
				return p1;
			} else if (No == 3) {
				FloatTreement float753 = new FloatTreement();
				double p1 = float753.FloatTree(753, time, 16, 3);
				FloatTreement float754 = new FloatTreement();
				double p2 = float754.FloatTree(754, time, 16, 3);
				p1=(p1+p2)/2;
				return p1;
			} else if (No == 4) {
				FloatTreement float959 = new FloatTreement();
				double p1 = float959.FloatTree(959, time, 16, 3);
				FloatTreement float960 = new FloatTreement();
				double p2 = float960.FloatTree(960, time, 16, 3);
				p1=(p1+p2)/2;
				return p1;
			} else {
				double p1 = 0;
				return p1;
			}
		}
	
		// 油系统油压低
		public double getOilPLFault(long time, int No) {

			if (No == 1) {
				FloatTreement float308 = new FloatTreement();
				double p1 = float308.FloatTree(308, time, 10, 1);
				return p1;
			} else if (No == 2) {
				FloatTreement float527 = new FloatTreement();
				double p1 = float527.FloatTree(527, time, 10, 1);
				return p1;
			} else if (No == 3) {
				FloatTreement float757 = new FloatTreement();
				double p1 = float757.FloatTree(757, time, 10, 1);
				return p1;
			} else if (No == 4) {
				FloatTreement float963 = new FloatTreement();
				double p1 = float963.FloatTree(963, time, 10, 1);
				return p1;
			} else {
				double p1 = 0;
				return p1;
			}
		}

		// 油系统油位异常
				public double getOilHFFault(long time, int No) {

					if (No == 1) {
						FloatTreement float309 = new FloatTreement();
						double p1 = float309.FloatTree(309, time, 1170, 38);
						return p1;
					} else if (No == 2) {
						FloatTreement float528 = new FloatTreement();
						double p1 = float528.FloatTree(528, time, 1170, 38);
						return p1;
					} else if (No == 3) {
						FloatTreement float758 = new FloatTreement();
						double p1 = float758.FloatTree(758, time, 1170, 38);
						return p1;
					} else if (No == 4) {
						FloatTreement float964 = new FloatTreement();
						double p1 = float964.FloatTree(964, time, 1170, 38);
						return p1;
					} else {
						double p1 = 0;
						return p1;
					}
				}
		
				// 油系统油混水
				public double getOilWWFault(long time, int No) {

					if (No == 1) {
						FloatTreement float310 = new FloatTreement();
						double p1 = float310.FloatTree(310, time, 100, 0);
						return p1;
					} else if (No == 2) {
						FloatTreement float529 = new FloatTreement();
						double p1 = float529.FloatTree(529, time, 100, 0);
						return p1;
					} else if (No == 3) {
						FloatTreement float759 = new FloatTreement();
						double p1 = float759.FloatTree(759, time, 100, 0);
						return p1;
					} else if (No == 4) {
						FloatTreement float965 = new FloatTreement();
						double p1 = float965.FloatTree(965, time, 100, 0);
						return p1;
					} else {
						double p1 = 0;
						return p1;
					}
				}
	

				// 油系统油温高
				public double getOilTHFault(long time, int No) {

					if (No == 1) {
						FloatTreement float311 = new FloatTreement();
						double p1 = float311.FloatTree(311, time, 190, 0);
						FloatTreement float530 = new FloatTreement();
						double p2 = float530.FloatTree(530, time, 190, 0);
						p1=(p1+p2)/2;
						return p1;
					} else if (No == 2) {
						FloatTreement float760 = new FloatTreement();
						double p1 = float760.FloatTree(760, time, 190, 0);
						FloatTreement float966 = new FloatTreement();
						double p2 = float966.FloatTree(966, time, 190, 0);
						p1=(p1+p2)/2;
						return p1;
					} else if (No == 3) {
						FloatTreement float1087 = new FloatTreement();
						double p1 = float1087.FloatTree(1087, time, 190, 0);
						FloatTreement float1101 = new FloatTreement();
						double p2 = float1101.FloatTree(1101, time, 190, 0);
						p1=(p1+p2)/2;
						return p1;
					} else if (No == 4) {
						FloatTreement float1115 = new FloatTreement();
						double p1 = float1115.FloatTree(1115, time, 190, 0);
						FloatTreement float1129 = new FloatTreement();
						double p2 = float1129.FloatTree(1129, time, 190, 0);
						p1=(p1+p2)/2;
						return p1;
					} else {
						double p1 = 0;
						return p1;
					}
				}
				
				// 机组振动异常
				public double getVibFault(long time, int No) {

					if (No == 1) {
						FloatTreement float328 = new FloatTreement();
						double p1 = float328.FloatTree(328, time, 20, 0);
						return p1;
					} else if (No == 2) {
						FloatTreement float547 = new FloatTreement();
						double p1 = float547.FloatTree(547, time, 20, 0);
						return p1;
					} else if (No == 3) {
						FloatTreement float777 = new FloatTreement();
						double p1 = float777.FloatTree(777, time, 20, 0);
						return p1;
					} else if (No == 4) {
						FloatTreement float983 = new FloatTreement();
						double p1 = float983.FloatTree(983, time, 20, 0);
						return p1;
					} else {
						double p1 = 0;
						return p1;
					}
				}
				
				// 机组转速过高
				public double getRspeedHFault(long time, int No) {

					if (No == 1) {
						FloatTreement float156 = new FloatTreement();
						double p1 = float156.FloatTree(156, time, 200, 0);
						return p1;
					} else if (No == 2) {
						FloatTreement float375 = new FloatTreement();
						double p1 = float375.FloatTree(375, time, 200, 0);
						return p1;
					} else if (No == 3) {
						FloatTreement float594 = new FloatTreement();
						double p1 = float594.FloatTree(594, time, 200, 0);
						return p1;
					} else if (No == 4) {
						FloatTreement float812 = new FloatTreement();
						double p1 = float812.FloatTree(812, time, 200, 0);
						return p1;
					} else {
						double p1 = 0;
						return p1;
					}
				}	
				
				// 尾水管压力脉动
				public double getDraftPressure(long time, int No) {

					if (No == 1) {
						FloatTreement float299 = new FloatTreement();
						double p1 = float299.FloatTree(299, time, 16, 0);
						FloatTreement float300 = new FloatTreement();
						double p2 = float300.FloatTree(300, time, 16, 0);
						FloatTreement float301 = new FloatTreement();
						double p3 = float301.FloatTree(301, time, 16, 0);
						p1=(p1+p2+p3)/3;
						return p1;
					} else if (No == 2) {
						FloatTreement float518 = new FloatTreement();
						double p1 = float518.FloatTree(518, time, 16, 0);
						FloatTreement float519 = new FloatTreement();
						double p2 = float519.FloatTree(519, time, 16, 0);
						FloatTreement float520 = new FloatTreement();
						double p3 = float520.FloatTree(520, time, 16, 0);
						p1=(p1+p2+p3)/3;
						return p1;
					} else if (No == 3) {
						FloatTreement float737 = new FloatTreement();
						double p1 = float737.FloatTree(737, time, 16, 0);
						FloatTreement float738 = new FloatTreement();
						double p2 = float738.FloatTree(738, time, 16, 0);
						FloatTreement float739 = new FloatTreement();
						double p3 = float739.FloatTree(739, time, 16, 0);
						p1=(p1+p2+p3)/3;
						return p1;
					} else if (No == 4) {
						FloatTreement float953 = new FloatTreement();
						double p1 = float953.FloatTree(953, time, 16, 0);
						FloatTreement float954 = new FloatTreement();
						double p2 = float954.FloatTree(954, time, 16, 0);
						FloatTreement float955 = new FloatTreement();
						double p3 = float955.FloatTree(955, time, 16, 0);
						p1=(p1+p2+p3)/3;
						return p1;
					} else {
						double p1 = 0;
						return p1;
					}
				}
				
				
				
}
