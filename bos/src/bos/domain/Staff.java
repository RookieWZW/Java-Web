/**   
* @Title: Staff.java 
* @Package bos.domain 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午10:34:16 
* @version V1.0   
*/
package bos.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Staff implements Serializable {
	private String id;
	private String name;
	private String telephone;
	private String haspda = "0";// 是否有PDA 1：有 0：无
	private String deltag = "0";// 删除标识位 1：已删除 0：未删除
	private String station;
	private String standard;
	private Set decidedzones = new HashSet(0);

	public Staff() {
	}

	/** minimal constructor */
	public Staff(String id) {
		this.id = id;
	}

	/** full constructor */
	public Staff(String id, String name, String telephone, String haspda, String deltag, String station,
			String standard, Set decidedzones) {
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.haspda = haspda;
		this.deltag = deltag;
		this.station = station;
		this.standard = standard;
		this.decidedzones = decidedzones;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the haspda
	 */
	public String getHaspda() {
		return haspda;
	}

	/**
	 * @param haspda
	 *            the haspda to set
	 */
	public void setHaspda(String haspda) {
		this.haspda = haspda;
	}

	/**
	 * @return the deltag
	 */
	public String getDeltag() {
		return deltag;
	}

	/**
	 * @param deltag
	 *            the deltag to set
	 */
	public void setDeltag(String deltag) {
		this.deltag = deltag;
	}

	/**
	 * @return the station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * @param station
	 *            the station to set
	 */
	public void setStation(String station) {
		this.station = station;
	}

	/**
	 * @return the standard
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * @param standard
	 *            the standard to set
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * @return the decidedzones
	 */
	public Set getDecidedzones() {
		return decidedzones;
	}

	/**
	 * @param decidedzones
	 *            the decidedzones to set
	 */
	public void setDecidedzones(Set decidedzones) {
		this.decidedzones = decidedzones;
	}

}
