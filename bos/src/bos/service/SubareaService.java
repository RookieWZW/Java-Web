/**   
* @Title: SubareaService.java 
* @Package bos.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月27日 下午10:32:40 
* @version V1.0   
*/
package bos.service;

import java.util.List;

import bos.domain.Subarea;
import bos.utils.PageBean;

public interface SubareaService {
		public void save(Subarea model);
		
		public void pageQuery(PageBean pageBean);
		
		public List<Subarea> findAll();
}
