package com.tqy.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.Admin;

@Component
public class TqyAdminDao extends BaseDao{

	public int adminLogin(Admin admin){
		String hql = "FROM Admin a WHERE a.adminAccount='"+admin.getAdminAccount()+"' and a.adminPwd='"+admin.getAdminPwd()+"'";
		List<Admin> admins= null;
		admins = getSession().createQuery(hql).list();
		if (admins.isEmpty()){
			return 0;
		} else {
			return 1;
		}
	}
}
