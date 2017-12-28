package com.dn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dn.dao.DnResponseDao;
import com.tqy.bean.page.PageInfo;

@Service
public class DnResponseService {
	//这里要加autowired注解
			@Autowired
			DnResponseDao dnResponseDao;
			
			public PageInfo getResponseBypage(Integer pn){
				List<Object> list = dnResponseDao.getResponses();
				PageInfo pageInfo = new PageInfo(list, pn, 5, 5);
				System.out.println(pageInfo);
				return pageInfo;
			}
}
