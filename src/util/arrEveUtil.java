package util;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入维度为n的数组，将数组前n维相加求和，算得均值
 * 输出n维数组
 * @author tiandiwei
 *
 */
public class arrEveUtil {
	
	public List<Double> list2arrayNumber(List<Double> aList) {
		
		List<Double> aDoubles= new ArrayList<>();
		double sum=sumArray(aList);
		for (int i=0;i<aList.size();i++) {
			aDoubles.add(Double.valueOf(aList.get(i).toString())/sum);
		}
		return aDoubles;
	}
	
	public Double sumArray(List<Double> aList) {
		double sum=0.0;
		for (int i=0;i<aList.size();i++) {
			sum= sum + Double.valueOf(aList.get(i).toString());
		}
		return  sum;
	}

}
