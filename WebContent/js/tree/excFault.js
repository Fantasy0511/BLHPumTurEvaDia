var cell1 = {
	"cells" : [ {
		"outs" : [ {
			"id" : 16,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 17,
			"to" : 22,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 331,
			"y" : 9
		},
		"width" : 132,
		"height" : 40,
		"style" : "subflow",
		"value" : "发电电动机故障"
	}, {
		"outs" : [ {
			"id" : 11,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 12,
			"to" : 312,
			"from" : 21
		}, {
			"id" : 13,
			"to" : 313,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 157,
			"y" : 84
		},
		"width" : 96,
		"height" : 40,
		"style" : "subflow",
		"value" : "机组故障"
	}, {
		"outs" : [ {
			"id" : 14,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 15,
			"to" : 322,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 511,
			"y" : 84
		},
		"width" : 109,
		"height" : 40,
		"style" : "subflow",
		"value" : "励磁系统故障"
	}, {
		"outs" : [ {
			"id" : 24,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 25,
			"to" : 4112,
			"from" : 311
		}, {
			"id" : 26,
			"to" : 4113,
			"from" : 311
		}, {
			"id" : 27,
			"to" : 4114,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : 6,
			"y" : 159
		},
		"width" : 115,
		"height" : 40,
		"style" : "subflow",
		"value" : "发电机过热"
	}, {
		"outs" : [ {
			"id" : 30,
			"to" : 4121,
			"from" : 312
		}, {
			"id" : 31,
			"to" : 4122,
			"from" : 312
		} ],
		"id" : 312,
		"position" : {
			"x" : 153,
			"y" : 159
		},
		"width" : 104,
		"height" : 40,
		"style" : "subflow",
		"value" : "动不平衡"
	}, {
		"outs" : [ {
			"id" : 37,
			"to" : 4131,
			"from" : 313
		}, {
			"id" : 38,
			"to" : 4132,
			"from" : 313
		} ],
		"id" : 313,
		"position" : {
			"x" : 295,
			"y" : 159
		},
		"width" : 101,
		"height" : 40,
		"style" : "subflow",
		"value" : "电磁振动"
	}, {
		"outs" : [ {
			"id" : 40,
			"to" : 4211,
			"from" : 321
		}, {
			"id" : 41,
			"to" : 4212,
			"from" : 321
		}, {
			"id" : 42,
			"to" : 4213,
			"from" : 321
		} ],
		"id" : 321,
		"position" : {
			"x" : 436,
			"y" : 159
		},
		"width" : 109,
		"height" : 40,
		"style" : "subflow",
		"value" : "起励失败"
	}, {
		"outs" : [ {
			"id" : 45,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 46,
			"to" : 4222,
			"from" : 322
		}, {
			"id" : 47,
			"to" : 4223,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 590,
			"y" : 159
		},
		"width" : 114,
		"height" : 40,
		"style" : "subflow",
		"value" : "功率柜故障"
	}, {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : 72,
			"y" : 237
		},
		"width" : 126,
		"height" : 40,
		"style" : "process",
		"value" : "发电机转频过高"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 72,
			"y" : 318
		},
		"width" : 126,
		"height" : 40,
		"style" : "process",
		"value" : "空冷器故障"
	}, {
		"outs" : [],
		"id" : 4113,
		"position" : {
			"x" : 72,
			"y" : 390
		},
		"width" : 126,
		"height" : 40,
		"style" : "process",
		"value" : "转子绝缘损坏"
	}, {
		"outs" : [],
		"id" : 4114,
		"position" : {
			"x" : 71,
			"y" : 466
		},
		"width" : 126,
		"height" : 40,
		"style" : "process",
		"value" : "机端电流过大"
	}, {
		"outs" : [],
		"id" : 4121,
		"position" : {
			"x" : 216,
			"y" : 237
		},
		"width" : 116,
		"height" : 40,
		"style" : "process",
		"value" : "电磁不平衡"
	}, {
		"outs" : [],
		"id" : 4122,
		"position" : {
			"x" : 216,
			"y" : 318
		},
		"width" : 118,
		"height" : 40,
		"style" : "process",
		"value" : "转子质量不平衡"
	}, {
		"outs" : [],
		"id" : 4131,
		"position" : {
			"x" : 356,
			"y" : 237
		},
		"width" : 117,
		"height" : 40,
		"style" : "process",
		"value" : "极频振动"
	}, {
		"outs" : [],
		"id" : 4132,
		"position" : {
			"x" : 356,
			"y" : 318
		},
		"width" : 114,
		"height" : 40,
		"style" : "process",
		"value" : "转频振动"
	}, {
		"outs" : [],
		"id" : 4211,
		"position" : {
			"x" : 501,
			"y" : 237
		},
		"width" : 124,
		"height" : 40,
		"style" : "process",
		"value" : "起励接触器不动"
	}, {
		"outs" : [],
		"id" : 4212,
		"position" : {
			"x" : 501,
			"y" : 318
		},
		"width" : 121,
		"height" : 40,
		"style" : "process",
		"value" : "励磁电源故障"
	}, {
		"outs" : [],
		"id" : 4213,
		"position" : {
			"x" : 501,
			"y" : 390
		},
		"width" : 123,
		"height" : 40,
		"style" : "process",
		"value" : "闭环故障"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 653,
			"y" : 237
		},
		"width" : 127,
		"height" : 40,
		"style" : "process",
		"value" : "电源异常"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 653,
			"y" : 318
		},
		"width" : 124,
		"height" : 40,
		"style" : "process",
		"value" : "风扇故障"
	}, {
		"outs" : [],
		"id" : 4223,
		"position" : {
			"x" : 653,
			"y" : 390
		},
		"width" : 128,
		"height" : 40,
		"style" : "process",
		"value" : "整流桥故障"
	} ]
}
