package bll.diagnosis.tree.model;
import java.util.ArrayList;

public class Node{	
	String name;
	ArrayList<String> children = new ArrayList<String>();
	String gate;
	double freq;
	//int childrennum;
	String father;
	//int Num;
	//Boolean Fault;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<String> children) {
		this.children = children;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	public double getX() {
		return freq;
	}
	public void setX(double freq) {
		this.freq = freq;
	}
	public void setFreq(Double freq) {
		this.freq = freq;
	}
	public Double getFreq() {
		return freq;
	}
//	public int getChildrennum() {
//		return childrennum;
//	}
//	public void setChildrennum(int childrennum) {
//		this.childrennum = childrennum;
//	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
}
