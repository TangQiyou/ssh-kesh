package com.tqy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Picture;
import com.tqy.dao.TqyPictureDao;

@Service
public class TqyPictureService {

	@Autowired
	TqyPictureDao tqyPictureDao;
	
	public List<Picture> getPictureByTypeWithPage(){
		return null;
	}
	
	public List<Picture> getPictureByDate(){
		return null;
	}
	
	public Picture addOnlyPicture(){
		return null;
	}
	
	public Picture addPicture(){
		return null;
	}
	
	public void updatePicture(){
		
	}
	
	public void deletePicture(){
		
	}
}
