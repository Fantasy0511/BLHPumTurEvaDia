package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.ObjDoubleConsumer;

import dao.assess.DaoAssessment;
import dao.impl.ReadData;
import util.DataInfo;
import util.DataUtils;

public class FloatAssessment {
	// float型数据专用方法
	public int FloatAssess(int id, long time, double Hlimite, double Llimite) {
		
		
		ReadData readDB = new ReadData();
		HashMap<String, DataInfo> maps = new HashMap<String, DataInfo>();
		try {
			maps= readDB.queInfo();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DaoAssessment as = new DaoAssessment();
		DataUtils data = as.queFloat("float", id, time);
		ArrayList<Double> value = data.getValue();
		DataInfo datainfo = maps.get(data.getType()+data.getId());
		double C2 = datainfo.getHLimite();//高报警
		double C1 = datainfo.getLLimite();//低报警
		if(C2==0&&C1==0) {
			return 100;
		}
		double interval = C2 - C1;// 区间大小
		double mid = (C2 + C1) / 2;// 区间中点
		double mean = 0;
		for (Double d : value) {
			System.out.println(d);
			mean += d;
		}
		mean = mean/value.size();
		double li = 0.0;
		if (mean > mid - 0.4 * interval && mean < mid + 0.4 * interval)
			li = 0.0;
		else if (mean <= mid - 0.4 * interval && mean >= C1)
			li = (mid - 0.4 * interval - mean)
					/ (mid - 0.4 * interval - C1);
		else if (mean >= mid + 0.4 * interval && mean <= C2)
			li = (mean - (mid + 0.4 * interval))
					/ (C2 - (mid + 0.4 * interval));
		else
			li = 1.0;
		
		System.out.println(li);
		
		return (int) (98 - 40 * li);

	}
}
