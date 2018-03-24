package crm.runoff.service.impl;

import java.util.List;

import crm.classesm.dao.ClassDao;
import crm.classesm.domain.CrmClass;
import crm.constant.CommonConstant;
import crm.runoff.dao.RunOffDao;
import crm.runoff.domain.CrmRunOff;
import crm.runoff.service.RunOffService;
import crm.student.dao.StudentDao;
import crm.student.domain.CrmStudent;

public class RunOffServiceImpl implements RunOffService {
	
	private RunOffDao runOffDao;
	public void setRunOffDao(RunOffDao runOffDao) {
		this.runOffDao = runOffDao;
	}
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	private ClassDao classDao;
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	@Override
	public void addRunoff(CrmRunOff crmRunOff) {
		//修改学生状态
		CrmStudent crmStudent = this.studentDao.findById(crmRunOff.getCrmStudent().getStudentId());
		crmStudent.setStatus(CommonConstant.STUDENT_STATUS_RUNOFF);
		
		//修改班级流失数量
		CrmClass findClass = this.classDao.findById(crmStudent.getCrmClass().getClassId());
		findClass.setRunoffCount(findClass.getRunoffCount() + 1);
		
		//总人数-1
		findClass.setTotalCount(findClass.getTotalCount() - 1);
		
		//TODO 解除关系 ？？？学员流失后，之后的查询是否可以查询到之前班级。
		
		this.runOffDao.save(crmRunOff);
	}
	@Override
	public List<CrmRunOff> findAll() {
		return this.runOffDao.findAll();
	}
	

}
