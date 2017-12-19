package com.zy.actions.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Announcement;
import com.zy.service.ZyAnnouncementService;

public class ZyAnnouncementAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private List<Announcement> annoucements;
	Map<String, Object> result = null;
	
	@Autowired
	ZyAnnouncementService zyAnnoucementService;

	public List<Announcement> getAnnoucements() {
		return annoucements;
	}

	public void setAnnoucements(List<Announcement> annoucements) {
		this.annoucements = annoucements;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	
}
