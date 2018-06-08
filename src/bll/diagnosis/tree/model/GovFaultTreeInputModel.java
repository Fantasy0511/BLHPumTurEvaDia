package bll.diagnosis.tree.model;

import java.util.ArrayList;
import java.util.List;

//import bll.diagnosis.tree.dao.CollectDataRead;
//import bll.diagnosis.tree.dao.JCData;
import bll.diagnosis.tree.dao.JKData;
//import bll.diagnosis.tree.dao.UnitDataRead;
//import com.nari.faultdiagnosis.service.gov.faultdiagnosis.GovFaultTreeService;
import bll.diagnosis.tree.test.dataread;
import service.faulttree.Governor.GovernorfaultBoolDay;
//import sun.net.www.content.text.plain;
import util.PathUtil;
import util.TimeUtils;

public class GovFaultTreeInputModel {

		private int jdxzt;  //剪断销状态
		
	    private	int ftHAlarm;  //集油箱油位高报警
	    private int ftLAlarm;  //集油箱油位低报警
		
	    private	int ptHAlarm;  //压力油罐油位高报警
	    private	int ptLAlarm;  //压力油罐油位低报警
		
	    private	int qiptHAlarm;  //补气系统压力罐压力高报警
	    private	int qiptLAlarm;  //补气系统压力罐压力低报警

	public GovFaultTreeInputModel tstreeanalysis() {
		GovFaultTreeInputModel datas = new GovFaultTreeInputModel();
		
		datas.jdxzt= 1;
		datas.ftHAlarm = 1; //
		datas.ftLAlarm = 0; 
		datas.ptHAlarm = 0;
		datas.ptLAlarm = 1;
		datas.qiptHAlarm = 0;
		datas.qiptLAlarm = 1;

		return datas;
	}


	public GovFaultTreeInputModel tstreeanalysis(String datetime,String UnitNo, String condtionName) {

		GovFaultTreeInputModel datas = new GovFaultTreeInputModel();
		GovernorfaultBoolDay dataflag=new GovernorfaultBoolDay();
		
		// 从数据库监控数据表中读取的开关量
	  //开关量取当日最新值
		long time=TimeUtils.StringtoLong(datetime);
		int  No=Integer.parseInt(UnitNo);
		datas.jdxzt= dataflag.getShearpinfault(time, No);
		datas.ftHAlarm=dataflag.gettankoilhigh(time, No);
		datas.ftLAlarm=dataflag.gettankoillow(time, No);
		datas.ptHAlarm=dataflag.getPressuretankoilhigh(time, No);
		datas.ptLAlarm=dataflag.gettankoillow(time, No);
		datas.qiptHAlarm=dataflag.getFilltankpressurehigh(time, No);
		datas.qiptLAlarm=dataflag.getFilltankpressurelow(time, No);
		
		return datas;
		
	}


	public int getJdxzt() {
		return jdxzt;
	}


	public int getFtHAlarm() {
		return ftHAlarm;
	}


	public int getFtLAlarm() {
		return ftLAlarm;
	}


	public int getPtHAlarm() {
		return ptHAlarm;
	}


	public int getPtLAlarm() {
		return ptLAlarm;
	}


	public int getQiptHAlarm() {
		return qiptHAlarm;
	}


	public int getQiptLAlarm() {
		return qiptLAlarm;
	}


	public void setJdxzt(int jdxzt) {
		this.jdxzt = jdxzt;
	}


	public void setFtHAlarm(int ftHAlarm) {
		this.ftHAlarm = ftHAlarm;
	}


	public void setFtLAlarm(int ftLAlarm) {
		this.ftLAlarm = ftLAlarm;
	}


	public void setPtHAlarm(int ptHAlarm) {
		this.ptHAlarm = ptHAlarm;
	}


	public void setPtLAlarm(int ptLAlarm) {
		this.ptLAlarm = ptLAlarm;
	}


	public void setQiptHAlarm(int qiptHAlarm) {
		this.qiptHAlarm = qiptHAlarm;
	}


	public void setQiptLAlarm(int qiptLAlarm) {
		this.qiptLAlarm = qiptLAlarm;
	}
	
	

}
