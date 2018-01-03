package com.tqy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.Picture;

@Component
public class TqyPictureDao extends BaseDao{
	
	public List<Object> getPictureByTypeWithPage(Integer picType){
		String hql = "From Picture Where picType =" +picType+"order by picId DESC";
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
	
	public Integer addOnlyPicture(Picture picture){
		getSession().save(picture);
		System.out.println("新生成主键为： "+picture.getPicId());
		return picture.getPicId();
	}
	
	public void addPicture(Picture addPicture){
		getSession().saveOrUpdate(addPicture);
	}
	
	public Picture getPictureById(Integer id){
		String hql = "From Picture Where picId="+id;
		List<Object> list = getSession().createQuery(hql).list();
		if(!list.isEmpty()){
			return (Picture)list.get(0);
		} else {
			return null;
		}
		
	}
	
	public void updatePicture(){
		
	}
	
	public void deletePicture(Picture picture){
		getSession().delete(picture);
	}
}
