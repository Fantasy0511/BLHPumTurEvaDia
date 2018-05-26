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
import service.faulttree.pumptur.PumpturBFault;
import service.faulttree.pumptur.PumpturFFault;
import util.TimeUtils;

/**
 * 构造树的逻辑实现
 * 
 * @author 肖汉、付文龙
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
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
						node.children.get(i));
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
	public static void InitialNodes(ArrayList<Node> Inodes, String date,
			Integer unitNo) {

		String result = GovXMLUtils.GetXMLPath("PumpturSystemFaultTree");
		if (new File(result).exists()) {
			System.out.println("123");
			try {

				SAXReader reader = new SAXReader();
				Document document = reader.read(new File(result));
				Element rootElement = document.getRootElement();

				/**
				 * 得到第一层节点
				 */
				List list = rootElement.elements("WorkNode");
				Iterator iter = list.iterator();

				PumpturBFault pb = new PumpturBFault();
				PumpturFFault fb = new PumpturFFault();
				while (iter.hasNext()) {
					Element ele = (Element) iter.next();

					Node temp = new Node();
					temp.name = ele.attribute("Name").getValue();

					String[] childs = ele.attribute("children").getValue()
							.split(",");
					for (int i = 0; i < childs.length; i++) {
						if (!childs[i].equals("null")) {
							temp.children.add(childs[i]);
						}
					}
					temp.gate = ele.attribute("gate").getValue();
					Long time = TimeUtils.StringtoLong(date);
					if (temp.name == "大轴摆度异常") {
						temp.freq = pb.getAxleViFault(time, unitNo);
					} else if (temp.name == "冷却水异常") {
						temp.freq = pb.getCWaterFault(time, unitNo);
					} else if (temp.name == "油系统异常") {
						temp.freq = pb.getOilFault(time, unitNo);
					} else if (temp.name == "动不平衡") {
						temp.freq = pb.getUnbalance(time, unitNo);
					} else if (temp.name == "励磁电流不平衡") {
						temp.freq = pb.getExCurrentFault(time, unitNo);
					} else if (temp.name == "剪断销故障") {
						temp.freq = pb.getBreakpinFault(time, unitNo);
					} else if (temp.name == "上导摆度异常") {
						temp.freq = pb.getUpguideFault(time, unitNo);
					} else if (temp.name == "下导摆度异常") {
						temp.freq = pb.getLoguideFault(time, unitNo);
					} else if (temp.name == "水导摆度异常") {
						temp.freq = pb.getWguideFault(time, unitNo);
					} else if (temp.name == "尾水管水位过高") {
						temp.freq = pb.getExWPipeFault(time, unitNo);
					} else if (temp.name == "冷却水流量低") {
						temp.freq = pb.getCoolWLow(time, unitNo);
					} else if (temp.name == "轴瓦温度") {
						temp.freq = pb.getBearingBushHot(time, unitNo);
					} else if (temp.name == "主轴密封") {
						temp.freq = pb.getAxleSealFault(time, unitNo);
					} else if (temp.name == "蜗壳故障") {
						temp.freq = pb.getVoluteFault(time, unitNo);
					} else if (temp.name == "迷宫环温度异常") {
						temp.freq = fb.getMgTFault(time, unitNo);
					} else if (temp.name == "轴承振摆异常") {
						temp.freq = fb.getBearingVFault(time, unitNo);
					} else {
						temp.freq = 0;
					}

					// temp.freq =
					// Double.parseDouble(ele.attribute("NodeType").getValue());
					if (!ele.attribute("father").getValue().equals("null")) {
						temp.father = ele.attribute("father").getValue();
					}

					Inodes.add(temp);
				}

			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			XMLWriter writer = new XMLWriter(new FileWriter(new File(filename)),
					format);
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
