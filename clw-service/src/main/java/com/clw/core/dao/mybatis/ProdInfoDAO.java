package com.clw.core.dao.mybatis;

import java.util.HashMap;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.clw.core.common.Pagination;
import com.clw.core.dto.QryProdInfoRequest;
import com.clw.core.model.ProductInfo;

@Component
public class ProdInfoDAO extends BaseDAO{
	
	/**
	 * 插入产品信息
	 * @param newsInfo
	 * @return
	 */
	public int insertProdInfo(ProductInfo productInfo) {
		logger.info("【插入产品信息】【DAO】【insertProdInfo】 参数：" + JSONObject.toJSONString(productInfo));
		int id = superDAO.insert("com.clw.core.model.ProductInfo.insertProdInfo", productInfo);
		logger.info("【插入产品信息】【DAO】【insertProdInfo】 结果 ID：" + id);
		return id;
	}
	
	/**
	 * 插入产品信息
	 * @param newsInfo
	 * @return
	 */
	public int updateProdInfo(ProductInfo productInfo) {
		logger.info("【插入产品信息】【DAO】【updateProdInfo】 参数：" + JSONObject.toJSONString(productInfo));
		int num = superDAO.update("com.clw.core.model.ProductInfo.updateProdInfo", productInfo);
		logger.info("【插入产品信息】【DAO】【updateProdInfo】 结果 num：" + num);
		return num;
	}
	
	/**
	 * 根据产品ID查询
	 * @param id
	 * @return
	 */
	public ProductInfo selectProdInfoById(int id) {
		logger.info("【查询新闻信息】【DAO】【selectProdInfoById】 参数 ID：" + id);
		ProductInfo prodInfo = superDAO.getObject("com.clw.core.model.ProductInfo.selectProdInfoById", id);
		logger.info("【查询新闻信息】【DAO】【selectProdInfoById】 结果：" + JSONObject.toJSONString(prodInfo));
		return prodInfo;
	}
	
	/**
	 * 分页查询商品信息
	 * @param qryProdInfoRequest
	 * @return
	 */
	public Pagination<ProductInfo> selectProdInfoListPag(QryProdInfoRequest qryProdInfoRequest){
		logger.info("【分页查询商品信息】【DAO】【selectProdInfoListPag】 参数：" + JSONObject.toJSONString(qryProdInfoRequest));
		HashMap<String,Object> query = new HashMap<String, Object>();
		query.put("state", qryProdInfoRequest.getState());
		query.put("userhot", qryProdInfoRequest.getUserhot());
		query.put("prodhot", qryProdInfoRequest.getProdhot());
		Pagination<ProductInfo> prodInfoPag = superDAO.queryPagination("com.clw.core.model.ProductInfo.selectProdList", query, qryProdInfoRequest);
		logger.info("【分页查询商品信息】【DAO】【selectProdInfoListPag】 结果：" + JSONObject.toJSONString(prodInfoPag));
		return prodInfoPag;
	}
	
}
