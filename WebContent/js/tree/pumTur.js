var cell2 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 6,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 8,
			"to" : 23,
			"from" : 1
		}, {
			"id" : 9,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 421,
			"y" : 2
		},
		"width" : 123,
		"height" : 35,
		"style" : "subflow",
		"value" : "水泵水轮机故障"
	}, {
		"outs" : [ {
			"id" : 12,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 13,
			"to" : 312,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 66,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 303,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 592,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [],
		"id" : 24,
		"position" : {
			"x" : 836,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 38,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 39,
			"to" : 4112,
			"from" : 311
		}, {
			"id" : 40,
			"to" : 4113,
			"from" : 311
		}, {
			"id" : 41,
			"to" : 4114,
			"from" : 311
		}, {
			"id" : 42,
			"to" : 4115,
			"from" : 311
		}, {
			"id" : 43,
			"to" : 4116,
			"from" : 311
		}, {
			"id" : 44,
			"to" : 4117,
			"from" : 311
		}, {
			"id" : 45,
			"to" : 4118,
			"from" : 311
		}, {
			"id" : 46,
			"to" : 4119,
			"from" : 311
		}, {
			"id" : 47,
			"to" : 4120,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : 7,
			"y" : 141
		},
		"width" : 100,
		"height" : 30,
		"style" : "subflow",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [ {
			"id" : 55,
			"to" : 4121,
			"from" : 312
		}, {
			"id" : 56,
			"to" : 4122,
			"from" : 312
		}, {
			"id" : 57,
			"to" : 4123,
			"from" : 312
		}, {
			"id" : 58,
			"to" : 4124,
			"from" : 312
		}, {
			"id" : 59,
			"to" : 4125,
			"from" : 312
		}, {
			"id" : 60,
			"to" : 4126,
			"from" : 312
		}, {
			"id" : 61,
			"to" : 4127,
			"from" : 312
		} ],
		"id" : 312,
		"position" : {
			"x" : 121,
			"y" : 141
		},
		"width" : 121,
		"height" : 30,
		"style" : "subflow",
		"value" : "油循环系统故障"
	}, {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : 25,
			"y" : 196
		},
		"width" : 107,
		"height" : 25,
		"style" : "process",
		"value" : "冷却水流量低"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 25,
			"y" : 258
		},
		"width" : 103,
		"height" : 25,
		"style" : "process",
		"value" : "冷却水水温高"
	}, {
		"outs" : [],
		"id" : 4113,
		"position" : {
			"x" : 25,
			"y" : 322
		},
		"width" : 108,
		"height" : 25,
		"style" : "process",
		"value" : "冷却水水压低"
	}, {
		"outs" : [],
		"id" : 4114,
		"position" : {
			"x" : 25,
			"y" : 387
		},
		"width" : 109,
		"height" : 25,
		"style" : "process",
		"value" : "油系统油压低"
	}, {
		"outs" : [],
		"id" : 4115,
		"position" : {
			"x" : 25,
			"y" : 450
		},
		"width" : 111,
		"height" : 25,
		"style" : "process",
		"value" : "油系统油位低"
	}, {
		"outs" : [],
		"id" : 4116,
		"position" : {
			"x" : 25,
			"y" : 519
		},
		"width" : 116,
		"height" : 25,
		"style" : "process",
		"value" : "油系统油温高"
	}, {
		"outs" : [],
		"id" : 4117,
		"position" : {
			"x" : 25,
			"y" : 594
		},
		"width" : 120,
		"height" : 25,
		"style" : "process",
		"value" : "油系统油混水"
	}, {
		"outs" : [],
		"id" : 4118,
		"position" : {
			"x" : 151,
			"y" : 594
		},
		"width" : 112,
		"height" : 25,
		"style" : "process",
		"value" : "大轴摆度异常"
	}, {
		"outs" : [],
		"id" : 4119,
		"position" : {
			"x" : 282,
			"y" : 594
		},
		"width" : 120,
		"height" : 25,
		"style" : "process",
		"value" : "轴承振动异常"
	}, {
		"outs" : [],
		"id" : 4120,
		"position" : {
			"x" : 425,
			"y" : 594
		},
		"width" : 115,
		"height" : 25,
		"style" : "process",
		"value" : "轴承密封损坏"
	}, {
		"outs" : [],
		"id" : 4121,
		"position" : {
			"x" : 151,
			"y" : 196
		},
		"width" : 105,
		"height" : 25,
		"style" : "process",
		"value" : "循环油泵故障"
	}, {
		"outs" : [],
		"id" : 4122,
		"position" : {
			"x" : 151,
			"y" : 258
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "油泵轴承卡涩"
	}, {
		"outs" : [],
		"id" : 4123,
		"position" : {
			"x" : 151,
			"y" : 322
		},
		"width" : 113,
		"height" : 25,
		"style" : "process",
		"value" : "逆止阀内漏"
	}, {
		"outs" : [],
		"id" : 4124,
		"position" : {
			"x" : 151,
			"y" : 387
		},
		"width" : 112,
		"height" : 25,
		"style" : "process",
		"value" : "冷却器内部堵塞"
	}, {
		"outs" : [],
		"id" : 4125,
		"position" : {
			"x" : 151,
			"y" : 450
		},
		"width" : 123,
		"height" : 25,
		"style" : "process",
		"value" : "轴瓦间隙不均"
	}, {
		"outs" : [],
		"id" : 4126,
		"position" : {
			"x" : 151,
			"y" : 519
		},
		"width" : 118,
		"height" : 25,
		"style" : "process",
		"value" : "回路故障"
	}, {
		"outs" : [],
		"id" : 4127,
		"position" : {
			"x" : 282,
			"y" : 519
		},
		"width" : 117,
		"height" : 25,
		"style" : "process",
		"value" : "传感器故障"
	} ]
}
var cell3 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 6,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 8,
			"to" : 23,
			"from" : 1
		}, {
			"id" : 9,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 421,
			"y" : 2
		},
		"width" : 123,
		"height" : 35,
		"style" : "subflow",
		"value" : "水泵水轮机故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 66,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [ {
			"id" : 26,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 27,
			"to" : 322,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 303,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 592,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [],
		"id" : 24,
		"position" : {
			"x" : 836,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 67,
			"to" : 4211,
			"from" : 321
		}, {
			"id" : 68,
			"to" : 4212,
			"from" : 321
		}, {
			"id" : 69,
			"to" : 4213,
			"from" : 321
		} ],
		"id" : 321,
		"position" : {
			"x" : 247,
			"y" : 141
		},
		"width" : 106,
		"height" : 30,
		"style" : "subflow",
		"value" : "尾水管水位过高"
	}, {
		"outs" : [ {
			"id" : 70,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 71,
			"to" : 4222,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 362,
			"y" : 141
		},
		"width" : 95,
		"height" : 30,
		"style" : "subflow",
		"value" : "蜗壳故障"
	}, {
		"outs" : [],
		"id" : 4211,
		"position" : {
			"x" : 282,
			"y" : 196
		},
		"width" : 115,
		"height" : 25,
		"style" : "process",
		"value" : "补气不足"
	}, {
		"outs" : [],
		"id" : 4212,
		"position" : {
			"x" : 282,
			"y" : 258
		},
		"width" : 112,
		"height" : 25,
		"style" : "process",
		"value" : "压力脉动"
	}, {
		"outs" : [],
		"id" : 4213,
		"position" : {
			"x" : 282,
			"y" : 322
		},
		"width" : 116,
		"height" : 25,
		"style" : "process",
		"value" : "空蚀磨损"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 282,
			"y" : 387
		},
		"width" : 122,
		"height" : 27,
		"style" : "process",
		"value" : "蜗壳进口压力脉动"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 282,
			"y" : 450
		},
		"width" : 121,
		"height" : 27,
		"style" : "process",
		"value" : "蜗壳排水管渗漏"
	} ]
}
var cell4 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 6,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 8,
			"to" : 23,
			"from" : 1
		}, {
			"id" : 9,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 421,
			"y" : 2
		},
		"width" : 123,
		"height" : 35,
		"style" : "subflow",
		"value" : "水泵水轮机故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 66,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 303,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [ {
			"id" : 25,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 26,
			"to" : 332,
			"from" : 23
		}, {
			"id" : 27,
			"to" : 333,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 592,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [],
		"id" : 24,
		"position" : {
			"x" : 836,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 80,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 81,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 82,
			"to" : 4313,
			"from" : 331
		}, {
			"id" : 83,
			"to" : 4314,
			"from" : 331
		}, {
			"id" : 84,
			"to" : 4315,
			"from" : 331
		}, {
			"id" : 85,
			"to" : 4316,
			"from" : 331
		}, {
			"id" : 86,
			"to" : 4317,
			"from" : 331
		}, {
			"id" : 87,
			"to" : 4318,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 473,
			"y" : 141
		},
		"width" : 109,
		"height" : 30,
		"style" : "subflow",
		"value" : "机组振动异常"
	}, {
		"outs" : [ {
			"id" : 94,
			"to" : 4321,
			"from" : 332
		}, {
			"id" : 95,
			"to" : 4322,
			"from" : 332
		}, {
			"id" : 96,
			"to" : 4323,
			"from" : 332
		}, {
			"id" : 97,
			"to" : 4324,
			"from" : 332
		}, {
			"id" : 98,
			"to" : 4325,
			"from" : 332
		}, {
			"id" : 99,
			"to" : 4326,
			"from" : 332
		} ],
		"id" : 332,
		"position" : {
			"x" : 590,
			"y" : 141
		},
		"width" : 105,
		"height" : 30,
		"style" : "subflow",
		"value" : "主轴密封故障"
	}, {
		"outs" : [ {
			"id" : 105,
			"to" : 4331,
			"from" : 333
		}, {
			"id" : 106,
			"to" : 4332,
			"from" : 333
		}, {
			"id" : 107,
			"to" : 4333,
			"from" : 333
		}, {
			"id" : 108,
			"to" : 4334,
			"from" : 333
		}, {
			"id" : 109,
			"to" : 4335,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 710,
			"y" : 141
		},
		"width" : 85,
		"height" : 30,
		"style" : "subflow",
		"value" : "迷宫环故障"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 425,
			"y" : 196
		},
		"width" : 104,
		"height" : 25,
		"style" : "process",
		"value" : "上导摆度异常"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 425,
			"y" : 258
		},
		"width" : 108,
		"height" : 25,
		"style" : "process",
		"value" : "下导摆度异常"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 425,
			"y" : 322
		},
		"width" : 102,
		"height" : 25,
		"style" : "process",
		"value" : "动不平衡"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 425,
			"y" : 387
		},
		"width" : 107,
		"height" : 25,
		"style" : "process",
		"value" : "主轴弯曲"
	}, {
		"outs" : [],
		"id" : 4315,
		"position" : {
			"x" : 425,
			"y" : 450
		},
		"width" : 120,
		"height" : 25,
		"style" : "process",
		"value" : "磁拉力不平衡"
	}, {
		"outs" : [],
		"id" : 4316,
		"position" : {
			"x" : 425,
			"y" : 519
		},
		"width" : 119,
		"height" : 25,
		"style" : "process",
		"value" : "上机架振动异常"
	}, {
		"outs" : [],
		"id" : 4318,
		"position" : {
			"x" : 678,
			"y" : 519
		},
		"width" : 122,
		"height" : 25,
		"style" : "process",
		"value" : "定子绕组固定不良"
	}, {
		"outs" : [],
		"id" : 4317,
		"position" : {
			"x" : 552,
			"y" : 519
		},
		"width" : 122,
		"height" : 25,
		"style" : "process",
		"value" : "下机架振动异常"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 552,
			"y" : 197
		},
		"width" : 96,
		"height" : 25,
		"style" : "process",
		"value" : "弹簧故障"
	}, {
		"outs" : [],
		"id" : 4322,
		"position" : {
			"x" : 552,
			"y" : 259
		},
		"width" : 100,
		"height" : 25,
		"style" : "process",
		"value" : "减压阀故障"
	}, {
		"outs" : [],
		"id" : 4323,
		"position" : {
			"x" : 552,
			"y" : 322
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "过滤器堵塞"
	}, {
		"outs" : [],
		"id" : 4324,
		"position" : {
			"x" : 552,
			"y" : 387
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "冲洗电机故障"
	}, {
		"outs" : [],
		"id" : 4325,
		"position" : {
			"x" : 552,
			"y" : 450
		},
		"width" : 114,
		"height" : 25,
		"style" : "process",
		"value" : "测压回路故障"
	}, {
		"outs" : [],
		"id" : 4326,
		"position" : {
			"x" : 678,
			"y" : 450
		},
		"width" : 117,
		"height" : 25,
		"style" : "process",
		"value" : "供气减压阀故障"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 679,
			"y" : 196
		},
		"width" : 104,
		"height" : 25,
		"style" : "process",
		"value" : "管路进气"
	}, {
		"outs" : [],
		"id" : 4332,
		"position" : {
			"x" : 678,
			"y" : 258
		},
		"width" : 97,
		"height" : 25,
		"style" : "process",
		"value" : "流量异常"
	}, {
		"outs" : [],
		"id" : 4333,
		"position" : {
			"x" : 678,
			"y" : 322
		},
		"width" : 106,
		"height" : 25,
		"style" : "process",
		"value" : "压力异常"
	}, {
		"outs" : [],
		"id" : 4334,
		"position" : {
			"x" : 678,
			"y" : 387
		},
		"width" : 113,
		"height" : 25,
		"style" : "process",
		"value" : "回路异常渗漏"
	}, {
		"outs" : [],
		"id" : 4335,
		"position" : {
			"x" : 813,
			"y" : 450
		},
		"width" : 119,
		"height" : 25,
		"style" : "process",
		"value" : "压力振荡"
	} ]
}

