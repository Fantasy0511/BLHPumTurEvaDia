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
		} ],
		"id" : 1,
		"position" : {
			"x" : 355,
			"y" : 18
		},
		"width" : 180,
		"height" : 58,
		"style" : "subflow",
		"value" : "主变压器故障"
	}, {
		"outs" : [ {
			"id" : 35,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 36,
			"to" : 312,
			"from" : 21
		}, {
			"id" : 37,
			"to" : 313,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 140,
			"y" : 176
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "本体故障"
	}, {
		"outs" : [ {
			"id" : 38,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 39,
			"to" : 32,
			"from" : 22
		}, {
			"id" : 40,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 41,
			"to" : 34,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 664,
			"y" : 176
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "附件故障"
	}, {
		"outs" : [],
		"id" : 4121,
		"position" : {
			"x" : 238,
			"y" : 469
		},
		"width" : 151,
		"height" : 53,
		"style" : "process",
		"value" : "油中气体含量异常"
	}, {
		"outs" : [],
		"id" : 4122,
		"position" : {
			"x" : 237,
			"y" : 609
		},
		"width" : 155,
		"height" : 54,
		"style" : "process",
		"value" : "油成分异常"
	}, {
		"outs" : [],
		"id" : 311,
		"position" : {
			"x" : 20,
			"y" : 311
		},
		"width" : 125,
		"height" : 52,
		"style" : "subflow",
		"value" : "铁芯过热"
	}, {
		"outs" : [ {
			"id" : 42,
			"to" : 4121,
			"from" : 312
		}, {
			"id" : 43,
			"to" : 4122,
			"from" : 312
		} ],
		"id" : 312,
		"position" : {
			"x" : 161,
			"y" : 311
		},
		"width" : 127,
		"height" : 52,
		"style" : "subflow",
		"value" : "绝缘油故障"
	}, {
		"outs" : [],
		"id" : 313,
		"position" : {
			"x" : 301,
			"y" : 311
		},
		"width" : 124,
		"height" : 52,
		"style" : "subflow",
		"value" : "绕组线圈过热"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 460,
			"y" : 310
		},
		"width" : 125,
		"height" : 53,
		"style" : "subflow",
		"value" : "继电器故障"
	}, {
		"outs" : [ {
			"id" : 48,
			"to" : 4231,
			"from" : 323
		}, {
			"id" : 49,
			"to" : 4232,
			"from" : 323
		}, {
			"id" : 50,
			"to" : 4233,
			"from" :323
		}, {
			"id" : 51,
			"to" : 4234,
			"from" : 323
		} ],
		"id" : 323,
		"position" : {
			"x" : 600,
			"y" : 310
		},
		"width" : 125,
		"height" : 52,
		"style" : "subflow",
		"value" : "冷却系统故障"
	}, {
		"outs" : [],
		"id" : 322,
		"position" : {
			"x" : 740,
			"y" : 310
		},
		"width" : 122,
		"height" : 53,
		"style" : "subflow",
		"value" : "温度计故障"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 880,
			"y" : 310
		},
		"width" : 120,
		"height" : 52,
		"style" : "subflow",
		"value" : "套管过热"
	}, {
		"outs" : [],
		"id" : 4231,
		"position" : {
			"x" : 665,
			"y" : 471
		},
		"width" : 149,
		"height" : 53,
		"style" : "process",
		"value" : "冷却器故障"
	}, {
		"outs" : [],
		"id" : 4232,
		"position" : {
			"x" : 817,
			"y" : 471
		},
		"width" : 147,
		"height" : 53,
		"style" : "process",
		"value" : "油流中断"
	}, {
		"outs" : [],
		"id" : 4233,
		"position" : {
			"x" : 657,
			"y" : 608
		},
		"width" : 153,
		"height" : 56,
		"style" : "process",
		"value" : "交流电源故障"
	}, {
		"outs" : [],
		"id" : 4234,
		"position" : {
			"x" : 817,
			"y" : 608
		},
		"width" : 149,
		"height" : 57,
		"style" : "process",
		"value" : "冷却水泄漏报警"
	} ]
}

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
		} ],
		"id" : 1,
		"position" : {
			"x" : 355,
			"y" : 18
		},
		"width" : 180,
		"height" : 58,
		"style" : "subflow",
		"value" : "主变压器故障"
	}, {
		"outs" : [ {
			"id" : 48,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 49,
			"to" : 312,
			"from" : 21
		}, {
			"id" : 50,
			"to" : 313,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 140,
			"y" : 176
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "本体故障"
	}, {
		"outs" : [],
		"id" : 22,
		"position" : {
			"x" : 664,
			"y" : 176
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "附件故障"
	}, {
		"outs" : [],
		"id" : 311,
		"position" : {
			"x" : 90,
			"y" : 342
		},
		"width" : 125,
		"height" : 53,
		"style" : "subflow",
		"value" : "铁芯过热"
	}, {
		"outs" : [ {
			"id" : 51,
			"to" : 4121,
			"from" : 312
		}, {
			"id" : 52,
			"to" : 4122,
			"from" : 312
		} ],
		"id" : 312,
		"position" : {
			"x" : 246,
			"y" : 342
		},
		"width" : 125,
		"height" : 52,
		"style" : "subflow",
		"value" : "绝缘油故障"
	}, {
		"outs" : [],
		"id" : 313,
		"position" : {
			"x" : 409,
			"y" : 342
		},
		"width" : 122,
		"height" : 53,
		"style" : "subflow",
		"value" : "绕组线圈过热"
	}, {
		"outs" : [],
		"id" : 4121,
		"position" : {
			"x" : 136,
			"y" : 500
		},
		"width" : 153,
		"height" : 56,
		"style" : "process",
		"value" : "油中气体含量异常"
	}, {
		"outs" : [],
		"id" : 4122,
		"position" : {
			"x" : 332,
			"y" : 500
		},
		"width" : 149,
		"height" : 57,
		"style" : "process",
		"value" : "油成分异常"
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
		} ],
		"id" : 1,
		"position" : {
			"x" : 355,
			"y" : 18
		},
		"width" : 180,
		"height" : 58,
		"style" : "subflow",
		"value" : "主变压器故障"
	}, {
		"outs" : [],
		"id" : 21,
		"position" : {
			"x" : 140,
			"y" : 176
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "本体故障"
	}, {
		"outs" : [ {
			"id" : 38,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 39,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 40,
			"to" : 323,
			"from" : 22
		}, {
			"id" : 41,
			"to" : 324,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 664,
			"y" : 176
		},
		"width" : 169,
		"height" : 54,
		"style" : "subflow",
		"value" : "附件故障"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 197,
			"y" : 342
		},
		"width" : 125,
		"height" : 53,
		"style" : "subflow",
		"value" : "继电器故障"
	}, {
		"outs" : [ {
			"id" : 48,
			"to" : 4231,
			"from" : 323
		}, {
			"id" : 49,
			"to" : 4232,
			"from" : 323
		}, {
			"id" : 50,
			"to" : 4234,
			"from" : 323
		}, {
			"id" : 51,
			"to" : 4233,
			"from" : 323
		} ],
		"id" : 323,
		"position" : {
			"x" : 390,
			"y" : 342
		},
		"width" : 125,
		"height" : 52,
		"style" : "subflow",
		"value" : "冷却系统故障"
	}, {
		"outs" : [],
		"id" : 322,
		"position" : {
			"x" : 590,
			"y" : 342
		},
		"width" : 122,
		"height" : 53,
		"style" : "subflow",
		"value" : "温度计故障"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 776,
			"y" : 342
		},
		"width" : 120,
		"height" : 52,
		"style" : "subflow",
		"value" : "套管过热"
	}, {
		"outs" : [],
		"id" : 4231,
		"position" : {
			"x" : 509,
			"y" : 506
		},
		"width" : 149,
		"height" : 53,
		"style" : "process",
		"value" : "冷却器故障"
	}, {
		"outs" : [],
		"id" : 4232,
		"position" : {
			"x" : 661,
			"y" : 506
		},
		"width" : 147,
		"height" : 53,
		"style" : "process",
		"value" : "油流中断"
	}, {
		"outs" : [],
		"id" : 4233,
		"position" : {
			"x" : 195,
			"y" : 506
		},
		"width" : 153,
		"height" : 56,
		"style" : "process",
		"value" : "交流电源故障"
	}, {
		"outs" : [],
		"id" : 4234,
		"position" : {
			"x" : 349,
			"y" : 506
		},
		"width" : 149,
		"height" : 57,
		"style" : "process",
		"value" : "冷却水泄漏报警"
	} ]
}
