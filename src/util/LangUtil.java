package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;

/**
 * 语言功能。仔细研究commons.lang包，应该有已经写好的解决方案。<br/>
 * 主要功能：<br/>
 * <ul>
 * <li>类型转换</li>
 * <li>保留小数位数</li>
 * <li>类型判断</li>
 * <li>将可序列化对象序列化为二进制流</li>
 * <li>数组操作</li>
 * <li>字符串操作</li>
 * </ul>
 * 
 * @author hx
 * 
 */
public class LangUtil {
	private static DecimalFormat format = null;
	private static int lastN = 0;

	/**
	 * 数组转为数组线性表。
	 * 
	 * @param array
	 *            对象数组，不能是原生类型。
	 * @return 对象的数组线性表
	 */
	public static <T> List<T> toList(T[] array) {
		ArrayList<T> arrayList = new ArrayList<T>();
		for (T t : array) {
			arrayList.add(t);
		}
		return arrayList;
	}

	public static List<Integer> toList(int[] intArray) {
		return toList(toWrappedArray(intArray));
	}

	/**
	 * double[]转换为List<Double>。
	 * 
	 * @param doubleArray
	 *            基本类型double数组
	 * @return 包装类Double的数组线性表
	 */
	public static List<Double> toList(double[] doubleArray) {
		return toList(toWrappedArray(doubleArray));
	}

	/**
	 * double数组转换为其包装类的数组。
	 * 
	 * @param doubleArray
	 *            基本类型double的数组
	 * @return 包装类型Double的数组
	 */
	public static Double[] toWrappedArray(double[] doubleArray) {
		Double[] res = new Double[doubleArray.length];
		for (int i = 0; i < res.length; ++i) {
			res[i] = doubleArray[i];
		}
		return res;
	}

