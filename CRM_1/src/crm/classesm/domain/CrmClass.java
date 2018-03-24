
package crm.classesm.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import crm.coursetype.domain.CrmCourseType;
import crm.graduate.domain.CrmGraduate;
import crm.station.domain.CrmStation;
import crm.student.domain.CrmStudent;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-21 下午10:09:19
 * @version :
 * 班级管理
 * 
 */

public class CrmClass {
	
	private static final long serialVersionUID = 6412775832959370116L;
	
	private String classId;
	private CrmCourseType crmCourseType;
	
	
	private String name;  
	private Date beginTime;
	private Date endTime;
	
	
	private String status; 
	private int totalCount;
	private int upgradeCount;
	
	private int changeCount;
	private int runoffCount;
	private String remark;
	
	private String uploadPath;
	private String uploadFilename;
	private Date uploadTime;
	
	private Set<CrmStation> crmBeforeStationSet = new HashSet<CrmStation>();
	private Set<CrmStation> crmAfterStationSet = new HashSet<CrmStation>();
	
	
	private Set<CrmGraduate> crmGraduateSet = new HashSet<CrmGraduate>();
	
	private Set<CrmStudent> crmStudentSet = new HashSet<CrmStudent>();

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public CrmCourseType getCrmCourseType() {
		return crmCourseType;
	}

	public void setCrmCourseType(CrmCourseType crmCourseType) {
		this.crmCourseType = crmCourseType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getUpgradeCount() {
		return upgradeCount;
	}

	public void setUpgradeCount(int upgradeCount) {
		this.upgradeCount = upgradeCount;
	}

	public int getChangeCount() {
		return changeCount;
	}

	public void setChangeCount(int changeCount) {
		this.changeCount = changeCount;
	}

	public int getRunoffCount() {
		return runoffCount;
	}

	public void setRunoffCount(int runoffCount) {
		this.runoffCount = runoffCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUploadFilename() {
		return uploadFilename;
	}

	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Set<CrmStation> getCrmBeforeStationSet() {
		return crmBeforeStationSet;
	}

	public void setCrmBeforeStationSet(Set<CrmStation> crmBeforeStationSet) {
		this.crmBeforeStationSet = crmBeforeStationSet;
	}

	public Set<CrmStation> getCrmAfterStationSet() {
		return crmAfterStationSet;
	}

	public void setCrmAfterStationSet(Set<CrmStation> crmAfterStationSet) {
		this.crmAfterStationSet = crmAfterStationSet;
	}

	public Set<CrmGraduate> getCrmGraduateSet() {
		return crmGraduateSet;
	}

	public void setCrmGraduateSet(Set<CrmGraduate> crmGraduateSet) {
		this.crmGraduateSet = crmGraduateSet;
	}

	public Set<CrmStudent> getCrmStudentSet() {
		return crmStudentSet;
	}

	public void setCrmStudentSet(Set<CrmStudent> crmStudentSet) {
		this.crmStudentSet = crmStudentSet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//**************************************************
	
	
}
