/**   
* @Title: UserService.java 
* @Package bos.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����3:42:37 
* @version V1.0   
*/
package bos.service;

import bos.domain.User;

public interface UserService {
	public User login(User model);
	
	public void editPassword(String password,String id);
}
