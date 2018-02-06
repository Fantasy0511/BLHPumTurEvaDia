//cell数组到cell4数组的内容

var cell1 = {                //cell1数组
	"cells" : [ {          
		"outs" : [ {
			"id" : 6,
			"to" : 2,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 320,
			"y" : 20
		},
		"width" : 184,
		"height" : 38,
		"style" : "subflow",
		"value" : "调速系统运行故障"
	}, {
		"outs" : [ {
			"id" : 7,
			"to" : 21,
			"from" : 2
		}, {
			"id" : 8,
			"to" : 22,
			"from" : 2
		}, {
			"id" : 9,
			"to" : 23,
			"from" : 2
		} ],
		"id" : 2,
		"position" : {
			"x" : 382.5,
			"y" : 90
		},
		"width" : 59,
		"height" : 47,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [ {
			"id" : 19,
			"to" : 13,
			"from" : 3
		} ],
		"id" : 21,
		"position" : {
			"x" : 41,
			"y" : 167
		},
		"width" : 151,
		"height" : 34,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 101,
			"from" : 4
		} ],
		"id" : 22,
		"position" : {
			"x" : 330,
			"y" : 167
		},
		"width" : 164,
		"height" : 34,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [ {
			"id" : 29,
			"to" : 102,
			"from" : 5
		} ],
		"id" : 23,
		"position" : {
			"x" : 635,
			"y" : 167
		},
		"width" : 148,
		"height" : 34,
		"style" : "subflow",
		"value" : "油压装置运行故障"
	}, {
		"outs" : [],
		"id" : 132,
		"position" : {
			"x" : 312.5,
			"y" : 336
		},
		"width" : 199,
		"height" : 43,
		"style" : "process",
		"value" : "配压阀和接力器跳动或抖动"
	}, {
		"outs" : [ {
			"id" : 23,
			"to" : 18,
			"from" : 11
		} ],
		"id" : 131,
		"position" : {
			"x" : 43,
			"y" : 341.5
		},
		"width" : 147,
		"height" : 32,
		"style" : "subflow",
		"value" : "导叶开度反馈故障"
	}, {
		"outs" : [],
		"id" : 133,
		"position" : {
			"x" : 570.5,
			"y" : 337
		},
		"width" : 135,
		"height" : 41,
		"style" : "process",
		"value" : "调节模式自动切换"
	}, {
		"outs" : [ {
			"id" : 20,
			"to" : 131,
			"from" : 13
		}, {
			"id" : 21,
			"to" : 132,
			"from" : 13
		}, {
			"id" : 22,
			"to" : 133,
			"from" : 13
		} ],
		"id" : 13,
		"position" : {
			"x" : 89.5,
			"y" : 232
		},
		"width" : 54,
		"height" : 53,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [],
		"id" : 141,
		"position" : {
			"x" : 19.5,
			"y" : 477
		},
		"width" : 194,
		"height" : 45,
		"style" : "process",
		"value" : "导叶开度反馈信号为零"
	}, {
		"outs" : [],
		"id" : 142,
		"position" : {
			"x" : 316.5,
			"y" : 481
		},
		"width" : 191,
		"height" : 47,
		"style" : "process",
		"value" : "导叶开度反馈信号最大"
	}, {
		"outs" : [ {
			"id" : 24,
			"to" : 142,
			"from" : 18
		}, {
			"id" : 25,
			"to" : 141,
			"from" : 18
		} ],
		"id" : 18,
		"position" : {
			"x" : 92,
			"y" : 404
		},
		"width" : 49,
		"height" : 43,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [],
		"id" : 101,
		"position" : {
			"x" : 391,
			"y" : 227
		},
		"width" : 42,
		"height" : 35,
		"style" : "download",
		"value" : ""
	}, {
		"outs" : [],
		"id" : 102,
		"position" : {
			"x" : 687,
			"y" : 226
		},
		"width" : 44,
		"height" : 37,
		"style" : "download",
		"value" : ""
	} ]
};



