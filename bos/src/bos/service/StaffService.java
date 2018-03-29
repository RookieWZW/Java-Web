/**   
* @Title: StaffService.java 
* @Package bos.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��27�� ����4:55:22 
* @version V1.0   
*/
package bos.service;

import bos.domain.Staff;
import bos.utils.PageBean;

public interface StaffService {
	public void svae(Staff model);

	public void pageQuery(PageBean pageBean);

	public void deleteBatch(String ids);

	public Staff findById(String id);

	public void update(Staff staff);
}
