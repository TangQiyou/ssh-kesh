package com.tqy.actions.pub;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Code;
import com.tqy.bean.Msg;
import com.tqy.service.TqyCodeService;

public class PubUtilAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	public String getCodeByType(){
		try {
			System.out.println("get the code type: "+code.getCodeType());
			List<Object> list = tqyCodeService.getCodesByCodeType(code.getCodeType());
			result = Msg.success();
			result = Msg.add(result, "list", list);
			return SUCCESS;
		} catch (Exception e) {
			result = Msg.fail();
			return SUCCESS;
		}
	}
	
	@Autowired
	TqyCodeService tqyCodeService;
	
	private Code code;
	private Map<String, Object> result = null;

	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
