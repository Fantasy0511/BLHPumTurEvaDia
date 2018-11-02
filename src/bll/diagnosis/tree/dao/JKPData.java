package bll.diagnosis.tree.dao;

/**
 * @author xyh
 * @version 创建时间：2016年6月21日 下午3:37:55 故障树-（水泵水轮机）所需监控系统数据类
 */
public class JKPData {

	int yxtyc;// 油系统异常，开关量
	int dzbdyc;// 大轴摆度异常，开关量

	int sdbdyc;// 水导摆度异常，开关量
	int wsgswg;// 尾水管水位过高，开关量
	double mghwd;// 迷宫环温度
	int lqslld;// 冷却水流量低，开关量
	int zwwdyc;// 轴瓦温度异常，开关量
	double zczb;// 轴承振摆
	int zzmfyc;// 主轴密封异常，开关量
	int wkgz;// 蜗壳故障，开关量

	int lqsyc; // 冷却水异常
	int lqsswg;// 冷却水水温高
	int lqssyyc;// 冷却水水压异常
	int yxtyyd;// 油系统油压低
	int yxtywyc;// 油系统油位异常
	int yxtywg;// 油系统油温高
	int yxyyhs;// 油系统油混水
	int zczdyc;// 轴承振动异常
	int bjxhwb;// 报警信号误报
	int jzzsgg;// 机组转速过高

	int shdbdyc;// 上导摆度异常
	int xdbdyc;// 下导摆度异常
	int dbph;// 动不平衡
	int lcdlbph;// 磁拉力不平衡

	int wsgylmd;// 尾水管压力脉动
	int dzgdbl;// 定子固定不良
	int sjjzd;// 上机架振动
	int xjjzd;// 下机架振动

	int xhybgz;// 循环油泵故障
	int ybzcks;// 油泵轴承卡涩
	int lqqnbds;// 冷却器内部堵塞
	int zwjxbj;// 轴瓦间隙不均
	int hlgz;// 回路故障

	int thgz;// 弹簧故障
	int jyfgz;// 减压阀故障
	int glqds;// 过滤器堵塞
	int cxdjgz;// 冲洗电机故障
	int cyhlgz;// 测压回路故障

	int gljq;// 管路进气
	int llyc;// 流量异常
	int ylyc;// 压力异常
	int hlstyc;// 回路异常渗漏
	int ylzd;// 压力振荡

	public int getWsgylmd() {
		return wsgylmd;
	}

	public int getDzgdbl() {
		return dzgdbl;
	}

	public int getSjjzd() {
		return sjjzd;
	}

	public int getXjjzd() {
		return xjjzd;
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

	public int getBjxhwb() {
		return bjxhwb;
	}

	public int getJzzsgg() {
		return jzzsgg;
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

	public int getSdbdyc() {
		return sdbdyc;
	}

	public int getWsgswg() {
		return wsgswg;
	}

	public double getMghwd() {
		return mghwd;
	}

	public int getLqslld() {
		return lqslld;
	}

	public int getZwwdyc() {
		return zwwdyc;
	}

	public double getZczb() {
		return zczb;
	}

	public int getZzmfyc() {
		return zzmfyc;
	}

	public int getWkgz() {
		return wkgz;
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

	public int getCxdjgz() {
		return cxdjgz;
	}

	public int getCyhlgz() {
		return cyhlgz;
	}

	public int getGljq() {
		return gljq;
	}public int getLlyc() {
		return llyc;
	}public int getYlyc() {
		return ylyc;
	}public int getHlstyc() {
		return hlstyc;
	}public int getYlzd() {
		return ylzd;
	}
	
	
	public void setXhybgz(int xhybgz) {
		this.xhybgz = xhybgz;
	}public void setYbzcks(int ybzcks) {
		this.ybzcks = ybzcks;
	}public void setLqqnbds(int lqqnbds) {
		this.lqqnbds = lqqnbds;
	}public void setZwjxbj(int zwjxbj) {
		this.zwjxbj = zwjxbj;
	}public void setHlgz(int hlgz) {
		this.hlgz = hlgz;
	}
	
	public void setThgz(int thgz) {
		this.thgz = thgz;
	}public void setJyfgz(int jyfgz) {
		this.jyfgz = jyfgz;
	}public void setGlqds(int glqds) {
		this.glqds = glqds;
	}public void setCxdjgz(int cxdjgz) {
		this.cxdjgz = cxdjgz;
	}public void setCyhlgz(int cyhlgz) {
		this.cyhlgz = cyhlgz;
	}
	
	
	public void setGljq(int gljq) {
		this.gljq = gljq;
	}public void setLlyc(int llyc) {
		this.llyc = llyc;
	}public void setYlyc(int ylyc) {
		this.ylyc = ylyc;
	}public void setHlstyc(int hlstyc) {
		this.hlstyc = hlstyc;
	}public void setYlzd(int ylzd) {
		this.ylzd = ylzd;
	}
	
	
	
	
	
	public void setWsgylmd(int wsgylmd) {
		this.wsgylmd = wsgylmd;
	}

	public void setDzgdbl(int dzgdbl) {
		this.dzgdbl = dzgdbl;
	}

	public void setSjjzd(int sjjzd) {
		this.sjjzd = sjjzd;
	}

	public void setXjjzd(int xjjzd) {
		this.xjjzd = xjjzd;
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

	public void setSdbdyc(int sdbdyc) {
		this.sdbdyc = sdbdyc;
	}

	public void setWsgswg(int wsgswg) {
		this.wsgswg = wsgswg;
	}

	public void setMghwd(double mghwd) {
		this.mghwd = mghwd;
	}

	public void setLqslld(int lqslld) {
		this.lqslld = lqslld;
	}

	public void setZwwdyc(int zwwdyc) {
		this.zwwdyc = zwwdyc;
	}

	public void setZczb(double zczb) {
		this.zczb = zczb;
	}

	public void setZzmfyc(int zzmfyc) {
		this.zzmfyc = zzmfyc;
	}

	public void setWkgz(int wkgz) {
		this.wkgz = wkgz;
	}

}