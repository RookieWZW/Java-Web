/**   
* @Title: IBaseDaoImpl.java 
* @Package bos.dao.base.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午2:22:48 
* @version V1.0   
*/
package bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bos.dao.base.BaseDao;
import bos.utils.PageBean;



public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	
	private Class<T> entityClass;
	
	
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	/** 
	* <p>Title: </p> 
	* <p>Description: </p>  
	*/
	public BaseDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		
		Class<T> class1 = (Class<T>) actualTypeArguments[0];
		entityClass = class1;
		System.out.println("create success");
	}

	/*
	* Title: save
	*Description: 
	* @param t 
	* @see bos.dao.base.BaseDao#save(java.lang.Object) 
	*/
	public void save(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
	}

	/*
	* Title: delete
	*Description: 
	* @param t 
	* @see bos.dao.base.BaseDao#delete(java.lang.Object) 
	*/
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}

	/*
	* Title: update
	*Description: 
	* @param t 
	* @see bos.dao.base.BaseDao#update(java.lang.Object) 
	*/
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}

	/*
	* Title: findById
	*Description: 
	* @param id
	* @return 
	* @see bos.dao.base.BaseDao#findById(java.io.Serializable) 
	*/
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(entityClass, id);
	}

	/*
	* Title: findAll
	*Description: 
	* @return 
	* @see bos.dao.base.BaseDao#findAll() 
	*/
	//@SuppressWarnings("unchecked")
	public List<T> findAll() {
		// TODO Auto-generated method stub
		String hql = "FROM  " + entityClass.getSimpleName();
		return this.getHibernateTemplate().find(hql);
	}

	/*
	* Title: executeUpdate
	*Description: 
	* @param queryName
	* @param objects 
	* @see bos.dao.base.BaseDao#executeUpdate(java.lang.String, java.lang.Object[]) 
	*/
	public void executeUpdate(String queryName, Object... objects) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		
		Query query = session.getNamedQuery(queryName);
		
		int i = 0;
		for (Object arg : objects) {
			query.setParameter(i++, arg);
		}
		query.executeUpdate();
	}

	/*
	* Title: pageQuery
	*Description: 
	* @param pageBean 
	* @see bos.dao.base.BaseDao#pageQuery(bos.utils.PageBean) 
	*/
	public void pageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		//总数据量----select count(*) from bc_staff
		//改变Hibernate框架发出的sql形式
		detachedCriteria.setProjection(Projections.rowCount());//select count(*) from bc_staff
		List<Long> list = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long total = list.get(0);
		pageBean.setTotal(total.intValue());//设置总数据量
		detachedCriteria.setProjection(null);//修改sql的形式为select * from ....
		//重置表和类的映射关系
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
		//当前页展示的数据集合
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
	}
	/*
	* Title: saveOrUpdate
	*Description: 
	* @param t 
	* @see bos.dao.base.BaseDao#saveOrUpdate(java.lang.Object) 
	*/
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(t);
	}



}
