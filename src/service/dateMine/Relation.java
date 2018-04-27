package service.dateMine;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import algorithms.fpgrowth.DataDiscrete;
import algorithms.fpgrowth.FPTree;
import algorithms.fpgrowth.FPTree.TNode;
import service.dateMine.bean.Links;
import util.PathUtil;

/**
 * 数据关联分析服务类，提供前台展示所需数据
 * 
 * @author lh
 */
public class Relation {

	public static void main(String[] args) throws IOException {
		Relation relation = new Relation();
		// relation.getNodes("Pum");
		// FPTree fptree = new FPTree(0.6);
		// List<List<String>> transactions = fptree.loadTransaction(
		// "C:\\Users\\Administrator\\Desktop\\trolley.txt");
		// // 构建头项表/BLHPumTurEvaDia/src/trolley.txt
		// List<TNode> headerTable = fptree.buildHeaderTable(transactions);
		// TNode tree = fptree.bulidFP_tree(headerTable, transactions);
		// List<String> links = new ArrayList<>();
		// DataDiscrete discrete = new DataDiscrete();
		// links = relation.getLinks(tree, links, discrete);
		// for (String s : links) {
		// System.out.println(s);
		// }

		//relation.getLinks("ball", 0.7);
	}

	/**
	 * 获取频繁项集的节点
	 * 
	 * @param system
	 *            选取的子系统
	 * @param confidence
	 *            置信度，建议大于0.6
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<node> getNodes(String system, double confidence)
			throws IOException, ClassNotFoundException, SQLException {
		FPTree fptree = new FPTree(confidence);
		System.out.println(PathUtil.getWebRealBasePath());
		// List<List<String>> transactions = fptree
		// .loadTransaction("src/items_" + system + ".txt");
		List<List<String>> transactions = fptree
				.loadTransaction(PathUtil.getWebRealBasePath() + "data/items_"
						+ system + ".txt");
		List<node> nodes = new ArrayList<node>(); // 顺序存储每个节点
		// 构建头项表
		List<TNode> headerTable = fptree.buildHeaderTable(transactions);
		int size = transactions.size();
		DataDiscrete discrete = new DataDiscrete();
		for (TNode head : headerTable) { // 遍历得到每个node
			String des = discrete
					.restoreID(Integer.parseInt(head.getItemName()));
			// 这里的name为空
			String name = des.split("  ")[1];
			String id = head.getItemName();
			int count = (int) Math.ceil(head.getCount()/(double)size*15);
			int category = 0;
			// 正则判断name属于哪个类
			if (Pattern.matches(".*4号机组.*", name)) {
				category = 4;
			} else if (Pattern.matches(".*3号机组.*", name)) {
				category = 3;
			} else if (Pattern.matches(".*2号机组.*", name)) {
				category = 2;
			} else if (Pattern.matches(".*1号机组.*", name)) {
				category = 1;
			}
			nodes.add(new node(name, id, count, category));
		}
		return nodes;
	}

	/**
	 * 在往上封装一层，只保留输入system和置信度
	 * 
	 * @param system
	 *            输入子系统
	 * @param confidence
	 *            置信度，建议大于0.6
	 * @return List<String> Links 其中String为source+" "+target
	 */
	public List<Links> getLinks(String system, double confidence) {
		FPTree fptree = new FPTree(confidence);
		System.out.println(PathUtil.getWebRealBasePath());
		List<List<String>> transactions = fptree
				.loadTransaction(PathUtil.getWebRealBasePath() + "data/items_"
						+ system + ".txt");
		// List<List<String>> transactions = fptree
		// .loadTransaction("src/items_" + system + ".txt");
		// 构建头项表
		List<TNode> headerTable = fptree.buildHeaderTable(transactions);
		TNode tree = fptree.bulidFP_tree(headerTable, transactions);
		List<Links> links = new ArrayList<>();
		links = getLinks(tree, links);
		return links;
	}

	/**
	 * 根据输入的FPtree生成link关系
	 * 
	 * @param FPtree
	 * @return List<String> String为source+" "+target
	 */
	public List<Links> getLinks(TNode tree, List<Links> links) {
		if (tree.getChildren() == null || tree.getChildren().size() == 0) {
			return links;
		}
		for (TNode children : tree.getChildren()) {
			if (tree.getItemName() != null) {
				String source = tree.getItemName();
				String target = children.getItemName();
				Links link = new Links(source, target);
				links.add(link);
			}
			links = getLinks(children, links);
		}
		return links;
	}

	
	public class node {
		private String name;
		private String id;
		private int size;
		private double x;
		private double y;
		private int category; // 0对应全厂 1~4对应1~4号机组

		public node(String name, String id, int count, int category) {
			this.name = filterName(name);
			this.id = id;
			this.size = count;
			this.category = category;
		}

		public String filterName(String name){
			String regEx = "统计数据\\.|运行参数\\.|虚设备\\.|电气参数\\.";
			Pattern p = Pattern.compile(regEx);
		    Matcher m = p.matcher(name);
		    if (m.find()) {
		    	name = m.replaceAll("");
		    }
		    return name;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getCategory() {
			return category;
		}

		public void setCategory(int category) {
			this.category = category;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}
	}

}
