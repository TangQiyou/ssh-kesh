package com.zy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.dao.BaseDao;

@Component
public class ZyAnnouncementDao extends BaseDao{
	public List<Object> getAnnouncements(){
		String hql = "From Announcement order by id desc";
		@SuppressWarnings("unchecked")
		List<Object> list =  getSession().createQuery(hql).list();
		return list;
	}
}
