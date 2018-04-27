package algorithms.fpgrowth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.sun.corba.se.spi.orb.StringPair;

import util.DataUtils;
import util.FaultUtils;
import util.TimeUtils;
import algorithms.fpgrowth.Itemset;
import dao.impl.ReadData;

/**
 * 数据处理类
 * @author lh
 * */
public class DataProcess {

	public static void main(String[] args) throws IOException{
		String[] filesString = {"ball","Transfer","Exc","Gov","Pum"};
		String[] systems = {"球阀系统","主变系统","发电机及励磁系统","调速器系统","水泵水轮机"};
		for(int i=0;i<systems.length;i++){
//			saveDatabase("src/items_notrend_"+filesString[i]+".txt", systems[i]);
			filterItems("src/items_notrend_"+filesString[i]+".txt", "src/items_notrend_"+filesString[i]+"_nofreq.txt");
		}
//		saveDatabase("src/items_notrend_"+filesString[3]+".txt", systems[3]);
		
	}
	
	/**
	 * 根据开始、结束时间获得离散后的事务
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * */
	private static int[] getItem(ReadData readDB,String startstr,String endstr,DataDiscrete discrete) throws ClassNotFoundException, SQLException{		
		ArrayList<DataUtils> datas = readDB.queAllRecord(startstr, endstr);
		List<Integer> item = new ArrayList<>();
		for(int i=0;i<datas.size();i++){
			DataUtils data = datas.get(i);
			if(data.getType().equals("bool")){
				if(discrete.boolDiscrete(data)==1){
					item.add(data.getId());
				}
			}else{
				int limiteFlag = discrete.LimiteAanlysis(data);
				//int trendFlag = discrete.trendAnalysis(data);
				if(limiteFlag!=0){
					item.add(limiteFlag*i);
				}
//				if(trendFlag!=0){
//					item.add(trendFlag*i*10); //bool已经占据了前2568，所以乘10后不会与前面发生冲突
//				}
			}
		}
		int[] item_array = new int[item.size()];
		for(int i=0;i<item.size();i++){
			item_array[i] = item.get(i);
		}
		return item_array;
		
	}
	
	/**
	 * 获得所有故障样本的时间段
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * */
	private static ArrayList<String> getTimes(ReadData readDB) throws ClassNotFoundException, SQLException{
		ArrayList<FaultUtils> faults = readDB.queFault();
		ArrayList<String> times = new ArrayList<>();
		for(FaultUtils fault:faults){
			if(fault.getStarttime()!=0){
				times.add(TimeUtils.LongtoString(fault.getStarttime()));
				times.add(TimeUtils.LongtoString(fault.getEndtime()));
			}
		}
		return times;
	}
	
	/**
	 * 获得指定系统故障样本的时间段
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * */
	private static ArrayList<String> getTimes(ReadData readDB,String system) throws ClassNotFoundException, SQLException{
		ArrayList<FaultUtils> faults = readDB.queFault(system);
		ArrayList<String> times = new ArrayList<>();
		for(FaultUtils fault:faults){
			if(fault.getStarttime()!=0){
				times.add(TimeUtils.LongtoString(fault.getStarttime()));
				times.add(TimeUtils.LongtoString(fault.getEndtime()));
			}
		}
		return times;
	}
	
	/**
	 * 把离散后的所有故障样本整合到一起，存放入txt中
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * */
	private static void saveDatabase(String savefile,String system) throws IOException, ClassNotFoundException, SQLException{
		ReadData readDB = new ReadData();
		ArrayList<String> times=null;
		if(system.equals("all")){
			times = getTimes(readDB); 
		}else{
			times = getTimes(readDB,system); 
		}
		
		DataDiscrete discrete = new DataDiscrete();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(savefile));
		for(int i=0;i<times.size()/2;i++){
			int[] item = getItem(readDB,times.get(2*i), times.get(2*i+1),discrete);
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<item.length;j++){
				sb.append(item[j]);
				sb.append(" ");
			}
			writer.write(sb.toString());
			writer.newLine();
			System.out.println("已经写入第"+i+"个故障");
		}
		writer.close();
	}
	
	static void saveItemsinString(String path,List<Itemset> itemsets) throws IOException, ClassNotFoundException, SQLException{
		DataDiscrete discrete = new DataDiscrete();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		int patternCount = 1;
		int k = 0;
		for (Itemset itemset : itemsets) {
			if(k!=itemset.getK()){
				k=itemset.getK();
				writer.write("频繁" + k + "项集：");
				writer.newLine();
			}
			writer.write("P"+patternCount+" 支持度："+itemset.getSupport()+" ");
			StringBuilder sb = new StringBuilder();
			for(String item:itemset.getItems()){
				sb.append(discrete.restoreID( Integer.parseInt(item)));
				sb.append("  ");
			}
			writer.write(sb.toString());
			writer.newLine();
			patternCount++;
			
		}
		writer.close();
	}
	
	/**
	 * 
	 * 选择输入文件，从中过滤五大系统的的频繁项，并保存
	 * @param inputptah 输入文件
	 * @param outputpath 输出文件
	 * */
	public static void filterItems(String inputpath,String outputpath){
		FPTree fptree = new FPTree(0.8);
		List<List<String>> transactions = fptree.loadTransaction("src/items_notrend_all.txt");
		fptree.FPGrowth(transactions, null);
		Collections.sort(fptree.getItemsets(),new Comparator<Itemset>(){
			public int compare(Itemset item1, Itemset item2) {
				return item2.getK()-item1.getK();//从大到小
			}
		});
		List<String> freItems = fptree.getItemsets().get(0).getItems();
		List<List<String>> transactions_input = fptree.loadTransaction(inputpath);
		//保存剩下的项
		try {
			BufferedWriter br1 = new BufferedWriter(new FileWriter(outputpath));
			for(List<String> items:transactions_input){
				StringBuilder sb1 = new StringBuilder();
				for(String item:items){
					if(!freItems.contains(item)){
						sb1.append(item);
						sb1.append(" ");
					}
				}
				br1.write(sb1.toString());
				br1.newLine();
			}
			br1.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 提取数据中bool的部分
	 * @param inputpath 输入文件
	 * @param outputpath1   只含bool变量的文件
	 * @param outputpath2 剩下的变量文件 
	 * @throws IOException 
	 * */
	public static void separateData(String inputpath,String outputpath1,String outputpath2) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File(inputpath)));
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(outputpath1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(outputpath2));
		String line = "";
		while((line = br.readLine()) != null){
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for(String item:line.split(" ")){
				if(Math.abs(Integer.parseInt(item))<=2568){
					sb1.append(item);
					sb1.append(" ");
				}else{
					sb2.append(item);
					sb2.append(" ");
				}
			}
			bw1.write(sb1.toString());
			bw1.newLine();
			bw2.write(sb2.toString());
			bw2.newLine();
		}
		br.close();
		bw1.close();
		bw2.close();
		
	} 
}
