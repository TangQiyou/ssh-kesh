package com.zy.dao;

import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.tqy.bean.Picture;
import com.tqy.dao.BaseDao;

@Component
public class ZyPictureDao extends BaseDao{
	public List<Object> getPictureByDate(int year, int month, int day){
		String hql = "FROM Picture WHERE year="+year+" and month="+month+" and day="+day;
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		
		return list;
	}
	
	public List<Object> getPictureByType(int type){
		String hql = "FROM Picture WHERE picType="+type;
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		
		return list;
	}
	
	public Picture getPictureByDateAndType(int year, int month, int day, int type){
		String hql = "SELECT picId, picName, picType, year, month, "
				+ "day, creatTime, url, des, codeName AS typeName"
				+ " FROM Picture, Code WHERE year="+year+" and month="+month+
				" and day="+day+" and picType="+type+" and codeValue="+type;
		@SuppressWarnings("unchecked")
		List<Picture> pictures = getSession().createSQLQuery(hql).setResultTransformer(
				Transformers.aliasToBean(Picture.class)).list();
		
		if (pictures.size() == 0) {
			System.out.println("year="+year+" and month="+month+" and day="+day
					+" and picType="+type+"无数据");
			return null;
		} else return pictures.get(0);
	}
}
