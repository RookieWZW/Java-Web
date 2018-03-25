/**   
* @Title: UserServiceImpl.java 
* @Package bos.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午3:43:45 
* @version V1.0   
*/
package bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.UserDao;
import bos.domain.User;
import bos.service.UserService;
import bos.utils.MD5Utils;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	/*
	* Title: login
	*Description: 
	* @param model
	* @return 
	* @see bos.service.UserService#login(bos.domain.User) 
	*/
	public User login(User model) {
		// TODO Auto-generated method stub
		String username = model.getUsername();
		String password = model.getPassword();
		password = MD5Utils.md5(password);
		return userDao.findByUsernameAndPassword(username, password);
	}

	/*
	* Title: editPassword
	*Description: 
	* @param password
	* @param id 
	* @see bos.service.UserService#editPassword(java.lang.String, java.lang.String) 
	*/
	public void editPassword(String password, String id) {
		// TODO Auto-generated method stub
		userDao.executeUpdate("editPassword", password,id);
	}

}
