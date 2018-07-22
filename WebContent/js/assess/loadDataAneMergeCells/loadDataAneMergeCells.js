/**
 * @param id,data,system,unitNo
 *            填写地址，数据，系统，机组号
 * @param 填充表格并且合并了该合并的单元格
 *         
 * @param by:贾天龙 2018.7.22
 */

function loadDataAneMergeCells(id, data,system,unitNo) {
	var data = _convert(data);
	$('#' + id).datagrid({
		data : data,                         // 这里的data的格式得是js对象，不能是json字符串
		onLoadSuccess : function(data) {
			// 水泵水轮机的合并单元格
			if (system == "pum") {
				if (unitNo == "first" || unitNo == "four") {
					var index1 = 0;
					var rowspan1 = 4;
					var index2 = 4;
					var rowspan2 = 6;
					var index3 = 10;
					var rowspan3 = 8;
					
				} else {
					var index1 = 0;
					var rowspan1 = 4;
					var index2 = 4;
					var rowspan2 = 10;
					var index3 = 14;
					var rowspan3 = 6;
				}
			};
			// 调速器的合并单元格
			if (system == "gov") {
					var index1 = 0;
					var rowspan1 = 5;
					var index2 = 5;
					var rowspan2 = 3;
					var index3 = "";
					var rowspan3 = "";
			};
			// 球阀的合并单元格
			if (system == "ball") {
				var index1 = 0;
				var rowspan1 = 3;
				var index2 = 3;
				var rowspan2 = 3;
				var index3 = "";
				var rowspan3 = "";
		    };
		    // 励磁的合并单元格
		    if (system == "exc") {
		    	if (unitNo == "first") {
				var index1 = 0;
				var rowspan1 = 3;
				var index2 = 3;
				var rowspan2 = 3;
				var index3 = 6;
				var rowspan3 = 3;
				var index4 = 9;
				var rowspan4 = 3;
				var index5 = 12;
				var rowspan5 = 2;
		    	} else {
		    		var index1 = 0;
					var rowspan1 = 3;
					var index2 = 3;
					var rowspan2 = 2;
					var index3 = 5;
					var rowspan3 = 3;
					var index4 = 8;
					var rowspan4 = 3;
					var index5 = 11;
					var rowspan5 = 2;
				}
		    };
		    // 主变的合并单元格
		    if (system == "transfer") {
				var index1 = 0;
				var rowspan1 = 3;
				var index2 = 3;
				var rowspan2 = 3;
		    };
				
		
			var merges = [ {          // name列的某几个格合并为一个单元格）
				index : index1,        // 从第'index1'行开始
				rowspan : rowspan1   // 向下合并'rowspan1'行
			
			}, {
				index : index2,
				rowspan : rowspan2
			}, {
				index : index3,
				rowspan : rowspan3
			},{
				index : index4,
				rowspan : rowspan4
			},{
				index : index5,
				rowspan : rowspan5
			} ];
			for (var i = 0; i < merges.length; i++) {
				$('#result_table').datagrid('mergeCells', {
					index : merges[i].index,
					field : 'category',
					rowspan : merges[i].rowspan
				});
			}
		}
	});

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