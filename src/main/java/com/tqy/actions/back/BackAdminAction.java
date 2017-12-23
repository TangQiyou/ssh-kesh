package com.tqy.actions.back;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Admin;
import com.tqy.bean.Msg;
import com.tqy.service.TqyAdminService;

public class BackAdminAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;   //不加要报警告，加上就没事了
	
	public String adminLogin(){
		
		//System.out.println(admin);
		boolean flag = tqyAdminService.adminLogin(admin);
    	if (flag){
    		result = Msg.success();   //位于com.tqy.bean.Msg中的success方法
    		//result = Msg.add(result, "user", returnUser);  //位于com.tqy.bean.Msg中的add方法
    	} else {
    		result = Msg.fail();
    	}
		return SUCCESS;
	}
	
	
	@Autowired
	TqyAdminService tqyAdminService;
	
	private Admin admin;
	private Map<String, Object> result = null;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
