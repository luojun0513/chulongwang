package com.clw.core.dao.mybatis;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.clw.core.common.Pagination;
import com.clw.core.dto.QryNewsInfoRequest;
import com.clw.core.model.NewsInfo;

@Component
public class NewsInfoDAO extends BaseDAO{
	
	/**
	 * 插入新闻信息
	 * @param newsInfo
	 * @return
	 */
	public int insertNewsInfo(NewsInfo newsInfo) {
		logger.info("【插入新闻信息】【DAO】【insertNewsInfo】 参数：" + JSONObject.toJSONString(newsInfo));
		int id = superDAO.insert("com.clw.core.model.NewsInfo.insertNewsInfo", newsInfo);
		logger.info("【插入新闻信息】【DAO】【insertNewsInfo】 结果 ID：" + id);
		return id;
	}
	
	/**
	 * 插入新闻信息
	 * @param newsInfo
	 * @return
	 */
	public int updateNewsInfo(NewsInfo newsInfo) {
		logger.info("【插入新闻信息】【DAO】【updateNewsInfo】 参数：" + JSONObject.toJSONString(newsInfo));
		int num = superDAO.update("com.clw.core.model.NewsInfo.updateNewsInfo", newsInfo);
		logger.info("【插入新闻信息】【DAO】【insertNewsInfo】 结果 num：" + num);
		return num;
	}
	
	/**
	 * 分页查询新闻信息
	 * @param qryNewsInfoRequest
	 * @return
	 */
	public Pagination<NewsInfo> selectNewsInfoListPag(QryNewsInfoRequest qryNewsInfoRequest){
		logger.info("【分页查询新闻信息】【DAO】【selectNewsInfoListPag】 参数：" + JSONObject.toJSONString(qryNewsInfoRequest));
		HashMap<String,Object> query = new HashMap<String, Object>();
		query.put("state", qryNewsInfoRequest.getState());
		Pagination<NewsInfo> newsInfoPag = superDAO.queryPagination("com.clw.core.model.NewsInfo.selectNewsList", query, qryNewsInfoRequest);
		logger.info("【分页查询新闻信息】【DAO】【selectNewsInfoListPag】 结果：" + JSONObject.toJSONString(newsInfoPag));
		return newsInfoPag;
	}

	/**
	 * 根据新闻ID查询
	 * @param id
	 * @return
	 */
	public NewsInfo selectNewsInfoById(int id) {
		logger.info("【查询新闻信息】【DAO】【selectNewsInfoById】 参数 ID：" + id);
		NewsInfo newsInfo = superDAO.getObject("com.clw.core.model.NewsInfo.selectNewsInfoById", id);
		logger.info("【查询新闻信息】【DAO】【selectNewsInfoListPag】 结果：" + JSONObject.toJSONString(newsInfo));
		return newsInfo;
	}
}
