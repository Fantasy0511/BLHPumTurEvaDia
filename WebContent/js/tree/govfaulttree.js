//cell数组到cell4数组的内容

var cell1 = // 调速器故障总图
{
	"cells" : [ {
		"outs" : [ {
			"id" : 22,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 23,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 24,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 448,
			"y" : 5
		},
		"width" : 100,
		"height" : 34,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [ {
			"id" : 25,
			"to" : 5,
			"from" : 21
		}, {
			"id" : 109,
			"to" : 107,
			"from" :21
		}, {
			"id" : 110,
			"to" : 313,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 8,
			"y" : 79
		},
		"width" : 100,
		"height" : 36,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 17,
			"to" : 13,
			"from" : 3
		}, {
			"id" : 18,
			"to" : 14,
			"from" : 3
		}, {
			"id" : 19,
			"to" : 15,
			"from" : 3
		}, {
			"id" : 114,
			"to" : 111,
			"from" : 3
		}, {
			"id" : 115,
			"to" : 112,
			"from" : 3
		}, {
			"id" : 116,
			"to" : 113,
			"from" : 3
		} ],
		"id" : 3,
		"position" : {
			"x" : 382,
			"y" : 79
		},
		"width" : 128,
		"height" : 39,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [ {
			"id" : 35,
			"to" : 331,
			"from" :23
		}, {
			"id" : 36,
			"to" : 332,
			"from" :23
		}, {
			"id" : 37,
			"to" : 333,
			"from" : 23
		} ],
		"id" :23,
		"position" : {
			"x" : 820,
			"y" : 79
		},
		"width" : 109,
		"height" : 38,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 8,
			"from" : 5
		}, {
			"id" : 29,
			"to" : 9,
			"from" : 5
		} ],
		"id" : 5,
		"position" : {
			"x" : 0,
			"y" : 153
		},
		"width" : 100,
		"height" : 38,
		"style" : "subflow",
		"value" : "开度反馈故障"
	}, {
		"outs" : [],
		"id" : 8,
		"position" : {
			"x" : 58,
			"y" : 233
		},
		"width" : 98,
		"height" : 47,
		"style" : "process",
		"value" : "反馈信号为零"
	}, {
		"outs" : [],
		"id" : 9,
		"position" : {
			"x" : 57,
			"y" : 315
		},
		"width" : 100,
		"height" : 46,
		"style" : "process",
		"value" : "反馈为最大值"
	}, {
		"outs" : [ {
			"id" : 41,
			"to" : 38,
			"from" : 13
		}, {
			"id" : 43,
			"to" : 39,
			"from" : 13
		}, {
			"id" : 119,
			"to" : 117,
			"from" : 13
		}, {
			"id" : 120,
			"to" : 118,
			"from" : 13
		} ],
		"id" : 13,
		"position" : {
			"x" : 231,
			"y" : 232
		},
		"width" : 100,
		"height" : 40,
		"style" : "subflow",
		"value" : "开机异常"
	}, {
		"outs" : [ {
			"id" : 58,
			"to" : 56,
			"from" : 14
		}, {
			"id" : 59,
			"to" : 57,
			"from" : 14
		} ],
		"id" : 14,
		"position" : {
			"x" : 387,
			"y" : 232
		},
		"width" : 100,
		"height" : 41,
		"style" : "subflow",
		"value" : "空载稳定性差"
	}, {
		"outs" : [ {
			"id" : 62,
			"to" : 60,
			"from" : 15
		}, {
			"id" : 63,
			"to" : 61,
			"from" : 15
		} ],
		"id" : 15,
		"position" : {
			"x" : 504,
			"y" : 232
		},
		"width" : 100,
		"height" : 40,
		"style" : "subflow",
		"value" : "并网溜负荷"
	}, {
		"outs" : [ {
			"id" : 68,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 69,
			"to" :4312,
			"from" : 331
		}, {
			"id" : 70,
			"to" : 4313,
			"from" : 331
		}, {
			"id" : 71,
			"to" : 4314,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 681,
			"y" : 161
		},
		"width" : 100,
		"height" : 41,
		"style" : "subflow",
		"value" : "状态越限异常"
	}, {
		"outs" : [ {
			"id" : 76,
			"to" : 4323,
			"from" : 332
		}, {
			"id" : 77,
			"to" : 4322,
			"from" : 332
		}, {
			"id" : 79,
			"to" : 4321,
			"from" : 332
		} ],
		"id" : 332,
		"position" : {
			"x" : 804,
			"y" : 161
		},
		"width" : 109,
		"height" : 40,
		"style" : "subflow",
		"value" : "性能下降或异常"
	}, {
		"outs" : [ {
			"id" : 105,
			"to" : 4331,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 914,
			"y" : 161
		},
		"width" : 100,
		"height" : 43,
		"style" : "subflow",
		"value" : "设备故障"
	}, {
		"outs" : [ {
			"id" : 50,
			"to" : 44,
			"from" : 38
		}, {
			"id" : 51,
			"to" : 45,
			"from" : 38
		}, {
			"id" : 52,
			"to" : 48,
			"from" : 38
		}, {
			"id" : 53,
			"to" : 49,
			"from" : 38
		} ],
		"id" : 38,
		"position" : {
			"x" : 165,
			"y" : 392
		},
		"width" : 100,
		"height" : 44,
		"style" : "subflow",
		"value" : "导叶响应缓慢"
	}, {
		"outs" : [ {
			"id" : 54,
			"to" : 46,
			"from" : 39
		}, {
			"id" : 55,
			"to" : 47,
			"from" : 39
		} ],
		"id" : 39,
		"position" : {
			"x" : 302,
			"y" : 392
		},
		"width" : 100,
		"height" : 44,
		"style" : "subflow",
		"value" : "误开机或蠕动"
	}, {
		"outs" : [],
		"id" : 44,
		"position" : {
			"x" : 58,
			"y" : 460
		},
		"width" : 125,
		"height" : 51,
		"style" : "process",
		"value" : "液压装置响应缓慢"
	}, {
		"outs" : [],
		"id" : 45,
		"position" : {
			"x" : 82,
			"y" : 547
		},
		"width" : 100,
		"height" : 51,
		"style" : "process",
		"value" : "系统油压过低"
	}, {
		"outs" : [],
		"id" : 46,
		"position" : {
			"x" : 233,
			"y" : 465
		},
		"width" : 100,
		"height" : 53,
		"style" : "process",
		"value" : "导叶关闭不严"
	}, {
		"outs" : [],
		"id" : 47,
		"position" : {
			"x" : 234,
			"y" : 555
		},
		"width" : 100,
		"height" : 51,
		"style" : "process",
		"value" : "锁定未投入"
	}, {
		"outs" : [],
		"id" : 48,
		"position" : {
			"x" : 7,
			"y" : 643
		},
		"width" : 172,
		"height" : 51,
		"style" : "process",
		"value" : "位移转换装置响应缓慢"
	}, {
		"outs" : [],
		"id" : 49,
		"position" : {
			"x" : 183,
			"y" : 643
		},
		"width" : 100,
		"height" : 51,
		"style" : "process",
		"value" : "主接响应缓慢"
	}, {
		"outs" : [],
		"id" : 56,
		"position" : {
			"x" : 439,
			"y" : 306
		},
		"width" : 105,
		"height" : 52,
		"style" : "process",
		"value" : "接力器周期摆动"
	}, {
		"outs" : [],
		"id" : 57,
		"position" : {
			"x" : 410,
			"y" : 390
		},
		"width" : 127,
		"height" : 52,
		"style" : "process",
		"value" : "接力器非周期摆动"
	}, {
		"outs" : [],
		"id" : 60,
		"position" : {
			"x" : 551,
			"y" : 307
		},
		"width" : 100,
		"height" : 50,
		"style" : "process",
		"value" : "增减负荷缓慢"
	}, {
		"outs" : [],
		"id" : 61,
		"position" : {
			"x" : 552,
			"y" : 389
		},
		"width" : 100,
		"height" : 55,
		"style" : "process",
		"value" : "增减负荷失灵"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 617,
			"y" : 230
		},
		"width" : 100,
		"height" : 48,
		"style" : "process",
		"value" : "集油箱油位高"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 732,
			"y" : 230
		},
		"width" : 100,
		"height" : 49,
		"style" : "process",
		"value" : "集油箱油位低"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 650,
			"y" : 311
		},
		"width" : 100,
		"height" : 49,
		"style" : "process",
		"value" : "压油罐油位高"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 748,
			"y" : 311
		},
		"width" : 100,
		"height" : 50,
		"style" : "process",
		"value" : "压油罐油位低"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 903,
			"y" : 231
		},
		"width" : 122,
		"height" : 53,
		"style" : "process",
		"value" : "油泵不能正常开启"
	}, {
		"outs" : [ {
			"id" : 82,
			"to" : 81,
			"from" : 4323
		}, {
			"id" : 84,
			"to" : 83,
			"from" :4323
		} ],
		"id" : 4323,
		"position" : {
			"x" : 679,
			"y" : 395
		},
		"width" : 100,
		"height" : 48,
		"style" : "subflow",
		"value" : "油泵效率低"
	}, {
		"outs" : [ {
			"id" : 106,
			"to" : 80,
			"from" : 4322
		} ],
		"id" : 4322,
		"position" : {
			"x" : 866,
			"y" : 395
		},
		"width" : 100,
		"height" : 46,
		"style" : "subflow",
		"value" : "油系统漏油"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 907,
			"y" : 315
		},
		"width" : 100,
		"height" : 54,
		"style" : "process",
		"value" : "压油罐漏气"
	}, {
		"outs" : [],
		"id" : 80,
		"position" : {
			"x" : 866,
			"y" : 473
		},
		"width" : 100,
		"height" : 55,
		"style" : "process",
		"value" : "耗油速度偏大"
	}, {
		"outs" : [],
		"id" : 81,
		"position" : {
			"x" : 752,
			"y" : 479
		},
		"width" : 100,
		"height" : 50,
		"style" : "process",
		"value" : "打油量偏低"
	}, {
		"outs" : [ {
			"id" : 89,
			"to" : 85,
			"from" : 83
		}, {
			"id" : 92,
			"to" : 88,
			"from" : 83
		}, {
			"id" : 123,
			"to" : 121,
			"from" : 83
		}, {
			"id" : 124,
			"to" : 122,
			"from" : 83
		} ],
		"id" : 83,
		"position" : {
			"x" : 441,
			"y" : 479
		},
		"width" : 159,
		"height" : 50,
		"style" : "subflow",
		"value" : "油泵单位时间启动频繁"
	}, {
		"outs" : [ {
			"id" : 99,
			"to" : 93,
			"from" : 85
		}, {
			"id" : 100,
			"to" : 94,
			"from" : 85
		} ],
		"id" : 85,
		"position" : {
			"x" : 346,
			"y" : 560
		},
		"width" : 100,
		"height" : 49,
		"style" : "subflow",
		"value" : "油泵控制故障"
	}, {
		"outs" : [ {
			"id" : 101,
			"to" : 95,
			"from" : 88
		}, {
			"id" : 102,
			"to" : 96,
			"from" : 88
		}, {
			"id" : 103,
			"to" : 97,
			"from" : 88
		}, {
			"id" : 104,
			"to" : 98,
			"from" : 88
		} ],
		"id" : 88,
		"position" : {
			"x" : 736,
			"y" : 560
		},
		"width" : 100,
		"height" : 46,
		"style" : "subflow",
		"value" : "接力器抽动"
	}, {
		"outs" : [],
		"id" : 93,
		"position" : {
			"x" : 288,
			"y" : 641
		},
		"width" : 100,
		"height" : 55,
		"style" : "process",
		"value" : "软启动器故障"
	}, {
		"outs" : [],
		"id" : 94,
		"position" : {
			"x" : 393,
			"y" : 643
		},
		"width" : 100,
		"height" : 55,
		"style" : "process",
		"value" : "其他硬件故障"
	}, {
		"outs" : [],
		"id" : 95,
		"position" : {
			"x" : 547,
			"y" : 644
		},
		"width" : 100,
		"height" : 57,
		"style" : "process",
		"value" : "接力器故障"
	}, {
		"outs" : [],
		"id" : 96,
		"position" : {
			"x" : 657,
			"y" : 643
		},
		"width" : 100,
		"height" : 52,
		"style" : "process",
		"value" : "主配故障"
	}, {
		"outs" : [],
		"id" : 97,
		"position" : {
			"x" : 758,
			"y" : 644
		},
		"width" : 100,
		"height" : 53,
		"style" : "process",
		"value" : "伺服电机故障"
	}, {
		"outs" : [],
		"id" : 98,
		"position" : {
			"x" : 870,
			"y" : 643
		},
		"width" : 100,
		"height" : 55,
		"style" : "process",
		"value" : "电调故障"
	}, {
		"outs" : [],
		"id" : 107,
		"position" : {
			"x" : 104,
			"y" : 153
		},
		"width" : 122,
		"height" : 47,
		"style" : "process",
		"value" : "配压阀跳动或抖动"
	}, {
		"outs" : [],
		"id" : 313,
		"position" : {
			"x" : 225,
			"y" : 153
		},
		"width" : 100,
		"height" : 46,
		"style" : "process",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 111,
		"position" : {
			"x" : 324,
			"y" : 151
		},
		"width" : 100,
		"height" : 48,
		"style" : "process",
		"value" : "停机超时"
	}, {
		"outs" : [],
		"id" : 112,
		"position" : {
			"x" : 455,
			"y" : 151
		},
		"width" : 100,
		"height" : 49,
		"style" : "process",
		"value" : "增减负荷异常"
	}, {
		"outs" : [],
		"id" : 113,
		"position" : {
			"x" : 555,
			"y" : 151
		},
		"width" : 126,
		"height" : 50,
		"style" : "process",
		"value" : "接力器和出力摆动"
	}, {
		"outs" : [],
		"id" : 117,
		"position" : {
			"x" : 158,
			"y" : 309
		},
		"width" : 123,
		"height" : 52,
		"style" : "process",
		"value" : "转速达不到额定值"
	}, {
		"outs" : [],
		"id" : 118,
		"position" : {
			"x" : 296,
			"y" : 309
		},
		"width" : 100,
		"height" : 49,
		"style" : "process",
		"value" : "接力器不开启"
	}, {
		"outs" : [],
		"id" : 121,
		"position" : {
			"x" : 471,
			"y" : 560
		},
		"width" : 100,
		"height" : 48,
		"style" : "process",
		"value" : "管路渗漏"
	}, {
		"outs" : [],
		"id" : 122,
		"position" : {
			"x" : 598,
			"y" : 561
		},
		"width" : 100,
		"height" : 51,
		"style" : "process",
		"value" : "事故配压阀渗漏"
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
			"to" : 3,
			"from" : 1
		}, {
			"id" : 12,
			"to" : 4,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 314,
			"y" : 5
		},
		"width" : 100,
		"height" : 38,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [ {
			"id" : 13,
			"to" : 5,
			"from" : 21
		}, {
			"id" : 20,
			"to" : 18,
			"from" : 21
		}, {
			"id" : 100,
			"to" : 313,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 4,
			"y" : 81
		},
		"width" : 100,
		"height" : 37,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [],
		"id" : 3,
		"position" : {
			"x" : 299,
			"y" : 80
		},
		"width" : 130,
		"height" : 36,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [],
		"id" : 4,
		"position" : {
			"x" : 607,
			"y" : 81
		},
		"width" : 110,
		"height" : 36,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [ {
			"id" : 16,
			"to" : 8,
			"from" : 5
		}, {
			"id" : 17,
			"to" : 9,
			"from" : 5
		} ],
		"id" : 5,
		"position" : {
			"x" : 4,
			"y" : 162
		},
		"width" : 100,
		"height" : 39,
		"style" : "subflow",
		"value" : "开度反馈故障"
	}, {
		"outs" : [],
		"id" : 8,
		"position" : {
			"x" : 74,
			"y" : 238
		},
		"width" : 100,
		"height" : 46,
		"style" : "process",
		"value" : "反馈信号为零"
	}, {
		"outs" : [],
		"id" : 9,
		"position" : {
			"x" : 74,
			"y" : 317
		},
		"width" : 100,
		"height" : 44,
		"style" : "process",
		"value" : "反馈为最大值"
	}, {
		"outs" : [],
		"id" : 18,
		"position" : {
			"x" : 123,
			"y" : 157
		},
		"width" : 131,
		"height" : 47,
		"style" : "process",
		"value" : "配压阀跳动或抖动"
	}, {
		"outs" : [],
		"id" : 313,
		"position" : {
			"x" : 273,
			"y" : 158
		},
		"width" : 100,
		"height" : 49,
		"style" : "process",
		"value" : "剪断销故障"
	} ]
}
// 油压装置异常

