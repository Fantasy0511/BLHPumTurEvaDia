package service.excel2Db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import service.excel2Db.TransDb.TransDbMain;
import util.DataInfo;

public class Excel2Table {
	/**
	 * 根据路径读取excel返回Table 注意pathName的excel的后缀 应该为xls；
	 * 读取excel，将excel每个单元格的内容都赋给Table这个对象
	 * 
	 * @param pathName
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Table readExcel2Table(String pathName)
			throws BiffException, IOException, ClassNotFoundException, SQLException {
		String tableName = pathName.substring(pathName.lastIndexOf("\\") + 1,
				pathName.lastIndexOf("."));
		
		TransDbMain aDbMain=new TransDbMain();
		HashMap<String, DataInfo> aHashMap=aDbMain.getExcle(tableName.split("_")[0]);
		
		Workbook readWb = null;
		InputStream inputStream = new FileInputStream(pathName);
		readWb = Workbook.getWorkbook(inputStream);
		Sheet sheet = readWb.getSheet(0);
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		List<TableRow> tableRows = new ArrayList<>();
		
		for (int i = 0; i < rows; i++) {
			if (tableName.split("_")[0].equals("float")) {
				List<String> list = new ArrayList<>();
				String cell0 = sheet.getCell(0, i).getContents();
				String cell1 = aHashMap.get(tableName.split("_")[0] + cell0).getPosition();
				String cell2 = sheet.getCell(1, i).getContents();
				String cell3 = sheet.getCell(2, i).getContents();
				list.add(cell0);
				list.add(cell1);
				list.add(cell2);
				list.add(cell3);
				TableRow tableRow = new TableRow(list);
				tableRows.add(tableRow);
			}
			else {
				List<String> list = new ArrayList<>();
				/*System.out.println("输出文件名字："+tableName.split("_")[0]);*/
				String cell0 = sheet.getCell(0, i).getContents();
				String cell1 = aHashMap.get(tableName.split("_")[0] + cell0).getPosition();
				String cell2 = aHashMap.get(tableName.split("_")[0] + cell0).getDescription();
				String cell3 = sheet.getCell(1, i).getContents();
				String cell4 = sheet.getCell(2, i).getContents();
				
				list.add(cell0);
				list.add(cell1);
				list.add(cell2);
				list.add(cell3);
				list.add(cell4);
				
				TableRow tableRow = new TableRow(list);
				tableRows.add(tableRow);
			}
			
		}
		return new Table(tableName, tableRows);
	}
	
	/**
	 * 适用于FaultInfoTable
	 * @param pathName
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public Table readExcel2Table2(String pathName)
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
		for (int i = 4; i < rows; i++) {
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
