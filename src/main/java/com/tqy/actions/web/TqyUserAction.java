package com.tqy.actions.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Msg;
import com.tqy.bean.User;
import com.tqy.service.TqyUserService;

/**
 * 
 * @author TQY 2017-12-17 23:03:11
 *
 */
public class TqyUserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;   //不加要报警告，加上就没事了
	
	//No.3 编写需调用的接口函数
	public String userLogin() throws Exception {    	
    	User returnUser = null;
    	returnUser = tqyUserService.userLogin(user);   //将得到的user传递给service方法
        
    	//根据调用service的返回值确定最后的返回内容
    	if (returnUser != null){
    		result = Msg.success();   //位于com.tqy.bean.Msg中的success方法
    		result = Msg.add(result, "user", returnUser);  //位于com.tqy.bean.Msg中的add方法
    	} else {
    		result = Msg.fail();
    	}
        return SUCCESS;  //将result返回给前端页面
    }
    
    //No.2 这里要加@Autowired注解，自动注入Service，因此在自定义方法中不用声明即可调用
    @Autowired
    TqyUserService tqyUserService;
    
    //No.1 设置需要用的属性属性
    private User user;    //将传入的参数与User的属性自动赋值，必须有get和set方法
    Map<String, Object> result = null;   //用于存放返回值，必须有要有get和set方法
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

    //No.1 设置属性
//	private int userId;
//	private String userAccount;
//	private String userPwd;
//	private String userLastLoginTime;
//	private String userName;
//	private String email;
//	private int age;
//	private String qq;
//	private String tel;
//	private String oldPwd;
//	private String userHead;
//	
//	private int college;
//	private String collegeName;
//	private int status;
//	private String statusName;
//	private int gender;
//	private String genderName;
//	
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public String getUserAccount() {
//		return userAccount;
//	}
//	public void setUserAccount(String userAccount) {
//		this.userAccount = userAccount;
//	}
//	public String getUserPwd() {
//		return userPwd;
//	}
//	public void setUserPwd(String userPwd) {
//		this.userPwd = userPwd;
//	}
//	public String getUserLastLoginTime() {
//		return userLastLoginTime;
//	}
//	public void setUserLastLoginTime(String userLastLoginTime) {
//		this.userLastLoginTime = userLastLoginTime;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getQq() {
//		return qq;
//	}
//	public void setQq(String qq) {
//		this.qq = qq;
//	}
//	public String getTel() {
//		return tel;
//	}
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//	public String getOldPwd() {
//		return oldPwd;
//	}
//	public void setOldPwd(String oldPwd) {
//		this.oldPwd = oldPwd;
//	}
//	public String getUserHead() {
//		return userHead;
//	}
//	public void setUserHead(String userHead) {
//		this.userHead = userHead;
//	}
//	public int getCollege() {
//		return college;
//	}
//	public void setCollege(int college) {
//		this.college = college;
//	}
//	public String getCollegeName() {
//		return collegeName;
//	}
//	public void setCollegeName(String collegeName) {
//		this.collegeName = collegeName;
//	}
//	public int getStatus() {
//		return status;
//	}
//	public void setStatus(int status) {
//		this.status = status;
//	}
//	public String getStatusName() {
//		return statusName;
//	}
//	public void setStatusName(String statusName) {
//		this.statusName = statusName;
//	}
//	public int getGender() {
//		return gender;
//	}
//	public void setGender(int gender) {
//		this.gender = gender;
//	}
//	public String getGenderName() {
//		return genderName;
//	}
//	public void setGenderName(String genderName) {
//		this.genderName = genderName;
//	} 
}
