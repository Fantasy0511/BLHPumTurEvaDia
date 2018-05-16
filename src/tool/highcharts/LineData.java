package tool.highcharts;

/**
 * 折线图的数据模型。适用于单条或者多条折线。<br/>
 * 注意：本类和js代码配合使用，一定不要单独改变其中之一代码的变量名称。
 * 
 * @author 聂勇文
 * @author hx
 * @version 1.0
 * @version 1.1 改造为适合转换成json的格式。且由于封装了数据，此时改变他的存储方式也不会影响到使用，满足重构的原则。
 * @version 2.0 升级为适用于单图多条折线的情况，并保持了接口不变，添加了构造者和工厂。
 * 
 */
public class LineData {
	private String title;
	private String xName;
	private String yName;
	private NameAndData[] data;

	private String type = "line";

	LineData(String title, String xName, String yName, NameAndData[] data) {
		super();
		this.title = title;
		this.xName = xName;
		this.yName = yName;
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public String getxName() {
		return xName;
	}

	public String getyName() {
		return yName;
	}

	public NameAndData[] getData() {
		return data;
	}

	public String getType() {
		return type;
	}

	public static class NameAndData {
		private String name = "";
		private double[][] data;

		public NameAndData(double[][] data) {
			super();
			this.data = data;
		}

		public NameAndData(String name, double[][] data) {
			super();
			this.name = name;
			this.data = data;
		}

		public String getName() {
			return name;
		}

		public double[][] getData() {
			return data;
		}

	}
}
