package com.clw.core.api;

import com.clw.core.common.Pagination;
import com.clw.core.common.Result;
import com.clw.core.dto.QryProdInfoRequest;
import com.clw.core.model.ProductInfo;

public interface ProdInfoFacade {
	
	/**
	 * 分页查询商品信息
	 * @param qryProdInfoRequest
	 * @return
	 * @throws Exception
	 */
	public Result<Pagination<ProductInfo>> selectProdInfoListPag(QryProdInfoRequest qryProdInfoRequest) throws Exception ;

	/**
	 * 根据Id查询产品信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Result<ProductInfo> selectProdInfoById(int id) throws Exception;
	
	/**
	 * 创建产品 初始状态为 未发布状态
	 * @param ProdInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> insertProdInfo(ProductInfo prodInfo) throws Exception;
	
	/**
	 * 发布产品  将未发布状态的产品 改为 已发布状态  
	 * @param ProdInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> publishProdInfo(ProductInfo prodInfo) throws Exception;
	
	/**
	 * 关闭产品 将已发布的产品关闭
	 * @param ProdInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> closeProdInfo(ProductInfo prodInfo) throws Exception;
	
	/**
	 * 更新产品
	 * @param ProdInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> updateProdInfo(ProductInfo prodInfo) throws Exception;
}