var cell2 = {                 //cell2数组
	"cells" : [ {
		"outs" : [ {
			"id" : 6,
			"to" : 2,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 320,
			"y" : 20
		},
		"width" : 184,
		"height" : 38,
		"style" : "subflow",
		"value" : "调速系统运行故障"
	}, {
		"outs" : [ {
			"id" : 7,
			"to" : 21,
			"from" : 2
		}, {
			"id" : 8,
			"to" : 22,
			"from" : 2
		}, {
			"id" : 9,
			"to" : 23,
			"from" : 2
		} ],
		"id" : 2,
		"position" : {
			"x" : 382.5,
			"y" : 90
		},
		"width" : 59,
		"height" : 47,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [ {
			"id" : 30,
			"to" : 201,
			"from" : 3
		} ],
		"id" : 21,
		"position" : {
			"x" : 41,
			"y" : 167
		},
		"width" : 151,
		"height" : 34,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 72,
			"to" : 32,
			"from" : 4
		} ],
		"id" : 22,
		"position" : {
			"x" : 330,
			"y" : 167
		},
		"width" : 164,
		"height" : 34,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [ {
			"id" : 31,
			"to" : 202,
			"from" : 5
		} ],
		"id" : 23,
		"position" : {
			"x" : 635,
			"y" : 167
		},
		"width" : 148,
		"height" : 34,
		"style" : "subflow",
		"value" : "油压装置运行故障"
	}, {
		"outs" : [],
		"id" : 202,
		"position" : {
			"x" : 688,
			"y" : 225
		},
		"width" : 42,
		"height" : 35,
		"style" : "download",
		"value" : ""
	}, {
		"outs" : [],
		"id" : 201,
		"position" : {
			"x" : 94.5,
			"y" : 224
		},
		"width" : 44,
		"height" : 37,
		"style" : "download",
		"value" : ""
	}, {
		"outs" : [ {
			"id" : 73,
			"to" : 231,
			"from" : 32
		}, {
			"id" : 74,
			"to" : 232,
			"from" : 32
		}, {
			"id" : 75,
			"to" : 233,
			"from" : 32
		}, {
			"id" : 76,
			"to" : 234,
			"from" : 32
		}, {
			"id" : 77,
			"to" : 235,
			"from" : 32
		}, {
			"id" : 78,
			"to" : 236,
			"from" : 32
		}, {
			"id" : 79,
			"to" : 237,
			"from" : 32
		} ],
		"id" : 32,
		"position" : {
			"x" : 386,
			"y" : 213
		},
		"width" : 52,
		"height" : 46,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [ {
			"id" : 50,
			"to" : 43,
			"from" : 33
		} ],
		"id" : 231,
		"position" : {
			"x" : 82.95173961840628,
			"y" : 292.63299663299665
		},
		"width" : 85.24466891133557,
		"height" : 32.734006734006755,
		"style" : "subflow",
		"value" : "开机异常"
	}, {
		"outs" : [ {
			"id" : 80,
			"to" : 59,
			"from" : 35
		} ],
		"id" : 233,
		"position" : {
			"x" : 484.62177328843995,
			"y" : 292.75533108866443
		},
		"width" : 110,
		"height" : 31.36700336700335,
		"style" : "subflow",
		"value" : "空载稳定性差"
	}, {
		"outs" : [ {
			"id" : 83,
			"to" : 66,
			"from" : 37
		} ],
		"id" : 235,
		"position" : {
			"x" : 832.4354657687991,
			"y" : 292.13299663299665
		},
		"width" : 123,
		"height" : 31.489337822671132,
		"style" : "subflow",
		"value" : "并网运行溜负荷"
	}, {
		"outs" : [ {
			"id" : 86,
			"to" : 71,
			"from" : 38
		} ],
		"id" : 237,
		"position" : {
			"x" : 1148.9506172839508,
			"y" : 290.26599326599325
		},
		"width" : 115,
		"height" : 30.734006734006755,
		"style" : "subflow",
		"value" : "增减负荷异常"
	}, {
		"outs" : [],
		"id" : 232,
		"position" : {
			"x" : 215.64309764309763,
			"y" : 291.4466891133558
		},
		"width" : 220.0897867564534,
		"height" : 40.71829405162737,
		"style" : "process",
		"value" : "调节模式自动切换"
	}, {
		"outs" : [],
		"id" : 234,
		"position" : {
			"x" : 631.4141414141415,
			"y" : 292.56902356902356
		},
		"width" : 133.6700336700336,
		"height" : 35.10662177328845,
		"style" : "process",
		"value" : "甩负荷性能不良"
	}, {
		"outs" : [],
		"id" : 236,
		"position" : {
			"x" : 969.8350168350166,
			"y" : 290.324354657688
		},
		"width" : 159.4837261503926,
		"height" : 37.35129068462402,
		"style" : "process",
		"value" : "调速器紧急停机失灵"
	}, {
		"outs" : [ {
			"id" : 51,
			"to" : 241,
			"from" : 43
		}, {
			"id" : 52,
			"to" : 49,
			"from" : 43
		} ],
		"id" : 43,
		"position" : {
			"x" : 101.185746352413,
			"y" : 354.2390572390573
		},
		"width" : 48.77665544332211,
		"height" : 47.65432098765433,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [ {
			"id" : 92,
			"to" : 251,
			"from" : 44
		} ],
		"id" : 241,
		"position" : {
			"x" : 7.712682379349047,
			"y" : 451.01010101010104
		},
		"width" : 130.30303030303025,
		"height" : 27.250280583613915,
		"style" : "subflow",
		"value" : "机组误开机或蠕动"
	}, {
		"outs" : [ {
			"id" : 89,
			"to" : 252,
			"from" : 49
		}, {
			"id" : 90,
			"to" : 253,
			"from" : 49
		}, {
			"id" : 91,
			"to" : 254,
			"from" : 49
		} ],
		"id" : 49,
		"position" : {
			"x" : 300.4702581369246,
			"y" : 426.21773288439954
		},
		"width" : 51.02132435465768,
		"height" : 45.40965207631871,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [ {
			"id" : 81,
			"to" : 242,
			"from" : 59
		}, {
			"id" : 82,
			"to" : 243,
			"from" : 59
		} ],
		"id" : 59,
		"position" : {
			"x" : 515.7946127946128,
			"y" : 357.6060606060606
		},
		"width" : 47.65432098765427,
		"height" : 40.920314253647575,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [],
		"id" : 243,
		"position" : {
			"x" : 552.361391694725,
			"y" : 423.64870931537604
		},
		"width" : 178.56341189674527,
		"height" : 45.207631874298556,
		"style" : "process",
		"value" : "转速和接力器非周期摆动"
	}, {
		"outs" : [],
		"id" : 252,
		"position" : {
			"x" : 132.2020202020202,
			"y" : 541.4624017957351
		},
		"width" : 124.69135802469137,
		"height" : 30.61728395061732,
		"style" : "process",
		"value" : "接力器不能自启"
	}, {
		"outs" : [],
		"id" : 253,
		"position" : {
			"x" : 261.39057239057223,
			"y" : 542.0157126823794
		},
		"width" : 129.18069584736247,
		"height" : 29.494949494949424,
		"style" : "process",
		"value" : "转速达不到额定值"
	}, {
		"outs" : [],
		"id" : 254,
		"position" : {
			"x" : 400.5476992143659,
			"y" : 541.4837261503927
		},
		"width" : 104.48933782267113,
		"height" : 31.739618406285103,
		"style" : "process",
		"value" : "导叶响应缓慢"
	}, {
		"outs" : [],
		"id" : 251,
		"position" : {
			"x" : 28.475869809203118,
			"y" : 541.4410774410774
		},
		"width" : 88.77665544332211,
		"height" : 29.49494949494948,
		"style" : "process",
		"value" : "锁定未投入"
	}, {
		"outs" : [],
		"id" : 242,
		"position" : {
			"x" : 376.5061728395061,
			"y" : 423.0426487093154
		},
		"width" : 154.9943883277217,
		"height" : 48.57463524130196,
		"style" : "process",
		"value" : "转速和接力器周期摆动"
	}, {
		"outs" : [ {
			"id" : 84,
			"to" : 244,
			"from" : 66
		}, {
			"id" : 85,
			"to" : 245,
			"from" : 66
		} ],
		"id" : 66,
		"position" : {
			"x" : 868.4248035914702,
			"y" : 356.48372615039284
		},
		"width" : 51.02132435465762,
		"height" : 43.16498316498314,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [],
		"id" : 244,
		"position" : {
			"x" : 770.5791245791245,
			"y" : 432.1964085297419
		},
		"width" : 102.24466891133568,
		"height" : 31.739618406285047,
		"style" : "process",
		"value" : "自行增负荷"
	}, {
		"outs" : [],
		"id" : 245,
		"position" : {
			"x" : 900.9943883277216,
			"y" : 430.5690235690236
		},
		"width" : 86.53198653198649,
		"height" : 38.473625140291745,
		"style" : "process",
		"value" : "自行减负荷"
	}, {
		"outs" : [],
		"id" : 246,
		"position" : {
			"x" : 1063.010101010101,
			"y" : 450.4197530864197
		},
		"width" : 102.24466891133557,
		"height" : 35.10662177328845,
		"style" : "process",
		"value" : "增减负荷缓慢"
	}, {
		"outs" : [],
		"id" : 247,
		"position" : {
			"x" : 1210.7384960718293,
			"y" : 450.9887766554433
		},
		"width" : 97.75533108866443,
		"height" : 35.106621773288396,
		"style" : "process",
		"value" : "增减负荷失灵"
	}, {
		"outs" : [ {
			"id" : 87,
			"to" : 247,
			"from" : 71
		}, {
			"id" : 88,
			"to" : 246,
			"from" : 71
		} ],
		"id" : 71,
		"position" : {
			"x" : 1184.8681257014591,
			"y" : 356.48372615039284
		},
		"width" : 43.16498316498337,
		"height" : 40.92031425364763,
		"style" : "start",
		"value" : "或门"
	} ]
};



