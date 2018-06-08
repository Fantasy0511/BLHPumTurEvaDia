var cell1 = {
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
		}, {
			"id" : 61,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 306,
			"y" : 7
		},
		"width" : 118,
		"height" : 38,
		"style" : "subflow",
		"value" : "水泵水轮机"
	}, {
		"outs" : [ {
			"id" : 64,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 65,
			"to" : 312,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 95,
			"y" : 83
		},
		"width" : 100,
		"height" : 36,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 242,
			"y" : 83
		},
		"width" : 103,
		"height" : 36,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 425,
			"y" : 83
		},
		"width" : 108,
		"height" : 38,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [],
		"id" : 24,
		"position" : {
			"x" : 629,
			"y" : 83
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 75,
			"to" : 4121,
			"from" : 312
		}, {
			"id" : 76,
			"to" : 4122,
			"from" : 312
		}, {
			"id" : 77,
			"to" : 4123,
			"from" : 312
		} ],
		"id" : 312,
		"position" : {
			"x" : 184,
			"y" : 192
		},
		"width" : 100,
		"height" : 38,
		"style" : "subflow",
		"value" : "机组振动异常"
	}, {
		"outs" : [ {
			"id" : 69,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 70,
			"to" : 4112,
			"from" : 311
		}, {
			"id" : 71,
			"to" : 4113,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : 16,
			"y" : 192
		},
		"width" : 100,
		"height" : 38,
		"style" : "subflow",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : 86,
			"y" : 296
		},
		"width" : 113,
		"height" : 55,
		"style" : "process",
		"value" : "冷却水异常"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 86,
			"y" : 392
		},
		"width" : 112,
		"height" : 54,
		"style" : "process",
		"value" : "油系统异常"
	}, {
		"outs" : [],
		"id" : 4113,
		"position" : {
			"x" : 86,
			"y" : 493
		},
		"width" : 114,
		"height" : 56,
		"style" : "process",
		"value" : "大轴摆度异常"
	}, {
		"outs" : [],
		"id" : 4121,
		"position" : {
			"x" : 270,
			"y" : 296
		},
		"width" : 116,
		"height" : 54,
		"style" : "process",
		"value" : "励磁电流不平衡"
	}, {
		"outs" : [],
		"id" : 4122,
		"position" : {
			"x" : 270,
			"y" : 392
		},
		"width" : 117,
		"height" : 51,
		"style" : "process",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 4123,
		"position" : {
			"x" : 270,
			"y" : 493
		},
		"width" : 117,
		"height" : 57,
		"style" : "process",
		"value" : "水导摆度异常"
	} ]
}
var cell2 = {
	"cells" : [ {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 135,
			"y" : 215
		},
		"width" : 140,
		"height" : 35,
		"style" : "process",
		"value" : "尾水管水位过高"
	}, {
		"outs" : [ {
			"id" : 35,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 36,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 37,
			"to" : 23,
			"from" : 1
		}, {
			"id" : 38,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 308,
			"y" : 3
		},
		"width" : 149,
		"height" : 40,
		"style" : "subflow",
		"value" : "水泵水轮机"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 79,
			"y" : 90
		},
		"width" : 116,
		"height" : 37,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [ {
			"id" : 41,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 42,
			"to" : 321,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 241,
			"y" : 90
		},
		"width" : 119,
		"height" : 37,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 404,
			"y" : 90
		},
		"width" : 116,
		"height" : 37,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [],
		"id" : 24,
		"position" : {
			"x" : 586,
			"y" : 90
		},
		"width" : 112,
		"height" : 39,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [],
		"id" : 322,
		"position" : {
			"x" : 342,
			"y" : 215
		},
		"width" : 137,
		"height" : 35,
		"style" : "process",
		"value" : "蜗壳故障"
	} ]
}

