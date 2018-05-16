package service.predict;

import tool.easyui.Table;

public class PredictReport {
	private String unitNo;

	private Table resultTable;
	private String comparison;
	private String step;
	private String object;

	public PredictReport() {
		super();
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public Table getResultTable() {
		return resultTable;
	}

	public void setResultTable(Table resultTable) {
		this.resultTable = resultTable;
	}

	public String getComparison() {
		return comparison;
	}

	public void setComparison(String comparison) {
		this.comparison = comparison;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	
}
