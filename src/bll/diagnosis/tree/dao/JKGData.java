package bll.diagnosis.tree.dao;

/**
 * @author xyh 故障树-（发电电动机）所需监控系统数据类
 */
public class JKGData {

	int zpgg; // 转频过高，开关量
	int klqgz;// 空冷器故障，开关量
	int zzjysh;// 转子绝缘损坏，开关量
	int zpzd;// 转频振动，开关量
	int jpzz;// 极频振动，开关量
	int lcdyyc;// 励磁电源异常，开关量
	int fsgz;// 风扇故障，开关量

	public int getZpgg() {
		return zpgg;
	}

	public int getKlqgz() {
		return klqgz;
	}

	public int getZzjysh() {
		return zzjysh;
	}

	public int getZpzd() {
		return zpzd;
	}

	public int getJpzz() {
		return jpzz;
	}

	public int getLcdyyc() {
		return lcdyyc;
	}

	public int getFsgz() {
		return fsgz;
	}

	public void setZpgg(int zpgg) {
		this.zpgg = zpgg;
	}

	public void setKlqgz(int klqgz) {
		this.klqgz = klqgz;
	}

	public void setZzjysh(int zzjysh) {
		this.zzjysh = zzjysh;
	}

	public void setZpzd(int zpzd) {
		this.zpzd = zpzd;
	}

	public void setJpzz(int jpzz) {
		this.jpzz = jpzz;
	}

	public void setLcdyyc(int lcdyyc) {
		this.lcdyyc = lcdyyc;
	}

	public void setFsgz(int fsgz) {
		this.fsgz = fsgz;
	}

}