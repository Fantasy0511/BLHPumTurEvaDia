package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * time相关计算的utils
 * 2017-09-28
 * @author 刘涵 
 * */
public class TimeUtils {

	
	/*
	 * 
	 * 类型间相互转换，共6种
	 * 
	 */
	/**
	 * String转long输出
	 * @param str 输入的string类型时间，形如"2015-08-31 21:08:06"
	 * @return 对应的长整型数据
	 * */
	public static long StringtoLong(String str){
		Date dt = StringtoDate(str);
		long timel =  DatetoLong(dt);  //得到秒数，Date类型的getTime()返回毫秒数
		return timel;
	}
	
	/**
	 * String转换date输出
	 * @param str 输入的string类型时间，形如"2015-08-31 21:08:06"
	 * @return
	 */
	public static Date StringtoDate(String str){ 
        Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			date = sdf.parse(str);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * date转long输出，输出最小单位为秒
	 * */
	public static long DatetoLong(Date date){
		long timel = date.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
		return timel;
	}
	
	/**
	 * date转string输出，形式为YYYY-MM-DD HH:MM:SS
	 * */
	public static String DatetoString(Date date){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String str = sdf.format(date);
        return str;
	}
	
	/**
	 * long转string输出，形式为YYYY-MM-DD HH:MM:SS
	 * @param timel 单位为s
	 * */
	public static String LongtoString(long timel){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(timel * 1000);  
		String str = sdf.format(date);  
		return str;
	}
	
	/**
	 * long转date输出
	 * */
	public static Date LongtoDate(long timel){
		Date date = new Date(timel * 1000);  
		return date;
	}

	
	/**
	 * 返回当前的时分秒string
	 * @return 当前时间"yyyy-MM-dd HH:mm:ss"
	 */
	public static String getNowTime() {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();  
		String str = sdf.format(date);  
		return str;
	}
	
	
	/*
	 * 
	 * 有关时间的计算
	 * 
	 */
	
	/**
	 * 在原始date上加number*单位，返回date
	 * */
	public static Date AddUnits(Date orignalDate,String unit,int number){
		Calendar   cal   =   Calendar.getInstance(); 
		cal.setTime(orignalDate);
		switch(unit){
			case "year":
				cal.add(Calendar.YEAR,   number);
				break;
			case "month":
				cal.add(Calendar.MONTH,   number);
				break;
			case "day":
				cal.add(Calendar.DATE,   number);
				break;
			case "hours":
				cal.add(Calendar.HOUR,   number);
				break;
			case "minute":
				cal.add(Calendar.MINUTE,   number);
				break;
			case "second":
				cal.add(Calendar.SECOND,   number);
				break;
			default:
				System.out.println("choose unit correctly!");
				return cal.getTime();
		}
		Date   newDate   =   cal.getTime();
		return newDate; 
	}
	
	
	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param begin 起始日期
	 * @param end 结束日期
	 * @return 天数
	 */
	public static int getTimeInteval(Date begin, Date end) {
		int betweenDays = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(begin);
		c2.setTime(end);
		if (c1.after(c2)) {
			c1 = c2;
			c2.setTime(begin);
		}
		int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		betweenDays = c2.get(Calendar.DAY_OF_YEAR)
				- c1.get(Calendar.DAY_OF_YEAR);
		for (int i = 0; i < betweenYears; i++) {
			c1.set(Calendar.YEAR, (c1.get(Calendar.DAY_OF_YEAR) + 1));
			betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);
		}
		return betweenDays;

	}


	
	
	




	
	public static void main(String[] args){
		String test = "2012-05-30 01:00:03";
        String startMounth = test.substring(0,4);
        System.out.println(startMounth);

	}

	


}
