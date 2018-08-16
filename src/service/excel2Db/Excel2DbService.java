package service.excel2Db;

import java.io.IOException;

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

	public void upLoadExcelToDb(String filePath)
			throws BiffException, IOException {
		/*String tableName = filePath.substring(filePath.lastIndexOf("\\") + 1,
				filePath.lastIndexOf("."));*/
		table2Db.saveTableToDb(excel2Table.readExcel2Table(filePath));
		// 在数据库上建一个“Table对象”，每个table实例代表一张表,并在数据库中建立了一个表，比如“float_201805”之类的
		/*table2Db.saveTable2TestTable(tableName);*/
		table2Db.saveFileToRecordTable(filePath);
		// 执行sql语句，存储上传文件信息保存到数据库表 "upload_file_record"
	}
}
