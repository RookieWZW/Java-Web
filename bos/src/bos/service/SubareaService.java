/**   
* @Title: SubareaService.java 
* @Package bos.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��27�� ����10:32:40 
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
