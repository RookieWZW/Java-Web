/**   
* @Title: BaseAction.java 
* @Package bos.web.action.base 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午3:18:16 
* @version V1.0   
*/
package bos.web.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	protected T model;
	/*
	* Title: getModel
	*Description: 
	* @return 
	* @see com.opensymphony.xwork2.ModelDriven#getModel() 
	*/
	public T getModel() {
		
		return model;
	}
	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		//获得实体类型
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		try {
			model  = entityClass.newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
