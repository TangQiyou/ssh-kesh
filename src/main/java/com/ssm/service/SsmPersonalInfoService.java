package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.SsmPersonalInfoDao;
import com.tqy.bean.User;
import com.tqy.dao.CodeDao;

@Service
public class SsmPersonalInfoService {
	
	@Autowired
	SsmPersonalInfoDao ssmPersonalInfoDao;
	   
	
	public User getUserById(Integer id){
		User user = ssmPersonalInfoDao.getUserById(id);
		
		return user;
	}
	
	public void updateUser(User user){
		ssmPersonalInfoDao.updateUser(user);
	}
}
