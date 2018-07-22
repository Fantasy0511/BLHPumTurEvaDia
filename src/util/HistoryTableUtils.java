package util;

/**
 * 历史运行数据结构
 * @author tiandiwei
 *
 */
public class HistoryTableUtils {
	private DataUtils dataUtils;
	private String  description;
	private String unit;
	
	public HistoryTableUtils(DataUtils dataUtils, String description, String unit) {
		super();
		this.dataUtils = dataUtils;
		this.description = description;
		this.unit = unit;
	}
	public DataUtils getDataUtils() {
		return dataUtils;
	}
	public String getDescription() {
		return description;
	}
	public String getUnit() {
		return unit;
	}
	public void setDataUtils(DataUtils dataUtils) {
		this.dataUtils = dataUtils;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	

}
