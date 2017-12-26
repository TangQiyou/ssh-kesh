package com.zy.actions.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Msg;
import com.tqy.bean.page.PageInfo;
import com.zy.service.ZyAnnouncementService;

public class ZyAnnouncementAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private Map<String, Object> result = null;
	
	@Autowired
	ZyAnnouncementService zyAnnouncementService;

	public String getAnnouncements(){
		PageInfo pageInfo = zyAnnouncementService.getAnnouncements();
		result = Msg.success();
		result = Msg.add(result, "pageInfo", pageInfo);
		return SUCCESS;
	}


	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	
}
