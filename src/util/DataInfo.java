package util;

/**
 * 数据信息结构
 * @author lh
 * */
public class DataInfo {
	private String typeid; 
	private String position;
	private String parameters;
	private String description;
	private String unit;
	private int alarmlevel;
	private int HHLimite;
	private int LLLimite;
	private int HLimite;
	private int LLimite;
	
	public DataInfo(String typeid,String position,String parameters,String description,
			String unit,int alarmlevel,int HHLimite,int LLLimite,int HLimite,int LLimite){
		this.setTypeid(typeid);
		this.setPosition(position);
		this.setParameters(parameters);
		this.setDescription(description);
		this.setUnit(unit);
		this.setAlarmlevel(alarmlevel);
		this.setHHLimite(HHLimite);
		this.setLLLimite(LLLimite);
		this.setHLimite(HLimite);
		this.setLLimite(LLimite);
	}
	
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getAlarmlevel() {
		return alarmlevel;
	}
	public void setAlarmlevel(int alarmlevel) {
		this.alarmlevel = alarmlevel;
	}
	public int getHHLimite() {
		return HHLimite;
	}
	public void setHHLimite(int hHLimite) {
		HHLimite = hHLimite;
	}
	public int getLLLimite() {
		return LLLimite;
	}
	public void setLLLimite(int lLLimite) {
		LLLimite = lLLimite;
	}
	public int getHLimite() {
		return HLimite;
	}
	public void setHLimite(int hLimite) {
		HLimite = hLimite;
	}
	public int getLLimite() {
		return LLimite;
	}
	public void setLLimite(int lLimite) {
		LLimite = lLimite;
	}
}
