package com.ssm.actions.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssm.service.SsmPasswordService;
import com.tqy.bean.Msg;
import com.tqy.bean.User;

public class SsmPasswordAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	public String updatePassword(){
		try {
			System.out.println("修改userId为   "+user.getUserId()+"  的信息");
			String pwdinfo = ssmPasswordService.updatePassword(user.getUserId(),user.getOldPwd(),user.getUserPwd());
			System.out.println(user.getUserId());
			result = Msg.success();
			result = Msg.add(result, "info", pwdinfo);
			System.out.println("update end...");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = Msg.fail();
			return SUCCESS;
		}

	}
	
	
	
	@Autowired
	SsmPasswordService ssmPasswordService;
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
