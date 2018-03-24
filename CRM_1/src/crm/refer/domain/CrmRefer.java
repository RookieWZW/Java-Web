
package crm.refer.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import crm.classesm.domain.CrmClass;
import crm.coursetype.domain.CrmCourseType;
import crm.follow.domain.CrmFollow;
import crm.staff.domain.CrmStaff;
import crm.student.domain.CrmStudent;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午3:14:00
 * @version :
 * 
 */
public class CrmRefer {
	private static final long serialVersionUID = 8325374064835606245L;
	private String referId;
	
	private String name;			//姓名
	private String telephone;		//电话
	private String qq;
	private Date createDate;		//咨询时间
	
	private CrmStaff crmStaff;		//咨询人员
	private String intentionLevel;	//意向级别
	private CrmClass crmClass;		//班级
	private CrmCourseType crmCourseType;//意向学科  
	
	private String source;			//来源
	private String status;			//状态（1.咨询中、2.准备报名、3.已经报名）
	private String remark;			//备注
	
	//一对多：一个咨询可以有【多个跟踪】
	private Set<CrmFollow> crmFollowSet = new HashSet<CrmFollow>();
	//一对一：一个咨询 咨询的是【一个学生】\
	// TODO 外键应该添加到学生处
	private CrmStudent crmStudent;
	
	
	private String condition;		//条件查询内容


	public String getReferId() {
		return referId;
	}


	public void setReferId(String referId) {
		this.referId = referId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public CrmStaff getCrmStaff() {
		return crmStaff;
	}


	public void setCrmStaff(CrmStaff crmStaff) {
		this.crmStaff = crmStaff;
	}


	public String getIntentionLevel() {
		return intentionLevel;
	}


	public void setIntentionLevel(String intentionLevel) {
		this.intentionLevel = intentionLevel;
	}


	public CrmClass getCrmClass() {
		return crmClass;
	}


	public void setCrmClass(CrmClass crmClass) {
		this.crmClass = crmClass;
	}


	public CrmCourseType getCrmCourseType() {
		return crmCourseType;
	}


	public void setCrmCourseType(CrmCourseType crmCourseType) {
		this.crmCourseType = crmCourseType;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Set<CrmFollow> getCrmFollowSet() {
		return crmFollowSet;
	}


	public void setCrmFollowSet(Set<CrmFollow> crmFollowSet) {
		this.crmFollowSet = crmFollowSet;
	}


	public CrmStudent getCrmStudent() {
		return crmStudent;
	}


	public void setCrmStudent(CrmStudent crmStudent) {
		this.crmStudent = crmStudent;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	
}
