/**
 * 
 */
package com.imarce.webadmin.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.EmployTendDao;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;

@Service
public class EmployTendService {

	Log  log  = LogFactory.getLog(EmployTendService.class);

	@Autowired
	private EmployTendDao  employTendDao;
	
	/**
	 * 
	 * @return
	 */
	public DataGridData queryEmployTend(Pager page){
		DataGridData  result  = new  DataGridData();
		try {
			List  ls  = employTendDao.queryEmployTend(page);
			result.setRows(ls);
			int cnt = employTendDao.countEmployTend();
			result.setTotal(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return result;
	}
	
	public boolean deleteEmployTend(int employTendId) {
		int result = 0;
		try {
			result = employTendDao.deleteEmployTend(employTendId);			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}
}
