/**   
* @Title: UserAction.java 
* @Package bos.web.action.base 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����3:21:16 
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
 * @Description: TODO(������һ�仰��������������)
 * @author RookieWangZhiWei
 * @date 2018��3��25�� ����3:21:16
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
	* @Description: TODO(������һ�仰�����������������) 
	* @param @return  ����˵�� 
	* @return String    �������� 
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
	* @Description: TODO(������һ�仰�����������������) 
	* @param @return  ����˵�� 
	* @return String    �������� 
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
