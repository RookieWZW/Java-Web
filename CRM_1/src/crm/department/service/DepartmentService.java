
package crm.department.service;

import java.util.List;

import crm.department.domain.CrmDepartment;

/**  
 * <p>Title: DepartmentService</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午7:04:41
 */
public interface DepartmentService {
	 List<CrmDepartment> findAll();
	 
	 void addOrEdit(CrmDepartment crmDepartment);
	 
	 
	 CrmDepartment findById(String depId);
}
