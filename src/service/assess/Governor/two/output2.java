package service.assess.Governor.two;

import java.text.DecimalFormat;

//2号机组调速器系统输出总分
public class output2 {
	public GovAssResultTwo output2(long time) {
		DecimalFormat df=new DecimalFormat("#.0");
		/* 调速故障信号得分 */
		SignalSum2 s = new SignalSum2();
		double U1 = s.SignalSum2(time);
		// 调速油系统性能状态得分
		State2 a = new State2();
		double U2 = a.State2(time);
		// 历史和巡检状态
		histroy2 history = new histroy2();
		double U3 = history.histroy2(time);

		double U4 = 0.55 * U1 + 0.1 * U3 + 0.35 * U2;
		U1=Double.parseDouble(df.format(U1));
		U2=Double.parseDouble(df.format(U2));
		U3 =Double.parseDouble(df.format(U3));
		U4=Double.parseDouble(df.format(U4));
		GovAssResultTwo govAssResultFour=new GovAssResultTwo(U1, U2, U3, U4);
		return govAssResultFour;
	}
}
