package com.tqy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CodeDao extends BaseDao{

	public List<Object> getCodeByCodeType(String codeType){
		String hql = "From Code Where codeType = '" + codeType +"'";
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		return list;
		
	}
}
