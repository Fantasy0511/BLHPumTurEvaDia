/**
 * 封装使用highcharts作图的功能。<br />
 * pre-condition: 导入了jQuery包，导入了highcharts包。<br />
 * pre-condition: 数据格式符合LineData、BarChart、PieChart类的约定。
 * 
 * @author hx
 */

// 图的配置
$(function() {
	Highcharts.setOptions({
		lang : {
			months : [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11',
					'12' ],
			resetZoom : "原始大小"
		}
	});
});

/**
 * 作折线图
 * 
 * @param title
 *            图标题
 * @param xName
 *            x轴名称
 * @param yName
 *            y轴名称
 * @param data
 * @param seriesName
 *            数据序列的名称
 * @param id
 *            图div容器的id
 */
function _drawLineChart(title, xName, yName, data, id, callback) {
	var options = {
		chart : {
			zoomType : 'x',
			spacingRight : 20,
			type : 'spline',
			events : {
				load : function() {
					if (_.isFunction(callback)) {
						callback(this.series);
					}
				}
			}
		},
		exporting : {
			enabled : false
		},
		title : {
			text : title
		},
		xAxis : {
			title : {
				text : xName
			}
		},
		yAxis : {
			title : {
				text : yName
			}
		},
		tooltip : {
			crosshairs : {
				width : 2,
				color : 'gray',
				dashStyle : 'shortdot'
			},
			shared : true
		},
		credits : {
			enabled : false
		},
		legend : {
			layout : 'horizontal',
			align : 'center',
			verticalAlign : "top",
			y : 20
		},
		plotOptions : {
			spline : {
				marker : {
					enabled : false
				}
			},
			series : {
				marker : {
					enabled : false
				},
				point : {}
			},
			area : {
				fillColor : {
					linearGradient : {
						x1 : 0,
						y1 : 0,
						x2 : 0,
						y2 : 1
					},
					stops : [
							[ 0, Highcharts.getOptions().colors[0] ],
							[
									1,
									Highcharts.Color(
											Highcharts.getOptions().colors[0])
											.setOpacity(0).get('rgba') ] ]
				},
				marker : {
					enabled : false
				},
				shadow : false,
				states : {
					hover : {
						lineWidth : 1
					}
				},
				threshold : null
			}
		},
		series : data,
	};
	$("#" + id).highcharts(options);
}

/**
 * 绘制折线图，数据封装到lineData对象中。
 * 
 * @param lineData
 *            封装作图数据的json对象
 * @param id
 *            图div容器的id
 */
function _drawLine(lineData, id) {
	_drawLineChart(lineData.title, lineData.xName, lineData.yName,
			lineData.data, id);
}
/**
 * 绘制柱状图
 * 
 * @param title, subtitle, categories, yLabel, seriesName,
		seriesValue, id
 *      
 */
function _drawBarChart(title, subtitle, categories, yLabel, seriesName,
		seriesValue, id) {
	$("#" + id)
			.highcharts(
					{
						chart : {
							type : 'column'
						},
						title : {
							text : title
						},
						subtitle : {
							text : subtitle
						},
						xAxis : {
							categories : categories
						},
						yAxis : {
							min : 0,
							title : {
								text : yLabel
							}
						},
						exporting : {
							enabled : false
						},
						credits : {
							enabled : false
						},
						tooltip : {
							headerFormat : '<span style="font-size:10px">{point.key}</span>',
							pointFormat : '' + '',
							footerFormat : '<table><tbody><tr><td style="color:{series.color};padding:0">得分: </td><td style="padding:0"><b>{point.y:.2f}</b></td></tr></tbody></table>',
							shared : true,
							useHTML : true
						},
						plotOptions : {
							column : {
								pointPadding : 0.2,
								borderWidth : 0
							}
						},
						series : [ {
							name : seriesName, // 横坐标
							data : seriesValue // 纵坐标
						} ]
					});
}

/**
 * 绘制柱状图新   by 贾天龙
 * 
 * @param title, subtitle, categories, yLabel, seriesName,
		seriesValue, id
 *      
 */
function _drawBarChartNew(title, subtitle, categories, yLabel, 
		data, id) {
	$("#" + id)
			.highcharts(
					{
						chart : {
							type : 'column'
						},
						title : {
							text : title
						},
						subtitle : {
							text : subtitle
						},
						xAxis : {
							categories : categories
						},
						yAxis : {
							min : 0,
							title : {
								text : yLabel
							}
						},
						exporting : {
							enabled : false
						},
						credits : {
							enabled : false
						},
						tooltip : {
							headerFormat : '<span style="font-size:10px">{point.key}</span>',
							pointFormat : '' + '',
							footerFormat : '<table><tbody><tr><td style="color:{series.color};padding:0">得分: </td><td style="padding:0"><b>{point.y:.2f}</b></td></tr></tbody></table>',
							shared : true,
							useHTML : true
						},
						plotOptions : {
							column : {
								pointPadding : 0.2,
								borderWidth : 0
							}
						},
						series : [ {
							data:data
						} ]
						
					});
}

