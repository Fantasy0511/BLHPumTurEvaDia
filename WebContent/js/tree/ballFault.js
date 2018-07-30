
var cell1 = {
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
			"to" :23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 355,
			"y" : 18
		},
		"width" : 180,
		"height" : 58,
		"style" : "subflow",
		"value" : "球阀系统故障"
	}, {
		"outs" : [ {
			"id" : 16,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 19,
			"to" : 312,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 8,
			"y" : 149
		},
		"width" : 170,
		"height" : 54,
		"style" : "subflow",
		"value" : "球阀本体故障"
	}, {
		"outs" : [ {
			"id" : 20,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 21,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 22,
			"to" : 323,
			"from" : 22
		}, {
			"id" : 23,
			"to" : 324,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 361,
			"y" : 146
		},
		"width" : 168,
		"height" : 54,
		"style" : "subflow",
		"value" : "球阀油压部分故障"
	}, {
		"outs" : [ {
			"id" : 17,
			"to" : 331,
			"from" :23
		}, {
			"id" : 18,
			"to" : 332,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 664,
			"y" : 149
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "电气控制部分故障"
	}, {
		"outs" : [],
		"id" : 312,
		"position" : {
			"x" : 112,
			"y" : 587
		},
		"width" : 154,
		"height" : 50,
		"style" : "process",
		"value" : "球阀关闭时间"
	}, {
		"outs" : [],
		"id" : 311,
		"position" : {
			"x" : 114,
			"y" : 405
		},
		"width" : 150,
		"height" : 52,
		"style" : "process",
		"value" : "球阀开启时间"
	}, {
		"outs" : [],
		"id" : 331,
		"position" : {
			"x" : 774,
			"y" : 406
		},
		"width" : 154,
		"height" : 54,
		"style" : "process",
		"value" : "球阀未正常开启"
	}, {
		"outs" : [],
		"id" : 332,
		"position" : {
			"x" : 774,
			"y" : 586
		},
		"width" : 157,
		"height" : 55,
		"style" : "process",
		"value" : "球阀未正常关闭"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 111,
			"y" : 249
		},
		"width" : 155,
		"height" : 51,
		"style" : "subflow",
		"value" : "漏油箱油位异常"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 29,
			"to" : 4223,
			"from" : 322
		}, {
			"id" : 30,
			"to" : 4222,
			"from" : 322
		}, {
			"id" : 31,
			"to" :4224,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 277,
			"y" : 249
		},
		"width" : 150,
		"height" : 52,
		"style" : "subflow",
		"value" : "压力油罐故障"
	}, {
		"outs" : [],
		"id" : 323,
		"position" : {
			"x" : 436,
			"y" : 249
		},
		"width" : 147,
		"height" : 51,
		"style" : "subflow",
		"value" : "主油循环回路异常"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 597,
			"y" : 249
		},
		"width" : 147,
		"height" : 51,
		"style" : "subflow",
		"value" : "集油箱油位异常"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 355,
			"y" : 407
		},
		"width" : 151,
		"height" : 52,
		"style" : "process",
		"value" : "油压偏高"
	}, {
		"outs" : [],
		"id" :4222,
		"position" : {
			"x" : 556,
			"y" : 407
		},
		"width" : 149,
		"height" : 53,
		"style" : "process",
		"value" : "油压偏低"
	}, {
		"outs" : [],
		"id" : 4223,
		"position" : {
			"x" : 355,
			"y" : 585
		},
		"width" : 151,
		"height" : 53,
		"style" : "process",
		"value" : "油位偏高"
	}, {
		"outs" : [],
		"id" :4224,
		"position" : {
			"x" : 553,
			"y" : 585
		},
		"width" : 155,
		"height" : 54,
		"style" : "process",
		"value" : "油位偏低"
	} ]
}

