
package crm.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import crm.base.BaseDao;
import crm.page.PageHibernateCallback;


/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午11:15:58
 * @version :
 * 
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> beanClass;
	public BaseDaoImpl(){
		
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		
		beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(beanClass, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from "+beanClass.getName());
		
	}

	@Override
	public List<T> findAll(String condition, Object[] params) {
		// TODO Auto-generated method stub
		String hql = "from " + beanClass.getName() + " where 1 = 1 " + condition;
		return this.getHibernateTemplate().find(hql,params);
	}

	@Override
	public List<T> findAllWithPage(int startIndex, int pageSize) {
		String hql = "from " + beanClass.getName();
		Object[] params = {};
		return this.getHibernateTemplate().execute(new PageHibernateCallback<T>(hql, params, startIndex, pageSize));
	}

	@Override
	public int getTotalRecord() {
		// TODO Auto-generated method stub
		List<Long> allData = this.getHibernateTemplate().find("select count(u) from "+beanClass.getName()+" u");
		return allData.get(0).intValue();
	}

}