	public static Integer[] toWrappedArray(int[] intArray) {
		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < result.length; ++i) {
			result[i] = intArray[i];
		}
		return result;
	}

	public static int[] toPrimitiveArray(Integer[] array) {
		int[] result = new int[array.length];
		for (int i = 0; i < result.length; ++i) {
			result[i] = array[i];
		}
		return result;
	}

	/**
	 * 数的列表转化为double类型的数组。
	 * 
	 * @param list
	 *            数表
	 * @return 数表成员的数组
	 */
	public static <T extends Number> double[] toPrimitiveDoubleArray(
			List<T> list) {
		return toPrimitiveDoubleArray(list.toArray(new Double[list.size()]));
	}

	/**
	 * @param array
	 *            包装类的数组
	 * @return 基本类型double的数组
	 */
	public static <T extends Number> double[] toPrimitiveDoubleArray(T[] array) {
		double[] res = null;
		res = new double[array.length];
		for (int i = 0; i < res.length; ++i) {
			res[i] = array[i].doubleValue();
		}
		return res;
	}

	public static <T extends Number> int[] toPrimitiveIntArray(T[] array) {
		int[] res = null;
		res = new int[array.length];
		for (int i = 0; i < res.length; ++i) {
			res[i] = array[i].intValue();
		}
		return res;
	}

	public static <T extends Number> double[][] toDoubleArray2D(T[][] array) {
		double[][] res = null;
		res = new double[array.length][array[0].length];
		for (int i = 0; i < res.length; ++i) {
			res[i] = toPrimitiveDoubleArray(array[i]);
		}
		return res;
	}

	/**
	 * 提取每个数组对应索引的值组成二维的数组
	 * 
	 * @param arrays
	 * 
	 * @return 组成的二维数组res[a.length][2]
	 */
	public static double[][] toDoubleArray2D(double[]... arrays) {
		double[][] res = new double[arrays[0].length][arrays.length];
		for (int i = 0; i < arrays[0].length; ++i) {
			for (int j = 0; j < arrays.length; ++j) {
				res[i][j] = arrays[j][i];
			}
		}
		return res;
	}

	/**
	 * 将数字保留两位小数并返回为一个字符串。
	 * 
	 * @param number
	 *            待格式化的数
	 * @param n
	 *            保留的位数
	 * @return 保留两位小数的字符串
	 */
	public static <T extends Number> double keepDigits(T number, int n) {
		if (n < 0.00001) {
			n = 0;
		}

		if (format == null || n != lastN) {
			String holder = "0";
			if (n > 0) {
				holder += ".";
			}

			int i = n;
			while (i > 0) {
				holder += "0";
				--i;
			}
			format = new DecimalFormat(holder);
			lastN = n;
		}
		return Double.parseDouble(format.format(number.doubleValue()));
	}

	public static <T extends Number> Double keep2Digits(T number) {
		return keepDigits(number, 2);
	}

	public static <T extends Number> double keep3Digits(T number) {
		return keepDigits(number, 3);
	}

	public static double[] keep3Digits(double[] data) {
		double[] result = new double[data.length];
		for (int i = 0; i < data.length; ++i) {
			result[i] = keep2Digits(data[i]);
		}
		return result;
	}

	public static <T extends Number> double keep4Digits(T number) {
		return keepDigits(number, 4);
	}

	/**
	 * double[]对半分，得到二维数组。数组元素个数不是偶数会抛出错误。
	 * 
	 * @param original
	 * @return
	 */
	public static double[][] halfAPile(double[] original) {
		return nAPile(original, 2);
	}

	/**
	 * @param original
	 *            原始一维数组
	 * @param n
	 *            分割的份数
	 * @return n维数组。
	 */
	public static double[][] nAPile(double[] original, int n) {
		int count = original.length;
		if (count % n != 0) {
			throw new IllegalStateException("count must be even");
		}
		double[][] result = new double[n][];
		int per = count / n;
		int from = 0;
		int to = per;
		for (int i = 0; i < n; ++i) {
			result[i] = Arrays.copyOfRange(original, from, to);
			from += to;
			to += per;
		}
		return result;
	}

	public static boolean isInteger(String str) {
		String s = str.trim();
		boolean isInt = true;
		for (int i = 0; i < s.length(); ++i) {
			if (!Character.isDigit(s.charAt(i))) {
				isInt = false;
				break;
			}
		}
		return isInt;
	}

	/**
	 * 泛型T的数组化为字符串存储，并用separator分开。
	 * 
	 * @param tara
	 *            tara你敢信
	 * @param separator
	 *            分隔符
	 * @return 分隔符隔开的字符串化泛型T数组。
	 */
	@SafeVarargs
	public static <T> String concat(String separator, T[]... tara) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tara.length; ++i) {
			for (int j = 0; j < tara[i].length; ++j) {
				builder.append(tara[i][j].toString() + separator);
			}
		}
		return builder.substring(0, builder.length() - separator.length());
	}

	/**
	 * 使用双井号“//”分隔
	 * 
	 * @param objects
	 * @return
	 */
	public static String concatWith2Splash(Object... objects) {
		return concat("//", objects);
	}

	/**
	 * @param doubleArray
	 *            数字的数组
	 * @return 用逗号分隔的数字字符串。
	 */
	public static String concatWithComma(double[] doubleArray) {
		return concat(",", toWrappedArray(doubleArray));
	}

	public static <T> String concatWithComma(T[] tara) {
		return concat(",", tara);
	}

	public static String concatWithComma(double[]... doubleArrays) {
		Double[][] d = new Double[doubleArrays.length][];
		for (int i = 0; i < d.length; ++i) {
			d[i] = toWrappedArray(doubleArrays[i]);
		}
		return concat(",", d);
	}

	/**
	 * @param snakeCase
	 *            this_is_snake_case
	 * @return thisIsCamelCase
	 */
	public static String toCamelCase(String snakeCase) {
		String[] parts = snakeCase.toLowerCase().split("_");
		StringBuilder builder = new StringBuilder();
		builder.append(parts[0]);
		for (int i = 1; i < parts.length; ++i) {
			String part = parts[i];
			builder.append(part.substring(0, 1).toUpperCase()
					+ part.substring(1));
		}
		return builder.toString();
	}

	/**
	 * @param camelCase
	 *            thisIsCamelCase
	 * @return this_is_snake_case
	 */
	public static String toSnakeCase(String camelCase) {
		List<String> parts = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (char c : camelCase.toCharArray()) {
			if (Character.isLowerCase(c)) {
				sb.append(c);
			} else {
				String str = sb.toString();
				if (!isEmptyString(str)) {
					parts.add(str);
				}
				sb = new StringBuilder();
				sb.append(Character.toLowerCase(c));
			}
		}
		String last = sb.toString();
		if (!isEmptyString(last)) {
			parts.add(last);
		}
		return concat("_", parts.toArray(new String[parts.size()]));
	}

	/**
	 * THIS_IS_DB_CASE
	 * 
	 * @return str是不是上述case
	 */
	public static boolean isDBCase(String str) {
		if (!str.contains("_")) {
			return false;
		}
		if (StringUtils.isAllUpperCase(str.replaceAll("_", ""))) {
			return true;
		}
		return false;
	}

	public static boolean isEmptyString(String str) {
		return str == null || str.equals("");
	}

	/**
	 * @param str
	 *            以逗号分隔的字符串浮点数。
	 * @return 解析后的浮点数组。
	 */
	public static double[] fromString(String str) {
		String[] s = str.split(",");
		double[] result = new double[s.length];
		for (int i = 0; i < result.length; ++i) {
			result[i] = Double.parseDouble(s[i]);
		}
		return result;
	}

	/**
	 * 将类型序列化到字节数组中。double[]、ArrayList可以被序列化。从占用的内存考虑，将double[]序列化开销更小。
	 * 
	 * @param data
	 *            可以序列化的数据类型
	 * @return 返回序列化的字节数组
	 */
	public static byte[] toBytes(Serializable data) {
		if (data == null) {
			return new byte[] {};
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bos.toByteArray();
	}

	/**
	 * 从序列化的字节流中反序列化得到对象。如：序列化后的double[]。
	 * 
	 * @param bytes
	 *            序列化的字节数组
	 * @return 反序列化的对象
	 */
	public static Serializable fromBytes(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
		ObjectInputStream oin = null;
		Serializable result = null;
		try {
			oin = new ObjectInputStream(bin);
			result = (Serializable) oin.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oin != null) {
					oin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 从double[]字节流中反序列化得到原始数组。
	 * 
	 * @param bytes
	 *            double数组字节流
	 * @return 反序列化得到的double[]
	 */
	public static double[] fromDoubleBytes(byte[] bytes) {
		return (double[]) fromBytes(bytes);
	}

	public static double[][] fromDouble2DBytes(byte[] bytes) {
		return (double[][]) fromBytes(bytes);
	}

	public static <T> T cast(Object obj, Class<T> clazz) {
		if (obj.getClass().equals(clazz)) {
			return clazz.cast(obj);
		}
		throw new IllegalStateException("impossible to reach here!");
	}

	private static final String CONFIG_FOLDER = PathUtil.getWebRealBasePath()
			+ "/config/";
	private static final String CONFIG_FIELD_PREFIX = "CONFIG_";

	public static Properties config(String configFileName) {
		Properties p = new Properties();
		InputStream stream = null;
		try {
			stream = new FileInputStream(CONFIG_FOLDER + configFileName
					+ ".properties");
			p.load(stream);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		return p;
	}

	public static <T> void config(Properties p, T object) {
		Class<?> clazz = object.getClass();
		List<Field> fields = findConfigFields(clazz);
		for (Field field : fields) {
			String propertyName = field.getName().replaceFirst(
					CONFIG_FIELD_PREFIX, "");
			boolean accessible = field.isAccessible();
			ReflectionUtils.makeAccessible(field);
			try {
				String property = p.getProperty(propertyName);
				Class<?> fieldClass = field.getType();
				if (fieldClass.equals(String.class)) {
					field.set(object, property);
				} else if (fieldClass.equals(int.class)) {
					field.setInt(object, Integer.parseInt(property));
				} else if (fieldClass.equals(double.class)) {
					field.setDouble(object, Double.parseDouble(property));
				} else {
					throw new IllegalStateException("no such type: "
							+ fieldClass.getName());
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			field.setAccessible(accessible);
		}
	}

	public static <T> void config(String configFileName, T object) {
		Properties p = config(configFileName);
		config(p, object);
	}

	private static <T> List<Field> findConfigFields(Class<T> clazz) {
		final List<Field> result = new ArrayList<>();
		ReflectionUtils.doWithFields(clazz, new FieldCallback() {
			@Override
			public void doWith(Field field) throws IllegalArgumentException,
					IllegalAccessException {
				result.add(field);
			}
		}, new FieldFilter() {
			@Override
			public boolean matches(Field field) {
				return isConfigField(field);
			}
		});
		return result;
	}

	/**
	 * 配置字段：db case的字段。
	 * 
	 * @param field
	 *            待判断的字段。
	 * @return 是否是约定好的配置字段。
	 */
	private static boolean isConfigField(Field field) {
		String name = field.getName();
		return isDBCase(name) && name.startsWith(CONFIG_FIELD_PREFIX);
	}
}
