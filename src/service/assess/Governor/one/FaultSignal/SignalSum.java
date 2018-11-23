package service.assess.Governor.one.FaultSignal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//调速故障信号得分//真的不想改了、、、、、
public class SignalSum {
	/**
	 * U1 调速器故障次数 U2 油泵故障次数 U3 超速报警次数
	 */
	public List<Number> getSignalSum(long time) {
		
		DecimalFormat df=new DecimalFormat("#.0");
		
		List<Number> singleList = new ArrayList<>();
		
		//调速器电气过速报警
		/*GeneratorTrip GT = new GeneratorTrip();
		int U1 = GT.GeneratorTrip(time);*/
	
		//调速器机械过速报警
		OverspeedAlarm OA = new OverspeedAlarm();
		int U1 = (int) OA.OverspeedAlarm(time).get(0);
		int U2 = (int) OA.OverspeedAlarm(time).get(1);
		
		//调速器油箱阻塞
		OilTank OT = new OilTank();
		int U3 = OT.getOilTank(time);
		
		double score = 0.15 * U1 + 0.45 * U2 + 0.4 * U3;
		
		score=Double.parseDouble(df.format(score));
		
		singleList.add(U1);
		singleList.add(U2);
		singleList.add(U3);
		singleList.add(score);
		
		System.out.println("*********");
		System.out.println("振动信号底层指标得分");
		System.out.println("调速器故障次数："+U1);
		System.out.println("油泵故障次数："+U2);
		System.out.println("超速报警次数："+U3);
		System.out.println("综合得分："+score);
		System.out.println("************");
		
		
		return singleList;
	}

	public static void main(String[] args) {
		SignalSum a = new SignalSum();
		System.out.println(a.getSignalSum(1441400000));
	}

}
