<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springMVC 测试</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
</head>
<body>
<h2>success!</h2>

<a href="#/test1">test1</a>
<a href="#/test2">test2</a>
<a href="#/test3">test3</a>

<div id="hello"></div>

<button onclick="download();">下载</button>

<form action="upload.do" enctype="multipart/form-data" method="post">
	<input type="file" name="file">
	<input type="submit" name="提交">
</form>

<script type="text/javascript" src="${ctx}/libs/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/libs/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="${ctx}/libs/FileSaver.min.js"></script>
<script type="text/javascript">
function download(){
	var blob=new Blob(["account,,,账户表,用户的账户信息,","\r\n"," 参数,参数名称,字段类型,备注,必输,默认值"],{type: "text/plain;charset=UTF-8"});
	saveAs(blob,"test.csv");
}
</script>
</body>
</html>