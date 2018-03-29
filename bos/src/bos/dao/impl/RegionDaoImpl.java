/**   
* @Title: RegionDaoImpl.java 
* @Package bos.dao.impl 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��27�� ����10:27:28 
* @version V1.0   
*/
package bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import bos.dao.RegionDao;
import bos.dao.base.impl.BaseDaoImpl;
import bos.domain.Region;
import bos.utils.PageBean;


@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao {

	
	/*
	* Title: findByQ
	*Description: 
	* @param q
	* @return 
	* @see bos.dao.RegionDao#findByQ(java.lang.String) 
	*/
	public List<Region> findByQ(String q) {
		// TODO Auto-generated method stub
		String hql = "FROM Region WHERE province LIKE ? OR city LIKE ? OR district LIKE ?";
		return this.getHibernateTemplate().find(hql, "%"+q+"%","%"+q+"%","%"+q+"%");
	}

}
