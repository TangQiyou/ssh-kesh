package com.tqy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.Picture;

@Component
public class TqyPictureDao extends BaseDao{
	
	public List<Object> getPictureByTypeWithPage(Integer picType){
		String hql = "From Picture Where picType =" +picType;
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		return list;
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
