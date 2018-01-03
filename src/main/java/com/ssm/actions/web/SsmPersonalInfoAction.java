package com.ssm.actions.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssm.service.SsmPersonalInfoService;
import com.tqy.bean.Msg;
import com.tqy.bean.User;
import com.tqy.service.TqyCodeService;


public class SsmPersonalInfoAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	public String getUserById(){
		
		User returnUser = ssmPersonalInfoService.getUserById(user.getUserId());
		
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
			ssmPersonalInfoService.updateUser(user);
			result = Msg.success();
			System.out.println("update end...");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = Msg.fail();
			return SUCCESS;
		}

	}
	
	@Autowired
	TqyCodeService tqyCodeService;
	@Autowired
	SsmPersonalInfoService ssmPersonalInfoService;
	
	private User user;
	Map<String, Object> result = null;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
}
