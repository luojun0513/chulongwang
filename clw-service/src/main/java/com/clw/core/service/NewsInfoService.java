package com.clw.core.service;

import com.clw.core.common.Pagination;
import com.clw.core.common.Result;
import com.clw.core.dto.QryNewsInfoRequest;
import com.clw.core.model.NewsInfo;


public interface NewsInfoService {
	/**
	 * 分页查询新闻信息
	 * @param qryNewsInfoRequest
	 * @return
	 */
	public Result<Pagination<NewsInfo>> selectNewsInfoListPag(QryNewsInfoRequest qryNewsInfoRequest) throws Exception;
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Result<NewsInfo> selectNewsInfoById(int id) throws Exception;
	
	/**
	 * 创建新闻 初始状态为 未发布状态
	 * @param newsInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> insertNewsInfo(NewsInfo newsInfo) throws Exception;
	
	/**
	 * 发布新闻  将未发布状态的新闻 改为 已发布状态  
	 * @param newsInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> publishNewsInfo(NewsInfo newsInfo) throws Exception;
	
	/**
	 * 关闭新闻 将已发布的新闻关闭
	 * @param newsInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> closeNewsInfo(NewsInfo newsInfo) throws Exception;
	/**
	 * 更新新闻
	 * @param newsInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> updateNewsInfo(NewsInfo newsInfo) throws Exception;
}
