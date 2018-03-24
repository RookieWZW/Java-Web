package crm.refer.service.impl;

import java.util.ArrayList;
import java.util.List;

import crm.refer.dao.ReferDao;
import crm.refer.domain.CrmRefer;
import crm.refer.service.ReferService;
import crm.utils.CrmBeanUtils;

public class ReferServiceImpl implements ReferService {
	
	private ReferDao referDao;
	public void setReferDao(ReferDao referDao) {
		this.referDao = referDao;
	}
	@Override
	public void addOrEdit(CrmRefer crmRefer) {
		this.referDao.saveOrUpdate(crmRefer);
	}
	@Override
	public List<CrmRefer> findAll() {
		return this.referDao.findAll();
	}
	@Override
	public CrmRefer findById(String referId) {
		return this.referDao.findById(referId);
	}
	@Override
	public List<CrmRefer> findAll(CrmRefer crmRefer) {
		
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		//1 设置状态
		builder.append(" and status = ?");
		paramsList.add(crmRefer.getStatus());
		
		//2 条件查询
		// * 拼写语句时需要使用括号() ，需要生产sql为 and( ... or ... or ...)
		// * 默认生成的语句 and ( ... ) or ... or ...
		if(crmRefer.getCondition() != null && !"".equals(crmRefer.getCondition())){
			//1 名称 ,必须是and 否则 1=1 true 短路
			builder.append(" and (name like ?");
			paramsList.add("%"+crmRefer.getCondition()+"%");
			//2 qq
			builder.append(" or qq like ?");
			paramsList.add("%"+crmRefer.getCondition()+"%");
			//3 电话
			builder.append(" or telephone like ?)");
			paramsList.add("%"+crmRefer.getCondition()+"%");
		}
		
		return this.referDao.findAll(builder.toString(), paramsList.toArray());
	}
	@Override
	public void addRefer(CrmRefer crmRefer) {
		// TODO 如何设置关联数据为""
		if(crmRefer.getCrmClass() != null && "".equals(crmRefer.getCrmClass().getClassId())){
			crmRefer.setCrmClass(null);
		}
		if(crmRefer.getCrmCourseType() != null && "".equals(crmRefer.getCrmCourseType().getCourseTypeId())){
			crmRefer.setCrmCourseType(null);
		}
		
		this.referDao.save(crmRefer);
	}
	@Override
	public void updateRefer(CrmRefer crmRefer) {
		CrmRefer findRefer = this.referDao.findById(crmRefer.getReferId());
		//this.referDao.update(crmRefer);
		
		//手动设置
//		findRefer.setName(crmRefer.getName());
//		findRefer.setTelephone(crmRefer.getTelephone());
//		findRefer.setQq(crmRefer.getQq());
//		findRefer.setIntentionLevel(crmRefer.getIntentionLevel());
//		findRefer.setCrmCourseType(crmRefer.getCrmCourseType());
//		findRefer.setCrmClass(crmRefer.getCrmClass());
//		findRefer.setSource(crmRefer.getSource());
//		findRefer.setRemark(crmRefer.getRemark());
		//自动设置--只要不为空
		CrmBeanUtils.changeProperty(crmRefer,findRefer);
		
		//TODO 如何设置关联数据为""
		if(crmRefer.getCrmClass() != null && "".equals(crmRefer.getCrmClass().getClassId())){
			findRefer.setCrmClass(null);
		}
		if(crmRefer.getCrmCourseType() != null && "".equals(crmRefer.getCrmCourseType().getCourseTypeId())){
			findRefer.setCrmCourseType(null);
		}
	}

}
