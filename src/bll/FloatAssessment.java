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
		
		int full_marks = 100;//满分，从100开始扣分
		ReadData readDB = new ReadData();
		DataInfo datainfo = null;
		try {
			datainfo = readDB.queInfo("float"+id);
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
		if(value.size()==0){
			return full_marks;
		}
		double C2 = datainfo.getHLimite();//高报警
		double C1 = datainfo.getLLimite();//低报警
		if(C2==0&&C1==0) {
			return full_marks;
		}
		double mean = 0;
		for (Double d : value) {
			if((C2!=0&&d>C2)||(C1!=0&&d<C1)){
				full_marks -= 10;//有一次越限就减10分
			}
			mean += d;
		}
		mean = mean/value.size();

		if(C1==0){//不设下限
			System.out.println("参数上限为"+C2);
			System.out.println("参数平均值为"+mean);
			if(mean>=C2) return 0;
			return (int) (mean<=C2*0.8?full_marks:(1-(mean-C2*0.8)/0.2/C2)*full_marks);
		}
		if(C2==0){//不设上限
			if(mean<=C1) return 0;
			System.out.println("参数下限为"+C2);
			System.out.println("参数平均值为"+mean);
			return (int) (mean>=C1*1.2?full_marks:(1-(C1*1.2-mean)/0.2/C1)*full_marks);
		}
		
		//同时有上下限
		double interval = C2 - C1;// 区间大小
		double mid = (C2 + C1) / 2;// 区间中点
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
		System.out.println("参数下限为"+C2);
		System.out.println("参数上限为"+C1);
		System.out.println("参数平均值为"+mean);
		return (int) (full_marks - 40 * li);

	}
}
