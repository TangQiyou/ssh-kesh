package com.tqy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.dao.CodeDao;

@Service
public class TqyCodeService {
	
	@Autowired
	CodeDao codeDao;
	
	public List<Object> getCodesByCodeType(String codeType){
		List<Object> list = codeDao.getCodeByCodeType(codeType);
		return list;
	}
}
