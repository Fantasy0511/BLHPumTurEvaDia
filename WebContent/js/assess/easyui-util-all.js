/**
 * 对easyui及常用功能的封装。
 * <p>
 * 依赖：jQuery、easyui、lodash、DownloadFileAction（后台）、Table（后台）、StringInputActionSupport（后台）、StringOutputActionSupport（后台）
 * </p>
 * 
 * @author hx
 */

var ACTION_SUCCESS = 0;
var ACTION_FAILED = 1;
var LOGIN_REQUIRED = 2;
var DB_CONNECTION_TIMEOUT = 3;


/*
 * EasyUI 的date选择框格式设置
 */

function myformatter(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
			+ (d < 10 ? ('0' + d) : d);
}
function myparser(s) {
	if (!s)
		return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0], 10);
	var m = parseInt(ss[1], 10);
	var d = parseInt(ss[2], 10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
		return new Date(y, m - 1, d);
	} else {
		return new Date();
	}
}

/**
 * 模拟java的MessageFormat.format方法。如: <code>
 * var str = "I am {0}";
 * var out = str.format("hx");
 * console.assert(out == "I am hx"); 
 * </code>
 */
String.prototype.format = function(/* ... */) {
	var args = arguments;
	return this.replace(/\{(\d+)\}/g, function(m, i) {
		return args[i];
	});
}

function S(id) {
	var result = $("#" + id);
	if (result.length != 1) {
		throw new ConventionError(id);
	}
	return result;
}

/**
 * 约定大于配置错误。当方法的使用不满足预先的约定时，抛出此错误。注意这里使用lodash继承Error.prototype。
 * 
 * @param key
 *            违反约定的键
 */
function ConventionError(key) {
	this.name = "convention error";
	this.message = "against convention error for key: " + key;
}
ConventionError.prototype = _.create(Error.prototype, {
	'constructor' : ConventionError
});

/**
 * 接收可变长参数。
 * 
 * @returns 合成的用来配合StringInputActionSupport的输入参数
 */
function makeInput(/* ... */) {
	var inputs = arguments;
	var result = "?inputStr=";
	for ( var i in inputs) {
		var input = inputs[i];
		if (_.isArray(input)) {
			input = concat(input, ",");
		}
		result += input + "//";
	}
	return result.substring(0, result.length - 2);
}

function concat(array, separator) {
	var result = "";
	for ( var i in array) {
		result += array[i] + separator;
	}
	return result.substring(0, result.length - separator.length);
}

/**
 * @param date
 *            js的日期对象
 * @returns {String}符合hhhh-mm-dd格式的日期字符串。
 */
function formatDate(date) {
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
			+ date.getDate();
}

/**
 * 禁止网页中图片的默认事件响应处理方式。
 */
function forbidImg() {
	$("img").each(function() {
		var _this = $(this);
		_this.on("dragstart", function() {
			return false;
		});
		_this.on("contextmenu", function() {
			return false;
		});
		_this.on("selectstart", function() {
			return false;
		});
	});
}

/**
 * 解决easyui在嵌套tabs的情况下出现的样式bug。
 */
function _fixbug() {
	$(".panel-header").css("height", "16px");
	$(".panel-header").css("width", "");
	$(".panel-body").css("width", "");
	$(".datagrid-cell-group").css("width", "");
}

/**
 * 右下角消息弹框。
 * 
 * @param message
 *            通知消息
 * @param duration
 *            消息显示持续的毫秒数
 */
function showMessage(message, duration) {
	if (duration && duration <= 100) {
		return;
	}
	if ((!message) || (message == "")) {
		return;
	}
	if (!arguments[1]) {
		duration = 700;
	}
	$.messager.show({
		title : '通知',
		msg : message,
		timeout : duration,
		showType : 'slide'
	});
}

/**
 * 删除easyui datagrid的若干行数据，当其列columnName等于value的时候。删除一行注意使用值唯一的列。
 * 
 * @param tableSelector
 *            table选择器
 * @param columnName
 *            列名
 * @param value
 *            值
 */
function deleteRow(tableSelector, columnName, value) {
	var table = $(tableSelector);
	var rows = table.datagrid("getRows");
	var row;
	for ( var i in rows) {
		row = rows[i];
		if (row[columnName] === value) {
			break;
		}
	}
	var idx = table.datagrid("getRowIndex", row);
	table.datagrid("deleteRow", idx);
}

