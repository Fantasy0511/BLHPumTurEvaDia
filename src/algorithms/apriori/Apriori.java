package algorithms.apriori;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Apriori频繁项集挖掘
 * 
 * @author wuyue
 *
 */
public class Apriori {
	protected int k;
	// candidateCount 候选项集
	protected int totalCandidateCount = 0;
	protected long startTimestamp;
	protected long endTimestamp;
	private int itemsetCount;
	private int databaseSize;

	// 最小支持度设置=minsup*databasesize(事务的条数)
	private int minsupRelative;
	// database中每一个记录代表一条事务,文件读取或者数据库读取
	private List<int[]> database = null;
	protected Itemsets patterns = null;
	BufferedWriter writer = null;

	public Apriori() {
		super();
	}

	/**
	 * 运行Apriori频繁项集挖掘
	 * 
	 * @param minsup
	 *            最小支持度为百分数=支持度计数/事物总数
	 * @param database
	 *            数据集合database
	 * @param output
	 *            输出文件path，若没有为null
	 * @return
	 * @throws IOException
	 */
	public Itemsets runAPriori(double minsup, List<int[]> database, String output)
			throws IOException {
		if (output == null) {
			writer = null;
			patterns = new Itemsets("Frequent Items");
		} else {
			patterns = null;
			writer = new BufferedWriter(new FileWriter(output));
		}

		startTimestamp = System.currentTimeMillis();
		itemsetCount = 0;
		totalCandidateCount = 0;
		// 记录事务的数目
		databaseSize = database.size();
		// 利用map记录每条项集的出现次数,key:项集value：支持度计数
		Map<Integer, Integer> mapItemCount = new HashMap<>();
		// 扫描数据库每一行代表一条事务（line）
		// 循环直到最后
		for(int i=0;i<databaseSize;i++){
			for(int n=0;n<database.get(i).length;n++){
				Integer item = database.get(i)[n];
				Integer count = mapItemCount.get(item); //hasmap存放每个项集的支持度计数
				if (count == null) {
					mapItemCount.put(item, 1);
				} else {
					mapItemCount.put(item, ++count);
				}
			}
			
		}
		// 很明显最小项集支持度计算
		this.minsupRelative = (int) Math.ceil(minsup * databaseSize);
		// k=1 开始产生候选1-项集
		k = 1;
		List<Integer> frequent1 = new ArrayList<>();
		for (Entry<Integer, Integer> entry : mapItemCount.entrySet()) {// 遍历map
			if (entry.getValue() >= minsupRelative) {
				frequent1.add(entry.getKey());
				// ****** 保存 ******************************
				saveItemsetToFile(entry.getKey(), entry.getValue());
			}
		}

		Collections.sort(frequent1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});

		if (frequent1.size() == 0) {
			if (writer != null) {
				writer.close();
			}
			return patterns;
		}
		totalCandidateCount += frequent1.size();
		// 循环开始挖掘频繁项集k>2的,直到候选项集为0
		List<Itemset> level = null;
		k = 2;
		do {
			List<Itemset> candidateK;
			if (k == 2) {
				candidateK = generateCandidate2(frequent1);
			} else {
				candidateK = generateCandidateSizeK(level);
			}

			totalCandidateCount += candidateK.size();
			for (int[] transaction : database) {
				if (transaction.length < k) {
					continue;
				}
				loopCand: for (Itemset candidate : candidateK) {
					// a variable that will be use to check if
					// all items of candidate are in this transaction
					int pos = 0;
					// for each item in this transaction
					for (int item : transaction) {
						// if the item correspond to the current item of
						// candidate
						if (item == candidate.itemset[pos]) {
							// we will try to find the next item of candidate
							// next
							pos++;
							// if we found all items of candidate in this
							// transaction
							if (pos == candidate.itemset.length) {
								// we increase the support of this candidate
								candidate.support++;
								continue loopCand;
							}
							// Because of lexical order, we don't need to
							// continue scanning the transaction if the current
							// item
							// is larger than the one that we search in
							// candidate.
						} else if (item > candidate.itemset[pos]) {
							continue loopCand;
						}

					}
				}
			}

			level = new ArrayList<Itemset>();
			for (Itemset candidate : candidateK) {
				// if the support is > minsup
				if (candidate.getAbsoluteSupport() >= minsupRelative) {
					// add the candidate
					level.add(candidate);
					// the itemset is frequent so save it into results
					saveItemset(candidate);
				}
			}
			// we will generate larger itemsets next.
			k++;
		} while (level.isEmpty() == false);

		if (writer != null) {
			writer.close();
		}

