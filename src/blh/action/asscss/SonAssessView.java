package blh.action.asscss;

import tool.highcharts.BarData;
import tool.highcharts.PieData;

public class SonAssessView {
	private BarData mainShaftSealBar;
	private PieData mainShaftSealPie;
	private BarData temperatureBar;
	private PieData temperaturePie;
	public SonAssessView(BarData mainShaftSealBar, PieData mainShaftSealPie, BarData temperatureBar,
			PieData temperaturePie) {
		super();
		this.mainShaftSealBar = mainShaftSealBar;
		this.mainShaftSealPie = mainShaftSealPie;
		this.temperatureBar = temperatureBar;
		this.temperaturePie = temperaturePie;
	}
	public BarData getMainShaftSealBar() {
		return mainShaftSealBar;
	}
	public void setMainShaftSealBar(BarData mainShaftSealBar) {
		this.mainShaftSealBar = mainShaftSealBar;
	}
	public PieData getMainShaftSealPie() {
		return mainShaftSealPie;
	}
	public void setMainShaftSealPie(PieData mainShaftSealPie) {
		this.mainShaftSealPie = mainShaftSealPie;
	}
	public BarData getTemperatureBar() {
		return temperatureBar;
	}
	public void setTemperatureBar(BarData temperatureBar) {
		this.temperatureBar = temperatureBar;
	}
	public PieData getTemperaturePie() {
		return temperaturePie;
	}
	public void setTemperaturePie(PieData temperaturePie) {
		this.temperaturePie = temperaturePie;
	}
	
	
	
	
	
}
