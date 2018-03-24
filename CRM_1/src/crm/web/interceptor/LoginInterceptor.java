
package crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午8:48:24
 * @version :
 * 
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Object loginUser = ActionContext.getContext().getSession().get("loginUser");
		if(loginUser == null){
			Object action = invocation.getAction();
			if(action instanceof ActionSupport){
				ActionSupport actionSupport = (ActionSupport) action;
				actionSupport.addFieldError("logonName", "请登陆");
			}
			return "nonLogin";
		}
		return invocation.invoke();
	}

}
