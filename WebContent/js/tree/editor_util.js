/*
 * css格式
 * var css = {
 *	styleName : 'styleName', //images.js文件中对应的样式图标
 *	basicStyle : { //基本的样式
 *		shape : 'arc',
 *		resizable : false
 *	},
 *	size : {//组件的大小
 *		width : 10,
 *		height : 10
 *	}
 *};
 *
 * 外部依赖配置,和styleName相挂钩。详见images.js
 * images
 * */

function TreeEditor(option) {
	jmEditor.call(this, option);
	this.commonStyle = this._commonStyle();
	this.comps = [];
	this._initialEditor();
}

jmUtils.extend(TreeEditor, jmEditor);

// api
// 手动添加预定义组件的api
TreeEditor.prototype.addStart = function(x, y, value) {
	return this._addCell(x, y, this._startCss(), value);
};

TreeEditor.prototype.addProcess = function(x, y, value) {
	return this._addCell(x, y, this._processCss(), value);
};

TreeEditor.prototype.drawComponentsPanel = function(divId) {
	var self = this;
	_drawList(divId, function(ul) {
		var _this = self;
		for (i in _this.comps) {
			var li = document.createElement('li');
			li.appendChild(_this.comps[i]);
			ul.appendChild(li);
		}
	});
};

TreeEditor.prototype.drawToolPanel = function(divId) {
	var self = this;
	_drawList(divId, function(ul) {
		var _this = self;

		var btZoomOut = document.createElement('button');
		btZoomOut.innerHTML = "缩小";
		btZoomOut.onclick = function() {
			_this.execute('zoomOut');
		}
		ul.appendChild(btZoomOut);

		var btZoomIn = document.createElement('button');
		btZoomIn.innerHTML = "放大";
		btZoomIn.onclick = function() {
			_this.execute('zoomIn');
		}
		ul.appendChild(btZoomIn);

		var btZoomActual = document.createElement('button');
		btZoomActual.innerHTML = "复原";
		btZoomActual.onclick = function() {
			_this.execute('zoomActual');
		}
		ul.appendChild(btZoomActual);

		var btLeft = document.createElement('button');
		btLeft.innerHTML = "左对齐";
		btLeft.onclick = function() {
			_this.align('left');
		}
		ul.appendChild(btLeft);

		var btCenter = document.createElement('button');
		btCenter.innerHTML = "水平居中";
		btCenter.onclick = function() {
			_this.align('center');
		}
		ul.appendChild(btCenter);

		var btRight = document.createElement('button');
		btRight.innerHTML = "右对齐";
		btRight.onclick = function() {
			_this.align('right');
		}
		ul.appendChild(btRight);

		var btTop = document.createElement('button');
		btTop.innerHTML = "顶部对齐";
		btTop.onclick = function() {
			_this.align('top');
		}
		ul.appendChild(btTop);

		var btMiddle = document.createElement('button');
		btMiddle.innerHTML = '垂直居中';
		btMiddle.onclick = function() {
			_this.align('middle');
		}
		ul.appendChild(btMiddle);

		var btBottom = document.createElement('button');
		btBottom.innerHTML = '底部对齐';
		btBottom.onclick = function() {
			_this.align('bottom');
		}
		ul.appendChild(btBottom);

		var btUndo = document.createElement('button');
		btUndo.innerHTML = "撤销";
		btUndo.onclick = function() {
			_this.execute('undo');
		}
		ul.appendChild(btUndo);

		var btRedo = document.createElement('button');
		btRedo.innerHTML = '重做';
		btRedo.onclick = function() {
			_this.execute('redo');
		}
		ul.appendChild(btRedo);
	});
}

TreeEditor.prototype._initialEditor = function() {
	this._regComponents();
	this._regEvents();
};

TreeEditor.prototype._regComponents = function() {
	this._regComp(this._startCss(),{
		fill : "#6666cc"
	});
	this._regComp(this._processCss(), {
		fill : "red"
	});
	this._regComp(this._switchCss());
	this._regComp(this._forkCss());
	this._regComp(this._joinCss());
	this._regComp(this._subflowCss(), {
		fill : "red"
	});
	this._regComp(this._uploadCss());
	this._regComp(this._endCss());
	this._regComp(this._downloadCss());
};

TreeEditor.prototype._regComp = function(css, selectedExtraStyle) {
	this._regStyle(css.styleName, css.basicStyle, selectedExtraStyle);
	var component = this._regComponent(images[css.styleName], css);
	this.comps.push(component);
};

TreeEditor.prototype._regStyle = function(styleName, style, selectedExtraStyle) {
	if (!selectedExtraStyle) {
		selectedExtraStyle = {};
	}
	var thisStyle = _appendProp(this.commonStyle, style);
	this.regStyle(styleName, thisStyle);
	this.regStyle(styleName + '_selected', _appendProp(thisStyle,
			selectedExtraStyle));
};

TreeEditor.prototype._regComponent = function(img, css) {
	return this.regComponent(img, {
		width : css.size.width,
		height : css.size.height,
		style : css.styleName,
		value : css.value
	});
};

