package com.comwebsite.agent.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clw.core.model.ProductInfo;
import com.comwebsite.agent.service.ProductService;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request,Model model) throws IOException{
		logger.info("url:" + request.getRequestURL());
		List<ProductInfo> productInfos = null;
		try {
			productInfos = productService.findHotProduct();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取热门产品异常",e);
		}
		model.addAttribute("productInfos", productInfos);
		return "/index.html";
	}
}
