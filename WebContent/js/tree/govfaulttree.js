//cell数组到cell4数组的内容

var cell1 = { // 调速器本体故障
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 23,
			"from" : 1
		}, {
			"id" : 20,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 21,
			"to" : 22,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 312,
			"y" : 9
		},
		"width" : 203,
		"height" : 51,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [ {
			"id" : 23,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 30,
			"to" : 312,
			"from" : 21
		}, {
			"id" : 31,
			"to" : 313,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 102,
			"y" : 121
		},
		"width" : 145,
		"height" : 51,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 344,
			"y" : 121
		},
		"width" : 139,
		"height" : 50,
		"style" : "subflow",
		"value" : "调速器性能异常"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 581,
			"y" : 121
		},
		"width" : 139,
		"height" : 49,
		"style" : "subflow",
		"value" : "油压装置运行异常"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 4112,
			"from" : 311
		}, {
			"id" : 33,
			"to" : 4111,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : 76,
			"y" : 261
		},
		"width" : 197,
		"height" : 49,
		"style" : "subflow",
		"value" : "导叶开度反馈故障"
	}, {
		"outs" : [],
		"id" : 312,
		"position" : {
			"x" : 290,
			"y" : 258
		},
		"width" : 178,
		"height" : 50,
		"style" : "subflow",
		"value" : "配压阀跳动或抖动"
	}, {
		"outs" : [],
		"id" : 313,
		"position" : {
			"x" : 485,
			"y" : 257
		},
		"width" : 176,
		"height" : 51,
		"style" : "subflow",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 281,
			"y" : 418
		},
		"width" : 186,
		"height" : 62,
		"style" : "process",
		"value" : "开度反馈信号为最大值"
	}, {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : 21,
			"y" : 418
		},
		"width" : 190,
		"height" : 67,
		"style" : "process",
		"value" : "开度反馈信号为零"
	} ]
}

var cell2 = { // 调速器性能异常
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 20,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 21,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 312,
			"y" : 9
		},
		"width" : 203,
		"height" : 51,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 102,
			"y" : 121
		},
		"width" : 145,
		"height" : 51,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 34,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 35,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 36,
			"to" : 323,
			"from" : 22
		}, {
			"id" : 37,
			"to" : 324,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 344,
			"y" : 123
		},
		"width" : 139,
		"height" : 47,
		"style" : "subflow",
		"value" : "调速器性能异常"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 581,
			"y" : 121
		},
		"width" : 139,
		"height" : 49,
		"style" : "subflow",
		"value" : "油压装置运行异常"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 76,
			"y" : 261
		},
		"width" : 197,
		"height" : 49,
		"style" : "subflow",
		"value" : "停机超时"
	}, {
		"outs" : [ {
			"id" : 40,
			"to" : 4222,
			"from" : 322
		}, {
			"id" : 41,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 42,
			"to" : 4223,
			"from" : 322
		}, {
			"id" : 43,
			"to" : 4224,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 290,
			"y" : 261
		},
		"width" : 178,
		"height" : 50,
		"style" : "subflow",
		"value" : "开机异常"
	}, {
		"outs" : [],
		"id" : 323,
		"position" : {
			"x" : 485,
			"y" : 261
		},
		"width" : 176,
		"height" : 51,
		"style" : "subflow",
		"value" : "增减负荷异常"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 286,
			"y" : 418
		},
		"width" : 186,
		"height" : 62,
		"style" : "process",
		"value" : "转速达不到额定值"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 65,
			"y" : 418
		},
		"width" : 190,
		"height" : 67,
		"style" : "process",
		"value" : "导叶响应缓慢"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 685,
			"y" : 261
		},
		"width" : 169,
		"height" : 48,
		"style" : "subflow",
		"value" : "并网运行溜负荷"
	}, {
		"outs" : [],
		"id" : 4223,
		"position" : {
			"x" : 508,
			"y" : 418
		},
		"width" : 164,
		"height" : 62,
		"style" : "process",
		"value" : "接力器不开启"
	}, {
		"outs" : [],
		"id" : 4224,
		"position" : {
			"x" : 702,
			"y" : 418
		},
		"width" : 156,
		"height" : 70,
		"style" : "process",
		"value" : "误开机或蠕动"
	} ]
}
// 油压装置异常

