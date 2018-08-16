//cell数组到cell4数组的内容
// 调速器总图
var cell1 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 11,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 12,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 13,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 333,
			"y" : 1
		},
		"width" : 128,
		"height" : 46,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [ {
			"id" : 14,
			"to" : 313,
			"from" : 21
		}, 
		{
			"id" : 15,
			"to" :312,
			"from" : 21
		},
		{
			"id" : 16,
			"to" : 311,
			"from" : 21
		}
		, {
			"id" : 65,
			"to" :312,
			"from" : 21
		} 
		],
		"id" : 21,
		"position" : {
			"x" : 77,
			"y" : 81
		},
		"width" : 132,
		"height" : 48,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 25,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 26,
			"to" : 324,
			"from" : 22
		}, {
			"id" : 27,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 28,
			"to" : 323,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 335,
			"y" : 80
		},
		"width" : 124,
		"height" : 45,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [ {
			"id" : 32,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 33,
			"to" : 332,
			"from" :23
		}, {
			"id" : 34,
			"to" : 333,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 628,
			"y" : 81
		},
		"width" : 125,
		"height" : 43,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [ {
			"id" : 18,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 20,
			"to" : 4112,
			"from" : 311
		} ],
		"id" :311,
		"position" : {
			"x" : 0,
			"y" : 156
		},
		"width" : 123,
		"height" : 43,
		"style" : "subflow",
		"value" : "导叶开度反馈故障"
	}, {
		"outs" : [],
		"id" :313,
		"position" : {
			"x" : 157,
			"y" : 156
		},
		"width" : 118,
		"height" : 44,
		"style" : "process",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 312,
		"position" : {
			"x" : 70,
			"y" : 218
		},
		"width" : 146,
		"height" : 46,
		"style" : "process",
		"value" : "配压阀跳动或抖动"
	}, {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : -1,
			"y" : 314
		},
		"width" : 125,
		"height" : 42,
		"style" : "process",
		"value" : "开度反馈信号为零"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 153,
			"y" : 311
		},
		"width" : 138,
		"height" : 42,
		"style" : "process",
		"value" : "开度反馈为最大值"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 283,
			"y" : 148
		},
		"width" : 106,
		"height" : 45,
		"style" : "subflow",
		"value" : "停机超时"
	}, {
		"outs" : [],
		"id" : 323,
		"position" : {
			"x" : 399,
			"y" : 229
		},
		"width" : 112,
		"height" : 45,
		"style" : "subflow",
		"value" : "并网运行溜负荷"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 407,
			"y" : 148
		},
		"width" : 100,
		"height" : 45,
		"style" : "subflow",
		"value" : "增减负荷异常"
	}, {
		"outs" : [ {
			"id" : 48,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 49,
			"to" : 4222,
			"from" : 322
		}, {
			"id" : 50,
			"to" : 4223,
			"from" : 322
		}, {
			"id" : 51,
			"to" : 4224,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 270,
			"y" : 229
		},
		"width" : 100,
		"height" : 46,
		"style" : "subflow",
		"value" : "开机异常"
	}, {
		"outs" : [ {
			"id" : 44,
			"to" : 4311,
			"from" : 311
		}, {
			"id" : 45,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 46,
			"to" : 4313,
			"from" :331
		}, {
			"id" : 47,
			"to" : 4314,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 522,
			"y" : 147
		},
		"width" : 106,
		"height" : 46,
		"style" : "subflow",
		"value" : "状态越限异常"
	}, {
		"outs" : [ {
			"id" : 54,
			"to" : 4323,
			"from" : 332
		}, {
			"id" : 55,
			"to" : 4322,
			"from" : 332
		}, {
			"id" : 63,
			"to" : 4321,
			"from" : 332
		} ],
		"id" : 332,
		"position" : {
			"x" : 631,
			"y" : 146
		},
		"width" : 118,
		"height" : 45,
		"style" : "subflow",
		"value" : "性能下降或异常"
	}, {
		"outs" : [ {
			"id" : 60,
			"to" : 4331,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 752,
			"y" : 147
		},
		"width" : 100,
		"height" : 43,
		"style" : "subflow",
		"value" : "设备故障"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 742,
			"y" : 220
		},
		"width" : 120,
		"height" : 45,
		"style" : "process",
		"value" : "油泵不能正常开启"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 577,
			"y" : 226
		},
		"width" : 113,
		"height" : 42,
		"style" : "process",
		"value" : "集油箱油位偏高"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 578,
			"y" : 309
		},
		"width" : 111,
		"height" : 45,
		"style" : "process",
		"value" : "集油箱油位偏低"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 452,
			"y" : 468
		},
		"width" : 121,
		"height" : 47,
		"style" : "process",
		"value" : "压力油罐油位偏高"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 299,
			"y" : 468
		},
		"width" : 118,
		"height" : 49,
		"style" : "process",
		"value" : "压力油罐油位偏低"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 325,
			"y" : 309
		},
		"width" : 114,
		"height" : 43,
		"style" : "process",
		"value" : "导叶响应缓慢"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 455,
			"y" : 308
		},
		"width" : 121,
		"height" : 44,
		"style" : "process",
		"value" : "转速达不到额定值"
	}, {
		"outs" : [],
		"id" : 4223,
		"position" : {
			"x" : 323,
			"y" : 390
		},
		"width" : 120,
		"height" : 43,
		"style" : "process",
		"value" : "接力器 不开启"
	}, {
		"outs" : [],
		"id" : 4224,
		"position" : {
			"x" : 456,
			"y" : 390
		},
		"width" : 119,
		"height" : 45,
		"style" : "process",
		"value" : "误开机或蠕动"
	}, {
		"outs" : [ {
			"id" : 61,
			"to" : 57,
			"from" : 4323
		}, {
			"id" : 62,
			"to" : 59,
			"from" : 4323
		} ],
		"id" : 4323,
		"position" : {
			"x" : 720,
			"y" : 311
		},
		"width" : 100,
		"height" : 43,
		"style" : "subflow",
		"value" : "油泵效率低"
	}, {
		"outs" : [ {
			"id" : 64,
			"to" : 58,
			"from" : 4322
		} ],
		"id" : 4322,
		"position" : {
			"x" : 830,
			"y" : 311
		},
		"width" : 100,
		"height" : 43,
		"style" : "subflow",
		"value" : "油系统漏油"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 584,
			"y" : 392
		},
		"width" : 107,
		"height" : 45,
		"style" : "process",
		"value" : "压油罐漏气"
	}, {
		"outs" : [],
		"id" : 57,
		"position" : {
			"x" : 690,
			"y" : 469
		},
		"width" : 160,
		"height" : 43,
		"style" : "process",
		"value" : "油泵单位时间启动频繁"
	}, {
		"outs" : [],
		"id" : 58,
		"position" : {
			"x" : 824,
			"y" : 391
		},
		"width" : 112,
		"height" : 45,
		"style" : "process",
		"value" : "耗油速度偏大"
	}, {
		"outs" : [],
		"id" : 59,
		"position" : {
			"x" : 578,
			"y" : 469
		},
		"width" : 116,
		"height" : 46,
		"style" : "process",
		"value" : "打油量偏低"
	} ]
}


