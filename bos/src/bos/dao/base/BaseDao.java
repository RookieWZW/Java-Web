/**   
* @Title: IBaseDao.java 
* @Package bos.dao.base 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午2:20:24 
* @version V1.0   
*/
package bos.dao.base;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: BaseDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午2:20:24 
*  
*/
public interface BaseDao<T> {
	public void save(T t);
	public void delete(T t);
	
	public void update(T t);
	public T findById(Serializable id);
	public List<T> findAll();
	public void executeUpdate(String queryName,Object...objects);
}
