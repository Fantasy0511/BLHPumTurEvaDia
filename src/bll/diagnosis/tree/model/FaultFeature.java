package bll.diagnosis.tree.model;


public class FaultFeature{	
	String name;
	double Feature[] = new double[19];
	double Threshold;//阈值
	int relation;//比较关系
	String description;//规则描述
}
