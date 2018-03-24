
package crm.coursetype.service;

import java.util.List;

import crm.coursetype.domain.CrmCourseType;

/**  
 * <p>Title: CourseTypeService</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午6:49:34
 */
public interface CourseTypeService {
	
	
	List<CrmCourseType> findAll();
	
	void addOrEdit(CrmCourseType courseType);
	
	CrmCourseType findById(String courseTypeId);
	
	
	List<CrmCourseType> findAll(CrmCourseType courseType);
	
	
	
	
	
}
