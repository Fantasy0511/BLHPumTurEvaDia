package blh.action.dataUpload;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.fileUploadRecordView.FileUploadRecordQuery;
import tool.easyui.Table;

@Result(type = "json")
public class ViewRecordAction extends AbstractActionSupport {

	/**
	 * 查看上传文件的值
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Table table;

	@Override
	public String execute() throws Exception {
		FileUploadRecordQuery fileUploadRecordQuery = new FileUploadRecordQuery();
		id = Integer.parseInt(getFirstInput());
		String fileName = fileUploadRecordQuery.getFileNameById(id);
		System.out.println(fileName);
		table = new Table(fileUploadRecordQuery.getDataByFileName(fileName));

		return super.execute();
	}

	public Table getTable() {
		return table;
	}

}
