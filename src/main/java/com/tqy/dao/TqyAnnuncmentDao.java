package com.tqy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TqyAnnuncmentDao extends BaseDao{
	
	public List<Object> getAnnouncements(){
		String hql = "From Announcement";
		@SuppressWarnings("unchecked")
		List<Object> list =  getSession().createQuery(hql).list();
		return list;
	}
}
