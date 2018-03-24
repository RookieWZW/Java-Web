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
		function condition(){
			document.getElementById("conditionFormId").submit();
		}
	</script>
	
	<script type="text/javascript">
		function changePost(departmentObj){
			//1 选择的部门id
			var depId = departmentObj.value;
			
			//2 发送ajax 通过部门id 查询对应职务
			var url = "${pageContext.request.contextPath}/post/postAction_ajaxGetPostion?crmDepartment.depId=" + depId;
			
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
					
					var postSelectObject = document.getElementById("postSelectId");
					postSelectObject.innerHTML = "<option>----请--选--择----</option>";
					
					//获得数据 json，并处理
					//@1 获得普通文本数据
					var textData = xmlhttp.responseText;
					//@2 将文本转换成json数据  eval()  ,但兼容  eval("("+...+")")
					var jsonData = eval("("+textData+")");
					//@3 遍历数据，将数据添加到“职务”select
					for(var i = 0 ; i < jsonData.length ; i ++){
						var postObj = jsonData[i];
						// @3.1 编号
						var postId = postObj.postId;
						// @3.2 名称
						var postName = postObj.postName;
						// @3.3 追加
						postSelectObject.innerHTML = postSelectObject.innerHTML + "<option value='"+postId+"'>"+postName+"</option>";
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
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="condition()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
    	<s:a namespace="/staff" action="staffAction_preAdd">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</s:a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：添加或选择马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/staff/staffAction_findAll" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
	    	<s:select list="allDepartment" 
	    		name="crmPost.crmDepartment.depId"
	    		listKey="depId" listValue="depName"
	    		headerKey="" headerValue="--请选择部门--"
	    		onchange="changePost(this)"
	    	>
	    	</s:select>
	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	    	<s:select id="postSelectId" list="allPost" 
	    		name="crmPost.postId"
	    		listKey="postId" listValue="postName"
	    		headerKey="" headerValue="--请选择职务--"
	    	>
	    	</s:select>
	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><input type="text" name="staffName" size="12" /></td>
	    <td ></td>
	  </tr>
	</table>
</form>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>
  <%-- 单行：tabtd2 ，双行：tabtd1 --%>
  <s:iterator value="allUser" status="vs">  <%--将遍历的每一个User数据 ，临时压入到栈顶 --%>
	  <tr class="<s:property value="#vs.odd ? 'tabtd2' : 'tabtd1'" />"> 
	    <td align="center"><s:property value="staffName"/></td>
	    <td align="center"><s:property value="gender"/></td>
	    <td align="center"><s:date name="onDutyDate" format="yyyy-MM-dd"/></td>
	    <td align="center"><s:property value="crmPost.crmDepartment.depName"/></td>
	    <td align="center"><s:property value="crmPost.postName"/></td>
	  	<td width="7%" align="center">
	  		<%--用户编辑 
	  			* 显示位置：/html/staff/editStaff.jsp
	  		--%>
	  		<s:a namespace="/staff" action="staffAction_preEdit">
	  			<s:param name="staffId" value="staffId"></s:param>
	  			<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" />
	  		</s:a>	
	  	</td>
	  	
	  </tr>
  </s:iterator>
 
</table>
<%-- 
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
--%>
</body>
</html>
