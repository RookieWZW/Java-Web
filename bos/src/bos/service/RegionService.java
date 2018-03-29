/**   
* @Title: RegionService.java 
* @Package bos.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月27日 下午10:30:59 
* @version V1.0   
*/
package bos.service;

import java.util.List;

import bos.domain.Region;
import bos.utils.PageBean;

public interface RegionService {
	public void saveBatch(List<Region> list);
	
	public void pageQuery(PageBean pageBean);
	
	public List<Region> findAll();
	
	public List<Region> findByQ(String q);
}
