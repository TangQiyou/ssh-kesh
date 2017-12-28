package com.tqy.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Announcement;
import com.tqy.bean.page.PageInfo;
import com.tqy.dao.TqyAnnuncmentDao;

@Service
public class TqyAnnouncementService {
	
	@Autowired
	TqyAnnuncmentDao tqyAnnuncmentDao;
	
	public PageInfo getAnnouncementBypage(Integer pn){
		List<Object> list = tqyAnnuncmentDao.getAnnouncements();
		PageInfo pageInfo = new PageInfo(list, pn, 5, 5);
		return pageInfo;
	}
	
	public Boolean addAnnouncement(Announcement announcement){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		announcement.setAnnTime(time);
		Integer i = tqyAnnuncmentDao.addAnnouncement(announcement);
		return i == 1 ? true: false;
	}
	
	public Boolean updateAnnouncement(Announcement announcement){
		Integer integer = tqyAnnuncmentDao.updateAnnouncement(announcement);
		return integer == 1 ? true: false;
	}
	
	public Boolean deleteAnnouncement(Announcement announcement){
		Integer integer = tqyAnnuncmentDao.deleteAnnouncement(announcement);
		return integer == 1 ? true: false;
	}
}
