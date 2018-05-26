package service.excel2Db;

import java.io.IOException;

import jxl.read.biff.BiffException;

/**
 * 封装1.解析excel文件到Table类 2.上传Table类到db 如果用Hibernata Table类可以直接映射为数据表
 * 
 * @author wuyue
 *
 */
public class Excel2DbService {
	Excel2Table excel2Table = new Excel2Table();
	Table2Db table2Db = new Table2Db();

	public void upLoadExcelToDb(String filePath)
			throws BiffException, IOException {
		table2Db.saveTableToDb(excel2Table.readExcel2Table(filePath)); // 在数据库上建一个“Table对象”，每个table实例代表一张表
		table2Db.saveFileToRecordTable(filePath);    // 执行sql语句，存储上传文件信息保存到数据库表 "upload_file_record"
	}
}
