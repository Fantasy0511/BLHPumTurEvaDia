package bll.predict.svm.copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import libsvm.svm_node;

/**
 * 预测时的归一化与反归一化。
 * 
 * @author dragon
 * 
 */
public class DataNormalize {
	public static double[][] cal_max_min_x(Vector<svm_node[]> vx) {
		int s = vx.elementAt(0).length;// 进行归一化并保留样本最大值最小值返回
		double[] maxs = new double[s];
		double[] mins = new double[s];

		for (int i = 0; i < s; i++) {
			maxs[i] = -Double.MAX_VALUE;
			mins[i] = Double.MAX_VALUE;
		}
		for (int k = 0; k < vx.size(); k++) {
			for (int i = 0; i < s; i++) {
				if (vx.elementAt(k)[i].value > maxs[i])
					maxs[i] = vx.elementAt(k)[i].value;
				if (vx.elementAt(k)[i].value < mins[i])
					mins[i] = vx.elementAt(k)[i].value;
			}
		}
		double[][] max_min = new double[2][s];
		max_min[0] = maxs;
		max_min[1] = mins;
		return max_min;
	}

	/**
	 * 对输入矩阵按照libsvm的数据格式进行归一化到[-1,1]
	 * 
	 * @param vx
	 * @param max_min
	 * @return
	 */
	public static Vector<svm_node[]> normalize_x(Vector<svm_node[]> vx,
			double[][] max_min) {
		Vector<svm_node[]> result = new Vector<svm_node[]>();
		double[] maxs = max_min[0];
		double[] mins = max_min[1];
		int s = vx.get(0).length;

		for (int i = 0; i < vx.size(); i++) {
			svm_node[] x = new svm_node[s];
			for (int j = 0; j < s; j++) {
				x[j] = new svm_node();
				x[j].index = j + 1;
				x[j].value = 2 * (vx.elementAt(i)[j].value - mins[j])
						/ (maxs[j] - mins[j]) - 1;
			}
			result.addElement(x);
		}
		return result;
	}

	/**
	 * 对输入矩阵按照libsvm的数据格式进行归一化到[-1,1]
	 * 
	 * @param vx
	 * @param max_min
	 * @return
	 */
	public static svm_node[] normalize_x_one(svm_node[] vx, double[][] max_min) {

		svm_node[] result = new svm_node[vx.length];
		double[] maxs = max_min[0];
		double[] mins = max_min[1];
		int s = vx.length;
		for (int i = 0; i < s; i++) {
			svm_node mid = new svm_node();
			mid.index = i + 1;
			if (maxs[i] > mins[i])
				mid.value = 2 * (vx[i].value - mins[i]) / (maxs[i] - mins[i])
						- 1;
			else
				mid.value = maxs[i];
			result[i] = mid;
		}
		return result;
	}

	/**
	 * 进行归一化并保留样本最大值最小值返回
	 * 
	 * @param vy
	 * @return
	 */
	public static double[] cal_max_min_y(Vector<Double> vy) {
		double max = -Double.MAX_VALUE;
		double min = Double.MAX_VALUE;

		for (int k = 0; k < vy.size(); k++) {
			if (vy.get(k) > max)
				max = vy.get(k);
			if (vy.get(k) < min)
				min = vy.get(k);
		}
		double[] max_min = new double[] { max, min };
		return max_min;
	}

	/**
	 * 归一化到[-1,1]区间内
	 * 
	 * @param vy
	 * @param max_min
	 * @return
	 */
	public static Vector<Double> normalize_y(Vector<Double> vy, double[] max_min) {
		Vector<Double> result = new Vector<Double>();
		double max = max_min[0];
		double min = max_min[1];
		for (int k = 0; k < vy.size(); k++)
			if (max > min)
				result.addElement(2 * (vy.get(k) - min) / (max - min) - 1);
			else
				result.addElement(max);
		return result;
	}

	/**
	 * 从[-1,1]区间进行反归一化还原
	 * 
	 * @param out
	 * @param max_min
	 * @return
	 */
	public static Vector<Double> inverse_normalize_y(Vector<Double> out,
			double[] max_min) {
		Vector<Double> result = new Vector<Double>();
		double max = max_min[0];
		double min = max_min[1];
		for (int k = 0; k < out.size(); k++)
			if (max > min)
				result.addElement((out.get(k) + 1) * (max - min) / 2 + min);
			else
				result.addElement(max);
		return result;
	}

	public static List<Double> inverse_normalize_y_list(List<Double> out,
			double[] max_min) {
		List<Double> result = new ArrayList<Double>();
		double max = max_min[0];
		double min = max_min[1];
		for (int k = 0; k < out.size(); k++) {
			if (max > min) {
				result.add((out.get(k) + 1) * (max - min) / 2 + min);
			} else {
				result.add(max);
			}
		}
		return result;
	}

}
