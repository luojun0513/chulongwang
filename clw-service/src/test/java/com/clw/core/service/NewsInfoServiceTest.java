package com.clw.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.clw.core.common.Pagination;
import com.clw.core.common.Result;
import com.clw.core.dto.QryNewsInfoRequest;
import com.clw.core.model.NewsInfo;

public class NewsInfoServiceTest extends BaseTest{
	
	@Autowired
	private NewsInfoService newsInfoService;
	
	@Test
	public void testSelectNewsInfoListPag(){
		QryNewsInfoRequest request = new QryNewsInfoRequest();
		request.setState("01");
		request.setPageNum(1);
		try {
			Result<Pagination<NewsInfo>> result = newsInfoService.selectNewsInfoListPag(request);
			System.out.println(JSONObject.toJSONString(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
