package bll.diagnosis.tree.dao;


/** 
* @author xyh 
* @version 创建时间：2016年6月21日 下午3:37:55 
* 故障树-（水泵水轮机）所需监控系统数据类 
*/
public class JKPData {

	
	int yxtyc;//油系统异常，开关量
    int dzbdyc;// 大轴摆度异常，开关量
	
	
	int jdxgz;// 剪断销故障，开关量
	
	int sdbdyc;//水导摆度异常，开关量
	int wsgswg;//尾水管水位过高，开关量
	double mghwd;//迷宫环温度
	int lqslld;//冷却水流量低，开关量
	int zwwdyc;//轴瓦温度异常，开关量
	double zczb;//轴承振摆
	int zzmfyc;//主轴密封异常，开关量
	int wkgz;//蜗壳故障，开关量
	
	
	
	
	int lqsyc ; //冷却水异常
	int lqsswg;//冷却水水温高
	int lqssyyc;//冷却水水压异常
	int yxtyyd;//油系统油压低
	int yxtywyc;//油系统油位异常
	int yxtywg;//油系统油温高
	int yxyyhs;//油系统油混水
	int zczdyc;//轴承振动异常
	int bjxhwb;//报警信号误报
	int jzzsgg;//机组转速过高
	
	
	int shdbdyc;//上导摆度异常
	int xdbdyc;//下导摆度异常
	int dbph;//动不平衡
	int lcdlbph;//磁拉力不平衡
	
	int wsgylmd;//尾水管压力脉动
	int dzgdbl;//定子固定不良
	int sjjzd;//上机架振动
	int xjjzd;//下机架振动
	
	
	public int getWsgylmd() {
		return wsgylmd;
	}public int getDzgdbl() {
		return dzgdbl;
	}public int getSjjzd() {
		return sjjzd;
	}public int getXjjzd() {
		return xjjzd;
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
	
	
	public void setWsgylmd(int wsgylmd) {
		this.wsgylmd = wsgylmd;
	}public void setDzgdbl(int dzgdbl) {
		this.dzgdbl = dzgdbl;
	}public void setSjjzd(int sjjzd) {
		this.sjjzd = sjjzd;
	}public void setXjjzd(int xjjzd) {
		this.xjjzd = xjjzd;
	}
	
	public void setLqsswg(int lqsswg) {
		this.lqsswg = lqsswg;
	}public void setLqssyyc(int lqssyyc) {
		this.lqssyyc = lqssyyc;
	}public void setYxtyyd(int yxtyyd) {
		this.yxtyyd = yxtyyd;
	}public void setYxtywyc(int yxtywyc) {
		this.yxtywyc = yxtywyc;
	}public void setYxtywg(int yxtywg) {
		this.yxtywg = yxtywg;
	}public void setYxyyhs(int yxyyhs) {
		this.yxyyhs = yxyyhs;
	}public void setZczdyc(int zczdyc) {
		this.zczdyc = zczdyc;
	}public void setBjxhwb(int bjxhwb) {
		this.bjxhwb = bjxhwb;
	}public void setJzzsgg(int jzzsgg) {
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