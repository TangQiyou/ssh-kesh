package com.tqy.service;

import java.util.FormatFlagsConversionMismatchException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Admin;
import com.tqy.dao.TqyAdminDao;

@Service
public class TqyAdminService {
	
	@Autowired
	TqyAdminDao tqyAdminDao;
	
	public boolean adminLogin(Admin admin){
		int flag = tqyAdminDao.adminLogin(admin);
		return flag == 1? true : false;
	}
	
}
