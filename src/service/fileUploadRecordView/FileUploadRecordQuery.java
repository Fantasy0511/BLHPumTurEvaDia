package service.fileUploadRecordView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import service.excel2Db.TableRow;
import util.TimeUtils;
import util.dao.JdbcDaoUtil;

/**
 * 查询文件提交记录
 * 
 * @author wuyue
 *
 */
public class FileUploadRecordQuery extends JdbcDaoUtil {
	/**
	 * 获取指定时间的上传文件记录
	 * 
	 * @return
	 */
	public List<HistoryReportRecord> getFileRecords(String begin, String end) {
		String sqlString = "SELECT * FROM UPLOAD_FILE_RECORD WHERE RECORDTIME BETWEEN ? AND ?";
		return getJdbcTemplate().query(sqlString, new ResultSetExtractor<List<HistoryReportRecord>>() {

			@Override
			public List<HistoryReportRecord> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<HistoryReportRecord> records = new ArrayList<>();
				while (rs.next()) {
					records.add(new HistoryReportRecord(rs.getInt("id"), rs.getString("fileName"),
							TimeUtils.LongtoString(Long.parseLong(rs.getString("recordTime")))));
				}

				return records;
			}
		}, begin, end);
	}

	/**
	 * 删除表记录
	 */

	public void deleteRecord(int id,String fileName) {
		String sql1;
		String sql2;
		if (fileName.contains("FaultInfo")) {
			sql1 = "delete from UPLOAD_FILE_RECORD where id=?";
			getJdbcTemplate().update(sql1, id);
		}
		else {
			sql1 = "delete from UPLOAD_FILE_RECORD where id=?";
			getJdbcTemplate().update(sql1, id);
			sql2= "drop table "+fileName;
			System.out.println("文件名："+fileName);
			getJdbcTemplate().update(sql2);
		}
	}

	/**
	 * 依据id查询upload_file_record中的fileName属性
	 */

	public String getFileNameById(int id) {
		String sql = "select fileName from UPLOAD_FILE_RECORD where id=?";
		return getJdbcTemplate().query(sql, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String fileName = null;
				while (rs.next()) {
					fileName = rs.getString("fileName");
				}
				return fileName;
			}

		}, id);
	}

	/**
	 * 依据filename获取文件数据
	 * 
	 * 这里很奇怪，在复制P0时，fileName赋值错误com.microsoft.sqlserver.jdbc.SQLServerException:
	 * 必须声明表变量 "@P0"。 ++++++++最终使用拼接字符串
	 */
	public List<TableRow> getDataByFileName(String fileName) {
		String sql;
		if (fileName.contains("FaultInfo")) {
			sql = "select * from " + fileName;
		}
		else {
			sql = "select TOP 10000 * from " + fileName;
		}
		
		return getJdbcTemplate().query(sql, new ResultSetExtractor<List<TableRow>>() {
			@Override
			public List<TableRow> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<TableRow> list = new ArrayList<>();
				if (fileName.contains("float")) {
					while (rs.next()) {
						list.add(new TableRow(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
					}
				}
				if (fileName.contains("bool") || fileName.contains("double")) {
					while (rs.next()) {
						list.add(new TableRow(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5)));
					}
				} else {
					while (rs.next()) {
						list.add(new TableRow(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)

						));
					}
				}

				return list;
			}

		});
	}

	public static void main(String[] args) {
		List<TableRow> list = new FileUploadRecordQuery().getDataByFileName("float_201802");
		System.out.println(list.size());
	}
}
