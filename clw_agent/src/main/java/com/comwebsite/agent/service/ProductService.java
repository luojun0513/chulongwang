package com.comwebsite.agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clw.core.api.ProdInfoFacade;
import com.clw.core.code.ProductInfoStateCode;
import com.clw.core.common.Pagination;
import com.clw.core.common.Result;
import com.clw.core.dto.QryProdInfoRequest;
import com.clw.core.model.ProductInfo;

@Service
public class ProductService {
	
	@Autowired
	private ProdInfoFacade productFacade;
	
	public List<ProductInfo> findHotProduct() throws Exception{
		QryProdInfoRequest request = new QryProdInfoRequest();
		request.setState(ProductInfoStateCode.已发布.getCode());
		request.setProdhot(1);
		request.setPageNum(1);
		request.setPageSize(3);
		Result<Pagination<ProductInfo>> serviceResult = productFacade.selectProdInfoListPag(request);
		Pagination<ProductInfo> productInfosPag = serviceResult.getData();
		List<ProductInfo>  result = productInfosPag.getDatas();
		return result;
	}
}
