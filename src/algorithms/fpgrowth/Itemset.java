package algorithms.fpgrowth;

import java.util.List;

/**
 * 每一条频繁项集
 * @author lh
 * */
public class Itemset {
	private int support;//支持度
	private List<String> items;//频繁项集
	private int k;//k为items的长度
	
	public int getSupport() {
		return support;
	}

	public void setSupport(int support) {
		this.support = support;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public Itemset(List<String> items,int support){
		this.support = support;
		this.items = items;
		this.k = items.size();
		
	}
}
