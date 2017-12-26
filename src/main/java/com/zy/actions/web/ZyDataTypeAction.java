package com.zy.actions.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Code;
import com.tqy.bean.Msg;
import com.zy.service.ZyDataTypeService;

public class ZyDataTypeAction extends ActionSupport{

	private static final long serialVersionUID = 3L;
	
	private String code_type; // 数据类型
	private Map<String, Object> result = null;
	
	@Autowired
	ZyDataTypeService zyDataTypeService;
	
	// 返回所有的图片类型信息
	public String getCodeByType() throws Exception{
		List<Object> list2 = zyDataTypeService.getDataByType(code_type);
		List<Code> list = new ArrayList<>();
		for (Object o : list2) {
			list.add((Code)o);
		}
		result = Msg.success();
		Msg.add(result, "list", list);	
		
		return SUCCESS;
	}
	
	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String getCode_type() {
		return code_type;
	}

	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}
	
	

	
	
}
