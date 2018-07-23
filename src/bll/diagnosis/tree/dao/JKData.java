package bll.diagnosis.tree.dao;


/** 
* @author  wqf
* @version 创建时间：2016年6月21日 下午3:37:55 
* 故障树-(调速器)所需监控系统数据类 
*/
public class JKData {
     int jdxzt;  //剪断销状态
	
	int ftHAlarm;  //集油箱油位高报警
	int ftLAlarm;  //集油箱油位低报警
	
	int ptHAlarm;  //压力油罐油位高报警
	int ptLAlarm;  //压力油罐油位低报警
	
	int OilPFailure;//油泵不能正常开启
	
	public int getOilSpill() {
		return OilSpill;
	}
	public void setOilSpill(int oilSpill) {
		OilSpill = oilSpill;
	}
	public int getPreviewLow() {
		return PreviewLow;
	}
	public void setPreviewLow(int previewLow) {
		PreviewLow = previewLow;
	}
	public int getFrequentH() {
		return FrequentH;
	}
	public void setFrequentH(int frequentH) {
		FrequentH = frequentH;
	}
	int OilSpill;//耗油速度偏大
	
	int PreviewLow;//大油量偏低
	
	int FrequentH;//油泵开启频繁
	
	
	public int getOilPFailure() {
		return OilPFailure;
	}
	public void setOilPFailure(int oilPFailure) {
		OilPFailure = oilPFailure;
	}
	int ptAirLeak; //压油罐漏气
	
	public int getPtAirLeak() {
		return ptAirLeak;
	}
	public void setPtAirLeak(int ptAirLeak) {
		this.ptAirLeak = ptAirLeak;
	}
	public int getSysOilSpill() {
		return sysOilSpill;
	}
	public void setSysOilSpill(int sysOilSpill) {
		this.sysOilSpill = sysOilSpill;
	}
	public int getLowEff() {
		return LowEff;
	}
	public void setLowEff(int lowEff) {
		LowEff = lowEff;
	}
	int sysOilSpill; //系统漏油
	
	int LowEff; //油泵效率低
	public int getJdxzt() {
		return jdxzt;
	}
	public void setJdxzt(int jdxzt) {
		this.jdxzt = jdxzt;
	}
	public int getFtHAlarm() {
		return ftHAlarm;
	}
	public void setFtHAlarm(int ftHAlarm) {
		this.ftHAlarm = ftHAlarm;
	}
	public int getFtLAlarm() {
		return ftLAlarm;
	}
	public void setFtLAlarm(int ftLAlarm) {
		this.ftLAlarm = ftLAlarm;
	}
	public int getPtHAlarm() {
		return ptHAlarm;
	}
	public void setPtHAlarm(int ptHAlarm) {
		this.ptHAlarm = ptHAlarm;
	}
	public int getPtLAlarm() {
		return ptLAlarm;
	}
	public void setPtLAlarm(int ptLAlarm) {
		this.ptLAlarm = ptLAlarm;
	}

}
