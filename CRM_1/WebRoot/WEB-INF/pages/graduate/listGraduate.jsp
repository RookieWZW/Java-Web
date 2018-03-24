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
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[就业情况]</td>
   
    <td width="57%"align="right">
  		<%--高级查询 
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
  		--%>
    	<%--添加 --%>
    	<s:a namespace="/graduate" action="graduateAction_preAddOrEdit">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
  		</s:a>
      
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
    <td width="6%" align="center">学生姓名</td>
    <td width="6%" align="center">就读班级</td>
    <td width="15%" align="center">就业公司</td>
    <td width="12%" align="center">薪资</td>
    
    <td width="15%" align="center">岗位</td>
    <td width="12%" align="center">入职时间</td>
    <td width="12%" align="center">描述</td>
    
    <td width="7%" align="center">编辑</td>
  </tr>
  <s:iterator value="allGraduate" status="vs">
	 <tr class="<s:property value="#vs.odd ? 'tabtd2' : 'tabtd1'" />">
	    <td align="center"><s:property value="crmStudent.name"/> </td>
	    <td align="center"><s:property value="crmStudent.crmClass.name"/> </td>
	    <td align="center"><s:property value="companyName"/> </td>
	    <td align="center"><s:property value="salary"/> </td>
	    
	    <td align="center"><s:property value="post"/> </td>
	    <td align="center"><s:date name="entryTime" format="yyyy-MM-dd"/> </td>
	    <td align="center"><s:property value="remark"/> </td>
	    
	  	<td width="7%" align="center">
	  		<s:a namespace="/graduate" action="graduateAction_preAddOrEdit">
		  		<s:param name="granduateId" value="granduateId"></s:param>
	  			<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" />
	  		</s:a>
	  	</td>
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