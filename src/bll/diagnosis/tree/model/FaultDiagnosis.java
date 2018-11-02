package bll.diagnosis.tree.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.impl.sql.catalog.SYSCONGLOMERATESRowFactory;

import bll.diagnosis.tree.GovDBConfig;

/**
 * 调速系统故障树诊断
 * 
 * @author
 *
 */
public class FaultDiagnosis {
	private ArrayList<FaultFeature> Faults;
	private ArrayList<Node> nodes;
	// private final double dert = 0.05;
	public static List<Symptomkind> symkind = new ArrayList<Symptomkind>();
	private ArrayList<String> faultData;

	// private static CaculateMinCutset caculateMinCutsetD;

	/**
	 * 构造故障树诊断类
	 * 
	 * @param nodeslist
	 *            故障树节点信息列表
	 */
	public FaultDiagnosis(ArrayList<Node> nodeslist) {
		nodes = nodeslist;
		Faults = new ArrayList<FaultFeature>();
	}

	public FaultDiagnosis() {
		super();
	}

	/**
	 * 故障特征向量初始化
	 * 
	 * @param FaultSymptom
	 *            故障特征向量
	 * @param datetime
	 *            诊断时间
	 * @return 故障特征向量
	 */

	public double[] InitialFaultSymptom(String system, double FaultSymptom[], String datetime, String UnitNo,
			String condtionName) {
		// 水泵水轮机征兆矩阵获取
		if (system.equals("pum")) {
			PumFaultTreeInputModel datas = new PumFaultTreeInputModel().tstreeanalysis(datetime, UnitNo, condtionName);

			if (null == datas) {
				FaultSymptom = null;
			} else {

				if (datas.getLqslld() == 1) // 冷却水流量低
					FaultSymptom[0] = 1;
				else {
					FaultSymptom[0] = 0;
				}

			

				if (datas.getLqssyyc() == 1) // 冷却水水压异常
					FaultSymptom[2] = 5;
				else {
					FaultSymptom[2] = 0;
				}

				if (datas.getYxtyyd() == 1) // 油系统油压低
					FaultSymptom[3] = 10;
				else {
					FaultSymptom[3] = 0;
				}

				if (datas.getHlgz() == 1) // 回路故障
					FaultSymptom[4] = 30;
				else {
					FaultSymptom[4] = 0;
				}
				/*if (datas.getHlgz() == 1) // 回路故障
					FaultSymptom[20] = 5000000;
				else {
					FaultSymptom[20] = 0;}*/
				
				if (datas.getYxtywg() == 1) // 油系统油温高
					FaultSymptom[5] = 50;
				else {
					FaultSymptom[5] = 0;
				}
				
				
				
				if (datas.getDzbdyc() == 1) // 大轴摆度异常
					FaultSymptom[6] = 100;
				else {
					FaultSymptom[6] = 0;
				}

				if (datas.getJyfgz() == 1) // 减压阀故障
					FaultSymptom[7] = 300;
				else {
					FaultSymptom[7] = 0;
				}
				
				/*if (datas.getJyfgz() == 1) // 减压阀故障
					FaultSymptom[22] = 30000000;
				else {
					FaultSymptom[22] = 0;}*/
				
				if (datas.getHlstyc() == 1) // 回路异常渗漏
					FaultSymptom[8] = 500;
				else {
					FaultSymptom[8] = 0;
				}

				if (datas.getXhybgz() == 1) // 循环油泵故障
					FaultSymptom[9] = 1000;
				else {
					FaultSymptom[9] = 0;
				}

				if (datas.getThgz() == 1) // 弹簧故障
					FaultSymptom[10] = 3000;
				else {
					FaultSymptom[10] = 0;
				}

			/*	if (datas.getThgz() == 1) // 弹簧故障
					FaultSymptom[21] = 10000000;
				else {
					FaultSymptom[21] = 0;}*/
				
				if (datas.getXdbdyc() == 1) // 下导摆度异常
					FaultSymptom[11] = 5000;
				else {
					FaultSymptom[11] = 0;
				}

				if (datas.getGljq() == 1) // 管路进气
					FaultSymptom[12] = 10000;
				else {
					FaultSymptom[12] = 0;
				}


				/*if (datas.getGljq() == 1) // 管路进气
					FaultSymptom[26] = 500000000;
				else {
					FaultSymptom[26] = 0;}*/
			
				
				if (datas.getLcdlbph() == 1) // 磁拉力不平衡
					FaultSymptom[13] = 30000;
				else {
					FaultSymptom[13] = 0;
				}

				if (datas.getYlyc() == 1) // 压力异常
					FaultSymptom[14] = 50000;
				else {
					FaultSymptom[14] = 0;
				}

				if (datas.getXjjzd() == 1) // 下机架振动
					FaultSymptom[15] = 100000;
				else {
					FaultSymptom[15] = 0;
				}

				if (datas.getYbzcks() == 1) // 油泵轴承卡涩
					FaultSymptom[16] = 300000;
				else {
					FaultSymptom[16] = 0;
				}
				if (datas.getCxdjgz() == 1) // 冲洗电机故障
					FaultSymptom[17] = 500000;
				else {
					FaultSymptom[17] = 0;
				}
			/*	if (datas.getCxdjgz() == 1) // 冲洗电机故障
					FaultSymptom[24] = 100000000;
				else {
					FaultSymptom[24] = 0;}*/
				if (datas.getGlqds() == 1) // 过滤器堵塞
					FaultSymptom[18] = 1000000;
				else {
					FaultSymptom[18] = 0;}
			
				if (datas.getZwjxbj() == 1) // 轴瓦间隙不均
					FaultSymptom[1] = 3;
				else {
					FaultSymptom[1] = 0;}
				
				/*if (datas.getLqsswg() == 1) // 冷却水水温高
					FaultSymptom[1] = 3;
				else {
					FaultSymptom[1] = 0;
				}*/
				
				
				
				/*if (datas.getGlqds() == 1) // 过滤器堵塞
					FaultSymptom[23] = 50000000;
				else {
					FaultSymptom[23] = 0;}*/
				
				
			
			/*	if (datas.getCyhlgz() == 1) // 测压回路故障
					FaultSymptom[25] = 300000000;
				else {
					FaultSymptom[25] = 0;}
			
			
				if (datas.getGljq() == 1) // 流量异常
					FaultSymptom[27] = 1000000000;
				else {
					FaultSymptom[27] = 0;}*/
			
			
			}
		}
		// 调速器征兆矩阵获取
		else if (system.equals("gov")) {
			System.out.println("11212555");
			GovFaultTreeInputModel datas = new GovFaultTreeInputModel().tstreeanalysis(datetime, UnitNo, condtionName);
			System.out.println("输出datas: " + datas);
			if (null == datas) {
				FaultSymptom = null;
			} else {
				if (datas.getJdxzt() == 1) { // 剪断销
					FaultSymptom[0] = 1;
				} else {
					FaultSymptom[0] = 0;
				}

				if (datas.getFtHAlarm() == 1) { // 集油箱油位偏高
					FaultSymptom[1] = 3;
				} else {
					FaultSymptom[1] = 0;
				}
				if (datas.getFtLAlarm() == 1) { // 集油箱油位偏低
					FaultSymptom[2] = 5;
				} else {
					FaultSymptom[2] = 0;
				}

				if (datas.getPtHAlarm() == 1) { // 压力油罐油位偏高
					FaultSymptom[3] = 10;
				} else {
					FaultSymptom[3] = 0;
				}
				if (datas.getPtLAlarm() == 1) { // 压力油罐油位偏低
					FaultSymptom[4] = 30;
				} else {
					FaultSymptom[4] = 0;
				}

				if (datas.getPtAirLeak() == 1) { // 压油罐漏气
					FaultSymptom[5] = 50;
				} else {
					FaultSymptom[5] = 0;
				}
				if (datas.getSysOilSpill() == 1) { // 油系统漏油
					FaultSymptom[6] = 100;
				} else {
					FaultSymptom[6] = 0;
				}
				if (datas.getLowEff() == 1) { // 油泵效率低
					FaultSymptom[7] = 300;
				} else {
					FaultSymptom[7] = 0;
				}
				if (datas.getOilPFailure() == 1) {
					FaultSymptom[8] = 500;
				} else {
					FaultSymptom[8] = 0;
				}
				FaultSymptom[9] = 0;
				FaultSymptom[10] = 0;
				FaultSymptom[11] = 0;
				FaultSymptom[12] = 0;
				FaultSymptom[13] = 0;
				FaultSymptom[14] = 0;
				FaultSymptom[15] = 0;
				FaultSymptom[16] = 0;
				FaultSymptom[17] = 0;
				FaultSymptom[18] = 0;
			}
		}

		// 球阀征兆矩阵
		else if (system.equals("blv")) {
			BlvFaultTreeInputModel datas = new BlvFaultTreeInputModel().tstreeanalysis(datetime, UnitNo, condtionName);
			if (null == datas) {
				FaultSymptom = null;
			} else {
				if (datas.getPtPLAlarm() == 1) {// 压力油罐油压低
					FaultSymptom[0] = 1;
				} else {
					FaultSymptom[0] = 0;
				}
				if (datas.getPtOHAlarm() == 1) {// 压力油罐油位高
					FaultSymptom[1] = 3;
				} else {
					FaultSymptom[1] = 0;
				}
				if (datas.getPtOlAlarm() == 0) {// 压力油罐油位低
					FaultSymptom[2] = 5;
				} else {
					FaultSymptom[2] = 0;
				}
				FaultSymptom[3] = 0;
				FaultSymptom[4] = 0;
				FaultSymptom[5] = 0;
				FaultSymptom[6] = 0;
				FaultSymptom[7] = 0;
				FaultSymptom[8] = 0;
				FaultSymptom[9] = 0;
				FaultSymptom[10] = 0;
				FaultSymptom[11] = 0;
				FaultSymptom[12] = 0;
				FaultSymptom[13] = 0;
				FaultSymptom[14] = 0;
				FaultSymptom[15] = 0;
				FaultSymptom[16] = 0;
				FaultSymptom[17] = 0;
				FaultSymptom[18] = 0;
			}
		}

		// 主变征兆矩阵
		else if (system.equals("mt")) {
			MtFaultTreeInputModel datas = new MtFaultTreeInputModel().tstreeanalysis(datetime, UnitNo, condtionName);
			if (null == datas) {
				FaultSymptom = null;
			} else {
				if (datas.getCoolerF() == 1) {// 冷却器故障
					FaultSymptom[0] = 1;
				} else {
					FaultSymptom[0] = 0;
				}
				if (datas.getACPowerF() == 1) {// 交流电源故障
					FaultSymptom[1] = 3;
				} else {
					FaultSymptom[1] = 0;
				}
				if (datas.getCoolingWF() == 1) {// 冷却水泄漏报警
					FaultSymptom[2] = 5;
				} else {
					FaultSymptom[2] = 0;
				}
				FaultSymptom[3] = 0;
				FaultSymptom[4] = 0;
				FaultSymptom[5] = 0;
				FaultSymptom[6] = 0;
				FaultSymptom[7] = 0;
				FaultSymptom[8] = 0;
				FaultSymptom[9] = 0;
				FaultSymptom[10] = 0;
				FaultSymptom[11] = 0;
				FaultSymptom[12] = 0;
				FaultSymptom[13] = 0;
				FaultSymptom[14] = 0;
				FaultSymptom[15] = 0;
				FaultSymptom[16] = 0;
				FaultSymptom[17] = 0;
				FaultSymptom[18] = 0;
			}
		}
		// 发电电动机征兆矩阵获取
		else if (system.equals("gen")) {

			GenFaultTreeInputModel datas = new GenFaultTreeInputModel().tstreeanalysis(datetime, UnitNo, condtionName);
			System.out.println("输出datas: " + datas);
			if (null == datas) {
				FaultSymptom = null;
			} else {
				if (datas.getZpgg() == 1) { // 转频过高
					FaultSymptom[0] = 1;
				} else {
					FaultSymptom[0] = 0;
				}

				if (datas.getKlqgz() == 1) { // 空冷器故障
					FaultSymptom[1] = 3;
				} else {
					FaultSymptom[1] = 0;
				}
				if (datas.getZzjysh() == 1) { // 转子绝缘损坏
					FaultSymptom[2] = 5;
				} else {
					FaultSymptom[2] = 0;
				}

				if (datas.getZpzd() == 1) { // 转频振动
					FaultSymptom[3] = 10;
				} else {
					FaultSymptom[3] = 0;
				}
				if (datas.getJpzd() == 1) { // 极频振动
					FaultSymptom[4] = 30;
				} else {
					FaultSymptom[4] = 0;
				}

				if (datas.getLcdyyc() == 1) { // 励磁电源异常
					FaultSymptom[5] = 50;
				} else {
					FaultSymptom[5] = 0;
				}
				if (datas.getFsgz() == 1) { // 风扇故障
					FaultSymptom[6] = 100;
				} else {
					FaultSymptom[6] = 0;
				}
				FaultSymptom[7] = 0;
				FaultSymptom[8] = 0;
				FaultSymptom[9] = 0;
				FaultSymptom[10] = 0;
				FaultSymptom[11] = 0;
				FaultSymptom[12] = 0;
				FaultSymptom[13] = 0;
				FaultSymptom[14] = 0;
				FaultSymptom[15] = 0;
				FaultSymptom[16] = 0;
				FaultSymptom[17] = 0;
				FaultSymptom[18] = 0;
			}
		}

		for (int i = 0; i < FaultSymptom.length; i++) {
			System.out.println("征兆矩阵：" + FaultSymptom[i]);
		}
		return FaultSymptom;

	}

