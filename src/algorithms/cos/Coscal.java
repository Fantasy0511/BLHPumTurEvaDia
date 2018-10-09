package algorithms.cos;

import gnu.io.RS485PortEvent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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

import javax.persistence.criteria.CriteriaBuilder.In;

import com.lowagie.text.pdf.events.IndexEvents.Entry;
import com.opensymphony.xwork2.inject.util.Strings;
import com.sun.glass.ui.Size;
import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.org.apache.xpath.internal.operations.Bool;

import bll.diagnosis.tree.model.pumInitialNodes;
import algorithms.DNN.LogRegression;
import algorithms.DNN.MultiClass;
import algorithms.fpgrowth.DataDiscrete;
import dao.impl.ReadData;
import service.FaultInfoService;
import util.DataInfo;
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
	private HashMap<Integer,String> idMap = new  HashMap<Integer,String>(); //faultvector每个维度对应的参数，与StringMap相反
	private ReadData rd; 
	private ArrayList<FaultUtils> allfaults; //所有故障样本信息
	private ArrayList<float[]> faultVectors = new ArrayList<float[]>();//所有故障样本向量
	private float[] vector;//当前故障向量
	//生成本地文件的，用过一次就行了
	public void writeVectors(){
		try {
			File f = new File(PathUtil.getWebRealBasePath()+"/config/" + "vectors2.txt");
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
					out.write(String.valueOf(vector[j])+" ");
					//out.write(""+(int) vector[j]+" ");
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
	
	
	public Coscal(String starttime,String endtime){
		try {
			String line = "";
			//InputStream is = new FileInputStream("src/vectors.txt");
			InputStream is = new FileInputStream(PathUtil.getWebRealBasePath()+"/config/" + "vectors2.txt");//加载文件
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
			for (HashMap.Entry <String, Integer> entry: StringMap.entrySet()) {
				this.idMap.put((int)entry.getValue(),entry.getKey());
			}
			this.disc = new DataDiscrete();
			this.len = StringMap.size();
			ArrayList<DataUtils> datas = this.rd.queAllRecord(starttime, endtime);
			System.out.println("查询完毕！");
			this.vector = dataUtilstoList(datas,StringMap);//获得当前故障向量
			System.out.println("转换完毕！");
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
	 * 计算两个向量欧式距离
	 * */
	private double getEuDistance(float[] a,float[] b){
		double rs = 0.0;
		for(int i=0;i<len;i++){
			rs += (a[i]-b[i])*(a[i]-b[i]);
		}
		return Math.sqrt(rs);
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
			double sum = 0;
			for(int j=0;j<len;j++){
				sum += tmp_vector[j];
				tmp_vector[j] = tmp_vector[j]/counter;
			}
			if(sum==0){
				System.out.println(keys[i]+"系统为0");
			}
			sys_vectors.put(keys[i], tmp_vector);
		}
		return sys_vectors;
	}
	
	/*
	//原先的没考虑正常状态，考虑正常状态则余弦相似度不再使用，改用欧氏距离
	public  HashMap<String, Double> getSimilarityDegreeOfSystemgs(String starttime,String endtime){
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
			//sys_pro.put(sys, sys_pro.get(sys)+cos); //概率累加
			sys_counters.put(sys,sys_counters.get(sys)+1);
		}
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
	*/
	/*
	//原先的没考虑正常状态，考虑正常状态则余弦相似度不再使用，改用欧氏距离
	public  HashMap<String, Double> getSimilarityDegreeOfSystemgs(String starttime,String endtime){
		HashMap<String, Double> sys_pro = new HashMap<String, Double>();
		HashMap<String, Double> sys_dis = new HashMap<String, Double>();
		HashMap<String, float[]> sys_vectors = cluster(); 
		String[] keys = {"无故障","水泵水轮机","调速器系统","发电机及励磁系统","主变系统","球阀系统"};
		sys_vectors.put(keys[0],new float[len]);
		try {
			ArrayList<DataUtils> datas = this.rd.queAllRecord(starttime, endtime);
			float[] vector = dataUtilstoList(datas,StringMap);//获得当前故障向量
			double[] distances = new double[keys.length];//存储每个故障中心与当前故障向量的距离
			double sum_dis = 0;
			for(int i=0;i<keys.length;i++){
				distances[i] = getEuDistance(vector,sys_vectors.get(keys[i]));
				sum_dis += distances[i];
				sys_dis.put(keys[i],distances[i]);
			}
			//根据距离计算不同故障发生的概率,
			System.out.print(sys_dis);
			for(int i=0;i<keys.length;i++){
				sys_pro.put(keys[i],(sum_dis-distances[i])/(keys.length-1)/sum_dis);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sys_pro;
	}
	*/
	//lr 解决
		public  HashMap<String, Double> getSimilarityDegreeOfSystemgs(){
			//得到训练数据
			float[][] inputx = new float[faultVectors.size()][len];
			for(int i=0;i<faultVectors.size();i++){
				float[] tmp_vector = faultVectors.get(i);
				for(int j=0;j<len;j++){
					inputx[i][j]=tmp_vector[j]>0?1:0; //简单的稀疏下
				}
			}
			float[] sparse_vector = new float[len];
			HashMap<String, Double> sys_pro = new HashMap<String, Double>();
			for(int i=0;i<len;i++){
				sparse_vector[i] = vector[i]>0?1:0; //稀疏
			}
			String[] keys = {"水泵水轮机","调速器系统","发电机及励磁系统","主变系统","球阀系统"};
			for(int k=0;k<keys.length;k++){//分为5个lr训练
				//设置输出label
				float[] outputy = new float[faultVectors.size()];
				for(int i=0;i<allfaults.size();i++){
					if(allfaults.get(i).getSystem().equals(keys[k])) {
						outputy[i]=1;
					}
					else{
						outputy[i]=0;
					}
				}
				LogRegression lr = new LogRegression();
				lr.train(inputx,outputy, 0.011f, 2000, (short)1);
				sys_pro.put(keys[k], lr.pred(sparse_vector)<0.001?0.001:(double) lr.pred(sparse_vector));
			}
			return sys_pro;
		}
	/**
	 * 获得开始结束时间内的向量，并与已知所有的故障向量对比，获得每个相似的概率
	 * */
	private  ArrayList<Double> getSimilarityDegree(){
		ArrayList<Double> rs = new ArrayList<Double>();
		double cos;
		for(int i=0;i<faultVectors.size();i++){
			cos = getCos(vector,faultVectors.get(i));
			if(Double.isNaN(cos)){
				cos = 0;
				}
			rs.add(cos);
		}
		return rs;
	}
	
	/**
	 * 获得开始结束时间内的向量，并与输入的系统对比，获得对应系统下的故障相似概率
	 * @param System 水泵水轮机/调速器系统 /发电机及励磁系统/主变系统/球阀系统
	 * */
	public  HashMap<String, Double> getFaultSimilarityOfSystemgs(String System){
		HashMap<String, Double> fault_pro = new HashMap<String, Double>();
		ArrayList<Double> rs = this.getSimilarityDegree();
		double total = 0;
		for(int i=0;i<rs.size();i++){
			String sys = allfaults.get(i).getSystem();
			String key = allfaults.get(i).getFaultName();
			double cos = rs.get(i);
			if(sys.equals(System)&&(!fault_pro.containsKey(key))){
				fault_pro.put(key, cos);
				total = total+cos;
			}
		}
		//求相对值
//		for (HashMap.Entry <String, Double> entry: fault_pro.entrySet()) {
//			String key = entry.getKey();
//			double cos = entry.getValue();
//			fault_pro.put(key, cos/total);
//		}
		//降序排序
		List<HashMap.Entry<String,Double>> list = new ArrayList<HashMap.Entry<String,Double>>(fault_pro.entrySet());
        Collections.sort(list,new Comparator<HashMap.Entry<String,Double>>() {
            
            public int compare(HashMap.Entry<String, Double> o1,
            		HashMap.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
            
        });
        
//        for(int i=0;i<list.size();i++){ 
//        	java.lang.System.out.println(list.get(i).getKey()+":"+list.get(i).getValue());
//          } 
        //只显示前5个
        fault_pro = new HashMap<String, Double>();
        total = 0;
        int size = list.size()<10?list.size():10;
        for(int i=0;i<size;i++){ 
        	total += list.get(i).getValue();
        	fault_pro.put(list.get(i).getKey(), list.get(i).getValue());
          } 
        //重新计算相对值
		for (HashMap.Entry <String, Double> entry: fault_pro.entrySet()) {
			String key = entry.getKey();
			double cos = entry.getValue();
			fault_pro.put(key, cos/total);
		}
		return fault_pro;
	}
	/**
	 * 获得开始结束时间内的向量，并与输入的系统对比，获得对应系统下的故障相似概率
	 * @param System 水泵水轮机/调速器系统 /发电机及励磁系统/主变系统/球阀系统
	 * */
	public  HashMap<String, Double> getFaultSimilarityOfSystemgs(){
		HashMap<String, Double> fault_pro = new HashMap<String, Double>();
		ArrayList<Double> rs = this.getSimilarityDegree();
		double total = 0;
		for(int i=0;i<rs.size();i++){
			String key = allfaults.get(i).getFaultName();
			double cos = rs.get(i);
			fault_pro.put(key, cos);
		}
		//求相对值
//		for (HashMap.Entry <String, Double> entry: fault_pro.entrySet()) {
//			String key = entry.getKey();
//			double cos = entry.getValue();
//			fault_pro.put(key, cos/total);
//		}
		//降序排序
		List<HashMap.Entry<String,Double>> list = new ArrayList<HashMap.Entry<String,Double>>(fault_pro.entrySet());
        Collections.sort(list,new Comparator<HashMap.Entry<String,Double>>() {
            
            public int compare(HashMap.Entry<String, Double> o1,
            		HashMap.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
            
        });
        
//        for(int i=0;i<list.size();i++){ 
//        	java.lang.System.out.println(list.get(i).getKey()+":"+list.get(i).getValue());
//          } 
        //只显示前5个
        fault_pro = new HashMap<String, Double>();
        total = 0;
        int size = list.size()<8?list.size():8;
        for(int i=0;i<size;i++){ 
        	total += list.get(i).getValue();
        	fault_pro.put(list.get(i).getKey(), list.get(i).getValue());
          } 
        //重新计算相对值
//		for (HashMap.Entry <String, Double> entry: fault_pro.entrySet()) {
//			String key = entry.getKey();
//			double cos = entry.getValue();
//			fault_pro.put(key, cos/total);
//		}
		return fault_pro;
	}
	
	//所有发生故障的参数
	public ArrayList<ArrayList<String>> getFaultParameters() {
		ArrayList<ArrayList<String>> faultparameter = new ArrayList<ArrayList<String>>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		ArrayList<String> llimits = new ArrayList<String>();
		ArrayList<String> hlimits = new ArrayList<String>();
		ArrayList<String> typeid = new ArrayList<String>();
		try {
			HashMap<Integer, Double> vector_map = new HashMap<Integer, Double>();
			for(int i=0;i<len;i++){
				vector_map.put(i, (double) vector[i]); //idx-value,3-1.0
			}
			List<java.util.Map.Entry<Integer,Double>> list = new ArrayList<java.util.Map.Entry<Integer,Double>>(vector_map.entrySet());
	        Collections.sort(list,new Comparator<java.util.Map.Entry<Integer,Double>>() {
	        	@Override
	        	//降序排序
	            public int compare(java.util.Map.Entry<Integer, Double> o1,
	            		java.util.Map.Entry<Integer, Double> o2) {
	                return o2.getValue().compareTo(o1.getValue());
	            }
	        });
			
			int i=0;
			int size=0;
			DataInfo info;
			while(list.get(i).getValue()>0&&size<10){
				info = this.rd.queInfo(idMap.get(list.get(i).getKey()));
				name.add(info.getPosition()+"."+info.getDescription());
				values.add(""+list.get(i).getValue());
				double h = info.getHLimite();
				double l = info.getLLimite();
				llimits.add(l+"");
				hlimits.add(h+"");
				typeid.add(info.getTypeid());
				i += 1;
				size +=1;
			}
			faultparameter.add(name);
			faultparameter.add(values);
			faultparameter.add(llimits);
			faultparameter.add(hlimits);
			faultparameter.add(typeid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return faultparameter;
	}

	public static void main(String[] args) {
		String starttime="2015-06-24 00:00:00";
		String endtime="2015-06-25 00:00:00";
		Coscal cc = new Coscal(starttime,endtime);
		//cc.writeVectors();
		//System.out.println("write finish");

		Long slong = TimeUtils.StringtoLong(starttime);//1431300000
		//String date = TimeUtils.LongtoString(1431303600L);
//		starttime = TimeUtils.LongtoString(1456761600l);
//		endtime = TimeUtils.LongtoString(1456761700l);
		//每个系统发生故障的概率
		HashMap<String, Double> pro_systems = cc.getSimilarityDegreeOfSystemgs();
		//时间段内发生故障的运行参数（由发生次数多到少排序,只显示前10个）,五维的list，第一个list存储故障参数名称，第二个list存储越限次数，第三个阈值下限，第四个阈值上限，第五个list存储对应id
		ArrayList<ArrayList<String>> faultparameter=cc.getFaultParameters();
		//时间段内，与当前故障最相近的历史故障，只显示前10个
		HashMap<String, Double> pro_fault = cc.getFaultSimilarityOfSystemgs();
		/*List<Double> faultRate=new ArrayList<>();
		List<String> faultName=new ArrayList<>();
		for (HashMap.Entry <String, Double> entry: pro_systems.entrySet()) {
			faultName.add(entry.getKey());
			faultRate.add(entry.getValue());
			
			System.out.println("key： "+entry.getKey());;
			System.out.println("value:"+ entry.getValue());
		}
		for (String string : faultName) {
			System.out.println(string);
		}
		for (Double double1 : faultRate) {
			System.out.println(double1);
		}*/
		
		System.out.println(pro_systems);
		System.out.println(faultparameter);
		System.out.println(pro_fault);
	}
}
