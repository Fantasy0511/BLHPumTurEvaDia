package bll.predict;

import java.util.Vector;

import bll.predict.svm.DataNormalize;
import libsvm.svm_node;

/**
 * 该类用于传递SVM预测时的所有参数
 * 
 * @author dragon 若样本数较少，要将嵌入维数len改小点，如3或4
 */
public class PredictTransfer {
	private int len = 10; // 嵌入维数，默认设为8，由8个预测下一个

	private double[][] max_min_x;
	private double[] max_min_y;
	private Vector<svm_node[]> normalized_vx; // 归一化初始输入[-1,1]
	private Vector<Double> normalized_vy; // 归一化初始输出矩阵[-1,1]

	private Vector<String> vtime;
	private Vector<Double> vy;
	private Vector<Double> originalY;

	public PredictTransfer(PredictInput input) {
		this.vtime = new Vector<>();
		this.originalY = new Vector<>();
		normalize(input);
	}

	private void normalize(PredictInput input) {
		double[] datas = input.getData();
		int N = datas.length - len;// 可供训练的样本个数
		Vector<svm_node[]> vx = new Vector<svm_node[]>();
		Vector<Double> vy = new Vector<Double>();
		for (int i = 0; i < N; i++) {
			svm_node[] x = new svm_node[len];
			for (int j = 0; j < len; j++) {
				x[j] = new svm_node();
				x[j].index = j + 1;
				x[j].value = Double.valueOf(datas[i + j]);
			}
			vx.addElement(x);
			this.vtime.add(input.getTime()[len + i]);
			this.originalY.add(input.getData()[len + i]);
			vy.addElement(Double.valueOf(datas[len + i]));
		}
		this.vy = vy;
		this.max_min_x = DataNormalize.cal_max_min_x(vx);
		this.max_min_y = DataNormalize.cal_max_min_y(vy);
		this.normalized_vx = DataNormalize.normalize_x(vx, max_min_x);
		this.normalized_vy = DataNormalize.normalize_y(vy, max_min_y);
	}

	public String[] getVTime() {
		String[] result = new String[vtime.size()];
		for (int i = 0; i < vtime.size(); ++i) {
			result[i] = vtime.get(i);
		}
		return result;
	}

	public Vector<Double> getVy() {
		return vy;
	}

	public Vector<Double> getOriginalY() {
		return originalY;
	}

	public int getLen() {
		return len;
	}

	public double[][] getMax_min_x() {
		return max_min_x;
	}

	public double[] getMax_min_y() {
		return max_min_y;
	}

	public Vector<svm_node[]> getNormalized_vx() {
		return normalized_vx;
	}

	public Vector<Double> getNormalized_vy() {
		return normalized_vy;
	}

	public void setNormalized_vy(Vector<Double> normalized_vy) {
		this.normalized_vy = normalized_vy;
	}

}
