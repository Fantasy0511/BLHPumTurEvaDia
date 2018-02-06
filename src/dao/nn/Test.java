package dao.nn;

import util.TimeUtils;  // 时间类型的相互转换方法

public class Test {
	public static void main(String[] args) {
		ReadyForNn readyForNn = new ReadyForNn();
		 System.out.println(readyForNn.getValues("主轴密封1#过滤器故障，无法自动停止"));
		 
      /*时间类型的转换*/
//		Long timel1 = 1387803098L;
//		Long timel2 = 1387803113L;
//		System.out.println(TimeUtils.LongtoString(timel1)+"-----"+TimeUtils.LongtoString(timel2));
//		
	}
}
