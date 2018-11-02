package bll.diagnosis.tree.model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import bll.diagnosis.tree.GovXMLUtils;
import service.faulttree.BallValve.BallValvefaultBool;
import service.faulttree.Genmotor.GenMotorFault;
import service.faulttree.Governor.GovernorfaultBool;
import service.faulttree.MainTransformer.MainTransformerfaultBool;
import service.faulttree.pumptur.PumpturBFault;
import service.faulttree.pumptur.PumpturFFault;
import util.TimeUtils;

/**
 * 构造树的逻辑实现
 * 
 * @author
 *
 */
public class MakeFaultTree {

	private DefaultTreeModel faultTree;
	private DefaultMutableTreeNode root;
	private ArrayList<Node> nodes;
	private Long time;
	private int unitNo;
	private ArrayList<Node> equations;

	/**
	 * 
	 * @param equations
	 *            处理后的等式集
	 */
	public MakeFaultTree(ArrayList<Node> equations) {
		nodes = equations;
	}

	public MakeFaultTree(Long time, int unitNo, ArrayList<Node> equations) {
		super();
		this.time = time;
		this.unitNo = unitNo;
		this.equations = equations;
	}

	/**
	 * 递归实现树的构建
	 * 
	 * @param treeNode
	 *            树根节点
	 */
	public void makeTree(DefaultMutableTreeNode treeNode) {

		String name = (String) treeNode.getUserObject();
		Node node = searchChildren(name);

		if (node != null) {
			for (int i = 0; i < node.children.size(); i++) {
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(node.children.get(i));
				;
				treeNode.add(newNode);
				makeTree(newNode);
			}
		} else {
			node = new Node();
			node.name = name;
			node.gate = "*";
			nodes.add(node);
		}
	}

	/**
	 * 找出指定名称的子节点
	 * 
	 * @param name
	 *            节点名称
	 * @return 结点的子结点
	 */
	public Node searchChildren(String name) {

		int size = nodes.size();
		for (int i = 0; i < size; i++) {
			Node newNode = nodes.get(i);
			if (newNode.name.equals(name))
				return newNode;
		}
		return null;
	}

	/**
	 * 故障树获取
	 * 
	 * @return 故障树
	 */
	public DefaultTreeModel getFaultTree() {
		Node node = nodes.get(0);
		root = new DefaultMutableTreeNode(node.name);
		makeTree(root);
		faultTree = new DefaultTreeModel(root);
		return faultTree;
	}

	/**
	 * 清空节点
	 */
	public void clear() {
		nodes.clear();
	}

