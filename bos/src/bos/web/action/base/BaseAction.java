/**   
* @Title: BaseAction.java 
* @Package bos.web.action.base 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午3:18:16 
* @version V1.0   
*/
package bos.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bos.service.RegionService;
import bos.service.StaffService;
import bos.service.SubareaService;
import bos.utils.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	@Autowired
	protected StaffService staffService;

	@Autowired
	protected RegionService regionService;

	@Autowired
	protected SubareaService subareaService;

	protected PageBean pageBean = new PageBean();

	
	DetachedCriteria detachedCriteria = null;
	
	private void setRow(int rows) {
		// TODO Auto-generated method stub
		pageBean.setPageSize(rows);
	}

	private void setPage(int page) {
		// TODO Auto-generated method stub
		pageBean.setCurrentPage(page);
	}

	protected T model;

	/*
	 * Title: getModel Description:
	 * 
	 * @return
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public T getModel() {

		return model;
	}

	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		// 获得实体类型
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		
		detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
		
		try {
			model = entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writePageBean2Json(PageBean pageBean, String[] excludes) throws IOException {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);

		JSONObject jsonObject = JSONObject.fromObject(pageBean, jsonConfig);

		String json = jsonObject.toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(json);
	}

	

	public void writeList2Json(List list, String[] excludes) throws IOException {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);
		JSONArray jsonObject = JSONArray.fromObject(list, jsonConfig);
		String json = jsonObject.toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(json);
	}

}
