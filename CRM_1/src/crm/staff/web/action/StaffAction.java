package crm.staff.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import crm.base.BaseAction;
import crm.department.domain.CrmDepartment;
import crm.post.domain.CrmPost;
import crm.staff.domain.CrmStaff;
import crm.utils.StringUtils;

/**
 * <p>
 * Title: StaffAction
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author RookieWangZhiWei
 * @date 2018-3-23 下午9:00:20
 */
public class StaffAction extends BaseAction<CrmStaff> {

	public String login() {
		CrmStaff loginUser = this.getStaffService().login(this.getModel());
		if (loginUser != null) {
			// 登录成功
			// 将用户的信息保存session中，保证一次会话数据共享
			this.sessionPut("loginUser", loginUser);
			return "success";
		} else {
			// 登录不成功
			this.addFieldError("loginName", "账号和密码不匹配");
			return "login";
		}
	}

	public String findAll() {

		// 1 查询所有部门
		List<CrmDepartment> allDepartment = this.getDepartmentService()
				.findAll();
		this.set("allDepartment", allDepartment);

		// 2查询所有职务
		List<CrmPost> allPost = this.getPostService().findAll();
		this.set("allPost", allPost);

		// 3 查询所有
		List<CrmStaff> allUser = this.getStaffService()
				.findAll(this.getModel());
		// 将结果存放值栈中 ,jsp页面通过"key"直接获得
		this.set("allUser", allUser);

		return "findAll";
	}

	public String logout() {
		ActionContext.getContext().getSession().remove("loginUser");
		return "login";
	}

	public void validateEditPassword() {
		CrmStaff loginStaff = (CrmStaff) ActionContext.getContext()
				.getSession().get("loginUser");
		String oldPassword = StringUtils.getMD5Value(this.getModel()
				.getOldPassword());
		if (!loginStaff.getLoginPwd().equals(oldPassword)) {
			this.addFieldError("loginName", "原始密码不正确");
		}
	}

	@InputConfig(resultName = "pwdInput")
	public String editPassword() {
		CrmStaff loginStaff = (CrmStaff) this.sessionGet("loginUser");

		this.getStaffService().updatePassword(loginStaff.getStaffId(),
				this.getModel().getNewPassword());

		return "editPassword";
	}

	public String preEdit() {

		// 1 通过id查询用户
		CrmStaff findStaff = this.getStaffService().findById(
				this.getModel().getStaffId());
		// 1.1 将查询结果存放值栈中，压入到栈顶，提供给struts标签进行回显的。
		// * 标签回显：<s:textfiled name="userName"/> 将使用userName从栈顶获得数据，如果获得就显示。
		ActionContext.getContext().getValueStack().push(findStaff);

		// 2 查询所有的部门
		List<CrmDepartment> allDepartment = this.getDepartmentService()
				.findAll();
		// 2.1 将查询结果存放到值栈中，必须设置key。jsp需要通过“#key”获得
		this.put("allDepartment", allDepartment);

		return "preEdit";
	}

	public String edit() {
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}

	public String preAdd() {

		// 1 查询所有的部门
		List<CrmDepartment> allDepartment = this.getDepartmentService()
				.findAll();
		// 1.1 将查询结果存放到值栈中，必须设置key。jsp需要通过“#key”获得
		this.put("allDepartment", allDepartment);

		return "preAdd";
	}

	public String add() {
		this.getStaffService().addStaff(this.getModel());

		return "add";
	}
}