var cell3 = {
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
		}, {
			"id" : 61,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 306,
			"y" : 7
		},
		"width" : 118,
		"height" : 38,
		"style" : "subflow",
		"value" : "水泵水轮机"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 40,
			"y" : 83
		},
		"width" : 100,
		"height" : 36,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 242,
			"y" : 83
		},
		"width" : 103,
		"height" : 36,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [ {
			"id" : 24,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 25,
			"to" : 333,
			"from" : 23
		}, {
			"id" : 26,
			"to" : 332,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 425,
			"y" : 83
		},
		"width" : 108,
		"height" : 38,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [ {
			"id" : 42,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 43,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 44,
			"to" : 4313,
			"from" : 331
		}, {
			"id" : 45,
			"to" : 4314,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 560,
			"y" : 165
		},
		"width" : 111,
		"height" : 44,
		"style" : "subflow",
		"value" : "转动部件故障"
	}, {
		"outs" : [],
		"id" : 332,
		"position" : {
			"x" : 424,
			"y" : 165
		},
		"width" : 110,
		"height" : 39,
		"style" : "process",
		"value" : "主轴密封异常"
	}, {
		"outs" : [ {
			"id" : 36,
			"to" : 4331,
			"from" : 333
		}, {
			"id" : 37,
			"to" : 4332,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 300,
			"y" : 165
		},
		"width" : 111,
		"height" : 44,
		"style" : "subflow",
		"value" : "迷宫环故障"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 360,
			"y" : 312
		},
		"width" : 114,
		"height" : 37,
		"style" : "process",
		"value" : "迷宫环温度异常"
	}, {
		"outs" : [],
		"id" : 4332,
		"position" : {
			"x" : 360,
			"y" : 388
		},
		"width" : 113,
		"height" : 37,
		"style" : "process",
		"value" : "冷却水流量低"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 620,
			"y" : 237
		},
		"width" : 98,
		"height" : 36,
		"style" : "process",
		"value" : "上导摆度异常"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 620,
			"y" : 312
		},
		"width" : 100,
		"height" : 37,
		"style" : "process",
		"value" : "下导摆度异常"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 620,
			"y" : 388
		},
		"width" : 101,
		"height" : 39,
		"style" : "process",
		"value" : "动不平衡"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 620,
			"y" : 466
		},
		"width" : 107,
		"height" : 42,
		"style" : "process",
		"value" : "主轴弯曲"
	}, {
		"outs" : [],
		"id" : 24,
		"position" : {
			"x" : 629,
			"y" : 83
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "推力轴承故障"
	} ]
}

var cell4 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 35,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 36,
			"to" : 22,
			"from" : 1
		}, {
			"id" : 37,
			"to" : 23,
			"from" : 1
		}, {
			"id" : 38,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 308,
			"y" : 3
		},
		"width" : 149,
		"height" : 40,
		"style" : "subflow",
		"value" : "水泵水轮机"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 79,
			"y" : 90
		},
		"width" : 116,
		"height" : 37,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 241,
			"y" : 90
		},
		"width" : 119,
		"height" : 37,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 404,
			"y" : 90
		},
		"width" : 116,
		"height" : 37,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [ {
			"id" : 53,
			"to" : 341,
			"from" : 24
		}, {
			"id" : 54,
			"to" : 342,
			"from" : 24
		} ],
		"id" : 24,
		"position" : {
			"x" : 586,
			"y" : 90
		},
		"width" : 112,
		"height" : 39,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 49,
			"to" : 4411,
			"from" : 341
		}, {
			"id" : 50,
			"to" : 4412,
			"from" : 341
		} ],
		"id" : 341,
		"position" : {
			"x" : 496,
			"y" : 202
		},
		"width" : 107,
		"height" : 38,
		"style" : "subflow",
		"value" : "轴承磨损"
	}, {
		"outs" : [ {
			"id" : 51,
			"to" : 4421,
			"from" : 342
		}, {
			"id" : 52,
			"to" : 4422,
			"from" : 342
		} ],
		"id" : 342,
		"position" : {
			"x" : 681,
			"y" : 202
		},
		"width" : 104,
		"height" : 38,
		"style" : "subflow",
		"value" : "油膜厚度异常"
	}, {
		"outs" : [],
		"id" : 4411,
		"position" : {
			"x" : 379,
			"y" : 314
		},
		"width" : 131,
		"height" : 39,
		"style" : "process",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [],
		"id" : 4412,
		"position" : {
			"x" : 379,
			"y" : 419
		},
		"width" : 130,
		"height" : 43,
		"style" : "process",
		"value" : "轴承振摆异常"
	}, {
		"outs" : [],
		"id" : 4421,
		"position" : {
			"x" : 584,
			"y" : 314
		},
		"width" : 132,
		"height" : 42,
		"style" : "process",
		"value" : "灭磁开关故障"
	}, {
		"outs" : [],
		"id" : 4422,
		"position" : {
			"x" : 584,
			"y" : 419
		},
		"width" : 130,
		"height" : 43,
		"style" : "process",
		"value" : "电源故障"
	} ]
}

