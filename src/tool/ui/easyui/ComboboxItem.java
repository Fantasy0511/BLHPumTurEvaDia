package tool.ui.easyui;

import java.util.Arrays;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

/**
 * 选择框的列表项。
 * 
 * @author hx
 *
 */
public class ComboboxItem {
	private static final ComboboxItem EMPTY_ITEM = new ComboboxItem("-1",
			"-未选择-");

	private String value;
	private String text;

	private ComboboxItem(String value, String text) {
		super();
		this.value = value;
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public String getText() {
		return text;
	}

	public static <T> ComboboxItem[] fromBeans(T[] beans, String valueProperty,
			String textProperty) {
		ComboboxItem[] items = new ComboboxItem[beans.length + 1];
		items[0] = EMPTY_ITEM;
		for (int i = 0; i < beans.length; ++i) {
			BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(
					beans[i]);
			items[i + 1] = new ComboboxItem(bpsps.getValue(valueProperty)
					.toString(), bpsps.getValue(textProperty).toString());
		}
		return items;
	}

	public static <T> ComboboxItem[] fromBeansWithOutEmpty(T[] beans,
			String valueProperty, String textProperty) {
		return removeEmpty(fromBeans(beans, valueProperty, textProperty));
	}

	private static <T> ComboboxItem[] removeEmpty(ComboboxItem[] original) {
		return Arrays.copyOfRange(original, 1, original.length);
	}
}
