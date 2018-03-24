
package crm.runoff.web.action;

import java.util.Date;
import java.util.List;

import crm.base.BaseAction;
import crm.constant.CommonConstant;
import crm.runoff.domain.CrmRunOff;
import crm.staff.domain.CrmStaff;
import crm.student.domain.CrmStudent;



/**  
 * <p>Title: RunoffAction</p>  
 * <p>Description: </p>   
 * @author RookieWangZhiWei  
 * @date 2018-3-23 下午8:57:12
 */
public class RunOffAction extends BaseAction<CrmRunOff> {
	public String preAdd(){
		CrmStudent findStudent = this.getStudentService().findById(this.getModel().getCrmStudent().getStudentId());
		this.push(findStudent);
		return "preAdd";
	}
	
	public String add(){
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser"); 
		this.getModel().setCrmStaff(crmStaff);
		this.getModel().setCreateDate(new Date());
		//如果不退款，就没有退款金额
		if(CommonConstant.RUNOFF_REFUND_NOT.equals(this.getModel().getIsRefund())){
			this.getModel().setRefundAmount("");
		}
		
		this.getRunOffService().addRunoff(this.getModel());
		
		return "add";
	}
	public String findAll(){
		List<CrmRunOff> allRunOff = this.getRunOffService().findAll();
		this.set("allRunOff", allRunOff);
		
		return "findAll";
	}
}