function selectRow(tableId, idx) {
	if (hasRows(tableId)) {
		var count = countRows(tableId);
		if (count >= 0 && idx < count - 1) {
			S(tableId).datagrid("selectRow", idx);
		}
	}
}

function hasRows(tableId) {
	return countRows(tableId) > 0;
}

function countRows(tableId) {
	var rows = S(tableId).datagrid("getRows");
	if (!rows) {
		return 0;
	}
	return rows.length;
}

function getRowData(tableId, rowIdx) {
	var result = null;
	var count = countRows(tableId);
	if (rowIdx >= 0 && rowIdx < count) {
		result = getRows(tableId)[rowIdx];
	}
	return result;
}

function getSelectedRow(tableId) {
	return S(tableId).datagrid("getSelected");
}

function getRows(tableId) {
	return S(tableId).datagrid("getRows");
}

function makeOperationTable(url, tableId, queryIt, deleteIt) {
	var success = function(data) {
		var infos = data.historyInfos;
		var rows = _convert(infos).rows;
		for ( var i in rows) {
			var row = rows[i];
			var operation = row.operation;
			var html = '<button class="operation_query" \
				style="margin-right:10px" value="'
					+ operation
					+ '">查询</button><button class="operation_delete" \
				style="margin-right:10px"'
					+ ' value="' + operation + '">删除</button>';
			row.operation = html;
		}
		$("#" + tableId).datagrid("loadData", rows);
		$(".operation_query").each(function() {
			$(this).click(function() {
				var operation = $(this).val();
				queryIt(operation);
			});
		});
		$(".operation_delete").each(function() {
			$(this).click(function() {
				var operation = $(this).val();
				deleteIt(operation);
			});
		});
	};
	getJSON(url, success);
}

/**
 * convention-over-configuration。参见conventionHelper。
 * 
 * @param data
 * @param prefix
 */
function setTexts(data, prefix) {
	if (!prefix) {
		prefix = "text_";
	}
	selector = "input[id^='{0}']".format(prefix);
	var callback = function(container, value) {
		container.textbox("setValue", value);
	}
	conventionHelper(data, selector, prefix, callback);
}

function getTexts(prefix) {
	if (!prefix) {
		prefix = "text_";
	}
	selector = "input[id^='{0}']".format(prefix);
	var result = {};
	var callback = function(container, key) {
		if (container && container.textbox()) {
			result[key] = container.textbox("getValue");
		}
	}
	conventionHelper(null, selector, prefix, callback);
	return result;
}

/**
 * convention-over-configuration。约定：后台传来的json符合camel
 * case，如someText、someChart，前台标签的id符合snake
 * case。并且前缀符合命名约定，即如：text_some_text、chart_some_chart。此时，使用后台的值处理标签，或者使用标签得到值传到后台。
 * 
 * @param data
 *            json数据，或者null。当为json时处理后台传来的数据（见setTexts方法），当为null时从前台获得待处理的数据（见getSVGs方法）。
 * @param selector
 *            页面选择器
 * @param prefix
 *            元素id的前缀
 * @param callback
 *            对每个对应的值进行处理的回调函数。callback(container,value) when
 *            data!=null;callback(container,kye)。其中，value为data里映射而来的数据，key为由id生成的后台需要的camelCase键。
 */
function conventionHelper(data, selector, prefix, callback) {
	var containers = $(selector);
	containers.each(function() {
		var container = $(this);
		var id = container.attr("id");
		if (_.startsWith(id, prefix)) {
			var trimed = _.replace(id, prefix, "");
			var key = _.camelCase(trimed);
			var value = null;
			if (data != null) {
				value = data[key];
			} else {
				value = key;
			}
			if (!_.isUndefined(value) && !_.isNull(value)) {
				callback(container, value, id);
			}
		} else {
			throw new ConventionError(id);
		}
	});
}

/**
 * @param data
 *            后台传来的json数据，含有符合combobox数据格式的对象数组
 * @param prefix
 *            匹配前台的snake_case的id的前缀，除去前缀的部分被转换为camelCase的名称并与对象data中的key相对应。<br/>
 *            如：select_some_data，则必有data["someData"]，与后台的ComboboxItem
 *            bean的数组转换成的json想一致。
 */
