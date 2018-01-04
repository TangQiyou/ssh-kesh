package com.ssm.actions.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssm.service.SsmLeavewordService;
import com.tqy.bean.Code;
import com.tqy.bean.LeaveWord;
import com.tqy.bean.Msg;
import com.tqy.bean.Response;
import com.tqy.bean.User;
import com.tqy.bean.page.PageInfo;

public class SsmLeavewordAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	public String getLeavewordByUserid(){
		
		try {
			PageInfo pageInfo = ssmLeavewordService.getLeavewordByUserid(pn, leaveword.getLeaveUserId());
			result = Msg.success();
			result = Msg.add(result, "pageInfo", pageInfo);
			
			return SUCCESS;
		} catch (Exception e) {
			result = Msg.fail();
			e.printStackTrace();
			return SUCCESS;
		}
	}
	
	public String getLeavewordDetails(){
		
		try {
			LeaveWord returnleaveword = ssmLeavewordService.getLeavewordDetails(leaveword.getLeaveId());
			
			result = Msg.success();
			result = Msg.add(result, "leaveword", returnleaveword);
			
			if(returnleaveword.getIsResponsed() == 50){
				
				Response response = ssmLeavewordService.getResponse(leaveword.getLeaveId());
				result = Msg.add(result, "response", response);
			}
			
			return SUCCESS;
		} catch (Exception e) {
			result = Msg.fail();
			e.printStackTrace();
			return SUCCESS;
		}
	}
	public String addLeaveword(){
		
		try {
			ssmLeavewordService.addLeaveword(leaveword);
			
			result = Msg.success();
			
			System.out.println(result);
			return SUCCESS;
		} catch (Exception e) {
			result = Msg.fail();
			e.printStackTrace();
			return SUCCESS;
		}
	}
	public String updateLeaveword(){
		
		System.out.println("修改留言"+leaveword.getLeaveId());
		try {
			
			ssmLeavewordService.updateLeaveword(leaveword);
			
			result = Msg.success();
			
			System.out.println(result);
			return SUCCESS;
		} catch (Exception e) {
			result = Msg.fail();
			e.printStackTrace();
			return SUCCESS;
		}
	}
	public String deleteLeaveword(){
		
		try {
			ssmLeavewordService.deleteLeaveword(leaveword);
			
			result = Msg.success();
			
			System.out.println(result);
			return SUCCESS;
		} catch (Exception e) {
			result = Msg.fail();
			e.printStackTrace();
			return SUCCESS;
		}
	}
	
	@Autowired
	SsmLeavewordService ssmLeavewordService;
	
	private Map<String, Object> result = null;
	private Integer pn;
	private User user;
	private LeaveWord leaveword;
	private Code code;
	private Response response;
	
	
	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

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
	public Integer getPn() {
		return pn;
	}
	public void setPn(Integer pn) {
		this.pn = pn;
	}
	public LeaveWord getLeaveword() {
		return leaveword;
	}
	public void setLeaveword(LeaveWord leaveword) {
		this.leaveword = leaveword;
	}
	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}

	
	
	
}
