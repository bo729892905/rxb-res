<html>
<head>
    <title>FreeMarker Example Web Application 1</title>
</head>
<body>
${name}
<#list itemList as item>
    <a href="${item}.html">${item}<a>|
</#list>
</body>
</html>