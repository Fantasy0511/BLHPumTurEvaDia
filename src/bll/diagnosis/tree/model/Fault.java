package bll.diagnosis.tree.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bll.diagnosis.tree.GovDBConfig;

/**
 * 调速系统故障树故障名称、位置、建议读取
 * 
 * @author 付文龙
 *
 */
public class Fault {
	int ID;
	String name;
	String location;
	String Recommendation;
	int node;

	public static ArrayList<Fault> TSFaultsRead(String system) {
		ArrayList<Fault> faults = new ArrayList<Fault>();
		Connection dbConn;
		try {
			dbConn = GovDBConfig.getconnection();
			System.out.println("Connection Successful!"); // 如果连接成功
															// 控制台输出Connection
															// Successful!
			Statement stmt = dbConn.createStatement();

			System.out.println("读取数据");
			ResultSet rs0=null;
			if (system.equals("pum")) {
				rs0 = stmt.executeQuery(
						"SELECT * FROM BLH_FaultTree_PumFaultInfor order by ID");
				while (rs0.next()) {
					Fault temp = new Fault();

					temp.ID = rs0.getInt("ID");
					temp.name = rs0.getString("name");
					temp.location = rs0.getString("location");
					temp.Recommendation = rs0.getString("Recommendation");
					faults.add(temp);
				}
			}

			else if (system.equals("gov")) {
				rs0 = stmt.executeQuery(
						"SELECT * FROM BLH_FaultTree_GovFaultInfor order by ID");
				while (rs0.next()) {
					Fault temp = new Fault();

					temp.ID = rs0.getInt("ID");
					temp.name = rs0.getString("name");
					temp.location = rs0.getString("Location");
					temp.Recommendation = rs0.getString("Recommendation");
					faults.add(temp);

				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return faults;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRecommendation() {
		return Recommendation;
	}

	public void setRecommendation(String Recommendation) {
		this.Recommendation = Recommendation;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return "Fault [ID=" + ID + ", name=" + name + ", location=" + location
				+ ", Recommendation=" + Recommendation + ", node=" + node + "]";
	}

}