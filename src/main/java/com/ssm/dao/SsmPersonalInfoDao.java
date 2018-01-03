package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.User;
import com.tqy.dao.BaseDao;

@Component
public class SsmPersonalInfoDao extends BaseDao {

	public User getUserById(Integer id) {

		String hql = "From User Where userId=" + id;
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		if (list.isEmpty()) {
			return null;
		} else {
			return (User) list.get(0);
		}
	}

	public void updateUser(User user) {
		System.out.println(user);
		getSession().saveOrUpdate(user);
	}

}
