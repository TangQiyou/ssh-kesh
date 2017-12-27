package com.zy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.Announcement;
import com.tqy.dao.BaseDao;
@SuppressWarnings("unchecked")
@Component
public class ZyAnnouncementDao extends BaseDao{
	public List<Object> getAnnouncements(){
		String hql = "From Announcement order by id desc";
		List<Object> list =  getSession().createQuery(hql).list();
		return list;
	}
	
	public Announcement getAnnouncement(int id) {
		String hql = "SELECT * FROM Announcement WHERE annId="+id;
		List<Announcement> list = getSession().createSQLQuery(hql)
				.addEntity(Announcement.class).list();
		if (list.size() == 0) {
			System.out.println("annId="+id+" 无数据");
			return null;
		}else {
			return list.get(0);
		}
	}
	
}
