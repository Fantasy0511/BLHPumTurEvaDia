package blh.action.dataUpload;
/**
 * 历史记录查询表 
 * @author tiandiwei
 *
 */
public class HistoryReport {
	private int ID;
	private String  fileName;
	private String  recordTime;
	
	public HistoryReport(int iD, String fileName, String recordTime) {
		super();
		ID = iD;
		this.fileName = fileName;
		this.recordTime = recordTime;
	}
	
	public int getID() {
		return ID;
	}
	public String getFileName() {
		return fileName;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	
	

}
