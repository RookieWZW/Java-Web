
package crm.staff.dao.impl;

import java.util.List;

import crm.base.impl.BaseDaoImpl;
import crm.staff.dao.StaffDao;
import crm.staff.domain.CrmStaff;

/**  
 * <p>Title: StaffDaoImpl</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-22 下午11:43:44
 */
public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao{

	@Override
	@SuppressWarnings("unchecked")
	public CrmStaff find(String loginName, String loginPwd) {
		// TODO Auto-generated method stub
		List<CrmStaff> allUser= this.getHibernateTemplate().find("from CrmStaff where loginName = ? and loginPwd = ?", loginName,loginPwd);
		if(allUser != null && allUser.size()>0){
			
			return allUser.get(0);
		}
		return null;
	}
	
}
