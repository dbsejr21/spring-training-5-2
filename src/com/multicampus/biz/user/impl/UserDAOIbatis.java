package com.multicampus.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.user.UserVO;

// DAO(Data Access Object)
@Repository
public class UserDAOIbatis {
	
	@Autowired
	SqlMapClientTemplate ibatis;
	
	public UserVO getUser(UserVO vo) {
		
//		Object[] args = {vo.getId(), vo.getPassword()};
//		return spring.queryForObject(USER_GET, args, new UserRowMapper());
		
		UserVO user = (UserVO) ibatis.queryForObject("getUser", vo);
		
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		
		return user;
		
	}
	
}



