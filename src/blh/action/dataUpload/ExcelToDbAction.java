package blh.action.dataUpload;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.excel2Db.Excel2DbService;
import util.FileUtils;

/**
 * 上传文件的action ActionSupport对post文件到后台进行了疯转，只要在action中声明File
 * fileName，并生成setter方法即可，获取页面传来的file; ------------注意：：：： 文件名前后应该对应
 * 
 * @author wuyue
 *
 */
@Action("excelToDb")
@Result(type = "json")
public class ExcelToDbAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private String fileName;
	private File excel;
	private String excelFilename;
	Excel2DbService excel2DbService = new Excel2DbService();

	@Override
	public String execute() throws Exception {
		System.out.println(excel.getName());
		System.out.println(excel.getPath());
		excel2DbService.upLoadExcelToDb(
				FileUtils.copyFile(fileName, excel).getAbsolutePath()); 
		// 从本地的输入文件拷贝到输出文件，再获取这个输出文件的绝对路径，再把这个绝对路径返回给upLoadExcelToDb（）方法执行
		return "SUCCESS";
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setExcel(File excel) {
		this.excel = excel;
	}

	public void setExcelFilename(String excelFilename) {
		this.excelFilename = excelFilename;
	}

	public String getExcelFilename() {
		return excelFilename;
	}

}
