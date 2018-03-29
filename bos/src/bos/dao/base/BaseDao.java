/**   
* @Title: IBaseDao.java 
* @Package bos.dao.base 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����2:20:24 
* @version V1.0   
*/
package bos.dao.base;

import java.io.Serializable;
import java.util.List;

import bos.utils.PageBean;

/** 
* @ClassName: BaseDao 
* @Description: TODO(������һ�仰��������������) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����2:20:24 
*  
*/
public interface BaseDao<T> {
	public void save(T t);
	public void delete(T t);
	
	public void update(T t);
	public void saveOrUpdate(T t);
	public T findById(Serializable id);
	public List<T> findAll();
	public void executeUpdate(String queryName,Object...objects);
	public void pageQuery(PageBean pageBean);
}
