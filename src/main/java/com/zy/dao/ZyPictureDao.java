package com.zy.dao;

import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.tqy.bean.Picture;
import com.tqy.dao.BaseDao;

@SuppressWarnings("unchecked")
@Component
public class ZyPictureDao extends BaseDao{
	public List<Picture> getPictureByDate(int year, int month, int day){
		String hql = "SELECT picId, picName, picType, year, month, "
				+ "day, creatTime, url, des, codeName AS typeName"
				+ " FROM Picture p, Code c WHERE p.picType=c.codeValue and year="+year
				+" and month="+month+" and day="+day;
		List<Picture> list = getSession().createSQLQuery(hql).setResultTransformer(
				Transformers.aliasToBean(Picture.class)).list();
		
		return list;
	}
	
	public List<Picture> getPictureByType(int type){
		String hql = "SELECT picId, picName, picType, year, month, "
				+ "day, creatTime, url, des, codeName AS typeName"
				+" FROM Picture p, Code c WHERE p.picType=c.codeValue and p.picType="+type;
		List<Picture> list = getSession().createSQLQuery(hql).setResultTransformer(
				Transformers.aliasToBean(Picture.class)).list();
		
		return list;
	}
	
	public Picture getPictureByDateAndType(int year, int month, int day, int type){
		String hql = "SELECT picId, picName, picType, year, month, "
				+ "day, creatTime, url, des, codeName AS typeName"
				+ " FROM Picture, Code WHERE year="+year+" and month="+month+
				" and day="+day+" and picType="+type+" and codeValue="+type;
		List<Picture> pictures = getSession().createSQLQuery(hql).setResultTransformer(
				Transformers.aliasToBean(Picture.class)).list();
		
		if (pictures.size() == 0) {
			System.out.println("year="+year+" and month="+month+" and day="+day
					+" and picType="+type+"无数据");
			return null;
		} else return pictures.get(0);
	}
}
