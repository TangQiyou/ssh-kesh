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
		List<Picture> pictures = new ArrayList<>();
		
		for (Object o: zyPictureDao.getPictureByDate(year, month, day)) {
			pictures.add((Picture) o);
		}
		
		return pictures;
	}
	
	public List<Picture> getPictureByType(int type){
		List<Picture> pictures = new ArrayList<>();
		
		for (Object o: zyPictureDao.getPictureByType(type)) {
			pictures.add((Picture) o);
		}
		
		return pictures;
	}
	
	public Picture getPictureByDateAndType(int year, int month, int day, int type){
		return zyPictureDao.getPictureByDateAndType(year, month, day, type);
	}
}
