var cell1 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 6,
			"to" : 3,
			"from" : 1
		}, {
			"id" : 7,
			"to" : 2,
			"from" : 1
		}, {
			"id" : 8,
			"to" : 4,
			"from" : 1
		}, {
			"id" : 9,
			"to" : 5,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 353,
			"y" : 24
		},
		"width" : 177,
		"height" : 50,
		"style" : "subflow",
		"value" : "水泵水轮机"
	}, {
		"outs" : [ {
			"id" : 23,
			"to" : 21,
			"from" : 2
		}, {
			"id" : 24,
			"to" : 22,
			"from" : 2
		} ],
		"id" : 2,
		"position" : {
			"x" : 5,
			"y" : 152
		},
		"width" : 152,
		"height" : 52,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [],
		"id" : 3,
		"position" : {
			"x" : 225,
			"y" : 152
		},
		"width" : 157,
		"height" : 52,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [],
		"id" : 4,
		"position" : {
			"x" : 470,
			"y" : 152
		},
		"width" : 156,
		"height" : 51,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [],
		"id" : 5,
		"position" : {
			"x" : 709,
			"y" : 152
		},
		"width" : 150,
		"height" : 51,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [],
		"id" : 10,
		"position" : {
			"x" : 69,
			"y" : 350
		},
		"width" : 141,
		"height" : 61,
		"style" : "process",
		"value" : "冷却水异常"
	}, {
		"outs" : [],
		"id" : 11,
		"position" : {
			"x" : 67,
			"y" : 446
		},
		"width" : 145,
		"height" : 58,
		"style" : "process",
		"value" : "油系统异常"
	}, {
		"outs" : [],
		"id" : 12,
		"position" : {
			"x" : 64,
			"y" : 557
		},
		"width" : 148,
		"height" : 68,
		"style" : "process",
		"value" : "大轴摆度异常"
	}, {
		"outs" : [],
		"id" : 16,
		"position" : {
			"x" : 277,
			"y" : 349
		},
		"width" : 137,
		"height" : 63,
		"style" : "process",
		"value" : "励磁电流不平衡"
	}, {
		"outs" : [],
		"id" : 17,
		"position" : {
			"x" : 279,
			"y" : 445
		},
		"width" : 139,
		"height" : 69,
		"style" : "process",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 18,
		"position" : {
			"x" : 288,
			"y" : 556
		},
		"width" : 138,
		"height" : 69,
		"style" : "process",
		"value" : "上导摆度异常"
	}, {
		"outs" : [],
		"id" : 19,
		"position" : {
			"x" : 439,
			"y" : 556
		},
		"width" : 143,
		"height" : 71,
		"style" : "process",
		"value" : "下导摆度异常"
	}, {
		"outs" : [],
		"id" : 20,
		"position" : {
			"x" : 600,
			"y" : 556
		},
		"width" : 142,
		"height" : 70,
		"style" : "process",
		"value" : "水导摆度异常"
	}, {
		"outs" : [ {
			"id" : 25,
			"to" : 10,
			"from" : 21
		}, {
			"id" : 26,
			"to" : 11,
			"from" : 21
		}, {
			"id" : 27,
			"to" : 12,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : -1,
			"y" : 251
		},
		"width" : 132,
		"height" : 49,
		"style" : "subflow",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 16,
			"from" : 22
		}, {
			"id" : 29,
			"to" : 17,
			"from" : 22
		}, {
			"id" : 30,
			"to" : 18,
			"from" : 22
		}, {
			"id" : 31,
			"to" : 19,
			"from" : 22
		}, {
			"id" : 32,
			"to" : 20,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 164,
			"y" : 251
		},
		"width" : 133,
		"height" : 51,
		"style" : "subflow",
		"value" : "机组振动异常"
	} ]
}

