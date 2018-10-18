var cell2 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 42,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 43,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 67,
			"to" : 66,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 488,
			"y" : 9
		},
		"width" : 129,
		"height" : 36,
		"style" : "subflow",
		"value" : "球阀系统故障"
	}, {
		"outs" : [ {
			"id" : 71,
			"to" : 68,
			"from" : 2
		}, {
			"id" : 72,
			"to" : 69,
			"from" : 2
		}, {
			"id" : 73,
			"to" : 70,
			"from" : 2
		} ],
		"id" : 2,
		"position" : {
			"x" : 53,
			"y" : 113
		},
		"width" : 120,
		"height" : 39,
		"style" : "subflow",
		"value" : "球阀开启失败"
	}, {
		"outs" : [],
		"id" : 3,
		"position" : {
			"x" : 491,
			"y" : 110
		},
		"width" : 123,
		"height" : 39,
		"style" : "subflow",
		"value" : "油压部分故障"
	}, {
		"outs" : [],
		"id" : 66,
		"position" : {
			"x" : 859,
			"y" : 113
		},
		"width" : 120,
		"height" : 39,
		"style" : "subflow",
		"value" : "工作密封故障"
	}, {
		"outs" : [],
		"id" : 68,
		"position" : {
			"x" : 132,
			"y" : 193
		},
		"width" : 135,
		"height" : 45,
		"style" : "process",
		"value" : "测压管路堵塞"
	}, {
		"outs" : [],
		"id" : 69,
		"position" : {
			"x" : 129,
			"y" : 279
		},
		"width" : 139,
		"height" : 45,
		"style" : "process",
		"value" : "开启电磁阀故障"
	}, {
		"outs" : [],
		"id" : 70,
		"position" : {
			"x" : 132,
			"y" : 363
		},
		"width" : 138,
		"height" : 47,
		"style" : "process",
		"value" : "液压锁定卡涩"
	} ]
}

