package crm.runoff.domain;

import java.util.Date;

import crm.staff.domain.CrmStaff;
import crm.student.domain.CrmStudent;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午3:21:45
 * @version :
 * 
 */
public class CrmRunOff {
	private static final long serialVersionUID = 8948840249553809646L;

	private String runOffId;

	private CrmStudent crmStudent; // 学生
	private CrmStaff crmStaff; // 经办人
	private Date createDate; // 流失时间

	private String isRefund; // 是否退款
	private String refundAmount; // 退款金额
	private String remark; // 描述（流失原因）
	public String getRunOffId() {
		return runOffId;
	}
	public void setRunOffId(String runOffId) {
		this.runOffId = runOffId;
	}
	public CrmStudent getCrmStudent() {
		return crmStudent;
	}
	public void setCrmStudent(CrmStudent crmStudent) {
		this.crmStudent = crmStudent;
	}
	public CrmStaff getCrmStaff() {
		return crmStaff;
	}
	public void setCrmStaff(CrmStaff crmStaff) {
		this.crmStaff = crmStaff;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getIsRefund() {
		return isRefund;
	}
	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	
}
