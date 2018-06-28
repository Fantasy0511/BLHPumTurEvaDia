package bll.diagnosis.tree.model;
import java.util.ArrayList;
import java.util.List;
import bll.diagnosis.tree.dao.JKBData;
import bll.diagnosis.tree.test.dataread;
import service.faulttree.BallValve.BallValvefaultBoolDay;
import util.PathUtil;
import util.TimeUtils;
public class BlvFaultTreeInputModel {
  private  int ptPLAlarm;//压力油罐油压低
	
private int ptOHAlarm;//压力油罐油位高
  private int ptOlAlarm;//压力油罐油位低
  
  public BlvFaultTreeInputModel tstreeanalysis() {
	  BlvFaultTreeInputModel datas=new BlvFaultTreeInputModel();
	  
	  datas.ptPLAlarm=0;//压力油罐油压低
	  datas.ptOHAlarm=1;//压力油罐油位高
	  datas.ptOlAlarm=0;//压力油罐油位低
	  return datas;
  }
  
  public BlvFaultTreeInputModel tstreeanalysis(String datetime,String UnitNo, String condtionName) {
	  
	  BlvFaultTreeInputModel datas=new BlvFaultTreeInputModel();
	  BallValvefaultBoolDay datasflag=new  BallValvefaultBoolDay();
	  
	  long time=TimeUtils.StringtoLong(datetime);
		int  No=Integer.parseInt(UnitNo);
		
		datas.ptPLAlarm=datasflag.getPressuretankpressurelow(time, No);
		datas.ptOHAlarm=datasflag.gettankoilhigh(time, No);
		datas.ptPLAlarm=datasflag.gettankoillow(time, No);
		
		return datas;
  }
  
  public int getPtPLAlarm() {
	return ptPLAlarm;
}

public void setPtPLAlarm(int ptPLAlarm) {
	this.ptPLAlarm = ptPLAlarm;
}

public int getPtOHAlarm() {
	return ptOHAlarm;
}

public void setPtOHAlarm(int ptOHAlarm) {
	this.ptOHAlarm = ptOHAlarm;
}

public int getPtOlAlarm() {
	return ptOlAlarm;
}

public void setPtOlAlarm(int ptOlAlarm) {
	this.ptOlAlarm = ptOlAlarm;
}
}
