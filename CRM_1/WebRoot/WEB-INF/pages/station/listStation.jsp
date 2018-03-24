<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[升级/转班管理]</td>
   
    <td width="57%"align="right">
    	<%--查询 
       <a href="javascript:void(0)" onclick="document.forms[0].submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	--%>
    	<%--添加 
    	<s:a namespace="/student" action="studentAction_preAddOrEdit">
    		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</s:a>
    	--%>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">

    <td width="10%" align="center">姓名</td>
    <td width="10%" align="center">操作时间</td>
    <td width="10%" align="center">操作类型</td>
    
    <td width="10%" align="center">经办人</td>
    <td width="10%" align="center">操作前的班</td>
    <td width="10%" align="center">操作前的班</td>
    
  </tr>
  <s:iterator value="allStation" status="vs">
	 <tr class="<s:property value="#vs.odd ? 'tabtd2' : 'tabtd1'" />">
		<td align="center"><s:property value="crmStudent.name"/></td>
		<td align="center"><s:date name="createDate"/> </td>
		<td align="center"><s:property value="@crm.constant.CommonConstant@STUDENT_STATUS[flag]"/> </td>
		
		<td align="center"><s:property value="crmStaff.staffName"/> </td>
		<td align="center"><s:property value="beforeClass.name"/></td>
		<td align="center"><s:property value="afterClass.name"/></td>
	 </tr>
  </s:iterator>
  
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
</body>
</html>