
package service.faulttree;

import java.util.ArrayList;

import bll.diagnosis.tree.dao.DaoTree;
import util.DataUtils;

public class FloatTreement {
	// float型数据专用方法
	public double FloatTree(int id, long time, double Hlimite, double Llimite) {

		DaoTree as = new DaoTree();

		DataUtils data = as.queFloat("float", id, time);
		ArrayList<Double> value = data.getValue();
		double p = 0;
		int x = 0;
		int y = 0;
		for (Double d : value) {
			System.out.println(d);
			double C2 = Hlimite;
			double C1 = Llimite;

			if (C2 < d || d < C1) {
				x++;
			} else {
				y++;
			}
		}
		if (x == 0 && y == 0) {
			p = 0;
		} else {
			p = (double) x / (x + y);
		}
		return p;
	}
}