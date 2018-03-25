/**   
* @Title: UserDaoImpl.java 
* @Package bos.dao.impl 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����2:37:46 
* @version V1.0   
*/
package bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import bos.dao.UserDao;
import bos.dao.base.impl.BaseDaoImpl;
import bos.domain.User;

/** 
* @ClassName: UserDaoImpl 
* @Description: TODO(������һ�仰��������������) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����2:37:46 
*  
*/
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/*
	* Title: findByUsernameAndPassword
	*Description: 
	* @param username
	* @param password
	* @return 
	* @see bos.dao.UserDao#findByUsernameAndPassword(java.lang.String, java.lang.String) 
	*/
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = this.getHibernateTemplate().find(hql, username,password);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	
}
