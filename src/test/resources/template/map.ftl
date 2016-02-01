<#assign map={"key":"id","value":20,"data":{"name":"tom"}}>
<#-- map?keys 将map的key取出赋值 -->
<#assign  keys=map?keys>
<#-- 遍历key值 -->
<#list keys as key>
<#if key!="data">
${key}:${map[key]}
</#if>
</#list>
data.name:${map["data"].name}

<#--Map对象的连接运算符也是将两个Map对象连接成一个新的Map对象,Map对象的连接运算符是+,如果两个Map对象具有相同的key,则右边的值替代左边的值-->
<#assign scores = {"语文":86,"数学":78} + {"数学":87,"Java":93}>
语文成绩是${scores.语文}
数学成绩是${scores.数学}
Java成绩是${scores.Java}

${user.name}
${user.data.age}
${user.data["birthday"]?datetime}
${user.data["birthday"]?string("yyyy-MM-dd HH:mm:ss zzzz")}
