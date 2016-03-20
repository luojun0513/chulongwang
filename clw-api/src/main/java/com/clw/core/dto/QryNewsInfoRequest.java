package com.clw.core.dto;

import java.util.Date;

import com.clw.core.common.BaseParamDTO;

public class QryNewsInfoRequest extends BaseParamDTO{
	/**
	 * 主键 自增长
	 */
	private int id;
	/**
	 * 新闻标题
	 */
	private String title;
	/**
	 * 新闻作者
	 */
	private String author;
	/**
	 * 新闻内容
	 */
	private String content;
	/**
	 * 新闻图片地址   如果有多张图片  地址间使用","隔开
	 */
	private String imagesPath;
	/**
	 * 状态  01:未发布   02：已发布   03：已关闭
	 */
	private String state;
	/**
	 * 新闻创建时间
	 */
	private Date createdTime;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 关闭时间
	 */
	private Date closedTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Date getClosedTime() {
		return closedTime;
	}
	public void setClosedTime(Date closedTime) {
		this.closedTime = closedTime;
	}
	
}
