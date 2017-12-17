package com.tqy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.User;
import com.tqy.dao.TqyUserDao;

/**
 * 每个Service类的开头要加@Service注解
 * @author TQY 2017-12-17 23:03:42
 * 
 */
@Service
public class TqyUserService {
	
	//这里要加autowired注解
	@Autowired
	TqyUserDao tqyUserDao;
	
	public User userLogin(User user){
		return tqyUserDao.userLogin(user);
	}
}
