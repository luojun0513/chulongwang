package com.clw.core.service;

import java.util.List;

import com.clw.core.dto.UserInfoDTO;

public interface UserInfoService {
	public List<UserInfoDTO> findAllUser() throws Exception ;
}
