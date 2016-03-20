package com.clw.core.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.clw.core.api.ProdInfoFacade;
import com.clw.core.common.Pagination;
import com.clw.core.common.Result;
import com.clw.core.dto.QryProdInfoRequest;
import com.clw.core.model.ProductInfo;
import com.clw.core.service.ProdInfoService;

@Service
public class ProdInfoFacadeImpl implements ProdInfoFacade{
	private static final Logger logger = LoggerFactory.getLogger(ProdInfoFacadeImpl.class);
	
	@Autowired
	private ProdInfoService prodInfoService;
	
	@Override
	public Result<Pagination<ProductInfo>> selectProdInfoListPag(QryProdInfoRequest qryProdInfoRequest) throws Exception {
		logger.info("【商品信息查询】【FACADE】【selectProdInfoListPag】参数:" + JSONObject.toJSONString(qryProdInfoRequest));
		Result<Pagination<ProductInfo>> result = prodInfoService.selectProdInfoListPag(qryProdInfoRequest);
		logger.info("【商品信息查询】【FACADE】【selectProdInfoListPag】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<ProductInfo> selectProdInfoById(int id) throws Exception {
		logger.info("【商品信息查询】【FACADE】【selectProdInfoById】参数:" + id);
		Result<ProductInfo> result = prodInfoService.selectProdInfoById(id);
		logger.info("【商品信息查询】【FACADE】【selectProdInfoById】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> insertProdInfo(ProductInfo prodInfo)throws Exception {
		logger.info("【创建商品信息】【FACADE】【insertProdInfo】参数:" + JSONObject.toJSONString(prodInfo));
		Result<Integer> result = prodInfoService.insertProdInfo(prodInfo);
		logger.info("【创建商品信息查询】【FACADE】【insertProdInfo】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> publishProdInfo(ProductInfo prodInfo)throws Exception {
		logger.info("【发布商品信息】【FACADE】【publishProdInfo】参数:" + JSONObject.toJSONString(prodInfo));
		Result<Integer> result = prodInfoService.publishProdInfo(prodInfo);
		logger.info("【发布商品信息查询】【FACADE】【publishProdInfo】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> closeProdInfo(ProductInfo prodInfo) throws Exception {
		logger.info("【发布商品信息】【FACADE】【publishProdInfo】参数:" + JSONObject.toJSONString(prodInfo));
		Result<Integer> result = prodInfoService.publishProdInfo(prodInfo);
		logger.info("【发布商品信息查询】【FACADE】【publishProdInfo】结果:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> updateProdInfo(ProductInfo prodInfo)throws Exception {
		logger.info("【更新商品信息】【FACADE】【updateProdInfo】参数:" + JSONObject.toJSONString(prodInfo));
		Result<Integer> result = prodInfoService.updateProdInfo(prodInfo);
		logger.info("【更新商品信息】【FACADE】【updateProdInfo】结果:" + JSONObject.toJSONString(result));
		return result;
	}

}
