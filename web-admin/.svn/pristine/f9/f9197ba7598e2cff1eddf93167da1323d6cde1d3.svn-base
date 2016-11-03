/**
 * 2016年7月6日
 */
package com.imarce.webadmin.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.RegistedStuDao;
import com.imarce.webadmin.dao.RequirementDao;
import com.imarce.webadmin.entity.RegistedStudent;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;

/**
 * Author: 		      Qian
 * 
 * Date: 	          2016年7月6日
 * 
 * Description:		
 */
@Service
public class RegistedStuService {
	Log  log  = LogFactory.getLog(RegistedStuService.class);

	@Autowired
	private RegistedStuDao  registedStuDao  ;
	
	/**
	 * 
	 * @return    
	 */
	public DataGridData queryRegistedStu(Pager page){
		DataGridData  result  = new  DataGridData();
		try {
			List<RegistedStudent>  ls  = registedStuDao.queryRegistedStu(page);
			result.setRows(ls);
			int cnt = registedStuDao.countRegistedStu();
			result.setTotal(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return result;
	}
	
	public boolean delRegistedStu(int studentId) {
		int result = 0;
		try {
			result = registedStuDao.delRegistedStu(studentId);			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}
}
