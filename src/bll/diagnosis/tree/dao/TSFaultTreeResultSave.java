package bll.diagnosis.tree.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bll.diagnosis.tree.GovDBConfig;


public class TSFaultTreeResultSave {
    int    ID;
	//String wcstatus;
	String time;
	String result; 
	String symptom;
	String unitNo;	
    String recommendation;

	//保存数据
	public boolean save()
	{
		return GovDBConfig.exeSql(buildSave());
	}

	public String buildSave()
	{
		String sql = "Insert into BLH_FaultTree_Result(";
		sql = sql + "ID, ";
	//	sql = sql + "WC_Status, ";
		sql = sql + "Time, ";
		sql = sql + "Result, ";
		sql = sql + "Symptom, ";
		sql = sql + "UnitNo, ";
		sql = sql + "Recommendation) values(";
		sql = sql + ID + ", ";
	//	sql = sql + wcstatus + ",'";
		sql = sql + time + "','";
		sql = sql + result + "','";
		sql = sql + symptom + "','";
		sql = sql + unitNo + "','";
		sql = sql + recommendation + "')";

		return sql;
	}

	//删除
	public boolean delete()
	{
		return GovDBConfig.exeSql(buildDelete());
	}

	public String buildDelete()
	{
		return "delete from BLH_FaultTree_Result where ID = '" + ID+"'";
	}

	//查询
	public static List<TSFaultTreeResultSave> read()
	{
		String sql = "SELECT * FROM BLH_FaultTree_Result";
		return search(sql);
	}

	public static List<TSFaultTreeResultSave> search(String sql)
	{
		Connection conn = GovDBConfig.getconnection();
		Statement stmt = null;
		ResultSet rs = null;

		List<TSFaultTreeResultSave> list = new ArrayList<TSFaultTreeResultSave>();
		try
		{
			stmt = conn.createStatement();
			System.out.println(sql);
			rs = stmt.executeQuery(sql);


			while (rs.next() == true)
			{
				TSFaultTreeResultSave td = new TSFaultTreeResultSave();
		//		td.setWcstatus(rs.getString("ID"));		
				td.setTime(rs.getString("Time"));			
				td.setResult(rs.getString("Result"));	
				td.setSymptom(rs.getString("Symptom"));	
				td.setUnitNo(rs.getString("UnitNo"));	
				td.setRecommendation(rs.getString("Recommendation"));
				list.add(td);

			}				

			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public static void main(String[] args) {
		
		TSFaultTreeResultSave tsre=new TSFaultTreeResultSave();
	//	tsre.wcstatus="1";
		tsre.ID=1;
//		 String startTime = "2011-12-1";// 起始时间
//		 String endTime = GovTimeUtils.getNowParticularTime();// 结束时间
		
		tsre.time= "2016-06-23";
		tsre.symptom="1646556/4654/9121";
		tsre.result="1/2/4";
		tsre.unitNo="2";
		
		tsre.save();
		System.out.println("执行结束");
	}

//	public String getWcstatus() {
//		return wcstatus;
//	}

	public String getTime() {
		return time;
	}

	public String getResult() {
		return result;
	}

	public String getSymptom() {
		return symptom;
	}

	public String getUnitNo() {
		return unitNo;
	}

//	public void setWcstatus(String wcstatus) {
//		this.wcstatus = wcstatus;
//	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}





	
	
}	