var cell2 = // 调速器本体故障
{
	"cells" : [ {
		"outs" : [ {
			"id" : 10,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 11,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 12,
			"to" :23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 328,
			"y" : 3
		},
		"width" : 133,
		"height" : 40,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [ {
			"id" : 13,
			"to" : 311,
			"from" :21
		}, {
			"id" : 14,
			"to" : 312,
			"from" :21
		}, {
			"id" : 15,
			"to" :313,
			"from" :21
		} ],
		"id" : 21,
		"position" : {
			"x" : 67,
			"y" : 81
		},
		"width" : 112,
		"height" : 43,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 330,
			"y" : 83
		},
		"width" : 129,
		"height" : 40,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 587,
			"y" : 81
		},
		"width" : 115,
		"height" : 44,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [ {
			"id" : 16,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 17,
			"to" : 4112,
			"from" :311
		} ],
		"id" : 311,
		"position" : {
			"x" : 10,
			"y" : 160
		},
		"width" : 127,
		"height" : 44,
		"style" : "subflow",
		"value" : "导叶开度反馈故障"
	}, {
		"outs" : [],
		"id" :312,
		"position" : {
			"x" : 168,
			"y" : 160
		},
		"width" : 133,
		"height" : 40,
		"style" : "process",
		"value" : "配压阀跳动或抖动"
	}, {
		"outs" : [],
		"id" :313,
		"position" : {
			"x" : 340,
			"y" : 160
		},
		"width" : 133,
		"height" : 40,
		"style" : "process",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" :4111,
		"position" : {
			"x" : 82,
			"y" : 241
		},
		"width" : 137,
		"height" : 39,
		"style" : "process",
		"value" : "开度反馈信号为零"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 80,
			"y" : 316
		},
		"width" : 141,
		"height" : 41,
		"style" : "process",
		"value" : "开度反馈为最大值"
	} ]
}