function fillCombobox(data, prefix) {
	if (!prefix) {
		prefix = "combobox_";
	}
	selector = "select[id^='{0}']".format(prefix);
	var callback = function(container, value) {
		container.combobox({
			valueField : "value",
			textField : "text",
			data : value,
			editable : false,
		});
		container.combobox("select", "-1");
	}
	conventionHelper(data, selector, prefix, callback);
}

function setText(id, value) {
	var text = $("#" + id);
	if (!value) {
		return function(value) {
			text.textbox("setValue", value);
		}
	}
	text.textbox("setValue", value);
}

function getText(id) {
	return $("#" + id).textbox("getValue");
}

function setDate(id, date) {
	$("#" + id).datebox("setValue", date);
}

function getDate(id) {
	return $("#" + id).datebox("getValue");
}

/**
 * @returns {String}yyyy-mm-dd for today
 */
function getTodayDate() {
	return formatDate(new Date());
}

/**
 * @returns {String} yyyy-mm-dd上个星期的今天的日期字符串。
 */
function getLastTodayDate() {
	var lastTodayMillis = new Date().getTime() - 7 * 24 * 60 * 60 * 1000;
	var lastToday = new Date();
	lastToday.setTime(lastTodayMillis);
	return formatDate(lastToday);
}

/**
 * @param id
 *            easyui combobox的id
 * @returns combobox当前选中值。
 */
function getComboboxValue(id) {
	return $("#" + id).combobox("getValue");
}

function setComboboxValue(id, value) {
	$("#" + id).combobox("setValue", value);
}

/**
 * 在样式上使button有效
 * 
 * @param selector
 *            easyui button的选择器。
 */
function enableButton(selector) {
	if (!selector) {
		selector = ".easyui-linkbutton";
	}
	$(selector).each(function() {
		$(this).linkbutton("enable");
	});
}

/**
 * 在样式上禁用button。但是并不会禁用button的功能，所以要在事件处理函数中加入逻辑判断当前按钮是否可用。
 * 
 * @param selector
 */
function disableButton(selector) {
	if (!selector) {
		selector = ".easyui-linkbutton";
	}
	$(selector).each(function() {
		$(this).linkbutton("disable");
	});
}

/**
 * 清空textbox的数据。
 * 
 * @param selector
 *            textbox选择器
 */
function clearText(selector) {
	if (!selector) {
		selector = ".easyui-textbox";
	}
	$(selector).each(function() {
		$(this).textbox("setValue", "");
	});
}

/**
 * 关闭当前标签页
 * 
 * @param selector
 *            标签选择器，默认为"#tabs"。
 */
function closeCurrentTab(selector) {
	if (!selector) {
		selector = "#tabs";
	}
	var tabs = $(selector);
	var selected = tabs.tabs("getSelected");
	var idx = tabs.tabs("getTabIndex", selected);
	if (idx != 0) {
		tabs.tabs("close", idx);
	}
}

/**
 * 解析后台数据中的outoutStr输出，配合后台
 * 
 * @param data
 *            后台传来的json数据
 * @returns
 */
function output(data) {
	var outputStr = data.outputStr;
	if (_.isString(outputStr)) {
		return outputStr.split("//");
	}
	return null;
}

/**
 * 解析后台传来的outputStr并展示消息。一般是数据库查询结果信息、数据库错误信息、业务程序错误信息等。
 * 
 * @param data
 *            后台传来的json数据
 * @return 结果码
 */
function _resultCode(data) {
	var out = output(data);
	if (out) {
		return parseInt(out[0]);
	}
	return ACTION_SUCCESS;
}

/**
 * @param data
 *            后台返回的结果。
 * @returns 结果中包含的字符串信息。
 */
function _message(data) {
	var message = null;
	var out = output(data);
	if (out) {
		message = out[1];
	}
	return message;
}

/**
 * @param data
 *            后台返回的结果。
 * @param errorCode
 *            错误码
 * @returns {Boolean} 是否发生了某种错误。
 */
function _isError(data, errorCode) {
	var code = _resultCode(data);
	if (code == errorCode) {
		return true;
	}
	return false;
}

/**
 * action发生错误。
 */
function hasActionError(data) {
	return _isError(data, ACTION_FAILED);
}

/**
 * 需要登录。
 */
function hasLoginError(data) {
	return _isError(data, LOGIN_REQUIRED);
}

