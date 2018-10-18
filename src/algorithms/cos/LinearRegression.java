package algorithms.cos;

import java.util.Date;
import java.util.Vector;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.fasterxml.jackson.core.sym.Name;

import bll.LinearReg.dataLine;
import util.DataInfo;
import util.DataUtils;
import util.TimeUtils;
import dao.impl.ReadData;

public class LinearRegression {
	
	private double k;
	private double b;
	public String alter;
	private int size;
	ArrayList<Long> x;
	ArrayList<Double> y;
	public static void main(String[] args) {
		LinearRegression lRegression = new LinearRegression("float", 1097, "2014-07-25 00:00:00", "2014-07-26 00:00:00");
		
		dataLine dl = lRegression.fit();
		System.out.println(lRegression.alter);
	}
	
	public dataLine fit() {
		Vector<Double> inputx = new Vector<Double>();
		long start = x.get(0);
		DecimalFormat df = new DecimalFormat("#.0000");
		Vector<Double> fity = new Vector<Double>();
		for(int i=0;i<x.size();i++){
			inputx.addElement((double)x.get(i));
			fity.addElement(Double.parseDouble(df.format((k*(double)(x.get(i)-start)+b))));
		}
		return new dataLine(inputx,fity);
	}
	
	public LinearRegression(String table,int id,String starttime,String endtime) {
		ReadData rd = new ReadData();
		try {
			DataUtils data = rd.queRecord(table, id, starttime, endtime);
			x = data.getTime();
			y = data.getValue();
			size=x.size();
			System.out.println("size的值："+size);
			long start = x.get(0);
			double Exy=0,Ex=0,Ey=0,Exx=0;
			for(int i=0;i<size;i++){
				Exy += (x.get(i)-start)*y.get(i);
				Ex += (x.get(i)-start);
				Ey += y.get(i);
				Exx += (x.get(i)-start)*(x.get(i)-start);
			} 
			k=(size*Exy-Ex*Ey)/(size*Exx-Ex*Ex);
			System.out.println("預測k為："+k);
			b=(Exx*Ey-Ex*Exy)/(size*Exx-Ex*Ex);
			DataInfo info = rd.queInfo(table+id);
			double h = info.getHHLimite()==0?info.getHLimite():info.getHHLimite();
			double l = info.getLLimite()==0?info.getLLLimite():info.getLLimite();
			String name = info.getPosition()+"."+info.getDescription();
			if(h>0){
				name += " 阈值上限为"+h+info.getUnit();
			}
			if(l>0){
				name += " 阈值下限为"+h+info.getUnit();
			}
			if(k==0){
				alter =  name+" 近期运行稳定。";
			}
			else{
				//往后延1个月
				Date excepteDate=TimeUtils.AddUnits(TimeUtils.LongtoDate(x.get(x.size()-1)), "month", 3);

				if(k>0 && h>0){//超过上限
					double inputx = TimeUtils.DatetoLong(excepteDate)-start;
					double predy = inputx*k+b;
					if(predy>h){
						alter = name+" 将在"+TimeUtils.LongtoString((long)((h-b)/k+start))+"达到参数阈值上限，请注意检修！";
					}
					else{
						alter = name+" 近期运行正常。";
					}
				}
				else if(k<0 && l>0){//超过上限
					double inputx = TimeUtils.DatetoLong(excepteDate)-start;
					double predy = inputx*k+b;
					if(predy<l){
						alter = name+" 将在"+TimeUtils.LongtoString((long)((l-b)/k+start))+"达到参数阈值下限，请注意检修！";
					}
					else{
						alter = name+" 近期运行正常。";
					}
				}
				else{
					alter = name+" 近期运行正常。";
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//alter = "该参数处于正常范围内。";
	}

}
