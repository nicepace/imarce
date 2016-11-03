/**
 * 2016年7月6日
 */
package com.imarce.webadmin.dao;

import java.util.List;

import com.imarce.webadmin.entity.WorkExperience;

/**
 * Author: Qian
 * 
 * Date: 2016年7月6日
 * 
 * Description:
 */
public interface WorkExperienceDao {

	public List<WorkExperience> queryWorkExperience(int studentId) throws Exception;

	public int countWorkExperience() throws Exception;

	public int saveWorkExperience(WorkExperience workExperience) throws Exception;

//	public WorkExperience queryWorkExpById(int studentId) throws Exception;

	public WorkExperience queryWorkExpById(int workExperienceId) throws Exception;
	
	public int updateWorkExperience(WorkExperience workExperience) throws Exception;
	
	public int deleteWorkExpById(int workExperienceId) throws Exception;
	
}
