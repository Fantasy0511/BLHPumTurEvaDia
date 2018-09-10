package algorithms.cos;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DataInfo;
import util.DataUtils;
import util.TimeUtils;
import dao.impl.ReadData;

public class LinearRegression {
	public static void main(String[] args) {
		System.out.println(LinearRegression.lr("float", 1329, "2015-01-01 00:00:00", "2015-01-02 00:00:00"));
		
	}
	public static String lr(String table,int id,String starttime,String endtime) {
		ReadData rd = new ReadData();
		try {
			DataUtils data = rd.queRecord(table, id, starttime, endtime);
			ArrayList<Long> x = data.getTime();
			ArrayList<Double> y = data.getValue();
			int n = x.size();
			long start = x.get(0);
			double Exy=0,Ex=0,Ey=0,Exx=0;
			for(int i=0;i<n;i++){
				Exy += (x.get(i)-start)*y.get(i);
				Ex += (x.get(i)-start);
				Ey += y.get(i);
				Exx += (x.get(i)-start)*(x.get(i)-start);
			}
			double k=(n*Exy-Ex*Ey)/(n*Exx-Ex*Ex);
			double b=(Exx*Ey-Ex*Exy)/(n*Exx-Ex*Ex);
			DataInfo info = rd.queInfo(table+id);
			String name = info.getPosition()+"."+info.getDescription();
			if(k==0){
				return name+" 近期运行稳定。";
			}
			else{
				//往后延1个月
				Date excepteDate=TimeUtils.AddUnits(TimeUtils.LongtoDate(x.get(x.size()-1)), "month", 3);
				double h = info.getHHLimite()==0?info.getHHLimite():info.getHLimite();
				double l = info.getLLimite()==0?info.getLLimite():info.getLLLimite();
				if(k>0 && h>0){//超过上限
					double inputx = TimeUtils.DatetoLong(excepteDate)-start;
					double predy = inputx*k+b;
					if(predy>h){
						return name+" 将在"+TimeUtils.LongtoString((long)((h-b)/k+start))+"达到参数阈值上限，请注意检修！";
					}
					else{
						return name+" 近期运行正常。";
					}
				}
				else if(k<0 && l>0){//超过上限
					double inputx = TimeUtils.DatetoLong(excepteDate)-start;
					double predy = inputx*k+b;
					if(predy<l){
						return name+" 将在"+TimeUtils.LongtoString((long)((l-b)/k+start))+"达到参数阈值下限，请注意检修！";
					}
					else{
						return name+" 近期运行正常。";
					}
				}
				else{
					return name+" 近期运行正常。";
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "该参数处于正常范围内。";
	}

}
