package com.clw.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.clw.core.code.NewsInfoStateCode;
import com.clw.core.code.ProductInfoStateCode;
import com.clw.core.common.CommonCode;
import com.clw.core.common.Pagination;
import com.clw.core.common.Result;
import com.clw.core.dao.mybatis.NewsInfoDAO;
import com.clw.core.dto.QryNewsInfoRequest;
import com.clw.core.model.NewsInfo;
import com.clw.core.service.NewsInfoService;

@Service
public class NewsInfoServiceImpl implements NewsInfoService{
	public static final Logger logger = LoggerFactory.getLogger(NewsInfoServiceImpl.class);
	@Autowired
	private NewsInfoDAO newsInfoDAO;
	
	@Override
	public Result<Pagination<NewsInfo>> selectNewsInfoListPag(QryNewsInfoRequest qryNewsInfoRequest) throws Exception {
		logger.info("【分页查询新闻信息】【SERVICE】【selectNewsInfoListPag】 参数：" + JSONObject.toJSONString(qryNewsInfoRequest));
		Pagination<NewsInfo> newsInfoListPag = newsInfoDAO.selectNewsInfoListPag(qryNewsInfoRequest);
		Result<Pagination<NewsInfo>> result = new Result<Pagination<NewsInfo>>(CommonCode.SUCCESS_CODE, newsInfoListPag);
		logger.info("【分页查询新闻信息】【SERVICE】【selectNewsInfoListPag】 参数：" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<NewsInfo> selectNewsInfoById(int id) throws Exception {
		logger.info("【查询新闻信息】【SERVICE】【selectNewsInfoById】 参数 ID：" + id);
		NewsInfo newsInfo = newsInfoDAO.selectNewsInfoById(id);
		Result<NewsInfo> result = new Result<NewsInfo>(CommonCode.SUCCESS_CODE, newsInfo);
		logger.info("【查询新闻信息】【SERVICE】【selectNewsInfoById】 参数：" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> insertNewsInfo(NewsInfo newsInfo) throws Exception {
		logger.info("【创建新闻信息】【SERVICE】【selectNewsInfoById】 参数 ：" + JSONObject.toJSONString(newsInfo));
		int id = newsInfoDAO.insertNewsInfo(newsInfo);
		Result<Integer> result = new Result<Integer>(CommonCode.SUCCESS_CODE,id);
		logger.info("【创建新闻信息】【SERVICE】【selectNewsInfoById】 结果 result ：" + result);
		return result;
	}
	
	public Result<Integer> updateNewsInfo(NewsInfo newsInfo) throws Exception{
		logger.info("【更新新闻信息】【SERVICE】【updateNewsInfo】 参数 ：" + JSONObject.toJSONString(newsInfo));
		int id = newsInfoDAO.updateNewsInfo(newsInfo);
		Result<Integer> result = new Result<Integer>(CommonCode.SUCCESS_CODE,id);
		logger.info("【更新新闻信息】【SERVICE】【updateNewsInfo】 结果 result ：" + result);
		return result;
	}

	@Override
	public Result<Integer> publishNewsInfo(NewsInfo newsInfo) throws Exception {
		logger.info("【发布新闻信息】【SERVICE】【publishNewsInfo】 参数 ：" + JSONObject.toJSONString(newsInfo));
		newsInfo.setState(NewsInfoStateCode.已发布.getCode());
		Result<Integer> result = updateNewsInfo(newsInfo);
		logger.info("【创建新闻信息】【SERVICE】【selectNewsInfoById】 结果 result ：" + result);
		return result;
	}

	@Override
	public Result<Integer> closeNewsInfo(NewsInfo newsInfo) throws Exception {
		logger.info("【关闭新闻信息】【SERVICE】【closeNewsInfo】 参数 ：" + JSONObject.toJSONString(newsInfo));
		newsInfo.setState(NewsInfoStateCode.已关闭.getCode());
		Result<Integer> result = updateNewsInfo(newsInfo);
		logger.info("【关闭新闻信息】【SERVICE】【closeNewsInfo】 结果 result ：" + result);
		return null;
	}
	
}
