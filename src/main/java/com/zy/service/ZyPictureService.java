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
}
