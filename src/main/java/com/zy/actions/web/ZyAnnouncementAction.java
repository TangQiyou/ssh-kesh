package com.zy.actions.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Announcement;
import com.tqy.bean.Msg;
import com.tqy.bean.page.PageInfo;
import com.zy.service.ZyAnnouncementService;

public class ZyAnnouncementAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private Integer pn; // 公告的页数
	private Integer id; // 公告的ID
	private Map<String, Object> result = null;
	
	@Autowired
	ZyAnnouncementService zyAnnouncementService;

	// 获取首页侧边栏的公告
	public String getAnnouncements(){
		PageInfo pageInfo = zyAnnouncementService.getAnnouncements();
		result = Msg.success();
		result = Msg.add(result, "pageInfo", pageInfo);
		return SUCCESS;
	}
	
	// 获取最新10条公告信息
	public String getAnnouncements2() {
		if (pn != null) {
			PageInfo pageInfo = zyAnnouncementService.getAnnouncements2(pn);
			result = Msg.success();
			result = Msg.add(result, "pageInfo", pageInfo);
		}else {
			System.out.println("没有接收到数据pn");
		}
		
		return SUCCESS;
	}
	
	// 获取一条公告的详细信息
	public String getAnnouncement() {
		if (id != null) {
			Announcement announcement = zyAnnouncementService.getAnnoucement(id);
			if (announcement != null) {
				result = Msg.success();
				result = Msg.add(result, "announcement", announcement);
			}
		}else {
			System.out.println("没有接收到公告id");
		}
		
		return SUCCESS;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
