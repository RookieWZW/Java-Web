
package crm.follow.domain;

import java.util.Date;

import crm.refer.domain.CrmRefer;
import crm.staff.domain.CrmStaff;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 上午9:21:58
 * @version :
 * 
 */
public class CrmFollow {
	private static final long serialVersionUID = -3077388290357277040L;
	private String followId;
	
	private Date followTime;		//跟踪时间（创建时间）
	private String content;			//跟踪内容
	
	//多对一：多个跟踪 被 一个员工 录入
	private CrmStaff crmStaff;
	//多对一：多个跟踪 属于 一个咨询
	private CrmRefer crmRefer;
	public String getFollowId() {
		return followId;
	}
	public void setFollowId(String followId) {
		this.followId = followId;
	}
	public Date getFollowTime() {
		return followTime;
	}
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CrmStaff getCrmStaff() {
		return crmStaff;
	}
	public void setCrmStaff(CrmStaff crmStaff) {
		this.crmStaff = crmStaff;
	}
	public CrmRefer getCrmRefer() {
		return crmRefer;
	}
	public void setCrmRefer(CrmRefer crmRefer) {
		this.crmRefer = crmRefer;
	}
	
}
