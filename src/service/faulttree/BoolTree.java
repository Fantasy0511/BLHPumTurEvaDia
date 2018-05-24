package service.faulttree;

import java.util.ArrayList;
import bll.diagnosis.tree.dao.DaoTree;
import util.DataUtils;

public class BoolTree {


	
	// bool型专用方法
	public double BooleanTree(int id, long time) {
		DaoTree as = new DaoTree();
		DataUtils data = as.queBool("bool", id, time);
		ArrayList<Double> value = data.getValue();
		
		int x = 0;
		int y = 0;
		double p=0;

		for (Double h : value) {
			if (h == 1.0) {
				x++;
			}
			if (h == 0) {
				y++;
			}
			
		}
		if(x==0&&y==0)
		{p=0;
		}else{
			p = (double)x/(x+y);
			}
		
		return  p;
	}
	// bool型专用方法
		public int BooleanTreeDay(int id, long time) {
			DaoTree asday = new DaoTree();
			DataUtils data1 = asday.queBoolDay("bool", id, time);
			ArrayList<Double> value = data1.getValue();
			
			int flag = 0;
			
			for (Double h : value) {
				if (h == 1.0) {
					flag = 1;
				}
			}
			
			return  flag;
		}
}