var cell3 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 42,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 43,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 67,
			"to" : 66,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 488,
			"y" : 9
		},
		"width" : 129,
		"height" : 36,
		"style" : "subflow",
		"value" : "球阀系统故障"
	}, {
		"outs" : [],
		"id" : 2,
		"position" : {
			"x" : -1,
			"y" : 113
		},
		"width" : 120,
		"height" : 39,
		"style" : "subflow",
		"value" : "球阀开启失败"
	}, {
		"outs" : [ {
			"id" : 45,
			"to" : 11,
			"from" : 22
		}, {
			"id" : 46,
			"to" : 12,
			"from" : 22
		}, {
			"id" : 47,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 48,
			"to" : 14,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 491,
			"y" : 110
		},
		"width" : 123,
		"height" : 39,
		"style" : "subflow",
		"value" : "油压部分故障"
	}, {
		"outs" : [ {
			"id" : 29,
			"to" : 15,
			"from" : 11
		}, {
			"id" : 30,
			"to" : 16,
			"from" : 11
		}, {
			"id" : 31,
			"to" : 17,
			"from" : 11
		}, {
			"id" : 32,
			"to" : 18,
			"from" : 11
		}, {
			"id" : 33,
			"to" : 19,
			"from" : 11
		} ],
		"id" : 11,
		"position" : {
			"x" : 192,
			"y" : 190
		},
		"width" : 111,
		"height" : 40,
		"style" : "subflow",
		"value" : "漏油箱油位异常"
	}, {
		"outs" : [],
		"id" : 12,
		"position" : {
			"x" : 390,
			"y" : 190
		},
		"width" : 134,
		"height" : 41,
		"style" : "subflow",
		"value" : "主油循环回路异常"
	}, {
		"outs" : [ {
			"id" : 52,
			"to" : 4221,
			"from" :322
		}, {
			"id" : 53,
			"to" : 4222,
			"from" : 322
		}, {
			"id" : 54,
			"to" : 4223,
			"from" : 322
		}, {
			"id" : 55,
			"to" : 4224,
			"from" : 322
		} ],
		"id" :322,
		"position" : {
			"x" : 600,
			"y" : 190
		},
		"width" : 107,
		"height" : 39,
		"style" : "subflow",
		"value" : "压力油罐故障"
	}, {
		"outs" : [ {
			"id" : 63,
			"to" : 20,
			"from" : 14
		}, {
			"id" : 64,
			"to" : 21,
			"from" : 14
		}, {
			"id" : 65,
			"to" : 100,
			"from" : 14
		} ],
		"id" : 14,
		"position" : {
			"x" : 773,
			"y" : 191
		},
		"width" : 108,
		"height" : 41,
		"style" : "subflow",
		"value" : "集油箱油位异常"
	}, {
		"outs" : [],
		"id" : 15,
		"position" : {
			"x" : 246,
			"y" : 267
		},
		"width" : 129,
		"height" : 45,
		"style" : "process",
		"value" : "排油阀损坏"
	}, {
		"outs" : [],
		"id" : 16,
		"position" : {
			"x" : 247,
			"y" : 350
		},
		"width" : 130,
		"height" : 42,
		"style" : "process",
		"value" : "过滤器堵塞"
	}, {
		"outs" : [],
		"id" : 17,
		"position" : {
			"x" : 89,
			"y" : 430
		},
		"width" : 134,
		"height" : 47,
		"style" : "process",
		"value" : "油位信号回路故障"
	}, {
		"outs" : [],
		"id" : 18,
		"position" : {
			"x" : 180,
			"y" : 513
		},
		"width" : 135,
		"height" : 47,
		"style" : "process",
		"value" : "逆止阀故障"
	}, {
		"outs" : [],
		"id" : 19,
		"position" : {
			"x" : 246,
			"y" : 430
		},
		"width" : 130,
		"height" : 42,
		"style" : "process",
		"value" : "漏油泵故障"
	}, {
		"outs" : [],
		"id" : 20,
		"position" : {
			"x" : 825,
			"y" : 268
		},
		"width" : 121,
		"height" : 45,
		"style" : "process",
		"value" : "油位信号回路故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 843,
			"y" : 346
		},
		"width" : 120,
		"height" : 48,
		"style" : "process",
		"value" : "循环油泵故障"
	}, {
		"outs" : [],
		"id" : 100,
		"position" : {
			"x" : 878,
			"y" : 429
		},
		"width" : 120,
		"height" : 49,
		"style" : "process",
		"value" : "油系统严重漏油"
	}, {
		"outs" : [ {
			"id" : 58,
			"to" : 37,
			"from" : 4222
		}, {
			"id" : 60,
			"to" : 38,
			"from" : 4222
		} ],
		"id" : 4222,
		"position" : {
			"x" : 498,
			"y" : 270
		},
		"width" : 100,
		"height" : 41,
		"style" : "subflow",
		"value" : "油压偏低"
	}, {
		"outs" : [ {
			"id" : 59,
			"to" : 39,
			"from" : 4223
		}, {
			"id" : 61,
			"to" : 40,
			"from" : 4223
		} ],
		"id" : 4223,
		"position" : {
			"x" : 616,
			"y" : 270
		},
		"width" : 100,
		"height" : 44,
		"style" : "subflow",
		"value" : "油位偏高"
	}, {
		"outs" : [ {
			"id" : 56,
			"to" : 35,
			"from" : 4221
		}, {
			"id" : 57,
			"to" : 36,
			"from" : 4221
		} ],
		"id" : 4221,
		"position" : {
			"x" : 375,
			"y" : 270
		},
		"width" : 116,
		"height" : 41,
		"style" : "subflow",
		"value" : "油压偏高"
	}, {
		"outs" : [ {
			"id" : 62,
			"to" : 41,
			"from" : 4224
		} ],
		"id" : 4224,
		"position" : {
			"x" : 725,
			"y" : 270
		},
		"width" : 101,
		"height" : 44,
		"style" : "subflow",
		"value" : "油位偏低"
	}, {
		"outs" : [],
		"id" : 35,
		"position" : {
			"x" : 432,
			"y" : 350
		},
		"width" : 117,
		"height" : 43,
		"style" : "process",
		"value" : "油泵长时间运行"
	}, {
		"outs" : [],
		"id" : 36,
		"position" : {
			"x" : 373,
			"y" : 431
		},
		"width" : 120,
		"height" : 43,
		"style" : "process",
		"value" : "压力信号回路故障"
	}, {
		"outs" : [],
		"id" : 37,
		"position" : {
			"x" : 547,
			"y" : 352
		},
		"width" : 120,
		"height" : 41,
		"style" : "process",
		"value" : "压力油罐大量漏油"
	}, {
		"outs" : [],
		"id" : 38,
		"position" : {
			"x" : 513,
			"y" : 430
		},
		"width" : 116,
		"height" : 43,
		"style" : "process",
		"value" : "补气回路漏气"
	}, {
		"outs" : [],
		"id" : 39,
		"position" : {
			"x" : 665,
			"y" : 352
		},
		"width" : 112,
		"height" : 40,
		"style" : "process",
		"value" : "补气回路漏气"
	}, {
		"outs" : [],
		"id" : 40,
		"position" : {
			"x" : 637,
			"y" : 432
		},
		"width" : 127,
		"height" : 45,
		"style" : "process",
		"value" : "油位信号回路故障"
	}, {
		"outs" : [],
		"id" : 41,
		"position" : {
			"x" : 760,
			"y" : 433
		},
		"width" : 119,
		"height" : 45,
		"style" : "process",
		"value" : "压力油罐大量漏油"
	}, {
		"outs" : [],
		"id" : 66,
		"position" : {
			"x" : 859,
			"y" : 113
		},
		"width" : 120,
		"height" : 39,
		"style" : "subflow",
		"value" : "工作密封故障"
	} ]
}
var cell4 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 42,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 43,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 67,
			"to" : 66,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 488,
			"y" : 9
		},
		"width" : 129,
		"height" : 36,
		"style" : "subflow",
		"value" : "球阀系统故障"
	}, {
		"outs" : [],
		"id" : 2,
		"position" : {
			"x" : 53,
			"y" : 113
		},
		"width" : 120,
		"height" : 39,
		"style" : "subflow",
		"value" : "球阀开启失败"
	}, {
		"outs" : [],
		"id" : 3,
		"position" : {
			"x" : 491,
			"y" : 110
		},
		"width" : 123,
		"height" : 39,
		"style" : "subflow",
		"value" : "油压部分故障"
	}, {
		"outs" : [ {
			"id" : 71,
			"to" : 68,
			"from" : 66
		}, {
			"id" : 72,
			"to" : 69,
			"from" : 66
		}, {
			"id" : 73,
			"to" : 70,
			"from" : 66
		} ],
		"id" : 66,
		"position" : {
			"x" : 859,
			"y" : 113
		},
		"width" : 120,
		"height" : 39,
		"style" : "subflow",
		"value" : "工作密封故障"
	}, {
		"outs" : [],
		"id" : 68,
		"position" : {
			"x" : 930,
			"y" : 193
		},
		"width" : 135,
		"height" : 45,
		"style" : "process",
		"value" : "压力开关故障"
	}, {
		"outs" : [],
		"id" : 69,
		"position" : {
			"x" : 927,
			"y" : 279
		},
		"width" : 139,
		"height" : 45,
		"style" : "process",
		"value" : "密封测点故障"
	}, {
		"outs" : [],
		"id" : 70,
		"position" : {
			"x" : 930,
			"y" : 363
		},
		"width" : 138,
		"height" : 47,
		"style" : "process",
		"value" : "管路接头脱落"
	} ]
}