var cell3 = // 调速油性能异常
{
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 6,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 4,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 340,
			"y" : 4
		},
		"width" : 100,
		"height" : 37,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [],
		"id" : 2,
		"position" : {
			"x" : 24,
			"y" : 80
		},
		"width" : 100,
		"height" : 40,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 14,
			"to" : 8,
			"from" : 3
		}, {
			"id" : 18,
			"to" : 12,
			"from" : 3
		}, {
			"id" : 19,
			"to" : 13,
			"from" : 3
		}, {
			"id" : 55,
			"to" : 54,
			"from" : 3
		}, {
			"id" : 57,
			"to" : 56,
			"from" : 3
		}, {
			"id" : 59,
			"to" : 58,
			"from" : 3
		} ],
		"id" : 3,
		"position" : {
			"x" : 327,
			"y" : 79
		},
		"width" : 126,
		"height" : 40,
		"style" : "subflow",
		"value" : "调速系统性能异常"
	}, {
		"outs" : [],
		"id" : 4,
		"position" : {
			"x" : 623,
			"y" : 80
		},
		"width" : 111,
		"height" : 41,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [ {
			"id" : 33,
			"to" : 21,
			"from" : 8
		}, {
			"id" : 35,
			"to" : 23,
			"from" : 8
		}, {
			"id" : 51,
			"to" : 50,
			"from" : 8
		}, {
			"id" : 53,
			"to" : 52,
			"from" : 8
		} ],
		"id" : 8,
		"position" : {
			"x" : 36,
			"y" : 160
		},
		"width" : 100,
		"height" : 41,
		"style" : "subflow",
		"value" : "开机异常"
	}, {
		"outs" : [ {
			"id" : 44,
			"to" : 24,
			"from" : 12
		}, {
			"id" : 45,
			"to" : 25,
			"from" : 12
		} ],
		"id" : 12,
		"position" : {
			"x" : 525,
			"y" : 160
		},
		"width" : 100,
		"height" : 41,
		"style" : "subflow",
		"value" : "空载稳定性差"
	}, {
		"outs" : [ {
			"id" : 46,
			"to" : 26,
			"from" : 13
		}, {
			"id" : 47,
			"to" : 27,
			"from" : 13
		} ],
		"id" : 13,
		"position" : {
			"x" : 644,
			"y" : 160
		},
		"width" : 100,
		"height" : 39,
		"style" : "subflow",
		"value" : "并网运行溜负荷"
	}, {
		"outs" : [ {
			"id" : 38,
			"to" : 28,
			"from" : 21
		}, {
			"id" : 39,
			"to" : 29,
			"from" : 21
		}, {
			"id" : 40,
			"to" : 30,
			"from" : 21
		}, {
			"id" : 41,
			"to" : 31,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 124,
			"y" : 240
		},
		"width" : 100,
		"height" : 42,
		"style" : "subflow",
		"value" : "导叶响应缓慢"
	}, {
		"outs" : [ {
			"id" : 42,
			"to" : 36,
			"from" : 23
		}, {
			"id" : 43,
			"to" : 37,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 342,
			"y" : 240
		},
		"width" : 100,
		"height" : 45,
		"style" : "subflow",
		"value" : "误开机或蠕动"
	}, {
		"outs" : [],
		"id" : 24,
		"position" : {
			"x" : 575,
			"y" : 235
		},
		"width" : 108,
		"height" : 47,
		"style" : "process",
		"value" : "接力器周期摆动"
	}, {
		"outs" : [],
		"id" : 25,
		"position" : {
			"x" : 551,
			"y" : 316
		},
		"width" : 124,
		"height" : 46,
		"style" : "process",
		"value" : "接力器非周期摆动"
	}, {
		"outs" : [],
		"id" : 26,
		"position" : {
			"x" : 696,
			"y" : 234
		},
		"width" : 100,
		"height" : 50,
		"style" : "process",
		"value" : "增减负荷缓慢"
	}, {
		"outs" : [],
		"id" : 27,
		"position" : {
			"x" : 699,
			"y" : 320
		},
		"width" : 100,
		"height" : 47,
		"style" : "process",
		"value" : "增减负荷失灵"
	}, {
		"outs" : [],
		"id" : 28,
		"position" : {
			"x" : 30,
			"y" : 319
		},
		"width" : 132,
		"height" : 48,
		"style" : "process",
		"value" : "放大装置响应缓慢"
	}, {
		"outs" : [],
		"id" : 29,
		"position" : {
			"x" : 186,
			"y" : 319
		},
		"width" : 100,
		"height" : 48,
		"style" : "process",
		"value" : "系统油压过低"
	}, {
		"outs" : [],
		"id" : 30,
		"position" : {
			"x" : 5,
			"y" : 402
		},
		"width" : 158,
		"height" : 47,
		"style" : "process",
		"value" : "位移转换装置响应缓慢"
	}, {
		"outs" : [],
		"id" : 31,
		"position" : {
			"x" : 181,
			"y" : 402
		},
		"width" : 100,
		"height" : 48,
		"style" : "process",
		"value" : "主接响应缓慢"
	}, {
		"outs" : [],
		"id" : 36,
		"position" : {
			"x" : 404,
			"y" : 318
		},
		"width" : 100,
		"height" : 45,
		"style" : "process",
		"value" : "导叶关闭不严"
	}, {
		"outs" : [],
		"id" : 37,
		"position" : {
			"x" : 408,
			"y" : 400
		},
		"width" : 100,
		"height" : 46,
		"style" : "process",
		"value" : "锁定未投入"
	}, {
		"outs" : [],
		"id" : 50,
		"position" : {
			"x" : 236,
			"y" : 240
		},
		"width" : 100,
		"height" : 49,
		"style" : "process",
		"value" : "接力器不开启"
	}, {
		"outs" : [],
		"id" : 52,
		"position" : {
			"x" : -1,
			"y" : 240
		},
		"width" : 120,
		"height" : 49,
		"style" : "process",
		"value" : "转速达不到额定值"
	}, {
		"outs" : [],
		"id" : 54,
		"position" : {
			"x" : 156,
			"y" : 160
		},
		"width" : 100,
		"height" : 46,
		"style" : "process",
		"value" : "停机超时"
	}, {
		"outs" : [],
		"id" : 56,
		"position" : {
			"x" : 267,
			"y" : 160
		},
		"width" : 100,
		"height" : 47,
		"style" : "process",
		"value" : "增减负荷异常"
	}, {
		"outs" : [],
		"id" : 58,
		"position" : {
			"x" : 389,
			"y" : 160
		},
		"width" : 124,
		"height" : 49,
		"style" : "process",
		"value" : "接力器和出力摆动"
	} ]
}

