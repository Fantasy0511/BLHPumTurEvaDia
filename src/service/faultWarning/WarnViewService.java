package service.faultWarning;
/**
 * 故障预警结果图绘制业务层
 * @author tiandiwei
 *
 */

import java.util.ArrayList;
import java.util.List;

public class WarnViewService {
	List<PieChartData> pieDatas = new ArrayList<>();

	public List<PieChartData> getData(String typeid, String startTime,
			String endTime) {
/*
		System.out.println(typeid + " " + startTime + " " + endTime);
		PieChartData pieChartData = new PieChartData("故障1", 0.5);
		PieChartData pieChartData2 = new PieChartData("故障2", 0.2);
		PieChartData pieChartData3 = new PieChartData("故障3", 0.3);
		pieDatas.add(pieChartData);
		pieDatas.add(pieChartData2);
		pieDatas.add(pieChartData3);*/
		return pieDatas;
	}
}