var cell1 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 42,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 43,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 44,
			"to" : 4,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 488,
			"y" : 9
		},
		"width" : 129,
		"height" : 36,
		"style" : "subflow",
		"value" : "球阀系统故障"
	}, {
		"outs" : [ {
			"id" : 26,
			"to" : 5,
			"from" : 2
		}, {
			"id" : 27,
			"to" : 6,
			"from" : 2
		}, {
			"id" : 28,
			"to" : 7,
			"from" : 2
		} ],
		"id" : 2,
		"position" : {
			"x" : -1,
			"y" : 113
		},
		"width" : 120,
		"height" : 39,
		"style" : "subflow",
		"value" : "球阀开启失败"
	}, {
		"outs" : [ {
			"id" : 45,
			"to" : 11,
			"from" : 22
		}, {
			"id" : 46,
			"to" : 12,
			"from" : 22
		}, {
			"id" : 47,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 48,
			"to" : 14,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 491,
			"y" : 110
		},
		"width" : 123,
		"height" : 39,
		"style" : "subflow",
		"value" : "油压部分故障"
	}, {
		"outs" : [ {
			"id" : 49,
			"to" : 8,
			"from" : 4
		}, {
			"id" : 50,
			"to" : 9,
			"from" : 4
		}, {
			"id" : 51,
			"to" : 10,
			"from" : 4
		} ],
		"id" : 4,
		"position" : {
			"x" : 887,
			"y" : 113
		},
		"width" : 123,
		"height" : 38,
		"style" : "subflow",
		"value" : "工作密封故障"
	}, {
		"outs" : [],
		"id" : 5,
		"position" : {
			"x" : 60,
			"y" : 186
		},
		"width" : 128,
		"height" : 45,
		"style" : "process",
		"value" : "测压管路堵塞"
	}, {
		"outs" : [],
		"id" : 6,
		"position" : {
			"x" : 60,
			"y" : 266
		},
		"width" : 133,
		"height" : 44,
		"style" : "process",
		"value" : "开启电磁阀故障"
	}, {
		"outs" : [],
		"id" : 7,
		"position" : {
			"x" : 36,
			"y" : 346
		},
		"width" : 134,
		"height" : 44,
		"style" : "process",
		"value" : "液压锁定卡涩"
	}, {
		"outs" : [],
		"id" : 8,
		"position" : {
			"x" : 954,
			"y" : 187
		},
		"width" : 117,
		"height" : 43,
		"style" : "process",
		"value" : "压力开关故障"
	}, {
		"outs" : [],
		"id" : 9,
		"position" : {
			"x" : 961,
			"y" : 266
		},
		"width" : 111,
		"height" : 48,
		"style" : "process",
		"value" : "密封测点故障"
	}, {
		"outs" : [],
		"id" : 10,
		"position" : {
			"x" : 969,
			"y" : 347
		},
		"width" : 111,
		"height" : 49,
		"style" : "process",
		"value" : "管路接头脱落"
	}, {
		"outs" : [ {
			"id" : 29,
			"to" : 15,
			"from" : 11
		}, {
			"id" : 30,
			"to" : 16,
			"from" : 11
		}, {
			"id" : 31,
			"to" : 17,
			"from" : 11
		}, {
			"id" : 32,
			"to" : 18,
			"from" : 11
		}, {
			"id" : 33,
			"to" : 19,
			"from" : 11
		} ],
		"id" : 11,
		"position" : {
			"x" : 192,
			"y" : 190
		},
		"width" : 111,
		"height" : 40,
		"style" : "subflow",
		"value" : "漏油箱油位异常"
	}, {
		"outs" : [],
		"id" : 12,
		"position" : {
			"x" : 390,
			"y" : 190
		},
		"width" : 134,
		"height" : 41,
		"style" : "subflow",
		"value" : "主油循环回路异常"
	}, {
		"outs" : [ {
			"id" : 52,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 53,
			"to" : 4222,
			"from" : 322
		}, {
			"id" : 54,
			"to" : 4223,
			"from" : 322
		}, {
			"id" : 55,
			"to" : 4224,
			"from" :322
		} ],
		"id" : 322,
		"position" : {
			"x" : 600,
			"y" : 190
		},
		"width" : 107,
		"height" : 39,
		"style" : "subflow",
		"value" : "压力油罐故障"
	}, {
		"outs" : [ {
			"id" : 63,
			"to" : 20,
			"from" : 14
		}, {
			"id" : 64,
			"to" : 21,
			"from" : 14
		}, {
			"id" : 65,
			"to" : 100,
			"from" : 14
		} ],
		"id" : 14,
		"position" : {
			"x" : 773,
			"y" : 191
		},
		"width" : 108,
		"height" : 41,
		"style" : "subflow",
		"value" : "集油箱油位异常"
	}, {
		"outs" : [],
		"id" : 15,
		"position" : {
			"x" : 246,
			"y" : 267
		},
		"width" : 129,
		"height" : 45,
		"style" : "process",
		"value" : "排油阀损坏"
	}, {
		"outs" : [],
		"id" : 16,
		"position" : {
			"x" : 247,
			"y" : 350
		},
		"width" : 130,
		"height" : 42,
		"style" : "process",
		"value" : "过滤器堵塞"
	}, {
		"outs" : [],
		"id" : 17,
		"position" : {
			"x" : 89,
			"y" : 430
		},
		"width" : 134,
		"height" : 47,
		"style" : "process",
		"value" : "油位信号回路故障"
	}, {
		"outs" : [],
		"id" : 18,
		"position" : {
			"x" : 180,
			"y" : 513
		},
		"width" : 135,
		"height" : 47,
		"style" : "process",
		"value" : "逆止阀故障"
	}, {
		"outs" : [],
		"id" : 19,
		"position" : {
			"x" : 246,
			"y" : 430
		},
		"width" : 130,
		"height" : 42,
		"style" : "process",
		"value" : "漏油泵故障"
	}, {
		"outs" : [],
		"id" : 20,
		"position" : {
			"x" : 825,
			"y" : 268
		},
		"width" : 121,
		"height" : 45,
		"style" : "process",
		"value" : "油位信号回路故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 843,
			"y" : 346
		},
		"width" : 120,
		"height" : 48,
		"style" : "process",
		"value" : "循环油泵故障"
	}, {
		"outs" : [],
		"id" : 100,
		"position" : {
			"x" : 878,
			"y" : 429
		},
		"width" : 120,
		"height" : 49,
		"style" : "process",
		"value" : "油系统严重漏油"
	}, {
		"outs" : [ {
			"id" : 58,
			"to" : 37,
			"from" : 4222
		}, {
			"id" : 60,
			"to" : 38,
			"from" : 4222
		} ],
		"id" : 4222,
		"position" : {
			"x" : 498,
			"y" : 270
		},
		"width" : 100,
		"height" : 41,
		"style" : "subflow",
		"value" : "油压偏低"
	}, {
		"outs" : [ {
			"id" : 59,
			"to" : 39,
			"from" : 4223
		}, {
			"id" : 61,
			"to" : 40,
			"from" : 4223
		} ],
		"id" : 4223,
		"position" : {
			"x" : 616,
			"y" : 270
		},
		"width" : 100,
		"height" : 44,
		"style" : "subflow",
		"value" : "油位偏高"
	}, {
		"outs" : [ {
			"id" : 56,
			"to" : 35,
			"from" : 4221
		}, {
			"id" : 57,
			"to" : 36,
			"from" : 4221
		} ],
		"id" : 4221,
		"position" : {
			"x" : 375,
			"y" : 270
		},
		"width" : 116,
		"height" : 41,
		"style" : "subflow",
		"value" : "油压偏高"
	}, {
		"outs" : [ {
			"id" : 62,
			"to" : 41,
			"from" : 4224
		} ],
		"id" : 4224,
		"position" : {
			"x" : 725,
			"y" : 270
		},
		"width" : 101,
		"height" : 44,
		"style" : "subflow",
		"value" : "油位偏低"
	}, {
		"outs" : [],
		"id" : 35,
		"position" : {
			"x" : 432,
			"y" : 350
		},
		"width" : 117,
		"height" : 43,
		"style" : "process",
		"value" : "油泵长时间运行"
	}, {
		"outs" : [],
		"id" : 36,
		"position" : {
			"x" : 373,
			"y" : 431
		},
		"width" : 120,
		"height" : 43,
		"style" : "process",
		"value" : "压力信号回路故障"
	}, {
		"outs" : [],
		"id" : 37,
		"position" : {
			"x" : 547,
			"y" : 352
		},
		"width" : 120,
		"height" : 41,
		"style" : "process",
		"value" : "压力油罐大量漏油"
	}, {
		"outs" : [],
		"id" : 38,
		"position" : {
			"x" : 513,
			"y" : 430
		},
		"width" : 116,
		"height" : 43,
		"style" : "process",
		"value" : "补气回路漏气"
	}, {
		"outs" : [],
		"id" : 39,
		"position" : {
			"x" : 665,
			"y" : 352
		},
		"width" : 112,
		"height" : 40,
		"style" : "process",
		"value" : "补气回路漏气"
	}, {
		"outs" : [],
		"id" : 40,
		"position" : {
			"x" : 637,
			"y" : 432
		},
		"width" : 127,
		"height" : 45,
		"style" : "process",
		"value" : "油位信号回路故障"
	}, {
		"outs" : [],
		"id" : 41,
		"position" : {
			"x" : 760,
			"y" : 433
		},
		"width" : 119,
		"height" : 45,
		"style" : "process",
		"value" : "压力油罐大量漏油"
	} ]
}
