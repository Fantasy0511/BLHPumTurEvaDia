//cell数组到cell4数组的内容

var cell1 = { // 调速器本体故障
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 20,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 21,
			"to" : 4,
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
			"to" : 6,
			"from" : 2
		}, {
			"id" : 30,
			"to" : 7,
			"from" : 2
		}, {
			"id" : 31,
			"to" : 8,
			"from" : 2
		} ],
		"id" : 2,
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
		"id" : 3,
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
		"id" : 4,
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
			"to" : 9,
			"from" : 6
		}, {
			"id" : 33,
			"to" : 32,
			"from" : 6
		} ],
		"id" : 6,
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
		"id" : 7,
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
		"id" : 8,
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
		"id" : 9,
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
		"id" : 32,
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

var cell2 = { // 调速器本体故障
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 20,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 21,
			"to" : 4,
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
		"id" : 2,
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
			"to" : 7,
			"from" : 3
		}, {
			"id" : 35,
			"to" : 6,
			"from" : 3
		}, {
			"id" : 36,
			"to" : 8,
			"from" : 3
		}, {
			"id" : 37,
			"to" : 33,
			"from" : 3
		} ],
		"id" : 3,
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
		"id" : 4,
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
		"id" : 6,
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
			"to" : 9,
			"from" : 7
		}, {
			"id" : 41,
			"to" : 32,
			"from" : 7
		}, {
			"id" : 42,
			"to" : 38,
			"from" : 7
		}, {
			"id" : 43,
			"to" : 39,
			"from" : 7
		} ],
		"id" : 7,
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
		"id" : 8,
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
		"id" : 9,
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
		"id" : 32,
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
		"id" : 33,
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
		"id" : 38,
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
		"id" : 39,
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

var cell3 = {     //油压装置异常
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 20,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 21,
			"to" : 4,
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
		"id" : 2,
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
		"id" : 3,
		"position" : {
			"x" : 344,
			"y" : 123
		},
		"width" : 139,
		"height" : 47,
		"style" : "subflow",
		"value" : "调速器性能异常"
	}, {
		"outs" : [ {
			"id" : 40,
			"to" : 7,
			"from" : 4
		}, {
			"id" : 41,
			"to" : 8,
			"from" : 4
		}, {
			"id" : 42,
			"to" : 33,
			"from" : 4
		} ],
		"id" : 4,
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
			"id" : 45,
			"to" : 32,
			"from" : 7
		}, {
			"id" : 46,
			"to" : 9,
			"from" : 7
		} ],
		"id" : 7,
		"position" : {
			"x" : 174,
			"y" : 261
		},
		"width" : 178,
		"height" : 50,
		"style" : "subflow",
		"value" : "集油箱异常"
	}, {
		"outs" : [ {
			"id" : 47,
			"to" : 38,
			"from" : 8
		}, {
			"id" : 48,
			"to" : 39,
			"from" : 8
		} ],
		"id" : 8,
		"position" : {
			"x" : 450,
			"y" : 261
		},
		"width" : 176,
		"height" : 51,
		"style" : "subflow",
		"value" : "压力油罐异常"
	}, {
		"outs" : [],
		"id" : 9,
		"position" : {
			"x" : 223,
			"y" : 421
		},
		"width" : 138,
		"height" : 60,
		"style" : "process",
		"value" : "油位偏低"
	}, {
		"outs" : [],
		"id" : 32,
		"position" : {
			"x" : 80,
			"y" : 421
		},
		"width" : 138,
		"height" : 58,
		"style" : "process",
		"value" : "油位偏高"
	}, {
		"outs" : [ {
			"id" : 49,
			"to" : 43,
			"from" : 33
		}, {
			"id" : 50,
			"to" : 44,
			"from" : 33
		} ],
		"id" : 33,
		"position" : {
			"x" : 729,
			"y" : 261
		},
		"width" : 169,
		"height" : 48,
		"style" : "subflow",
		"value" : "补气系统压罐异常"
	}, {
		"outs" : [],
		"id" : 38,
		"position" : {
			"x" : 386,
			"y" : 418
		},
		"width" : 134,
		"height" : 62,
		"style" : "process",
		"value" : "油位偏高"
	}, {
		"outs" : [],
		"id" : 39,
		"position" : {
			"x" : 536,
			"y" : 418
		},
		"width" : 127,
		"height" : 60,
		"style" : "process",
		"value" : "油位偏低"
	}, {
		"outs" : [],
		"id" : 43,
		"position" : {
			"x" : 670,
			"y" : 418
		},
		"width" : 118,
		"height" : 64,
		"style" : "process",
		"value" : "压力偏高"
	}, {
		"outs" : [],
		"id" : 44,
		"position" : {
			"x" : 801,
			"y" : 418
		},
		"width" : 121,
		"height" : 67,
		"style" : "process",
		"value" : "压力偏低"
	} ]
}

