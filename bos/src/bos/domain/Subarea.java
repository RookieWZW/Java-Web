/**   
* @Title: Subarea.java 
* @Package bos.domain 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月25日 下午10:29:54 
* @version V1.0   
*/
package bos.domain;

import java.io.Serializable;

public class Subarea implements Serializable {
	private String id;
	private Decidedzone decidedzone;
	private Region region;
	private String addresskey;
	private String startnum;
	private String endnum;
	private String single;
	private String position;

	

	/** default constructor */
	public Subarea() {
	}

	/** minimal constructor */
	public Subarea(String id) {
		this.id = id;
	}

	/** full constructor */
	public Subarea(String id, Decidedzone decidedzone, Region region,
			String addresskey, String startnum, String endnum, String single,
			String position) {
		this.id = id;
		this.decidedzone = decidedzone;
		this.region = region;
		this.addresskey = addresskey;
		this.startnum = startnum;
		this.endnum = endnum;
		this.single = single;
		this.position = position;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the decidedzone
	 */
	public Decidedzone getDecidedzone() {
		return decidedzone;
	}

	/**
	 * @param decidedzone the decidedzone to set
	 */
	public void setDecidedzone(Decidedzone decidedzone) {
		this.decidedzone = decidedzone;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @return the addresskey
	 */
	public String getAddresskey() {
		return addresskey;
	}

	/**
	 * @param addresskey the addresskey to set
	 */
	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}

	/**
	 * @return the startnum
	 */
	public String getStartnum() {
		return startnum;
	}

	/**
	 * @param startnum the startnum to set
	 */
	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}

	/**
	 * @return the endnum
	 */
	public String getEndnum() {
		return endnum;
	}

	/**
	 * @param endnum the endnum to set
	 */
	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}

	/**
	 * @return the single
	 */
	public String getSingle() {
		return single;
	}

	/**
	 * @param single the single to set
	 */
	public void setSingle(String single) {
		this.single = single;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
}
