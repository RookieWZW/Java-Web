/** 
 * 通过部门select，级联显示职务
 * @param departmentObj  部门对象，this
 * @param postId 职务的select id,字符串数据，需要提供成员变量，是否回调函数中无法获得
 * @deprecated 处理比较麻烦，
 * 	1.回调函数获得postId
 * 	2.js文件中不能使用el函数
 */
var tempPostId = null;
function changePost(departmentObj,postId){
	//1 选择的部门id
	var depId = departmentObj.value;
	tempPostId = postId;
	
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
			
			var postSelectObject = document.getElementById(tempPostId);
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