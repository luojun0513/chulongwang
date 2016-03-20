package com.clw.core.dao.mybatis;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clw.core.model.UserInfo;
@Component
public class UserInfoDao {
	@Autowired
	private ISuperDAO superDAO;
	
	public List<UserInfo> findAllUser() {
		return superDAO.getList("com.clw.core.dao.mybatis.model.UserInfo.findAllUser", null);
	}
}