function hasDBConnectionError(data) {
	return _isError(data, DB_CONNECTION_TIMEOUT);
}

/**
 * 无错误。
 */
function hasNoError(data) {
	return _isError(data, ACTION_SUCCESS);
}

/**
 * 错误处理的统一手段。
 * 
 * @param data
 *            后台返回的数据
 * @param callback
 *            回调函数。成功：success；失败：fail；需要登录：relogin。
 */
function handleError(data, callback, hide) {
	if (_.isUndefined(hide)) {
		hide = true;
	}
	var message = _message(data);
	if (!callback) {
		callback = {};
	}
	if (_.isFunction(callback)) {
		var success = callback;
		callback = {};
		callback.success = success;
	} else if (_.isObject(callback)) {
		if (!(callback.relogin)) {
			callback.relogin = function(data) {
				if (message) {
					_rootWindow().location.href = _message(data);
				}
			};
		}
	}
	if (!(callback.success)) {
		callback.success = function(data) {
		};
	}
	if (!(callback.fail)) {
		callback.fail = function(data) {
		};
	}
	var duration = 3000;
	if (hasNoError(data)) {
		duration = 700;
		callback.success(data);
	} else if (hasLoginError(data)) {
		duration = 0;
		callback.relogin(data);
	} else if (hasActionError(data)) {
		callback.fail(data);
	} else if (hasDBConnectionError(data)) {
		hideMask();
	}
	expandAccordion();
	_fixbug();
	if (hide) {
		hideMask();
	}
	showMessage(message, duration);
}

/**
 * 封装json，后台配合StringOutputActionSupport使用，解析后台执行action传回的信息，并在前台做相应的处理。<br/>
 * 做测试，测试网络连接是否通畅，测试数据库连接是否正常。
 * 
 * @param url
 *            后台action的url
 * @param callback
 *            回调函数，参见handleError。
 */
function getJSON(url, callback, checkConn) {
	if (_.isUndefined(checkConn)) {
		// checkConn = true;
		checkConn = false;
	}
	// var testUrl = "/HPPumTurReg/test-connection";
	var timeout = true;
	var success = function() {
		$.getJSON(url, function(data) {
			handleError(data, callback);
		});
	}
	if (checkConn) {
		var testConn = $.getJSON(testUrl, function(data) {
			timeout = false;
			handleError(data, success, false);
		});
		setTimeout(function() {
			if (timeout) {
				testConn.abort();
				hideMask();
				showMessage("网络连接异常，请检查网络连接！");
			}
		}, 8000);
	} else {
		success();
	}
}

function post(url, data, callback) {
	$.post(url, data, function(data) {
		handleError(data, callback);
	});
}

/**
 * @returns 根window对象，在iframe中使用可以找到根父页面的window对象。
 */
function _rootWindow() {
	var result = null;
	var w = window;
	while (!(w.parent === w)) {
		w = w.parent;
	}
	return w;
}

/**
 * 展开手风琴。
 * 
 * @param selector
 *            手风琴控件选择器
 */
function expandAccordion(selector) {
	if (!selector) {
		selector = ".easyui-accordion";
	}
	var accordion = $(selector);
	if (accordion) {
		accordion.each(function(i) {
			var count = $(this).accordion("panels").length;
			for (var c = 0; c < count; c = c + 1) {
				$(this).accordion("getPanel", c).panel("expand");
			}
		});
	}
}

function collapseAccordion(selector) {
	if (!selector) {
		selector = ".easyui-accordion";
	}
	var accordion = $(selector);
	if (accordion) {
		accordion.each(function(i) {
			var count = $(this).accordion("panels").length;
			for (var c = 0; c < count; c = c + 1) {
				$(this).accordion("getPanel", c).panel("collapse");
			}
		});
	}
}

function expandAccordionWithIdx(idx, selector) {
	if (!selector) {
		selector = ".easyui-accordion";
	}
	if ($(selector).length > 1) {
		throw new Error("too many accordion");
	}
	$(selector).accordion("getPanel", idx).panel("expand");
}

function collapseAccordionWithIdx(idx, selector) {
	if (!selector) {
		selector = ".easyui-accordion";
	}
	if ($(selector).length > 1) {
		throw new Error("too many accordion");
	}
	$(selector).accordion("getPanel", idx).panel("collapse");
}

