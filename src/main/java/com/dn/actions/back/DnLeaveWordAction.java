package com.dn.actions.back;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.dn.service.DnLeaveWordService;
import com.tqy.bean.LeaveWord;
import com.tqy.bean.Msg;
import com.tqy.bean.page.PageInfo;

public class DnLeaveWordAction extends ActionSupport {
	private static final long serialVersionUID = 1L; // 不加要报警告，加上就没事了

	// No.3 编写需调用的接口函数
	public String getLeaveWordsBypage() {
		System.out.println("pn: " + pn);
		PageInfo pageInfo = dnLeaveWordService.getLeaveWordBypage(pn);
		result = Msg.success();
		result = Msg.add(result, "pageInfo", pageInfo);
		return SUCCESS; // 将result返回给前端页面
	}

	// 删除留言
	public String deleteLeaveWord() {
		System.out.println("删除留言...");
		boolean flag = dnLeaveWordService.deleteLeaveWord(leaveWord);
		result = flag ? Msg.success() : Msg.fail();
		return SUCCESS;
	}

	// No.2 这里要加@Autowired注解，自动注入Service，因此在自定义方法中不用声明即可调用
	@Autowired
	DnLeaveWordService dnLeaveWordService;

	// No.1 设置需要用的属性属性
	private Map<String, Object> result = null;
	private Integer pn;
	private LeaveWord leaveWord;

	public LeaveWord getLeaveWord() {
		return leaveWord;
	}

	public void setLeaveWord(LeaveWord leaveWord) {
		this.leaveWord = leaveWord;
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
}
