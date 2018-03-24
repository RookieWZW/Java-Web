package crm.follow.service.impl;

import crm.follow.dao.FollowDao;
import crm.follow.domain.CrmFollow;
import crm.follow.service.FollowService;
/**
 * 
* <p>Title: FollowServiceImpl</p>  
* <p>Description: </p>   
* @author RookieWangZhiWei  
* @date 2018-3-23 下午7:21:40
 */
public class FollowServiceImpl implements FollowService {
	
	private FollowDao followDao;
	public void setFollowDao(FollowDao followDao) {
		this.followDao = followDao;
	}
	
	public void addOrEdit(CrmFollow crmFollow){
		this.followDao.saveOrUpdate(crmFollow);
	}

	@Override
	public CrmFollow findById(String followId) {
		return this.followDao.findById(followId);
	}

}
