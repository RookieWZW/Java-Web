package crm.graduate.service.impl;

import java.util.List;

import crm.constant.CommonConstant;
import crm.graduate.dao.GraduateDao;
import crm.graduate.domain.CrmGraduate;
import crm.graduate.service.GraduateService;
import crm.student.dao.StudentDao;
import crm.student.domain.CrmStudent;
/**
 * 
* <p>Title: GraduateServiceImpl</p>  
* <p>Description: </p>   
* @author RookieWangZhiWei  
* @date 2018-3-23 下午7:45:20
 */
public class GraduateServiceImpl implements GraduateService {
	
	private GraduateDao graduateDao;
	public void setGraduateDao(GraduateDao graduateDao) {
		this.graduateDao = graduateDao;
	}
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Override
	public List<CrmGraduate> findAll() {
		return this.graduateDao.findAll();
	}
	@Override
	public void addOrEdit(CrmGraduate crmGraduate) {
		//更新学生状态
		CrmStudent crmStudent = this.studentDao.findById(crmGraduate.getCrmStudent().getStudentId());
		crmStudent.setStatus(CommonConstant.STUDENT_STATUS_GRADUATE);
		
		this.graduateDao.saveOrUpdate(crmGraduate);
	}
	
	
	

}
