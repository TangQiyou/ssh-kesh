package com.zy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.dao.BaseDao;

@Component
public class ZyDataTypeDao extends BaseDao{
	public List<Object> getDataByType(String type){
		String hql = "FROM Code WHERE codeType='" + type +"'";
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		
		return list;
		
	}
}
