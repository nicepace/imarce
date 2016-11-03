package com.imarce.webadmin.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.RecommendDao;
import com.imarce.webadmin.entity.Recommend;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;

@Service
public class RecommendService {

	Log  log  = LogFactory.getLog(RecommendService.class);
	
	@Autowired
	private RecommendDao recommendDao;
	
	public DataGridData queryRecommend(Pager page){
		DataGridData result=new DataGridData();
		try {
			List<Recommend> ls=recommendDao.queryRecommend(page);
			result.setRows(ls);
			int count=recommendDao.countRecommend();
			result.setTotal(count);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result;
	}
	
	public boolean deleteRecommend(int recommendId) {
		int result = 0;
		try {
			result = recommendDao.deleteRecommend(recommendId);			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}
}
