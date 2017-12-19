package com.zy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.ZyAnnouncementDao;

@Service
public class ZyAnnouncementService {
	
	@Autowired
	ZyAnnouncementDao zyAnnouncementDao;
	
	
}
