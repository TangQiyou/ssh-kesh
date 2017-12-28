package com.tqy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Code;
import com.tqy.bean.User;
import com.tqy.bean.page.PageInfo;
import com.tqy.dao.CodeDao;
import com.tqy.dao.TqyUserDao;

/**
 * 每个Service类的开头要加@Service注解
 * @author TQY 2017-12-17 23:03:42
 * 
 */
@Service
public class TqyUserService {
	
	//这里要加autowired注解
	@Autowired
	TqyUserDao tqyUserDao;
	@Autowired
	CodeDao codeDao;
	
	public User userLogin(User user){
		return tqyUserDao.userLogin(user);
	}
	
	public PageInfo getUserByPage(Integer pn){
		List<Object> list = tqyUserDao.getUsers();
		
		List<Object> genders = codeDao.getCodeByCodeType("gender");
		List<Object> colleges = codeDao.getCodeByCodeType("college_type");
		List<Object> status = codeDao.getCodeByCodeType("status_type");
		
		//将查处的User设置statusName, collegeName, genderNames
		List<Object>list2 = new ArrayList<Object>();
		User user = null;
		for (int i = 0; i < list.size(); i++){
			user = (User)list.get(i);
			user.setGenderName(getCodeNameByCodeValue(genders,user.getGender()));
			user.setStatusName(getCodeNameByCodeValue(status, user.getStatus()));
			user.setCollegeName(getCodeNameByCodeValue(colleges, user.getCollege()));
			list2.add(user);
		}

		PageInfo pageInfo = new PageInfo(list2, pn, 5, 5);
		return pageInfo;
	}
	
	public String getCodeNameByCodeValue(List<Object> codeList, Integer codeValue){
		Code code = null;
		String codeName = null;
		for (int i = 0; i < codeList.size(); i++){
			code = (Code)codeList.get(i);
			if (code.getCodeValue() == codeValue){
				codeName = code.getCodeName();
				break;
			}
		}
		return codeName;
	}
	
	public User getUserById(Integer id){
		User user = tqyUserDao.getUserById(id);
		return user;
	}
}
