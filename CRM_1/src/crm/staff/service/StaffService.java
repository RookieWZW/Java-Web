
package crm.staff.service;

import java.util.List;

import crm.staff.domain.CrmStaff;

/**  
 * <p>Title: StaffService</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 上午8:44:36
 */
public interface StaffService {
	public CrmStaff login(CrmStaff crmStaff);
	
	
	public List<CrmStaff> findAll();
	
	
	public List<CrmStaff> findAll(CrmStaff crmStaff);
	
	
	public void updatePassword(String staffId,String newPassword);
	
	
	public CrmStaff findById(String staffId);
	
	public void updateStaff(CrmStaff crmStaff);
	
	public void addStaff(CrmStaff crmStaff);
}
