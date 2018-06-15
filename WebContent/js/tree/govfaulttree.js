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
		"id" :311,
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
			"to" :23,
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

var cell3 = {//油压装置运行异常
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 6,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 292,
			"y" : 21
		},
		"width" : 166,
		"height" : 58,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 31,
			"y" : 146
		},
		"width" : 158,
		"height" : 52,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 296,
			"y" : 145
		},
		"width" : 158,
		"height" : 53,
		"style" : "subflow",
		"value" : "调速器性能异常"
	}, {
		"outs" : [ {
			"id" : 11,
			"to" :  333,
			"from" : 23
		}, {
			"id" : 12,
			"to" :  332,
			"from" : 23
		}, {
			"id" : 13,
			"to" : 331,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 595,
			"y" : 146
		},
		"width" : 156,
		"height" : 52,
		"style" : "subflow",
		"value" : "油压装置运行异常"
	}, {
		"outs" : [ {
			"id" : 16,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 17,
			"to" : 4312,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 146,
			"y" : 262
		},
		"width" : 161,
		"height" : 56,
		"style" : "subflow",
		"value" : "集油箱异常"
	}, {
		"outs" : [ {
			"id" : 22,
			"to" :  4321,
			"from" :  332
		}, {
			"id" :  23,
			"to" : 4322,
			"from" :  332
		} ],
		"id" : 332,
		"position" : {
			"x" : 371,
			"y" : 262
		},
		"width" : 162,
		"height" : 58,
		"style" : "subflow",
		"value" : "压力油罐异常"
	}, {
		"outs" : [ {
			"id" : 24,
			"to" : 4331,
			"from" :  333
		}, {
			"id" : 25,
			"to" : 4332,
			"from" :  333
		} ],
		"id" :  333,
		"position" : {
			"x" : 596,
			"y" : 264
		},
		"width" : 154,
		"height" : 55,
		"style" : "subflow",
		"value" : "气系统压力罐异常"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 235,
			"y" : 357
		},
		"width" : 129,
		"height" : 67,
		"style" : "process",
		"value" : "集油箱油位偏高"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 239,
			"y" : 479
		},
		"width" : 125,
		"height" : 65,
		"style" : "process",
		"value" : "集油箱油位偏低"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 457,
			"y" : 356
		},
		"width" : 127,
		"height" : 67,
		"style" : "process",
		"value" : "压力油罐油位偏高"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 677,
			"y" : 359
		},
		"width" : 127,
		"height" : 64,
		"style" : "process",
		"value" : "补气压罐压力偏高"
	}, {
		"outs" : [],
		"id" :  4322,
		"position" : {
			"x" : 459,
			"y" : 480
		},
		"width" : 127,
		"height" : 65,
		"style" : "process",
		"value" : "压力油罐油位偏低"
	}, {
		"outs" : [],
		"id" : 4332,
		"position" : {
			"x" : 675,
			"y" : 478
		},
		"width" : 128,
		"height" : 64,
		"style" : "process",
		"value" : "补气压罐压力偏低"
	} ]
}
// 调速器总图
var cell4 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 15,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 16,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 17,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 380,
			"y" : 16
		},
		"width" : 157,
		"height" : 54,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [ {
			"id" : 40,
			"to" : 312,
			"from" : 21
		}, {
			"id" : 41,
			"to" : 313,
			"from" : 21
		}, {
			"id" : 42,
			"to" : 311,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 4,
			"y" : 121
		},
		"width" : 151,
		"height" : 58,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 23,
			"to" : 321,
			"from" :22
		}, {
			"id" : 24,
			"to" : 323,
			"from" : 22
		}, {
			"id" : 25,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 26,
			"to" : 324,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 385,
			"y" : 126
		},
		"width" : 148,
		"height" : 57,
		"style" : "subflow",
		"value" : "调速器性能异常"
	}, {
		"outs" : [ {
			"id" : 49,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 50,
			"to" : 332,
			"from" :23
		}, {
			"id" : 51,
			"to" : 333,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 709,
			"y" : 121
		},
		"width" : 150,
		"height" : 57,
		"style" : "subflow",
		"value" : "油压装置运行异常"
	}, {
		"outs" : [ {
			"id" : 43,
			"to" : 4112,
			"from" : 311
		}, {
			"id" : 44,
			"to" : 4111,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : 97,
			"y" : 397
		},
		"width" : 130,
		"height" : 49,
		"style" : "subflow",
		"value" : "导叶开度反馈故障"
	}, {
		"outs" : [],
		"id" : 312,
		"position" : {
			"x" : 97,
			"y" : 232
		},
		"width" : 129,
		"height" : 49,
		"style" : "subflow",
		"value" : "配压阀跳动或抖动"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 175,
			"y" : 493
		},
		"width" : 151,
		"height" : 62,
		"style" : "process",
		"value" : "开度反馈为最大值"
	}, {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : 183,
			"y" : 594
		},
		"width" : 145,
		"height" : 62,
		"style" : "process",
		"value" : "开度反馈信号为零"
	}, {
		"outs" : [],
		"id" : 313,
		"position" : {
			"x" : 98,
			"y" : 314
		},
		"width" : 130,
		"height" : 49,
		"style" : "subflow",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 300,
			"y" : 231
		},
		"width" : 148,
		"height" : 47,
		"style" : "subflow",
		"value" : "停机超时"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 479,
			"y" : 349
		},
		"width" : 145,
		"height" : 49,
		"style" : "subflow",
		"value" : "并网运行溜负荷"
	}, {
		"outs" : [ {
			"id" : 58,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 59,
			"to" : 4222,
			"from" : 322
		}, {
			"id" : 60,
			"to" : 4223,
			"from" : 322
		}, {
			"id" : 61,
			"to" : 4224,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 303,
			"y" : 349
		},
		"width" : 145,
		"height" : 48,
		"style" : "subflow",
		"value" : "开机异常"
	}, {
		"outs" : [],
		"id" : 323,
		"position" : {
			"x" : 476,
			"y" : 231
		},
		"width" : 142,
		"height" : 50,
		"style" : "subflow",
		"value" : "增减负荷异常"
	}, {
		"outs" : [ {
			"id" : 52,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 53,
			"to" : 4312,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 815,
			"y" : 219
		},
		"width" : 146,
		"height" : 52,
		"style" : "subflow",
		"value" : "集油箱异常"
	}, {
		"outs" : [ {
			"id" : 54,
			"to" : 4321,
			"from" : 332
		}, {
			"id" : 55,
			"to" : 4322,
			"from" : 332
		} ],
		"id" : 332,
		"position" : {
			"x" : 836,
			"y" : 369
		},
		"width" : 143,
		"height" : 51,
		"style" : "subflow",
		"value" : "压力油罐异常"
	}, {
		"outs" : [ {
			"id" : 56,
			"to" : 4331,
			"from" : 333
		}, {
			"id" : 57,
			"to" : 4332,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 814,
			"y" : 529
		},
		"width" : 158,
		"height" : 58,
		"style" : "subflow",
		"value" : "气系统压力罐异常"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 1021,
			"y" : 185
		},
		"width" : 149,
		"height" : 56,
		"style" : "process",
		"value" : "集油箱油位偏高"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 1021,
			"y" : 251
		},
		"width" : 151,
		"height" : 58,
		"style" : "process",
		"value" : "集油箱油位偏低"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 1021,
			"y" : 336
		},
		"width" : 154,
		"height" : 56,
		"style" : "process",
		"value" : "压力油罐油位偏高"
	}, {
		"outs" : [],
		"id" : 4322,
		"position" : {
			"x" : 1021,
			"y" : 403
		},
		"width" : 156,
		"height" : 54,
		"style" : "process",
		"value" : "压力油罐油位偏低"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 1032,
			"y" : 486
		},
		"width" : 143,
		"height" : 61,
		"style" : "process",
		"value" : "补气压罐压力偏高"
	}, {
		"outs" : [],
		"id" : 4332,
		"position" : {
			"x" : 1033,
			"y" : 572
		},
		"width" : 144,
		"height" : 59,
		"style" : "process",
		"value" : "补气压罐压力偏低"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 394,
			"y" : 490
		},
		"width" : 158,
		"height" : 64,
		"style" : "process",
		"value" : "导叶响应缓慢"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 576,
			"y" : 489
		},
		"width" : 164,
		"height" : 67,
		"style" : "process",
		"value" : "转速达不到额定值"
	}, {
		"outs" : [],
		"id" : 4223,
		"position" : {
			"x" : 395,
			"y" : 594
		},
		"width" : 161,
		"height" : 64,
		"style" : "process",
		"value" : "接力器不开启"
	}, {
		"outs" : [],
		"id" : 4224,
		"position" : {
			"x" : 577,
			"y" : 593
		},
		"width" : 164,
		"height" : 66,
		"style" : "process",
		"value" : "机组误开机或蠕动"
	} ]
}
