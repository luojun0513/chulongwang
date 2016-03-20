package com.clw.core.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.clw.core.api.NewsInfoFacade;
import com.clw.core.common.Pagination;
import com.clw.core.common.Result;
import com.clw.core.dto.QryNewsInfoRequest;
import com.clw.core.model.NewsInfo;
import com.clw.core.service.NewsInfoService;

@Service
public class NewsInfoFacadeImpl implements NewsInfoFacade{
	private static final Logger logger = LoggerFactory.getLogger(NewsInfoFacadeImpl.class);
	@Autowired
	private NewsInfoService newsInfoService;
	
	@Override
	public Result<Pagination<NewsInfo>> selectNewsInfoListPag(QryNewsInfoRequest qryNewsInfoRequest) throws Exception {
		logger.info("【新闻信息查询】【selectNewsInfoListPag】【FACADE】参数:" + JSONObject.toJSONString(qryNewsInfoRequest));
		Result<Pagination<NewsInfo>> result = newsInfoService.selectNewsInfoListPag(qryNewsInfoRequest);
		logger.info("【新闻信息查询】【selectNewsInfoListPag】【FACADE】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<NewsInfo> selectNewsInfoById(int id) throws Exception {
		logger.info("【新闻信息查询】【selectNewsInfoById】【FACADE】【selectNewsInfoById】参数:" + JSONObject.toJSONString(id));
		Result<NewsInfo> result = newsInfoService.selectNewsInfoById(id);
		logger.info("【新闻信息查询】【selectNewsInfoById】【FACADE】【selectNewsInfoById】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> insertNewsInfo(NewsInfo newsInfo) throws Exception {
		logger.info("【创建新闻信息】【insertNewsInfo】【FACADE】参数:" + JSONObject.toJSONString(newsInfo));
		Result<Integer> result = newsInfoService.insertNewsInfo(newsInfo);
		logger.info("【创建新闻信息】【insertNewsInfo】【FACADE】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> publishNewsInfo(NewsInfo newsInfo) throws Exception {
		logger.info("【发布新闻信息】【publishNewsInfo】【FACADE】参数:" + JSONObject.toJSONString(newsInfo));
		Result<Integer> result = newsInfoService.publishNewsInfo(newsInfo);
		logger.info("【发布新闻信息】【publishNewsInfo】【FACADE】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> closeNewsInfo(NewsInfo newsInfo) throws Exception {
		logger.info("【关闭新闻信息】【closeNewsInfo】【FACADE】参数:" + JSONObject.toJSONString(newsInfo));
		Result<Integer> result = newsInfoService.closeNewsInfo(newsInfo);
		logger.info("【关闭新闻信息】【closeNewsInfo】【FACADE】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> updateNewsInfo(NewsInfo newsInfo) throws Exception {
		logger.info("【更新新闻信息】【updateNewsInfo】【FACADE】参数:" + JSONObject.toJSONString(newsInfo));
		Result<Integer> result = newsInfoService.updateNewsInfo(newsInfo);
		logger.info("【更新新闻信息】【updateNewsInfo】【FACADE】结果:" + JSONObject.toJSONString(result));
		return result;
	}

}
