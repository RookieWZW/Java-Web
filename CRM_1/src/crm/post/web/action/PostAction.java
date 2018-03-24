
package crm.post.web.action;

import java.util.List;

import crm.base.BaseAction;
import crm.department.domain.CrmDepartment;
import crm.post.domain.CrmPost;

/**  
 * <p>Title: PostAcion</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午7:51:07
 */
public class PostAction extends BaseAction<CrmPost> {
	public String ajaxGetPostion(){
		//获得部门id
		String depId = this.getModel().getCrmDepartment().getDepId();
		//通过部门id，查询所有职务
		List<CrmPost> allPost = this.getPostService().findAll(depId);
		// * 将查询结果存放值栈中 , jsp 通过“key”获得
		this.set("allPost", allPost);
		
		return "ajaxGetPostion";
	}
	
	public String findAll(){
		List<CrmPost> allPost = this.getPostService().findAll();
		this.set("allPost", allPost);
		
		return "findAll";
	}
	
	
	
	public String preAddOrEdit(){
		//1 查询当前职务（编辑）
		if(this.getModel().getPostId() != null){
			CrmPost findPost = this.getPostService().findById(this.getModel().getPostId());
			this.push(findPost);
		}
		// 2 查询所有部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		// jsp 通过 "#key" 获得数据
		this.put("allDepartment", allDepartment);
		
		return "preAddOrEdit";
	}
	
	
	public String addOrEdit(){
		this.getPostService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	
}
