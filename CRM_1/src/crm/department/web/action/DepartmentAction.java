
package crm.department.web.action;

import java.util.List;

import crm.base.BaseAction;
import crm.department.domain.CrmDepartment;

/**  
 * <p>Title: DepartmentAction</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午7:14:32
 */
public class DepartmentAction extends BaseAction<CrmDepartment> {
	
	
	public String findAll(){
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		this.set("allDepartment", allDepartment);
		return "findAll";
	}
	
	
	public String preAddOrEdit(){
		if(this.getModel().getDepId() != null){
			CrmDepartment findDepartment = this.getDepartmentService().findById(this.getModel().getDepId());
			this.push(findDepartment);
		}
		return "preAddOrEdit";
	}
	
	public String addOrEdit(){
		this.getDepartmentService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	
}
