package crm.post.service;

import java.util.List;

import crm.post.domain.CrmPost;

public interface PostService {

	/**
	 * 通过部门id查询所有的职务
	 * @param depId
	 * @return
	 */
	List<CrmPost> findAll(String depId);

	/**
	 * 查询所有的职务
	 * @return
	 */
	List<CrmPost> findAll();

	/**
	 * 通过id查询
	 * @param postId
	 * @return
	 */
	CrmPost findById(String postId);

	/**
	 * 添加或编辑
	 * @param crmPost
	 */
	void addOrEdit(CrmPost crmPost);

}
