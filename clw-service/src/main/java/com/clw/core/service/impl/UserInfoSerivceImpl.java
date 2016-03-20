package com.clw.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clw.core.dao.mybatis.UserInfoDao;
import com.clw.core.dto.UserInfoDTO;
import com.clw.core.model.UserInfo;
import com.clw.core.service.UserInfoService;

@Service
public class UserInfoSerivceImpl implements UserInfoService{
	@Autowired
	private UserInfoDao UserInfoDao;
	
	@Override
	public List<UserInfoDTO> findAllUser() throws Exception {
		List<UserInfo> userInfos = UserInfoDao.findAllUser();
		List<UserInfoDTO> userInfoDTOs = new ArrayList<UserInfoDTO>();
		UserInfoDTO userInfoDTO = null;
		for(UserInfo userInfo : userInfos){
			userInfoDTO = new UserInfoDTO();
			BeanUtils.copyProperties(userInfoDTO, userInfo);
			userInfoDTOs.add(userInfoDTO);
		}
		return userInfoDTOs;
	}
	
}
