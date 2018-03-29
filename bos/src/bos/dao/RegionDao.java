/**   
* @Title: RegionDao.java 
* @Package bos.dao 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��27�� ����10:25:42 
* @version V1.0   
*/
package bos.dao;

import java.util.List;

import bos.dao.base.BaseDao;
import bos.domain.Region;

public interface RegionDao extends BaseDao<Region> {
	public List<Region> findByQ(String q);
}