/**   
* @Title: UserDao.java 
* @Package bos.dao 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����2:36:32 
* @version V1.0   
*/
package bos.dao;

import bos.dao.base.BaseDao;
import bos.domain.User;

/** 
* @ClassName: UserDao 
* @Description: TODO(������һ�仰��������������) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����2:36:32 
*  
*/
public interface UserDao extends BaseDao<User> {
	public User findByUsernameAndPassword(String username,String password);
}
