/**   
* @Title: RegionDao.java 
* @Package bos.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月27日 下午10:25:42 
* @version V1.0   
*/
package bos.dao;

import java.util.List;

import bos.dao.base.BaseDao;
import bos.domain.Region;

public interface RegionDao extends BaseDao<Region> {
	public List<Region> findByQ(String q);
}
