package bll.diagnosis.tree.model;

import java.util.ArrayList;
import java.util.List;

//import bll.diagnosis.tree.dao.CollectDataRead;
//import bll.diagnosis.tree.dao.JCData;
import bll.diagnosis.tree.dao.JKPData;
//import bll.diagnosis.tree.dao.UnitDataRead;

import bll.diagnosis.tree.test.dataread;
import service.faulttree.pumptur.PumpturBFaultDay;
import util.PathUtil;
import util.TimeUtils;

public class PumFaultTreeInputModel {

	private int lqsyc;// 冷却水异常
	private int yxtyc; // 油系统异常
	private int dzbdyc; // 大轴摆度异常
	private int dbph; // 动不平衡
	private int lcdlbph; // 励磁电流不平衡
	private int jdxgz; // 剪断销故障
	private int shdbdyc; // 上导摆度异常
	private int xdbdyc; // 下导摆度异常
	private int sdbdyc; // 水导摆度异常
	private int wsgswg; // 尾水管水位过高
	private int lqslld; // 冷却水流量低
	private int zwwdyc; // 轴瓦温度异常
	private int zzmfyc; // 主轴密封异常
	private int wkgz; // 蜗壳故障
	/*private List<Double> mgt;// 迷宫环温度
	private List<Double> zczb;// 轴承振摆
*/
	public PumFaultTreeInputModel tstreeanalysis() {
		PumFaultTreeInputModel datas = new PumFaultTreeInputModel();

		/*datas.mgt = new ArrayList<Double>();
		datas.zczb = new ArrayList<Double>();*/

		for (int i = 0; i < 70; i++) {

			/*datas.mgt.add((double) 1);
			datas.zczb.add((double) 0.5); //
*/		}
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
	}

	public PumFaultTreeInputModel tstreeanalysis(String datetime, String UnitNo, String condtionName) {

		PumFaultTreeInputModel datas = new PumFaultTreeInputModel();
		// String dateBegin = TimeUtil.addDay(datetime, -170); //
		// 取查询时间的前7天作为开始时间（已经改正为取最近的一条记录）
		// List<JKPData> jkList = UnitDataRead.readOilData(Integer.parseInt(UnitNo),
		// datetime);
		// datas.T = new ArrayList<Integer>(); //时间
		PumpturBFaultDay dataflag = new PumpturBFaultDay();

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
		
		datas.lqsyc = dataflag.getCWaterFault(time, No);
		datas.yxtyc = dataflag.getOilFault(time, No);
		datas.dzbdyc = dataflag.getAxleViFault(time, No);
		datas.dbph = dataflag.getUnbalance(time, No);
		datas.lcdlbph = dataflag.getExCurrentFault(time, No);
		datas.jdxgz = dataflag.getBreakpinFault(time, No);
		datas.shdbdyc = dataflag.getUpguideFault(time, No);
		datas.xdbdyc = dataflag.getLoguideFault(time, No);
		datas.sdbdyc = dataflag.getWguideFault(time, No);
		datas.lqslld = dataflag.getCoolWLow(time, No);
		datas.wsgswg = dataflag.getExWPipeFault(time, No);
		datas.zwwdyc = dataflag.getBearingBushHot(time, No);
		datas.zzmfyc = dataflag.getAxleSealFault(time, No);
		datas.wkgz = dataflag.getVoluteFault(time, No);

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

	public int getWkgz() {
		return wkgz;
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
