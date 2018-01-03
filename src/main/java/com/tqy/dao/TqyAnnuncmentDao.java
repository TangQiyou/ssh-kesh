package com.tqy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.Announcement;

@Component
public class TqyAnnuncmentDao extends BaseDao{
	
	public List<Object> getAnnouncements(){
		String hql = "From Announcement";
		@SuppressWarnings("unchecked")
		List<Object> list =  getSession().createQuery(hql).list();
		return list;
	}
	
	public void addAnnouncement(Announcement announcement){
		System.out.println(announcement);
		getSession().saveOrUpdate(announcement);
	}
	
	public void updateAnnouncement(Announcement announcement){
		System.out.println(announcement);
		getSession().saveOrUpdate(announcement);
	}
	
	public Integer deleteAnnouncement(Announcement announcement){
		System.out.println(announcement);
		getSession().delete(announcement);
		return 1;
	}
}
