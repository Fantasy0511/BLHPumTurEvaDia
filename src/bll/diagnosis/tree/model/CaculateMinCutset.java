package bll.diagnosis.tree.model;

import java.util.ArrayList;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * 计算故障树最小割集
 * 
 * @author 肖汉、付文龙
 * 
 */
public class CaculateMinCutset {

	private DefaultTreeModel faultTree;
	private DefaultMutableTreeNode root;
	private ArrayList<Node> nodes;

	/**
	 * 构造CaculateMinCutset类
	 * 
	 * @param nodeList
	 *            节点列表
	 * @param model
	 *            故障树
	 */
	public CaculateMinCutset(ArrayList<Node> nodeList, DefaultTreeModel model) {
		nodes = nodeList;
		faultTree = model;
		root = (DefaultMutableTreeNode) faultTree.getRoot();
	}

	/**
	 * 生成树节点
	 * 
	 * @param name
	 *            故障名称
	 * @return 故障树节点
	 */
	public DefaultMutableTreeNode getDestNode(String name) {
		DefaultMutableTreeNode nextLeaf = root.getFirstLeaf();
		while (nextLeaf != null) {
			if (name.equals((String) nextLeaf.getUserObject()))
				return nextLeaf;
			else
				nextLeaf = nextLeaf.getNextLeaf();
		}
		return null;
	}

	/**
	 * 合并两个节点矩阵
	 * 
	 * @param array1
	 *            节点矩阵1
	 * @param array2
	 *            节点矩阵2
	 * @return 合并后的节点矩阵
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<ArrayList<DefaultMutableTreeNode>> deepMultiply(
			ArrayList<ArrayList<DefaultMutableTreeNode>> array1,
			ArrayList<ArrayList<DefaultMutableTreeNode>> array2) {
		ArrayList<ArrayList<DefaultMutableTreeNode>> newArray = new ArrayList<ArrayList<DefaultMutableTreeNode>>();
		for (int i = 0; i < array2.size(); i++) {
			ArrayList<DefaultMutableTreeNode> nodes2 = (ArrayList<DefaultMutableTreeNode>) array2
					.get(i).clone();
			for (int j = 0; j < array1.size(); j++) {
				ArrayList<DefaultMutableTreeNode> nodes1 = (ArrayList<DefaultMutableTreeNode>) array1
						.get(j).clone();
				nodes1.addAll(nodes1.size(), nodes2);
				newArray.add(nodes1);
			}

		}
		return newArray;
	}

	/**
	 * 合并两个节点序列
	 * 
	 * @param array1
	 *            节点序列1
	 * @param array2节点序列2
	 * @return 合并后的节点序列
	 */
	public ArrayList<DefaultMutableTreeNode> multiply(
			ArrayList<DefaultMutableTreeNode> nodes1,
			ArrayList<DefaultMutableTreeNode> nodes2) {
		ArrayList<DefaultMutableTreeNode> newNode = nodes1;
		newNode.addAll(nodes1.size(), nodes2);
		return newNode;
	}

	/**
	 * 合并两个节点矩阵
	 * 
	 * @param array1
	 *            节点矩阵1
	 * @param array2
	 *            节点矩阵2
	 * @return 合并后的节点矩阵
	 */
	public ArrayList<ArrayList<DefaultMutableTreeNode>> plus(
			ArrayList<ArrayList<DefaultMutableTreeNode>> array1,
			ArrayList<ArrayList<DefaultMutableTreeNode>> array2) {
		ArrayList<ArrayList<DefaultMutableTreeNode>> newArray = array1;
		newArray.addAll(array1.size(), array2);
		return newArray;
	}

	/**
	 * 计算最小割集
	 * 
	 * @param node
	 *            树节点
	 * @return 最小割集节点矩阵
	 */
	public ArrayList<ArrayList<DefaultMutableTreeNode>> caculate(
			DefaultMutableTreeNode node) {
		int childcount = node.getChildCount();
		String gate = getGate(node);
		ArrayList<ArrayList<DefaultMutableTreeNode>> newArray = new ArrayList<ArrayList<DefaultMutableTreeNode>>();
		if (childcount > 0) {
			newArray = caculate((DefaultMutableTreeNode) node.getChildAt(0));
			for (int i = 1; i < childcount; i++) {
				ArrayList<ArrayList<DefaultMutableTreeNode>> array = caculate((DefaultMutableTreeNode) node
						.getChildAt(i));
				if (gate.equals("+"))
					newArray = plus(newArray, array);
				else
					newArray = deepMultiply(newArray, array);
			}
		} else {
			ArrayList<DefaultMutableTreeNode> array = new ArrayList<DefaultMutableTreeNode>();
			array.add(node);
			newArray.add(array);
		}
		return newArray;
	}

	/**
	 * 获取节点处理方式信息
	 * 
	 * @param node
	 *            树节点
	 * @return 节点的处理方式
	 */
	public String getGate(DefaultMutableTreeNode node) {
		String name = (String) node.getUserObject();
		for (int i = 0; i < nodes.size(); i++) {
			Node newNode = nodes.get(i);
			if (name.equals(newNode.name)) {
				return newNode.gate;
			}
		}
		return "*";
	}

