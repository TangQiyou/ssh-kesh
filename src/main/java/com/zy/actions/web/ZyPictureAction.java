package com.zy.actions.web;

import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Msg;
import com.tqy.bean.Picture;
import com.zy.service.ZyPictureService;

public class ZyPictureAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	private int year;
	private int month;
	private int day;
	
	private int picType;
	private String picName;
	
	private InputStream is;
	
	private Map<String, Object> result = null;
	
	@Autowired
	private ZyPictureService zyPictureService;
	
	public String getPictureByDate(){
		if (year != 0) {
			result = Msg.success();
			Msg.add(result, "list", zyPictureService.getPictureByDate(year, month, day));
		}else {
			System.out.println("未接收到year, month, day");
		}

		return SUCCESS;
	}
	
	public String getPictureByType() {
		if (picType != 0) {
			result = Msg.success();
			Msg.add(result, "pictures", zyPictureService.getPictureByType(picType));
		}else {
			System.out.println("未接收到picType");
		}
		
		
		return SUCCESS;
	}
	
	public String getPictureByDateAndType() {
		result = Msg.success();
		Picture p = zyPictureService.getPictureByDateAndType(year,month,day,picType);
		Msg.add(result, "returnPicture", p);
		
		return SUCCESS;
	}
	
	// 下载图片
	public String downloadPicture() {
		if (year != 0 && picType !=0) {
			Picture p = zyPictureService.getPictureByDateAndType(year,month,day,picType);
			picName = p.getPicName();
			String url = p.getUrl().substring(2, p.getUrl().length());
			is = ServletActionContext.getServletContext().getResourceAsStream(url);
		}else {
			System.out.println("下载图片方法没接收到year和picType参数");
		}
		
		return SUCCESS;
	}
	

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getPicType() {
		return picType;
	}

	public void setPicType(int picType) {
		this.picType = picType;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}
	
}