/**
 * 绘制饼图的函数，数据封装到barData中。
 * 
 * @param barData
 * @param id
 */
function _drawBar(barData, id) {
	_drawBarChart(barData.title, barData.subtitle, barData.categories,
			barData.yLabel, barData.seriesName, barData.seriesValue, id);
}

/**
 * 画饼图。
 * 
 * @param title
 *            标题
 * @param seriesName
 *            序列名
 * @param nameArray
 *            名字数组
 * @param dataArray
 *            数据数组
 * @param id
 *            绘图div容器的id
 */
function _drawPieChart(title, pieData, id) {
	$('#' + id)
			.highcharts(
					{
						chart : {
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false,
							tooltip : enabled = false,
							type : 'pie'
						},
						title : {
							text : title
						},
						tooltip : {
							pointFormat : '{series.name}: <b>{point.percentage:.2f}%</b>'
						},
						credits : {
							enabled : false
						},
						exporting : {
							enabled : false
						},
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								dataLabels : {
									enabled : true,
									format : '<b>{point.name}</b>: {point.percentage:.2f} %',
									style : {
										color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
												|| 'black'
									}
								},
								showInLegend : true,
							}
						},
						legend : {
							enabled:false,
							layout : 'horizontal',
							backgroundColor : '#FFFFFF',
							floating : true,
							align : 'center',
							verticalAlign : 'bottom',
							x : 10,
							y : 25,
							labelFormatter : function() {
								return this.name + '('
										+ this.percentage.toFixed(2) + '%)';
							}
						},
						series : [ {
							colorByPoint : true,
							data : pieData
						} ]
					});
}
/**
 * 重载的绘制饼图。数据封装到json中。
 * 
 * @param pieData
 *            封装饼图需要的数据。
 * @param id
 *            绘制饼图的div容器的id。
 */
function _drawPie(pieData, id) {
	_drawPieChart(pieData.title, pieData.data, id);
	/*_drawPieChart(pieData.title, pieData.seriesName, pieData.data, id);*/ 
	/*这是以前的，饼状图不应该有seriesName*/
}

/**
 * 
 * 调用以作图。if中的判断表达式判断相等，千万不能掉“==”一个等号。这是一个下午的教训。
 * 
 * @param id
 *            容器id
 * @param type
 *            图类型，支持"bar", "line", "pie", "timeline"。
 * @param data
 *            图的数据
 */
function drawPic(id, data) {
	if ((!data) || (data == {})) {
		var div = $("#" + id);
		div.empty();
		var html = "<div><pre>    没有结果！</pre></div>";
		div.append(html);
	}
	var type = data.type;
	if (type == "line") {
		_drawLine(data, id);
	} else if (type == "bar") {
		_drawBar(data, id);
	} else if (type == "pie") {
		_drawPie(data, id);
	} else {
		throw new Error("no such type");
	}
}

/**
 * convention-over-configuration. 约定：图的id和键值（key）一样。
 * 
 */
function drawPictures(data, selector) {
	if (!selector) {
		selector = "div[id^='chart']";
	}
	var prefix = "chart_";
	var callback = function(container, value, id) {
		drawPic(id, value);
	}
	conventionHelper(data, selector, prefix, callback);
}

/**
 * 终极作图函数
 * 
 * @param id
 * @param requestPath
 */
function drawChart(id, requestPath) {
	$.getJSON(requestPath, function(data) {
		drawPic(id, data);
	});
}

/**
 * 终极的作图函数。可以传入容器的this引用。
 * 
 * @param pointer
 * @param requestPath
 */
function draw(pointer, requestPath) {
	drawChart(pointer.id, requestPath);
}

function getSVGArray(prefix/* ,ids... */) {
	var ids = _.drop(arguments);
	var result = [];
	for (idx in ids) {
		var svg = "";
		var container = $("#" + ids[idx]);
		if (container && container.highcharts()) {
			svg = container.highcharts().getSVG();
		}
		result.push(svg);
	}
	return result;
}

/**
 * convention-over-configuration.
 */
function getSVGs(selector) {
	if (!selector) {
		selector = "div[id^=chart]";
	}
	var prefix = "chart_";
	var result = {};
	var callback = function(container, key) {
		if (container && container.highcharts()) {
			var svg = container.highcharts().getSVG();
			result[key] = svg;
		} else {
			throw new ConventionError(id);
		}
	};
	conventionHelper(null, selector, prefix, callback);
	return result;
}