	public void setNodes(ArrayList<Node> equations) {
		nodes = equations;
	}

	/**
	 * 获取树节点矩阵
	 * 
	 * @return 树节点矩阵
	 */
	public ArrayList<ArrayList<DefaultMutableTreeNode>> getResult() {
		ArrayList<ArrayList<DefaultMutableTreeNode>> array;
		array = caculate(root);
		return array;
	}

	// 计算任意一个节点概率，要求节点不会重复出现
	/**
	 * 计算节点故障概率
	 * 
	 * @param name
	 *            故障名称
	 * @return 故障概率
	 */
	public double CalculateP(String name) {
		double calp = 0;
		Node tasknode = new Node();
		int i;
		for (i = 0; i < nodes.size(); i++) {
			if (name.equals(nodes.get(i).name)) {
				tasknode = nodes.get(i);
				break;
			}
		}
		calp = CalculateP(tasknode, nodes);

		return calp;
	}

	// 计算概率基本函数
	/**
	 * 计算节点故障概率
	 * 
	 * @param Node
	 *            树节点
	 * @param Pnodes
	 *            节点列表
	 * @return 节点故障概率
	 */
	private double CalculateP(Node Node, ArrayList<Node> Pnodes) {
		double calp = 0;
		double tempcalp[] = new double[Node.children.size()];
		double temp = 1;
		int i, j;
		if (Node.children.size() != 0) {
			for (i = 0; i < Node.children.size(); i++) {
				j = 0;
				while (!Pnodes.get(j).name.equals(Node.children.get(i)))
					j++;
				tempcalp[i] = CalculateP(Pnodes.get(j), Pnodes);
			}

			if (Node.gate.equals("+")) {
				for (j = 0; j < Node.children.size(); j++) {
					temp *= 1 - tempcalp[j];
				}
				calp = 1 - temp;
			} else {
				for (j = 0; j < Node.children.size(); j++) {
					temp *= tempcalp[j];
				}
				calp = temp;
			}
			// Node.freq = calp;
		} else {
			calp = Node.freq;
		}

		return calp;
	}

	// 计算底事件概率重要度
	/**
	 * 计算底事件概率重要度
	 * 
	 * @param name
	 *            故障名称
	 * @return 概率重要度
	 */
	public double CalculateIP(String name) {
		double calp = 0;
		ArrayList<Node> IPnodes1 = new ArrayList<Node>();
		ArrayList<Node> IPnodes0 = new ArrayList<Node>();
		Node IPnode1 = new Node();
		Node IPnode0 = new Node();
		int i;
		for (i = 0; i < nodes.size(); i++) {
			if (name.equals(nodes.get(i).name)) {
				IPnode1.children = nodes.get(i).children;
				IPnode0.children = nodes.get(i).children;
				IPnode1.gate = nodes.get(i).gate;
				IPnode0.gate = nodes.get(i).gate;
				IPnode1.name = nodes.get(i).name;
				IPnode0.name = nodes.get(i).name;
				// IPnode1.Num = nodes.get(i).Num;
				// IPnode0.Num = nodes.get(i).Num;
				IPnode1.freq = 1;
				IPnode0.freq = 0;
				IPnodes1.add(IPnode1);
				IPnodes0.add(IPnode0);
				// break;
			} else {
				IPnodes1.add(nodes.get(i));
				IPnodes0.add(nodes.get(i));
			}
			// System.out.println(nodes.get(i).freq);
		}
		calp = CalculateP(IPnodes1.get(0), IPnodes1)
				- CalculateP(IPnodes0.get(0), IPnodes0);
		return calp;
	}

	// 计算底事件结构重要度
	/**
	 * 计算底事件结构重要度
	 * 
	 * @param name
	 *            故障名称
	 * @return 结构重要度
	 */
	public double CalculateIPStructure(String name) {
		double calp = 0;
		ArrayList<Node> IPnodes1 = new ArrayList<Node>();
		ArrayList<Node> IPnodes0 = new ArrayList<Node>();
		Node IPnode1 = new Node();
		Node IPnode0 = new Node();
		int i, j;
		for (i = 0; i < nodes.size(); i++) {
			if (name.equals(nodes.get(i).name)) {
				IPnode1.children = nodes.get(i).children;
				IPnode0.children = nodes.get(i).children;
				IPnode1.gate = nodes.get(i).gate;
				IPnode0.gate = nodes.get(i).gate;
				IPnode1.name = nodes.get(i).name;
				IPnode0.name = nodes.get(i).name;
				// IPnode1.Num = nodes.get(i).Num;
				// IPnode0.Num = nodes.get(i).Num;
				IPnode1.freq = 1;
				IPnode0.freq = 0;
				IPnodes1.add(IPnode1);
				IPnodes0.add(IPnode0);
				// break;
			} else {
				Node IPnode = new Node();
				for (j = 0; j < nodes.get(i).children.size(); j++) {
					IPnode.children.add(nodes.get(i).children.get(j));
				}
				IPnode.gate = nodes.get(i).gate;
				IPnode.name = nodes.get(i).name;
				// IPnode.Num = nodes.get(i).Num;
				// IPnode.freq = nodes.get(i).freq;
				IPnode.freq = 0.5;
				IPnodes1.add(IPnode);
				IPnodes0.add(IPnode);
			}
			// System.out.println(nodes.get(i).freq);
		}
		calp = CalculateP(IPnodes1.get(0), IPnodes1)
				- CalculateP(IPnodes0.get(0), IPnodes0);
		;
		return calp;
	}

