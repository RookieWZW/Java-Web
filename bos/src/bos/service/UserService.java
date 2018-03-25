/**   
* @Title: UserService.java 
* @Package bos.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午3:42:37 
* @version V1.0   
*/
package bos.service;

import bos.domain.User;

public interface UserService {
	public User login(User model);
	
	public void editPassword(String password,String id);
}
