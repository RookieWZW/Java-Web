package crm.station.service;

import java.util.List;

import crm.station.domain.CrmStation;

public interface StationService {

	void addStation(CrmStation crmStation);
	
	List<CrmStation> findAll();

}
