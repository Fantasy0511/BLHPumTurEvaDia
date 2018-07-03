package algorithms.cos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
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

import com.opensymphony.xwork2.inject.util.Strings;
import com.sun.org.apache.xpath.internal.operations.Bool;

import bll.diagnosis.tree.model.pumInitialNodes;
import algorithms.fpgrowth.DataDiscrete;
import dao.impl.ReadData;
import service.FaultInfoService;
import util.DataUtils;
import util.FaultUtils;
import util.PathUtil;
import util.TimeUtils;

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
			File f = new File("src/vectors1.txt");
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(f),"gbk");      
			this.rd = new ReadData();
			this.allfaults= this.rd.queFault();
			this.StringMap = this.rd.queAlltype();
			this.disc = new DataDiscrete();
			this.len = StringMap.size();
			for(int i=0;i<allfaults.size();i++){
				if(allfaults.get(i).getFaultID()<100){
					long starttime = allfaults.get(i).getStarttime();
					long endtime = allfaults.get(i).getEndtime();
					ArrayList<DataUtils> datas = this.rd.queAllRecord(starttime,endtime);
					float[] vector = dataUtilstoList(datas,this.StringMap);
					faultVectors.add(vector);
					for(int j=0;j<vector.length;j++){
						out.write(String.valueOf(vector[j])+" ");
						//out.write(""+(int) vector[j]+" ");
					}
					out.write("\r\n");
				}
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
			/*InputStream is = new FileInputStream("src/vectors.txt");*/
			InputStream is = new FileInputStream(PathUtil.getWebRealBasePath()+"/config/" + "vectors.txt");//加载文件
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
			bf.close();
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
	/**
	 * 计算两个向量间余弦相似度
	 * */
	private double getCos(float[] a,float[] b){
		double product_ab = 0,product_a=0,product_b=0;
		for(int i=0;i<len;i++){
			product_ab = product_ab + a[i]*b[i];
			product_a = product_a + a[i]*a[i];
			product_b = product_b + b[i]*b[i];
		}
		return product_ab/(Math.pow(product_a, 0.5)*Math.pow(product_b, 0.5));
	}
	
	/**
	 * 将读取到的数据转换为向量
	 * */
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
	
	/**
	 * 将隶属于每个故障样本的按照子系统聚类
	 * */
	private HashMap<String, float[]> cluster() {
		HashMap<String, float[]> sys_vectors = new HashMap<String, float[]>();
		HashMap<String, Integer> sys_counters = new HashMap<String, Integer>();
		String[] keys = {"水泵水轮机","调速器系统","发电机及励磁系统","主变系统","球阀系统"};
		for(int i=0;i<keys.length;i++){
			sys_vectors.put(keys[i], new float[len]);//特征故障向量
			sys_counters.put(keys[i], 0);//向量计数器
		}
		for(int i=0;i<allfaults.size();i++){
			String sys = allfaults.get(i).getSystem();
			sys_counters.put(sys, sys_counters.get(sys)+1);
			float[] tmp_vector = sys_vectors.get(sys);
			for(int j=0;j<len;j++){
				tmp_vector[j] += faultVectors.get(i)[j];
			}
			sys_vectors.put(sys, tmp_vector);
		}
		for(int i=0;i<keys.length;i++){
			int counter = sys_counters.get(keys[i]);
			float[] tmp_vector = sys_vectors.get(keys[i]);
			for(int j=0;j<len;j++){
				tmp_vector[j] = tmp_vector[j]/counter;
			}
			sys_vectors.put(keys[i], tmp_vector);
		}
		return sys_vectors;
	}
	
	/**
	 * 获得开始结束时间内的向量，并与5大系统的故障向量对比，获得每个相似的概率
	 * */
	private  HashMap<String, Double> getSimilarityDegreeOfSystemgs(String starttime,String endtime){
		HashMap<String, Double> sys_pro = new HashMap<String, Double>();
		HashMap<String, Integer> sys_counters = new HashMap<String, Integer>();
		String[] keys = {"水泵水轮机","调速器系统","发电机及励磁系统","主变系统","球阀系统"};
		for(int i=0;i<keys.length;i++){
			sys_pro.put(keys[i], 0.0);
			sys_counters.put(keys[i], 0);
		}
		ArrayList<Double> rs = this.getSimilarityDegree(starttime,endtime);
		for(int i=0;i<rs.size();i++){
			String sys = allfaults.get(i).getSystem();
			double cos = rs.get(i);
			sys_pro.put(sys,sys_pro.get(sys)>cos?sys_pro.get(sys):cos);//存储最靠近的概率
			/*sys_pro.put(sys, sys_pro.get(sys)+cos); //概率累加*/
			sys_counters.put(sys,sys_counters.get(sys)+1);
		}
		/*
		 * 如果是概率累计的话，则需要除以总数量
		for(int i=0;i<keys.length;i++){
			double cos = sys_pro.get(keys[i]);
			sys_pro.put(keys[i], cos/sys_counters.get(keys[i]));
		}
		*/
		//求相对值
		double total = 0;
		for(int i=0;i<keys.length;i++){
			total += sys_pro.get(keys[i]);
		}
		for(int i=0;i<keys.length;i++){
			sys_pro.put(keys[i], sys_pro.get(keys[i])/total);
		}
		return sys_pro;
	}
	
	/**
	 * 获得开始结束时间内的向量，并与已知所有的故障向量对比，获得每个相似的概率
	 * */
	private  ArrayList<Double> getSimilarityDegree(String starttime,String endtime){
		ArrayList<Double> rs = new ArrayList<Double>();
		double cos;
		try {
			ArrayList<DataUtils> datas = this.rd.queAllRecord(starttime, endtime);
			float[] vector = dataUtilstoList(datas,StringMap);
			for(int i=0;i<faultVectors.size();i++){
				cos = getCos(vector,faultVectors.get(i));
				if(Double.isNaN(cos)){
					cos = 0;
					}
				rs.add(cos);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	
	
	public static void main(String[] args) {
		Coscal cc = new Coscal();
		String starttime="2015-05-11 07:20:00";
		String endtime="2015-05-11 08:20:00";
		String date = TimeUtils.LongtoString(1431303600L);
		HashMap<String, Double> pro_systems = cc.getSimilarityDegreeOfSystemgs(starttime, endtime);
		System.out.print(pro_systems);
	}
}
