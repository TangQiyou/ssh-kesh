package com.tqy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.User;

/**
 * 每个Dao类的开头要加@Comonent注解
 * 并且每个Dao要继承BaseDao,这样就不用每个Dao类都写getSession之类的函数
 * @author TQY 2017-12-17 23:04:12
 */
@Component
public class TqyUserDao extends BaseDao{
	
	//根据需求编写查询函数
	@SuppressWarnings("unchecked")
	public User userLogin(User user){
		String hql = "FROM User u WHERE u.userAccount='"+user.getUserAccount()+"' and u.userPwd='"+user.getUserPwd()+"'";
		List<User> users= null;
		users = getSession().createQuery(hql).list();
		if (users.isEmpty()){
			return null;
		} else {
			return users.get(0);
		}
	}
	
	public List<Object> getUsers(){
		String hql = "FROM User ";
		@SuppressWarnings("unchecked")
		List<Object> users = getSession().createQuery(hql).list();
		return users;
	}
}
