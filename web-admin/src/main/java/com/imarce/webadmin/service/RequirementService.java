package com.imarce.webadmin.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.RequirementDao;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

/**
  2016年7月5日 下午2:10:59
  @kriss
    说明：
    版本：
*/
@Service
public class RequirementService {

	Log  log  = LogFactory.getLog(RequirementService.class);

	@Autowired
	private RequirementDao  requirementDao  ;
	
	/**
	 * 
	 * @return
	 */
	public DataGridData queryRequirements(Pager page){
		DataGridData  result  = new  DataGridData();
		try {
			List  ls  = requirementDao.queryRequirements(page);
			result.setRows(ls);
			int cnt = requirementDao.countRequirements();
			result.setTotal(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return result;
	}
	
	public Result queryReqKnowledgeById(int requirementId){
	    Result result = new Result();
	    try {
	        result.setData( requirementDao.queryReqKnowledge( requirementId ) );
            } catch ( Exception e ) {
            log.error(e.getMessage());
            }
	    return result;
	};
	
	public Result queryReqSkillById(int requirementId){
            Result result = new Result();
            try {
                result.setData( requirementDao.queryReqSkill( requirementId ) );
            } catch ( Exception e ) {
            log.error(e.getMessage());
            }
            return result;
        };
        
        public boolean deleteRequirement(int requirementId) {
    		int result = 0;
    		try {
    			result = requirementDao.deleteRequirement(requirementId);			
    		} catch (Exception e) {
    			e.printStackTrace();
    			log.error(e.getMessage());
    		}
    		return result > 0 ? true : false;
    	}
}
