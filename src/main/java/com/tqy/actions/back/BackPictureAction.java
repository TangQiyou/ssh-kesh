package com.tqy.actions.back;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Code;
import com.tqy.bean.Picture;

public class BackPictureAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public List<Picture> getPictureByTypeWithPage(){
		return null;
	}
	
	public List<Picture> getPictureByDate(){
		return null;
	}
	
	public Picture addOnlyPicture(){
		return null;
	}
	
	public Picture addPicture(){
		return null;
	}
	
	public void updatePicture(){
		
	}
	
	public void deletePicture(){
		
	}
	
	
	private Map<String, Object> result = null;
	private Integer pn;
	private Picture picture;
	private Code code;
	
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
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}
}