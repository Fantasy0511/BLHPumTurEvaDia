package blh.action.support;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 接收页面传来的参数，并解析，存放在inputStr[]中；
 * 
 * @author wuyue
 * 
 */
public abstract class AbstractActionSupport extends ActionSupport {

	private static final long serialVersionUID = 1L;
	protected String[] inputStr;

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public final void setInputStr(String inputStr) {
		if (inputStr == null) {
			inputStr = "";
		}
		this.inputStr = inputStr.split("//");
	}

	public final String getInput(int index) {
		return inputStr[index];
	}

	public final String getFirstInput() {
		return inputStr[0];
	}

	public final String getSecondInput() {
		return inputStr[1];
	}

	public final String getThirdInput() {
		return inputStr[2];
	}
	public final String getFourthInput() {
		return inputStr[3];
	}
	public final String getFifthInput() {
		return inputStr[4];
	}
}
