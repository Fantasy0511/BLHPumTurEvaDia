package blh.action.exception;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.impl.BaseDAO;

/*
 * 查询数据库，验证是否连接正常
 */
@Result(type = "json")
public class DbexceptionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private DbConnectionMessage exceptionString = new DbConnectionMessage();

	@Override
	public String execute() throws Exception {
		try {
			BaseDAO baseDAO = new BaseDAO();
			exceptionString.setMessage("数据库正常连接！");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			exceptionString.setMessage("数据库连接异常："+e.getMessage()+"请检查！");
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public DbConnectionMessage getExceptionString() {
		return exceptionString;
	}


}