// 注册事件
TreeEditor.prototype._regEvents = function() {
	this.on('select', function(cell, selected) {
		if (cell.is('jmCell')) {
			var stylename = cell.option.style;
			var _index = stylename.indexOf('_');
			if (_index > 0) {
				stylename = stylename.substring(0, _index);
			}
			cell.setStyle(selected ? stylename + '_selected' : stylename);
		}
	});
};

/**
 * 手动添加api
 * 
 * @returns 新部件
 */
TreeEditor.prototype._addCell = function(x, y, css, value) {
	return this.addCell({
		position : {
			x : x,
			y : y
		},
		width : css.size.width,
		height : css.size.height,
		style : css.styleName,
		value : value
	});
};

// 各种样式的设置
/**
 * bean css
 * 
 * @param styleName
 *            样式名
 * @param extendedStyle
 *            样式bean
 * @param size
 *            部件size
 */
TreeEditor.prototype._css = function(styleName, extendedStyle, size, value) {
	return {
		styleName : styleName,
		size : size,
		basicStyle : _appendProp(this.commonStyle, extendedStyle),
		value : value
	};
}

/**
 * @returns 基本样式
 */
TreeEditor.prototype._commonStyle = function() {
	var bg = jmGraph.prototype.createLinearGradient(0, 0, 0, '100%');
	bg.addColorStop(0, '#6666cc');
	bg.addColorStop(0.5, '#6666cc');
	bg.addColorStop(1, '#6666cc');

	var style = {
		stroke : '#000',
		fill : '#6666cc',
//		lineWidth : 1,
		close : true,
		lineJoin : 'round',
		radius : 6,
		resizable : true,
		zIndex : 1000
	};
	style.connectLine = {
		stroke : '#6666cc',
		normalStroke : '#6666cc',
		overStroke : 'red',
		selectedStroke : 'red',
		lineWidth : 2,
		zIndex : 100,
		fontStyle : {
			fill : 'green',
			textAlign : 'center'
		}
	};
	style.borderStyle = {
		stroke : '#6666cc',
		rectStroke : '#6666cc', // 放大缩小小方块颜色
		fill:'#6666cc',
		close : true
	};
	// style.shadow = jmGraph.prototype.createShadow(0, 0, 10, '#000');
	style.fontStyle = {
		
		textAlign : 'center',
		textBaseline : 'middle',
		font : '14px SimHei',
		fill: 'white'
	};
	style.overlay = {// 状态小图标样式
		margin : {
			left : 10,
			top : 10
		}
	};
	return style;
};

TreeEditor.prototype._startCss = function() {
	var size = _size(60, 60);
	var style = {
		resizable : false,
		shape : 'arc'
	};
	return this._css('start', style, size, 'start');
};

TreeEditor.prototype._processCss = function() {
	var size = _size(100, 80);
	var style = {
		shape : 'arc',
		fill:'#6666cc'
	};
	return this._css('process', style, size, 'process');
};

TreeEditor.prototype._forkCss = function() {
	var size = _size(100, 40);
	var style = {
		fill : '#6666cc',
		resizable : false,
		shape : 'rect'
	};
	return this._css('fork', style, size, 'fork');
};

TreeEditor.prototype._switchCss = function() {
	var size = _size(100, 50);
	var style = {
		shape : 'prismatic'
	};
	return this._css('switch', style, size, 'switch');
};

TreeEditor.prototype._joinCss = function() {
	var size = _size(100, 50);
	var style = {
		shape : 'arc'
	};
	return this._css('join', style, size, 'join');
};

TreeEditor.prototype._subflowCss = function() {
	var size = _size(100, 80);
	var style = {
		fill : '#6666cc',
		resizable : true,
		shape : 'rect'
	};
	return this._css('subflow', style, size, 'subflow');
};

TreeEditor.prototype._uploadCss = function() {
	var size = _size(100, 80);
	var style = {
		resizable : true,
		shape : 'img',
		fill:'#6666cc',
		image : images.upload,
		width : 120,
		height : 80,
	};
	return this._css('upload', style, size, 'upload');
};

TreeEditor.prototype._downloadCss = function() {
	var size = _size(45, 45);
	var style = {
		shape : 'img',
		image : images.download
	};
	return this._css('download', style, size, 'download');
};

TreeEditor.prototype._endCss = function() {
	var size = _size(60, 60);
	var style = {
		close : true,
		lineWidth : 1,
		connectable : false,
		fill : '#6666cc',
		shape : 'harc',
		maxRadius : 30,
		minRadius : 20
	};
	return this._css('end', style, size, 'end');
};

// helper function
/**
 * 给bean添加新属性
 * 
 * @param obj
 * @param props
 * @returns
 */
function _appendProp(obj, props) {
	var result = jmUtils.clone(obj);
	for (x in props) {
		if (x) {
			result[x] = props[x];
		} else {
			continue;
		}
	}
	return result;
}

function _drawList(divId, callback) {
	var div = document.getElementById(divId);
	var ul = document.createElement('ul');
	callback && callback(ul);
	div.appendChild(ul);
}

/**
 * bean size.
 * 
 * @param width
 *            部件宽
 * @param height
 *            部件长
 */
function _size(width, height) {
	return {
		width : width,
		height : height,
	};
}
