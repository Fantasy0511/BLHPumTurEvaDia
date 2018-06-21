package algorithms.cos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import algorithms.fpgrowth.DataDiscrete;
import dao.impl.ReadData;
import service.FaultInfoService;
import util.DataUtils;
import util.FaultUtils;

/**
 * 余弦相似度计算
 * 与故障样本库中的数据进行对比，获得当前最有可能的故障
 * @author lh
 * */
public class Coscal {
	private int len; //每个向量的长度
	private DataDiscrete disc; //供离散化数据
	private HashMap<String, Integer> StringMap; //typeid对应的每个向量的维度，从0开始
	private ReadData rd; 
	private ArrayList<FaultUtils> allfaults; //所有故障样本信息
	private ArrayList<float[]> faultVectors = new ArrayList<float[]>();//所有故障样本向量
	/*生成本地文件的，用过一次就行了
	public Coscal(){
		try {
			File f = new File("src/vectors.txt");
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(f),"gbk");      
			this.rd = new ReadData();
			this.allfaults= this.rd.queFault();
			this.StringMap = this.rd.queAlltype();
			this.disc = new DataDiscrete();
			this.len = StringMap.size();
			for(int i=0;i<allfaults.size();i++){
				long starttime = allfaults.get(i).getStarttime();
				long endtime = allfaults.get(i).getEndtime();
				ArrayList<DataUtils> datas = this.rd.queAllRecord(starttime,endtime);
				float[] vector = dataUtilstoList(datas,this.StringMap);
				faultVectors.add(vector);
				for(int j=0;j<vector.length;j++){
					out.write(""+(int) vector[j]+" ");
				}
				out.write("\r\n");
			}
			out.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	*/
	public Coscal(){
		try {
			String line = "";
			InputStream is = new FileInputStream("src/vectors.txt");//加载文件
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			while ((line=bf.readLine()) != null) {//循环一次读取一行
				String[] vectorStrings = line.split(" ");
				float[] vector = new float[vectorStrings.length];
				for(int i=0;i<vectorStrings.length;i++){
					vector[i] = Float.parseFloat(vectorStrings[i]); 
				}
				faultVectors.add(vector);
			}
			this.rd = new ReadData();
			this.allfaults= this.rd.queFault();
			this.StringMap = this.rd.queAlltype();
			this.disc = new DataDiscrete();
			this.len = StringMap.size();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private double getCos(float[] a,float[] b){
		double product_ab = 0,product_a=0,product_b=0;
		for(int i=0;i<len;i++){
			product_ab = product_ab + a[i]*b[i];
			product_a = product_a + a[i]*a[i];
			product_b = product_b + b[i]*b[i];
		}
		return product_ab/(Math.pow(product_a, 0.5)*Math.pow(product_b, 0.5));
	}
	
	
	private float[] dataUtilstoList(ArrayList<DataUtils> datas,HashMap<String, Integer> StringMap) {
		float[] rs = new float[this.len];
		for(int i=0;i<datas.size();i++){
			DataUtils data = datas.get(i);
			String type = data.getType(),id = ""+data.getId();
			String typeid = type+id;
			int idx = StringMap.get(typeid);
			if(type.equals("bool")){
				rs[idx] = this.disc.boolCounter(data);
			}
			else{
				rs[idx] = this.disc.LimiteCounter(data);
			}
			
		}
		return rs;
		
	}
	
	private ArrayList<Double> getSimilarityDegree(String starttime,String endtime){
		ArrayList<Double> rs = new ArrayList<Double>();
		double total = 0.0,cos;
		try {
			ArrayList<DataUtils> datas = this.rd.queAllRecord(starttime, endtime);
			float[] vector = dataUtilstoList(datas,StringMap);
			for(int i=0;i<faultVectors.size();i++){
				cos = getCos(vector,faultVectors.get(i));
				if(Double.isNaN(cos)){
					cos = 0;
					}
				total = total + cos;
				rs.add(cos);
			}
			for(int i=0;i<faultVectors.size();i++){
				rs.set(i, rs.get(i)/total);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void main(String[] args) {
		Coscal cc = new Coscal();
		String starttime="2014-01-01 00:00:00";
		String endtime="2014-01-02 00:00:00";
		ArrayList<Double> rs = cc.getSimilarityDegree(starttime, endtime);
		System.out.print(rs);
	}
}
