package bll.diagnosis.tree.model;
/**
 * @author 肖汉
 * 规则类定义
 */
public class Symptomkind{
	
	int ID;//编号
	String name;//特征类型名称
	String[] path;//通道描述
	int[] pathad;//通道地址
	String[] pathtype;//通道类型
	String[] pathcondition;//通道工况

	
	public Symptomkind(){
		
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String[] getPath() {
		return path;
	}

	public void setPath(String[] path) {
		this.path = path;
	}

	public int[] getPathad() {
		return pathad;
	}

	public void setPathad(int[] pathad) {
		this.pathad = pathad;
	}

	public String[] getPathtype() {
		return pathtype;
	}

	public void setPathtype(String[] pathtype) {
		this.pathtype = pathtype;
	}

	public String[] getPathcondition() {
		return pathcondition;
	}
	public void setPathcondition(String[] pathcondition) {
		this.pathcondition = pathcondition;
	}
}