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

<body class="emp_body">
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[正式学员管理]</td>
   
    <td width="52%"align="right">
    	<!--<a href="listLog.html"><img src="${pageContext.request.contextPath}/images/button/find.gif" class="img"/></a>
        <a href="addLog.html"><img src="${pageContext.request.contextPath}/images/button/add.gif" class="img"/></a>~-->
        
       <!-- <a href="#"><img src="${pageContext.request.contextPath}/images/button/close.gif" class="img"/></a>-->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:form namespace="/student" action="studentAction_addOrEdit">
	<s:if test="status != null">
		<s:hidden name="status" value="%{status}"></s:hidden>
	</s:if>
	<s:if test="crmRefer != null">
		<s:hidden name="crmRefer.referId" value="%{crmRefer.referId}"></s:hidden>
	</s:if>
	<table width="88%" class="emp_table">
	  <tr>
	    <td width="100px" align="left">姓名：</td>
	    <td width="200px" align="left"><s:textfield name="name"></s:textfield> </td>
	    <td width="80px" align="left">性别：</td>
	    <td align="left">
	    	<s:radio list="{'男','女'}" name="gender"  key="男"></s:radio>
	    </td>
	  </tr>
	  <tr>
	    <td align="left">应付学费：</td>
	    <td align="left"><s:textfield name="mustTuition"></s:textfield></td>
	    <td align="left">实付学费：</td>
	    <td align="left"><s:textfield name="actualTuition"></s:textfield></td>
	  </tr>
	  <tr>
	    <td align="left">身份证号：</td>
	    <td align="left"><s:textfield name="identity"></s:textfield></td>
	    <td align="left">手机号：</td>
	    <td align="left"><s:textfield name="telephone"></s:textfield></td>
	  </tr>
	  <tr>
	    <td align="left">QQ号：</td>
	    <td align="left"><s:textfield name="qq"></s:textfield></td>
	    <td align="left">邮箱：</td>
	    <td align="left"><s:textfield name="email"></s:textfield></td>
	  </tr>
	  <tr>
	    <td align="left">就读班级：</td>
	    <td align="left" colspan="3">
	    	类别 <s:select list="allCourseType" 
	    			name="crmClass.crmCourseType.courseTypeId" 
	    			listKey="courseTypeId" listValue="courseName" 
	    			headerKey="" headerValue="--选择班级--" 
	    			onchange="changeClass(this)"></s:select>
	    	班级<s:if test="allClass != null">
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
	  </tr>
	  <tr>
	    <td align="left">毕业学校：</td>
	    <td align="left"><s:textfield name="school"></s:textfield></td>
	    <td align="left">学历：</td>
	    <td align="left">
	    	<s:select list="@crm.constant.CommonConstant@STUDENT_EDUCATION" name="education" headerKey="" headerValue="--选择学历--"></s:select>
	    	专业<s:textfield name="professional" size="17"></s:textfield>
	    </td>
	  </tr>
	  <tr>
	    <td align="left">身份证地址：</td>
	    <td align="left" colspan="3"><s:textfield name="identityAddress" size="60"></s:textfield></td>
	  </tr>
	  <tr>
	    <td align="left">在京地址：</td>
	    <td align="left" colspan="3"><s:textfield name="address" size="60"></s:textfield></td>
	  </tr>
	  <tr>
	    <td align="left">学员描述：</td>
	    <td align="left" colspan="3"><s:textfield name="remark" size="60"></s:textfield></td>
	  </tr>
	  <tr>
	    <td colspan="6"><br />出门在外，如果发生意外，我们将通过下面的信息跟学院的家长联系</td>
	    </tr>
	   <tr>
	    <td align="left">家庭联系电话：</td>
	    <td align="left"><s:textfield name="homeTelephone"></s:textfield></td>
	    <td align="left">家庭联系人：</td>
	    <td align="left"><s:textfield name="homeUser"></s:textfield></td>
	  </tr>
	</table>
</s:form>

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
</html>