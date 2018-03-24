
package crm.staff.dao;

import crm.base.BaseDao;
import crm.staff.domain.CrmStaff;

/**  
 * <p>Title: StaffDao</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-22 下午11:42:11
 */
public interface StaffDao extends BaseDao<CrmStaff> {
		
	
	public CrmStaff find(String loginName,String loginPwd);
}
