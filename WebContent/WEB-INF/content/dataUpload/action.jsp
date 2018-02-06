<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function upLoad() {
		var url = "/BLHPumTurEvaDia/dataUpload/excelToDb";
		$.post(url, function(data) {
			alert(data);
		});
	}
	$(function() {
	})
</script>
<body>
	<s:form action="excelToDb" method="POST" enctype="multipart/form-data">
		<s:textfield name="fileName" label="文件名" maxlength="20" />
		<s:file name="excel" label="选择Excel文件" />
		<s:submit name="sumbit" value="Submit" />
	</s:form>

</body>
</html>
