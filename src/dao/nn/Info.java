package dao.nn;

/**
 * InfoTable
 * 
 * @author wuyue
 *
 */
public class Info {
	private String position;
	private String description;

	public Info() {
		super();
	}

	public Info(String position, String description) {
		super();
		this.position = position;
		this.description = description;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
