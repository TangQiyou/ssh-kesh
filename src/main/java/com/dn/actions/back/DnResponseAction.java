package com.dn.actions.back;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.dn.service.DnResponseService;
import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Msg;
import com.tqy.bean.page.PageInfo;

public class DnResponseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;   //不加要报警告，加上就没事了
	
	//No.3 编写需调用的接口函数
	public String getResponsesBypage(){
		System.out.println("pn: "+pn);
		PageInfo pageInfo = dnResponseService.getResponseBypage(pn);
		result = Msg.success();
		result = Msg.add(result, "pageInfo", pageInfo);
        return SUCCESS;  //将result返回给前端页面
	}
	
	//No.2 这里要加@Autowired注解，自动注入Service，因此在自定义方法中不用声明即可调用
    @Autowired
    DnResponseService dnResponseService;
	
	//No.1 设置需要用的属性属性
    private Map<String, Object> result = null;
	private Integer pn;
	
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
}
