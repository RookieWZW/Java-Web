package crm.page;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午3:03:51
 * @version :
 * 
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

	private String hql; // hql语句
	private Object[] params; // hql语句的实际查询条件
	private int startIndex; // 开始索引
	private int pageSize; // 每页显示的个数

	public PageHibernateCallback(String hql, Object[] params, int startIndex,
			int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	// spring 在执行查询时，会执行doInHibernate方法。
	@SuppressWarnings("unchecked")
	@Override
	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {

		Query queryObject = session.createQuery(hql);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				queryObject.setParameter(i, params[i]);

			}
		}

		// 开始索引
		if (startIndex > 0) {
			queryObject.setFirstResult(startIndex);
		}
		if (pageSize > 0) {
			queryObject.setMaxResults(pageSize);
		}

		return queryObject.list();
	}

}