var cell3 = {                    //cell3数组
	"cells" : [ {
		"outs" : [ {
			"id" : 6,
			"to" : 2,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 320,
			"y" : 20
		},
		"width" : 184,
		"height" : 38,
		"style" : "subflow",
		"value" : "调速系统运行故障"
	}, {
		"outs" : [ {
			"id" : 7,
			"to" : 21,
			"from" : 2
		}, {
			"id" : 8,
			"to" : 22,
			"from" : 2
		}, {
			"id" : 9,
			"to" : 23,
			"from" : 2
		} ],
		"id" : 2,
		"position" : {
			"x" : 382.5,
			"y" : 90
		},
		"width" : 59,
		"height" : 47,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [ {
			"id" : 30,
			"to" : 271,
			"from" : 3
		} ],
		"id" : 21,
		"position" : {
			"x" : 41,
			"y" : 167
		},
		"width" : 151,
		"height" : 34,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 261,
			"from" : 4
		} ],
		"id" : 22,
		"position" : {
			"x" : 330,
			"y" : 167
		},
		"width" : 164,
		"height" : 34,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [ {
			"id" : 29,
			"to" : 13,
			"from" : 5
		} ],
		"id" : 23,
		"position" : {
			"x" : 635,
			"y" : 167
		},
		"width" : 148,
		"height" : 34,
		"style" : "subflow",
		"value" : "油压装置运行故障"
	}, {
		"outs" : [ {
			"id" : 40,
			"to" : 18,
			"from" : 11
		} ],
		"id" : 331,
		"position" : {
			"x" : 224,
			"y" : 317.5
		},
		"width" : 147,
		"height" : 32,
		"style" : "subflow",
		"value" : "油系统管路异常"
	}, {
		"outs" : [ {
			"id" : 38,
			"to" : 331,
			"from" : 13
		}, {
			"id" : 39,
			"to" : 332,
			"from" : 13
		} ],
		"id" : 13,
		"position" : {
			"x" : 685,
			"y" : 226
		},
		"width" : 48,
		"height" : 40,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [ {
			"id" : 41,
			"to" : 341,
			"from" : 18
		}, {
			"id" : 42,
			"to" : 342,
			"from" : 18
		}, {
			"id" : 43,
			"to" : 343,
			"from" : 18
		} ],
		"id" : 18,
		"position" : {
			"x" : 273,
			"y" : 367
		},
		"width" : 49,
		"height" : 43,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [],
		"id" : 261,
		"position" : {
			"x" : 391,
			"y" : 227
		},
		"width" : 42,
		"height" : 35,
		"style" : "download",
		"value" : ""
	}, {
		"outs" : [],
		"id" : 271,
		"position" : {
			"x" : 94.5,
			"y" : 228
		},
		"width" : 44,
		"height" : 37,
		"style" : "download",
		"value" : ""
	}, {
		"outs" : [ {
			"id" : 44,
			"to" : 32,
			"from" : 31
		} ],
		"id" : 332,
		"position" : {
			"x" : 641,
			"y" : 319
		},
		"width" : 136,
		"height" : 33,
		"style" : "subflow",
		"value" : "油位、油压异常"
	}, {
		"outs" : [ {
			"id" : 46,
			"to" : 344,
			"from" : 32
		}, {
			"id" : 47,
			"to" : 345,
			"from" : 32
		} ],
		"id" : 32,
		"position" : {
			"x" : 687,
			"y" : 379.5
		},
		"width" : 44,
		"height" : 41,
		"style" : "start",
		"value" : "或门"
	}, {
		"outs" : [],
		"id" : 341,
		"position" : {
			"x" : 110,
			"y" : 433
		},
		"width" : 117,
		"height" : 45,
		"style" : "process",
		"value" : "压油罐油压偏低"
	}, {
		"outs" : [],
		"id" : 342,
		"position" : {
			"x" : 238.5,
			"y" : 436
		},
		"width" : 118,
		"height" : 39,
		"style" : "process",
		"value" : "回油箱油位异常"
	}, {
		"outs" : [],
		"id" : 343,
		"position" : {
			"x" : 374,
			"y" : 433.5
		},
		"width" : 133,
		"height" : 44,
		"style" : "process",
		"value" : "压油罐油压偏高"
	}, {
		"outs" : [],
		"id" : 344,
		"position" : {
			"x" : 544,
			"y" : 434.5
		},
		"width" : 114,
		"height" : 35,
		"style" : "process",
		"value" : "油系统管路漏油"
	}, {
		"outs" : [],
		"id" : 345,
		"position" : {
			"x" : 762,
			"y" : 430
		},
		"width" : 112,
		"height" : 40,
		"style" : "process",
		"value" : "油泵频繁启动"
	} ]
};



