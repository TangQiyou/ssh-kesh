package com.dn.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.Announcement;
import com.tqy.bean.Response;
import com.tqy.dao.BaseDao;
@Component
public class DnResponseDao extends BaseDao{
	public List<Object> getResponses(){
		String hql = "From Response";
		@SuppressWarnings("unchecked")
		List<Object> list= getSession().createQuery(hql).list();
		return list;
	}
	public Integer deleteResponse(Response response){
		System.out.println(response);
		getSession().delete(response);
		return 1;
	}
	public Integer addResponse(Response response){
		System.out.println(response);
		getSession().saveOrUpdate(response);
		return 1;
	}
}
