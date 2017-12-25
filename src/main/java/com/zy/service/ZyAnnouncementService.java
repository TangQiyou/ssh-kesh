package com.zy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.page.PageInfo;
import com.zy.dao.ZyAnnouncementDao;

@Service
public class ZyAnnouncementService {
	
	@Autowired
	ZyAnnouncementDao zyAnnouncementDao;
	
	public PageInfo getAnnouncements() {
		List<Object> list = zyAnnouncementDao.getAnnouncements();
		PageInfo pageInfo = new PageInfo(list, 1, 5, 5); //查询第0页的试试
		return pageInfo;
	}
}
