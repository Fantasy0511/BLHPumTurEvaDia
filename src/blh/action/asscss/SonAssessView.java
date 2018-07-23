package blh.action.asscss;

import tool.highcharts.BarData;
import tool.highcharts.PieData;
/**
 * 子系统数据模型封装
 */
public class SonAssessView {
	private BarData fristBar;
	private PieData fristPie;
	private BarData secondBar;
	private PieData secondPie;
	private BarData thirdBar;
	private PieData thirdPie;
	private BarData fourthBar;
	private PieData fourthPie;
	private BarData fifthBar;
	private PieData fifthPie;
	
	public SonAssessView(BarData fristBar, PieData fristPie, BarData secondBar, PieData secondPie) {
		super();
		this.fristBar = fristBar;
		this.fristPie = fristPie;
		this.secondBar = secondBar;
		this.secondPie = secondPie;
	}
	
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

	public SonAssessView(BarData fristBar, PieData fristPie, BarData secondBar, PieData secondPie, BarData thirdBar,
			PieData thirdPie, BarData fourthBar, PieData fourthPie, BarData fifthBar, PieData fifthPie) {
		super();
		this.fristBar = fristBar;
		this.fristPie = fristPie;
		this.secondBar = secondBar;
		this.secondPie = secondPie;
		this.thirdBar = thirdBar;
		this.thirdPie = thirdPie;
		this.fourthBar = fourthBar;
		this.fourthPie = fourthPie;
		this.fifthBar = fifthBar;
		this.fifthPie = fifthPie;
	}

	public BarData getFourthBar() {
		return fourthBar;
	}

	public PieData getFourthPie() {
		return fourthPie;
	}

	public BarData getFifthBar() {
		return fifthBar;
	}

	public PieData getFifthPie() {
		return fifthPie;
	}

	public void setFourthBar(BarData fourthBar) {
		this.fourthBar = fourthBar;
	}

	public void setFourthPie(PieData fourthPie) {
		this.fourthPie = fourthPie;
	}

	public void setFifthBar(BarData fifthBar) {
		this.fifthBar = fifthBar;
	}

	public void setFifthPie(PieData fifthPie) {
		this.fifthPie = fifthPie;
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
