package com.tqy.actions.back;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Announcement;
import com.tqy.bean.Msg;
import com.tqy.bean.page.PageInfo;
import com.tqy.service.TqyAnnouncementService;

public class BackAnnouncementAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	public String getAnnouncementsByPage(){
		System.out.println("pn:"+pn);
		PageInfo pageInfo = tqyAnnouncementService.getAnnouncementBypage(pn);
		result = Msg.success();
		result = Msg.add(result, "pageInfo", pageInfo);
		return SUCCESS;
	}
	
	public String addAnnouncement(){
		System.out.println("添加公告...");
		boolean flag = tqyAnnouncementService.addAnnouncement(announcement);
		result = flag ? Msg.success(): Msg.fail();
		System.out.println("添加公告...end...");
		return SUCCESS;
	}
	
	@Autowired
	TqyAnnouncementService tqyAnnouncementService;
	
	private Map<String, Object> result = null;
	private Integer pn;
	private Announcement announcement;
	
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

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	
}
