package bll.diagnosis.tree.dao;


/** 
* @author xyh 
* @version 创建时间：2016年6月21日 下午3:37:55 
* 故障树所需监控系统数据类 
*/
public class JKPData {

	int lqsyc ; //冷却水异常，开关量
	int yxtyc;//油系统异常，开关量
    int dzbdyc;// 大轴摆度异常，开关量
	int dbph;//动不平衡，开关量
	int lcdlbph;//励磁电流不平衡，开关量
	int jdxgz;// 剪断销故障，开关量
	int shdbdyc;//上导摆度异常，开关量
	int xdbdyc;//下导摆度异常，开关量
	int sdbdyc;//水导摆度异常，开关量
	int wsgswg;//尾水管水位过高，开关量
	double mghwd;//迷宫环温度
	int lqslld;//冷却水流量低，开关量
	int zwwdyc;//轴瓦温度异常，开关量
	double zczb;//轴承振摆
	int zzmfyc;//主轴密封异常，开关量
	int wkgz;//蜗壳故障，开关量
	
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