package algorithms.apriori;

import java.util.List;

/**
 * 项集
 * 
 * @author wuyue
 *
 */
public class Itemset extends AbstractOrderedItemset {
	// 项集
	public int[] itemset;
	// 支持度计数
	public int support = 0;

	public int[] getItems() {
		return itemset;
	}

	public Itemset() {
		this.itemset = new int[] {};
	}

	public Itemset(int item) {
		itemset = new int[] { item };
	}

	public Itemset(int[] items) {
		this.itemset = items;
	}

	public Itemset(List<Integer> itemset, int support) {
		this.itemset = new int[itemset.size()];
		int i = 0;
		for (Integer item : itemset) {
			this.itemset[i++] = item.intValue();
		}
		this.support = support;
	}

	@Override
	public int getAbsoluteSupport() {
		return support;
	}

	public void setAbsoluteSupport(int support) {
		this.support = support;
	}

	@Override
	public int size() {
		return itemset.length;
	}

	@Override
	public Integer get(int position) {
		return itemset[position];
	}

	/**
	 * Increase the support of this itemset by 1
	 */
	public void increaseTransactionCount() {
		this.support++;
	}

	public Itemset cloneItemSetMinusOneItem(Integer itemToRemove) {
		// create the new itemset
		int[] newItemset = new int[itemset.length - 1];
		int i = 0;
		// for each item in this itemset
		for (int j = 0; j < itemset.length; j++) {
			// copy the item except if it is the item that should be excluded
			if (itemset[j] != itemToRemove) {
				newItemset[i++] = itemset[j];
			}
		}
		return new Itemset(newItemset); // return the copy
	}

	public Itemset intersection(Itemset itemset2) {
		int[] intersection = ArraysAlgos
				.intersectTwoSortedArrays(this.getItems(), itemset2.getItems());
		return new Itemset(intersection);
	}
}
