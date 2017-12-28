package com.dn.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.dao.BaseDao;
@Component
public class DnResponseDao extends BaseDao{
	public List<Object> getResponses(){
		String hql = "From Response";
		@SuppressWarnings("unchecked")
		List<Object> list= getSession().createQuery(hql).list();
		return list;
	}
}
