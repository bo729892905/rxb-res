尊敬的用户你好：
用户名：${user};
URL：${url};
姓名：${name}

<#--定义answer-->
<#assign answer=42/>
原:${answer}
字符串:${answer?string}
数字:${answer?string.number}
货币:${answer?string.currency}
百分比${answer?string.percent}

${.now?string("yyyy-MM-dd HH:mm:ss zzzz")} <#--2016-02-01 11:45:49 中国标准时间-->
${.now?string("EEE, MMM d, yy")}<#--星期一, 二月 1, 16-->
${.now?string("EEEE, MMMM dd, yyyy, hh:mm:ss a '('zzz')'")}<#--星期一, 二月 01, 2016, 11:47:10 上午 (CST)-->

<#--处理可能存在的空值使用"!"-->
${other!"default"}
<#if other??>default</#if>

<#--mX:小数部分最小X位;MX:小数部分最大X位-->
<#assign x=2.582/>
<#assign y=4/>
#{x; M2} <#-- 输出2.58 -->
#{y; M2} <#-- 输出4 -->
#{x; m1} <#-- 输出2.6 -->
#{y; m2} <#-- 输出4.00 -->
#{x; m1M2} <#-- 输出2.58 -->
#{y; m1M2} <#-- 输出4.0 -->

<#--FreeMarker表达式中完全支持算术运算,FreeMarker支持的算术运算符包括:+, - , * , / -->
<#assign x=5>
${ x * x - 100 }
${ x /2 }
${ 12 %10 }
<#--使用+运算符时,如果一边是数字,一边是字符串,就会自动将数字转换为字符串再连接-->
${x+"5"}<#--55-->

<#-- 内建函数 -->
<#assign test=" tom & JERRY <bob> ">
${test?html}<#-- tom &amp; JERRY &lt;bob&gt; -->
${test?cap_first}<#-- Tom & JERRY <bob> -->
${test?lower_case}<#-- tom & jerry <bob> -->
${test?upper_case}<#-- TOM & JERRY <BOB> -->
${test?trim}<#--tom & JERRY <bob>-->

<#--include语法:
<#include filename [options]>
filename:指定被包含的模板文件
options:可以省略,指定包含时的选项,包含encoding和parse两个选项
        encoding指定包含页面时所用的解码集
        parse指定被包含文件是否作为FTL文件来解析,如果省略了parse选项值,则该选项默认是true.-->
解析(默认)：<#include "hello.ftl" parse="true">
不解析：<#include "hello.ftl" parse="false">

<#--import指令用于导入FreeMarker模板中的所有变量,并将该变量放置在指定的Map对象中-->
<#import "hello.ftl" as imp>
${imp.hello}

<#--noparse指令指定FreeMarker不处理该指定里包含的内容-->
<#noparse>
${imp.hello}
</#noparse>

<#--escape指令导致body区的插值都会被自动加上escape表达式-->
<#--以下等同于test:${test?html}-->
<#escape x as x?html>
test:${test}</#escape>

<#--escape可以嵌套使用-->
<#assign map={"key":"id","value":20,"data":{"name":"tom"}}>
<#escape x as x?cap_first>
    <#escape x as map[x]>
        ${"key"}
        ${"value"}
    </#escape>
</#escape>

<#--macro可以用于实现自定义指令-->
<#macro book type booklist >
${type}
<#list booklist as bookname>
    ${bookname}
</#list>
</#macro>
<@book booklist=["spring","j2ee"] type="java" />