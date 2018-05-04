package bll.predict.svm;

import libsvm.*;
import java.io.*;
import java.util.*;

/**
 * 该类用于对历史样本进行拟合预测，vy作为原始预测输出进行对比
 * 
 * @author dragon
 * 
 */
public class SvmPredict {
	private static int atoi(String s) {
		return Integer.parseInt(s);
	}

	private static Vector<Double> predict(svm_model model,
			Vector<svm_node[]> vx, Vector<Double> vy, int predict_probability)
			throws IOException {
		Vector<Double> predictOutput = new Vector<Double>();

		int correct = 0;
		int total = 0;
		double error = 0;
		double sumv = 0, sumy = 0, sumvv = 0, sumyy = 0, sumvy = 0;

		int svm_type = svm.svm_get_svm_type(model);
		int nr_class = svm.svm_get_nr_class(model);
		double[] prob_estimates = null;

		if (predict_probability == 1) {
			if (svm_type == svm_parameter.EPSILON_SVR
					|| svm_type == svm_parameter.NU_SVR) {
				System.out
						.print("Prob. model for test data: target value = predicted value + z,\nz: Laplace distribution e^(-|z|/sigma)/(2sigma),sigma="
								+ svm.svm_get_svr_probability(model) + "\n");
			} else {
				int[] labels = new int[nr_class];
				svm.svm_get_labels(model, labels);
				prob_estimates = new double[nr_class];
			}
		}

		for (int i = 0; i < vx.size(); i++) {
			svm_node[] x = vx.get(i);
			double target = vy.get(i);
			double v;
			if (predict_probability == 1
					&& (svm_type == svm_parameter.C_SVC || svm_type == svm_parameter.NU_SVC))
				v = svm.svm_predict_probability(model, x, prob_estimates);
			else
				v = svm.svm_predict(model, x);
			predictOutput.add(v);
			/**
			 * 做二次开发，这里可动手脚，你可以输入要具体预测对的类在这里显示出来等等
			 */
			if (v == target) // 如果预测正确，那么分类的正确就加一
				++correct;
			error += (v - target) * (v - target);
			sumv += v;
			sumy += target;
			sumvv += v * v;
			sumyy += target * target;
			sumvy += v * target;
			++total;
		}

		if (svm_type == svm_parameter.EPSILON_SVR
				|| svm_type == svm_parameter.NU_SVR) {
			System.out.print("Mean squared error = " + error / total
					+ " (regression)\n");
			System.out.print("Squared correlation coefficient = "
					+ ((total * sumvy - sumv * sumy) * (total * sumvy - sumv
							* sumy))
					/ ((total * sumvv - sumv * sumv) * (total * sumyy - sumy
							* sumy)) + " (regression)\n");
		} else
			System.out.print("Accuracy = " + (double) correct / total * 100
					+ "% (" + correct + "/" + total + ") (classification)\n");
		return predictOutput;
	}

	private static void exit_with_help() {
		System.err
				.print("usage: svm_predict [options] test_file model_file output_file\n"
						+ "options:\n"
						+ "-b probability_estimates: whether to predict probability estimates, 0 or 1 (default 0); one-class SVM not supported yet\n");
		System.exit(1);
	}

	public static Vector<Double> main(svm_model model, Vector<svm_node[]> vx,
			Vector<Double> vy, String argv[]) throws IOException {
		int i, predict_probability = 0;
		Vector<Double> predictOutput = new Vector<Double>();
		// parse options
		for (i = 0; i < argv.length; i++) {
			if (argv[i].charAt(0) != '-')
				break;
			++i;
			switch (argv[i - 1].charAt(1)) {
			case 'b':
				predict_probability = atoi(argv[i]);
				break;
			default:
				System.err.print("Unknown option: " + argv[i - 1] + "\n");
				exit_with_help();
			}
		}

		try {
			if (predict_probability == 1) {
				if (svm.svm_check_probability_model(model) == 0) {
					System.err
							.print("Model does not support probabiliy estimates\n");
					System.exit(1);
				}
			} else {
				if (svm.svm_check_probability_model(model) != 0) {
					System.out
							.print("Model supports probability estimates, but disabled in prediction.\n");
				}
			}
			predictOutput = predict(model, vx, vy, predict_probability);
		} catch (FileNotFoundException e) {
			exit_with_help();
		} catch (ArrayIndexOutOfBoundsException e) {
			exit_with_help();
		}
		return predictOutput;
	}
}
