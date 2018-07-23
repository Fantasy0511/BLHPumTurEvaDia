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
import service.faulttree.Governor.GovernorfaultDouble;
//import sun.net.www.content.text.plain;
import util.PathUtil;
import util.TimeUtils;

public class GovFaultTreeInputModel {

		private int jdxzt;  //剪断销状态
		
	    private	int ftHAlarm;  //集油箱油位高报警
	    private int ftLAlarm;  //集油箱油位低报警
		
	    private	int ptHAlarm;  //压力油罐油位高报警
	    private	int ptLAlarm;  //压力油罐油位低报警
	    
	    private int ptAirLeak; //压油罐漏气

		private int sysOilSpill;//系统漏油
	    
	    private int LowEff; //油泵效率低
	    
	    private int OilPFailure;//油泵不能正常启动
	    
	 public int getOilSpill() {
			return OilSpill;
		}


		public void setOilSpill(int oilSpill) {
			OilSpill = oilSpill;
		}


		public int getPreviewLow() {
			return PreviewLow;
		}


		public void setPreviewLow(int previewLow) {
			PreviewLow = previewLow;
		}


		public int getFrequentH() {
			return FrequentH;
		}


		public void setFrequentH(int frequentH) {
			FrequentH = frequentH;
		}


	private  int OilSpill;//耗油速度偏大
		
	 private int PreviewLow;//大油量偏低
		
	 private int FrequentH;//油泵开启频繁

	public int getOilPFailure() {
			return OilPFailure;
		}


		public void setOilPFailure(int oilPFailure) {
			OilPFailure = oilPFailure;
		}


	public GovFaultTreeInputModel tstreeanalysis() {
		GovFaultTreeInputModel datas = new GovFaultTreeInputModel();
		
		datas.jdxzt= 1;
		datas.ftHAlarm = 1; //
		datas.ftLAlarm = 0; 
		datas.ptHAlarm = 0;
		datas.ptLAlarm = 1;
		datas.ptAirLeak=0;
		datas.sysOilSpill=1;
		datas.OilSpill=1;
		datas.LowEff=0;
		datas.FrequentH=0;
		datas.PreviewLow=0;
		datas.OilPFailure=1;

		return datas;
	}


	public GovFaultTreeInputModel tstreeanalysis(String datetime,String UnitNo, String condtionName) {

		GovFaultTreeInputModel datas = new GovFaultTreeInputModel();
		GovernorfaultBoolDay dataflag=new GovernorfaultBoolDay();
		GovernorfaultDouble dataflags=new GovernorfaultDouble();
		
		// 从数据库监控数据表中读取的开关量
	  //开关量取当日最新值
		long time=TimeUtils.StringtoLong(datetime);
		int  No=Integer.parseInt(UnitNo);
		datas.jdxzt= dataflag.getShearpinfault(time, No);
		datas.ftHAlarm=dataflag.gettankoilhigh(time, No);
		datas.ftLAlarm=dataflag.gettankoillow(time, No);
		datas.ptHAlarm=dataflag.getPressuretankoilhigh(time, No);
		datas.ptLAlarm=dataflag.gettankoillow(time, No);
		datas.ptAirLeak=dataflags.Airleak(time, No);
		datas.OilSpill=dataflags.OilSpill(time, No);
		if(datas.OilSpill==1){
			datas.sysOilSpill=1;
		}else{
			datas.sysOilSpill=0;
		}
		datas.FrequentH=dataflag.getPumpEfficiency(time, No);
		datas.PreviewLow=dataflags.PreviewLow(time, No);
		if(	datas.FrequentH ==1 & datas.PreviewLow==1 ){
			datas.LowEff=1;
		}else{
			datas.LowEff=0;
		}
		datas.OilPFailure=dataflag.getOilPFailure(time, No);

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
    public int getPtAirLeak() {
			return ptAirLeak;
		}


		public void setPtAirLeak(int ptAirLeak) {
			this.ptAirLeak = ptAirLeak;
		}


		public int getSysOilSpill() {
			return sysOilSpill;
		}


		public void setSysOilSpill(int sysOilSpill) {
			this.sysOilSpill = sysOilSpill;
		}


		public int getLowEff() {
			return LowEff;
		}


		public void setLowEff(int lowEff) {
			LowEff = lowEff;
		}

}