var cell3 = {// 调速油系统故障
	"cells" : [ {
		"outs" : [ {
			"id" : 20,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 21,
			"to" :22,
			"from" : 1
		}, {
			"id" : 22,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 450,
			"y" : 12
		},
		"width" : 152,
		"height" : 52,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 57,
			"y" : 111
		},
		"width" : 148,
		"height" : 47,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 455,
			"y" : 111
		},
		"width" : 142,
		"height" : 49,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [ {
			"id" : 23,
			"to" :333,
			"from" : 23
		}, {
			"id" : 24,
			"to" : 332,
			"from" : 23
		}, {
			"id" : 25,
			"to" : 331,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 809,
			"y" : 111
		},
		"width" : 136,
		"height" : 49,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [ {
			"id" : 26,
			"to" :4311,
			"from" :331
		}, {
			"id" : 27,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 28,
			"to" : 4313,
			"from" : 331
		}, {
			"id" : 29,
			"to" : 4314,
			"from" :331
		} ],
		"id" : 331,
		"position" : {
			"x" : 104,
			"y" : 224
		},
		"width" : 137,
		"height" : 52,
		"style" : "subflow",
		"value" : "状态越限异常"
	}, {
		"outs" : [ {
			"id" : 30,
			"to" : 4321,
			"from" : 332
		}, {
			"id" : 31,
			"to" : 4322,
			"from" : 332
		}, {
			"id" : 32,
			"to" : 4323,
			"from" : 332
		} ],
		"id" :332,
		"position" : {
			"x" : 507,
			"y" : 225
		},
		"width" : 135,
		"height" : 51,
		"style" : "subflow",
		"value" : "性能下降或异常"
	}, {
		"outs" : [ {
			"id" : 36,
			"to" : 4331,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 884,
			"y" : 224
		},
		"width" : 135,
		"height" : 54,
		"style" : "subflow",
		"value" : "设备故障"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 8,
			"y" : 410
		},
		"width" : 158,
		"height" : 66,
		"style" : "process",
		"value" : "集油箱油位偏高"
	}, {
		"outs" : [],
		"id" :4312,
		"position" : {
			"x" : 203,
			"y" : 410
		},
		"width" : 151,
		"height" : 68,
		"style" : "process",
		"value" : "集油箱油位偏低"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 6,
			"y" : 548
		},
		"width" : 157,
		"height" : 68,
		"style" : "process",
		"value" : "压力油罐油位偏高"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 203,
			"y" : 548
		},
		"width" : 157,
		"height" : 67,
		"style" : "process",
		"value" : "压力油罐油位偏低"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 338,
			"y" : 329
		},
		"width" : 139,
		"height" : 57,
		"style" : "subflow",
		"value" : "压油罐漏气"
	}, {
		"outs" : [ {
			"id" : 33,
			"to" : 16,
			"from" : 4322
		} ],
		"id" : 4322,
		"position" : {
			"x" : 503,
			"y" : 329
		},
		"width" : 142,
		"height" : 55,
		"style" : "subflow",
		"value" : "油系统漏油"
	}, {
		"outs" : [ {
			"id" : 34,
			"to" : 17,
			"from" : 4323
		}, {
			"id" : 35,
			"to" : 18,
			"from" : 4323
		} ],
		"id" : 4323,
		"position" : {
			"x" : 690,
			"y" : 329
		},
		"width" : 128,
		"height" : 53,
		"style" : "subflow",
		"value" : "油泵效率低"
	}, {
		"outs" : [],
		"id" : 16,
		"position" : {
			"x" : 498,
			"y" : 474
		},
		"width" : 152,
		"height" : 67,
		"style" : "process",
		"value" : " 压油罐耗油速度偏大"
	}, {
		"outs" : [],
		"id" : 17,
		"position" : {
			"x" : 753,
			"y" : 476
		},
		"width" : 166,
		"height" : 63,
		"style" : "process",
		"value" : "油泵单位时间启动频繁"
	}, {
		"outs" : [],
		"id" : 18,
		"position" : {
			"x" : 754,
			"y" : 570
		},
		"width" : 162,
		"height" : 67,
		"style" : "process",
		"value" : "打油量偏低"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 871,
			"y" : 400
		},
		"width" : 161,
		"height" : 70,
		"style" : "process",
		"value" : "油泵不能正常开启"
	} ]
}

