package blh.action.dataUpload;

import org.apache.struts2.convention.annotation.Action;

import blh.action.support.AbstractActionSupport;
import service.fileUploadRecordView.FileUploadRecordQuery;

@Action("delete-record")
public class DeleteRecordAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private int id;

	@Override
	public String execute() throws Exception {
		id = Integer.parseInt(getFirstInput());
		FileUploadRecordQuery fileUploadRecordQuery = new FileUploadRecordQuery();
		String fileName = fileUploadRecordQuery.getFileNameById(id);
		System.out.println("删除："+fileName);
		new FileUploadRecordQuery().deleteRecord(id,fileName);
		
		return super.execute();
	}

	public void setId(int id) {
		this.id = id;
	}

}
