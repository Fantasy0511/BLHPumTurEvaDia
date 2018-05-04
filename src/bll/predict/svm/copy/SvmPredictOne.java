package bll.predict.svm.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_parameter;

/**
 * 该类用于对下时刻值进行预测，不存在预测结果对比值
 * 
 * @author dragon
 * 
 */
public class SvmPredictOne {
	private static int atoi(String s) {
		return Integer.parseInt(s);
	}

	private static Vector<Double> predict(svm_model model,
			Vector<svm_node[]> vx, int predict_probability) throws IOException {
		Vector<Double> predictOutput = new Vector<Double>();

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
			double v;
			if (predict_probability == 1
					&& (svm_type == svm_parameter.C_SVC || svm_type == svm_parameter.NU_SVC)) {
				v = svm.svm_predict_probability(model, x, prob_estimates);
			} else {
				v = svm.svm_predict(model, x);
			}
			predictOutput.add(v);
		}
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
			String argv[]) throws IOException {
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
			predictOutput = predict(model, vx, predict_probability);
		} catch (FileNotFoundException e) {
			exit_with_help();
		} catch (ArrayIndexOutOfBoundsException e) {
			exit_with_help();
		}
		return predictOutput;
	}
}
