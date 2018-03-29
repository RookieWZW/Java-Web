/**   
* @Title: RegionServiceImpl.java 
* @Package bos.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月27日 下午10:34:11 
* @version V1.0   
*/
package bos.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.RegionDao;
import bos.domain.Region;
import bos.service.RegionService;
import bos.utils.PageBean;

@Service
@Transactional
public class RegionServiceImpl implements RegionService {
	
	
	@Resource
	private RegionDao regionDao;
	/*
	* Title: saveBatch
	*Description: 
	* @param list 
	* @see bos.service.RegionService#saveBatch(java.util.List) 
	*/
	public void saveBatch(List<Region> list) {
		// TODO Auto-generated method stub
		for (Region region : list) {
			regionDao.saveOrUpdate(region);
		}
	}

	/*
	* Title: pageQuery
	*Description: 
	* @param pageBean 
	* @see bos.service.RegionService#pageQuery(bos.utils.PageBean) 
	*/
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		regionDao.pageQuery(pageBean);
	}

	/*
	* Title: findAll
	*Description: 
	* @return 
	* @see bos.service.RegionService#findAll() 
	*/
	public List<Region> findAll() {
		// TODO Auto-generated method stub
		return regionDao.findAll();
	}

	/*
	* Title: findByQ
	*Description: 
	* @param q
	* @return 
	* @see bos.service.RegionService#findByQ(java.lang.String) 
	*/
	public List<Region> findByQ(String q) {
		// TODO Auto-generated method stub
		return regionDao.findByQ(q);
	}

}
