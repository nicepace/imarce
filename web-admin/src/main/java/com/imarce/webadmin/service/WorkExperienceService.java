/**
 * 2016年7月6日
 */
package com.imarce.webadmin.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.WorkExperienceDao;
import com.imarce.webadmin.entity.WorkExperience;
import com.imarce.webadmin.util.DataGridData;

/**
 * Author: Qian
 * 
 * Date: 2016年7月6日
 * 
 * Description:
 */
@Service
public class WorkExperienceService {
	Log log = LogFactory.getLog(WorkExperienceService.class);

	@Autowired
	private WorkExperienceDao workExperienceDao;

	public List queryWorkExperience(int studentId) {
		List list = null;
		try {
			list = workExperienceDao.queryWorkExperience(studentId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return list;
	}

	public boolean saveWorkExperience(WorkExperience workExperience) {
		int result = 0;
		try {
			result = workExperienceDao.saveWorkExperience(workExperience);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}

	public WorkExperience queryWorkExpById(int workExperienceId) {
		WorkExperience workExperience = null;
		try {
			workExperience = workExperienceDao.queryWorkExpById(workExperienceId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return workExperience;
	}	
	

	public boolean updateWorkExperience(WorkExperience workExperience) {
		int result = 0;
		try {
			result = workExperienceDao.updateWorkExperience(workExperience);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}
	
	public boolean deleteWorkExpById(int workExperienceId){
		int result = 0;
		try {
			result = workExperienceDao.deleteWorkExpById(workExperienceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0 ? true : false;
	}
}
