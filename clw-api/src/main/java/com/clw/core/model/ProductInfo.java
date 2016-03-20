package com.clw.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 201506110117
 * 产品信息
 */
public class ProductInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7660739693804380743L;
	/**
	 * 主键   自增长
	 */
	private int id;
	/**
	 * 产品编号
	 */
	private String prodNo;
	/**
	 * 产品名称
	 */
	private String prodName;
	/**
	 * 产品规格
	 */
	private String prudSize;
	/**
	 * 防止害虫种类  多种种类 使用","隔开
	 */
	private String prevPest;
	/**
	 * 产品描述
	 */
	private String proddesc;
	/**
	 * 使用方法
	 */
	private String instruction;
	/**
	 * 产品图片   如果有多张图片   地址使用","隔开
	 */
	private String imagesPath;
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
	
	private Date createdTime;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 备注
	 */
	private String remark;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getPrudSize() {
		return prudSize;
	}
	public void setPrudSize(String prudSize) {
		this.prudSize = prudSize;
	}
	public String getPrevPest() {
		return prevPest;
	}
	public void setPrevPest(String prevPest) {
		this.prevPest = prevPest;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getImagesPath() {
		return imagesPath;
	}
	public void setImagesPath(String imagesPath) {
		this.imagesPath = imagesPath;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
