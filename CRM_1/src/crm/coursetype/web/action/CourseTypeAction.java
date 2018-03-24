
package crm.coursetype.web.action;

import java.util.List;

import crm.base.BaseAction;
import crm.coursetype.domain.CrmCourseType;

/**  
 * <p>Title: CourseTypeAction</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午6:56:47
 */
public class CourseTypeAction extends BaseAction<CrmCourseType> {
		
	
	
	public String findAll(){
		
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll(this.getModel());
		
		this.set("allCourseType", allCourseType);
		return "findAll";
	}
	
	
	
	public String preAddOrEdit(){
		if(this.getModel().getCourseTypeId() != null){
			
			CrmCourseType findCourseType  = this.getCourseTypeService().findById(this.getModel().getCourseTypeId());
			
			this.push(findCourseType);
			
			
		}
		return "preAddOrEdit";
	}
	public String addOrEdit(){
		this.getCourseTypeService().addOrEdit(this.getModel());
		
		
		return "addOrEdit";
	}
	
}
