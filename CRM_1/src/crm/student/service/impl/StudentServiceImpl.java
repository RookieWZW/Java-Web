package crm.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import crm.classesm.dao.ClassDao;
import crm.classesm.domain.CrmClass;
import crm.constant.CommonConstant;
import crm.refer.dao.ReferDao;
import crm.student.dao.StudentDao;
import crm.student.domain.CrmStudent;
import crm.student.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	private ReferDao referDao;
	public void setReferDao(ReferDao referDao) {
		this.referDao = referDao;
	}
	private ClassDao classDao;
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	@Override
	public void addOrEdit(CrmStudent crmStudent) {
		
		//处理班级
		if(crmStudent.getCrmClass() != null){
			// 如果没有选择班级暂时不处理
			if(crmStudent.getCrmClass().getClassId() == null){
				crmStudent.setCrmClass(null);
			}
		}
		//TODO 如果没有咨询信息，如何确定咨询人?? 。如果有咨询信息，需要修改咨询状态？？
		if(crmStudent.getCrmRefer() != null){
			this.referDao.findById(crmStudent.getCrmRefer().getReferId()).setStatus(CommonConstant.REFER_STATUS_SIGNUP);
		}
		
		//修改编辑总人数 累加1  +1:Plus one ; -1:Minus one
		CrmClass crmClass = classDao.findById(crmStudent.getCrmClass().getClassId());
		crmClass.setTotalCount(crmClass.getTotalCount() + 1);
		
		this.studentDao.saveOrUpdate(crmStudent);
	}
	@Override
	public List<CrmStudent> findAll() {
		return this.studentDao.findAll();
	}
	@Override
	public CrmStudent findById(String studentId) {
		return this.studentDao.findById(studentId);
	}
	@Override
	public List<CrmStudent> findAll(CrmStudent crmStudent) {
		
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		//1 班级优先，其次类别
		if(crmStudent.getCrmClass() != null){
			String classId = crmStudent.getCrmClass().getClassId();
			if(classId != null && !"".equals(classId)){
				builder.append(" and crmClass = ?");
				paramsList.add(crmStudent.getCrmClass());
			} else {
				if(crmStudent.getCrmClass().getCrmCourseType() != null){
					String courseTypeId = crmStudent.getCrmClass().getCrmCourseType().getCourseTypeId();
					if(courseTypeId != null && !"".equals(courseTypeId)){
						builder.append(" and crmClass.crmCourseType = ?");
						paramsList.add(crmStudent.getCrmClass().getCrmCourseType());
					}
				}
			}
		}
		//2 其他
		if(crmStudent.getCondition() != null && !"".equals(crmStudent.getCondition())){
			
			//2.1 名称
			builder.append(" and (name like ?");
			paramsList.add("%"+crmStudent.getCondition()+"%");
			//2.2 qq
			builder.append(" or qq like ?");
			paramsList.add("%"+crmStudent.getCondition()+"%");
			//2.3 电话
			builder.append(" or telephone like ?");
			paramsList.add("%"+crmStudent.getCondition()+"%");
			//2.4 性别
			builder.append(" or gender = ? )");
			paramsList.add(crmStudent.getCondition());
			
			
		}
		
		// 3 排序
		builder.append(" order by status");
		
		return this.studentDao.findAll(builder.toString(), paramsList.toArray());
	}
	@Override
	public List<CrmStudent> findAll(String classId) {
		//查询指定班级的学生，退费的除外
		
		
		return this.studentDao.findAll(" and crmClass.classId = ? and status != ?", classId,CommonConstant.STUDENT_STATUS_RUNOFF);
	}
	
	
	

}
