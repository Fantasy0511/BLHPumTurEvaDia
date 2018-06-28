package bll.diagnosis.tree.model;
import java.util.ArrayList;
import java.util.List;
import bll.diagnosis.tree.dao.JKMData;
import bll.diagnosis.tree.test.dataread;
import service.faulttree.MainTransformer. MainTransformerfaultBoolDay;
import util.PathUtil;
import util.TimeUtils;
public class MtFaultTreeInputModel {
	private int  CoolerF;//冷却器故障
	
	private int ACPowerF;//交流电源故
		
	private int CoolingWF;//冷却水泄露报警
	
	  public MtFaultTreeInputModel tstreeanalysis() {
		  MtFaultTreeInputModel datas=new MtFaultTreeInputModel();
		  
		  datas.CoolerF=0;//冷却器故障
		  datas.ACPowerF=1;//交流电源故
		  datas.CoolingWF=0;//冷却水泄露报警
		  
		  return datas;
	  }
	  
	  public MtFaultTreeInputModel tstreeanalysis(String datetime,String UnitNo, String condtionName) {
		  MtFaultTreeInputModel datas=new MtFaultTreeInputModel();
		  MainTransformerfaultBoolDay datasflag=new MainTransformerfaultBoolDay();
		  
		  long time=TimeUtils.StringtoLong(datetime);
			int  No=Integer.parseInt(UnitNo);
			
			datas.CoolerF=datasflag.getCoolerFailure(time, No);
			datas.ACPowerF=datasflag.getACPowerFailure(time, No);
			datas.CoolingWF=datasflag.CoolingWaterLeak(time, No);
			
			return datas;
	  }
	  public int getCoolerF() {
			return CoolerF;
		}

		public void setCoolerF(int coolerF) {
			CoolerF = coolerF;
		}

		public int getACPowerF() {
			return ACPowerF;
		}

		public void setACPowerF(int aCPowerF) {
			ACPowerF = aCPowerF;
		}

		public int getCoolingWF() {
			return CoolingWF;
		}

		public void setCoolingWF(int coolingWF) {
			CoolingWF = coolingWF;
		}
}
