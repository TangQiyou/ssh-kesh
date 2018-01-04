package com.ssm.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.LeaveWord;
import com.tqy.bean.Response;
import com.tqy.dao.BaseDao;


@Component
public class SsmLeavewordDao extends BaseDao{
	
	public List<Object> getLeavewordByUserid(Integer id){
		
		String hql = "From LeaveWord Where leaveUserId =" +id;
		
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		
		if (list.isEmpty()){
			
			return null;
		} else {
			
			return list;
		}
		
	}
	
	public LeaveWord getLeavewordDetails(Integer leaveid) {

		String hql = "From LeaveWord Where leaveId=" + leaveid;
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		
		if (list.isEmpty()) {
			return null;
		} else {
			return (LeaveWord) list.get(0);
		}
	}
	
	public Response getResponse(Integer leaveid){
		
		String rhql = "From Response Where responseId=" + leaveid;
		
		@SuppressWarnings("unchecked")
		List<Object> responselist = getSession().createQuery(rhql).list();
		
		if (responselist.isEmpty()) {
			return null;
		} else {
			return (Response) responselist.get(0);
		}
		
	}
	
	public void updateLeaveword(LeaveWord leaveword) {
		
		String hql = "From LeaveWord Where leaveId=" + leaveword.getLeaveId();
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		
		Date date=new Date();  
	    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    
		LeaveWord updateleave = (LeaveWord) list.get(0);
		
		updateleave.setLeaveContent(leaveword.getLeaveContent());
		updateleave.setLeaveTitle(leaveword.getLeaveTitle());
		updateleave.setLeaveTime(formatter.format(date));
		
		System.out.println(leaveword);
		getSession().saveOrUpdate(updateleave);
	}
	
	public void addLeaveword(LeaveWord leaveword){
		
		Date date=new Date();  
	    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    
		leaveword.setLeaveTime(formatter.format(date));
		leaveword.setIsResponsed(51);
		
		System.out.println("添加的留言"+leaveword);
		getSession().saveOrUpdate(leaveword);
	}
	public void deleteLeaveword(LeaveWord leaveword){
		
		getSession().delete(leaveword);
	}
}
