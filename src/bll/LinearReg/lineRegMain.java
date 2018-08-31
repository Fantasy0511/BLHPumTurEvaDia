package bll.LinearReg;

import java.text.DecimalFormat;
import java.util.Vector;

/**
 * 一元线性回归
 * @author tiandiwei
 *
 */
public class lineRegMain {

	public dataLine calculatedSum(dataLine dLine) {

		/* x的和；y的和；x的平方和；xy的和；y的平方和 */
		double sumX = 0, sumY = 0, sumXX = 0, sumXY = 0, sumYY = 0;

		Vector<Double> x = dLine.getX();
		Vector<Double> y = dLine.getY();

		int pn = x.size();

		for (int i = 0; i < x.size(); i++) {
			sumX += x.get(i);
			sumY += y.get(i);
			sumXX += Math.pow(x.get(i), 2);
			sumXY += x.get(i) * y.get(i);
			sumYY += Math.pow(y.get(i), 2);
		}
		
		System.out.println("输出pn个数:"+pn);
		System.out.println("输出x的和：" + sumX);
		System.out.println("输出y的和：" + sumY);
		System.out.println("输出xx的和："+sumXX);
		System.out.println("输出xy的和："+sumXY);
		System.out.println("输出yy的和："+sumYY);
		
		double Sxx = sumXX - Math.pow(sumX, 2) / pn;
		double Sxy = sumYY - Math.pow(sumY, 2) / pn;
		double Syy = sumXY - sumX * sumY / pn;

		System.out.println("输出sxx："+Sxx);
		System.out.println("输出sxy:"+Sxy);
		System.out.println("输出syy:"+Syy);
		
		/*x;y的平均值*/
		double averageX = sumX / pn;
		double averageY = sumY / pn;

		/* 系数a,b */
		double b = Sxy / Sxx;
		double a = averageY - b * averageX;
		System.out.println("a的值："+a);
		/* 误差 */
		double sse = Sxx / (Math.sqrt(Sxx * Syy));

		RegressionBean aBean=new RegressionBean(sse, a, b);
		Vector<Double> aVector=new Vector<>();
		DecimalFormat df = new DecimalFormat("#.000"); // 控制小数点位数
		
		//输出结果保留小数点后三位
		for (int i = 0; i < x.size(); i++) {
			System.out.println("输出x的值： "+x.get(i));
			/*aVector.add(Double.parseDouble(df.format(aBean.getA()+aBean.getB()*x.get(i))));*/
			aVector.add(Double.parseDouble(df.format(aBean.getA()+aBean.getB()*i)));
		}
		
		System.out.println("线性回归误差：  R^2 "+aBean.getSse());
		return new dataLine(x, aVector);

	}

	/*public static void main(String[] args) {
		lineRegMain lineRegMain = new lineRegMain();
		Vector<Double> x = new Vector<>();
		Vector<Double> y = new Vector<>();
		for (int i = 0; i < 5; i++) {
			x.add((double) i+6);
			System.out.println("x的值为："+x.get(i));
			
			y.add((double) i+20);
			System.out.println("y的值为："+y.get(i));
		}
		
		dataLine aDataLine = new dataLine(x, y);

		RegressionBean aBean = lineRegMain.calculatedSum(aDataLine);
		
		System.out.println("a的值为" + aBean.getA() + "  b的值：" + aBean.getB());

		System.out.println("y=" + aBean.getA() + "+" + aBean.getB() + "* x");

		System.out.println("误差为：" + aBean.getSse());
	}*/
}
