package service.assess.Governor.four;

import java.text.DecimalFormat;

//4号机组调速器系统输出总分
public class output4 {

	public GovAssResultfour output4(long time) {
		
		DecimalFormat df=new DecimalFormat("#.0");
		/* 调速故障信号得分 */
		SignalSum4 s = new SignalSum4();
		double U1 = s.SignalSum4(time);
		// 调速油系统性能状态得分
		State4 a = new State4();
		double U2 = a.State4(time);
		// 历史和巡检状态
		histroy4 history = new histroy4();
		double U3 = history.histroy4(time);
		double U4 = 0.55 * U1 + 0.1 * U3 + 0.35 * U2;
		U1=Double.parseDouble(df.format(U1));
		U2=Double.parseDouble(df.format(U2));
		U3 =Double.parseDouble(df.format(U3));
		U4=Double.parseDouble(df.format(U4));
		GovAssResultfour govAssResultfour=new GovAssResultfour(U1, U2, U3, U4);
		return govAssResultfour;
	}
}
