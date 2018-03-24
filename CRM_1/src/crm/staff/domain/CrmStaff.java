
package crm.staff.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import crm.follow.domain.CrmFollow;
import crm.post.domain.CrmPost;
import crm.refer.domain.CrmRefer;
import crm.runoff.domain.CrmRunOff;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午3:25:58
 * @version :
 * 
 */
public class CrmStaff {
	
	
	private static final long serialVersionUID = 2250013234774357149L;
	private String staffId;
	
	private String loginName;		//登录名
	private String loginPwd;		//登录密码
	private String staffName;		//姓名
	
	private String gender;			//性别
	private Date onDutyDate;		//入职时间
	private CrmPost crmPost;		//所属职务（职务关联部门）
	
	//一个员工 可以被  【咨询多次】
	private Set<CrmRefer> crmReferSet = new HashSet<CrmRefer>();
	
	//一个员工 添加 多个跟踪
	private Set<CrmFollow> crmFollowSet = new HashSet<CrmFollow>();
	//一个员工 添加 多个 丢失
	private Set<CrmRunOff> crmRunOffset = new HashSet<CrmRunOff>();
	
	
	//修改密码(可以存放action)
	private String oldPassword;
	private String newPassword;
	private String reNewPassword;
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getOnDutyDate() {
		return onDutyDate;
	}
	public void setOnDutyDate(Date onDutyDate) {
		this.onDutyDate = onDutyDate;
	}
	public CrmPost getCrmPost() {
		return crmPost;
	}
	public void setCrmPost(CrmPost crmPost) {
		this.crmPost = crmPost;
	}
	public Set<CrmRefer> getCrmReferSet() {
		return crmReferSet;
	}
	public void setCrmReferSet(Set<CrmRefer> crmReferSet) {
		this.crmReferSet = crmReferSet;
	}
	public Set<CrmFollow> getCrmFollowSet() {
		return crmFollowSet;
	}
	public void setCrmFollowSet(Set<CrmFollow> crmFollowSet) {
		this.crmFollowSet = crmFollowSet;
	}
	public Set<CrmRunOff> getCrmRunOffset() {
		return crmRunOffset;
	}
	public void setCrmRunOffset(Set<CrmRunOff> crmRunOffset) {
		this.crmRunOffset = crmRunOffset;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getReNewPassword() {
		return reNewPassword;
	}
	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	
	
}
