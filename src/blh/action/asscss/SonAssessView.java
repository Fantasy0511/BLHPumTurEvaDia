package blh.action.asscss;

import tool.highcharts.BarData;
import tool.highcharts.PieData;

public class SonAssessView {
	private BarData fristBar;
	private PieData fristPie;
	private BarData secondBar;
	private PieData secondPie;
	private BarData thirdBar;
	private PieData thirdPie;
	public SonAssessView(BarData fristBar, PieData fristPie, BarData secondBar, PieData secondPie, BarData thirdBar,
			PieData thirdPie) {
		super();
		this.fristBar = fristBar;
		this.fristPie = fristPie;
		this.secondBar = secondBar;
		this.secondPie = secondPie;
		this.thirdBar = thirdBar;
		this.thirdPie = thirdPie;
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
	public BarData getThirdBar() {
		return thirdBar;
	}
	public void setThirdBar(BarData thirdBar) {
		this.thirdBar = thirdBar;
	}
	public PieData getThirdPie() {
		return thirdPie;
	}
	public void setThirdPie(PieData thirdPie) {
		this.thirdPie = thirdPie;
	}
	
}
