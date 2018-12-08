package service.excel2Db;

import java.io.IOException;
import java.sql.SQLException;

import jxl.read.biff.BiffException;

/**
 * 封装1.解析excel文件到Table类 2.上传Table类到db 如果用Hibernata Table类可以直接映射为数据表
 * 功能：1.在数据库根据文件名建立一个表 2.将表的上传信息记录到表 "upload_file_record"中，包括：文件名，上传时间
 * 
 * @author wuyue
 *
 */
public class Excel2DbService {
	Excel2Table excel2Table = new Excel2Table();
	Table2Db table2Db = new Table2Db();
	private Table fileTable;
	private String message;

	public void upLoadExcelToDb(String filePath)
			throws BiffException, IOException, ClassNotFoundException, SQLException {
		System.out.println("输出绝对路径："+filePath);
		if (filePath.contains("xls")) {
			fileTable=excel2Table.readExcel2Table2(filePath);
			table2Db.saveTableToDb(fileTable);
			table2Db.saveFileToRecordTable(fileTable.getTableName(),fileTable.getFileTimeValue());
		}else {
			fileTable=excel2Table.readCsv2Table(filePath);
			message=table2Db.saveFileToRecordTable(fileTable.getTableName(),fileTable.getFileTimeValue());
			if (message.equals("0")) {
				table2Db.saveTableToDb(fileTable);
				System.out.println("。。。。。文件上传成功！");
			}
		}
		
	}
}