var cell3 = // 调速器性能异常
{
	"cells" : [ {
		"outs" : [ {
			"id" : 13,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 14,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 15,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 336,
			"y" : 6
		},
		"width" : 131,
		"height" : 43,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 55,
			"y" : 81
		},
		"width" : 124,
		"height" : 42,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 16,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 17,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 18,
			"to" : 323,
			"from" : 22
		}, {
			"id" : 19,
			"to" : 324,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 340,
			"y" : 81
		},
		"width" : 123,
		"height" : 42,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 584,
			"y" : 81
		},
		"width" : 116,
		"height" : 40,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 126,
			"y" : 162
		},
		"width" : 100,
		"height" : 40,
		"style" : "subflow",
		"value" : "停机超时"
	}, {
		"outs" : [ {
			"id" : 20,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 21,
			"to" : 4222,
			"from" : 322
		}, {
			"id" : 22,
			"to" : 4223,
			"from" : 322
		}, {
			"id" : 23,
			"to" : 4224,
			"from" : 322
		} ],
		"id" :322,
		"position" : {
			"x" : 261,
			"y" : 162
		},
		"width" : 100,
		"height" : 43,
		"style" : "subflow",
		"value" : "开机异常"
	}, {
		"outs" : [],
		"id" : 323,
		"position" : {
			"x" : 401,
			"y" : 162
		},
		"width" : 100,
		"height" : 40,
		"style" : "subflow",
		"value" : "增减负荷异常"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 540,
			"y" : 162
		},
		"width" : 100,
		"height" : 42,
		"style" : "subflow",
		"value" : "并网运行溜负荷"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 107,
			"y" : 241
		},
		"width" : 127,
		"height" : 41,
		"style" : "process",
		"value" : "导叶响应缓慢"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 249,
			"y" : 238
		},
		"width" : 124,
		"height" : 44,
		"style" : "process",
		"value" : "转速达不到额定值"
	}, {
		"outs" : [],
		"id" : 4223,
		"position" : {
			"x" : 375,
			"y" : 241
		},
		"width" : 121,
		"height" : 42,
		"style" : "process",
		"value" : "接力器不开启"
	}, {
		"outs" : [],
		"id" :4224,
		"position" : {
			"x" : 507,
			"y" : 241
		},
		"width" : 119,
		"height" : 42,
		"style" : "process",
		"value" : "误开机或蠕动"
	} ]
}
// 油压装置异常

