package bll.diagnosis.tree.model;

import java.util.ArrayList;
import java.util.List;

//import bll.diagnosis.tree.dao.CollectDataRead;
//import bll.diagnosis.tree.dao.JCData;
import bll.diagnosis.tree.dao.JKPData;

//import bll.diagnosis.tree.dao.UnitDataRead;

import bll.diagnosis.tree.test.dataread;
import service.faulttree.pumptur.PumpturBFault;
import service.faulttree.pumptur.PumpturFFault;
import util.PathUtil;
import util.TimeUtils;





public class PumFaultTreeInputModel {

	private int lqsyc;// 冷却水异常
	private int yxtyc; // 油系统异常
	private int dzbdyc=0; // 大轴摆度异常
	
	
	private int jdxgz; // 剪断销故障
	
	private int sdbdyc; // 水导摆度异常
	private int wsgswg; // 尾水管水位过高
	
	private int zwwdyc; // 轴瓦温度异常
	private int zzmfyc=0; // 主轴密封异常
	private int wkgz; // 蜗壳故障

	private int lqslld=0; // 冷却水流量低
	private int lqsswg=0;//冷却水水温高
	private int lqssyyc=0;//冷却水水压异常
	private int yxtyyd=0;//油系统油压低
	private int yxtywyc=0;//油系统油位异常
	private int yxtywg=0;//油系统油温高
	private int yxyyhs=0;//油系统油混水
	private int zczdyc=0;//轴承振动异常
	private int bjxhwb=0;//报警信号误报
	private int jzzsgg=0;//机组转速过高
	
	
	private int shdbdyc=0; // 上导摆度异常
	private int xdbdyc=0; // 下导摆度异常
	private int dbph=0; // 动不平衡
	private int lcdlbph=0; // 磁拉力不平衡
	private int sjjzd=0;//上机架振动
	private int xjjzd=0;//下机架振动
	private int wsgylmd=0;//尾水管压力脉动
	private int dzgdbl=0;//定子固定不良
	private double f0;
	private double f1;
	private double f2;
	private double f3;
	private double f4;
	private double f5;
	private double f6;
	private double f7;
	private double f8;
	private double f9;
	private double f10;
	private double f11;
	private double f12;
	private double f13;
	private double f14;
	private double f15;
	private double f16;
	private double f17;
	private double f18;
	/*public PumFaultTreeInputModel tstreeanalysis() {
		PumFaultTreeInputModel datas = new PumFaultTreeInputModel();

		/*datas.mgt = new ArrayList<Double>();
		datas.zczb = new ArrayList<Double>();*/

		/*for (int i = 0; i < 70; i++) {

			/*datas.mgt.add((double) 1);
			datas.zczb.add((double) 0.5); /
*/	/*	}
		datas.lqsyc = 1;
		datas.yxtyc = 1; //
		datas.dzbdyc = 0;
		datas.dbph = 0;
		datas.lcdlbph = 1;
		datas.jdxgz = 0;
		datas.shdbdyc = 1;
		datas.xdbdyc = 0;
		datas.sdbdyc = 1;
		datas.wsgswg = 1;
		datas.lqslld = 0;
		datas.zwwdyc = 1;
		datas.zzmfyc = 0;
		datas.wkgz = 0;

		return datas;
	}*/

