
package crm.student.domain;

import java.util.HashSet;
import java.util.Set;

import crm.classesm.domain.CrmClass;
import crm.graduate.domain.CrmGraduate;
import crm.refer.domain.CrmRefer;
import crm.runoff.domain.CrmRunOff;
import crm.station.domain.CrmStation;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午3:35:17
 * @version :
 * 
 */
public class CrmStudent {
private static final long serialVersionUID = 3080749354122546728L;
	
	//private String studentId;
	private String studentId;
	
	private String name;			//姓名
	private String gender;			//性别
	private Integer mustTuition;		//应付学费	mustTuition
	private Integer actualTuition;		//实付学费
	
	
	private String telephone;		//手机号
	private String identity;		//身份证号
	private CrmClass crmClass;		//就读班级
	
	private String qq;				//QQ号
	private String email;			//邮箱
	private String school;			//毕业学校
	private String education;		//学历
	private String professional;	//专业
	
	private String status;			//状态(新生、转班、升级、退费、毕业)
	private String identityAddress;	//身份证地址
	private String address;			//在京地址
	
	private String remark;			//学员描述
	private String homeTelephone;	//家庭联系电话
	private String homeUser;		//家庭联系人
	
	//一对一：一个学生 有 一个咨询
	private CrmRefer crmRefer;		//咨询
	
	//一对多：一个学生 存在【 多个驻留】（升级、转班）
	private Set<CrmStation> crmStationSet = new HashSet<CrmStation>();
	//一对多：一个学生 存在 多个丢失
	private Set<CrmRunOff> runOffSet = new HashSet<CrmRunOff>();
	//一对一：一个学生存在一条就业
	private CrmGraduate crmGraduate;
	
	//条件查询
	private String condition;
	
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMustTuition() {
		return mustTuition;
	}
	public void setMustTuition(int mustTuition) {
		this.mustTuition = mustTuition;
	}
	public int getActualTuition() {
		return actualTuition;
	}
	public void setActualTuition(int actualTuition) {
		this.actualTuition = actualTuition;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public CrmClass getCrmClass() {
		return crmClass;
	}
	public void setCrmClass(CrmClass crmClass) {
		this.crmClass = crmClass;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIdentityAddress() {
		return identityAddress;
	}
	public void setIdentityAddress(String identityAddress) {
		this.identityAddress = identityAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getHomeTelephone() {
		return homeTelephone;
	}
	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}
	public String getHomeUser() {
		return homeUser;
	}
	public void setHomeUser(String homeUser) {
		this.homeUser = homeUser;
	}
	public CrmRefer getCrmRefer() {
		return crmRefer;
	}
	public void setCrmRefer(CrmRefer crmRefer) {
		this.crmRefer = crmRefer;
	}
	public Set<CrmStation> getCrmStationSet() {
		return crmStationSet;
	}
	public void setCrmStationSet(Set<CrmStation> crmStationSet) {
		this.crmStationSet = crmStationSet;
	}
	public Set<CrmRunOff> getRunOffSet() {
		return runOffSet;
	}
	public void setRunOffSet(Set<CrmRunOff> runOffSet) {
		this.runOffSet = runOffSet;
	}
	public CrmGraduate getCrmGraduate() {
		return crmGraduate;
	}
	public void setCrmGraduate(CrmGraduate crmGraduate) {
		this.crmGraduate = crmGraduate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}