var cell4 = {               //cell4数组
	"cells" : [ {
		"outs" : [ {
			"id" : 26,
			"to" : 23,
			"from" : 19
		}, {
			"id" : 27,
			"to" : 24,
			"from" : 19
		} ],
		"id" : 19,
		"position" : {
			"x" : 628.5,
			"y" : 213
		},
		"width" : 117,
		"height" : 39,
		"style" : "subflow",
		"value" : "油系统管路异常"
	}, {
		"outs" : [],
		"id" : 20,
		"position" : {
			"x" : 349,
			"y" : 362
		},
		"width" : 110,
		"height" : 40,
		"style" : "subflow",
		"value" : "回油箱油位异常"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 476,
			"y" : 360
		},
		"width" : 108,
		"height" : 41,
		"style" : "subflow",
		"value" : "压油罐油压偏高"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 210,
			"y" : 361
		},
		"width" : 123,
		"height" : 40,
		"style" : "subflow",
		"value" : "压油罐油压偏低"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 593,
			"y" : 365
		},
		"width" : 117,
		"height" : 36,
		"style" : "subflow",
		"value" : "油系统管路漏油"
	}, {
		"outs" : [],
		"id" : 24,
		"position" : {
			"x" : 722,
			"y" : 365
		},
		"width" : 100,
		"height" : 36,
		"style" : "subflow",
		"value" : "油泵频繁启动"
	} ]
};
