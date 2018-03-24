
package crm.follow.web.action;

import java.util.Date;

import crm.base.BaseAction;
import crm.follow.domain.CrmFollow;
import crm.staff.domain.CrmStaff;

/**  
 * <p>Title: FollowAction</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午7:24:41
 */
public class FollowAction extends BaseAction<CrmFollow> {
	private static final long serialVersionUID = -6362821775050123442L;
	
	public String preAddOrEdit(){
		if(this.getModel().getFollowId() != null){
			CrmFollow crmFollow = this.getFollowService().findById(this.getModel().getFollowId());
			this.push(crmFollow);
			
		
			
		}
		return "preAddOrEdit";
	}
	public String addOrEdit(){
		
		this.getModel().setFollowTime(new Date());
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
		this.getModel().setCrmStaff(crmStaff);
		
		this.getFollowService().addOrEdit(this.getModel());
		
		return "addOrEdit";
		
	}
	
}
