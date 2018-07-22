package blh.action.datamine.relation;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.dateMine.Relation;
import service.dateMine.Relation.node;
import service.dateMine.bean.Links;
import service.dateMine.relation.RelationRecord;
import tool.easyui.Table;

/**
 * @author wuyue 关联规则挖掘对应的action
 */
@Result(type = "json")
// @Namespaces(value = { @Namespace("/User"),@Namespace("/") })
public class RelationAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Links> links = null;
	private List<node> nodes = null;
	private String system;
	private int support;
	private Table relationTables;

	@Override
	public String execute() throws Exception {
		system = getFirstInput();
		System.out.println(system);
		support = Integer.parseInt(getSecondInput());
		System.out.println(system + "," + support);
		Relation relation = new Relation();
		links = relation.getLinks(system, (double) (support) / 100);
		nodes = relation.getNodes(system, (double) (support) / 100);

		relationTables = new Table(new String[] { "deviceType", "deviceState" });

		List<RelationRecord> relationTables1 = new ArrayList<>();
		for (node n : nodes) {
			String deviceType = n.getName().substring(0, n.getName().indexOf("."));
			String deviceState = n.getName().substring(n.getName().indexOf("."), n.getName().length());
			RelationRecord relationRecord = new RelationRecord(deviceType, deviceState);
			relationTables1.add(relationRecord);
		}

		for (int i = 0; i < relationTables1.size(); i++) {
			relationTables.withRow(relationTables1.get(i).getDeviceType(), relationTables1.get(i).getDeviceState()
					.substring(1, relationTables1.get(i).getDeviceState().length()));//去掉关联分析表“设备状态”列，字符多了一个“.”
		}

		return super.execute();
	}

	public List<Links> getLinks() {
		return links;
	}

	public List<node> getNodes() {
		return nodes;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public void setSupport(int support) {
		this.support = support;
	}

	public Table getRelationTables() {
		return relationTables;
	}

	public void setRelationTables(Table relationTables) {
		this.relationTables = relationTables;
	}

}
