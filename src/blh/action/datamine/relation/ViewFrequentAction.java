package blh.action.datamine.relation;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.dateMine.frequentItem.FrequentItem;

/**
 * 频繁项集的展示
 * 
 * @author wuyue
 *
 */
@Result(type = "json")
public class ViewFrequentAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private String system;
	private int frequent;
	private String result;

	@Override
	public String execute() throws Exception {
		system = getFirstInput();
		frequent = Integer.parseInt(getSecondInput());
		System.out.println(system + "   " + frequent);
		FrequentItem frequentItem = new FrequentItem().getFrequentItem(system, frequent);
		System.out.println(frequentItem);
		List<String> list = frequentItem.getItems();
		System.out.println(list.toString());
		result=list.toString().replaceAll(",", " ; ").replace("[", "").replace("]", "");
		return super.execute();
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public void setFrequent(int frequent) {
		this.frequent = frequent;
	}

	public String getResult() {
		return result;
	}

}
