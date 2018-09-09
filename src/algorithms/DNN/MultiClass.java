package algorithms.DNN;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import blh.action.datamine.history.SystemConvert;
import service.FaultInfoService;
import util.DataUtils;
import util.FaultUtils;
import util.TimeUtils;


/**
 * 多分类任务调用
 * @author lh
 * */
public class MultiClass {
	MLP mlp = new MLP();
	double[][] inputdata;
	double[][] outputdata;
    int itrs=5000;
    double lr=0.8;
    double mom=0.3;
    /**
     * 初始化，默认只有三层
     * */
	public MultiClass(double[][] inputArray,double[][] desiredOutputArray){
		int[] layers = new int[]{0,1028,0};
		layers[0] = inputArray[0].length;
		layers[2] = desiredOutputArray[0].length;
		inputdata = inputArray;
		outputdata = desiredOutputArray;
		mlp.initNeuralNet(layers); 
	}
	/**
	 * 用默认参数训练数据
	 * */
	public void train(){
		mlp.train(inputdata,outputdata,itrs,lr,mom);
	}
	/**
	 * 重载，自定义训练参数
	 * */
	public void train(int itrs,double lr,double mom){
		mlp.train(inputdata,outputdata,itrs,lr,mom);
	}
	/**
	 * 根据输入数据预测分类
	 * */
	public double[][] predict(double[][] testdata){
		double[][] pred = mlp.interrogate(testdata);
		return pred;
	}
	
	public static void main(String args[]) throws NumberFormatException, ClassNotFoundException, SQLException{
        //input  
        double[][] inputArray = new double[][]  
        {  
        { 0.0, 0.0 },  
        { 0.0, 1.0 },  
        { 1.0, 0.0 },  
        { 1.0, 1.0 } };  
        // desired output  
        
    	String system;
    	Long startTime;
    	Long endTime;
		system = "aa";
		startTime = 1323404214L;
		endTime=1323404215L;
		
		FaultInfoService faultInfoService = new FaultInfoService();
		List<FaultUtils> data = faultInfoService.getFaultInfos(system,startTime,endTime);
        
        double[][] desiredOutputArray = new double[][]  
        {
        { 0.0,1.0},  
        { 0.0,1.0 },  
        { 1.0,0.0 },  
        { 1.0,0.0} }; 
		MultiClass mc =new  MultiClass(inputArray,desiredOutputArray);
		mc.train();
		double[][] pred = mc.predict(inputArray);//获得预测值
		
	}
	/*
	//dnn 解决故障分类
		public  HashMap<String, Double> getSimilarityDegreeOfSystemgs(String starttime,String endtime){
			//得到训练数据
			double[][] inputx = new double[faultVectors.size()][len];
			for(int i=0;i<faultVectors.size();i++){
				float[] vector = faultVectors.get(i);
				for(int j=0;j<len;j++){
					inputx[i][j]=vector[j]>0?1:0; //简单的稀疏下
				}
			}
			//设置输出label
			double[][] outputy = new double[faultVectors.size()][5];
			for(int i=0;i<allfaults.size();i++){
				if(allfaults.get(i).getSystem().equals("水泵水轮机")) {
					outputy[i]=new double[]{1,0,0,0,0};
				}
				else if(allfaults.get(i).getSystem().equals("调速器系统")) {
					outputy[i]=new double[]{0,1,0,0,0};
				}
				else if(allfaults.get(i).getSystem().equals("发电机及励磁系统")) {
					outputy[i]=new double[]{0,0,1,0,0};
				}
				else if(allfaults.get(i).getSystem().equals("主变系统")) {
					outputy[i]=new double[]{0,0,0,1,0};
				}
				else if(allfaults.get(i).getSystem().equals("球阀系统")) {
					outputy[i]=new double[]{0,0,0,0,1};
				}
			}
			
			MultiClass mc =new  MultiClass(inputx,outputy);
			mc.train();
			HashMap<String, Double> sys_pro = new HashMap<String, Double>();
			try {
				ArrayList<DataUtils> datas = this.rd.queAllRecord(starttime, endtime);
				float[] vector = dataUtilstoList(datas,StringMap);//获得当前故障向量
				double[][] testx = new double[1][len];
				for(int i=0;i<len;i++){
					testx[0][i] = vector[i]>0?1:0;
				}
				double[][] pred = mc.predict(testx);//获得预测值
				
				
				String[] keys = {"水泵水轮机","调速器系统","发电机及励磁系统","主变系统","球阀系统"};
				for(int i=0;i<keys.length;i++){
					sys_pro.put(keys[i], pred[0][i]);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return sys_pro;
		}
		*/
}
