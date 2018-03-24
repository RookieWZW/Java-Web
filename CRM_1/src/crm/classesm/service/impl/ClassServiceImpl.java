
package crm.classesm.service.impl;

import java.util.Date;
import java.util.List;

import crm.classesm.dao.ClassDao;
import crm.classesm.domain.CrmClass;
import crm.classesm.service.ClassService;
import crm.coursetype.domain.CrmCourseType;

/**  
 * <p>Title: ClassServiceImpl</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午12:36:43
 */
public class ClassServiceImpl implements ClassService {

	
	private ClassDao classDao;
	
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}

	@Override
	public List<CrmClass> findAll() {
		// TODO Auto-generated method stub
		return this.classDao.findAll();
	}

	@Override
	public CrmClass findById(String classId) {
		// TODO Auto-generated method stub
		return this.classDao.findById(classId);
	}

	@Override
	public void addOrEdit(CrmClass crmClass) {
		// TODO Auto-generated method stub
		this.classDao.saveOrUpdate(crmClass);
	}

	@Override
	public List<CrmClass> findAll(CrmCourseType courseType) {
		// TODO Auto-generated method stub
		return this.classDao.findAll(" and crmCourseType = ? ", courseType);
	}

	@Override
	public void updateSchedule(CrmClass crmClass) {
		// TODO Auto-generated method stub
			CrmClass findClass = this.classDao.findById(crmClass.getClassId());
			findClass.setUploadFilename(crmClass.getUploadFilename());
			
			findClass.setUploadPath(crmClass.getUploadPath());
			
			findClass.setUploadTime(new Date());
	}

}
