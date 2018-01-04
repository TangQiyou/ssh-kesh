package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.SsmPasswordDao;
import com.tqy.bean.User;

@Service
public class SsmPasswordService {
	
	@Autowired
	SsmPasswordDao ssmPasswordDao;
	
	public String updatePassword(Integer id,String oldpwd,String newPwd){
		
		return ssmPasswordDao.updatePassword(id,oldpwd,newPwd);
	}
}
