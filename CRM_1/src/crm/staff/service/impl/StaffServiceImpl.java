
package crm.staff.service.impl;

import java.util.ArrayList;
import java.util.List;

import crm.staff.dao.StaffDao;
import crm.staff.domain.CrmStaff;
import crm.staff.service.StaffService;
import crm.utils.StringUtils;

/**  
 * <p>Title: StaffServiceImpl</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 上午9:05:32
 */
public class StaffServiceImpl implements StaffService {

	
	private StaffDao staffDao;
	
	
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public CrmStaff login(CrmStaff crmStaff) {
		// TODO Auto-generated method stub
		String loginPwd = crmStaff.getLoginPwd();
		loginPwd = StringUtils.getMD5Value(loginPwd);
		return staffDao.find(crmStaff.getLoginName(),loginPwd);
		
	}

	@Override
	public List<CrmStaff> findAll() {
		// TODO Auto-generated method stub
		return staffDao.findAll();
	}

	@Override
	public List<CrmStaff> findAll(CrmStaff crmStaff) {
		// TODO Auto-generated method stub
		StringBuilder builder  = new StringBuilder();
		List<Object> paramList = new ArrayList<Object>();
		if(crmStaff.getCrmPost() !=null && crmStaff.getCrmPost().getCrmDepartment() != null){
			
			if(org.apache.commons.lang3.StringUtils.isNotBlank(crmStaff.getCrmPost().getCrmDepartment().getDepId())){
				builder.append(" and crmPost.crmDepartment.depId = ?");
				paramList.add(crmStaff.getCrmPost().getCrmDepartment().getDepId());
				
			}
		}
		if(crmStaff.getCrmPost() != null){
			if(org.apache.commons.lang3.StringUtils.isNotBlank(crmStaff.getCrmPost().getPostId())){
				builder.append(" and crmPost.postId = ?");
				paramList.add(crmStaff.getCrmPost().getPostId());
			}
		}
		if(org.apache.commons.lang3.StringUtils.isNotBlank(crmStaff.getStaffName())){
			builder.append(" and staffName = ? ");
			paramList.add(crmStaff.getStaffName());
		}
		String condition = builder.toString();
		Object[] params = paramList.toArray();
		
		return staffDao.findAll(condition, params);
		
	}

	@Override
	public void updatePassword(String staffId, String newPassword) {
		// TODO Auto-generated method stub
		String loginPwd = StringUtils.getMD5Value(newPassword);
		CrmStaff crmStaff = staffDao.findById(staffId);
		crmStaff.setLoginPwd(loginPwd);
	}

	@Override
	public CrmStaff findById(String staffId) {
		// TODO Auto-generated method stub
		return staffDao.findById(staffId);
	}

	@Override
	public void updateStaff(CrmStaff crmStaff) {
		// TODO Auto-generated method stub
		String loginPwd = crmStaff.getLoginPwd();
		if(loginPwd.length() != 32){
			loginPwd = StringUtils.getMD5Value(loginPwd);
			crmStaff.setLoginPwd(loginPwd);
		}
		this.staffDao.update(crmStaff);
	}

	@Override
	public void addStaff(CrmStaff crmStaff) {
		// TODO Auto-generated method stub
		String loginPwd  = StringUtils.getMD5Value(crmStaff.getLoginPwd());
		
		crmStaff.setLoginPwd(loginPwd);
		
		this.staffDao.save(crmStaff);
	}

}
