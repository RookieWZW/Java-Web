
package crm.classesm.service;

import java.util.List;

import crm.classesm.domain.CrmClass;
import crm.coursetype.domain.CrmCourseType;

/**  
 * <p>Title: ClassService</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午12:33:56
 */
public interface ClassService {
	public List<CrmClass> findAll();
	
	public CrmClass findById(String classId);
	
	public void addOrEdit(CrmClass crmClass);
	
	public List<CrmClass> findAll(CrmCourseType courseType);
	
	public void updateSchedule(CrmClass model);
}