// 调速器总图
var cell4 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 32,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 33,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 34,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 717,
			"y" : 20
		},
		"width" : 201,
		"height" : 66,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [ {
			"id" : 35,
			"to" :313,
			"from" : 21
		}, {
			"id" : 36,
			"to" : 312,
			"from" :21
		}, {
			"id" : 37,
			"to" : 311,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : -2,
			"y" : 182
		},
		"width" : 218,
		"height" : 67,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 40,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 41,
			"to" : 323,
			"from" : 22
		}, {
			"id" : 42,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 43,
			"to" : 324,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 611,
			"y" : 182
		},
		"width" : 230,
		"height" : 65,
		"style" : "subflow",
		"value" : "调速器性能异常"
	}, {
		"outs" : [ {
			"id" : 48,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 49,
			"to" : 332,
			"from" : 23
		}, {
			"id" : 50,
			"to" : 333,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 1187,
			"y" : 182
		},
		"width" : 227,
		"height" : 64,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [],
		"id" : 313,
		"position" : {
			"x" : 149,
			"y" : 368
		},
		"width" : 182,
		"height" : 62,
		"style" : "subflow",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 312,
		"position" : {
			"x" : 143,
			"y" : 472
		},
		"width" : 185,
		"height" : 63,
		"style" : "subflow",
		"value" : "配压阀和接力器跳动或抖动"
	}, {
		"outs" : [ {
			"id" : 62,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 63,
			"to" : 4112,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : 19,
			"y" : 570
		},
		"width" : 176,
		"height" : 60,
		"style" : "subflow",
		"value" : "导叶开度反馈故障"
	}, {
		"outs" : [],
		"id" :4111,
		"position" : {
			"x" : 176,
			"y" : 656
		},
		"width" : 175,
		"height" : 69,
		"style" : "process",
		"value" : "导叶开度反馈信号为零"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 177,
			"y" : 762
		},
		"width" : 174,
		"height" : 67,
		"style" : "process",
		"value" : "导叶开度反馈为最大值"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 492,
			"y" : 365
		},
		"width" : 168,
		"height" : 65,
		"style" : "subflow",
		"value" : "停机超时"
	}, {
		"outs" : [],
		"id" : 323,
		"position" : {
			"x" : 743,
			"y" : 365
		},
		"width" : 158,
		"height" : 63,
		"style" : "subflow",
		"value" : "增减负荷异常"
	}, {
		"outs" : [ {
			"id" : 44,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 45,
			"to" : 4222,
			"from" : 322
		}, {
			"id" : 46,
			"to" : 4223,
			"from" : 322
		}, {
			"id" : 47,
			"to" : 4224,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 491,
			"y" : 525
		},
		"width" : 175,
		"height" : 65,
		"style" : "subflow",
		"value" : "开机异常"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 731,
			"y" : 525
		},
		"width" : 167,
		"height" : 59,
		"style" : "subflow",
		"value" : "并网运行溜负荷"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 593,
			"y" : 643
		},
		"width" : 165,
		"height" : 64,
		"style" : "process",
		"value" : "开机导叶响应缓慢"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 786,
			"y" : 644
		},
		"width" : 155,
		"height" : 62,
		"style" : "process",
		"value" : "开机转速达不到额定值"
	}, {
		"outs" : [],
		"id" : 4223,
		"position" : {
			"x" : 530,
			"y" : 775
		},
		"width" : 162,
		"height" : 64,
		"style" : "process",
		"value" : "开机接力器 不开启"
	}, {
		"outs" : [],
		"id" : 4224,
		"position" : {
			"x" : 719,
			"y" : 775
		},
		"width" : 152,
		"height" : 63,
		"style" : "process",
		"value" : "机组误开机或蠕动"
	}, {
		"outs" : [ {
			"id" : 54,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 55,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 56,
			"to" : 4313,
			"from" : 331
		}, {
			"id" : 57,
			"to" : 4314,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 996,
			"y" : 368
		},
		"width" : 160,
		"height" : 64,
		"style" : "subflow",
		"value" : "状态越限异常"
	}, {
		"outs" : [ {
			"id" : 58,
			"to" : 4331,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 1479,
			"y" : 368
		},
		"width" : 149,
		"height" : 63,
		"style" : "subflow",
		"value" : "设备故障"
	}, {
		"outs" : [ {
			"id" : 51,
			"to" : 4321,
			"from" : 332
		}, {
			"id" : 52,
			"to" : 4322,
			"from" : 332
		}, {
			"id" : 53,
			"to" :4323,
			"from" : 332
		} ],
		"id" : 332,
		"position" : {
			"x" : 1221,
			"y" : 368
		},
		"width" : 158,
		"height" : 63,
		"style" : "subflow",
		"value" : "性能下降或异常"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 1127,
			"y" : 522
		},
		"width" : 156,
		"height" : 64,
		"style" : "process",
		"value" : "集油箱油位偏高"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 907,
			"y" : 522
		},
		"width" : 159,
		"height" : 64,
		"style" : "process",
		"value" : "集油箱油位偏低"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 1078,
			"y" : 678
		},
		"width" : 163,
		"height" : 63,
		"style" : "process",
		"value" : "压力油罐油位偏高"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 1069,
			"y" : 799
		},
		"width" : 156,
		"height" : 66,
		"style" : "process",
		"value" : "压力油罐油位偏低"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 1300,
			"y" : 491
		},
		"width" : 156,
		"height" : 58,
		"style" : "subflow",
		"value" : "压油罐漏气"
	}, {
		"outs" : [ {
			"id" : 59,
			"to" : 28,
			"from" :4322
		} ],
		"id" : 4322,
		"position" : {
			"x" : 1235,
			"y" : 636
		},
		"width" : 157,
		"height" : 59,
		"style" : "subflow",
		"value" : "油系统漏油"
	}, {
		"outs" : [ {
			"id" : 60,
			"to" : 29,
			"from" : 4323
		}, {
			"id" : 61,
			"to" : 30,
			"from" : 4323
		} ],
		"id" : 4323,
		"position" : {
			"x" : 1424,
			"y" : 636
		},
		"width" : 144,
		"height" : 60,
		"style" : "subflow",
		"value" : "油泵效率低"
	}, {
		"outs" : [],
		"id" : 28,
		"position" : {
			"x" : 1238,
			"y" : 817
		},
		"width" : 151,
		"height" : 64,
		"style" : "process",
		"value" : " 压油罐耗油速度偏大"
	}, {
		"outs" : [],
		"id" : 29,
		"position" : {
			"x" : 1508,
			"y" : 818
		},
		"width" : 157,
		"height" : 64,
		"style" : "process",
		"value" : "油泵单位时间启动频繁"
	}, {
		"outs" : [],
		"id" : 30,
		"position" : {
			"x" : 1419,
			"y" : 890
		},
		"width" : 154,
		"height" : 68,
		"style" : "process",
		"value" : "打油量偏低"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 1471,
			"y" : 492
		},
		"width" : 165,
		"height" : 67,
		"style" : "process",
		"value" : "油泵不能正常开启"
	} ]
}