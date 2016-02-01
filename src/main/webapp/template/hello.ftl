<html>
<head>
    <title>FreeMarker Example Web Application 1</title>
</head>
<body>
你好，${user.username},${name}
<#list itemList as item>
    <a href="${item}.html">${item}<a>|
</#list>
</body>
</html>