		endTimestamp = System.currentTimeMillis();
		return patterns;
	}
	/**
	 * 运行Apriori频繁项集挖掘
	 * 
	 * @param minsup
	 *            最小支持度为百分数=支持度计数/事物总数
	 * @param input
	 *            输入文件path
	 * @param output
	 *            输出文件path，若没有为null
	 * @return
	 * @throws IOException
	 */
	public Itemsets runAPriori(double minsup, String input, String output)
			throws IOException {
		if (output == null) {
			writer = null;
			patterns = new Itemsets("Frequent Items");
		} else {
			patterns = null;
			writer = new BufferedWriter(new FileWriter(output));
		}

		startTimestamp = System.currentTimeMillis();
		itemsetCount = 0;
		totalCandidateCount = 0;
		// 记录事务的数目
		databaseSize = 0;
		// 利用map记录每条项集的出现次数,key:项集value：支持度计数
		Map<Integer, Integer> mapItemCount = new HashMap<>();
		database = new ArrayList<int[]>();
		// 扫描数据库每一行代表一条事务（line）
		BufferedReader reader = new BufferedReader(new FileReader(input));
		String line;
		// 循环直到最后
		while ((line = reader.readLine()) != null) {
			String[] lineSpited = line.split(" ");
			int[] transaction = new int[lineSpited.length];
			for (int i = 0; i < transaction.length; i++) {
				Integer item = Integer.parseInt(lineSpited[i]);
				transaction[i] = item;
				Integer count = mapItemCount.get(item);
				if (count == null) {
					mapItemCount.put(item, 1);
				} else {
					mapItemCount.put(item, ++count);
				}
			}
			database.add(transaction);
			databaseSize++;
		}
		reader.close();
		System.out.println("构建database完成");
		// 很明显最小项集支持度计算
		this.minsupRelative = (int) Math.ceil(minsup * databaseSize);
		// k=1 开始产生候选1-项集
		k = 1;
		List<Integer> frequent1 = new ArrayList<>();
		for (Entry<Integer, Integer> entry : mapItemCount.entrySet()) {
			if (entry.getValue() >= minsupRelative) {
				frequent1.add(entry.getKey());
				// ****** 保存 ******************************
				saveItemsetToFile(entry.getKey(), entry.getValue());
			}
		}

		Collections.sort(frequent1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});

		if (frequent1.size() == 0) {
			if (writer != null) {
				writer.close();
			}
			return patterns;
		}
		totalCandidateCount += frequent1.size();
		// 循环开始挖掘频繁项集k>2的,直到候选项集为0
		List<Itemset> level = null;
		k = 2;
		do {
			List<Itemset> candidateK;
			if (k == 2) {
				candidateK = generateCandidate2(frequent1);
			} else {
				candidateK = generateCandidateSizeK(level);
			}

			totalCandidateCount += candidateK.size();
			for (int[] transaction : database) {
				if (transaction.length < k) {
					continue;
				}
				loopCand: for (Itemset candidate : candidateK) {
					// a variable that will be use to check if
					// all items of candidate are in this transaction
					int pos = 0;
					// for each item in this transaction
					for (int item : transaction) {
						// if the item correspond to the current item of
						// candidate
						if (item == candidate.itemset[pos]) {
							// we will try to find the next item of candidate
							// next
							pos++;
							// if we found all items of candidate in this
							// transaction
							if (pos == candidate.itemset.length) {
								// we increase the support of this candidate
								candidate.support++;
								continue loopCand;
							}
							// Because of lexical order, we don't need to
							// continue scanning the transaction if the current
							// item
							// is larger than the one that we search in
							// candidate.
						} else if (item > candidate.itemset[pos]) {
							continue loopCand;
						}

					}
				}
			}

			level = new ArrayList<Itemset>();
			for (Itemset candidate : candidateK) {
				// if the support is > minsup
				if (candidate.getAbsoluteSupport() >= minsupRelative) {
					// add the candidate
					level.add(candidate);
					// the itemset is frequent so save it into results
					saveItemset(candidate);
				}
			}
			// we will generate larger itemsets next.
			k++;
			System.out.println("完成频繁"+(k-1)+"项集挖掘");
		} while (level.isEmpty() == false);

		if (writer != null) {
			writer.close();
		}

		endTimestamp = System.currentTimeMillis();
		return patterns;
	}

	void saveItemset(Itemset itemset) throws IOException {
		itemsetCount++;

		// if the result should be saved to a file
		if (writer != null) {
			writer.write(itemset.toString() + " #SUP: "
					+ itemset.getAbsoluteSupport());
			writer.newLine();
		} // otherwise the result is kept into memory
		else {
			patterns.addItemset(itemset, itemset.size());
		}
	}

	void saveItemsetToFile(Integer item, Integer support) throws IOException {
		itemsetCount++;

		// if the result should be saved to a file
		if (writer != null) {
			writer.write(item + " #SUP: " + support);
			writer.newLine();
		} // otherwise the result is kept into memory
		else {
			Itemset itemset = new Itemset(item);
			itemset.setAbsoluteSupport(support);
			patterns.addItemset(itemset, 1);
		}
	}

	private List<Itemset> generateCandidate2(List<Integer> frequent1) {
		List<Itemset> candidates = new ArrayList<>();
		// 循环项集I1和I2
		for (int i = 0; i < frequent1.size(); i++) {
			Integer item1 = frequent1.get(i);
			for (int j = 0; j < frequent1.size(); j++) {
				Integer item2 = frequent1.get(j);
				candidates.add(new Itemset(new int[] { item1, item2 }));
			}
		}
		return candidates;
	}

	/**
	 * Method to generate itemsets of size k from frequent itemsets of size K-1.
	 * 
	 * @param levelK_1
	 *            frequent itemsets of size k-1
	 * @return itemsets of size k
	 */
	protected List<Itemset> generateCandidateSizeK(List<Itemset> levelK_1) {
		// create a variable to store candidates
		List<Itemset> candidates = new ArrayList<Itemset>();

		// For each itemset I1 and I2 of level k-1
		loop1: for (int i = 0; i < levelK_1.size(); i++) {
			int[] itemset1 = levelK_1.get(i).itemset;
			loop2: for (int j = i + 1; j < levelK_1.size(); j++) {
				int[] itemset2 = levelK_1.get(j).itemset;

				// we compare items of itemset1 and itemset2.
				// If they have all the same k-1 items and the last item of
				// itemset1 is smaller than
				// the last item of itemset2, we will combine them to generate a
				// candidate
				for (int k = 0; k < itemset1.length; k++) {
					// if they are the last items
					if (k == itemset1.length - 1) {
						// the one from itemset1 should be smaller (lexical
						// order)
						// and different from the one of itemset2
						if (itemset1[k] >= itemset2[k]) {
							continue loop1;
						}
					}
					// if they are not the last items, and
					else if (itemset1[k] < itemset2[k]) {
						continue loop2; // we continue searching
					} else if (itemset1[k] > itemset2[k]) {
						continue loop1; // we stop searching: because of lexical
										// order
					}
				}

				// Create a new candidate by combining itemset1 and itemset2
				int newItemset[] = new int[itemset1.length + 1];
				System.arraycopy(itemset1, 0, newItemset, 0, itemset1.length);
				newItemset[itemset1.length] = itemset2[itemset2.length - 1];

				// The candidate is tested to see if its subsets of size k-1 are
				// included in
				// level k-1 (they are frequent).
				if (allSubsetsOfSizeK_1AreFrequent(newItemset, levelK_1)) {
					candidates.add(new Itemset(newItemset));
				}
			}
		}
		return candidates; // return the set of candidates
	}

	/**
	 * Method to check if all the subsets of size k-1 of a candidate of size k
	 * are freuqnet
	 * 
	 * @param candidate
	 *            a candidate itemset of size k
	 * @param levelK_1
	 *            the frequent itemsets of size k-1
	 * @return true if all the subsets are frequet
	 */
	protected boolean allSubsetsOfSizeK_1AreFrequent(int[] candidate,
			List<Itemset> levelK_1) {
		// generate all subsets by always each item from the candidate, one by
		// one
		for (int posRemoved = 0; posRemoved < candidate.length; posRemoved++) {

			// perform a binary search to check if the subset appears in level
			// k-1.
			int first = 0;
			int last = levelK_1.size() - 1;

			// variable to remember if we found the subset
			boolean found = false;
			// the binary search
			while (first <= last) {
				int middle = (first + last) >> 1; // >>1 means to divide by 2

				int comparison = ArraysAlgos.sameAs(
						levelK_1.get(middle).getItems(), candidate, posRemoved);
				if (comparison < 0) {
					first = middle + 1; // the itemset compared is larger than
										// the subset according to the lexical
										// order
				} else if (comparison > 0) {
					last = middle - 1; // the itemset compared is smaller than
										// the subset is smaller according to
										// the lexical order
				} else {
					found = true; // we have found it so we stop
					break;
				}
			}

			if (found == false) { // if we did not find it, that means that
									// candidate is not a frequent itemset
									// because
				// at least one of its subsets does not appear in level k-1.
				return false;
			}
		}
		return true;
	}

	/**
	 * Print statistics about the algorithm execution to System.out.
	 */
	public void printStats() {
		System.out.println("=============  APRIORI - STATS =============");
		System.out.println(" Candidates count : " + totalCandidateCount);
		System.out.println(" The algorithm stopped at size " + (k - 1)
				+ ", because there is no candidate");
		System.out.println(" Frequent itemsets count : " + itemsetCount);
		System.out.println(
				" Total time ~ " + (endTimestamp - startTimestamp) + " ms");
		System.out
				.println("===================================================");
	}

	public List<int[]> getDatabase() {
		return database;
	}

	public int getDatabaseSize() {
		return databaseSize;
	}

}
