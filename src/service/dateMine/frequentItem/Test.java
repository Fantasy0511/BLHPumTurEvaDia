package service.dateMine.frequentItem;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		FrequentItem frequentItem = new FrequentItem();
		System.out.println(frequentItem.getFrequentItem("ball", 3));
		FrequentItem string = frequentItem.getFrequentItem("ball", 3);
		String[] strs = string.toString().split("  ");
		for (String str : strs) {
			System.out.println(str);
		}

	}
}
