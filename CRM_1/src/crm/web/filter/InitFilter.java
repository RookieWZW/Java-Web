 
package crm.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import crm.staff.domain.CrmStaff;
import crm.staff.service.StaffService;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午8:41:28
 * @version :
 * 
 */
public class InitFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String initAdmin = filterConfig.getInitParameter("initAdmin");
		if(Boolean.valueOf(initAdmin)){
			CrmStaff crmStaff = new CrmStaff();
			crmStaff.setLoginName("jack");
			crmStaff.setLoginPwd("1234");
			crmStaff.setStaffName("管理员");
			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
			StaffService staffService = (StaffService) webApplicationContext.getBean("StaffService");
			
			CrmStaff findStaff = staffService.login(crmStaff);
			if(findStaff == null){
				staffService.addStaff(crmStaff);
			}
		}
	}
	
}
