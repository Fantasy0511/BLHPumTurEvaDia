package blh.action.dataUpload;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.fileUploadRecordView.FileUploadRecordQuery;
import service.fileUploadRecordView.HistoryReportRecord;
import tool.easyui.Table;
import util.TimeUtils;

/**
 * 查询excel文件上传历史
 * 
 * @author wuyue
 *
 */
@Result(type = "json")
public class RecordAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;
	private String beginTime;
	private String endTime;
	private Table table;
	FileUploadRecordQuery fileUploadRecordQuery = new FileUploadRecordQuery();

	@Override
	public String execute() throws Exception {
		System.out.println(getFirstInput());
		beginTime = String
				.valueOf(TimeUtils.StringtoLong(getFirstInput() + " 00:00:00"));
		endTime = String.valueOf(
				TimeUtils.StringtoLong(getSecondInput() + " 00:00:00"));
		System.out.println(beginTime + " " + endTime);
		List<HistoryReportRecord> records = fileUploadRecordQuery
				.getFileRecords(beginTime, endTime);
		table = new Table(records);

		return super.execute();
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Table getTable() {
		return table;
	}

}
