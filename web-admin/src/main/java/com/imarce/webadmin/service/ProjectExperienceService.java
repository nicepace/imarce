/**
 * 2016年7月6日
 */
package com.imarce.webadmin.service;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.ProjectExperienceDao;
import com.imarce.webadmin.entity.ProjectExperience;

/**
 * Author: Qian
 * 
 * Date: 2016年7月6日
 * 
 * Description:
 */
@Service
public class ProjectExperienceService {
	Log log = LogFactory.getLog(ProjectExperienceService.class);

	@Autowired
	private ProjectExperienceDao projectExperienceDao;

	public List queryProjectExperience(int studentId) {
		List list = null;
		try {
			list = projectExperienceDao.queryProjectExperience(studentId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return list;
	}

	public boolean saveProjectExperience(ProjectExperience projectExperience) {
		int result = 0;
		try {
			result = projectExperienceDao.saveProjectExperience(projectExperience);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}

	public ProjectExperience queryProjectExpById(int projectExperienceId) {
		ProjectExperience projectExperience = new ProjectExperience();
		try {
			projectExperience = this.projectExperienceDao.queryProjectExpById(projectExperienceId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return projectExperience;
	}

	public boolean updateProjectExperience(ProjectExperience projectExperience) {
		int result = 0;
		try {
			result = projectExperienceDao.updateProjectExperience(projectExperience);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}
	
	public boolean deleteProjectExpById(int projectExperienceId){
		int result = 0;
		try {
			result = projectExperienceDao.deleteProjectExpById(projectExperienceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0 ? true : false;
	}
	
}
