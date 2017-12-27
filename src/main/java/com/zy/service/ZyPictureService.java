package com.zy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Picture;
import com.zy.dao.ZyPictureDao;

@Service
public class ZyPictureService {
	
	@Autowired
	private ZyPictureDao zyPictureDao;
	
	public List<Picture> getPictureByDate(int year, int month, int day){
		return zyPictureDao.getPictureByDate(year, month, day);
	}
	
	public List<Picture> getPictureByType(int type){
		return zyPictureDao.getPictureByType(type);
	}
	
	public Picture getPictureByDateAndType(int year, int month, int day, int type){
		return zyPictureDao.getPictureByDateAndType(year, month, day, type);
	}
}
