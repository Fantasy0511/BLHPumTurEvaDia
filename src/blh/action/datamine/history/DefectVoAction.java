package blh.action.datamine.history;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import dao.findDefectTable;
import vo.DefectTableVo;

@Result(type = "json")
public class DefectVoAction  extends AbstractActionSupport{
	
	
	private static final long serialVersionUID = 1L;
	
	private List<DefectTableVo> data;

	@Override
	public String execute() throws Exception {
		
		findDefectTable findDefectTablea=new findDefectTable();
		data =findDefectTablea.queDefectFault();
		
		return super.execute();
	}

	public List<DefectTableVo> getData() {
		return data;
	}

	public void setData(List<DefectTableVo> data) {
		this.data = data;
	}

	
	
}