	public PumFaultTreeInputModel tstreeanalysis(String datetime, String UnitNo, String condtionName) {

		PumFaultTreeInputModel datas = new PumFaultTreeInputModel();
		// String dateBegin = TimeUtil.addDay(datetime, -170); //
		// 取查询时间的前7天作为开始时间（已经改正为取最近的一条记录）
		// List<JKPData> jkList = UnitDataRead.readOilData(Integer.parseInt(UnitNo),
		// datetime);
		// datas.T = new ArrayList<Integer>(); //时间
		PumpturBFault dataflag = new PumpturBFault();
		PumpturFFault dataflagf = new PumpturFFault();
		
		// 从数据库监控数据表中读取的模拟量
		/*
		 * for (int i = 0; i < jkList.size(); i++) { JKPData tempData = jkList.get(i);
		 * datas.T.add(i);
		 * 
		 * datas.kdgd.add(tempData.getKdgd());
		 * datas.unitloadset.add(tempData.getUnitloadset());
		 * 
		 * datas.pt.add(tempData.getPt());
		 * 
		 * }
		 */
		// 从数据库监控数据表中读取的开关量
		// 开关量取最新值
		long time=TimeUtils.StringtoLong(datetime);
		int  No=Integer.parseInt(UnitNo);
		
	
		
		
	//	datas.lqsyc = dataflag.getCWaterFault(time, No);
	//	datas.yxtyc = dataflag.getOilFault(time, No);
		
	//	datas.jdxgz = dataflag.getBreakpinFault(time, No);
		
	//	datas.sdbdyc = dataflag.getWguideFault(time, No);
	//	datas.lqslld = dataflag.getCoolWLow(time, No);
	//	datas.wsgswg = dataflag.getExWPipeFault(time, No);
	//	datas.zwwdyc = dataflag.getBearingBushHot(time, No);
	
	//	datas.wkgz = dataflag.getVoluteFault(time, No);
		f0=dataflag.getAxleSealFault(time, No);
		if(f0>0) {datas.zzmfyc=1;}
		f1=dataflagf.getWaterFLFault(time, No);
		if(f1>0) {datas.lqslld=1;}
	
		f2=dataflagf.getWaterTHFault(time, No);
	if(f2>0) {datas.lqsswg=1;}
		
	f3=dataflagf.getWaterPLFault(time, No);
	if(f3>0) {datas.lqssyyc=1;}
	
	f4=dataflagf.getOilPLFault(time, No);
	if(f4>0) {datas.yxtyyd=1;}
	
	f5=dataflagf.getOilHFFault(time, No);
	if(f5>0) {datas.yxtywyc=1;}
	
	f6=dataflagf.getOilWWFault(time, No);
	if(f6>0) {datas.yxyyhs=1;}
	
	
	f7=dataflag.getAxleViFault(time, No);
	if(f7>0) {datas.dzbdyc=1;}
	
	f8=dataflagf.getOilTHFault(time, No);
	if(f8>0) {datas.yxtywg=1;}
	
	f9=dataflagf.getVibFault(time, No);
	if(f9>0) {datas.zczdyc=1;}
	
	f10=dataflagf.getRspeedHFault(time, No);
	if(f10>0) {datas.jzzsgg=1;}
	
	f11=dataflagf.getDraftPressure(time, No);
	if(f11>0) {datas.wsgylmd=1;}
	
	f12=dataflag.getUpguideFault(time, No);
	if(f12>0) {datas.shdbdyc=1;}
	f13=dataflag.getLoguideFault(time, No);
	if(f13>0) {datas.xdbdyc=1;}
	f14=dataflag.getUnbalance(time, No);
	if(f14>0) {datas.dbph=1;}
	f15=dataflag.getExCurrentFault(time, No);
	if(f15>0) {datas.lcdlbph=1;}
	f16=dataflag.getUpFrame(time, No);
	if(f16>0) {datas.sjjzd=1;}
	f17=dataflag.getLowFrame(time, No);
	if(f17>0) {datas.xjjzd=1;}
	f18=dataflag.getStatorFault(time, No);
	if(f18>0) {datas.dzgdbl=1;}
	
	
		// 从数据库的采集表读取到的波形数据，包括机频，网频，导叶开度，导叶反馈，有功功率和功率反馈
		/*
		 * List<JCData> jcList =
		 * CollectDataRead.readFromCollector(Integer.parseInt(UnitNo), datetime); for
		 * (int i = 0; i < jcList.get(0).getPower().length; i++){
		 * datas.pf.add(jcList.get(0).getPower()[i]);
		 * datas.unitload.add(jcList.get(0).getPower()[i]); } for (int i = 0; i <
		 * jcList.get(0).getFre_unit().length; i++){
		 * datas.f.add(jcList.get(0).getFre_unit()[i]);
		 * datas.wp.add(jcList.get(0).getFre_unit()[i]); } for (int i = 0; i <
		 * jcList.get(0).getXc_guidevane().length; i++){
		 * datas.y.add(jcList.get(0).getXc_guidevane()[i]);
		 * datas.dyfk.add(jcList.get(0).getXc_guidevane()[i]); }
		 */
		return datas;
	}

	public int getLqsyc() {
		return lqsyc;
	}

	public int getYxtyc() {
		return yxtyc;
	}

	public int getDzbdyc() {
		return dzbdyc;
	}

	public int getDbph() {
		return dbph;
	}

	public int getLcdlbph() {
		return lcdlbph;
	}

	public int getJdxgz() {
		return jdxgz;
	}

	public int getShdbdyc() {
		return shdbdyc;
	}

