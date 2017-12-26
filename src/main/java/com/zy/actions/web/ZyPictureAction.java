package com.zy.actions.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Msg;
import com.zy.service.ZyPictureService;

public class ZyPictureAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	private int year;
	private int month;
	private int day;
	
	private Map<String, Object> result = null;
	
	@Autowired
	private ZyPictureService zyPictureService;
	
	public String getPictureByDate(){
		System.out.println("year:"+year);
		
		if (year != 0) {
			result = Msg.success();
			Msg.add(result, "list", zyPictureService.getPictureByDate(year, month, day));
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


	

	
	
	
	
	
}
