
package crm.graduate.web.action;

import java.util.List;

import crm.base.BaseAction;
import crm.classesm.domain.CrmClass;
import crm.graduate.domain.CrmGraduate;

/**  
 * <p>Title: GraduateAction</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午7:46:39
 */
public class GraduateAction extends BaseAction<CrmGraduate> {
	
	public String preAddOrEdit(){
		//1查询所有的班级
		List<CrmClass> allClass = this.getClassService().findAll();
		this.set("allClass", allClass);
		
		return "preAddOrEdit";
	}
	
	
	public String addOrEdit(){
		this.getGraduateService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	public String findAll(){
		
		//2查询所有
		List<CrmGraduate> allGraduate = this.getGraduateService().findAll();
		this.set("allGraduate", allGraduate);
		
		return "findAll";
	}
	
}
