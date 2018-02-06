package service.dateMine.bean;

/**
 * 树的链接关系
 * 
 * @author wuyue
 *
 */
public class Links {
	private String source;
	private String target;

	public Links() {
		super();
	}

	public Links(String source, String target) {
		super();
		this.source = source;
		this.target = target;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
