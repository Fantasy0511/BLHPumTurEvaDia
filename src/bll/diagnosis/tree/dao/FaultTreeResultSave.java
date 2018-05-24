package bll.diagnosis.tree.dao;

/** 
* @author xyh
* @version 创建时间：2016年6月20日 下午4:39:56 
* 故障树结果保存 
*/
public class FaultTreeResultSave {
	
	public static void save(FaultTreeResult ftr)
		{
		//	String wcstatus=ftr.getWcstatus();
			String time=ftr.getTime();
			String result=ftr.getResult();
			String symptom=ftr.getSymptom();
			int    unitNo=ftr.getUnitNo(); 

			String sql = "Insert into BLH_FaultTree_Result(";
		//	sql = sql + "WC_Status, ";
			sql = sql + "Time, ";
			sql = sql + "Result, ";
			sql = sql + "Symptom, ";
			sql = sql + "UnitNo) values(";
		//	sql = sql + wcstatus + ", ";
			sql = sql + time + ",'";
			sql = sql + result + "','";
			sql = sql + symptom + "','";
			sql = sql + unitNo + "')";

		}
}
