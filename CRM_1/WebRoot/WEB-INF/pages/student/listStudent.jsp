<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
		function changeClass(courseTypeObj){
			//1 选择的部门id
			var courseTypeId = courseTypeObj.value;
			
			//2 发送ajax 通过部门id 查询对应职务
			var url = "${pageContext.request.contextPath}/classesm/classAction_ajaxGetClass?crmCourseType.courseTypeId=" + courseTypeId;
			
			//2.1 创建核心对象
			var xmlhttp=null;
			if (window.XMLHttpRequest) {
				xmlhttp=new XMLHttpRequest();
			}else if (window.ActiveXObject) {// code for IE5 and IE6
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			// 2.2 设置回调函数，当ajax请求完成之后，进行处理
			xmlhttp.onreadystatechange = function(){
				// * 发送成功， 并发送的正常页面
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					
					var classSelectObject = document.getElementById("classSelectId");
					// 必须设置 value='' 否则数据有误
					classSelectObject.innerHTML = "<option value=''>----请--选--择----</option>";
					
					//获得数据 json，并处理
					//@1 获得普通文本数据
					var textData = xmlhttp.responseText;
					//@2 将文本转换成json数据  eval()  ,但兼容  eval("("+...+")")
					var jsonData = eval("("+textData+")");
					//@3 遍历数据，将数据添加到“职务”select
					for(var i = 0 ; i < jsonData.length ; i ++){
						var classObj = jsonData[i];
						// @3.1 编号
						var classId = classObj.classId;
						// @3.2 名称
						var className = classObj.name;
						// @3.3 追加
						classSelectObject.innerHTML = classSelectObject.innerHTML + "<option value='"+classId+"'>"+className+"</option>";
					}
				}
			};
			
			// 2.3 打开连接 ,以get请求方式发送数据
			xmlhttp.open("get",url);
			
			// 2.4 发送 , 没有请求体的内容，设置成null
			xmlhttp.send(null);
		}
	</script>
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
    <td width="39%" align="left">[在校学生管理]</td>
   
    <td width="57%"align="right">
    	<%--查询 --%>
       <a href="javascript:void(0)" onclick="document.forms[0].submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--添加 --%>
    	<s:a namespace="/student" action="studentAction_preAddOrEdit">
    		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</s:a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：添加或选择马上查询 -->
<s:form namespace="/student" action="studentAction_findAll">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">查询条件：</td>
	    <td width="300px"><s:textfield name="condition" size="20"></s:textfield>（姓名|电话|QQ|性别）</td>
	    <td width="500px">
	    	课程类别：
	    	<s:select list="allCourseType" 
	    			name="crmClass.crmCourseType.courseTypeId" 
	    			listKey="courseTypeId" listValue="courseName" 
	    			headerKey="" headerValue="--选择班级--" 
	    			onchange="changeClass(this)"></s:select>
	    	班级：
	    	<s:if test="allClass != null">
	    		<s:select list="allClass" 
		    			id="classSelectId" 
		    			name="crmClass.classId"
		    			headerKey="" headerValue="----请--选--择----"
		    			listKey="classId" listValue="name" 
		    			></s:select>
	    	</s:if>
	    	<s:else>
		    	<s:select list="{}" 
		    			id="classSelectId" 
		    			name="crmClass.classId"
		    			headerKey="" headerValue="----请--选--择----"
		    			></s:select>
	    	</s:else>
	    	
	    </td>
	    <td></td>
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

    <td width="10%" align="center">姓名</td>
    <td width="10%" align="center">入学时间</td>
    <td width="10%" align="center">班级</td>
    <td width="10%" align="center">QQ</td>
    <td width="10%" align="center">联系电话</td>
    <td width="10%" align="center">已付/应付学费</td>
    <td width="10%" align="center">状态</td>  <!-- 新生、转班、升级、退费、毕业 -->
  	<td width="5%" align="center">编辑</td>
  	<td width="5%" align="center">升级/转班</td>
  	<td width="5%" align="center">查看</td>
  	<td width="5%" align="center">流失</td>
  </tr>
  <s:iterator value="allStudent" status="vs">
	   <tr class="<s:property value="#vs.odd ? 'tabtd2' : 'tabtd1'" />">
		<td align="center"><s:property value="name"/>(<s:property value="gender"/>) </td>
		<td align="center"><s:property value="name"/> </td>
		<td align="center"><s:property value="crmClass.name"/> </td>
		<td align="center"><s:property value="qq"/> </td>
		<td align="center"><s:property value="telephone"/> </td>
		<td align="center"><s:property value="actualTuition"/>/<s:property value="mustTuition"/> </td>
		<td align="center">
			<s:property value="@cn.itcast.crm.constant.CommonConstant@STUDENT_STATUS[status]"/> 
		</td>
		<%-- 编辑 --%>
	    <td align="center">
	    	<s:a namespace="/student" action="studentAction_preAddOrEdit">
	    		<s:param name="studentId" value="studentId"></s:param>
	    		<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
	    	</s:a>
	    </td>
	    <%-- 升级/转班--%>
	    <td align="center">
	    	<s:a namespace="/station" action="stationAction_preEditStation">
	    		<s:param name="crmStudent.studentId" value="studentId"></s:param>
	    		<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
	    	</s:a>
    	</td>
    	<!-- 查询详情 -->
		<td align="center">
			<s:a namespace="/student" action="studentAction_findById">
				<s:param name="studentId" value="studentId"></s:param>
				<img src="${pageContext.request.contextPath}/images/button/view.gif" class="img"/>
			</s:a>
		</td>
		<%--丢失 --%>
	    <td align="center">
			<s:a namespace="/runoff" action="runoffAction_preAdd">
				<s:param name="crmStudent.studentId" value="studentId"></s:param>
	    		<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
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