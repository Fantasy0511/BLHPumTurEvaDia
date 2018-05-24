package bll.diagnosis.tree.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bll.diagnosis.tree.GovDBConfig;

/**
 * 调速系统故障树诊断
 * 
 * @author 许颜贺
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

	/**
	 * 故障特征向量初始化
	 * 
	 * @param FaultSymptom
	 *            故障特征向量
	 * @param datetime
	 *            诊断时间
	 * @return 故障特征向量
	 */

	public double[] InitialFaultSymptom(double FaultSymptom[], String datetime, String UnitNo, String condtionName) {

		GovFaultTreeInputModel datas = new GovFaultTreeInputModel().tstreeanalysis(datetime, UnitNo, condtionName);

		if (null == datas) {
			FaultSymptom = null;
		} else {

			if (datas.getLqsyc() == 1)
				FaultSymptom[0] = 1;
			else {
				FaultSymptom[0] = 0;
			}

			if (datas.getYxtyc() == 1)
				FaultSymptom[1] = 3;
			else {
				FaultSymptom[1] = 0;
			}

			if (datas.getDzbdyc() == 1)
				FaultSymptom[2] = 5;
			else {
				FaultSymptom[2] = 0;
			}

			if (datas.getDbph() == 1)
				FaultSymptom[3] = 10;
			else {
				FaultSymptom[3] = 0;
			}

			if (datas.getLcdlbph() == 1)
				FaultSymptom[4] = 30;
			else {
				FaultSymptom[4] = 0;
			}

			if (datas.getJdxgz() == 1)
				FaultSymptom[5] = 50;
			else {
				FaultSymptom[5] = 0;
			}

			if (datas.getShdbdyc() == 1)
				FaultSymptom[6] = 100;
			else {
				FaultSymptom[6] = 0;
			}

			if (datas.getXdbdyc() == 1)
				FaultSymptom[7] = 300;
			else {
				FaultSymptom[7] = 0;
			}

			if (datas.getSdbdyc() == 1)
				FaultSymptom[8] = 500;
			else {
				FaultSymptom[8] = 0;
			}

			if (datas.getWsgswg() == 1)
				FaultSymptom[9] = 1000;
			else {
				FaultSymptom[9] = 0;
			}

			if (datas.getLqslld() == 1)
				FaultSymptom[10] = 3000;
			else {
				FaultSymptom[10] = 0;
			}

			if (datas.getZwwdyc() == 1)
				FaultSymptom[11] = 5000;
			else {
				FaultSymptom[11] = 0;
			}

			if (datas.getZzmfyc() == 1)
				FaultSymptom[12] = 10000;
			else {
				FaultSymptom[12] = 0;
			}

			if (datas.getWkgz() == 1)
				FaultSymptom[13] = 30000;
			else {
				FaultSymptom[13] = 0;
			}

			FaultSymptom[14] = 0;
			FaultSymptom[15] = 0;
			FaultSymptom[16] = 0;
			FaultSymptom[17] = 0;
			FaultSymptom[18] = 0;
		}
		return FaultSymptom;
	}

	/**
	 * 初始化故障征兆矩阵表
	 * 
	 * @return
	 */
	public void InitialFaultFeature() {

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

			rs1 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_RULE");
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
	public void Diagnosis(double FaultSymptom[], ArrayList<String> Faultnames) {
		Node root = nodes.get(0);
		for (int i = 0; i < root.children.size(); i++) {
			Node child = new Node();
			for (int j = 0; j < nodes.size(); j++)
				if (nodes.get(j).name.equals(root.children.get(i)))
					child = nodes.get(j);
			handle(child, FaultSymptom, Faultnames);
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
	private void handle(Node tasknode, double FaultSymptom[], ArrayList<String> Faultnames) {
		FaultFeature taskfeature = new FaultFeature();
		for (int i = 0; i < Faults.size(); i++) {
			if (Faults.get(i).name.equals(tasknode.name))
				taskfeature = Faults.get(i);
		}
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
			}

		} else {
			flag = 0;
			int tempm = 0;
			for (int i = 1; i < taskfeature.Feature.length; i++) {
				tempm += FaultSymptom[i] * taskfeature.Feature[i];
			}

			if (taskfeature.Threshold == 1) {
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

			if (taskfeature.Threshold == 10) {
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

			if (taskfeature.Threshold == 100) {
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

			if (taskfeature.Threshold == 1000) {
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

			if (taskfeature.Threshold == 10000) {
				int tempCre = tempm / 10000;
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
						handle(child, FaultSymptom, Faultnames);
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
	public static ArrayList<Fault> TSFaultsRead() {
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

			rs0 = stmt.executeQuery("SELECT * FROM BLH_FaultTree_FaultInfor order by ID");
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
/*
 * // 返回诊断结果正确与否的矩阵 // 正确返回1 // 错误返回-1 // 不操作返回0 public void
 * getFaultIsCorrect(int FaultIsCorrect[]) { for (int i = 0; i <
 * FaultIsCorrect.length; i++) { double temp = Math.random(); if (temp > 0.4)
 * FaultIsCorrect[i] = (temp > 0.7) ? 1 : (-1); } }
 */
/**
 * 修改底事件概率
 * 
 * @param Faultsname
 *            故障名称列表
 * @param FaultIsCorrect
 *            故障正确列表
 */
/*
 * public void modifyBottumP(ArrayList<String> Faultsname, int FaultIsCorrect[])
 * { // System.out.println("************************************"); for (int i =
 * 0; i < FaultIsCorrect.length; i++) { if (FaultIsCorrect[i] == 1) { for (int j
 * = 0; j < nodes.size(); j++) { if
 * (Faultsname.get(i).equals(nodes.get(j).name)) { Node temp = nodes.get(j); //
 * System.out.print(temp.freq + " ———— "); double y = temp.freq; double x =
 * myReverseFunction(y); x += dert; y = (double) ((int) (myFunction(x) * 100)) /
 * 100; temp.freq = y < 0.01 ? 0.01 : y; // System.out.print(temp.freq +
 * " ———— \n"); nodes.set(j, temp); } } } else if (FaultIsCorrect[i] == -1) {
 * for (int j = 0; j < nodes.size(); j++) { if
 * (Faultsname.get(i).equals(nodes.get(j).name)) { Node temp = nodes.get(j); //
 * System.out.print(temp.freq + " ———— "); double y = temp.freq; double x =
 * myReverseFunction(y); x -= dert; y = (double) ((int) (myFunction(x) * 100)) /
 * 100; temp.freq = y < 0.01 ? 0.01 : y; // System.out.print(temp.freq + "\n");
 * nodes.set(j, temp); } } } } //
 * System.out.println("************************************");
 * Change.write(nodes); }
 * 
 * public double myFunction(double x) { double y; y = 1 - Math.exp(-x); return
 * y; }
 * 
 * public double myReverseFunction(double y) { double x; x = -Math.log(1 - y);
 * return x; }
 * 
 * }
 */
