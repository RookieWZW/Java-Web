/**   
* @Title: UserAction.java 
* @Package bos.web.action.base 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午3:21:16 
* @version V1.0   
*/
package bos.web.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bos.domain.User;
import bos.service.UserService;
import bos.utils.MD5Utils;
import bos.web.action.base.BaseAction;

/**
 * @ClassName: UserAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author RookieWangZhiWei
 * @date 2018年3月25日 下午3:21:16
 * 
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	@Resource
	private UserService userService;

	private String checkcode;

	/**
	 * @param checkcode
	 *            the checkcode to set
	 */
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	/**
	 * 
	* @Title: login 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public String login() {
		String key = (String) ServletActionContext.getRequest().getSession().getAttribute("key");

		if (StringUtils.isNotBlank(checkcode) && checkcode.equals(key)) {
			User user = userService.login(model);
			if (user != null) {
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);

				return "home";
			} else {
				this.addActionError(this.getText("loginError"));
				return "login";
			}
		} else {
			this.addActionError(this.getText("validateCodeError"));
			return "login";
		}

	}
	/**
	 * 
	* @Title: logout 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
	public String editPassword() throws IOException {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		String password = model.getPassword();
		password = MD5Utils.md5(password);
		String flag = "1";
		
		try {
			userService.editPassword(password, user.getId());
			
		}catch (Exception e) {
			// TODO: handle exception
			flag = "0"; 
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		return NONE;
	}
	
	
}
