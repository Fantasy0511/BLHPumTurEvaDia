var cell2 ={
		"cells" : [ {
			"outs" : [],
			"id" : 314,
			"position" : {
				"x" : 338,
				"y" : 150
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "引线故障"
		}, {
			"outs" : [ {
				"id" : 24,
				"to" : 21,
				"from" : 1
			}, {
				"id" : 25,
				"to" : 22,
				"from" : 1
			} ],
			"id" : 1,
			"position" : {
				"x" : 385,
				"y" : 8
			},
			"width" : 135,
			"height" : 36,
			"style" : "subflow",
			"value" : "主变压器故障"
		}, {
			"outs" : [ {
				"id" : 26,
				"to" : 311,
				"from" : 21
			}, {
				"id" : 27,
				"to" : 312,
				"from" : 21
			}, {
				"id" : 28,
				"to" : 313,
				"from" : 21
			}, {
				"id" : 29,
				"to" : 314,
				"from" : 21
			} ],
			"id" : 21,
			"position" : {
				"x" : 112,
				"y" : 79
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "本体故障"
		}, {
			"outs" : [ ],
			"id" : 22,
			"position" : {
				"x" : 697,
				"y" : 79
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "附件故障"
		}, {
			"outs" : [ {
				"id" : 30,
				"to" : 4111,
				"from" : 311
			}, {
				"id" : 31,
				"to" : 4112,
				"from" : 311
			}, {
				"id" : 32,
				"to" : 4113,
				"from" : 311
			} ],
			"id" : 311,
			"position" : {
				"x" : -2,
				"y" : 150
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "铁芯故障"
		}, {
			"outs" : [ {
				"id" : 33,
				"to" : 4121,
				"from" : 312
			}, {
				"id" : 34,
				"to" : 4122,
				"from" : 312
			}, {
				"id" : 35,
				"to" : 4123,
				"from" : 312
			}, {
				"id" : 36,
				"to" : 4124,
				"from" : 312
			}, {
				"id" : 37,
				"to" : 4125,
				"from" : 312
			} ],
			"id" : 312,
			"position" : {
				"x" : 110,
				"y" : 150
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "绕组线圈过热"
		}, {
			"outs" : [ {
				"id" : 38,
				"to" : 4131,
				"from" : 313
			}, {
				"id" : 39,
				"to" : 4132,
				"from" : 313
			} ],
			"id" : 313,
			"position" : {
				"x" : 233,
				"y" : 150
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "绝缘油故障"
		}, {
			"outs" : [],
			"id" : 4111,
			"position" : {
				"x" : 18,
				"y" : 227
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "铁芯多点接地"
		}, {
			"outs" : [],
			"id" : 4112,
			"position" : {
				"x" : 18,
				"y" : 300
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "对地电阻降低"
		}, {
			"outs" : [],
			"id" : 4113,
			"position" : {
				"x" : 18,
				"y" : 371
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "局部过热"
		}, {
			"outs" : [],
			"id" : 4121,
			"position" : {
				"x" : 159,
				"y" : 227
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "绝缘薄弱"
		}, {
			"outs" : [],
			"id" : 4122,
			"position" : {
				"x" : 159,
				"y" : 300
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "大气过电压"
		}, {
			"outs" : [],
			"id" : 4123,
			"position" : {
				"x" : 159,
				"y" : 371
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "操作过电压"
		}, {
			"outs" : [],
			"id" : 4124,
			"position" : {
				"x" : 159,
				"y" : 453
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "检修工艺不良"
		}, {
			"outs" : [],
			"id" : 4125,
			"position" : {
				"x" : 159,
				"y" : 544
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "制作工艺不良"
		}, {
			"outs" : [],
			"id" : 4131,
			"position" : {
				"x" : 308,
				"y" : 227
			},
			"width" : 140,
			"height" : 35,
			"style" : "process",
			"value" : "油中气体含量异常"
		}, {
			"outs" : [],
			"id" : 4132,
			"position" : {
				"x" : 308,
				"y" : 300
			},
			"width" : 140,
			"height" : 35,
			"style" : "process",
			"value" : "油成分异常"
		}]
	}
var cell3 = {
		"cells" : [ {
			"outs" : [ {
				"id" : 24,
				"to" : 21,
				"from" : 1
			}, {
				"id" : 25,
				"to" : 22,
				"from" : 1
			} ],
			"id" : 1,
			"position" : {
				"x" : 385,
				"y" : 8
			},
			"width" : 135,
			"height" : 36,
			"style" : "subflow",
			"value" : "主变压器故障"
		}, {
			"outs" : [],
			"id" : 21,
			"position" : {
				"x" : 112,
				"y" : 79
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "本体故障"
		}, {
			"outs" : [ {
				"id" : 40,
				"to" : 321,
				"from" : 22
			}, {
				"id" : 41,
				"to" : 322,
				"from" : 22
			}, {
				"id" : 42,
				"to" : 323,
				"from" : 22
			}, {
				"id" : 43,
				"to" : 324,
				"from" : 22
			}, {
				"id" : 44,
				"to" : 325,
				"from" : 5
			} ],
			"id" : 22,
			"position" : {
				"x" : 697,
				"y" : 79
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "附件故障"
		}, {
			"outs" : [ {
				"id" : 53,
				"to" : 4231,
				"from" : 323
			}, {
				"id" : 54,
				"to" : 4232,
				"from" : 323
			}, {
				"id" : 55,
				"to" : 4233,
				"from" : 323
			}, {
				"id" : 56,
				"to" : 4234,
				"from" : 323
			} ],
			"id" : 323,
			"position" : {
				"x" : 584,
				"y" : 150
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "冷却系统故障"
		}, {
			"outs" : [],
			"id" : 321,
			"position" : {
				"x" : 464,
				"y" : 150
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "继电器故障"
		}, {
			"outs" : [ {
				"id" : 51,
				"to" : 4221,
				"from" : 322
			}, {
				"id" : 52,
				"to" : 4222,
				"from" : 322
			} ],
			"id" : 322,
			"position" : {
				"x" : 693,
				"y" : 150
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "声响、振动"
		}, {
			"outs" : [],
			"id" : 324,
			"position" : {
				"x" : 799,
				"y" : 150
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "套管过热"
		}, {
			"outs" : [],
			"id" : 325,
			"position" : {
				"x" : 917,
				"y" : 150
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "温度计故障"
		}, {
			"outs" : [],
			"id" : 4232,
			"position" : {
				"x" : 496,
				"y" : 227
			},
			"width" : 140,
			"height" : 35,
			"style" : "process",
			"value" : "进水电动阀故障"
		}, {
			"outs" : [],
			"id" : 4231,
			"position" : {
				"x" : 496,
				"y" : 300
			},
			"width" : 140,
			"height" : 35,
			"style" : "process",
			"value" : "冷却器故障"
		}, {
			"outs" : [],
			"id" : 4233,
			"position" : {
				"x" : 496,
				"y" : 371
			},
			"width" : 140,
			"height" : 35,
			"style" : "process",
			"value" : "交流电源故障"
		}, {
			"outs" : [],
			"id" : 4234,
			"position" : {
				"x" : 496,
				"y" : 453
			},
			"width" : 140,
			"height" : 35,
			"style" : "process",
			"value" : "冷却水泄露报警"
		}, {
			"outs" : [],
			"id" : 4221,
			"position" : {
				"x" : 756,
				"y" : 227
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "密封不良"
		}, {
			"outs" : [],
			"id" : 4222,
			"position" : {
				"x" : 756,
				"y" : 300
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "套管过热"
		} ]
	}
var cell1 = {
	"cells" : [ {
		"outs" : [],
		"id" : 314,
		"position" : {
			"x" : 338,
			"y" : 150
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "引线故障"
	}, {
		"outs" : [ {
			"id" : 24,
			"to" : 21,
			"from" : 1
		}, {
			"id" : 25,
			"to" : 22,
			"from" : 1
		} ],
		"id" : 1,
		"position" : {
			"x" : 385,
			"y" : 8
		},
		"width" : 135,
		"height" : 36,
		"style" : "subflow",
		"value" : "主变压器故障"
	}, {
		"outs" : [ {
			"id" : 26,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 27,
			"to" : 312,
			"from" : 21
		}, {
			"id" : 28,
			"to" : 313,
			"from" : 21
		}, {
			"id" : 29,
			"to" : 314,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 112,
			"y" : 79
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "本体故障"
	}, {
		"outs" : [ {
			"id" : 40,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 41,
			"to" : 322,
			"from" : 22
		}, {
			"id" : 42,
			"to" : 323,
			"from" : 22
		}, {
			"id" : 43,
			"to" : 324,
			"from" : 22
		}, {
			"id" : 44,
			"to" : 325,
			"from" : 5
		} ],
		"id" : 22,
		"position" : {
			"x" : 697,
			"y" : 79
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "附件故障"
	}, {
		"outs" : [ {
			"id" : 30,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 31,
			"to" : 4112,
			"from" : 311
		}, {
			"id" : 32,
			"to" : 4113,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : -2,
			"y" : 150
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "铁芯故障"
	}, {
		"outs" : [ {
			"id" : 33,
			"to" : 4121,
			"from" : 312
		}, {
			"id" : 34,
			"to" : 4122,
			"from" : 312
		}, {
			"id" : 35,
			"to" : 4123,
			"from" : 312
		}, {
			"id" : 36,
			"to" : 4124,
			"from" : 312
		}, {
			"id" : 37,
			"to" : 4125,
			"from" : 312
		} ],
		"id" : 312,
		"position" : {
			"x" : 110,
			"y" : 150
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "绕组线圈过热"
	}, {
		"outs" : [ {
			"id" : 38,
			"to" : 4131,
			"from" : 313
		}, {
			"id" : 39,
			"to" : 4132,
			"from" : 313
		} ],
		"id" : 313,
		"position" : {
			"x" : 233,
			"y" : 150
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "绝缘油故障"
	}, {
		"outs" : [ {
			"id" : 53,
			"to" : 4231,
			"from" : 323
		}, {
			"id" : 54,
			"to" : 4232,
			"from" : 323
		}, {
			"id" : 55,
			"to" : 4233,
			"from" : 323
		}, {
			"id" : 56,
			"to" : 4234,
			"from" : 323
		} ],
		"id" : 323,
		"position" : {
			"x" : 584,
			"y" : 150
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "冷却系统故障"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 464,
			"y" : 150
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "继电器故障"
	}, {
		"outs" : [ {
			"id" : 51,
			"to" : 4221,
			"from" : 322
		}, {
			"id" : 52,
			"to" : 4222,
			"from" : 322
		} ],
		"id" : 322,
		"position" : {
			"x" : 693,
			"y" : 150
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "声响、振动"
	}, {
		"outs" : [],
		"id" : 324,
		"position" : {
			"x" : 799,
			"y" : 150
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "套管过热"
	}, {
		"outs" : [],
		"id" : 325,
		"position" : {
			"x" : 917,
			"y" : 150
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "温度计故障"
	}, {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : 18,
			"y" : 227
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "铁芯多点接地"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 18,
			"y" : 300
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "对地电阻降低"
	}, {
		"outs" : [],
		"id" : 4113,
		"position" : {
			"x" : 18,
			"y" : 371
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "局部过热"
	}, {
		"outs" : [],
		"id" : 4121,
		"position" : {
			"x" : 159,
			"y" : 227
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "绝缘薄弱"
	}, {
		"outs" : [],
		"id" : 4122,
		"position" : {
			"x" : 159,
			"y" : 300
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "大气过电压"
	}, {
		"outs" : [],
		"id" : 4123,
		"position" : {
			"x" : 159,
			"y" : 371
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "操作过电压"
	}, {
		"outs" : [],
		"id" : 4124,
		"position" : {
			"x" : 159,
			"y" : 453
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "检修工艺不良"
	}, {
		"outs" : [],
		"id" : 4125,
		"position" : {
			"x" : 159,
			"y" : 544
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "制作工艺不良"
	}, {
		"outs" : [],
		"id" : 4131,
		"position" : {
			"x" : 308,
			"y" : 227
		},
		"width" : 140,
		"height" : 35,
		"style" : "process",
		"value" : "油中气体含量异常"
	}, {
		"outs" : [],
		"id" : 4132,
		"position" : {
			"x" : 308,
			"y" : 300
		},
		"width" : 140,
		"height" : 35,
		"style" : "process",
		"value" : "油成分异常"
	}, {
		"outs" : [],
		"id" : 4232,
		"position" : {
			"x" : 496,
			"y" : 227
		},
		"width" : 140,
		"height" : 35,
		"style" : "process",
		"value" : "进水电动阀故障"
	}, {
		"outs" : [],
		"id" : 4231,
		"position" : {
			"x" : 496,
			"y" : 300
		},
		"width" : 140,
		"height" : 35,
		"style" : "process",
		"value" : "冷却器故障"
	}, {
		"outs" : [],
		"id" : 4233,
		"position" : {
			"x" : 496,
			"y" : 371
		},
		"width" : 140,
		"height" : 35,
		"style" : "process",
		"value" : "交流电源故障"
	}, {
		"outs" : [],
		"id" : 4234,
		"position" : {
			"x" : 496,
			"y" : 453
		},
		"width" : 140,
		"height" : 35,
		"style" : "process",
		"value" : "冷却水泄露报警"
	}, {
		"outs" : [],
		"id" : 4221,
		"position" : {
			"x" : 756,
			"y" : 227
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "密封不良"
	}, {
		"outs" : [],
		"id" : 4222,
		"position" : {
			"x" : 756,
			"y" : 300
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "套管过热"
	} ]
}