package service.excel2Db;

import java.io.IOException;

import jxl.read.biff.BiffException;

public class Test {

	// @org.junit.Test
	// public void testExcle2Table() throws BiffException, IOException {
	// Excel2Table excel2Table = new Excel2Table();
	// Table table = excel2Table.readExcel2Table("D:/double_201712.xls");
	// System.out.println(table.getTableName());
	// }

	public static void main(String[] args) throws BiffException, IOException {
		Table2Db table2Db = new Table2Db();
		// table2Db.creatNewTableByName("test11");
		Excel2Table excel2Table = new Excel2Table();
		Table table = excel2Table.readExcel2Table("D:/double_201812.xls");
		table2Db.saveTableToDb(table);
	}

}
