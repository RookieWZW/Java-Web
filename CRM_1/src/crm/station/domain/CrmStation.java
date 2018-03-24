
package crm.station.domain;

import java.util.Date;

import crm.classesm.domain.CrmClass;
import crm.staff.domain.CrmStaff;
import crm.student.domain.CrmStudent;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午3:29:51
 * @version :
 * 
 */
public class CrmStation {
	private static final long serialVersionUID = -7189308663123147154L;
	private String stationId;
	
	private CrmStudent crmStudent;			//学生
	private String flag;					//标记（1.升级(基本-->就业)、2.转班）
	private CrmStaff crmStaff;				//经办人
	
	private Date createDate;				//操作时间
	private CrmClass beforeClass;			//之前班
	private CrmClass afterClass;			//之后班
	
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public CrmStudent getCrmStudent() {
		return crmStudent;
	}
	public void setCrmStudent(CrmStudent crmStudent) {
		this.crmStudent = crmStudent;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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
	public CrmClass getBeforeClass() {
		return beforeClass;
	}
	public void setBeforeClass(CrmClass beforeClass) {
		this.beforeClass = beforeClass;
	}
	public CrmClass getAfterClass() {
		return afterClass;
	}
	public void setAfterClass(CrmClass afterClass) {
		this.afterClass = afterClass;
	}
	
}
