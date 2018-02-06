package util;

import java.util.List;

/**
 * 用于单元测试的辅助函数。为了实现测试的自动化，以后的项目争取采用maven进行开发，使用JUnit进行测试。 实现的功能如下：<br />
 * <ul>
 * <li>打印（print方法的封装）各种类型的数组</li>
 * <li>打印分割线：TestUtil.printLine()</li>
 * <li>给程序的运行时间计时： timeIt</li>
 * </ul>
 * 适用于：console端的手动测试。
 * 
 * @author hx
 * 
 */
public class TestUtil {
	public static <T> void print(T[] array, boolean keep2Digits) {
		int j = 0;
		for (T t : array) {
			if (t instanceof Double && keep2Digits) {
				System.out.print(LangUtil.keep2Digits((Double) t) + " ");
			} else {
				System.out.print(t + " ");
			}
			++j;
			if (j >= 20) {
				System.out.println("");
				j = 0;
			}
		}
		print();
	}

	public static <T> void print(T[] array) {
		print(array, false);
	}

	public static <T> void print(T[][] array) {
		for (T[] t : array) {
			for (T tt : t) {
				System.out.print(tt + "  ");
			}
			print();
		}
	}

	public static void print(double[][] array) {
		for (double[] t : array) {
			for (double tt : t) {
				System.out.print(tt + "  ");
			}
			print();
		}
	}

	public static void print() {
		System.out.println("");
	}

	public static void print(double[] doubleArray) {
		print(LangUtil.toWrappedArray(doubleArray));
	}

	public static void print(Object o) {
		System.out.println(o.toString());
	}

	public static <T> void print(List<T> list, int numPerLine) {
		int j = 0;
		for (T t : list) {
			System.out.print(t + "  ");
			++j;
			if (j >= numPerLine) {
				System.out.println("");
				j = 0;
			}
		}
		System.out.println("");
	}

	public static <T> void print(List<T> list) {
		print(list, 10);
	}

	public static void printLine() {
		print("__________________________________________________________");
	}

	/**
	 * 给程序计时。
	 * 
	 * @param container
	 *            实现这个接口并把待计时的代码写在process方法体中
	 */
	public static void timeIt(Container container) {
		long start = System.currentTimeMillis();
		print("...it begins...");
		try {
			container.process();
		} catch (Exception e) {
			print("error occured: " + e.getMessage());
			return;
		}
		print("...it ends...");
		long end = System.currentTimeMillis();
		long cost = (end - start);
		print("...it costs: " + cost + "ms...");
	}

	public static interface Container {
		void process();
	}
}
