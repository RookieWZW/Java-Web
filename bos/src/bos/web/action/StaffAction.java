/**   
* @Title: StaffAction.java 
* @Package bos.web.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月27日 下午5:01:07 
* @version V1.0   
*/
package bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bos.domain.Staff;
import bos.service.StaffService;
import bos.utils.PageBean;
import bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
		
	
	@Autowired
	private StaffService staffService;
	
	
	private int page;
	private int row;
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	
	
	public String add() {
		staffService.svae(model);
		
		return "list";
	}
	
	public String pageQuery() throws IOException {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(row);
		
		DetachedCriteria detachedCriteria =DetachedCriteria.forClass(Staff.class);
		
		pageBean.setDetachedCriteria(detachedCriteria);
		
		staffService.pageQuery(pageBean);
		
		JsonConfig jsonConfig = new JsonConfig();
		
		jsonConfig.setExcludes(new String[] {"currentPage","detachedCriteria","pageSize"});
		
		JSONObject jsonObject =JSONObject.fromObject(pageBean,jsonConfig);
		
		String json = jsonObject.toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		
		ServletActionContext.getResponse().getWriter().println(json);
		
		return NONE;
	}
	
	public String ids;
	/**
	 * @param ids the ids to set
	 */
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	public String delete() {
		staffService.deleteBatch(ids);
		return "list";
	}
	
	public String edit() {
		Staff staff = staffService.findById(model.getId());
		
		
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setStation(model.getStation());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		
		staffService.update(staff);
		return "list";
	}
}