var cell2 = {
	"cells" : [ {
		"outs" : [],
		"id" : 1,
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
			"to" : 3,
			"from" : 2
		}, {
			"id" : 36,
			"to" : 4,
			"from" : 2
		}, {
			"id" : 37,
			"to" : 5,
			"from" : 2
		}, {
			"id" : 38,
			"to" : 6,
			"from" : 2
		} ],
		"id" : 2,
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
		"id" : 3,
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
			"id" : 39,
			"to" : 1,
			"from" : 4
		}, {
			"id" : 40,
			"to" : 8,
			"from" : 4
		} ],
		"id" : 4,
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
		"id" : 5,
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
		"id" : 6,
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
		"id" : 8,
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
			"id" : 35,
			"to" : 3,
			"from" : 2
		}, {
			"id" : 36,
			"to" : 4,
			"from" : 2
		}, {
			"id" : 37,
			"to" : 5,
			"from" : 2
		}, {
			"id" : 38,
			"to" : 6,
			"from" : 2
		} ],
		"id" : 2,
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
		"id" : 3,
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
		"id" : 4,
		"position" : {
			"x" : 241,
			"y" : 90
		},
		"width" : 119,
		"height" : 37,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [ {
			"id" : 42,
			"to" : 39,
			"from" : 5
		}, {
			"id" : 43,
			"to" : 40,
			"from" : 5
		}, {
			"id" : 44,
			"to" : 41,
			"from" : 5
		} ],
		"id" : 5,
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
		"id" : 6,
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
			"to" : 45,
			"from" : 39
		}, {
			"id" : 50,
			"to" : 46,
			"from" : 39
		} ],
		"id" : 39,
		"position" : {
			"x" : 247,
			"y" : 202
		},
		"width" : 107,
		"height" : 38,
		"style" : "subflow",
		"value" : "转动部件故障"
	}, {
		"outs" : [],
		"id" : 40,
		"position" : {
			"x" : 410,
			"y" : 202
		},
		"width" : 104,
		"height" : 35,
		"style" : "process",
		"value" : "主轴密封故障"
	}, {
		"outs" : [ {
			"id" : 51,
			"to" : 47,
			"from" : 41
		}, {
			"id" : 52,
			"to" : 48,
			"from" : 41
		} ],
		"id" : 41,
		"position" : {
			"x" : 583,
			"y" : 202
		},
		"width" : 104,
		"height" : 38,
		"style" : "subflow",
		"value" : "迷宫环故障"
	}, {
		"outs" : [],
		"id" : 45,
		"position" : {
			"x" : 162,
			"y" : 314
		},
		"width" : 108,
		"height" : 35,
		"style" : "process",
		"value" : "动不平衡"
	}, {
		"outs" : [],
		"id" : 46,
		"position" : {
			"x" : 327,
			"y" : 314
		},
		"width" : 106,
		"height" : 36,
		"style" : "process",
		"value" : "主轴弯曲"
	}, {
		"outs" : [],
		"id" : 47,
		"position" : {
			"x" : 475,
			"y" : 314
		},
		"width" : 132,
		"height" : 37,
		"style" : "process",
		"value" : "迷宫环温度异常"
	}, {
		"outs" : [],
		"id" : 48,
		"position" : {
			"x" : 661,
			"y" : 314
		},
		"width" : 122,
		"height" : 37,
		"style" : "process",
		"value" : "冷却水流量低"
	} ]
}

