package bll.diagnosis.tree.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import bll.diagnosis.tree.pumParmeter;

//import bll.diagnosis.tree.dao.TSFaultTreeResultSave;

/**
 * 调速系统故障树诊断主模块，通过该类进入故障树诊断
 * 
 * @author 许颜贺
 * 
 */
public class FaultTreeMain {

	private static DefaultMutableTreeNode root;
	private static DefaultTreeModel model;
	private static MakeFaultTree makeFaultTree;
	private static CaculateMinCutset caculateMinCutset;
	private static FaultDiagnosis faultDiagnosis;
	private static String[] faultname;
	private static String[] faultvalue;
	private static Map<String, String> faultTreeResultMap = new HashMap();
	public static ArrayList<String> Faultsname = new ArrayList<String>();
	private static double[] FaultSymptom;
	private static String faultfeature = "";
	private static String[] recommendation = { "0", "0", "0" };

	/**
	 * 初始化
	 */
	public static void initail() {
		faultname = null;
		faultvalue = null;
		faultTreeResultMap = new HashMap();
		Faultsname = new ArrayList<String>();
		FaultSymptom = null;
	}
	
	
	/**
	 * 测试类
	 * @param args
	 */
	/*public static void main(String[] args) {
		String nowtime = "";
		String  pum;
		java.text.Format format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		nowtime = format.format(new java.util.Date());
		FaultTreeDiagnosis("pum",1, "1", "1", nowtime);// 需要把nowtime改成由前端获取的诊断时间
	}*/

	/**
	 * 故障树诊断主函数
	 * 
	 * @param write
	 *            诊断结果存储标志，1表示存储，其他表示不存储
	 * @param unit
	 *            机组名称
	 * @param datetime
	 *            诊断时间
	 * @return 故障信息列表
	 */

	public static List<FaultResult> FaultTreeDiagnosis(String system,int write, String condtionName, 
			String unitNo, String datetime)
	// public static List<FaultResult> FaultTreeDiagnosis()
	{
		initail();
		int i, j;
		ArrayList<Node> testnodes = new ArrayList<Node>();
		ArrayList<ArrayList<DefaultMutableTreeNode>> cal;
		double P = 0, P1 = 0;
		double IP = 0, IPS = 0, IPK = 0;
		// double FaultSymptom[] = new double[19];

		// 创建故障树节点数组（可修改InitialNodes()函数，从文件中读取）
		MakeFaultTree.InitialNodes(system,testnodes, datetime, Integer.valueOf(unitNo));
		// 写txt
		// Change.write(testnodes);
		// 建立故障树
		makeFaultTree = new MakeFaultTree(testnodes);
		makeFaultTree.setNodes(testnodes);
		model = makeFaultTree.getFaultTree();

		root = (DefaultMutableTreeNode) model.getRoot();

		// 最小割集计算
		caculateMinCutset = new CaculateMinCutset(testnodes, model);
		cal = caculateMinCutset.caculate(root);

		// 计算概率
		P = caculateMinCutset.EstimateP(cal); // 估算顶事件概率

		P1 = caculateMinCutset.CalculateP("调速系统运行故障"); // 计算任何节点概率

		// 计算底事件重要度
		IP = caculateMinCutset.CalculateIP("导叶开度反馈信号为零");// 底事件概率重要度
		IPS = caculateMinCutset.CalculateIPStructure("导叶开度反馈信号为零");// 底事件结构重要度
		IPK = caculateMinCutset.CalculateIPKey("导叶开度反馈信号为零");// 底事件关键重要度

		// ----------------故障诊断----------------//
		// ---初始化---//
		faultDiagnosis = new FaultDiagnosis(testnodes);
		// faultDiagnosis.initialSymptomkind(station,unitNo,datetime);

		faultDiagnosis.InitialFaultFeature(system);// 生成故障表（读取表）
		FaultSymptom = new double[19];
		FaultSymptom = faultDiagnosis.InitialFaultSymptom(system,FaultSymptom, datetime, unitNo, condtionName);// 随机生成故障征兆向量（读取征兆）
		// for(int aaa=0;aaa<18;aaa++)
		// {System.out.println(FaultSymptom[aaa]);};
		// double
		// FaultSymptom[]={1.00,1.00,0.00,0.40,0.50,0.00,0.080,0.00,0.00,0.00,0.60,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
		// ---定义变量---//
		String BottomEvents[] = new String[testnodes.size()];// 底事件名称数组
		double BottomIPK[] = new double[testnodes.size()];// 底事件关键重要度数组
		int BottomEventsNum = 0;// 底事件数
		ArrayList<FaultFeature> FaultMatrix = new ArrayList<FaultFeature>();// 针对故障树的征兆模糊矩阵

		// ---故障计算---//
		BottomEventsNum = caculateMinCutset.BottomEventSort(BottomEvents, BottomIPK);// 底事件按关键重要度从大到小排序
		faultDiagnosis.getFaultMatrix(FaultMatrix, BottomEvents);// 获得征兆特征模糊矩阵
		double FaultAttribution[] = new double[BottomEventsNum];// 定义故障隶属度向量
		faultDiagnosis.getFaultAttribution(FaultSymptom, FaultMatrix, FaultAttribution);// 计算故障隶属度

		faultDiagnosis.Diagnosis(system,FaultSymptom, Faultsname);// 根据故障征兆按照故障树诊断出可能故障集
		double FaultsIPK[] = new double[Faultsname.size()];// 定义故障集中故障的关键度数组
		caculateMinCutset.FaultsSort(Faultsname, FaultsIPK);// 故障集中故障按照故障关键度大小排列
		int Faultsnum = 0;// 故障数量

		double FaultsFreq[] = new double[Faultsname.size()];// 故障概率数组
		Faultsnum = faultDiagnosis.DiagnosisResult(Faultsname, FaultsIPK, FaultsFreq);// 故障结果处理
		faultname = new String[Faultsnum];
		faultvalue = new String[Faultsnum];
		System.out.println(Faultsnum);
		// 为faultname赋值
		for (int k = 0; k < Faultsname.size(); k++) {

			faultname[k] = Faultsname.get(k);
		}

		java.text.NumberFormat formater = java.text.DecimalFormat.getInstance();
		formater.setMaximumFractionDigits(4);
		formater.setMinimumFractionDigits(4);

		System.out.println(Faultsname);

		// 显示故障诊断

		// java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");

		List<FaultResult> faultResultList = new ArrayList<FaultResult>();
		// List<Fault> faults = Readtable.Fault();
		List<Fault> faults = FaultDiagnosis.TSFaultsRead(system);

		if (Faultsname.size() != 0) {

			System.out.println("/*-----检测出" + Faultsname.size() + "故障-----*/");
			for (i = 0; i < Faultsnum; i++) {

				System.out.println("FTree:" + Faultsname.get(i) + "	" + FaultsFreq[i]);
				// String[] symptom = new String[3];
				int temp = 0;
				int node = 0;
				for (j = 0; j < faults.size(); j++) {
					if (Faultsname.get(i).equals(faults.get(j).getName())) {

						temp = faults.get(j).getID();
						node = faults.get(j).getNode();
						System.out.println(temp);
						System.out.println(node);

					}
				}
				;
				if (temp != 0) {
					FaultResult tempFault = new FaultResult();
					tempFault.setID(temp);
					System.out.println("id值：" + temp);
					tempFault.setName(Faultsname.get(i));
					tempFault.setLocation(faults.get(temp - 1).getLocation());
					tempFault.setNode(node);
					tempFault.setProbability(FaultsFreq[i]);
					System.out.println(faults.toString());
					tempFault.setRecommendation(faults.get(temp - 1).getRecommendation());
					// recommendation[i]=faults.get(temp -
					// 1).getRecommendation();
					tempFault.setConditionName(condtionName);
					faultResultList.add(tempFault);
				}

			}
		}

		if (Faultsname.size() == 0) {
			String[] symptom = new String[3];
			FaultResult tempFault = new FaultResult();
			tempFault.setID(-1);
			tempFault.setName("未诊断出故障");
			tempFault.setLocation("");
			tempFault.setProbability(0.0);

			tempFault.setRecommendation("未诊断出故障，建议采取进一步分析");
			tempFault.setConditionName(condtionName);

			symptom[0] = "";
			symptom[1] = "";
			symptom[2] = "";

			faultResultList.add(tempFault);
		}

		// if (write == 1) {
		// writeresult(unitNo, datetime, condtionName);
		// }

		return faultResultList;

	}

