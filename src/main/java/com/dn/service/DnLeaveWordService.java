package com.dn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dn.dao.DnLeaveWordDao;
import com.tqy.bean.page.PageInfo;

@Service
public class DnLeaveWordService {
		//这里要加autowired注解
		@Autowired
		DnLeaveWordDao dnLeaveWordDao;
		
		public PageInfo getLeaveWordBypage(Integer pn){
			List<Object> list = dnLeaveWordDao.getLeaveWords();
			PageInfo pageInfo = new PageInfo(list, pn, 5, 5);
			System.out.println(pageInfo);
			return pageInfo;
		}
}
