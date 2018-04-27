package algorithms.apriori;

import java.awt.print.Printable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.ranking.TiesStrategy;

import algorithms.fpgrowth.DataDiscrete;
import dao.impl.ReadData;
import util.DataUtils;
import util.FaultUtils;
import util.TimeUtils;
import util.TypeNums;

/**
 * Example of how to use APRIORI algorithm from the source code.
 * 
 * @author Philippe Fournier-Viger (Copyright 2008) lh
 */
public class MainTestApriori_saveToMemory {

	public static void main(String[] arg) throws IOException, ClassNotFoundException, SQLException {

		
		/*
		// Note : we here set the output file path to null
		// because we want that the algorithm save the
		// result in memory for this example.
		long startTime=System.currentTimeMillis();   //获取开始时间
		//saveDatabase("src/items_Transf.txt","主变系统");
		// Applying the Apriori algorithm
		
		String input = "src/items_Pum.txt";
		double minsup = 0.5;
		Apriori apriori = new Apriori();
		Itemsets result = apriori.runAPriori(minsup, input, null);
		apriori.printStats();
		result.printItemsets(apriori.getDatabaseSize());
		
		String path = "E:/Pum"+minsup+".txt";
		saveItemsinString(path,result,apriori.getDatabaseSize());
		
		System.out.println("事务集中共含有："+apriori.getDatabaseSize()+"项事务");
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		*/
		saveDatabase("src/items_Pum.txt","Pum");//103kb
		saveDatabase("src/items_Exc.txt","Exc");
		saveDatabase("src/items_Transfer.txt","Transfer");
		saveDatabase("src/items_Gov.txt","Gov");
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
				//int trendFlag = discrete.trendAnalysis(data);不要了，开销太大
				if(limiteFlag!=0){
					item.add(limiteFlag*i);
				}
				/*
				if(trendFlag!=0){
					item.add(trendFlag*i*10); //bool已经占据了前2568，所以乘10后不会与前面发生冲突
				}
				*/
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
		ArrayList<String> times = getTimes(readDB,system); 
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
	
	private static void saveItemsinString(String path,Itemsets result,int databasesize) throws IOException, ClassNotFoundException, SQLException{
		DataDiscrete discrete = new DataDiscrete();
		
		List<List<Itemset>> levels = result.getLevels();//通过一层层遍历level即可获得所需
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		int patternCount = 0;
		int levelCount = 0;
		for (List<Itemset> level : levels) {
			writer.write("  L" + levelCount + " ");
			writer.newLine();
			for (Itemset itemset : level) {
				writer.write("  pattern " + patternCount + ":  ");
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<itemset.getItems().length;i++){
					sb.append(discrete.restoreID(itemset.getItems()[i]));
					sb.append(" ");
				}
				writer.write(sb.toString());
				writer.write("  " + itemset.getAbsoluteSupport());
				writer.write("  " + itemset.getRelativeSupportAsString(databasesize));
				// + itemset.getRelativeSupportAsString(nbObject));
				patternCount++;
				writer.newLine();
			}
			levelCount++;
		}
		writer.close();
	}
}