	public int getXdbdyc() {
		return xdbdyc;
	}

	public int getSdbdyc() {
		return sdbdyc;
	}

	public int getWsgswg() {
		return wsgswg;
	}

	public int getLqslld() {
		return lqslld;
	}

	public int getZwwdyc() {
		return zwwdyc;
	}

	public int getZzmfyc() {
		return zzmfyc;
	}

	public int getWsgylmd() {
		return wsgylmd;
	}

	public int getWkgz() {
		return wkgz;
	}
	
	
	public int getSjjzd() {
		return sjjzd;
	}public int getXjjzd() {
		return xjjzd;
	}public int getDzgdbl() {
		return dzgdbl;
	}
	
	public int getLqsswg() {
		return lqsswg;
	}public int getLqssyyc() {
		return lqssyyc;
	}public int getYxtyyd() {
		return yxtyyd;
	}public int getYxtywyc() {
		return yxtywyc;
	}public int getYxtywg() {
		return yxtywg;
	}public int getYxyyhs() {
		return yxyyhs;
	}public int getZczdyc() {
		return zczdyc;
	}public int getBjxhwb() {
		return bjxhwb;
	}public int getJzzsgg() {
		return jzzsgg;
	}
	
	
	public void setSjjzd(int sjjzd) {
		this.sjjzd = sjjzd;
	}public void setXjjzd(int xjjzd) {
		this.xjjzd = xjjzd;
	}public void setDzgdbl(int dzgdbl) {
		this.dzgdbl = dzgdbl;
	}
	
	
	
	
	
	public void setWsgylmd(int wsgylmd) {
		this.wsgylmd = wsgylmd;
	}
	
	public void setLqsyc(int lqsyc) {
		this.lqsyc = lqsyc;
	}

	public void setYxtyc(int yxtyc) {
		this.yxtyc = yxtyc;
	}

	public void setDzbdyc(int dzbdyc) {
		this.dzbdyc = dzbdyc;
	}

	public void setDbph(int dbph) {
		this.dbph = dbph;
	}

	public void setLcdlbph(int lcdlbph) {
		this.lcdlbph = lcdlbph;
	}

	public void setJdxgz(int jdxgz) {
		this.jdxgz = jdxgz;
	}

	public void setShdbdyc(int shdbdyc) {
		this.shdbdyc = shdbdyc;
	}

	public void setXdbdyc(int xdbdyc) {
		this.xdbdyc = xdbdyc;
	}

	public void setSdbdyc(int sdbdyc) {
		this.sdbdyc = sdbdyc;
	}

	public void setWsgswg(int wsgswg) {
		this.wsgswg = wsgswg;
	}

	public void setLqslld(int lqslld) {
		this.lqslld = lqslld;
	}

	public void setZwwdyc(int zwwdyc) {
		this.zwwdyc = zwwdyc;
	}

	public void setZzmfyc(int zzmfyc) {
		this.zzmfyc = zzmfyc;
	}

	public void setWkgz(int wkgz) {
		this.wkgz = wkgz;
	}

	public void setLqsswg(int lqsswg) {
		this.lqsswg = lqsswg;
	}
	public void setLqssyyc(int lqssyyc) {
		this.lqssyyc = lqssyyc;
	}
	public void setYxtyyd(int yxtyyd) {
		this.yxtyyd = yxtyyd;
	}
	public void setYxtywyc(int yxtywyc) {
		this.yxtywyc = yxtywyc;
	}
	public void setYxtywg(int yxtywg) {
		this.yxtywg = yxtywg;
	}
	public void setYxyyhs(int yxyyhs) {
		this.yxyyhs = yxyyhs;
	}
	public void setZczdyc(int zczdyc) {
		this.zczdyc = zczdyc;
	}
	public void setBjxhwb(int bjxhwb) {
		this.bjxhwb = bjxhwb;
	}
	public void setJzzsgg(int jzzsgg) {
		this.jzzsgg = jzzsgg;
	}
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * GovFaultTreeInputModel datas = new GovFaultTreeInputModel()
	 * .tstreeanalysis();
	 * 
	 * for (int i = 0; i < datas.f.size(); i++) { System.out.print(datas.T.get(i) +
	 * "   "); System.out.print(datas.f.get(i) + "   ");
	 * System.out.print(datas.y.get(i) + "   "); System.out.println(datas.jzgk); }
	 * 
	 * System.out.println(datas.T.size()); }
	 */


}
