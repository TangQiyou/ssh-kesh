package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.SsmLeavewordDao;
import com.ssm.dao.SsmPersonalInfoDao;
import com.tqy.bean.LeaveWord;
import com.tqy.bean.Response;
import com.tqy.bean.page.PageInfo;

@Service
public class SsmLeavewordService {
	
	@Autowired
	SsmLeavewordDao ssmLeavewordDao;
	
	@Autowired
	SsmPersonalInfoDao ssmPersonalInfoDao;
	
	public PageInfo getLeavewordByUserid(Integer pn,Integer id){
		System.out.println("service得到用户"+pn+","+id);
		List<Object> list = ssmLeavewordDao.getLeavewordByUserid(id);
		PageInfo pageInfo = new PageInfo(list, pn, 5, 5);
		
		System.out.println(pageInfo);
		return pageInfo;
	}
	
	public LeaveWord getLeavewordDetails(Integer leaveid){
		
		System.out.println("service得到留言id"+leaveid);
		LeaveWord leaveWord =  ssmLeavewordDao.getLeavewordDetails(leaveid);
		
		System.out.println(leaveWord);
		return leaveWord;
	}
	
	public Response getResponse(Integer leaveid){
		
		System.out.println("查找留言id："+leaveid);
		
		Response response = ssmLeavewordDao.getResponse(leaveid);
		
		return response;
	}
	
	public void addLeaveword(LeaveWord leaveword){
		leaveword.setLeaveUser(ssmPersonalInfoDao.getUserById(leaveword.getLeaveUserId()));
		ssmLeavewordDao.addLeaveword(leaveword);
	}
	
	public void updateLeaveword(LeaveWord leaveword){
		
		ssmLeavewordDao.updateLeaveword(leaveword);
	}
	
	public void deleteLeaveword(LeaveWord leaveword){
		
		ssmLeavewordDao.deleteLeaveword(leaveword);
	}
}
