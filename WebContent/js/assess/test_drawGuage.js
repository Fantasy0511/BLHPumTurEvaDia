var drawGuage = function (id,scores){
		var condition;
		var score = +scores.toFixed(2);
		if(score>=85){
			condition = '正常';
			conditionColor = '#42E9B6';
		}
		else if(score<85&&score>=75){
			condition = '注意';
			conditionColor = '#4AC5F8';
		}
		else if(score<75&&score>=60){
			condition = '异常';
			conditionColor = '#F7D253';
		}
		else if(score<60){
			condition = '严重';
			conditionColor = '#FF4442';
		}
	$('#'+id).highcharts({
	
		    chart: {
		        type: 'gauge',//定义图表的类型
		        plotBackgroundColor: null,
		        plotBackgroundImage: null,
		        plotBorderWidth: 0,
		        plotShadow: false
		    },
		    
		    title: {
		        text: "总体健康状况",
		        style : {
        			'fontSize' : '20px',
   				},
   				margin:0//边距
		    },
		    
		    pane: {//pane 只适用在极坐标图和角度测量仪。此可配置对象持有组合x轴和y周的常规选项
		        startAngle: -120,//x轴或测量轴的开始度数，以度数的方式给出。0是北
		        endAngle: 120,//x轴极坐标或角度轴的最终度数，以度数的方式给出。0是北
		        background: [{
		            backgroundColor: {
		                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
		                stops: [
		                    [0, '#FFF'],
		                    [1, '#333']
		                ]
		            },
		            borderWidth: 10,
		            outerRadius: '110%'
		        }, {
		            backgroundColor: {
		                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
		                stops: [
		                    [0, '#333'],
		                    [1, '#FFF']
		                ]
		            },
		            borderWidth: 1,
		            outerRadius: '107%'
		        }, {
		            // default background
		        }, {
		            backgroundColor: '#DDD',
		            borderWidth: 0,
		            outerRadius: '105%',
		            innerRadius: '103%'
		        }]
		    },
		       
		    // the value axis
		    yAxis: {
		        min: 0,
		        //max: 200,最大值，修改为100 下面plotBands也需要相应修改
		        max: 100,
		        minorTickInterval: 'auto',
		        minorTickWidth: 1,
		        //minorTickLength: 10, 这个是刻度盘上的刻度长度，觉得太难看设置为0即不显示
		        minorTickLength: 0,
		        minorTickPosition: 'inside',
		        minorTickColor: '#666',
		
		        tickPixelInterval: 30,
		        tickWidth: 1,
		        tickPosition: 'inside',
		        tickLength: 10,
		        tickColor: '#666',
		        labels: {
		            step: 2,
		            rotation: 'auto'
		        },
		        title: {
		            text: condition,
		            style : {
        			'fontSize' : '18px',
        			'color': conditionColor,
   					},
		        },
		        plotBands: [{
		            from: 0,
		            to: 30,
		            color: '#FF4442' // red
		        },{
		            from: 30,
		            to: 60,
		            color: '#F7D253' // yellow
		        }, {
		            from: 60,
		            to: 90,
		            color: '#4AC5F8' // blue
		        }, {
		            from: 90,
		            to: 100,
		            color: '#42E9B6' // green
		        }]        
		    },
		    credits:{
	        	enabled:false
	        },
		    series: [{
		        name: '指标',
		        data: [score],//注意为json形式
		       	cursor:'pointer'
		         
		    }]
		
		}
		);
		
	};