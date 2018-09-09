package algorithms.DNN;

import java.util.Arrays;

public class LogRegression {
	private float[] w;
	public static void main(String[] args) {
		
		LogRegression lr = new LogRegression();
		float[][] datas = new float[][]{{1,1},{5,6},{1,1}};
		float[] labels = new float[]{1,0,1};
		lr.train(datas,labels, 0.1f, 2000, (short)1);
		System.out.println(lr.pred(datas[0]));
	}
	
	public float pred(float[] data){
		float rs = this.innerProduct(w,data);
		return this.sigmoid(rs);
	}
	
	
	public void train(float[][] datas,float[] labels, float step, int maxIt, short algorithm) {
		
		int size = datas.length;
		int dim = datas[0].length;
		w = new float[dim];
		
		for(int i = 0; i < dim; i++) {
			w[i] = (float) 0.001;
		}
		
		switch(algorithm){
		//批量梯度下降
		case 1: 
			for(int i = 0; i < maxIt; i++) {
				//求输出
				float[] out = new float[size];
				for(int s = 0; s < size; s++) {
					float lire = innerProduct(w, datas[s]);
					out[s] = sigmoid(lire);
				}
				for(int d = 0; d < dim; d++) {
					float sum = 0;
					for(int s = 0; s < size; s++) {
						sum  += (labels[s] - out[s]) * datas[s][d];
					}
					w[d] = w[d] + step * sum;
				}
				if(i%200==0){
					System.out.println("第"+i+"次迭代后误差为"+loss(datas,labels));
				}
				
			}
			break;
		//随机梯度下降
		case 2: 
			for(int i = 0; i < maxIt; i++) {
				for(int s = 0; s < size; s++) {
					float lire = innerProduct(w, datas[s]);
					float out = sigmoid(lire);
					float error = labels[s] - out;
					for(int d = 0; d < dim; d++) {
						w[d] += step * error * datas[s][d];
					}
				}
				System.out.println(Arrays.toString(w));
			}
			break;
		}
	}
	
	private float innerProduct(float[] w, float[] x) {
		
		float sum = 0;
		for(int i = 0; i < w.length; i++) {
			sum += w[i] * x[i];
		}
		
		return sum;
	}
	
	private float sigmoid(float src) {
		return (float) (1.0 / (1 + Math.exp(-src)));
	}
	
	private float loss(float[][] datas,float[] labels){
		float ls=0;
		int size=datas.length;
		for(int i=0;i<size;i++){
			float predy = pred(datas[i]);
			ls += -labels[i]*Math.log(predy)-(1-labels[i])*Math.log(1-predy);
		}
		return ls/size;
	}
}
