package service.assess.transformer.one.frist;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.FloatAssessment;

public class temperature {
//主变压器温度
public List<Number> temperatureA(long time){
		
		List<Number> hList=new ArrayList<>();
		DecimalFormat df=new DecimalFormat("#.0");  //控制小数点位数
		FloatAssessment temper=new FloatAssessment();
		//主变油温
		int U1=temper.FloatAssess(1087,time, 150, 0);
		//主变压器.高压侧绕组
		int U2=temper.FloatAssess(1090,time, 150, 0);
		//冷却器出口水温
		int U3=temper.FloatAssess(1092,time, 80, 0);
		
		//主变温度总得分
		double a=Double.parseDouble(df.format((U1+U2+U3)/3));   
	
		hList.add(U1); 
		hList.add(U2);
		hList.add(U3);
		hList.add(a);
		
		return hList;
	}
}
