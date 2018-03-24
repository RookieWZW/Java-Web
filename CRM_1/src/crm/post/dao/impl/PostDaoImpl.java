package crm.post.dao.impl;

import java.util.List;

import crm.base.impl.BaseDaoImpl;
import crm.post.dao.PostDao;
import crm.post.domain.CrmPost;
/**
 * 
* <p>Title: PostDaoImpl</p>  
* <p>Description: </p>   
* @author RookieWangZhiWei  
* @date 2018-3-23 下午7:48:33
 */
public class PostDaoImpl extends BaseDaoImpl<CrmPost> implements PostDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmPost> findAll(String depId) {
		return this.getHibernateTemplate().find("from CrmPost p where p.crmDepartment.depId = ?" , depId);
	}

}
