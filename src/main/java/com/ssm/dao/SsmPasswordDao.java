package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.User;
import com.tqy.dao.BaseDao;

@Component
public class SsmPasswordDao extends BaseDao{
	
	
	public String updatePassword(Integer id,String oldpwd,String newPwd){
		String hql = "From User Where userId=" + id;
		String info = "";
		System.out.println(hql);
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		
		User user = (User) list.get(0);
		
		if(oldpwd.equals(user.getUserPwd())){
			info = "修改成功";
			user.setUserPwd(newPwd);
			getSession().saveOrUpdate(user);
		}else{
			info = "原密码错误";
		}
		
		System.out.println(user);
		
		return info;
	}
	
}
