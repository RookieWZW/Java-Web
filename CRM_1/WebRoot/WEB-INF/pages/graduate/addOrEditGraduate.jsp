<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
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
    <td width="44%" align="left">[添加学员就业信息]</td>
   
	<td width="52%"align="right">
    	<!-- 添加 -->
		<a href="javascript:void(0)" onclick="document.forms[0].submit()">
			<img src="${pageContext.request.contextPath}/images/button/save.gif" />
		</a>
		<a href="#"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:form namespace="/graduate" action="graduateAction_addOrEdit">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="9%">班级：</td>
	    <td width="19%">
	    	<s:select list="allClass" name="crmStudent.crmClass.classId"
	    		headerKey="" headerValue="--选择班级--"
	    		listKey="classId" listValue="name"
	    		onchange="changeStudent(this)"
	    		>
	    	</s:select>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="9%">学生：</td>
	    <td width="19%"><select id="studentSelectId" name="crmStudent.studentId" ><option>--选择学生--</option></select></td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>就业公司：</td>
	    <td><s:textfield name="companyName"/> </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>薪资：</td>
	    <td><s:textfield name="salary"/> </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>岗位：</td>
	    <td><s:textfield name="post"/>  </td>
		<td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>入职时间：</td>
	    <td><s:textfield name="entryTime" readonly="true" onfocus="c.showMoreDay=true; c.show(this);"/> </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>备注：</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="3">
	    	<s:textarea name="remark" cols="60" rows="10"></s:textarea>
	    </td>
	  </tr>
	</table>
</s:form>
	<script type="text/javascript">
		function changeStudent(obj){
			//1 班级的id
			var classId = obj.value;
			
			//2通过编辑查询所有的学生
			//2 发送ajax 通过部门id 查询对应职务
			var url = "${pageContext.request.contextPath}/student/studentAction_ajaxGetStudent?crmClass.classId=" + classId;
			
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
					
					var studentSelectObj = document.getElementById("studentSelectId");
					// 必须设置 value='' 否则数据有误
					studentSelectObj.innerHTML = "<option value=''>--选择学生--</option>";
					
					//获得数据 json，并处理
					//@1 获得普通文本数据
					var textData = xmlhttp.responseText;
					//@2 将文本转换成json数据  eval()  ,但兼容  eval("("+...+")")
					var jsonData = eval("("+textData+")");
					//@3 遍历数据，将数据添加到“学生”select
					for(var i = 0 ; i < jsonData.length ; i ++){
						var studentObj = jsonData[i];
						// @3.1 编号
						var studentId = studentObj.studentId;
						// @3.2 名称
						var studentName = studentObj.name;
						// @3.3 追加
						studentSelectObj.innerHTML = studentSelectObj.innerHTML + "<option value='"+studentId+"'>"+studentName+"</option>";
					}
				}
			};
			
			// 2.3 打开连接 ,以get请求方式发送数据
			xmlhttp.open("get",url);
			
			// 2.4 发送 , 没有请求体的内容，设置成null
			xmlhttp.send(null);
		}
	</script>
</html>