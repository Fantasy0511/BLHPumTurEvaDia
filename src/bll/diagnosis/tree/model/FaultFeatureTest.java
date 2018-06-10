package bll.diagnosis.tree.model;

public class FaultFeatureTest {
	String name;
	double Feature[] = new double[19];
	double Threshold;
	double relation;

	public FaultFeatureTest(String name, double[] feature, double threshold, int relation) {
		super();
		this.name = name;
		Feature = feature;
		Threshold = threshold;
		this.relation = relation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getThreshold() {
		return Threshold;
	}

	public void setThreshold(double threshold) {
		Threshold = threshold;
	}

	public double getRelation() {
		return relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
	}

	public double[] getFeature() {
		return Feature;
	}

	public void setFeature(double[] feature) {
		Feature = feature;
	}

}
