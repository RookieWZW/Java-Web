
package crm.base;

import java.util.List;

/**
 * 
* <p>Title: BaseDao</p>  
* <p>Description: </p>   
* @author RookieWangZhiWei  
* @date 2018-3-22 下午11:06:58
 */
public interface BaseDao<T>{
	
	/**
	 * 
	* @Title: save   
	* @Description: TODO   
	* @param @param t      
	* @return void     
	* @throws
	 */
	public void save(T t);
	
	/**
	 * 
	* @Title: update   
	* @Description: TODO   
	* @param @param t      
	* @return void     
	* @throws
	 */
	public void update(T t);
	
	
	/**
	 * 
	* @Title: saveOrUpdate   
	* @Description: TODO   
	* @param @param t      
	* @return void     
	* @throws
	 */
	public void saveOrUpdate(T t);
	
	
	/**
	 * 
	* @Title: delete   
	* @Description: TODO   
	* @param @param t      
	* @return void     
	* @throws
	 */
	public void delete(T t);
	
	public T findById(java.io.Serializable id);
	
	/**
	 * 
	* @Title: findAll   
	* @Description: TODO   
	* @param @return      
	* @return List<T>     
	* @throws
	 */
	public List<T> findAll();
	
	
	public List<T> findAll(String condition,Object ... params);
	
	public List<T> findAllWithPage(int startIndex,int pageSize);
	
	public int getTotalRecord();
	
}