/**
 * 抽取数据。 完成如下列例子的转换：
 * {"rows":[{"row":{"row":{"name":"hx"}}},{"row":{"row":{"name":"zxy","age":"24"}}}]}
 * 转换为： {rows:[{"name":"hx"},{"name":"zxy","age":"24"}]}
 * 
 * @param data
 *            由RowTable类的getData()方法转为json格式后传来的传来的数据。
 */
function _convert(data) {
	var result = {};
	result['rows'] = []
	var rows = data.rows;
	for ( var i in rows) {
		result['rows'].push(rows[i]['row']['row']);
	}
	return result;
}

/**
 * @param id
 *            easyui table的id
 * @param data
 *            后台传来的Table类映射而来的json数据
 */
function loadData(id, data) {
	$('#' + id).datagrid('loadData', _convert(data));
}

var mask_id = "_mask";
var mask_id_selector = "#" + mask_id;
var mask_open = false;/* true for open, false for closed */

$(function() {
	if (!$(mask_id_selector)) {
		throw new Error("name collapse! change a new mask_id");
	}
	var html = '<div id="'
			+ mask_id
			+ '" style="width: 300px; height: 150px; padding: 10px; background-color: #EBEBEB;">\
			<table style="margin-left: 45px; margin-top: 30px">\
			<tr><td><img alt="waiting..." src="/BLHPumTurEvaDia/images/waiting.gif" \
			style="width: 48px; height: 48px;" /></td><td><div>处理中，请稍候...</div>\
			</td></tr></table></div>'
	$("body").append(html);
	$(mask_id_selector).window({
		title : "",
		modal : true,
		closed : true,
		closable : false,
		draggable : false,
		collapsible : false,
		minimizable : false,
		maximizable : false
	});
	$(".window-shadow").remove();
});

/**
 * 调整遮罩的位置。
 * 
 * @param obj
 */
function arrangeLocation(obj) {
	var w = $(window).width();
	var h = $(window).height();
	var mwidth = 300, mheight = 150;
	var top = (h - mheight) / 2;
	top = top < 0 ? 0 : top;
	var left = (w - mwidth) / 2;
	obj.css("top", top + "px");
	obj.css("left", left + "px");
}

/**
 * 展示遮罩，屏蔽前台的无效操作。
 */
function showMask() {
	if (!mask_open) {
		$(mask_id_selector).window("open");
		arrangeLocation($(mask_id_selector).parent());
		mask_open = true;
	}
}

/**
 * 隐藏遮罩。业务完成，页面已更新。
 */
function hideMask() {
	if (mask_open) {
		$(mask_id_selector).window("close");
		mask_open = false;
	}
}

var previewer_div = "_previewerDiv";
var previewer_div_selector = "#" + previewer_div;
var previewer_id = "_previewer";
var previewer_name = "_previewer";
var previewer_selector = "#" + previewer_id;

$(function() {
	if (!$(previewer_id)) {
		throw new Error("name collapse! change a new previewer_id");
	}
	var html = '<div id="{0}" class="easyui-window" title="打印预览"\
			style="width: 800px; height: 450px; padding: 10px; overflow: hidden">\
			<iframe id="{1}" name="{2}"\
				style="width: 100%; height: 100%; border: none"></iframe></div>';
	$("body").append(html.format(previewer_div, previewer_id, previewer_name));
	$(previewer_div_selector).window({
		modal : true,
		closed : true
	});
});

/**
 * @param url
 *            后台生成报表action的url
 * @param postData
 *            发送到后台的数据
 */
function previewPage(url, postData) {
	showMask();
	$.post(url, postData, function(data) {
		var path = data.htmlPath;
		if (!data) {
			showMessage("生成报告失败，请重试！", 2000);
		} else {
			window.frames[previewer_name].location.href = path;
			arrangeLocation($(previewer_selector).parent())
			$(previewer_div_selector).window('open');
		}
		hideMask();
	});
}

/**
 * @param url
 *            下载后台文件，如生成的pdf。
 * @param postData
 *            发送到后台的数据
 */
function exportPdfFile(url, postData) {
	showMask();
	$.post(url, postData, function(data) {
		handleError(data, function(data) {
			var path = data.pdfPath;
			var down = "/HPPumTurReg/util/download-file?filePath=" + path;
			window.open(down);
			hideMask();
		});
	});
}
