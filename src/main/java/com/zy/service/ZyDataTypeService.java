package com.zy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Code;
import com.zy.dao.ZyDataTypeDao;

@Service
public class ZyDataTypeService {
	@Autowired
	ZyDataTypeDao zyDataTypeDao;
	
	public List<Object> getDataByType(String codeType){
		return zyDataTypeDao.getDataByType(codeType);
	}
}
