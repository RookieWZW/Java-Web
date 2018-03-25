/**   
* @Title: UserDao.java 
* @Package bos.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午2:36:32 
* @version V1.0   
*/
package bos.dao;

import bos.dao.base.BaseDao;
import bos.domain.User;

/** 
* @ClassName: UserDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午2:36:32 
*  
*/
public interface UserDao extends BaseDao<User> {
	public User findByUsernameAndPassword(String username,String password);
}
