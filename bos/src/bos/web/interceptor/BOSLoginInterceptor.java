/**   
* @Title: BOSLoginInterceptor.java 
* @Package bos.web.interceptor 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����6:56:11 
* @version V1.0   
*/
package bos.web.interceptor;

import org.aopalliance.intercept.Invocation;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import bos.domain.User;

public class BOSLoginInterceptor extends MethodFilterInterceptor {

	/*
	* Title: doIntercept
	*Description: 
	* @param arg0
	* @return
	* @throws Exception 
	* @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation) 
	*/
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		
		if(user == null) {
			return "login";
		}
		return invocation.invoke();
	}



}
