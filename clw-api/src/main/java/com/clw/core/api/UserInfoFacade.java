package com.clw.core.api;

import java.util.List;

import com.clw.core.dto.UserInfoDTO;

/**
 * @author 201506110117
 * 用户接口
 */
public interface UserInfoFacade {
	public List<UserInfoDTO> findAllUser();
}
