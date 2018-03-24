package crm.graduate.service;

import java.util.List;

import crm.graduate.domain.CrmGraduate;
/**
 * 
* <p>Title: GraduateService</p>  
* <p>Description: </p>   
* @author RookieWangZhiWei  
* @date 2018-3-23 下午7:45:26
 */
public interface GraduateService {

	List<CrmGraduate> findAll();

	void addOrEdit(CrmGraduate crmGraduate);

}
