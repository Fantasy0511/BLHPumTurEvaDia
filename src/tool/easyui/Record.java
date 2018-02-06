package tool.easyui;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 一行记录。
 * 
 * @author hx
 * 
 * @param <T>
 *            代表列的对象类型
 * @param <V>
 *            代表数据的对象类型
 */
public class Record<T, V> {
	private Map<T, V> map;
	private Pair p;

	public Record() {
		this.map = new LinkedHashMap<T, V>();
		this.p = this.new Pair();
	}

	public Record<T, V> withName(T colName) {
		p.name = colName;
		return this;
	}

	public Record<T, V> withValue(V value) {
		p.value = value;
		return this;
	}

	public Record<T, V> addProperty() {
		map.put(p.name, p.value);
		return this;
	}

	public Map<T, V> addEnd() {
		return map;
	}

	public Map<T, V> getRow() {
		return map;
	}

	public Object get(T key) {
		return map.get(key);
	}

	class Pair {
		T name;
		V value;
	}
}
