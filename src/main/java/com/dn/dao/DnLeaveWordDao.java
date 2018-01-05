package com.dn.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tqy.bean.Announcement;
import com.tqy.bean.LeaveWord;
import com.tqy.dao.BaseDao;

@Component
public class DnLeaveWordDao extends BaseDao {
	// 根据需求编写查询函数
	public List<Object> getLeaveWords() {
		String hql = "From LeaveWord";
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();
		System.out.println(list);
		return list;
	}

	public Integer deleteLeaveWord(LeaveWord leaveWord) {
		getSession().delete(leaveWord);
		return 1;
	}

	public void updateLeaveWord(LeaveWord leaveword) {

		String hql = "From LeaveWord Where leaveId=" + leaveword.getLeaveId();
		@SuppressWarnings("unchecked")
		List<Object> list = getSession().createQuery(hql).list();

		LeaveWord updateleave = (LeaveWord) list.get(0);

		updateleave.setIsResponsed(leaveword.getIsResponsed());

		System.out.println(leaveword);
		getSession().saveOrUpdate(updateleave);
	}
}
