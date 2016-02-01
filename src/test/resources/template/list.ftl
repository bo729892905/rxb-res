<#-- 集合以方括号包括,各集合元素之间以英文逗号","分隔 -->
<#list ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"] as item>
${item_index+1}.${item}<#if item_has_next>;<#else>.</#if>
</#list>

<#--集合运算符是将两个集合连接成一个新的集合,连接集合的运算符是"+"-->
<#list ["星期一","星期二","星期三"] + ["星期四","星期五","星期六","星期天"] as x>
<#if x="星期六"><#break></#if>
${x}
</#list>

<#-- 集合元素也可以是表达式 -->
<#list [2 + 2, 5/3, "whatnot"] as item>
${item}
</#list>

<!--可以使用数字范围定义数字集合,如2..5等同于[2, 3, 4, 5],却比后者更有效率-->
<#list 3..-1 as item>
${item}
</#list>

<#list itemList as item>
${item}
</#list>
${itemList[0]}