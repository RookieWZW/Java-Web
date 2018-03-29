/**   
* @Title: SubareaServiceImpl.java 
* @Package bos.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月27日 下午10:39:27 
* @version V1.0   
*/
package bos.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.SubareaDao;
import bos.domain.Subarea;
import bos.service.SubareaService;
import bos.utils.PageBean;


@Service
@Transactional
public class SubareaServiceImpl implements SubareaService {
	@Resource
	private SubareaDao subareaDao;
	/*
	* Title: save
	*Description: 
	* @param model 
	* @see bos.service.SubareaService#save(bos.domain.Subarea) 
	*/
	public void save(Subarea model) {
		// TODO Auto-generated method stub
			subareaDao.save(model);
	}

	/*
	* Title: pageQuery
	*Description: 
	* @param pageBean 
	* @see bos.service.SubareaService#pageQuery(bos.utils.PageBean) 
	*/
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		subareaDao.pageQuery(pageBean);
	}

	/*
	* Title: findAll
	*Description: 
	* @return 
	* @see bos.service.SubareaService#findAll() 
	*/
	public List<Subarea> findAll() {
		// TODO Auto-generated method stub
		return subareaDao.findAll();
	}

}
