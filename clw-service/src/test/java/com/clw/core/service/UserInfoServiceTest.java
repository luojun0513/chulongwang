package com.clw.core.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.clw.core.dto.UserInfoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-*.xml")
public class UserInfoServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	public void testFindAllUser(){
		List<UserInfoDTO> userInfos;
		try {
			userInfos = userInfoService.findAllUser();
			System.out.println(userInfos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
