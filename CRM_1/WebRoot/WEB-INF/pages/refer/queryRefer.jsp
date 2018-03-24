<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
    <td width="44%" align="left">[查看咨询学生]</td>
   
    <td width="52%"align="right">
    	<!--<a href="listLog.html"><img src="${pageContext.request.contextPath}/images/button/find.gif" class="img"/></a>
        <a href="addLog.html"><img src="${pageContext.request.contextPath}/images/button/add.gif" class="img"/></a>~-->
        
       <!-- <a href="#"><img src="${pageContext.request.contextPath}/images/button/close.gif" class="img"/></a>
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
       -->
       <%--退回 --%>
       <s:a namespace="/refer" action="referAction_findAll">
       		<s:param name="status" value="1"></s:param>
       		<img src="${pageContext.request.contextPath}/images/button/tuihui.gif" />
       </s:a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<table width="89%" class="emp_table"    style="" align="left" cellspacing="0">
  <tr>
    <td width="120px" height="35" align="left" >姓名：</td>
    <td width="300px" align="left"><s:property value="name"/> </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>电话：</td>
    <td><s:property value="telephone"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>QQ：</td>
    <td><s:property value="qq"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>咨询人：</td>
    <td><s:property value="crmStaff.staffName"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>意向级别：</td>
    <td><s:property value="intentionLevel"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>意向学科：</td>
    <td><s:property value="crmCourseType.courseName"/> &nbsp;&nbsp;&nbsp;意向班级：<s:property value="crmClass.name"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="41" align="left">来源：</td>
    <td align="left"><s:property value="source"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="left">备注：</td>
    <td align="left"><s:property value="remark"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td>跟踪信息：</td>
    <td>
    	<s:if test="status == 1">
    	<s:a namespace="/follow" action="followAction_preAddOrEdit">
    		<s:param name="crmRefer.referId" value="referId"></s:param>
    		添加跟踪
    	</s:a>
    	</s:if>
    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
  	<%--显示所有的跟踪 --%>
    <td colspan="3">
    	<table class="emp_table" style="width:70%; border:1px solid #CCC; margin-left:0" align="left">
	      <tr>
	        <td align="center">内容</td>
	        <td width="150px" align="center">时间</td>
	        <td width="80px" align="center">资源人员</td>
	      </tr>
	      <s:iterator value="crmFollowSet">
		      <tr>
		        <td style="padding-left: 10px;"><s:property value="content"/></td>
		        <td align="center"><s:date name="followTime" format="yyyy-MM-dd hh:mm"/> </td>
		        <td align="center"><s:property value="crmStaff.staffName"/></td>
		      </tr>
	      </s:iterator>
	    </table>
	</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>
</table>

</body>
</html>