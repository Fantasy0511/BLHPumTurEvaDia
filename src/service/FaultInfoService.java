package service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.impl.ReadData;
import util.DataInfo;
import util.DataUtils;
import util.FaultUtils;

/**
 * 获取故障相关数据
 * @author lh
 * */
public class FaultInfoService {
	
	/**
	 * 获取指定子系统的所有故障样本,参数中的code已转化为中文
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * */
	public List<FaultUtils> getFaultInfos(String system,Long startTime,Long endTime) throws ClassNotFoundException, SQLException{
		ReadData rd = new ReadData();
		List<FaultUtils> faultInfos= rd.queFault(system,startTime,endTime);
		HashMap<String, DataInfo> maps = rd.queInfo();
		for(FaultUtils faultInfo:faultInfos){
			String[] parameters = faultInfo.getParamters().split(" ");
			for(int i=0;i<parameters.length;i++){
				DataInfo dataInfo = maps.get(parameters[i]);
				parameters[i] = dataInfo.getPosition()+"."+dataInfo.getDescription()+"("+parameters[i]+")";
			}
			faultInfo.setParamters(String.join(" ", parameters));
		}
		return faultInfos;
	}
	
	/**
	 * 获取参数在故障时间范围内的值
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws NumberFormatException 
	 * */
	public DataUtils getData(String typeid,String startTime,String endTime) throws NumberFormatException, ClassNotFoundException, SQLException{
		ReadData rd = new ReadData();
		String pattern = "(\\D*)(\\d+)(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(typeid);
		if (m.find( )) {
			return rd.queRecord(m.group(1), Integer.parseInt(m.group(2)), startTime, endTime);
	      }
		return null;
		
	}
	
	public static void main(String[] args){
//		FaultInfoService faultInfoService = new FaultInfoService();
//		List<FaultUtils> faultUtils=faultInfoService.getFaultInfos("水泵水轮机");
//		DataUtils data = faultInfoService.getData("bool1132", faultUtils.get(0).getStartTimeString(), faultUtils.get(0).getEndTimeSting());
		String regEx = "统计数据\\.|运行参数\\.|虚设备\\.|电气参数\\.";
		String name ="升压站.500KV莲吉线.电气参数.总无功_过高";
		Pattern p = Pattern.compile(regEx);
	    Matcher m = p.matcher(name);
	    if (m.find()) {
	    	name = m.replaceAll("");
	    }
		System.out.println(name);
	}
}
