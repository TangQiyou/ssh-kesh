package com.fys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tqy.bean.Announcement;

@Component
public class FysAnnouncementDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Object> getAnnouncements(){
		String hql = "From Announcement";
		@SuppressWarnings("unchecked")
		List<Object> list =  sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}
	
	public Integer addAnnouncement(Announcement announcement){
		System.out.println(announcement);
		sessionFactory.getCurrentSession().saveOrUpdate(announcement);
		return 1;
	}
	
	public Integer updateAnnouncement(Announcement announcement){
		System.out.println(announcement);
		sessionFactory.getCurrentSession().saveOrUpdate(announcement);
		return 1;
	}
	
	public Integer deleteAnnouncement(Announcement announcement){
		System.out.println(announcement);
		sessionFactory.getCurrentSession().delete(announcement);
		return 1;
	}
}
