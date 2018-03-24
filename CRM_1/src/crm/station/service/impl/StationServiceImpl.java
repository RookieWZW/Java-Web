package crm.station.service.impl;

import java.util.List;

import crm.classesm.dao.ClassDao;
import crm.classesm.domain.CrmClass;
import crm.constant.CommonConstant;
import crm.station.dao.StationDao;
import crm.station.domain.CrmStation;
import crm.station.service.StationService;
import crm.student.dao.StudentDao;
import crm.student.domain.CrmStudent;

public class StationServiceImpl implements StationService {
	
	private StationDao stationDao;
	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	private ClassDao classDao;
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	@Override
	public void addStation(CrmStation crmStation) {
		CrmStudent crmStudent = this.studentDao.findById(crmStation.getCrmStudent().getStudentId());
		//修改学生的状态
		crmStudent.setStatus(crmStation.getFlag());
		//修改学生当前班级
		crmStudent.setCrmClass(crmStation.getAfterClass());
		
		//之前班级总数-1，之后班级+1
		CrmClass beforeClass = this.classDao.findById(crmStation.getBeforeClass().getClassId());
		CrmClass afterClass = this.classDao.findById(crmStation.getAfterClass().getClassId());
		beforeClass.setTotalCount(beforeClass.getTotalCount() -1);
		afterClass.setTotalCount(afterClass.getTotalCount() + 1);
		
		//之前班级的升级或转班数 变化，之后班级没有变化，升级和转班指当前班级。
		if(CommonConstant.STUDENT_STATUS_UPGRADE.equals(crmStation.getFlag())){
			//之前班级--升级
			beforeClass.setUpgradeCount(beforeClass.getUpgradeCount() + 1);
		}
		if(CommonConstant.STUDENT_STATUS_CHANGE.equals(crmStation.getFlag())){
			//之前班级--转班
			beforeClass.setChangeCount(beforeClass.getChangeCount() + 1);
		}
		
		
		this.stationDao.save(crmStation);
	}
	@Override
	public List<CrmStation> findAll() {
		return this.stationDao.findAll();
	}
	
	

}
