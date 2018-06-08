package service.assess.Governor.three;



//3号机组调速器系统输出总分
public class output3 {

	public double output3(long time) {
		/*调速故障信号得分*/
		SignalSum3 s=new SignalSum3();
		double U1 = s.SignalSum3(time);
		//调速油系统性能状态得分
		State3 a=new State3();
		double U2 = a.State3(time);
		//历史和巡检状态
				histroy3 history = new histroy3();
				double U3 = history.histroy3(time);
		
				double U4 = 0.55 * U1 + 0.1* U3 + 0.35 * U2 ;
		
		return U4;
		}
}