var cell2 = {
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
			"to" :23,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 355,
			"y" : 18
		},
		"width" : 180,
		"height" : 58,
		"style" : "subflow",
		"value" : "球阀系统故障"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 29,
			"to" : 312,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 49,
			"y" : 176
		},
		"width" : 170,
		"height" : 54,
		"style" : "subflow",
		"value" : "球阀本体故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 361,
			"y" : 173
		},
		"width" : 168,
		"height" : 54,
		"style" : "subflow",
		"value" : "球阀油压部分故障"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 664,
			"y" : 176
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "电气控制部分故障"
	}, {
		"outs" : [],
		"id" : 311,
		"position" : {
			"x" : 157,
			"y" : 356
		},
		"width" : 151,
		"height" : 53,
		"style" : "process",
		"value" : "球阀开启时间"
	}, {
		"outs" : [],
		"id" : 312,
		"position" : {
			"x" : 157,
			"y" : 460
		},
		"width" : 155,
		"height" : 54,
		"style" : "process",
		"value" : "球阀关闭时间"
	} ]
}

var cell3 = {
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
			"x" : 355,
			"y" : 18
		},
		"width" : 180,
		"height" : 58,
		"style" : "subflow",
		"value" : "球阀系统故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 28,
			"y" : 149
		},
		"width" : 170,
		"height" : 54,
		"style" : "subflow",
		"value" : "球阀本体故障"
	}, {
		"outs" : [ {
			"id" : 20,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 21,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 22,
			"to" : 323,
			"from" :22
		}, {
			"id" : 23,
			"to" : 324,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 361,
			"y" : 146
		},
		"width" : 168,
		"height" : 54,
		"style" : "subflow",
		"value" : "球阀油压部分故障"
	}, {
		"outs" : [],
		"id" : 23,
		"position" : {
			"x" : 664,
			"y" : 149
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "电气控制部分故障"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 67,
			"y" : 317
		},
		"width" : 155,
		"height" : 51,
		"style" : "subflow",
		"value" : "漏油箱油位异常"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 4224,
			"from" : 322
		}, {
			"id" : 29,
			"to" : 4223,
			"from" : 322
		}, {
			"id" : 30,
			"to" : 4221,
			"from" :322
		}, {
			"id" : 31,
			"to" : 4222,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 272,
			"y" : 317
		},
		"width" : 150,
		"height" : 52,
		"style" : "subflow",
		"value" : "压力油罐故障"
	}, {
		"outs" : [],
		"id" : 323,
		"position" : {
			"x" : 480,
			"y" : 317
		},
		"width" : 147,
		"height" : 51,
		"style" : "subflow",
		"value" : "主油循环回路异常"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 675,
			"y" : 317
		},
		"width" : 147,
		"height" : 51,
		"style" : "subflow",
		"value" : "集油箱油位异常"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 410,
			"y" : 490
		},
		"width" : 151,
		"height" : 52,
		"style" : "process",
		"value" : "油压偏高"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 586,
			"y" : 490
		},
		"width" : 149,
		"height" : 53,
		"style" : "process",
		"value" : "油压偏低"
	}, {
		"outs" : [],
		"id" : 4223,
		"position" : {
			"x" : 58,
			"y" : 490
		},
		"width" : 151,
		"height" : 53,
		"style" : "process",
		"value" : "油位偏高"
	}, {
		"outs" : [],
		"id" : 4224,
		"position" : {
			"x" : 229,
			"y" : 490
		},
		"width" : 155,
		"height" : 54,
		"style" : "process",
		"value" : "油位偏低"
	} ]
}
var cell4 = {
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
			"x" : 355,
			"y" : 18
		},
		"width" : 180,
		"height" : 58,
		"style" : "subflow",
		"value" : "球阀系统故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 49,
			"y" : 176
		},
		"width" : 170,
		"height" : 54,
		"style" : "subflow",
		"value" : "球阀本体故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 361,
			"y" : 173
		},
		"width" : 168,
		"height" : 54,
		"style" : "subflow",
		"value" : "球阀油压部分故障"
	}, {
		"outs" : [ {
			"id" : 28,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 29,
			"to" : 332,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 664,
			"y" : 176
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "电气控制部分故障"
	}, {
		"outs" : [],
		"id" : 331,
		"position" : {
			"x" : 754,
			"y" : 353
		},
		"width" : 151,
		"height" : 53,
		"style" : "process",
		"value" : "球阀未正常开启"
	}, {
		"outs" : [],
		"id" : 332,
		"position" : {
			"x" : 757,
			"y" : 476
		},
		"width" : 155,
		"height" : 54,
		"style" : "process",
		"value" : "球阀未正常关闭"
	} ]
}

