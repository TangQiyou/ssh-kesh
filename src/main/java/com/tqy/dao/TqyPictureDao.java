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
	
	public List<Object> getPictureByDateAndType(Picture picture){
		String hql = "From Picture Where year = "+ picture.getYear() + " and month = "+ picture.getMonth()
		+" and day = "+ picture.getDay() +" and picType = " + picture.getPicType(); 
		System.out.println(hql);
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		if (list.isEmpty()){
			return null;
		} else {
			return list;
		}
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
