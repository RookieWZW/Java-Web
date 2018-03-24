package crm.student.dao.impl;

import java.util.List;

import crm.base.impl.BaseDaoImpl;
import crm.student.dao.StudentDao;
import crm.student.domain.CrmStudent;

public class StudentDaoImpl extends BaseDaoImpl<CrmStudent> implements StudentDao {


//
	@SuppressWarnings("unchecked")
	@Override
	public List<CrmStudent> findAll() {
		return this.getHibernateTemplate().find("from CrmStudent order by status");
	}


}
