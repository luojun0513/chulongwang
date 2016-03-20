package com.clw.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.clw.core.api.UserInfoFacade;
import com.clw.core.dao.mybatis.UserInfoDao;
import com.clw.core.dto.UserInfoDTO;
import com.clw.core.service.UserInfoService;

@Service
public class UserInfoFacadeImpl implements UserInfoFacade{

	@Autowired
	private UserInfoService useInfoService;
	
	@Override
	public List<UserInfoDTO> findAllUser() {
		List<UserInfoDTO> result = null; 
		try {
			result = useInfoService.findAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
