package com.tqy.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Code;
import com.tqy.bean.Picture;
import com.tqy.bean.page.PageInfo;
import com.tqy.dao.CodeDao;
import com.tqy.dao.TqyPictureDao;
import com.tqy.utils.PictureUtil;

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
	
	public Integer addOnlyPicture(Picture picture, String fileName){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		picture.setPicName(fileName);
		picture.setCreatTime(format.format(new Date()));
		picture.setUrl("../img/"+picture.getPicType()+"/"+fileName);
		picture.setDes(picture.getCreatTime()+"上传");
		Integer picId = tqyPictureDao.addOnlyPicture(picture);
		return picId;
	}
	
	public Picture getPictureById(Integer id){
		return tqyPictureDao.getPictureById(id);
	}
	
	public void addPicture(Picture picture){
		Picture addPicture = tqyPictureDao.getPictureById(picture.getPicId());
		System.out.println(addPicture);
		addPicture.setYear(picture.getYear());
		addPicture.setMonth(picture.getMonth());
		addPicture.setDay(picture.getDay());
		System.out.println(addPicture);
		tqyPictureDao.addPicture(addPicture);
	}
	
	public void updatePicture(){
		
	}
	
	public void deletePicture(Picture picture){
		tqyPictureDao.deletePicture(picture);
		boolean result = PictureUtil.deletePictureOnTheDisk(picture.getPicType(), picture.getPicName());
		System.out.println(result?"删除成功！":"删除失败！");
	}
}