	// 计算底事件关键重要度
	/**
	 * 计算底事件关键重要度
	 * 
	 * @param name
	 *            故障名称
	 * @return 关键重要度
	 */
	public double CalculateIPKey(String name) {
		double calp = 0;
		int i = 0;
		for (i = 0; i < nodes.size(); i++) {
			if (name.equals(nodes.get(i).name)) {
				calp = nodes.get(i).freq * CalculateIP(name)
						/ CalculateP(nodes.get(0).name);
			}
		}
		return calp;
	}

	/**
	 * 计算底事件个数
	 * 
	 * @param BottomEvents
	 *            底事件名称列表
	 * @param BottomIPK
	 *            底事件概率列表
	 * @return 底事件个数
	 */
	public int BottomEventSort(String BottomEvents[], double BottomIPK[]) {
		int num = 0, i, j;
		for (i = 0; i < nodes.size(); i++) {
			// if(nodes.get(i).gate == null)
			if (nodes.get(i).children.size() == 0) {
				BottomEvents[num] = nodes.get(i).name;
				BottomIPK[num] = CalculateIPKey(nodes.get(i).name);
				num++;
			}
		}
		for (i = 0; i < num; i++) {
			for (j = i + 1; j < num; j++) {
				if (BottomIPK[j] > BottomIPK[i]) {
					double tempi = BottomIPK[j];
					String tempb = BottomEvents[j];
					BottomIPK[j] = BottomIPK[i];
					BottomEvents[j] = BottomEvents[i];
					BottomIPK[i] = tempi;
					BottomEvents[i] = tempb;
				}

			}
		}
		return num;
	}

	// 将诊断结果按关键重要度大小排序生成序列
	/**
	 * 底事件降序排列
	 * 
	 * @param BottomEvents
	 *            底事件名称列表
	 * @param BottomIPK
	 *            底事件概率列表
	 */
	public void FaultsSort(ArrayList<String> Faultsname, double FaultsIPK[]) {
		int num = 0, i, j;
		for (i = 0; i < Faultsname.size(); i++) {
			FaultsIPK[i] = CalculateIPKey(Faultsname.get(i));
			// System.out.println(Faultnames.get(i)+":"+BottomIPK[i]);
		}
		for (i = 0; i < Faultsname.size(); i++) {
			for (j = i + 1; j < Faultsname.size(); j++) {
				if (FaultsIPK[j] > FaultsIPK[i]) {
					double temp = FaultsIPK[j];
					String tempbi = Faultsname.get(i);
					String tempbj = Faultsname.get(j);
					FaultsIPK[j] = FaultsIPK[i];
					FaultsIPK[i] = temp;
					Faultsname.set(j, tempbi);
					Faultsname.set(i, tempbj);
				}

			}
		}

	}

	// 将底事件按关键重要度大小排序生成序列
	/**
	 * 底事件名称获取
	 * 
	 * @return 底事件名称列表
	 */
	public static List<String> getBottomEvent() {
		ArrayList<Node> testnodes = new ArrayList<Node>();
		MakeFaultTree.InitialNodes(testnodes);
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < testnodes.size(); i++) {
			// if(nodes.get(i).gate == null)
			if (testnodes.get(i).children.size() == 0) {
				result.add(testnodes.get(i).name);
			}
		}

		return result;
	}

	// 利用最小割集近似求顶事件概率
	/**
	 * 底事件概率估计
	 * 
	 * @param MinCutset
	 *            节点矩阵
	 * @return 概率
	 */
	public double EstimateP(
			ArrayList<ArrayList<DefaultMutableTreeNode>> MinCutset) {
		double EstimateP = 0;
		double temp = 1;
		double esptemp[] = new double[MinCutset.size()];
		int i, j;
		for (i = 0; i < MinCutset.size(); i++) {
			esptemp[i] = 1;
			for (j = 0; j < MinCutset.get(i).size(); j++) {
				int k = 0;
				while (!nodes.get(k).name.equals((String) (MinCutset.get(i)
						.get(j).getUserObject()))) {
					k++;
				}
				esptemp[i] *= nodes.get(k).freq;
			}
			temp *= 1 - esptemp[i];
		}

		EstimateP = 1 - temp;

		return EstimateP;
	}

	public static void main(String[] args) {
		List<String> result = CaculateMinCutset.getBottomEvent();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
