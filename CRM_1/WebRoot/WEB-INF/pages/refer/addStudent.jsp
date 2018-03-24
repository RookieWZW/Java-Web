<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body class="emp_body">
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[录入学籍]</td>
   
    <td width="52%"align="right">
    	<!--<a href="listLog.html"><img src="${pageContext.request.contextPath}/images/button/find.gif" class="img"/></a>
        <a href="addLog.html"><img src="${pageContext.request.contextPath}/images/button/add.gif" class="img"/></a>~-->
        
       <!-- <a href="#"><img src="${pageContext.request.contextPath}/images/button/close.gif" class="img"/></a>-->
       <%--保存 --%>
       <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:form namespace="/refer" action="referAction_addStudent">
	<s:hidden name="crmRefer.referId" value="%{referId}"></s:hidden>
	<table width="89%" class="emp_table" style="" align="left" cellspacing="0">
	  <tr>
	    <td width="120px" height="35" align="left" >姓名：</td>
	    <td width="300px" align="left">
	    	<s:textfield name="name"></s:textfield>
	    </td>
	    <td>
	    	<%-- 状态：咨询中--%>
	    </td>
	  </tr>
	  <tr>
	    <td>电话：</td>
	    <td><s:textfield name="telephone"></s:textfield> </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>QQ：</td>
	    <td><s:textfield name="qq"></s:textfield></td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>身份证：</td>
	    <td><s:textfield name="identity"></s:textfield></td>
	    <td>&nbsp;</td>
	  </tr>
	</table>
</s:form>

</body>
</html>
