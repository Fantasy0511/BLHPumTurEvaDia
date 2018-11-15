package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.impl.BaseDAO;
import util.FaultUtils;
import util.dao.JdbcDaoUtil;
import vo.DefectTableVo;

public class findDefectTable extends JdbcDaoUtil {
	
	public List<DefectTableVo> queDefectFault() throws ClassNotFoundException, SQLException {
		BaseDAO database = new BaseDAO();
		List<DefectTableVo> faults = database.queDefect();
		return faults;
	}
	
}
