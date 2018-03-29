/**   
* @Title: PageBean.java 
* @Package bos.utils 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��27�� ����4:44:30 
* @version V1.0   
*/
package bos.utils;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public class PageBean {
	private int currentPage; //��ǰҳ��
	private int pageSize;  //ÿҳ��ʾ����
	private DetachedCriteria detachedCriteria;  //����������ѯ����
	private int total; // �ܾ�·��
	private List rows; //��ǰҳ��Ҫ��ʾ�����ݼ���
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the detachedCriteria
	 */
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	/**
	 * @param detachedCriteria the detachedCriteria to set
	 */
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the rows
	 */
	public List getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
