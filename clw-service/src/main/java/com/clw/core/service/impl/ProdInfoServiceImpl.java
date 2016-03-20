package com.clw.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.clw.core.code.ProductInfoStateCode;
import com.clw.core.common.CommonCode;
import com.clw.core.common.Pagination;
import com.clw.core.common.Result;
import com.clw.core.dao.mybatis.NewsInfoDAO;
import com.clw.core.dao.mybatis.ProdInfoDAO;
import com.clw.core.dto.QryNewsInfoRequest;
import com.clw.core.dto.QryProdInfoRequest;
import com.clw.core.model.NewsInfo;
import com.clw.core.model.ProductInfo;
import com.clw.core.service.ProdInfoService;

@Service
public class ProdInfoServiceImpl implements ProdInfoService{
	
	public static final Logger logger = LoggerFactory.getLogger(ProdInfoServiceImpl.class);
	@Autowired
	private ProdInfoDAO prodInfoDAO;
	
	@Override
	public Result<Pagination<ProductInfo>> selectProdInfoListPag(QryProdInfoRequest qryProdInfoRequest) throws Exception {
		logger.info("【分页查询商品信息】【SERVICE】【selectProdInfoListPag】 参数：" + JSONObject.toJSONString(qryProdInfoRequest));
		Pagination<ProductInfo> prodInfoListPag = prodInfoDAO.selectProdInfoListPag(qryProdInfoRequest);
		Result<Pagination<ProductInfo>> result = new Result<Pagination<ProductInfo>>(CommonCode.SUCCESS_CODE, prodInfoListPag);
		logger.info("【分页查询商品信息】【SERVICE】【selectProdInfoListPag】 参数：" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<ProductInfo> selectProdInfoById(int id) throws Exception {
		logger.info("【查询商品信息】【SERVICE】【selectProdInfoById】 参数：" + id);
		ProductInfo prodInfo = prodInfoDAO.selectProdInfoById(id);
		Result<ProductInfo> result = new Result<ProductInfo>(CommonCode.SUCCESS_CODE, prodInfo);
		logger.info("【查询商品信息】【SERVICE】【selectProdInfoById】 参数：" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> insertProdInfo(ProductInfo prodInfo)throws Exception {
		logger.info("【创建商品】【SERVICE】【insertProdInfo】 参数：" + JSONObject.toJSONString(prodInfo));
		int prodId = prodInfoDAO.insertProdInfo(prodInfo);
		Result<Integer> result = new Result<Integer>(CommonCode.SUCCESS_CODE, prodId);
		logger.info("【创建商品】【SERVICE】【insertProdInfo】 参数：" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> publishProdInfo(ProductInfo prodInfo)throws Exception {
		logger.info("【发布商品】【SERVICE】【publishProdInfo】 参数：" + JSONObject.toJSONString(prodInfo));
		prodInfo.setState(ProductInfoStateCode.已发布.getCode());
		int num = prodInfoDAO.updateProdInfo(prodInfo);
		Result<Integer> result = new Result<Integer>(CommonCode.SUCCESS_CODE, num);
		logger.info("【发布商品】【SERVICE】【publishProdInfo】 参数：" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> closeProdInfo(ProductInfo prodInfo) throws Exception {
		logger.info("【关闭商品】【SERVICE】【closeProdInfo】 参数：" + JSONObject.toJSONString(prodInfo));
		prodInfo.setState(ProductInfoStateCode.已下架.getCode());
		int num = prodInfoDAO.updateProdInfo(prodInfo);
		Result<Integer> result = new Result<Integer>(CommonCode.SUCCESS_CODE, num);
		logger.info("【关闭商品】【SERVICE】【closeProdInfo】 参数：" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Result<Integer> updateProdInfo(ProductInfo prodInfo)throws Exception {
		logger.info("【更新商品】【SERVICE】【updateProdInfo】 参数：" + JSONObject.toJSONString(prodInfo));
		int num = prodInfoDAO.updateProdInfo(prodInfo);
		Result<Integer> result = new Result<Integer>(CommonCode.SUCCESS_CODE, num);
		logger.info("【更新商品】【SERVICE】【updateProdInfo】 参数：" + JSONObject.toJSONString(result));
		return result;
	}
	
}
