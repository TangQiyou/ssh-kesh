package com.dn.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.tqy.dao.BaseDao;

@Component
public class DnLeaveWordDao extends BaseDao {
	//根据需求编写查询函数
	public List<Object> getLeaveWords(){
		String hql = "From LeaveWord";
		@SuppressWarnings("unchecked")
		List<Object> list= getSession().createQuery(hql).list();
		System.out.println(list);
		return list;
	}
}
