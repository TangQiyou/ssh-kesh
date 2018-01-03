package com.dn.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dn.dao.DnResponseDao;
import com.tqy.bean.Announcement;
import com.tqy.bean.Response;
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
			public Boolean deleteResponse(Response response){
				Integer integer = dnResponseDao.deleteResponse(response);
				return integer == 1 ? true: false;
			}
			public Boolean addResponse(Response response){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = format.format(new Date());
				response.setResponseTime(time);
				Integer i = dnResponseDao.addResponse(response);
				return i == 1 ? true: false;
			}
}
