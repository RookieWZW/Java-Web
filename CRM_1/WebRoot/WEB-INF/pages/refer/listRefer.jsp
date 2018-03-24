<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
		function selectRefer(){
			
		}
	</script>
</head>

<body>
 <table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="33%" align="left">[咨询学生管理]</td>
   
    <td width="63%"align="right">
    	<%--添加咨询 --%>
    	<s:a cssClass="butbg" namespace="/refer" action="referAction_preAdd">
	        <img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</s:a>
        </a>
    	<%--高级查询咨询 
        <a class="butbg"  href="#"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	--%>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：添加或选择马上查询 -->
<s:form namespace="/refer" action="referAction_findAll">
	<s:hidden name="status" value="%{status}"></s:hidden>
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">查询条件：</td>
	    <td width="300px"><s:textfield name="condition" size="20" onblur="document.forms[0].submit();"></s:textfield>（姓名|电话|QQ）</td>
	    <td ></td>
	  </tr>
	</table>
</s:form>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
	<td width="80px" align="center">姓名</td>
	<td width="9%" align="center">电话</td>
	<td width="11%" align="center">QQ </td>
	<td width="15%" align="center">意向类别/班级</td>
	<td width="17%" align="center">状态</td>
	<td width="10%" align="center">营销人员</td>
	<td width="8%" align="center">查看</td>
	<s:if test="status == 1">
	<td width="8%" align="center">编辑</td>
	<td width="8%" align="center">跟踪</td>
	<td width="8%" align="center">录入学籍</td>
	</s:if>
  </tr>
  <s:iterator value="allRefer" status="vs">
	<tr class="<s:property value="#vs.odd ? 'tabtd2' : 'tabtd1'" />">
	    <td align="center"><s:property value="name"/></td>
	    <td align="center"><s:property value="telephone"/></td>
	    <td align="center"><s:property value="qq"/></td>
	    <td align="center">
	    	<s:property value="crmCourseType.courseName"/>/
	    	<s:property value="crmClass.name"/>
	    </td>
	    <td align="center">
	    	<s:property value="@crm.constant.CommonConstant@REFER_STATUS[status]" />
	    </td>
	    <td align="center"><s:property value="crmStaff.staffName"/></td>
	    <%--查询 --%>
		<td width="8%" align="center">
			<s:a namespace="/refer" action="referAction_findById">
				<s:param name="referId" value="referId"></s:param>
				<img src="${pageContext.request.contextPath}/images/button/view.gif" class="img"/>
			</s:a>
		</td>
		
		<s:if test="status == 1">
		<!-- 编辑 -->
		<td width="8%" align="center">
			<s:a namespace="/refer" action="referAction_preEdit">
	    		<s:param name="referId" value="referId"></s:param>
				<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
			</s:a>
		</td>
		
		<!-- 添加跟踪 -->
		<td width="8%" align="center">
			<s:a namespace="/follow" action="followAction_preAddOrEdit">
	    		<s:param name="crmRefer.referId" value="referId"></s:param>
				<img src="${pageContext.request.contextPath}/images/button/new.gif" class="img"/>
	    	</s:a>
		</td>
		
		<!-- 入学 -->
		<td width="8%" align="center">
			<s:a namespace="/refer" action="referAction_preAddStudent">
	    		<s:param name="referId" value="referId"></s:param>
				<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
	    	</s:a>
		</td>
		</s:if>
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