var cell4 = // 调速油系统故障
{
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 6,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 336,
			"y" : 2
		},
		"width" : 129,
		"height" : 43,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 20,
			"y" : 81
		},
		"width" : 111,
		"height" : 41,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 338,
			"y" : 82
		},
		"width" : 125,
		"height" : 41,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [ {
			"id" : 11,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 12,
			"to" : 332,
			"from" : 23
		}, {
			"id" : 13,
			"to" : 333,
			"from" :23
		} ],
		"id" :23,
		"position" : {
			"x" : 586,
			"y" : 81
		},
		"width" : 113,
		"height" : 38,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [ {
			"id" : 26,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 27,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 28,
			"to" :4313,
			"from" : 331
		}, {
			"id" : 29,
			"to" : 4314,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 401,
			"y" : 160
		},
		"width" : 100,
		"height" : 39,
		"style" : "subflow",
		"value" : "状态越限异常"
	}, {
		"outs" : [ {
			"id" : 22,
			"to" : 4321,
			"from" : 332
		}, {
			"id" : 24,
			"to" : 4323,
			"from" : 332
		}, {
			"id" : 25,
			"to" : 4322,
			"from" : 332
		} ],
		"id" : 332,
		"position" : {
			"x" : 551,
			"y" : 160
		},
		"width" : 106,
		"height" : 40,
		"style" : "subflow",
		"value" : "性能下降或异常"
	}, {
		"outs" : [ {
			"id" : 23,
			"to" : 4331,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 678,
			"y" : 160
		},
		"width" : 100,
		"height" : 37,
		"style" : "subflow",
		"value" : "设备故障"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 219,
			"y" : 242
		},
		"width" : 117,
		"height" : 45,
		"style" : "process",
		"value" : "集油箱油位偏高"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 335,
			"y" : 242
		},
		"width" : 116,
		"height" : 43,
		"style" : "process",
		"value" : "集油箱油位偏低"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 220,
			"y" : 319
		},
		"width" : 118,
		"height" : 44,
		"style" : "process",
		"value" : "压力油罐油位偏高"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 343,
			"y" : 319
		},
		"width" : 117,
		"height" : 46,
		"style" : "process",
		"value" : "压力油罐油位偏低"
	}, {
		"outs" : [ {
			"id" : 33,
			"to" : 31,
			"from" : 4323
		}, {
			"id" : 34,
			"to" : 30,
			"from" : 4323
		} ],
		"id" : 4323,
		"position" : {
			"x" : 554,
			"y" : 323
		},
		"width" : 100,
		"height" : 38,
		"style" : "subflow",
		"value" : "油泵效率低"
	}, {
		"outs" : [ {
			"id" : 35,
			"to" : 32,
			"from" : 4322
		} ],
		"id" : 4322,
		"position" : {
			"x" : 682,
			"y" : 320
		},
		"width" : 100,
		"height" : 38,
		"style" : "subflow",
		"value" : "油系统漏油"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 480,
			"y" : 244
		},
		"width" : 125,
		"height" : 44,
		"style" : "process",
		"value" : "压油罐漏气"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 667,
			"y" : 241
		},
		"width" : 122,
		"height" : 44,
		"style" : "process",
		"value" : "油泵不能正常开启"
	}, {
		"outs" : [],
		"id" : 30,
		"position" : {
			"x" : 348,
			"y" : 401
		},
		"width" : 121,
		"height" : 44,
		"style" : "process",
		"value" : "打油量偏低"
	}, {
		"outs" : [],
		"id" : 31,
		"position" : {
			"x" : 486,
			"y" : 401
		},
		"width" : 155,
		"height" : 43,
		"style" : "process",
		"value" : "油泵单位时间启动频繁"
	}, {
		"outs" : [],
		"id" : 32,
		"position" : {
			"x" : 672,
			"y" : 404
		},
		"width" : 118,
		"height" : 43,
		"style" : "process",
		"value" : "耗油速度偏大"
	} ]
}
