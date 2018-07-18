package service.assess.generator.two;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class electricity2 {

	//2号机组励磁故障信号总得分

		public List<Number> getElectricity2(long time){
			
			List<Number> eList = new ArrayList<>();
			DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
			//励磁电源故障 
			BoolAssess bool1608=new BoolAssess();
			int U1=bool1608.BooleanAssess(1608,time);
			
		//电压/频率跳闸
			BoolAssess bool606=new BoolAssess();
			int U2=bool606.BooleanAssess(606,time);
		//	晶闸管桥风扇故障
			BoolAssess bool602=new BoolAssess();
			int U3=bool602.BooleanAssess(602,time);
			double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));
			eList.add(U1);
			eList.add(U2);
			eList.add(U3);
			eList.add(a);
			return eList;
	}
}
