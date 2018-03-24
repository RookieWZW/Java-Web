package crm.post.dao;

import java.util.List;

import crm.base.BaseDao;
import crm.post.domain.CrmPost;
/**
 * 
* <p>Title: PostDao</p>  
* <p>Description: </p>   
* @author RookieWangZhiWei  
* @date 2018-3-23 下午7:48:19
 */
public interface PostDao extends BaseDao<CrmPost>  {

	
	List<CrmPost> findAll(String depId);

}