	/**
	 * 诊断结果存储函数
	 * 
	 * @param station
	 *            电站名称
	 * @param unit
	 *            机组名称
	 * @param datetime
	 *            诊断时间
	 *//*
		 * public static List<Fault> writeresult(String unitNo, String datetime, String
		 * wcstatus) {
		 * 
		 * List<Fault> faults = FaultDiagnosis.TSFaultsRead(); int temp = 0; int node =
		 * 0;
		 * 
		 * TSFaultTreeResultSave tsre = new TSFaultTreeResultSave(); for (int m = 0; m <
		 * FaultSymptom.length; m++) { faultfeature += FaultSymptom[m] + "/"; } if
		 * (faultname.length != 0) { int[] resultID = new int[faultname.length]; for
		 * (int i = 0; i < faultname.length; i++) {
		 * 
		 * for (int j = 0; j < faults.size(); j++) { if
		 * (Faultsname.get(i).equals(faults.get(j).getName())) { temp =
		 * faults.get(j).getID(); node = faults.get(j).getNode(); } if
		 * (faults.get(j).getName().equals(faultname[i])) { resultID[i] =
		 * faults.get(j).getID(); tsre.setID(faults.get(j).getID()); //
		 * tsre.setWcstatus(wcstatus); tsre.setResult(Faultsname.get(i));
		 * tsre.setSymptom(faultfeature); tsre.setUnitNo(unitNo);
		 * tsre.setTime(datetime); tsre.setRecommendation( faults.get(temp -
		 * 1).getRecommendation()); tsre.save(); System.out.println("诊断结果保存成功");
		 * System.out.println(resultID[i] + ":  " + faultname[i]); } }
		 * 
		 * } } return faults; }
		 */

	public static Map<String, String> getFaultTreeResultMap() {
		return faultTreeResultMap;
	}

	public static void setFaultTreeResultMap(Map<String, String> faultTreeResultMap) {
		FaultTreeMain.faultTreeResultMap = faultTreeResultMap;
	}

}