	public void setNodes(ArrayList<Node> equations) {
		nodes = equations;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	/**
	 * 节点信息初始化
	 * 
	 * @param Inodes
	 *            节点信息列表
	 */
	@SuppressWarnings("rawtypes")
	public static void InitialNodes(String system, ArrayList<Node> Inodes, String date, Integer unitNo) {

		// 读取水泵水轮机故障树XML文件
		if (system.equals("pum")) {
			String result = GovXMLUtils.GetXMLPath("PumpturSystemFaultTree");
			if (new File(result).exists()) {
				System.out.println("XML文档读取成功！");
				try {

					SAXReader reader = new SAXReader();
					Document document = reader.read(new File(result));
					Element rootElement = document.getRootElement();

					/**
					 * 得到第一层节点
					 */
					List list = rootElement.elements("WorkNode");
					Iterator iter = list.iterator();

					PumpturBFault pb = new PumpturBFault();// 查询bool型数据
					PumpturFFault fb = new PumpturFFault();// 查询float 型数据

					while (iter.hasNext()) {
						Element ele = (Element) iter.next();

						Node temp = new Node();
						temp.name = ele.attribute("Name").getValue();

						String[] childs = ele.attribute("children").getValue().split(",");
						for (int i = 0; i < childs.length; i++) {
							if (!childs[i].equals("null")) {
								temp.children.add(childs[i]);
							}
						}
						temp.gate = ele.attribute("gate").getValue();
						Long time = TimeUtils.StringtoLong(date);

						if (temp.name.equals("大轴摆度异常")) {
							temp.freq = pb.getAxleViFault(time, unitNo);

						} else if (temp.name.equals("动不平衡")) {
							temp.freq = pb.getUnbalance(time, unitNo);

						} else if (temp.name.equals("磁拉力不平衡")) {
							temp.freq = pb.getExCurrentFault(time, unitNo);

						} else if (temp.name.equals("上导摆度异常")) {
							temp.freq = pb.getUpguideFault(time, unitNo);

						} else if (temp.name.equals("下导摆度异常")) {
							temp.freq = pb.getLoguideFault(time, unitNo);
						} else if (temp.name.equals("轴承密封损坏")) {
							temp.freq = pb.getAxleSealFault(time, unitNo);
						} else if (temp.name.equals("冷却水流量低")) {
							temp.freq = fb.getWaterFLFault(time, unitNo);
						} else if (temp.name.equals("冷却水水温高")) {
							temp.freq = fb.getWaterTHFault(time, unitNo);
						} else if (temp.name.equals("冷却水水压异常")) {
							temp.freq = fb.getWaterPLFault(time, unitNo);
						} else if (temp.name.equals("油系统油压低")) {
							temp.freq = fb.getOilPLFault(time, unitNo);
						} else if (temp.name.equals("油系统油位异常")) {
							temp.freq = fb.getOilHFFault(time, unitNo);
						} else if (temp.name.equals("油系统油温高")) {
							temp.freq = fb.getOilTHFault(time, unitNo);
						} else if (temp.name.equals("油系统油混水")) {
							temp.freq = fb.getOilWWFault(time, unitNo);
						} else if (temp.name.equals("轴承振动异常")) {
							temp.freq = fb.getVibFault(time, unitNo);
						} 
						 else if (temp.name.equals("上机架振动异常")) {
							temp.freq = pb.getUpFrame(time, unitNo);
						} else if (temp.name.equals("下机架振动异常")) {
							temp.freq = pb.getLowFrame(time, unitNo);
						} else if (temp.name.equals("尾水管压力脉动")) {
							temp.freq = fb.getDraftPressure(time, unitNo);
						} else if (temp.name.equals("定子绕组固定不良")) {
							temp.freq = pb.getStatorFault(time, unitNo);
						} else if (temp.name.equals("循环油泵故障")) {
							temp.freq = (fb.getShuidaoPressure(time, unitNo)+fb.getShuidaoLevel(time, unitNo))/2;
						} else if (temp.name.equals("油泵轴承卡涩")) {
							temp.freq = pb.getOilPumpFault(time, unitNo);
						} else if (temp.name.equals("冷却器内部堵塞")) {
							temp.freq = (pb.getBearingBushHot(time, unitNo)+fb.getShuidaoPressure(time, unitNo)/2);
						} else if (temp.name.equals("轴瓦间隙不均")) {
							temp.freq = pb.getBearingBushHot(time, unitNo);
						} else if (temp.name.equals("回路故障")) {
							temp.freq = (fb.getOilPLFault(time, unitNo)+fb.getOilHFFault(time, unitNo))/2;
						} else if (temp.name.equals("弹簧故障")) {
							temp.freq = (fb.getMiFengMoSun(time, unitNo)+fb.getMiFengLiuLiang(time, unitNo))/2;
						} else if (temp.name.equals("减压阀故障")) {
							temp.freq = 1;
						} else if (temp.name.equals("过滤器堵塞")) {
							temp.freq = fb.getYaCha(time, unitNo);
						} 
						else if (temp.name.equals("冲洗电机故障")) {
							temp.freq = (fb.getZhuZhouYaLiL(time, unitNo));
						} else if (temp.name.equals("测压回路故障")) {
							temp.freq = fb.getZhuZhouBoDong(time, unitNo);
						} else if (temp.name.equals("管路进气")) {
							temp.freq = (fb.getMiGongLiuLiang(time, unitNo)+fb.getMiGongBoDong(time, unitNo))/2;
						} else if (temp.name.equals("流量异常")) {
							temp.freq = fb.getMiGongLiuLiang(time, unitNo);
						} else if (temp.name.equals("压力异常")) {
							temp.freq = fb.getMiGongYaLiH(time, unitNo);
						} else if (temp.name.equals("回路异常渗漏")) {
							temp.freq = (fb.getMiGongLiuLiang(time, unitNo)+fb.getMiGongYaLiL(time, unitNo))/2;
						}  else if (temp.name.equals("压力振荡")) {
							temp.freq = fb.getMiGongBoDong(time, unitNo);
						} 
						
						else {
							temp.freq = 0;
						}

						if (!ele.attribute("father").getValue().equals("null")) {
							temp.father = ele.attribute("father").getValue();
						}

						Inodes.add(temp);
					}
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
		}

		else if (system.equals("gov")) {
			String result = GovXMLUtils.GetXMLPath("SpeedRegulatingSystemFaultTree");
			System.out.println("文件读取成功！");
			if (new File(result).exists()) {
				try {

					SAXReader reader = new SAXReader();
					Document document = reader.read(new File(result));
					Element rootElement = document.getRootElement();

					/**
					 * 得到第一层节点
					 */
					List list = rootElement.elements("WorkNode");
					Iterator iter = list.iterator();

					GovernorfaultBool gn = new GovernorfaultBool();

					while (iter.hasNext()) {
						Element ele = (Element) iter.next();

						Node temp = new Node();
						temp.name = ele.attribute("Name").getValue();

						String[] childs = ele.attribute("children").getValue().split(",");
						for (int i = 0; i < childs.length; i++) {
							if (!childs[i].equals("null")) {
								temp.children.add(childs[i]);
							}
						}
						temp.gate = ele.attribute("gate").getValue();
						Long time = TimeUtils.StringtoLong(date);

						if (temp.name.equals("剪断销故障")) {
							temp.freq = gn.getShearpinfault(time, unitNo);
						} else if (temp.name.equals("集油箱油位偏高")) {
							temp.freq = gn.gettankoilhigh(time, unitNo);
						} else if (temp.name.equals("集油箱油位偏低")) {
							temp.freq = gn.gettankoillow(time, unitNo);
						} else if (temp.name.equals("压力油罐油位偏高")) {
							temp.freq = gn.getPressuretankoilhigh(time, unitNo);
						} else if (temp.name.equals("压力油罐油位偏低")) {
							temp.freq = gn.getPressuretankoillow(time, unitNo);
						} else if (temp.name.equals("压油罐漏气")) {
							temp.freq = 0.05;
						} else if (temp.name.equals("油系统漏油")) {
							temp.freq = 0.07;
						} else if (temp.name.equals("油泵效率低")) {
							temp.freq = 0.09;
						} else if (temp.name.equals("油泵不能正常开启")) {
							temp.freq = gn.OilPFailure(time, unitNo);
						} else {
							temp.freq = 0;
						}

						if (!ele.attribute("father").getValue().equals("null")) {
							temp.father = ele.attribute("father").getValue();
						}

						Inodes.add(temp);

					}

				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
		}
		// 球阀故障树
		else if (system.equals("blv")) {
			String result = GovXMLUtils.GetXMLPath("BallValveFaultTree");
			System.out.println("文件读取成功！");
			if (new File(result).exists()) {
				try {

					SAXReader reader = new SAXReader();
					Document document = reader.read(new File(result));
					Element rootElement = document.getRootElement();

					/**
					 * 得到第一层节点
					 */
					List list = rootElement.elements("WorkNode");
					Iterator iter = list.iterator();

					BallValvefaultBool bv = new BallValvefaultBool();

					while (iter.hasNext()) {
						Element ele = (Element) iter.next();

						Node temp = new Node();
						temp.name = ele.attribute("Name").getValue();

						String[] childs = ele.attribute("children").getValue().split(",");
						for (int i = 0; i < childs.length; i++) {
							if (!childs[i].equals("null")) {
								temp.children.add(childs[i]);
							}
						}
						temp.gate = ele.attribute("gate").getValue();
						Long time = TimeUtils.StringtoLong(date);

						if (temp.name.equals("油压偏低")) {
							temp.freq = bv.getPressuretankpressurelow(time, unitNo) < 0.1 ? 1.0
									: bv.getPressuretankpressurelow(time, unitNo);
						} else if (temp.name.equals("油位偏高")) {
							temp.freq = bv.gettankoilhigh(time, unitNo) < 0.1 ? 1.0 : bv.gettankoilhigh(time, unitNo);
						} else if (temp.name.equals("油位偏低")) {
							temp.freq = bv.gettankoillow(time, unitNo) < 0.1 ? 1.0 : bv.gettankoillow(time, unitNo);
						} else {
							temp.freq = 0;
						}

						if (!ele.attribute("father").getValue().equals("null")) {
							temp.father = ele.attribute("father").getValue();
						}

						Inodes.add(temp);

					}

				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
		}
		// 主变故障树
		else if (system.equals("mt")) {
			String result = GovXMLUtils.GetXMLPath("MainTransformerFaultTree");
			System.out.println("文件读取成功！");
			if (new File(result).exists()) {
				try {

					SAXReader reader = new SAXReader();
					Document document = reader.read(new File(result));
					Element rootElement = document.getRootElement();

					/**
					 * 得到第一层节点
					 */
					List list = rootElement.elements("WorkNode");
					Iterator iter = list.iterator();

					MainTransformerfaultBool mt = new MainTransformerfaultBool();

					while (iter.hasNext()) {
						Element ele = (Element) iter.next();

						Node temp = new Node();
						temp.name = ele.attribute("Name").getValue();

						String[] childs = ele.attribute("children").getValue().split(",");
						for (int i = 0; i < childs.length; i++) {
							if (!childs[i].equals("null")) {
								temp.children.add(childs[i]);
							}
						}
						temp.gate = ele.attribute("gate").getValue();
						Long time = TimeUtils.StringtoLong(date);

						if (temp.name.equals("冷却器故障")) {
							temp.freq = 1.0;
						} else if (temp.name.equals("交流电源故障")) {
							temp.freq = 1.0;
						} else if (temp.name.equals("冷却水泄漏报警")) {
							temp.freq = 1.0;
						} else {
							temp.freq = 0;
						}

						if (!ele.attribute("father").getValue().equals("null")) {
							temp.father = ele.attribute("father").getValue();
						}

						Inodes.add(temp);

					}

				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
		} else if (system.equals("gen")) {
			String result = GovXMLUtils.GetXMLPath("GenmotorSystemFaultTree");
			System.out.println("文件读取成功！");
			if (new File(result).exists()) {
				try {

					SAXReader reader = new SAXReader();
					Document document = reader.read(new File(result));
					Element rootElement = document.getRootElement();

					/**
					 * 得到第一层节点
					 */
					List list = rootElement.elements("WorkNode");
					Iterator iter = list.iterator();

					GenMotorFault gm = new GenMotorFault();

					while (iter.hasNext()) {
						Element ele = (Element) iter.next();

						Node temp = new Node();
						temp.name = ele.attribute("Name").getValue();

						String[] childs = ele.attribute("children").getValue().split(",");
						for (int i = 0; i < childs.length; i++) {
							if (!childs[i].equals("null")) {
								temp.children.add(childs[i]);
							}
						}
						temp.gate = ele.attribute("gate").getValue();
						Long time = TimeUtils.StringtoLong(date);

						if (temp.name.equals("发电机转频过高")) {
							temp.freq = gm.getRotateFFault(time, unitNo);
						} else if (temp.name.equals("空冷器故障")) {
							temp.freq = gm.getACoolerFault(time, unitNo);
						} else if (temp.name.equals("转子绝缘损坏")) {
							temp.freq = gm.getRoInsulationFault(time, unitNo);
						} else if (temp.name.equals("转频振动")) {
							temp.freq = gm.getZhuanPin(time, unitNo);
						} else if (temp.name.equals("极频振动")) {
							temp.freq = gm.getJiPin(time, unitNo);
						} else if (temp.name.equals("励磁电源故障")) {
							temp.freq = gm.getExcitePowerFault(time, unitNo);
						} else if (temp.name.equals("风扇故障")) {
							temp.freq = gm.getFanFault(time, unitNo);
						} else {
							temp.freq = 0;
						}

						if (!ele.attribute("father").getValue().equals("null")) {
							temp.father = ele.attribute("father").getValue();
						}

						Inodes.add(temp);

					}

				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
		}

		Node temp = Inodes.get(0);
		Inodes.set(0, Inodes.get(1));
		Inodes.set(1, temp);

		for (int i = 0; i < Inodes.size(); i++) {
			if (Inodes.get(i).father == null) {
				Node tempn = Inodes.get(0);
				Inodes.set(0, Inodes.get(i));
				Inodes.set(i, tempn);
			}
		}
	}

	/**
	 * 将Document对象保存为一个xml文件到本地
	 * 
	 * @param document
	 *            需要保存的document对象
	 * @param filename
	 *            保存的文件名
	 * @return true:保存成功 flase:失败
	 */
	public static boolean doc2XmlFile(Document document, String filename) {
		boolean flag = true;
		try {
			/* 将document中的内容写入文件中 */
			// 默认为UTF-8格式，指定为"UTF-8"
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			XMLWriter writer = new XMLWriter(new FileWriter(new File(filename)), format);
			writer.write(document);
			writer.close();
		} catch (Exception ex) {
			flag = false;
			ex.printStackTrace();
		}
		return flag;
	}

	public Long getTime() {
		return time;
	}

	public int getUnitNo() {
		return unitNo;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public void setUnitNo(int unitNo) {
		this.unitNo = unitNo;
	}

	public ArrayList<Node> getEquations() {
		return equations;
	}

	public void setEquations(ArrayList<Node> equations) {
		this.equations = equations;
	}

}
