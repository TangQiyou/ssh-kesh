package com.tqy.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Code;
import com.tqy.bean.Picture;
import com.tqy.bean.page.PageInfo;
import com.tqy.dao.CodeDao;
import com.tqy.dao.TqyPictureDao;

@Service
public class TqyPictureService {

	@Autowired
	TqyPictureDao tqyPictureDao;
	
	@Autowired
	CodeDao codeDao;
	
	public PageInfo getPictureByTypeWithPage(Integer pn, Integer picType){
		List<Object> list = tqyPictureDao.getPictureByTypeWithPage(picType);
		PageInfo pageInfo = new PageInfo(list, pn, 5, 5);
		return pageInfo;
	}
	
	public PageInfo getPictureByDateAndType(Picture picture){
		List<Object> list = tqyPictureDao.getPictureByDateAndType(picture);
		PageInfo pageInfo = new PageInfo(list,1,5,5);
		return pageInfo;
	}
	
	public PageInfo getPictureByDate(Picture picture){
		List<Object> codes = codeDao.getCodeByCodeType("pic_type");
		List<Object> pictures = new ArrayList<Object>();
		for (int i =0; i < codes.size(); i++){
			picture.setPicType(((Code)codes.get(i)).getCodeValue());
			pictures.add(tqyPictureDao.getPictureByDateAndType(picture).get(0));
		}
		PageInfo pageInfo = new PageInfo(pictures, 1, 20, 5);
		return pageInfo;
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
