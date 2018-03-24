package crm.runoff.service;

import java.util.List;

import crm.runoff.domain.CrmRunOff;

public interface RunOffService {

	void addRunoff(CrmRunOff crmRunOff);

	List<CrmRunOff> findAll();


}
