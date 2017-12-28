package com.tqy.actions.back;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Msg;
import com.tqy.bean.User;
import com.tqy.bean.page.PageInfo;
import com.tqy.service.TqyCodeService;
import com.tqy.service.TqyUserService;

public class BackUserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	public String getUserByPage(){
		try {
			System.out.println("正在访问第  "+pn+"  页用户");
			PageInfo pageInfo = tqyUserService.getUserByPage(pn);
			result = Msg.success();
			result = Msg.add(result, "pageInfo", pageInfo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = Msg.fail();
			return SUCCESS;
		}

	}
	
	public String getUserById(){
		System.out.println("查找ID为   "+ user.getUserId()+"  的用户");
		User returnUser = tqyUserService.getUserById(user.getUserId());
		System.out.println(returnUser);
		if (returnUser == null){
			result = Msg.fail();
		} else {
			result = Msg.success();
			result = Msg.add(result, "user", returnUser);
			result = Msg.add(result, "genderList", tqyCodeService.getCodesByCodeType("gender"));
			result = Msg.add(result, "collegeList", tqyCodeService.getCodesByCodeType("college_type"));
			result = Msg.add(result, "statusList", tqyCodeService.getCodesByCodeType("status_type"));
		}
		return SUCCESS;
	}
	

	public String updateUser(){
		try {
			System.out.println("修改userId为   "+user.getUserId()+"  的信息");
			tqyUserService.updateUser(user);
			result = Msg.success();
			System.out.println("update end...");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = Msg.fail();
			return SUCCESS;
		}

	}
	
	public String deleteUser(){
		try {
			System.out.println("delete the information of userId = " +user.getUserId());
			tqyUserService.deleteUser(user);
			result = Msg.success();
			System.out.println("delete...end..");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = Msg.fail();
			return SUCCESS;
		}

	}
	
	@Autowired
	TqyUserService tqyUserService;
	@Autowired
	TqyCodeService tqyCodeService;
	
	private Map<String, Object> result = null;
	private Integer pn;
	private User user;
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public Integer getPn() {
		return pn;
	}
	public void setPn(Integer pn) {
		this.pn = pn;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
