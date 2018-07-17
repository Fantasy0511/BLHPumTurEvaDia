package blh.action.datamine.relation;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.dateMine.frequentItem.FrequentItem;
import tool.easyui.Table;

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
	private Table bottomDatail;

	@Override
	public String execute() throws Exception {
		system = getFirstInput();
		frequent = Integer.parseInt(getSecondInput());

		// 输出频繁项集前两项和后两项

		List<String> data = new ArrayList<>();
		List<String> result = new ArrayList<>();
		bottomDatail = new Table(new String[] { "FrequentName", "detail" });
		for (int i = frequent; i < frequent +6; i++) {
			
			System.out.println(system + "   " + i);
			FrequentItem frequentItem = new FrequentItem().getFrequentItem(system, i);

			result.add(frequentItem.getItems().toString());
			data.add("频繁" + i + "项集");
			System.out.println(data.get(0));
		}
		for (int j = 0; j < result.size(); j++) {
			bottomDatail.withRow(data.get(j), result.get(j));
		}
			
		return super.execute();
	}

	public Table getBottomDatail() {
		return bottomDatail;
	}

	public void setBottomDatail(Table bottomDatail) {
		this.bottomDatail = bottomDatail;
	}

}