var cell5 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 6,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 8,
			"to" : 23,
			"from" : 1
		}, {
			"id" : 9,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 421,
			"y" : 2
		},
		"width" : 123,
		"height" : 35,
		"style" : "subflow",
		"value" : "水泵水轮机故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 66,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 303,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 592,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 341,
			"from" : 24
		}, {
			"id" : 29,
			"to" : 342,
			"from" : 24
		} ],
		"id" : 24,
		"position" : {
			"x" : 836,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 114,
			"to" : 4411,
			"from" : 341
		}, {
			"id" : 115,
			"to" : 4412,
			"from" : 341
		} ],
		"id" : 341,
		"position" : {
			"x" : 803,
			"y" : 141
		},
		"width" : 89,
		"height" : 30,
		"style" : "subflow",
		"value" : "轴承磨损"
	}, {
		"outs" : [ {
			"id" : 116,
			"to" : 4421,
			"from" : 342
		}, {
			"id" : 117,
			"to" : 4422,
			"from" : 342
		} ],
		"id" : 342,
		"position" : {
			"x" : 899,
			"y" : 141
		},
		"width" : 96,
		"height" : 30,
		"style" : "subflow",
		"value" : "油膜厚度异常"
	}, {
		"outs" : [],
		"id" : 4411,
		"position" : {
			"x" : 813,
			"y" : 196
		},
		"width" : 112,
		"height" : 25,
		"style" : "process",
		"value" : "轴瓦温度过高"
	}, {
		"outs" : [],
		"id" : 4412,
		"position" : {
			"x" : 813,
			"y" : 258
		},
		"width" : 113,
		"height" : 25,
		"style" : "process",
		"value" : "轴承振摆异常"
	}, {
		"outs" : [],
		"id" : 4421,
		"position" : {
			"x" : 813,
			"y" : 322
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "供油故障"
	}, {
		"outs" : [],
		"id" : 4422,
		"position" : {
			"x" : 813,
			"y" : 387
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "轴瓦变形"
	} ]
}