	/**
	 * 初始化故障征兆矩阵表
	 * 
	 * @return
	 */
	public void InitialFaultFeature(String system) {

		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		try {
			dbConn = GovDBConfig.getconnection();// DriverManager.getConnection(testURL,
													// userName, userPwd);
			System.out.println("Connection Successful!"); // 如果连接成功
															// 控制台输出Connection
															// Successful!
			stmt = dbConn.createStatement();

			System.out.println("读取数据");
			if (system.equals("pum")) {
				rs1 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_PumRule");
			} else if (system.equals("gov")) {
				rs1 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_GovRule");
			} else if (system.equals("blv")) {
				rs1 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_BlvRule");
			} else if (system.equals("mt")) {
				rs1 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_MtRule");
			} else if (system.equals("gen")) {
				rs1 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_GenRule");
			}
			while (rs1.next()) {
				FaultFeature temp = new FaultFeature();
				temp.name = rs1.getString("Name");
				String[] str = rs1.getString("Feature").split("/");
				for (int i = 0; i < str.length; i++)
					temp.Feature[i] = Double.parseDouble(str[i]);
				String[] relationstr = rs1.getString("Thresholdrelation").split("/");
				temp.Threshold = Double.parseDouble(relationstr[0]);
				temp.relation = Integer.parseInt(relationstr[1]);
				Faults.add(temp);
				for (int i = 0; i < Faults.size(); i++) {
					System.out.println(
							"输出relation   " + Faults.get(i).relation + "  Threshold值：  " + Faults.get(i).Threshold);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GovDBConfig.closeConnection(rs1, stmt, dbConn);
		}

	}

	/**
	 * 获取征兆矩阵
	 * 
	 * @param FaultMatrix
	 *            故障征兆矩阵
	 * @param BottomEvents
	 *            底事件名称列表
	 */
	public void getFaultMatrix(ArrayList<FaultFeature> FaultMatrix, String BottomEvents[]) {
		for (int i = 0; (i < BottomEvents.length) && (BottomEvents[i] != null); i++) {
			FaultFeature temp = new FaultFeature();
			temp.name = BottomEvents[i];
			for (int j = 0; j < Faults.size(); j++) {
				if (temp.name.equals(Faults.get(j).name)) {
					System.arraycopy(Faults.get(j).Feature, 0, temp.Feature, 0, Faults.get(j).Feature.length);
					break;
				}
			}
			FaultMatrix.add(temp);
		}
	}

	/**
	 * 计算隶属度
	 * 
	 * @param FaultSymptom
	 *            故障特征向量
	 * @param FaultMatrix
	 *            故障征兆矩阵
	 * @param FaultAttribution
	 *            隶属度
	 */
	public void getFaultAttribution(double FaultSymptom[], ArrayList<FaultFeature> FaultMatrix,
			double FaultAttribution[]) {
		for (int i = 0; i < FaultAttribution.length; i++) {
			FaultAttribution[i] = 0;
			for (int j = 0; j < FaultMatrix.get(i).Feature.length; j++) {
				FaultAttribution[i] += FaultSymptom[j] * FaultMatrix.get(i).Feature[j];
			}

		}
	}

	// ---------故障诊断函数---------//
	// 得到故障诊断可能结果集合
	/**
	 * 故障诊断函数
	 * 
	 * @param FaultSymptom
	 *            故障特征向量
	 * @param Faultnames
	 *            故障名称列表
	 */
	public void Diagnosis(String system, double FaultSymptom[], ArrayList<String> Faultnames) {
		Node root = nodes.get(0);
		for (int i = 0; i < root.children.size(); i++) {
			Node child = new Node();

			for (int j = 0; j < nodes.size(); j++)
				if (nodes.get(j).name.equals(root.children.get(i)))
					child = nodes.get(j);
			handle(system, child, FaultSymptom, Faultnames);
		}
	}

	/**
	 * 故障推理函数
	 * 
	 * @param tasknode
	 *            故障树节点
	 * @param FaultSymptom
	 *            故障特征向量
	 * @param Faultnames
	 *            故障名称列表
	 */
	private void handle(String system, Node tasknode, double FaultSymptom[], ArrayList<String> Faultnames) {
		// 水泵水轮机
		FaultFeature taskfeature = new FaultFeature();
		for (int i = 0; i < Faults.size(); i++) {

			if (Faults.get(i).name.equals(tasknode.name))
				taskfeature = Faults.get(i);
		}
		if (system.equals("pum")) {

			int flag = 0;
			if (taskfeature.Threshold == -1) { // Threshold阈值
				flag = 1;
				switch (taskfeature.relation) { // relation:比较关系
				case 1:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] >= taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 2:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] > taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 3:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] != taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 4:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] < taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 5:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] <= taskfeature.Feature[i] && taskfeature.Feature[i] != 0)
							flag = 0;
					}
					break;
				case 6:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] == taskfeature.Feature[i])
							flag = 0;
					}
					break;
				default:
				}

			} else if (taskfeature.Threshold == 1) {

				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = tempm % 10;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;
				}
			} else if (taskfeature.Threshold == 10) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 100) / 10;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}

			else if (taskfeature.Threshold == 100) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 1000) / 100;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}

			else if (taskfeature.Threshold == 1000) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 10000) / 1000;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}

			else if (taskfeature.Threshold == 10000) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 100000) / 10000;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			} else if (taskfeature.Threshold == 100000) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 1000000) / 100000;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}
			else if (taskfeature.Threshold == 1000000) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 10000000) / 1000000;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}
			else if (taskfeature.Threshold == 10000000) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 100000000) / 10000000;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}
			
			
			
			else if (taskfeature.Threshold == 100000000) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 1000000000) / 100000000;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				
				default:
					;

				}
			}
			
			
			if (flag == 1) {
				if (!tasknode.gate.equals("0")) {
					for (int i = 0; i < tasknode.children.size(); i++) {
						Node child = new Node();
						for (int j = 0; j < nodes.size(); j++)
							if (nodes.get(j).name.equals(tasknode.children.get(i)))
								child = nodes.get(j);
						handle(system, child, FaultSymptom, Faultnames);
					}
				} else {
					Faultnames.add(tasknode.name);

				}
			}
		}
		// 调速器

		else if (system.equals("gov")) {
			int flag = 0;
			if (taskfeature.Threshold == -1) {
				flag = 1;
				switch (taskfeature.relation) {
				case 1:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] >= taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 2:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] > taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 3:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] != taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 4:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] < taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 5:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] <= taskfeature.Feature[i] && taskfeature.Feature[i] != 0)
							flag = 0;
					}
					break;
				case 6:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] == taskfeature.Feature[i])
							flag = 0;
					}
					break;
				default:
					;
				}

			}

			else if (taskfeature.Threshold == 1) {
				flag = 0;
				int tempm = 0;
				int tempCre=0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i]; // 计算隶属度
				}
				if(FaultSymptom[0]==1){
					tempCre = tempm % 10+1;
				}else{
					tempCre = tempm % 10;
				}
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;
				}
			}

			else if (taskfeature.Threshold == 10) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 100) / 10;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}

			else if (taskfeature.Threshold == 100) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 1000) / 100;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}
			if (flag == 1) {
				if (!tasknode.gate.equals("0")) {
					for (int i = 0; i < tasknode.children.size(); i++) {
						Node child = new Node();
						for (int j = 0; j < nodes.size(); j++)
							if (nodes.get(j).name.equals(tasknode.children.get(i)))
								child = nodes.get(j);
						handle(system, child, FaultSymptom, Faultnames);
					}
				} else {
					Faultnames.add(tasknode.name);
				}
			}
		}

		// 球阀

		else if (system.equals("blv")) {
			int flag = 0;
			if (taskfeature.Threshold == -1) {
				flag = 1;
				switch (taskfeature.relation) {
				case 1:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] >= taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 2:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] > taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 3:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] != taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 4:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] < taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 5:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] <= taskfeature.Feature[i] && taskfeature.Feature[i] != 0)
							flag = 0;
					}
					break;
				case 6:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] == taskfeature.Feature[i])
							flag = 0;
					}
					break;
				default:
					;
				}

			}

			else if (taskfeature.Threshold == 1) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i]; // 计算隶属度
				}

				int tempCre = tempm % 10;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;
				}
			}

			else if (taskfeature.Threshold == 10) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 100) / 10;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}

			else if (taskfeature.Threshold == 100) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 1000) / 100;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}
			if (flag == 1) {
				if (!tasknode.gate.equals("0")) {
					for (int i = 0; i < tasknode.children.size(); i++) {
						Node child = new Node();
						for (int j = 0; j < nodes.size(); j++)
							if (nodes.get(j).name.equals(tasknode.children.get(i)))
								child = nodes.get(j);
						handle(system, child, FaultSymptom, Faultnames);
					}
				} else {
					Faultnames.add(tasknode.name);
				}
			}
		}

		// 主变

		else if (system.equals("mt")) {
			int flag = 0;
			if (taskfeature.Threshold == -1) {
				flag = 1;
				switch (taskfeature.relation) {
				case 1:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] >= taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 2:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] > taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 3:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] != taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 4:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] < taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 5:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] <= taskfeature.Feature[i] && taskfeature.Feature[i] != 0)
							flag = 0;
					}
					break;
				case 6:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] == taskfeature.Feature[i])
							flag = 0;
					}
					break;
				default:
					;
				}

			}

			else if (taskfeature.Threshold == 1) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i]; // 计算隶属度
				}

				int tempCre = tempm % 10;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;
				}
			}

			else if (taskfeature.Threshold == 10) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 100) / 10;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}

			else if (taskfeature.Threshold == 100) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 1000) / 100;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}
			if (flag == 1) {
				if (!tasknode.gate.equals("0")) {
					for (int i = 0; i < tasknode.children.size(); i++) {
						Node child = new Node();
						for (int j = 0; j < nodes.size(); j++)
							if (nodes.get(j).name.equals(tasknode.children.get(i)))
								child = nodes.get(j);
						handle(system, child, FaultSymptom, Faultnames);
					}
				} else {
					Faultnames.add(tasknode.name);
				}
			}
		}

		// 发电机

		else if (system.equals("gen")) {
			int flag = 0;
			if (taskfeature.Threshold == -1) {
				flag = 1;
				switch (taskfeature.relation) {
				case 1:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] >= taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 2:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] > taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 3:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] != taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 4:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] < taskfeature.Feature[i])
							flag = 0;
					}
					break;
				case 5:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] <= taskfeature.Feature[i] && taskfeature.Feature[i] != 0)
							flag = 0;
					}
					break;
				case 6:
					for (int i = 0; i < taskfeature.Feature.length; i++) {
						if (FaultSymptom[i] == taskfeature.Feature[i])
							flag = 0;
					}
					break;
				default:
					;
				}

			}

			else if (taskfeature.Threshold == 1) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i]; // 计算隶属度
				}

				int tempCre = tempm % 10;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;
				}
			}

			else if (taskfeature.Threshold == 10) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 100) / 10;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}

			else if (taskfeature.Threshold == 100) {
				flag = 0;
				int tempm = 0;
				for (int i = 1; i < taskfeature.Feature.length; i++) {
					tempm += FaultSymptom[i] * taskfeature.Feature[i];
				}

				int tempCre = (tempm % 1000) / 100;
				switch (taskfeature.relation) {
				case 1:
					if (tempCre == 1 || tempCre == 4 || tempCre == 6 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 3:
					if (tempCre == 3 || tempCre == 4 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				case 5:
					if (tempCre == 5 || tempCre == 6 || tempCre == 8 || tempCre == 9) {
						flag = 1;
					} else {
						flag = 0;
					}
					break;
				default:
					;

				}
			}
			if (flag == 1) {
				if (!tasknode.gate.equals("0")) {
					for (int i = 0; i < tasknode.children.size(); i++) {
						Node child = new Node();
						for (int j = 0; j < nodes.size(); j++)
							if (nodes.get(j).name.equals(tasknode.children.get(i)))
								child = nodes.get(j);
						handle(system, child, FaultSymptom, Faultnames);
					}
				} else {
					Faultnames.add(tasknode.name);
				}
			}
		}
	}

	/**
	 * 故障诊断结果处理
	 * 
	 * @param Faultsname
	 *            故障名称列表
	 * @param FaultsIPK
	 *            故障关键重要度
	 * @param FaultsFreq
	 *            故障概率
	 * @return 故障数量
	 */
	public int DiagnosisResult(ArrayList<String> Faultsname, double FaultsIPK[], double FaultsFreq[]) {
		double totalIPK = 0;
		int num = Faultsname.size() > 5 ? 5 : Faultsname.size();
		// int num=Faultsname.size();
		for (int i = 0; i < num; i++) {
			totalIPK += FaultsIPK[i];
		}
		for (int i = 0; i < num; i++) {
			FaultsFreq[i] = FaultsIPK[i] / totalIPK;
		}

		return num;
	}

	/**
	 * 故障结果、位置、建议获取
	 * 
	 * @return 故障列表
	 */
	public static ArrayList<Fault> TSFaultsRead(String system) {
		ArrayList<Fault> faults = new ArrayList<Fault>();
		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs0 = null;
		try {
			dbConn = GovDBConfig.getconnection();
			System.out.println("Connection Successful!"); // 如果连接成功
															// 控制台输出Connection
															// Successful!
			stmt = dbConn.createStatement();

			System.out.println("读取数据");

			if (system.equals("pum")) {
				rs0 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_PumFaultInfor order by ID");
			} else if (system.equals("gov")) {
				rs0 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_GovFaultInfor order by ID");
			} else if (system.equals("blv")) {
				rs0 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_BlvFaultInfor order by ID");
			} else if (system.equals("mt")) {
				rs0 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_MtFaultInfor order by ID");
			} else if (system.equals("gen")) {
				rs0 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_GenFaultInfor order by ID");
			}
			while (rs0.next()) {
				Fault temp = new Fault();

				temp.ID = rs0.getInt("ID");
				temp.name = rs0.getString("name");
				temp.location = rs0.getString("location");
				temp.Recommendation = rs0.getString("Recommendation");
				temp.node = rs0.getInt("Node");
				faults.add(temp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GovDBConfig.closeConnection(rs0, stmt, dbConn);
		}
		return faults;
	}
}
