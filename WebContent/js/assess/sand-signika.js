/**
 * Sand-Signika theme for Highcharts JS
 * 
 * @author Torstein Honsi
 */

// Load the fonts
// Add the background image to the container
Highcharts.wrap(Highcharts.Chart.prototype, 'getContainer', function(proceed) {
	proceed.call(this);
});

Highcharts.theme = {
	colors : [ "#f45b5b", "#8085e9", "#8d4654", "#7798BF", "#aaeeee",
			"#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee" ],
	chart : {
		backgroundColor : "white",
		style : {
			fontFamily : "微软雅黑, serif"
		}
	},
	title : {
		style : {
			color : 'black',
			fontSize : '16px',
			fontWeight : 'normal'
		}
	},
	subtitle : {
		style : {
			color : 'black'
		}
	},
	tooltip : {
		borderWidth : 0
	},
	legend : {
		itemStyle : {
			fontWeight : 'bold',
			fontSize : '13px'
		}
	},
	xAxis : {
		labels : {
			style : {
				color : 'black'
			}
		}
	},
	yAxis : {
		labels : {
			style : {
				color : 'black'
			}
		}
	},
	plotOptions : {
		series : {
			shadow : true
		},
		candlestick : {
			lineColor : '#404048'
		},
		map : {
			shadow : false
		}
	},

	// Highstock specific
	navigator : {
		xAxis : {
			gridLineColor : '#D0D0D8'
		}
	},
	rangeSelector : {
		buttonTheme : {
			fill : 'white',
			stroke : '#C0C0C8',
			'stroke-width' : 1,
			states : {
				select : {
					fill : '#D0D0D8'
				}
			}
		}
	},
	scrollbar : {
		trackBorderColor : '#C0C0C8'
	},

	// General
	background2 : '#E0E0E8'

};

// Apply the theme
Highcharts.setOptions(Highcharts.theme);
