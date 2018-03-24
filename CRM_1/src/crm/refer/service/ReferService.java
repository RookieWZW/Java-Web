package crm.refer.service;

import java.util.List;

import crm.refer.domain.CrmRefer;

public interface ReferService {
	
	/**
	 * 添加或编辑
	 * @param crmRefer
	 */
	public void addOrEdit(CrmRefer crmRefer);
	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmRefer> findAll();
	/**
	 * 条件查询
	 * @param condition
	 * @return
	 */
	public List<CrmRefer> findAll(CrmRefer crmRefer);
	/**
	 * 通过id查询
	 * @param crmRefer
	 * @return
	 */
	public CrmRefer findById(String referId);
	/**
	 * 添加
	 * @param model
	 */
	public void addRefer(CrmRefer crmRefer);
	/**
	 * 编辑
	 * @param model
	 */
	public void updateRefer(CrmRefer crmRefer);

}