var cell4 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 35,
			"to" : 3,
			"from" : 2
		}, {
			"id" : 36,
			"to" : 4,
			"from" : 2
		}, {
			"id" : 37,
			"to" : 5,
			"from" : 2
		}, {
			"id" : 38,
			"to" : 6,
			"from" : 2
		} ],
		"id" : 2,
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
		"id" : 3,
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
		"id" : 4,
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
		"id" : 5,
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
			"to" : 39,
			"from" : 6
		}, {
			"id" : 54,
			"to" : 41,
			"from" : 6
		} ],
		"id" : 6,
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
			"to" : 45,
			"from" : 39
		}, {
			"id" : 50,
			"to" : 46,
			"from" : 39
		} ],
		"id" : 39,
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
			"to" : 47,
			"from" : 41
		}, {
			"id" : 52,
			"to" : 48,
			"from" : 41
		} ],
		"id" : 41,
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
		"id" : 45,
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
		"id" : 46,
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
		"id" : 47,
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
		"id" : 48,
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
		"id" : 1,
		"position" : {
			"x" : 58,
			"y" : 219
		},
		"width" : 105,
		"height" : 34,
		"style" : "process",
		"value" : "冷却水异常"
	}, {
		"outs" : [ {
			"id" : 35,
			"to" : 3,
			"from" : 2
		}, {
			"id" : 36,
			"to" : 4,
			"from" : 2
		}, {
			"id" : 37,
			"to" : 5,
			"from" : 2
		}, {
			"id" : 38,
			"to" : 6,
			"from" : 2
		} ],
		"id" : 2,
		"position" : {
			"x" : 308,
			"y" : 3
		},
		"width" : 149,
		"height" : 40,
		"style" : "subflow",
		"value" : "水泵水轮机"
	}, {
		"outs" : [ {
			"id" : 39,
			"to" : 7,
			"from" : 3
		}, {
			"id" : 40,
			"to" : 13,
			"from" : 3
		} ],
		"id" : 3,
		"position" : {
			"x" : 53,
			"y" : 90
		},
		"width" : 116,
		"height" : 37,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [ {
			"id" : 26,
			"to" : 24,
			"from" : 4
		}, {
			"id" : 27,
			"to" : 25,
			"from" : 4
		} ],
		"id" : 4,
		"position" : {
			"x" : 241,
			"y" : 90
		},
		"width" : 119,
		"height" : 37,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [ {
			"id" : 41,
			"to" : 28,
			"from" : 5
		}, {
			"id" : 42,
			"to" : 29,
			"from" : 5
		}, {
			"id" : 43,
			"to" : 30,
			"from" : 5
		} ],
		"id" : 5,
		"position" : {
			"x" : 382,
			"y" : 90
		},
		"width" : 124,
		"height" : 34,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [ {
			"id" : 54,
			"to" : 48,
			"from" : 6
		}, {
			"id" : 55,
			"to" : 49,
			"from" : 6
		} ],
		"id" : 6,
		"position" : {
			"x" : 571,
			"y" : 90
		},
		"width" : 113,
		"height" : 36,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 10,
			"to" : 1,
			"from" : 7
		}, {
			"id" : 11,
			"to" : 8,
			"from" : 7
		}, {
			"id" : 12,
			"to" : 9,
			"from" : 7
		} ],
		"id" : 7,
		"position" : {
			"x" : 1,
			"y" : 155
		},
		"width" : 100,
		"height" : 44,
		"style" : "subflow",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [],
		"id" : 8,
		"position" : {
			"x" : 61,
			"y" : 291
		},
		"width" : 100,
		"height" : 35,
		"style" : "process",
		"value" : "油系统异常"
	}, {
		"outs" : [],
		"id" : 9,
		"position" : {
			"x" : 55,
			"y" : 360
		},
		"width" : 108,
		"height" : 37,
		"style" : "process",
		"value" : "大轴摆度异常"
	}, {
		"outs" : [ {
			"id" : 19,
			"to" : 14,
			"from" : 13
		}, {
			"id" : 20,
			"to" : 15,
			"from" : 13
		}, {
			"id" : 21,
			"to" : 16,
			"from" : 13
		}, {
			"id" : 22,
			"to" : 17,
			"from" : 13
		}, {
			"id" : 23,
			"to" : 18,
			"from" : 13
		} ],
		"id" : 13,
		"position" : {
			"x" : 123,
			"y" : 155
		},
		"width" : 118,
		"height" : 41,
		"style" : "subflow",
		"value" : "机组振动异常"
	}, {
		"outs" : [],
		"id" : 14,
		"position" : {
			"x" : 184,
			"y" : 219
		},
		"width" : 120,
		"height" : 33,
		"style" : "process",
		"value" : "励磁电流不平衡"
	}, {
		"outs" : [],
		"id" : 15,
		"position" : {
			"x" : 184,
			"y" : 291
		},
		"width" : 120,
		"height" : 34,
		"style" : "process",
		"value" : "剪断销故障"
	}, {
		"outs" : [],
		"id" : 16,
		"position" : {
			"x" : 184,
			"y" : 360
		},
		"width" : 125,
		"height" : 35,
		"style" : "process",
		"value" : "上导摆度异常"
	}, {
		"outs" : [],
		"id" : 17,
		"position" : {
			"x" : 184,
			"y" : 423
		},
		"width" : 125,
		"height" : 31,
		"style" : "process",
		"value" : "下导摆度异常"
	}, {
		"outs" : [],
		"id" : 18,
		"position" : {
			"x" : 184,
			"y" : 500
		},
		"width" : 126,
		"height" : 35,
		"style" : "process",
		"value" : "水导摆度异常"
	}, {
		"outs" : [],
		"id" : 24,
		"position" : {
			"x" : 309,
			"y" : 219
		},
		"width" : 128,
		"height" : 37,
		"style" : "process",
		"value" : "尾水管水位过高"
	}, {
		"outs" : [],
		"id" : 25,
		"position" : {
			"x" : 310,
			"y" : 291
		},
		"width" : 128,
		"height" : 33,
		"style" : "process",
		"value" : "蜗壳故障"
	}, {
		"outs" : [ {
			"id" : 44,
			"to" : 31,
			"from" : 28
		}, {
			"id" : 45,
			"to" : 32,
			"from" : 28
		} ],
		"id" : 28,
		"position" : {
			"x" : 450,
			"y" : 155
		},
		"width" : 107,
		"height" : 44,
		"style" : "subflow",
		"value" : "转动部件故障"
	}, {
		"outs" : [ {
			"id" : 46,
			"to" : 33,
			"from" : 29
		}, {
			"id" : 47,
			"to" : 34,
			"from" : 29
		} ],
		"id" : 29,
		"position" : {
			"x" : 450,
			"y" : 360
		},
		"width" : 107,
		"height" : 42,
		"style" : "subflow",
		"value" : "迷宫环故障"
	}, {
		"outs" : [],
		"id" : 30,
		"position" : {
			"x" : 450,
			"y" : 569
		},
		"width" : 113,
		"height" : 31,
		"style" : "process",
		"value" : "主轴密封"
	}, {
		"outs" : [],
		"id" : 31,
		"position" : {
			"x" : 513,
			"y" : 219
		},
		"width" : 106,
		"height" : 33,
		"style" : "process",
		"value" : "动不平衡"
	}, {
		"outs" : [],
		"id" : 32,
		"position" : {
			"x" : 515,
			"y" : 291
		},
		"width" : 108,
		"height" : 36,
		"style" : "process",
		"value" : "主轴弯曲"
	}, {
		"outs" : [],
		"id" : 33,
		"position" : {
			"x" : 513,
			"y" : 500
		},
		"width" : 123,
		"height" : 34,
		"style" : "process",
		"value" : "迷宫环温度异常"
	}, {
		"outs" : [],
		"id" : 34,
		"position" : {
			"x" : 515,
			"y" : 423
		},
		"width" : 115,
		"height" : 35,
		"style" : "process",
		"value" : "冷却水流量低"
	}, {
		"outs" : [ {
			"id" : 56,
			"to" : 50,
			"from" : 48
		}, {
			"id" : 57,
			"to" : 51,
			"from" : 48
		} ],
		"id" : 48,
		"position" : {
			"x" : 631,
			"y" : 155
		},
		"width" : 110,
		"height" : 40,
		"style" : "subflow",
		"value" : "轴承磨损"
	}, {
		"outs" : [ {
			"id" : 58,
			"to" : 52,
			"from" : 49
		}, {
			"id" : 59,
			"to" : 53,
			"from" : 49
		} ],
		"id" : 49,
		"position" : {
			"x" : 632,
			"y" : 360
		},
		"width" : 109,
		"height" : 42,
		"style" : "subflow",
		"value" : "油膜厚度异常"
	}, {
		"outs" : [],
		"id" : 50,
		"position" : {
			"x" : 690,
			"y" : 219
		},
		"width" : 102,
		"height" : 37,
		"style" : "process",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [],
		"id" : 51,
		"position" : {
			"x" : 690,
			"y" : 291
		},
		"width" : 112,
		"height" : 32,
		"style" : "process",
		"value" : "轴承振摆异常"
	}, {
		"outs" : [],
		"id" : 52,
		"position" : {
			"x" : 690,
			"y" : 423
		},
		"width" : 109,
		"height" : 38,
		"style" : "process",
		"value" : "灭磁开关故障"
	}, {
		"outs" : [],
		"id" : 53,
		"position" : {
			"x" : 690,
			"y" : 500
		},
		"width" : 108,
		"height" : 36,
		"style" : "process",
		"value" : "电源故障"
	} ]
}
