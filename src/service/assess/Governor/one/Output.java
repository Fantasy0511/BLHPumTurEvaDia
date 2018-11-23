package service.assess.Governor.one;

import java.text.DecimalFormat;
import java.util.List;

public class Output {
	public GovAssResult getGovAssessResult(long time) {
		//控制小数点
		DecimalFormat df=new DecimalFormat("#.0");

		//调速系统性能状态
		
		List<Number> U1 = GovState.calAllScore(time);
		
		//调速故障信号
		List<Number> U2 = GovFaultSignal.calAllScore(time);
        
		//历史性能
		History history = new History();
		double U3 = history.getHistory(time);
		
		//综合得分     
		double score =Double.valueOf(String.valueOf(U1.get(U1.size()-1)))*0.6+
				Double.valueOf(String.valueOf(U2.get(U2.size()-1)))*0.4;
		
		// 控制小数点位数
		U3 =Double.parseDouble(df.format(U3));
		
		score=Double.parseDouble(df.format(score));
		
		GovAssResult govAssResult = new GovAssResult(U1, U2, U3, score);
		return govAssResult;
	}

	public static void main(String[] args) {
		Output a = new Output();
		System.out.println(a.getGovAssessResult(1441400000));
	}
	
}
