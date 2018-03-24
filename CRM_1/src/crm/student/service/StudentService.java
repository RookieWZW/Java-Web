package crm.student.service;

import java.util.List;

import crm.student.domain.CrmStudent;

public interface StudentService {
	/**
	 * 添加或编辑
	 */
	public void addOrEdit(CrmStudent crmStudent);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmStudent> findAll();
	
	/**
	 * 条件查询
	 * @param crmStudent
	 * @return
	 */
	public List<CrmStudent> findAll(CrmStudent crmStudent);
	
	/**
	 * 通过id查询
	 * @return
	 */
	public CrmStudent findById(String studentId);

	/**
	 * 查询指定班级的所有的学生
	 * @param classId
	 * @return
	 */
	public List<CrmStudent> findAll(String classId);
}
