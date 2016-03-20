package com.clw.core.dto;

import java.util.Date;

import com.clw.core.common.BaseParamDTO;

public class QryProdInfoRequest extends BaseParamDTO{
	/**
	 * 主键   自增长
	 */
	private int id;
	/**
	 * 状态  01:未发布    02：已发布    03：已下架
	 */
	private String state;
	/**
	 * 用户热度   即  用户点击量
	 */
	private int userhot;
	/**
	 * 产品热度   即  产品重视度
	 */
	private int prodhot; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getUserhot() {
		return userhot;
	}
	public void setUserhot(int userhot) {
		this.userhot = userhot;
	}
	public int getProdhot() {
		return prodhot;
	}
	public void setProdhot(int prodhot) {
		this.prodhot = prodhot;
	}
	
}
