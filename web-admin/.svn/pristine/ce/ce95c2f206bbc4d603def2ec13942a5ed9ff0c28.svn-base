package com.imarce.webadmin.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.OpinionsDao;
import com.imarce.webadmin.dao.RequirementDao;
import com.imarce.webadmin.entity.Opinions;
import com.imarce.webadmin.service.RequirementService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;

/**
 * 
 * 2016年7月5日 下午7:04:13
 * @author shadow
 * 说明：意见表业务逻辑层实现类
 *
 */
@Service
public class OpinionsServiceImpl {
	//日志对象
	Log  log  = LogFactory.getLog(RequirementService.class);
	
	//Opinions数据访问层对象
	@Autowired
	private OpinionsDao opinionsDao;
	
	/**
	 * 查询意见表，返回带意见总数和每页显示数的json数据集合
	 * @param page
	 * @return DataGridData
	 */
	public DataGridData queryOpinions(Pager page){
		DataGridData  result  = new  DataGridData();
		try{
			List list = opinionsDao.queryOpinions(page);
			result.setRows(list);
			int count = opinionsDao.countOpinions();
			result.setTotal(count);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 根据意见id查询选定的opinion 
	 * @param opinionId
	 * @return Opinions
	 */
	public Opinions queryOpinionById(int opinionId){
		Opinions opinion = new Opinions();
		try {
			opinion = opinionsDao.queryOpinionById(opinionId);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return opinion;		
	}
	
	public boolean deleteOpinion(int opinionId) {
		int result = 0;
		try {
			result = opinionsDao.deleteOpinion(opinionId);			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}

}
