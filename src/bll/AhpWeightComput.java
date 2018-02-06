package bll;
/**
 * 依据层次分析法计算调速系统评估体系各指标、项目的权重值
 */
public class AhpWeightComput {
	
	//计算各指标权重
	public double[] getAhpWeight(double[][] judgeMatrix){
//		double[] ahpweight = new double[judgeMatrix.length];
		double w[]= new double[judgeMatrix.length];// 判断矩阵的近似特征向量
		double aw[]=new double[judgeMatrix.length];
		double sum = 0.0;
		double eigvalmax=0.0;//特征向量w对应的最大特征值
		double ci=0.0;
		double cr=0.0;
		for(int i=0;i<judgeMatrix.length;i++){
			w[i]=judgeMatrix[i][0];
			for(int j=1;j<judgeMatrix[i].length;j++){
				w[i]=w[i]*judgeMatrix[i][j];
			}
			w[i]=Math.pow(w[i],1.0/3.0);
		}
		// 归一化处理
		for(int k=0;k<judgeMatrix.length;k++){
			sum+=w[k];
		}
		for(int k=0;k<judgeMatrix.length;k++){
			w[k]=w[k]/sum;
		}
		
		//求特征向量w对应的最大特征值
		for(int i=0;i<judgeMatrix.length;i++){
			for(int j=0;j<judgeMatrix[i].length;j++){
				aw[i]+=judgeMatrix[i][j]*w[j];
			}
			aw[i]=aw[i]/(judgeMatrix.length*w[i]);
			eigvalmax+=aw[i];
		}
		
		//判断矩阵一致性检验，ci与cr指标均小于0.1时，一致性可接受；
		ci=(eigvalmax-judgeMatrix.length)/(judgeMatrix.length-1);
		int x=judgeMatrix.length;//判断矩阵的行数
		switch(x){
		case 2:
			ci=0.05;
			cr=0.05;
			break;
		case 3:
			cr=ci/0.58;
			break;
		case 4:
			cr=ci/0.98;
			break;
		case 5:
			cr=ci/1.12;
			break;
		case 6:
			cr=ci/1.26;
			break;
		case 7:
			cr=ci/1.36;
			break;
		case 8:
			cr=ci/1.41;
			break;
		case 9:
			cr=ci/1.46;
			break;
		case 10:
			cr=ci/1.49;
			break;
		}
		if(ci<0.1 && cr<0.1){
		System.out.println("判断矩阵符合一致性检验！");
		}
		else{
			System.out.println("判断矩阵一致性检验不合格，请重新给定！");
		}
		return w;
	}

}
