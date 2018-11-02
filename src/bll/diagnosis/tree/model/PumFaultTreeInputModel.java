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

	private int lqsyc= 0;// 冷却水异常
	private int yxtyc= 0; // 油系统异常
	private int dzbdyc = 0; // 大轴摆度异常
	private int zwwdyc= 0; // 轴瓦温度异常
	private int zzmfyc = 0; // 主轴密封异常
	private int lqslld = 0; // 冷却水流量低
	private int lqsswg = 0;// 冷却水水温高
	private int lqssyyc = 0;// 冷却水水压低
	private int yxtyyd = 0;// 油系统油压低
	private int yxtywyc = 0;// 油系统油位低
	private int yxtywg = 0;// 油系统油温高
	private int yxyyhs = 0;// 油系统油混水
	private int zczdyc = 0;// 轴承振动异常
	private int bjxhwb = 0;// 报警信号误报
	
	private int xhybgz = 0;// 循环油泵故障
	private int ybzcks = 0;// 油泵轴承卡涩
	private int lqqnbds = 0;// 冷却器内部堵塞
	private int zwjxbj = 0;// 轴瓦间隙不均
	private int hlgz = 0;// 回路故障
	
	private int shdbdyc = 0; // 上导摆度异常
	private int xdbdyc = 0; // 下导摆度异常
	private int dbph = 0; // 动不平衡
	private int lcdlbph = 0; // 磁拉力不平衡
	private int sjjzd = 0;// 上机架振动
	private int xjjzd = 0;// 下机架振动
	private int dzgdbl = 0;// 定子固定不良
	
	private int thgz = 0;// 弹簧故障
	private int jyfgz = 0;// 减压阀故障
	private int glqds = 0;// 过滤器堵塞
	private int cxdjgz = 0;// 冲洗电机故障
	private int cyhlgz = 0;// 测压回路故障
	
	private int gljq = 0;// 管路进气
	private int llyc = 0;// 流量异常
	private int ylyc = 0;// 压力异常
	private int hlstyc = 0;// 回路异常渗漏
	private int ylzd = 0;// 压力振荡
	
	
	
	
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
	private double f19;
	private double f20;
	private double f21;
	private double f22;
	private double f23;
	private double f24;
	private double f25;
	private double f26;
	private double f27;
	private double f28;
	private double f29;
	
	

	public PumFaultTreeInputModel tstreeanalysis(String datetime, String UnitNo, String condtionName) {

		PumFaultTreeInputModel datas = new PumFaultTreeInputModel();

		PumpturBFault dataflag = new PumpturBFault();
		PumpturFFault dataflagf = new PumpturFFault();

		// 从数据库监控数据表中读取的开关量
		// 开关量取最新值
		long time = TimeUtils.StringtoLong(datetime);
		int No = Integer.parseInt(UnitNo);

		f0 = dataflag.getAxleSealFault(time, No);
		if (f0 > 0) {
			datas.zzmfyc = 1;
		}
		f1 = dataflagf.getWaterFLFault(time, No);
		if (f1 > 0) {
			datas.lqslld = 1;
		}

		f2 = dataflagf.getWaterTHFault(time, No);
		if (f2 > 0) {
			datas.lqsswg = 1;
		}

		f3 = dataflagf.getWaterPLFault(time, No);
		if (f3 > 0) {
			datas.lqssyyc = 1;
		}

		f4 = dataflagf.getOilPLFault(time, No);
		if (f4 > 0) {
			datas.yxtyyd = 1;
		}

		f5 = dataflagf.getOilHFFault(time, No);
		if (f5 > 0) {
			datas.yxtywyc = 1;
		}

		f6 = dataflagf.getOilWWFault(time, No);
		if (f6 > 0) {
			datas.yxyyhs = 1;
		}

		f7 = dataflag.getAxleViFault(time, No);
		if (f7 > 0) {
			datas.dzbdyc = 1;
		}

		f8 = dataflagf.getOilTHFault(time, No);
		if (f8 > 0) {
			datas.yxtywg = 1;
		}

		f9 = dataflagf.getVibFault(time, No);
		if (f9 > 0) {
			datas.zczdyc = 1;
		}

		f10 = dataflagf.getShuidaoPressure(time, No);
		f11 = dataflagf.getShuidaoLevel(time, No);
	
		if (f10 > 0 && f11>0) {
			datas.xhybgz = 1;
		}

		f12 = dataflag.getUpguideFault(time, No);
		if (f12 > 0) {
			datas.shdbdyc = 1;
		}
		f13 = dataflag.getLoguideFault(time, No);
		if (f13 > 0) {
			datas.xdbdyc = 1;
		}
		f14 = dataflag.getUnbalance(time, No);
		if (f14 > 0) {
			datas.dbph = 1;
		}
		f15 = dataflag.getExCurrentFault(time, No);
		if (f15 > 0) {
			datas.lcdlbph = 1;
		}
		f16 = dataflag.getUpFrame(time, No);
		if (f16 > 0) {
			datas.sjjzd = 1;
		}
		f17 = dataflag.getLowFrame(time, No);
		if (f17 > 0) {
			datas.xjjzd = 1;
		}
		f18 = dataflag.getStatorFault(time, No);
		if (f18 > 0) {
			datas.dzgdbl = 1;
		}
		
		f19 = dataflag.getBearingBushHot(time, No);
		if (f10 > 0 && f19>0) {
			datas.lqqnbds = 1;
		}
		f20 = dataflag.getOilPumpFault(time, No);
		if (f20 > 0) {
			datas.ybzcks = 1;
		}
		if (f19>0 && f10 == 0 ) {
			datas.zwjxbj = 1;
		}
		if (f4>0 && f5 > 0 ) {
			datas.hlgz = 1;
		}
		
		f21 = dataflag.getYaChaDi(time, No);
		f22 = dataflagf.getMiFengMoSun(time, No);
		f23 = dataflagf.getMiFengLiuLiang(time, No);
		if (f22>0 && f23>0) {
			datas.thgz = 1;
		}
		f24 = dataflagf.getZhuZhouYaLiL(time, No);
		if (f21 == 1){
			datas.jyfgz = 1;
		}
		
		if (f21 > 0&&f21<1) {
			datas.glqds = 1;
		}
		
		if (f24>0  && f23>0 ) {
			datas.cxdjgz = 1;
		}
		f25 = dataflagf.getZhuZhouBoDong(time, No);
		if (f25>0 ) {
			datas.cyhlgz = 1;
		}
		f26 = dataflagf.getMiGongLiuLiang(time, No);
		f27 = dataflagf.getMiGongBoDong(time, No);
		f28 = dataflagf.getMiGongYaLiH(time, No);
		f29 = dataflagf.getMiGongYaLiL(time, No);
		if (f26>0 && f27>0 ) {
			datas.gljq = 1;
		}
		if (f26>0 && f27==0) {
			datas.llyc = 1;
		}
		if (f28>0 ) {
			datas.ylyc = 1;
		}
		if (f26>0 && f29>0 ) {
			datas.hlstyc = 1;
		}
		if (f27>0 && f26==0 ) {
			datas.ylzd = 1;
		}
	
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

	public int getShdbdyc() {
		return shdbdyc;
	}

	public int getXdbdyc() {
		return xdbdyc;
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


	public int getSjjzd() {
		return sjjzd;
	}

	public int getXjjzd() {
		return xjjzd;
	}

	public int getDzgdbl() {
		return dzgdbl;
	}

	public int getLqsswg() {
		return lqsswg;
	}

	public int getLqssyyc() {
		return lqssyyc;
	}

	public int getYxtyyd() {
		return yxtyyd;
	}

	public int getYxtywyc() {
		return yxtywyc;
	}

	public int getYxtywg() {
		return yxtywg;
	}

	public int getYxyyhs() {
		return yxyyhs;
	}

	public int getZczdyc() {
		return zczdyc;
	}

	public int getXhybgz() {
		return xhybgz;
	}

	public int getYbzcks() {
		return ybzcks;
	}
	public int getLqqnbds() {
		return lqqnbds;
	}
	public int getZwjxbj() {
		return zwjxbj;
	}
	public int getHlgz() {
		return hlgz;
	}
	public int getThgz() {
		return thgz;
	}
	public int getJyfgz() {
		return jyfgz;
	}
	public int getGlqds() {
		return glqds;
	}
	public int getBjxhwb() {
		return bjxhwb;
	}
	
	
	public int getCxdjgz() {
		return cxdjgz;
	}
	public int getCyhlgz() {
		return cyhlgz;
	}
	public int getGljq() {
		return gljq;
	}
	public int getLlyc() {
		return llyc;
	}
	public int getYlyc() {
		return ylyc;
	}
	public int getHlstyc() {
		return hlstyc;
	}
	public int getYlzd() {
		return ylzd;
	}
	
	public void setXhybgz(int xhybgz) {
		this.xhybgz = xhybgz;
	}
	public void setYbzcks(int ybzcks) {
		this.ybzcks = ybzcks;
	}
	public void setLqqnbds(int lqqnbds) {
		this.lqqnbds = lqqnbds;
	}
	public void setZwjxbj(int zwjxbj) {
		this.zwjxbj = zwjxbj;
	}
	public void setHlgz(int hlgz) {
		this.hlgz = hlgz;
	}
	public void setThgz(int thgz) {
		this.thgz = thgz;
	}
	public void setJyfgz(int jyfgz) {
		this.jyfgz = jyfgz;
	}
	public void setGlqds(int glqds) {
		this.glqds = glqds;
	}
	public void setCxdjgz(int cxdjgz) {
		this.cxdjgz = cxdjgz;
	}
	public void setCyhlgz(int cyhlgz) {
		this.cyhlgz = cyhlgz;
	}
	public void setGljq(int gljq) {
		this.gljq = gljq;
	}
	public void setLlyc(int llyc) {
		this.llyc = llyc;
	}
	public void setYlyc(int ylyc) {
		this.ylyc = ylyc;
	}
	public void setHlstyc(int hlstyc) {
		this.hlstyc = hlstyc;
	}
	public void setYlzd(int ylzd) {
		this.ylzd = ylzd;
	}
	
	
	public void setSjjzd(int sjjzd) {
		this.sjjzd = sjjzd;
	}

	public void setXjjzd(int xjjzd) {
		this.xjjzd = xjjzd;
	}

	public void setDzgdbl(int dzgdbl) {
		this.dzgdbl = dzgdbl;
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

	public void setShdbdyc(int shdbdyc) {
		this.shdbdyc = shdbdyc;
	}

	public void setXdbdyc(int xdbdyc) {
		this.xdbdyc = xdbdyc;
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

	
}
