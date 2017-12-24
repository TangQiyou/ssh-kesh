package com.tqy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
