package bll;

public class AhpWeightComputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double judgeMatrix[][]={{1.0,1.0/3.0,2.0},{3.0,1.0,5.0},{1.0/2.0,1.0/5.0,1.0}};
		double[] w=new double[judgeMatrix.length];
		AhpWeightComput awc = new AhpWeightComput();
		w=awc.getAhpWeight(judgeMatrix);
		for(int i=0;i<w.length;i++){
			System.out.print(w[i]+"  ");
		}

	}

}
