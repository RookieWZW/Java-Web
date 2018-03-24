
package crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import crm.coursetype.dao.CourseTypeDao;
import crm.coursetype.domain.CrmCourseType;
import crm.coursetype.service.CourseTypeService;

/**  
 * <p>Title: CourseTypeServiceImpl</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午6:51:47
 */
public class CourseTypeServiceImpl implements CourseTypeService {
	
	
	private CourseTypeDao courseTypeDao;
	
	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}

	@Override
	public List<CrmCourseType> findAll() {
		// TODO Auto-generated method stub
		return this.courseTypeDao.findAll();
	}

	@Override
	public void addOrEdit(CrmCourseType courseType) {
		// TODO Auto-generated method stub
		this.courseTypeDao.saveOrUpdate(courseType);
	}

	@Override
	public CrmCourseType findById(String courseTypeId) {
		// TODO Auto-generated method stub
		return this.courseTypeDao.findById(courseTypeId);
	}

	@Override
	public List<CrmCourseType> findAll(CrmCourseType crmCourseType) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		
		
		// 2.1 类别名称
				if(StringUtils.isNotBlank(crmCourseType.getCourseName())){
					builder.append(" and courseName like ? ");
					paramsList.add("%"+crmCourseType.getCourseName()+"%");
				}
				// 2.2 简介
				if(StringUtils.isNotBlank(crmCourseType.getRemark())){
					builder.append(" and remark like ? ");
					paramsList.add("%"+crmCourseType.getRemark()+"%");
				}
				
				// 2.3 学时范围，类型:int
				if(StringUtils.isNotBlank(crmCourseType.getTotalStart())){
					builder.append(" and total >= ? ");
					paramsList.add(Integer.parseInt(crmCourseType.getTotalStart()));
				}
				
				if(StringUtils.isNotBlank(crmCourseType.getTotalEnd())){
					builder.append(" and total <= ? ");
					paramsList.add(Integer.parseInt(crmCourseType.getTotalEnd()));
				}
				// 2.4 课程范围，类型:double
				if(StringUtils.isNotBlank(crmCourseType.getLessonCostStart())){
					builder.append(" and lessonCost >= ? ");
					paramsList.add(Double.parseDouble(crmCourseType.getLessonCostStart()));
				}
				
				if(StringUtils.isNotBlank(crmCourseType.getLessonCostEnd())){
					builder.append(" and lessonCost <= ? ");
					paramsList.add(Double.parseDouble(crmCourseType.getLessonCostEnd()));
				}
				
				
				
				String condition = builder.toString();
				Object[] params = paramsList.toArray();
				
				return this.courseTypeDao.findAll(condition, params);
		
	}
	

}