var cell4 = {     //调速器总图
	"cells" : [ {
		"outs" : [ {
			"id" : 5,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 20,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 21,
			"to" : 4,
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
			"id" : 22,
			"to" : 7,
			"from" : 2
		}, {
			"id" : 23,
			"to" : 6,
			"from" : 2
		}, {
			"id" : 24,
			"to" : 8,
			"from" : 2
		} ],
		"id" : 2,
		"position" : {
			"x" : 136,
			"y" : 121
		},
		"width" : 121,
		"height" : 38,
		"style" : "subflow",
		"value" : "调速器本体故障"
	}, {
		"outs" : [ {
			"id" : 40,
			"to" : 37,
			"from" : 3
		}, {
			"id" : 41,
			"to" : 36,
			"from" : 3
		}, {
			"id" : 42,
			"to" : 38,
			"from" : 3
		}, {
			"id" : 43,
			"to" : 39,
			"from" : 3
		} ],
		"id" : 3,
		"position" : {
			"x" : 355,
			"y" : 121
		},
		"width" : 117,
		"height" : 39,
		"style" : "subflow",
		"value" : "调速器性能异常"
	}, {
		"outs" : [ {
			"id" : 25,
			"to" : 12,
			"from" : 4
		}, {
			"id" : 26,
			"to" : 11,
			"from" : 4
		}, {
			"id" : 27,
			"to" : 13,
			"from" : 4
		} ],
		"id" : 4,
		"position" : {
			"x" : 582,
			"y" : 121
		},
		"width" : 130,
		"height" : 41,
		"style" : "subflow",
		"value" : "油压装置运行异常"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 9,
			"from" : 6
		}, {
			"id" : 29,
			"to" : 10,
			"from" : 6
		} ],
		"id" : 6,
		"position" : {
			"x" : 3,
			"y" : 201
		},
		"width" : 128,
		"height" : 46,
		"style" : "subflow",
		"value" : "导叶开度反馈故障"
	}, {
		"outs" : [],
		"id" : 7,
		"position" : {
			"x" : 132,
			"y" : 200
		},
		"width" : 129,
		"height" : 46,
		"style" : "subflow",
		"value" : "配压阀跳动或抖动"
	}, {
		"outs" : [],
		"id" : 8,
		"position" : {
			"x" : 263,
			"y" : 201
		},
		"width" : 99,
		"height" : 44,
		"style" : "subflow",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 9,
		"position" : {
			"x" : 73,
			"y" : 299
		},
		"width" : 127,
		"height" : 62,
		"style" : "process",
		"value" : "开度反馈信号为零"
	}, {
		"outs" : [],
		"id" : 10,
		"position" : {
			"x" : 66,
			"y" : 394
		},
		"width" : 130,
		"height" : 59,
		"style" : "process",
		"value" : "开度反馈为最大值"
	}, {
		"outs" : [ {
			"id" : 30,
			"to" : 14,
			"from" : 11
		}, {
			"id" : 31,
			"to" : 15,
			"from" : 11
		} ],
		"id" : 11,
		"position" : {
			"x" : 465,
			"y" : 202
		},
		"width" : 112,
		"height" : 43,
		"style" : "subflow",
		"value" : "集邮箱异常"
	}, {
		"outs" : [ {
			"id" : 32,
			"to" : 16,
			"from" : 12
		}, {
			"id" : 33,
			"to" : 17,
			"from" : 12
		} ],
		"id" : 12,
		"position" : {
			"x" : 588,
			"y" : 201
		},
		"width" : 118,
		"height" : 45,
		"style" : "subflow",
		"value" : "压力油罐异常"
	}, {
		"outs" : [ {
			"id" : 34,
			"to" : 18,
			"from" : 13
		}, {
			"id" : 35,
			"to" : 19,
			"from" : 13
		} ],
		"id" : 13,
		"position" : {
			"x" : 720,
			"y" : 202
		},
		"width" : 140,
		"height" : 48,
		"style" : "subflow",
		"value" : "气系统压力罐异常"
	}, {
		"outs" : [],
		"id" : 14,
		"position" : {
			"x" : 537,
			"y" : 286
		},
		"width" : 97,
		"height" : 45,
		"style" : "process",
		"value" : "油位偏高"
	}, {
		"outs" : [],
		"id" : 15,
		"position" : {
			"x" : 541,
			"y" : 374
		},
		"width" : 97,
		"height" : 46,
		"style" : "process",
		"value" : "油位偏低"
	}, {
		"outs" : [],
		"id" : 16,
		"position" : {
			"x" : 662,
			"y" : 287
		},
		"width" : 100,
		"height" : 45,
		"style" : "process",
		"value" : "油位偏高"
	}, {
		"outs" : [],
		"id" : 17,
		"position" : {
			"x" : 665,
			"y" : 376
		},
		"width" : 99,
		"height" : 50,
		"style" : "process",
		"value" : "油位偏低"
	}, {
		"outs" : [],
		"id" : 18,
		"position" : {
			"x" : 795,
			"y" : 285
		},
		"width" : 101,
		"height" : 44,
		"style" : "process",
		"value" : "压力偏高"
	}, {
		"outs" : [],
		"id" : 19,
		"position" : {
			"x" : 801,
			"y" : 373
		},
		"width" : 101,
		"height" : 48,
		"style" : "process",
		"value" : "压力偏低"
	}, {
		"outs" : [],
		"id" : 36,
		"position" : {
			"x" : 159,
			"y" : 470
		},
		"width" : 132,
		"height" : 52,
		"style" : "subflow",
		"value" : "停机超时"
	}, {
		"outs" : [ {
			"id" : 48,
			"to" : 45,
			"from" : 37
		}, {
			"id" : 49,
			"to" : 44,
			"from" : 37
		}, {
			"id" : 50,
			"to" : 46,
			"from" : 37
		}, {
			"id" : 51,
			"to" : 47,
			"from" : 37
		} ],
		"id" : 37,
		"position" : {
			"x" : 345,
			"y" : 471
		},
		"width" : 137,
		"height" : 50,
		"style" : "subflow",
		"value" : "开机异常"
	}, {
		"outs" : [],
		"id" : 38,
		"position" : {
			"x" : 511,
			"y" : 470
		},
		"width" : 130,
		"height" : 50,
		"style" : "subflow",
		"value" : "增减负荷异常"
	}, {
		"outs" : [],
		"id" : 39,
		"position" : {
			"x" : 694,
			"y" : 470
		},
		"width" : 126,
		"height" : 55,
		"style" : "subflow",
		"value" : "并网运行溜负荷"
	}, {
		"outs" : [],
		"id" : 44,
		"position" : {
			"x" : 201,
			"y" : 589
		},
		"width" : 120,
		"height" : 68,
		"style" : "process",
		"value" : "导叶响应缓慢"
	}, {
		"outs" : [],
		"id" : 45,
		"position" : {
			"x" : 335,
			"y" : 587
		},
		"width" : 157,
		"height" : 66,
		"style" : "process",
		"value" : "转速达不到额定值"
	}, {
		"outs" : [],
		"id" : 46,
		"position" : {
			"x" : 524,
			"y" : 589
		},
		"width" : 143,
		"height" : 64,
		"style" : "process",
		"value" : "接力器不开启"
	}, {
		"outs" : [],
		"id" : 47,
		"position" : {
			"x" : 681,
			"y" : 589
		},
		"width" : 146,
		"height" : 63,
		"style" : "process",
		"value" : "机组误开机或蠕动"
	} ]
};
