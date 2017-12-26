package com.zy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.dao.BaseDao;

@Component
public class ZyPictureDao extends BaseDao{
	public List<Object> getPictureByDate(int year, int month, int day){
		String hql = "FROM Picture WHERE year="+year+" and month="+month+" and day="+day;
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		
		return list;
	}
}
