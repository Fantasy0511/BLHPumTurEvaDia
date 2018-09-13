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
	private double alarmlevel;
	private double HHLimite;
	private double LLLimite;
	private double HLimite;
	private double LLimite;
	
	public DataInfo(String typeid,String position,String parameters,String description,
			String unit,double alarmlevel,double HHLimite,double LLLimite,double HLimite,double LLimite){
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
	
	
	public DataInfo(String typeid, String position, String parameters, String description) {
		super();
		this.typeid = typeid;
		this.position = position;
		this.parameters = parameters;
		this.description = description;
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
	public double getAlarmlevel() {
		return alarmlevel;
	}
	public void setAlarmlevel(double alarmlevel) {
		this.alarmlevel = alarmlevel;
	}
	public double getHHLimite() {
		return HHLimite;
	}
	public void setHHLimite(double hHLimite) {
		HHLimite = hHLimite;
	}
	public double getLLLimite() {
		return LLLimite;
	}
	public void setLLLimite(double lLLimite) {
		LLLimite = lLLimite;
	}
	public double getHLimite() {
		return HLimite;
	}
	public void setHLimite(double hLimite) {
		HLimite = hLimite;
	}
	public double getLLimite() {
		return LLimite;
	}
	public void setLLimite(double lLimite) {
		LLimite = lLimite;
	}
}
