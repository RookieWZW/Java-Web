package crm.follow.service;

import crm.follow.domain.CrmFollow;
/**
 * 
* <p>Title: FollowService</p>  
* <p>Description: </p>   
* @author RookieWangZhiWei  
* @date 2018-3-23 下午7:21:44
 */
public interface FollowService {
	
	/**
	 * 添加或编辑
	 * @param crmFollow
	 */
	public void addOrEdit(CrmFollow crmFollow);

	/**
	 * 通过id查询
	 * @param followId
	 * @return
	 */
	public CrmFollow findById(String followId);

}
