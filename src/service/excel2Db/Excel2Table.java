package service.excel2Db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel2Table {
	/**
	 * 根据路径读取excel返回Table 注意pathName的excel的后缀 应该为xls；
	 * 读取excel，将excel每个单元格的内容都赋给Table这个对象
	 * 
	 * @param pathName
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public Table readExcel2Table(String pathName)
			throws BiffException, IOException {
		String tableName = pathName.substring(pathName.lastIndexOf("\\") + 1,
				pathName.lastIndexOf("."));
		Workbook readWb = null;
		InputStream inputStream = new FileInputStream(pathName);
		readWb = Workbook.getWorkbook(inputStream);
		Sheet sheet = readWb.getSheet(0);
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		List<TableRow> tableRows = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			List<String> list = new ArrayList<>();
			for (int j = 0; j < cols; j++) {
				String cell = sheet.getCell(j, i).getContents();
				list.add(cell);
			}
			TableRow tableRow = new TableRow(list);
			tableRows.add(tableRow);
		}

		return new Table(tableName, tableRows);
	}
}
