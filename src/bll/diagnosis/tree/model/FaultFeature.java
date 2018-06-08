package bll.diagnosis.tree.model;


public class FaultFeature{	
	String name;
	double Feature[] = new double[19];
	double Threshold;//阈值
	int relation;//比较关系
	String description;//规则描述
	
	public String getName() {
		return name;
	}
	public double[] getFeature() {
		return Feature;
	}
	public double getThreshold() {
		return Threshold;
	}
	public int getRelation() {
		return relation;
	}
	public String getDescription() {
		return description;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFeature(double[] feature) {
		Feature = feature;
	}
	public void setThreshold(double threshold) {
		Threshold = threshold;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
