/**   
* @Title: IBaseDaoImpl.java 
* @Package bos.dao.base.impl 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����2:22:48 
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
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bos.dao.base.BaseDao;


/** 
* @ClassName: BaseDaoImpl 
* @Description: TODO(������һ�仰��������������) 
* @author RookieWangZhiWei
* @date 2018��3��25�� ����2:22:48 
*  
*/
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



}
