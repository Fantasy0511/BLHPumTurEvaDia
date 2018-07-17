package blh.action.asscss;

import tool.highcharts.BarData;
import tool.highcharts.PieData;

public class SonAssessView {
	private BarData fristBar;
	private PieData fristPie;
	private BarData secondBar;
	private PieData secondPie;
	public SonAssessView(BarData fristBar, PieData fristPie, BarData secondBar, PieData secondPie) {
		super();
		this.fristBar = fristBar;
		this.fristPie = fristPie;
		this.secondBar = secondBar;
		this.secondPie = secondPie;
	}
	public BarData getFristBar() {
		return fristBar;
	}
	public void setFristBar(BarData fristBar) {
		this.fristBar = fristBar;
	}
	public PieData getFristPie() {
		return fristPie;
	}
	public void setFristPie(PieData fristPie) {
		this.fristPie = fristPie;
	}
	public BarData getSecondBar() {
		return secondBar;
	}
	public void setSecondBar(BarData secondBar) {
		this.secondBar = secondBar;
	}
	public PieData getSecondPie() {
		return secondPie;
	}
	public void setSecondPie(PieData secondPie) {
		this.secondPie = secondPie;
	}
	
	
	
}
