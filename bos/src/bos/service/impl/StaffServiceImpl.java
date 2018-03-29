/**   
* @Title: StaffServiceImpl.java 
* @Package bos.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月27日 下午4:56:46 
* @version V1.0   
*/
package bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.StaffDao;
import bos.domain.Staff;
import bos.service.StaffService;
import bos.utils.PageBean;


@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;
	
	/*
	* Title: svae
	*Description: 
	* @param model 
	* @see bos.service.StaffService#svae(bos.domain.Staff) 
	*/
	public void svae(Staff model) {
		// TODO Auto-generated method stub
		staffDao.save(model);
	}

	/*
	* Title: pageQuery
	*Description: 
	* @param pageBean 
	* @see bos.service.StaffService#pageQuery(bos.utils.PageBean) 
	*/
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		staffDao.pageQuery(pageBean);
	}

	/*
	* Title: deleteBatch
	*Description: 
	* @param ids 
	* @see bos.service.StaffService#deleteBatch(java.lang.String) 
	*/
	public void deleteBatch(String ids) {
		// TODO Auto-generated method stub
		String[] staffIds = ids.split(",");
		for (String string : staffIds) {
			staffDao.executeUpdate("staff.delete", string);
		}
	}

	/*
	* Title: findById
	*Description: 
	* @param id
	* @return 
	* @see bos.service.StaffService#findById(java.lang.String) 
	*/
	public Staff findById(String id) {
		// TODO Auto-generated method stub
		return staffDao.findById(id);
	}

	/*
	* Title: update
	*Description: 
	* @param staff 
	* @see bos.service.StaffService#update(bos.domain.Staff) 
	*/
	public void update(Staff staff) {
		// TODO Auto-generated method stub
			staffDao.update(staff);
	}

}
