package service.assess.Governor.three;

import java.text.DecimalFormat;
import java.util.List;

//3号机组调速器系统输出总分
public class output3 {

	public GovAssResultThree getOutput3(long time) {
		
		DecimalFormat df=new DecimalFormat("#.0");
		
		/* 调速故障信号得分 */
		SignalSum3 s = new SignalSum3();
		List<Number> U1 = s.getSignalSum3(time);
		
		// 调速油系统性能状态得分
		State3 a = new State3();
		List<Number> U2 = a.getState3(time);
		
		// 历史和巡检状态
		histroy3 history = new histroy3();
		double U3 = history.histroy3(time);

		double U4 = 0.55 * (double) U1.get(U1.size() - 1) 
				+ 0.1 * U3 
				+ 0.35 * (double) U2.get(U2.size() - 1);
		
		/*U1=Double.parseDouble(df.format(U1));
		U2=Double.parseDouble(df.format(U2));*/
		U3 =Double.parseDouble(df.format(U3));
		U4=Double.parseDouble(df.format(U4));
		
		GovAssResultThree govAssResultThree=new GovAssResultThree(U1, U2, U3, U4);
		
		return govAssResultThree;
	}
}