// 调速油系統故障
var cell4 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 6,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 329,
			"y" : 7
		},
		"width" : 100,
		"height" : 39,
		"style" : "subflow",
		"value" : "调速系统故障"
	}, {
		"outs" : [],
		"id" : 2,
		"position" : {
			"x" : 11,
			"y" : 80
		},
		"width" : 100,
		"height" : 40,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [],
		"id" : 3,
		"position" : {
			"x" : 317,
			"y" : 79
		},
		"width" : 122,
		"height" : 40,
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
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 600,
			"y" : 80
		},
		"width" : 118,
		"height" : 42,
		"style" : "subflow",
		"value" : "调速油系统故障"
	}, {
		"outs" : [ {
			"id" : 18,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 19,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 20,
			"to" : 4313,
			"from" : 331
		}, {
			"id" : 21,
			"to" : 4314,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 110,
			"y" : 160
		},
		"width" : 100,
		"height" : 39,
		"style" : "subflow",
		"value" : "状态越限异常"
	}, {
		"outs" : [ {
			"id" : 27,
			"to" : 4322,
			"from" : 332
		}, {
			"id" : 28,
			"to" : 4323,
			"from" : 332
		}, {
			"id" : 29,
			"to" : 4321,
			"from" : 332
		} ],
		"id" :332,
		"position" : {
			"x" : 363,
			"y" : 160
		},
		"width" : 100,
		"height" : 40,
		"style" : "subflow",
		"value" : "性能下降或异常"
	}, {
		"outs" : [ {
			"id" : 56,
			"to" : 25,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 658,
			"y" : 160
		},
		"width" : 100,
		"height" : 40,
		"style" : "subflow",
		"value" : "设备故障"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 29,
			"y" : 239
		},
		"width" : 100,
		"height" : 43,
		"style" : "process",
		"value" : "集油箱油位高"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 171,
			"y" : 239
		},
		"width" : 100,
		"height" : 42,
		"style" : "process",
		"value" : "集油箱油位低"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 28,
			"y" : 323
		},
		"width" : 100,
		"height" : 44,
		"style" : "process",
		"value" : "压油罐油位高"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 166,
			"y" : 323
		},
		"width" : 100,
		"height" : 45,
		"style" : "process",
		"value" : "压油罐油位低"
	}, {
		"outs" : [],
		"id" :4321,
		"position" : {
			"x" : 394,
			"y" : 239
		},
		"width" : 100,
		"height" : 44,
		"style" : "process",
		"value" : "压油罐漏气"
	}, {
		"outs" : [ {
			"id" : 31,
			"to" : 30,
			"from" : 4322
		} ],
		"id" : 4322,
		"position" : {
			"x" : 276,
			"y" : 239
		},
		"width" : 100,
		"height" : 41,
		"style" : "subflow",
		"value" : "油系统漏油"
	}, {
		"outs" : [ {
			"id" : 34,
			"to" : 32,
			"from" : 4323
		}, {
			"id" : 35,
			"to" : 33,
			"from" : 4323
		} ],
		"id" :4323,
		"position" : {
			"x" : 513,
			"y" : 240
		},
		"width" : 100,
		"height" : 43,
		"style" : "subflow",
		"value" : "油泵效率低"
	}, {
		"outs" : [],
		"id" : 25,
		"position" : {
			"x" : 645,
			"y" : 239
		},
		"width" : 126,
		"height" : 46,
		"style" : "process",
		"value" : "油泵不能正常开启"
	}, {
		"outs" : [],
		"id" : 30,
		"position" : {
			"x" : 276,
			"y" : 320
		},
		"width" : 100,
		"height" : 48,
		"style" : "process",
		"value" : "耗油速度偏大"
	}, {
		"outs" : [ {
			"id" : 40,
			"to" : 36,
			"from" : 32
		}, {
			"id" : 41,
			"to" : 38,
			"from" : 32
		}, {
			"id" : 42,
			"to" : 37,
			"from" : 32
		}, {
			"id" : 43,
			"to" : 39,
			"from" : 32
		} ],
		"id" : 32,
		"position" : {
			"x" : 393,
			"y" : 321
		},
		"width" : 153,
		"height" : 40,
		"style" : "subflow",
		"value" : "油泵单位时间启动频繁"
	}, {
		"outs" : [],
		"id" : 33,
		"position" : {
			"x" : 593,
			"y" : 321
		},
		"width" : 100,
		"height" : 47,
		"style" : "process",
		"value" : "打油量偏低"
	}, {
		"outs" : [ {
			"id" : 46,
			"to" : 44,
			"from" : 36
		}, {
			"id" : 47,
			"to" : 45,
			"from" : 36
		} ],
		"id" : 36,
		"position" : {
			"x" : 139,
			"y" : 401
		},
		"width" : 100,
		"height" : 43,
		"style" : "subflow",
		"value" : "油泵控制故障"
	}, {
		"outs" : [ {
			"id" : 52,
			"to" : 48,
			"from" : 37
		}, {
			"id" : 53,
			"to" : 49,
			"from" : 37
		}, {
			"id" : 54,
			"to" : 50,
			"from" : 37
		}, {
			"id" : 55,
			"to" : 51,
			"from" : 37
		} ],
		"id" : 37,
		"position" : {
			"x" : 416,
			"y" : 401
		},
		"width" : 100,
		"height" : 40,
		"style" : "subflow",
		"value" : "接力器抽动"
	}, {
		"outs" : [],
		"id" : 38,
		"position" : {
			"x" : 281,
			"y" : 400
		},
		"width" : 100,
		"height" : 49,
		"style" : "process",
		"value" : "管路渗漏"
	}, {
		"outs" : [],
		"id" : 39,
		"position" : {
			"x" : 550,
			"y" : 400
		},
		"width" : 115,
		"height" : 50,
		"style" : "process",
		"value" : "事故配压阀渗漏"
	}, {
		"outs" : [],
		"id" : 44,
		"position" : {
			"x" : 54,
			"y" : 478
		},
		"width" : 100,
		"height" : 49,
		"style" : "process",
		"value" : "软启动器故障"
	}, {
		"outs" : [],
		"id" : 45,
		"position" : {
			"x" : 182,
			"y" : 478
		},
		"width" : 100,
		"height" : 48,
		"style" : "process",
		"value" : "其他硬件故障"
	}, {
		"outs" : [],
		"id" : 48,
		"position" : {
			"x" : 309,
			"y" : 476
		},
		"width" : 100,
		"height" : 47,
		"style" : "process",
		"value" : "接力器故障"
	}, {
		"outs" : [],
		"id" : 49,
		"position" : {
			"x" : 421,
			"y" : 476
		},
		"width" : 100,
		"height" : 49,
		"style" : "process",
		"value" : "主配故障"
	}, {
		"outs" : [],
		"id" : 50,
		"position" : {
			"x" : 534,
			"y" : 476
		},
		"width" : 100,
		"height" : 47,
		"style" : "process",
		"value" : "伺服电机故障"
	}, {
		"outs" : [],
		"id" : 51,
		"position" : {
			"x" : 645,
			"y" : 476
		},
		"width" : 100,
		"height" : 50,
		"style" : "process",
		"value" : "电调故障"
	} ]
}