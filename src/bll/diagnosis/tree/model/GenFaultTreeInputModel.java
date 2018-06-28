package bll.diagnosis.tree.model;


import service.faulttree.Genmotor.GenMotorFaultDay;

import util.PathUtil;
import util.TimeUtils;

public class GenFaultTreeInputModel {

	
	private int zpgg; // 转频过高，开关量
	private	int klqgz;// 空冷器故障，开关量
	private	int zzjysh;// 转子绝缘损坏，开关量
	private	int zpzd;// 转频振动，开关量
	private	int jpzd;// 极频振动，开关量
	private	int lcdyyc;// 励磁电源异常，开关量
	private	int fsgz;// 风扇故障，开关量
	
	
	
	public GenFaultTreeInputModel tstreeanalysis() {
		GenFaultTreeInputModel datas = new GenFaultTreeInputModel();
		
		datas.zpgg= 1;
		datas.klqgz = 1; 
		datas.zzjysh = 0; 
		datas.zpzd = 0;
		datas.jpzd= 1;
		datas.lcdyyc = 0;
		datas.fsgz = 1;

		return datas;
	}


	public GenFaultTreeInputModel tstreeanalysis(String datetime,String UnitNo, String condtionName) {

		GenFaultTreeInputModel datas = new GenFaultTreeInputModel();
		GenMotorFaultDay dataflag=new GenMotorFaultDay();
		
		// 从数据库监控数据表中读取的开关量
	  //开关量取当日最新值
		long time=TimeUtils.StringtoLong(datetime);
		int  No=Integer.parseInt(UnitNo);
		datas.zpgg= dataflag.getRotateFFault(time, No);
		datas.klqgz=dataflag.getACoolerFault(time, No);
		datas.zzjysh=dataflag.getRoInsulationFault(time, No);
		datas.zpzd=dataflag.getZhuanPin(time, No);
		datas.jpzd=dataflag.getJiPin(time, No);
		datas.lcdyyc=dataflag.getExcitePowerFault(time, No);
		datas.fsgz=dataflag.getFanFault(time, No);
		
		return datas;
		
	}


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


	public int getJpzd() {
		return jpzd;
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


	public void setJpzd(int jpzd) {
		this.jpzd = jpzd;
	}


	public void setLcdyyc(int lcdyyc) {
		this.lcdyyc = lcdyyc;
	}


	public void setFsgz(int fsgz) {
		this.fsgz = fsgz;
	}
	
	

}
