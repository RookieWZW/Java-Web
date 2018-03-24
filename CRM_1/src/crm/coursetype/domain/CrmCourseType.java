
package crm.coursetype.domain;

import java.util.HashSet;
import java.util.Set;

import crm.classesm.domain.CrmClass;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 上午9:08:42
 * @version :
 * 
 */
public class CrmCourseType {
	private static final long serialVersionUID = -8171144210280541229L;
	

	private String courseTypeId;
	
	private Double courseCost;
	private Integer total;
	private String courseName;
	
	private String remark;
	private Set<CrmClass> crmClassSet = new HashSet<CrmClass>();
	
	// 表单对应字段--用于条件查询（可以另外编写javabean）
	private String totalStart;		//学时开始
	private String totalEnd;		//学时结束
	private String lessonCostStart;	//金额开始
	private String lessonCostEnd;	//金额结束
	
	
	//**********************************
	public String getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public Double getCourseCost() {
		return courseCost;
	}
	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<CrmClass> getCrmClassSet() {
		return crmClassSet;
	}
	public void setCrmClassSet(Set<CrmClass> crmClassSet) {
		this.crmClassSet = crmClassSet;
	}
	public String getTotalStart() {
		return totalStart;
	}
	public void setTotalStart(String totalStart) {
		this.totalStart = totalStart;
	}
	public String getTotalEnd() {
		return totalEnd;
	}
	public void setTotalEnd(String totalEnd) {
		this.totalEnd = totalEnd;
	}
	public String getLessonCostStart() {
		return lessonCostStart;
	}
	public void setLessonCostStart(String lessonCostStart) {
		this.lessonCostStart = lessonCostStart;
	}
	public String getLessonCostEnd() {
		return lessonCostEnd;
	}
	public void setLessonCostEnd(String lessonCostEnd) {
		this.lessonCostEnd = lessonCostEnd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//********************************************
	
}
