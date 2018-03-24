package crm.department.service.impl;

import java.util.List;

import crm.department.dao.DepartmentDao;
import crm.department.domain.CrmDepartment;
import crm.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	@Override
	public List<CrmDepartment> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public void addOrEdit(CrmDepartment crmDepartment) {
		departmentDao.saveOrUpdate(crmDepartment);
	}

	@Override
	public CrmDepartment findById(String depId) {
		return departmentDao.findById(depId);
	}

}
