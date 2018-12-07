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
		LinearRegression lRegression = new LinearRegression(1,"float", 1097, "2014-07-25 00:00:00", "2014-07-26 00:00:00");
		
		dataLine dl = lRegression.fit(2);
		System.out.println(lRegression.alter);
	}
	
	public dataLine fit(int step) {
		Vector<Double> inputx = new Vector<Double>();
		long start = x.get(0);
		DecimalFormat df = new DecimalFormat("#.0000");
		Vector<Double> fity = new Vector<Double>();
		double interval = 0;//求取每个的间隔均值，再往后推预测步长
		double current_x = 0; //保存接下来遍历时候最后一个x的值
		for(int i=0;i<x.size();i++){
			current_x = (double)x.get(i);
			if(i!=x.size()-1) interval += (double)(x.get(i+1)-current_x);
			inputx.addElement(current_x);
			fity.addElement(Double.parseDouble(df.format((k*(double)(current_x-start)+b))));
		}
		interval = Math.ceil(interval/(x.size()-1));
		for(int s=0;s<step;s++){
			current_x = current_x+interval;
			inputx.addElement(current_x);
			fity.addElement(Double.parseDouble(df.format((k*(double)(current_x-start)+b))));
		}
		return new dataLine(inputx,fity);
	}
	
	public LinearRegression(int unitNo,String table,int id,String starttime,String endtime) {
		//1号机组 有功功率  float9 2号机组 有功功率  float24 3号机组 有功功率  float39 4号机组 有功功率  float54
		int[] ids = new int[]{9,24,39,54};
		ReadData rd = new ReadData();
		try {
			/*
			DataUtils powerData = rd.queRecord("float", ids[unitNo-1], starttime, endtime);
			for(int i=0;i<powerData.getValue().size();i++){
				if(powerData.getValue().get(i)<0){
					alter = "机组当前运行工况为抽水工况。";
					break;
				}
				if(powerData.getValue().get(i)>0){
					alter = "机组当前运行工况为发电工况。";
					break;
				}
			}
			if(alter.length()<1){
				alter = "机组当前运行工况为停机工况。";
			}
			*/
			alter="";//不要工况判断了
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
			double h = info.getHLimite();
			double l = info.getLLimite();
			String name = info.getPosition()+"."+info.getDescription();
			if(h!=0){
				name += " 阈值上限为"+h+info.getUnit();
			}
			if(l!=0){
				name += " 阈值下限为"+l+info.getUnit();
			}
			if(k==0){
				alter +=  name+" 近期运行稳定。";
			}
			else{
				//往后延1个月
				Date excepteDate=TimeUtils.AddUnits(TimeUtils.LongtoDate(x.get(x.size()-1)), "month", 3);

				if(k>0 && h>0){//超过上限
					double inputx = TimeUtils.DatetoLong(excepteDate)-start;
					double predy = inputx*k+b;
					if(predy>h){
						alter += name+" 将在"+TimeUtils.LongtoString((long)((h-b)/k+start))+"达到参数阈值上限，请注意检修！";
					}
					else{
						alter += name+" 近期运行正常。";
					}
				}
				else if(k<0 && l>0){//超过上限
					double inputx = TimeUtils.DatetoLong(excepteDate)-start;
					double predy = inputx*k+b;
					if(predy<l){
						alter += name+" 将在"+TimeUtils.LongtoString((long)((l-b)/k+start))+"达到参数阈值下限，请注意检修！";
					}
					else{
						alter += name+" 近期运行正常。";
					}
				}
				else{
					alter += name+" 近期运行正常。";
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