var cell5 = {
	"cells" : [ {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : 55,
			"y" : 237
		},
		"width" : 101,
		"height" : 37,
		"style" : "process",
		"value" : "冷却水异常"
	}, {
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
		}, {
			"id" : 18,
			"to" : 24,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 306,
			"y" : 7
		},
		"width" : 118,
		"height" : 38,
		"style" : "subflow",
		"value" : "水泵水轮机"
	}, {
		"outs" : [ {
			"id" : 14,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 19,
			"to" : 312,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 40,
			"y" : 83
		},
		"width" : 100,
		"height" : 36,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [ {
			"id" : 22,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 23,
			"to" : 322,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 242,
			"y" : 83
		},
		"width" : 103,
		"height" : 36,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [ {
			"id" : 24,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 25,
			"to" : 333,
			"from" : 23
		}, {
			"id" : 26,
			"to" : 332,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 425,
			"y" : 83
		},
		"width" : 108,
		"height" : 38,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [ {
			"id" : 27,
			"to" : 341,
			"from" : 24
		}, {
			"id" : 28,
			"to" : 342,
			"from" : 24
		} ],
		"id" : 24,
		"position" : {
			"x" : 620,
			"y" : 83
		},
		"width" : 106,
		"height" : 37,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 49,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 50,
			"to" : 4112,
			"from" : 311
		}, {
			"id" : 51,
			"to" : 4113,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : 1,
			"y" : 165
		},
		"width" : 100,
		"height" : 42,
		"style" : "subflow",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [ {
			"id" : 46,
			"to" : 4121,
			"from" : 312
		}, {
			"id" : 47,
			"to" : 4122,
			"from" : 312
		}, {
			"id" : 48,
			"to" : 4123,
			"from" : 312
		} ],
		"id" : 312,
		"position" : {
			"x" : 126,
			"y" : 165
		},
		"width" : 101,
		"height" : 41,
		"style" : "subflow",
		"value" : "机组振动异常"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 297,
			"y" : 237
		},
		"width" : 112,
		"height" : 36,
		"style" : "process",
		"value" : "尾水管水位过高"
	}, {
		"outs" : [],
		"id" : 322,
		"position" : {
			"x" : 297,
			"y" : 312
		},
		"width" : 106,
		"height" : 35,
		"style" : "process",
		"value" : "蜗壳故障"
	}, {
		"outs" : [ {
			"id" : 42,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 43,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 44,
			"to" : 4313,
			"from" : 331
		}, {
			"id" : 45,
			"to" : 4314,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 506,
			"y" : 165
		},
		"width" : 111,
		"height" : 44,
		"style" : "subflow",
		"value" : "转动部件故障"
	}, {
		"outs" : [],
		"id" : 332,
		"position" : {
			"x" : 424,
			"y" : 236
		},
		"width" : 110,
		"height" : 39,
		"style" : "process",
		"value" : "主轴密封异常"
	}, {
		"outs" : [ {
			"id" : 36,
			"to" : 4331,
			"from" : 333
		}, {
			"id" : 37,
			"to" : 4332,
			"from" : 333
		} ],
		"id" : 333,
		"position" : {
			"x" : 354,
			"y" : 165
		},
		"width" : 113,
		"height" : 41,
		"style" : "subflow",
		"value" : "迷宫环故障"
	}, {
		"outs" : [ {
			"id" : 55,
			"to" : 4411,
			"from" : 341
		}, {
			"id" : 56,
			"to" : 4412,
			"from" : 341
		} ],
		"id" : 341,
		"position" : {
			"x" : 699,
			"y" : 165
		},
		"width" : 105,
		"height" : 44,
		"style" : "subflow",
		"value" : "轴承磨损"
	}, {
		"outs" : [ {
			"id" : 58,
			"to" : 4422,
			"from" : 342
		}, {
			"id" : 59,
			"to" : 4421,
			"from" : 342
		} ],
		"id" : 342,
		"position" : {
			"x" : 699,
			"y" : 389
		},
		"width" : 98,
		"height" : 45,
		"style" : "subflow",
		"value" : "油膜厚度异常"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 55,
			"y" : 312
		},
		"width" : 96,
		"height" : 34,
		"style" : "process",
		"value" : "油系统异常"
	}, {
		"outs" : [],
		"id" : 4113,
		"position" : {
			"x" : 55,
			"y" : 388
		},
		"width" : 95,
		"height" : 36,
		"style" : "process",
		"value" : "大轴摆度异常"
	}, {
		"outs" : [],
		"id" : 4121,
		"position" : {
			"x" : 179,
			"y" : 237
		},
		"width" : 111,
		"height" : 37,
		"style" : "process",
		"value" : "励磁电流不平衡"
	}, {
		"outs" : [],
		"id" : 4122,
		"position" : {
			"x" : 179,
			"y" : 312
		},
		"width" : 112,
		"height" : 35,
		"style" : "process",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 4123,
		"position" : {
			"x" : 179,
			"y" : 388
		},
		"width" : 114,
		"height" : 33,
		"style" : "process",
		"value" : "水导摆度异常"
	}, {
		"outs" : [],
		"id" : 4331,
		"position" : {
			"x" : 414,
			"y" : 312
		},
		"width" : 114,
		"height" : 37,
		"style" : "process",
		"value" : "迷宫环温度异常"
	}, {
		"outs" : [],
		"id" : 4332,
		"position" : {
			"x" : 417,
			"y" : 388
		},
		"width" : 113,
		"height" : 37,
		"style" : "process",
		"value" : "冷却水流量低"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 568,
			"y" : 237
		},
		"width" : 98,
		"height" : 36,
		"style" : "process",
		"value" : "上导摆度异常"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 568,
			"y" : 312
		},
		"width" : 100,
		"height" : 37,
		"style" : "process",
		"value" : "下导摆度异常"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 568,
			"y" : 388
		},
		"width" : 101,
		"height" : 39,
		"style" : "process",
		"value" : "动不平衡"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 568,
			"y" : 466
		},
		"width" : 107,
		"height" : 42,
		"style" : "process",
		"value" : "主轴弯曲"
	}, {
		"outs" : [],
		"id" : 4411,
		"position" : {
			"x" : 750,
			"y" : 237
		},
		"width" : 112,
		"height" : 41,
		"style" : "process",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [],
		"id" : 4412,
		"position" : {
			"x" : 750,
			"y" : 312
		},
		"width" : 110,
		"height" : 43,
		"style" : "process",
		"value" : "轴承振摆异常"
	}, {
		"outs" : [],
		"id" : 4421,
		"position" : {
			"x" : 750,
			"y" : 466
		},
		"width" : 108,
		"height" : 41,
		"style" : "process",
		"value" : "灭磁开关故障"
	}, {
		"outs" : [],
		"id" : 4422,
		"position" : {
			"x" : 750,
			"y" : 556
		},
		"width" : 104,
		"height" : 44,
		"style" : "process",
		"value" : "电源故障"
	} ]
}