var cell1 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 6,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 8,
			"to" : 23,
			"from" : 1
		}, {
			"id" : 9,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 421,
			"y" : 2
		},
		"width" : 123,
		"height" : 35,
		"style" : "subflow",
		"value" : "水泵水轮机故障"
	}, {
		"outs" : [ {
			"id" : 12,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 13,
			"to" : 312,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 66,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [ {
			"id" : 26,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 27,
			"to" : 322,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 303,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [ {
			"id" : 25,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 26,
			"to" : 332,
			"from" : 23
		}, {
			"id" : 27,
			"to" : 333,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 592,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 341,
			"from" : 24
		}, {
			"id" : 29,
			"to" : 342,
			"from" : 24
		} ],
		"id" : 24,
		"position" : {
			"x" : 836,
			"y" : 74
		},
		"width" : 100,
		"height" : 25,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 38,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 39,
			"to" : 4112,
			"from" : 311
		}, {
			"id" : 40,
			"to" : 4113,
			"from" : 311
		}, {
			"id" : 41,
			"to" : 4114,
			"from" : 311
		}, {
			"id" : 42,
			"to" : 4115,
			"from" : 311
		}, {
			"id" : 43,
			"to" : 4116,
			"from" : 311
		}, {
			"id" : 44,
			"to" : 4117,
			"from" : 311
		}, {
			"id" : 45,
			"to" : 4118,
			"from" : 311
		}, {
			"id" : 46,
			"to" : 4119,
			"from" : 311
		}, {
			"id" : 47,
			"to" : 4120,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : 7,
			"y" : 141
		},
		"width" : 100,
		"height" : 30,
		"style" : "subflow",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [ {
			"id" : 55,
			"to" : 4121,
			"from" : 312
		}, {
			"id" : 56,
			"to" : 4122,
			"from" : 312
		}, {
			"id" : 57,
			"to" : 4123,
			"from" : 312
		}, {
			"id" : 58,
			"to" : 4124,
			"from" : 312
		}, {
			"id" : 59,
			"to" : 4125,
			"from" : 312
		}, {
			"id" : 60,
			"to" : 4126,
			"from" : 312
		}, {
			"id" : 61,
			"to" : 4127,
			"from" : 312
		} ],
		"id" : 312,
		"position" : {
			"x" : 121,
			"y" : 141
		},
		"width" : 121,
		"height" : 30,
		"style" : "subflow",
		"value" : "油循环系统故障"
	}, {
		"outs" : [ {
			"id" : 67,
			"to" : 4211,
			"from" : 321
		}, {
			"id" : 68,
			"to" : 4212,
			"from" : 321
		}, {
			"id" : 69,
			"to" : 4213,
			"from" : 321
		} ],
		"id" : 321,
		"position" : {
			"x" : 247,
			"y" : 141
		},
		"width" : 106,
		"height" : 30,
		"style" : "subflow",
		"value" : "尾水管水位过高"
	}, {
		"outs" : [ {
			"id" : 70,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 71,
			"to" : 4222,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 362,
			"y" : 141
		},
		"width" : 95,
		"height" : 30,
		"style" : "subflow",
		"value" : "蜗壳故障"
	}, {
		"outs" : [ {
			"id" : 80,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 81,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 82,
			"to" : 4313,
			"from" : 331
		}, {
			"id" : 83,
			"to" : 4314,
			"from" : 331
		}, {
			"id" : 84,
			"to" : 4315,
			"from" : 331
		}, {
			"id" : 85,
			"to" : 4316,
			"from" : 331
		}, {
			"id" : 86,
			"to" : 4317,
			"from" : 331
		}, {
			"id" : 87,
			"to" : 4318,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 473,
			"y" : 141
		},
		"width" : 109,
		"height" : 30,
		"style" : "subflow",
		"value" : "机组振动异常"
	}, {
		"outs" : [ {
			"id" : 94,
			"to" : 4321,
			"from" : 332
		}, {
			"id" : 95,
			"to" : 4322,
			"from" : 332
		}, {
			"id" : 96,
			"to" : 4323,
			"from" : 332
		}, {
			"id" : 97,
			"to" : 4324,
			"from" : 332
		}, {
			"id" : 98,
			"to" : 4325,
			"from" : 332
		}, {
			"id" : 99,
			"to" : 4326,
			"from" : 332
		} ],
		"id" : 332,
		"position" : {
			"x" : 590,
			"y" : 141
		},
		"width" : 105,
		"height" : 30,
		"style" : "subflow",
		"value" : "主轴密封故障"
	}, {
		"outs" : [ {
			"id" : 105,
			"to" : 4331,
			"from" : 333
		}, {
			"id" : 106,
			"to" : 4332,
			"from" : 333
		}, {
			"id" : 107,
			"to" : 4333,
			"from" : 333
		}, {
			"id" : 108,
			"to" : 4334,
			"from" : 333
		}, {
			"id" : 109,
			"to" : 4335,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 710,
			"y" : 141
		},
		"width" : 85,
		"height" : 30,
		"style" : "subflow",
		"value" : "迷宫环故障"
	}, {
		"outs" : [ {
			"id" : 114,
			"to" : 4411,
			"from" : 341
		}, {
			"id" : 115,
			"to" : 4412,
			"from" : 341
		} ],
		"id" : 341,
		"position" : {
			"x" : 803,
			"y" : 141
		},
		"width" : 89,
		"height" : 30,
		"style" : "subflow",
		"value" : "轴承磨损"
	}, {
		"outs" : [ {
			"id" : 116,
			"to" : 4421,
			"from" : 342
		}, {
			"id" : 117,
			"to" : 4422,
			"from" : 342
		} ],
		"id" : 342,
		"position" : {
			"x" : 899,
			"y" : 141
		},
		"width" : 96,
		"height" : 30,
		"style" : "subflow",
		"value" : "油膜厚度异常"
	}, {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : 25,
			"y" : 196
		},
		"width" : 107,
		"height" : 25,
		"style" : "process",
		"value" : "冷却水流量低"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 25,
			"y" : 258
		},
		"width" : 103,
		"height" : 25,
		"style" : "process",
		"value" : "冷却水水温高"
	}, {
		"outs" : [],
		"id" : 4113,
		"position" : {
			"x" : 25,
			"y" : 322
		},
		"width" : 108,
		"height" : 25,
		"style" : "process",
		"value" : "冷却水水压低"
	}, {
		"outs" : [],
		"id" : 4114,
		"position" : {
			"x" : 25,
			"y" : 387
		},
		"width" : 109,
		"height" : 25,
		"style" : "process",
		"value" : "油系统油压低"
	}, {
		"outs" : [],
		"id" : 4115,
		"position" : {
			"x" : 25,
			"y" : 450
		},
		"width" : 111,
		"height" : 25,
		"style" : "process",
		"value" : "油系统油位低"
	}, {
		"outs" : [],
		"id" : 4116,
		"position" : {
			"x" : 25,
			"y" : 519
		},
		"width" : 116,
		"height" : 25,
		"style" : "process",
		"value" : "油系统油温高"
	}, {
		"outs" : [],
		"id" : 4117,
		"position" : {
			"x" : 25,
			"y" : 594
		},
		"width" : 120,
		"height" : 25,
		"style" : "process",
		"value" : "油系统油混水"
	}, {
		"outs" : [],
		"id" : 4118,
		"position" : {
			"x" : 151,
			"y" : 594
		},
		"width" : 112,
		"height" : 25,
		"style" : "process",
		"value" : "大轴摆度异常"
	}, {
		"outs" : [],
		"id" : 4119,
		"position" : {
			"x" : 282,
			"y" : 594
		},
		"width" : 120,
		"height" : 25,
		"style" : "process",
		"value" : "轴承振动异常"
	}, {
		"outs" : [],
		"id" : 4120,
		"position" : {
			"x" : 425,
			"y" : 594
		},
		"width" : 115,
		"height" : 25,
		"style" : "process",
		"value" : "轴承密封损坏"
	}, {
		"outs" : [],
		"id" : 4121,
		"position" : {
			"x" : 151,
			"y" : 196
		},
		"width" : 105,
		"height" : 25,
		"style" : "process",
		"value" : "循环油泵故障"
	}, {
		"outs" : [],
		"id" : 4122,
		"position" : {
			"x" : 151,
			"y" : 258
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "油泵轴承卡涩"
	}, {
		"outs" : [],
		"id" : 4123,
		"position" : {
			"x" : 151,
			"y" : 322
		},
		"width" : 113,
		"height" : 25,
		"style" : "process",
		"value" : "逆止阀内漏"
	}, {
		"outs" : [],
		"id" : 4124,
		"position" : {
			"x" : 151,
			"y" : 387
		},
		"width" : 112,
		"height" : 25,
		"style" : "process",
		"value" : "冷却器内部堵塞"
	}, {
		"outs" : [],
		"id" : 4125,
		"position" : {
			"x" : 151,
			"y" : 450
		},
		"width" : 123,
		"height" : 25,
		"style" : "process",
		"value" : "轴瓦间隙不均"
	}, {
		"outs" : [],
		"id" : 4126,
		"position" : {
			"x" : 151,
			"y" : 519
		},
		"width" : 118,
		"height" : 25,
		"style" : "process",
		"value" : "回路故障"
	}, {
		"outs" : [],
		"id" : 4127,
		"position" : {
			"x" : 282,
			"y" : 519
		},
		"width" : 117,
		"height" : 25,
		"style" : "process",
		"value" : "传感器故障"
	}, {
		"outs" : [],
		"id" : 4211,
		"position" : {
			"x" : 282,
			"y" : 196
		},
		"width" : 115,
		"height" : 25,
		"style" : "process",
		"value" : "补气不足"
	}, {
		"outs" : [],
		"id" : 4212,
		"position" : {
			"x" : 282,
			"y" : 258
		},
		"width" : 112,
		"height" : 25,
		"style" : "process",
		"value" : "压力脉动"
	}, {
		"outs" : [],
		"id" : 4213,
		"position" : {
			"x" : 282,
			"y" : 322
		},
		"width" : 116,
		"height" : 25,
		"style" : "process",
		"value" : "空蚀磨损"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 282,
			"y" : 387
		},
		"width" : 122,
		"height" : 27,
		"style" : "process",
		"value" : "蜗壳进口压力脉动"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 282,
			"y" : 450
		},
		"width" : 121,
		"height" : 27,
		"style" : "process",
		"value" : "蜗壳排水管渗漏"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 425,
			"y" : 196
		},
		"width" : 104,
		"height" : 25,
		"style" : "process",
		"value" : "上导摆度异常"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 425,
			"y" : 258
		},
		"width" : 108,
		"height" : 25,
		"style" : "process",
		"value" : "下导摆度异常"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 425,
			"y" : 322
		},
		"width" : 102,
		"height" : 25,
		"style" : "process",
		"value" : "动不平衡"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 425,
			"y" : 387
		},
		"width" : 107,
		"height" : 25,
		"style" : "process",
		"value" : "主轴弯曲"
	}, {
		"outs" : [],
		"id" : 4315,
		"position" : {
			"x" : 425,
			"y" : 450
		},
		"width" : 120,
		"height" : 25,
		"style" : "process",
		"value" : "磁拉力不平衡"
	}, {
		"outs" : [],
		"id" : 4316,
		"position" : {
			"x" : 425,
			"y" : 519
		},
		"width" : 119,
		"height" : 25,
		"style" : "process",
		"value" : "上机架振动异常"
	}, {
		"outs" : [],
		"id" : 4318,
		"position" : {
			"x" : 678,
			"y" : 519
		},
		"width" : 122,
		"height" : 25,
		"style" : "process",
		"value" : "定子绕组固定不良"
	}, {
		"outs" : [],
		"id" : 4317,
		"position" : {
			"x" : 552,
			"y" : 519
		},
		"width" : 122,
		"height" : 25,
		"style" : "process",
		"value" : "下机架振动异常"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 552,
			"y" : 197
		},
		"width" : 96,
		"height" : 25,
		"style" : "process",
		"value" : "弹簧故障"
	}, {
		"outs" : [],
		"id" : 4322,
		"position" : {
			"x" : 552,
			"y" : 259
		},
		"width" : 100,
		"height" : 25,
		"style" : "process",
		"value" : "减压阀故障"
	}, {
		"outs" : [],
		"id" : 4323,
		"position" : {
			"x" : 552,
			"y" : 322
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "过滤器堵塞"
	}, {
		"outs" : [],
		"id" : 4324,
		"position" : {
			"x" : 552,
			"y" : 387
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "冲洗电机故障"
	}, {
		"outs" : [],
		"id" : 4325,
		"position" : {
			"x" : 552,
			"y" : 450
		},
		"width" : 114,
		"height" : 25,
		"style" : "process",
		"value" : "测压回路故障"
	}, {
		"outs" : [],
		"id" : 4326,
		"position" : {
			"x" : 678,
			"y" : 450
		},
		"width" : 117,
		"height" : 25,
		"style" : "process",
		"value" : "供气减压阀故障"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 679,
			"y" : 196
		},
		"width" : 104,
		"height" : 25,
		"style" : "process",
		"value" : "管路进气"
	}, {
		"outs" : [],
		"id" : 4332,
		"position" : {
			"x" : 678,
			"y" : 258
		},
		"width" : 97,
		"height" : 25,
		"style" : "process",
		"value" : "流量异常"
	}, {
		"outs" : [],
		"id" : 4333,
		"position" : {
			"x" : 678,
			"y" : 322
		},
		"width" : 106,
		"height" : 25,
		"style" : "process",
		"value" : "压力异常"
	}, {
		"outs" : [],
		"id" : 4334,
		"position" : {
			"x" : 678,
			"y" : 387
		},
		"width" : 113,
		"height" : 25,
		"style" : "process",
		"value" : "回路异常渗漏"
	}, {
		"outs" : [],
		"id" : 4335,
		"position" : {
			"x" : 813,
			"y" : 450
		},
		"width" : 119,
		"height" : 25,
		"style" : "process",
		"value" : "压力振荡"
	}, {
		"outs" : [],
		"id" : 4411,
		"position" : {
			"x" : 813,
			"y" : 196
		},
		"width" : 112,
		"height" : 25,
		"style" : "process",
		"value" : "轴瓦温度过高"
	}, {
		"outs" : [],
		"id" : 4412,
		"position" : {
			"x" : 813,
			"y" : 258
		},
		"width" : 113,
		"height" : 25,
		"style" : "process",
		"value" : "轴承振摆异常"
	}, {
		"outs" : [],
		"id" : 4421,
		"position" : {
			"x" : 813,
			"y" : 322
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "供油故障"
	}, {
		"outs" : [],
		"id" : 4422,
		"position" : {
			"x" : 813,
			"y" : 387
		},
		"width" : 110,
		"height" : 25,
		"style" : "process",
		"value" : "轴瓦变形"
	} ]
}