package com.zy.dao;

import java.util.List;

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
	
	public Object getPictureByDateAndType(int year, int month, int day, int type){
		String hql = "SELECT picName, picType, year, month, "
				+ "day, creatTime, url, des, typeName (codeName)"
				+ " FROM Picture, Code WHERE year="+year+" and month="+month+
				" and day="+day+" and picType="+type+" and codeValue="+type;
		@SuppressWarnings("unchecked")
		List<Object> pictures = getSession().createSQLQuery(hql).list();
		
		if (pictures.size() == 0) {
			System.out.println("year="+year+" and month="+month+" and day="+day
					+" and picType="+type+"无数据");
			return null;
		} else return pictures.get(0);
	}
}
