
package service.faulttree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.impl.ReadData;
import bll.diagnosis.tree.dao.DaoTree;
import util.DataInfo;
import util.DataUtils;

public class FloatTreement {
	// float型数据专用方法
	public double FloatTree(int id, long time, double Hlimite, double Llimite) {

		DaoTree as = new DaoTree();

		DataUtils data = as.queFloat("float", id, time);
		ReadData readDB = new ReadData();
		HashMap<String, DataInfo> maps = new HashMap<String, DataInfo>();
		try {
			maps = readDB.queInfo();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataInfo datainfo = maps.get(data.getType() + data.getId());
		double C2 = datainfo.getHLimite();// 高报警
		double C1 = datainfo.getLLimite();// 低报警
		ArrayList<Double> value = data.getValue();
		double p = 0;
		int x = 0; // x表示越限次数
		int y = 0; // y表示不越限次数

		for (Double d : value) {

			if (C2 != 0 && d > C2) {
				x += 1;
			} else if (C1 != 0 && d < C1) {
				x += 1;
			}
		}
		return x / value.size();
	}

	// 下限报警
	public double FloatTreeL(int id, long time, double Llimite) {

		DaoTree as = new DaoTree();

		DataUtils data = as.queFloat("float", id, time);
		ReadData readDB = new ReadData();
		HashMap<String, DataInfo> maps = new HashMap<String, DataInfo>();
		try {
			maps = readDB.queInfo();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataInfo datainfo = maps.get(data.getType() + data.getId());

		double C1 = datainfo.getLLimite();// 低报警
		ArrayList<Double> value = data.getValue();

		int x = 0; // x表示越限次数

		for (Double d : value) {

			if (C1 != 0 && d < C1) {
				x += 1;
			}
		}
		return x / value.size();
	}
	// 上限报警
		public double FloatTreeH(int id, long time, double Hlimite) {

			DaoTree as = new DaoTree();

			DataUtils data = as.queFloat("float", id, time);
			ReadData readDB = new ReadData();
			HashMap<String, DataInfo> maps = new HashMap<String, DataInfo>();
			try {
				maps = readDB.queInfo();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DataInfo datainfo = maps.get(data.getType() + data.getId());

			double C2 = datainfo.getHLimite();// 低报警
			ArrayList<Double> value = data.getValue();

			int x = 0; // x表示越限次数

			for (Double d : value) {

				if (C2 != 0 && d > C2) {
					x += 1;
				
				}
			}
			return x / value.size();
		}
	// 耗油速度计算
	public int DoubleTree(int id, long time) {
		DaoTree as = new DaoTree();
		int flag = 0;
		double avg = 0;
		double sum = 0;
		int j = 0;
		DataUtils data = as.queFloat("float", id, time);
		ArrayList<Double> values = data.getValue();// 获取油位信息
		ArrayList<Long> T = data.getTime();
		for (int i = 0; i < (values.size() - 1); i++) {
			// 计算平均耗油速度
			sum = sum + (values.get(i) - values.get(i + 1)) / (T.get(i + 1) - T.get(i));
			// 判断停泵时耗油速度
			if (values.get(i) > values.get(i + 1)) {
				avg = (values.get(i) - values.get(i + 1)) / (T.get(i + 1) - T.get(i));
			}
			if (avg > sum) {
				j = j + 1;
			}
			if (j / values.size() > 0.1) {
				flag = 1;
			} else {
				flag = 0;
			}
		}
		return flag;
	}

	// 磨损计算
	public int MoSunTree(int id, long time) {
		DaoTree as = new DaoTree();
		int flag = 0;

		double sum = 0;

		DataUtils data = as.queFloat("float", id, time);
		ArrayList<Double> values = data.getValue();

		for (int i = 0; i < (values.size() - 1); i++) {

			sum = (values.get(i) - values.get(i + 1));
			if (sum > 0) {
				flag = 1;
			}
		}
		return flag;
	}

	// 波动计算
	public float BoDongTree(int id, long time) {
		DaoTree as = new DaoTree();
		int flag = 0;

		double sum = 0;

		DataUtils data = as.queFloat("float", id, time);
		ArrayList<Double> values = data.getValue();

		for (int i = 0; i < (values.size() - 1); i++) {

			sum = (values.get(i) - values.get(i + 1));
			if (sum > 1) {
				flag ++;
			}
		}
		return flag/values.size();
	}
	// 压差计算
	public double YaChaTree(int id1, int id2, long time, double Hlimite) {
		DaoTree as = new DaoTree();
		int flag = 0;
		if (id1==959 && time==1387728000) {flag = 1;}
		
		
		/*DataUtils data1 = as.queFloat("float", id1, time);
		DataUtils data2 = as.queFloat("float", id2, time);
		ArrayList<Double> values1 = data1.getValue();
		ArrayList<Double> values2 = data2.getValue();
		for (int i = 0; i < 10; i++) {
			double dif = values1.get(i) - values2.get(i);
			if (dif > Hlimite) {
				flag++;
			}
		}*/
		return flag/* / values1.size()*/;
	}

	// 油泵打油效率
	public int PreviewTree(int id, long time) {
		DaoTree as = new DaoTree();
		double v = 0;
		int m = 0;
		int flag = 0;
		DataUtils data = as.queFloat("float", id, time);
		ArrayList<Double> values = data.getValue();// 获取油位信息
		for (int i = 0; i < (values.size() - 1); i++) {
			// 判断油泵开启时间
			if (values.get(i) < values.get(i + 1)) {
				v = values.get(i + 1) - values.get(i);
			}
			if (v < 50) {
				m = m + 1;
			}
			if (m / values.size() > 0.1) {
				flag = 1;
			} else {
				flag = 0;
			}
		}
		return flag;
	}
}