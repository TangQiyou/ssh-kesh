package com.zy.actions.web;

import java.util.Map;

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
	
	private Map<String, Object> result = null;
	
	@Autowired
	private ZyPictureService zyPictureService;
	
	public String getPictureByDate(){
		if (year != 0) {
			result = Msg.success();
			Msg.add(result, "list", zyPictureService.getPictureByDate(year, month, day));
			return SUCCESS;
		}

		return ERROR;
		
	}
	
	public String getPictureByType() {
		result = Msg.success();
		Msg.add(result, "pictures", zyPictureService.getPictureByType(picType));
		
		return SUCCESS;
	}
	
	public String getPictureByDateAndType() {
		result = Msg.success();
		System.out.println("接收:year="+year+" and month="+month+" and day="+day
				+" and picType="+picType);
		

		Object o = zyPictureService.getPictureByDateAndType(year,month,day,picType);
		if (o != null) {
			Msg.add(result, "returnPicture", (Picture) o);
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
	
}
