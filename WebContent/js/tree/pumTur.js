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
				"x" : 386,
				"y" : 7
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "水泵水轮机"
		}, {
			"outs" : [ {
				"id" : 18,
				"to" : 311,
				"from" : 21
			}, {
				"id" : 31,
				"to" : 312,
				"from" : 21
			} ],
			"id" : 21,
			"position" : {
				"x" : 50,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "水导故障"
		}, {
			"outs" : [],
			"id" : 22,
			"position" : {
				"x" : 270,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "过流部件故障"
		}, {
			"outs" : [],
			"id" : 23,
			"position" : {
				"x" : 480,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "轴系故障"
		}, {
			"outs" : [],
			"id" : 24,
			"position" : {
				"x" : 710,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "推力轴承故障"
		}, {
			"outs" : [ {
				"id" : 47,
				"to" : 4111,
				"from" : 311
			}, {
				"id" : 48,
				"to" : 4112,
				"from" : 311
			}, {
				"id" : 49,
				"to" : 4113,
				"from" : 311
			}, {
				"id" : 50,
				"to" : 4114,
				"from" : 311
			}, {
				"id" : 51,
				"to" : 4115,
				"from" : 311
			}, {
				"id" : 52,
				"to" : 4116,
				"from" : 311
			}, {
				"id" : 53,
				"to" : 4117,
				"from" : 311
			}, {
				"id" : 54,
				"to" : 4118,
				"from" : 311
			}, {
				"id" : 55,
				"to" : 4119,
				"from" : 311
			}, {
				"id" : 56,
				"to" : 4120,
				"from" : 311
			}, {
				"id" : 57,
				"to" : 4121,
				"from" : 311
			} ],
			"id" : 311,
			"position" : {
				"x" : 0,
				"y" : 140
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "轴瓦温度异常"
		},  {
			"outs" : [],
			"id" : 312,
			"position" : {
				"x" : 103,
				"y" : 140
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "水导摆度异常"
		}, {
			"outs" : [],
			"id" : 4111,
			"position" : {
				"x" : 49,
				"y" : 221
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "冷却水流量低"
		}, {
			"outs" : [],
			"id" : 4112,
			"position" : {
				"x" : 168,
				"y" : 221
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "冷却水水温高"
		}, {
			"outs" : [],
			"id" : 4113,
			"position" : {
				"x" : 292,
				"y" : 221
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "冷却水水压异常"
		}, {
			"outs" : [],
			"id" : 4114,
			"position" : {
				"x" : 49,
				"y" : 310
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "油系统油压低"
		}, {
			"outs" : [],
			"id" : 4115,
			"position" : {
				"x" : 168,
				"y" : 310
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "油系统油位异常"
		}, {
			"outs" : [],
			"id" : 4116,
			"position" : {
				"x" : 292,
				"y" : 310
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "油系统油温高"
		}, {
			"outs" : [],
			"id" : 4117,
			"position" : {
				"x" : 49,
				"y" : 403
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "油系统油混水"
		}, {
			"outs" : [],
			"id" : 4118,
			"position" : {
				"x" : 168,
				"y" : 403
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "大轴摆度异常"
		}, {
			"outs" : [],
			"id" : 4119,
			"position" : {
				"x" : 292,
				"y" : 403
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "轴承振动异常"
		}, {
			"outs" : [],
			"id" : 4120,
			"position" : {
				"x" : 49,
				"y" : 496
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "轴承密封损坏"
		}, {
			"outs" : [],
			"id" : 4121,
			"position" : {
				"x" : 168,
				"y" : 496
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "机组转速过高"
		}]
	}
var cell2 ={
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
				"x" : 386,
				"y" : 7
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "水泵水轮机"
		}, {
			"outs" : [ ],
			"id" : 21,
			"position" : {
				"x" : 50,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "水导故障"
		}, {
			"outs" : [ {
				"id" : 32,
				"to" : 321,
				"from" : 22
			}, {
				"id" : 33,
				"to" : 322,
				"from" : 22
			} ],
			"id" : 22,
			"position" : {
				"x" : 270,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "过流部件故障"
		}, {
			"outs" : [ ],
			"id" : 23,
			"position" : {
				"x" : 480,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "轴系故障"
		}, {
			"outs" : [],
			"id" : 24,
			"position" : {
				"x" : 710,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "推力轴承故障"
		},   {
			"outs" : [],
			"id" : 321,
			"position" : {
				"x" : 216,
				"y" : 140
			},
			"width" : 113,
			"height" : 35,
			"style" : "process",
			"value" : "尾水管水位过高"
		}, {
			"outs" : [],
			"id" : 322,
			"position" : {
				"x" : 328,
				"y" : 140
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "蜗壳故障"
		}]
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
				"x" : 386,
				"y" : 7
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "水泵水轮机"
		}, {
			"outs" : [],
			"id" : 21,
			"position" : {
				"x" : 50,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "水导故障"
		}, {
			"outs" : [],
			"id" : 22,
			"position" : {
				"x" : 280,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "过流部件故障"
		}, {
			"outs" : [ {
				"id" : 122,
				"to" : 331,
				"from" : 23
			}, {
				"id" : 123,
				"to" : 332,
				"from" : 23
			} ],
			"id" : 23,
			"position" : {
				"x" : 480,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "轴系故障"
		}, {
			"outs" : [],
			"id" : 24,
			"position" : {
				"x" : 710,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "推力轴承故障"
		}, {
			"outs" : [ {
				"id" : 71,
				"to" : 4311,
				"from" : 331
			}, {
				"id" : 72,
				"to" : 4312,
				"from" : 331
			}, {
				"id" : 73,
				"to" : 4313,
				"from" : 331
			}, {
				"id" : 74,
				"to" : 4314,
				"from" : 331
			}, {
				"id" : 75,
				"to" : 4315,
				"from" : 331
			}, {
				"id" : 76,
				"to" : 4316,
				"from" : 331
			}, {
				"id" : 77,
				"to" : 4317,
				"from" : 331
			}, {
				"id" : 78,
				"to" : 4318,
				"from" : 331
			}, {
				"id" : 79,
				"to" : 4319,
				"from" : 331
			} ],
			"id" : 331,
			"position" : {
				"x" : 434,
				"y" : 140
			},
			"width" : 100,
			"height" : 35,
			"style" : "subflow",
			"value" : "机组振动异常"
		}, {
			"outs" : [ {
				"id" : 69,
				"to" : 4321,
				"from" : 332
			}, {
				"id" : 70,
				"to" : 4322,
				"from" : 332
			} ],
			"id" : 332,
			"position" : {
				"x" : 554,
				"y" : 140
			},
			"width" : 104,
			"height" : 35,
			"style" : "subflow",
			"value" : "迷宫环故障"
		}, {
			"outs" : [],
			"id" : 4311,
			"position" : {
				"x" : 473,
				"y" : 221
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "上导摆度异常"
		}, {
			"outs" : [],
			"id" : 4312,
			"position" : {
				"x" : 746,
				"y" : 314
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "下导摆度异常"
		}, {
			"outs" : [],
			"id" : 4313,
			"position" : {
				"x" : 473,
				"y" : 403
			},
			"width" : 110,
			"height" : 40,
			"style" : "process",
			"value" : "动不平衡"
		}, {
			"outs" : [],
			"id" : 4314,
			"position" : {
				"x" : 473,
				"y" : 496
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "主轴弯曲"
		}, {
			"outs" : [],
			"id" : 4315,
			"position" : {
				"x" : 746,
				"y" : 403
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "磁拉力不平衡"
		}, {
			"outs" : [],
			"id" : 4316,
			"position" : {
				"x" : 473,
				"y" : 314
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "上机架振动异常"
		}, {
			"outs" : [],
			"id" : 4317,
			"position" : {
				"x" : 602,
				"y" : 314
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "下机架振动异常"
		}, {
			"outs" : [],
			"id" : 4318,
			"position" : {
				"x" : 602,
				"y" : 403
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "尾水管压力脉动"
		}, {
			"outs" : [],
			"id" : 4319,
			"position" : {
				"x" : 602,
				"y" : 496
			},
			"width" : 120,
			"height" : 35,
			"style" : "process",
			"value" : "定子绕组固定不良"
		}, {
			"outs" : [],
			"id" : 4321,
			"position" : {
				"x" : 602,
				"y" : 221
			},
			"width" : 130,
			"height" : 35,
			"style" : "process",
			"value" : "迷宫环温度异常"
		}, {
			"outs" : [],
			"id" : 4322,
			"position" : {
				"x" : 746,
				"y" : 221
			},
			"width" : 140,
			"height" : 35,
			"style" : "process",
			"value" : "迷宫环冷却水流量低"
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
				"x" : 386,
				"y" : 7
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "水泵水轮机"
		}, {
			"outs" : [],
			"id" : 21,
			"position" : {
				"x" : 50,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "水导故障"
		}, {
			"outs" : [],
			"id" : 22,
			"position" : {
				"x" : 280,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "过流部件故障"
		}, {
			"outs" : [ ],
			"id" : 23,
			"position" : {
				"x" : 480,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "轴系故障"
		}, {
			"outs" : [ {
				"id" : 27,
				"to" : 341,
				"from" : 24
			}, {
				"id" : 37,
				"to" : 342,
				"from" : 24
			} ],
			"id" : 24,
			"position" : {
				"x" : 710,
				"y" : 75
			},
			"width" : 120,
			"height" : 35,
			"style" : "subflow",
			"value" : "推力轴承故障"
		}, {
			"outs" : [],
			"id" : 342,
			"position" : {
				"x" : 767,
				"y" : 140
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "轴承磨损"
		}, {
			"outs" : [],
			"id" : 341,
			"position" : {
				"x" : 665,
				"y" : 140
			},
			"width" : 110,
			"height" : 35,
			"style" : "process",
			"value" : "油膜厚度异常"
		}   ]
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
			"x" : 386,
			"y" : 7
		},
		"width" : 120,
		"height" : 35,
		"style" : "subflow",
		"value" : "水泵水轮机"
	}, {
		"outs" : [ {
			"id" : 18,
			"to" : 311,
			"from" : 21
		}, {
			"id" : 31,
			"to" : 312,
			"from" : 21
		} ],
		"id" : 21,
		"position" : {
			"x" : 50,
			"y" : 75
		},
		"width" : 120,
		"height" : 35,
		"style" : "subflow",
		"value" : "水导故障"
	}, {
		"outs" : [ {
			"id" : 32,
			"to" : 321,
			"from" : 22
		}, {
			"id" : 33,
			"to" : 322,
			"from" : 22
		} ],
		"id" : 22,
		"position" : {
			"x" : 270,
			"y" : 75
		},
		"width" : 120,
		"height" : 35,
		"style" : "subflow",
		"value" : "过流部件故障"
	}, {
		"outs" : [ {
			"id" : 122,
			"to" : 331,
			"from" : 23
		}, {
			"id" : 123,
			"to" : 332,
			"from" : 23
		} ],
		"id" : 23,
		"position" : {
			"x" : 480,
			"y" : 75
		},
		"width" : 120,
		"height" : 35,
		"style" : "subflow",
		"value" : "轴系故障"
	}, {
		"outs" : [ {
			"id" : 27,
			"to" : 341,
			"from" : 24
		}, {
			"id" : 37,
			"to" : 342,
			"from" : 24
		} ],
		"id" : 24,
		"position" : {
			"x" : 710,
			"y" : 75
		},
		"width" : 120,
		"height" : 35,
		"style" : "subflow",
		"value" : "推力轴承故障"
	}, {
		"outs" : [ {
			"id" : 47,
			"to" : 4111,
			"from" : 311
		}, {
			"id" : 48,
			"to" : 4112,
			"from" : 311
		}, {
			"id" : 49,
			"to" : 4113,
			"from" : 311
		}, {
			"id" : 50,
			"to" : 4114,
			"from" : 311
		}, {
			"id" : 51,
			"to" : 4115,
			"from" : 311
		}, {
			"id" : 52,
			"to" : 4116,
			"from" : 311
		}, {
			"id" : 53,
			"to" : 4117,
			"from" : 311
		}, {
			"id" : 54,
			"to" : 4118,
			"from" : 311
		}, {
			"id" : 55,
			"to" : 4119,
			"from" : 311
		}, {
			"id" : 56,
			"to" : 4120,
			"from" : 311
		}, {
			"id" : 57,
			"to" : 4121,
			"from" : 311
		} ],
		"id" : 311,
		"position" : {
			"x" : 0,
			"y" : 140
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "轴瓦温度异常"
	}, {
		"outs" : [ {
			"id" : 71,
			"to" : 4311,
			"from" : 331
		}, {
			"id" : 72,
			"to" : 4312,
			"from" : 331
		}, {
			"id" : 73,
			"to" : 4313,
			"from" : 331
		}, {
			"id" : 74,
			"to" : 4314,
			"from" : 331
		}, {
			"id" : 75,
			"to" : 4315,
			"from" : 331
		}, {
			"id" : 76,
			"to" : 4316,
			"from" : 331
		}, {
			"id" : 77,
			"to" : 4317,
			"from" : 331
		}, {
			"id" : 78,
			"to" : 4318,
			"from" : 331
		}, {
			"id" : 79,
			"to" : 4319,
			"from" : 331
		} ],
		"id" : 331,
		"position" : {
			"x" : 434,
			"y" : 140
		},
		"width" : 100,
		"height" : 35,
		"style" : "subflow",
		"value" : "机组振动异常"
	}, {
		"outs" : [ {
			"id" : 69,
			"to" : 4321,
			"from" : 332
		}, {
			"id" : 70,
			"to" : 4322,
			"from" : 332
		} ],
		"id" : 332,
		"position" : {
			"x" : 554,
			"y" : 140
		},
		"width" : 104,
		"height" : 35,
		"style" : "subflow",
		"value" : "迷宫环故障"
	}, {
		"outs" : [],
		"id" : 342,
		"position" : {
			"x" : 767,
			"y" : 140
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "轴承磨损"
	}, {
		"outs" : [],
		"id" : 321,
		"position" : {
			"x" : 216,
			"y" : 140
		},
		"width" : 113,
		"height" : 35,
		"style" : "process",
		"value" : "尾水管水位过高"
	}, {
		"outs" : [],
		"id" : 322,
		"position" : {
			"x" : 328,
			"y" : 140
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "蜗壳故障"
	}, {
		"outs" : [],
		"id" : 312,
		"position" : {
			"x" : 103,
			"y" : 140
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "水导摆度异常"
	}, {
		"outs" : [],
		"id" : 4111,
		"position" : {
			"x" : 49,
			"y" : 221
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "冷却水流量低"
	}, {
		"outs" : [],
		"id" : 4112,
		"position" : {
			"x" : 168,
			"y" : 221
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "冷却水水温高"
	}, {
		"outs" : [],
		"id" : 341,
		"position" : {
			"x" : 665,
			"y" : 140
		},
		"width" : 100,
		"height" : 35,
		"style" : "process",
		"value" : "油膜厚度异常"
	}, {
		"outs" : [],
		"id" : 4113,
		"position" : {
			"x" : 292,
			"y" : 221
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "冷却水水压异常"
	}, {
		"outs" : [],
		"id" : 4114,
		"position" : {
			"x" : 49,
			"y" : 310
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "油系统油压低"
	}, {
		"outs" : [],
		"id" : 4115,
		"position" : {
			"x" : 168,
			"y" : 310
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "油系统油位异常"
	}, {
		"outs" : [],
		"id" : 4116,
		"position" : {
			"x" : 292,
			"y" : 310
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "油系统油温高"
	}, {
		"outs" : [],
		"id" : 4117,
		"position" : {
			"x" : 49,
			"y" : 403
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "油系统油混水"
	}, {
		"outs" : [],
		"id" : 4118,
		"position" : {
			"x" : 168,
			"y" : 403
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "大轴摆度异常"
	}, {
		"outs" : [],
		"id" : 4119,
		"position" : {
			"x" : 292,
			"y" : 403
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "轴承振动异常"
	}, {
		"outs" : [],
		"id" : 4120,
		"position" : {
			"x" : 49,
			"y" : 496
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "轴承密封损坏"
	}, {
		"outs" : [],
		"id" : 4121,
		"position" : {
			"x" : 168,
			"y" : 496
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "机组转速过高"
	}, {
		"outs" : [],
		"id" : 4311,
		"position" : {
			"x" : 473,
			"y" : 221
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "上导摆度异常"
	}, {
		"outs" : [],
		"id" : 4312,
		"position" : {
			"x" : 746,
			"y" : 314
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "下导摆度异常"
	}, {
		"outs" : [],
		"id" : 4313,
		"position" : {
			"x" : 473,
			"y" : 403
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "动不平衡"
	}, {
		"outs" : [],
		"id" : 4314,
		"position" : {
			"x" : 473,
			"y" : 496
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "主轴弯曲"
	}, {
		"outs" : [],
		"id" : 4315,
		"position" : {
			"x" : 746,
			"y" : 403
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "磁拉力不平衡"
	}, {
		"outs" : [],
		"id" : 4316,
		"position" : {
			"x" : 473,
			"y" : 314
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "上机架振动异常"
	}, {
		"outs" : [],
		"id" : 4317,
		"position" : {
			"x" : 602,
			"y" : 314
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "下机架振动异常"
	}, {
		"outs" : [],
		"id" : 4318,
		"position" : {
			"x" : 602,
			"y" : 403
		},
		"width" : 110,
		"height" : 35,
		"style" : "process",
		"value" : "尾水管压力脉动"
	}, {
		"outs" : [],
		"id" : 4319,
		"position" : {
			"x" : 602,
			"y" : 496
		},
		"width" : 120,
		"height" : 35,
		"style" : "process",
		"value" : "定子绕组固定不良"
	}, {
		"outs" : [],
		"id" : 4321,
		"position" : {
			"x" : 602,
			"y" : 221
		},
		"width" : 130,
		"height" : 35,
		"style" : "process",
		"value" : "迷宫环温度异常"
	}, {
		"outs" : [],
		"id" : 4322,
		"position" : {
			"x" : 746,
			"y" : 221
		},
		"width" : 140,
		"height" : 35,
		"style" : "process",
		"value" : "迷宫环冷却水流量低"
	} ]
}