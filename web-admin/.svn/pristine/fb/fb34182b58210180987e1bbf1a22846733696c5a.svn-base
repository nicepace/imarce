/**
 * 
 */
package com.imarce.webadmin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.imarce.webadmin.dao.KnowledgeDao;
import com.imarce.webadmin.dao.PositionDao;
import com.imarce.webadmin.dao.PositionSkillModuleDao;
import com.imarce.webadmin.dao.SkillModuleDao;
import com.imarce.webadmin.entity.Knowledge;
import com.imarce.webadmin.entity.Position;
import com.imarce.webadmin.entity.Student;
import com.imarce.webadmin.entity.vo.ComboTreeVO;
import com.imarce.webadmin.entity.vo.KnowledgeVO;
import com.imarce.webadmin.entity.vo.OptionVO;
import com.imarce.webadmin.entity.vo.SkillVO;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;

/**
 * @author JianqMQ
 * 2016年7月6日 下午2:15:57
 */

@Service
public class PositionService {

	Log  log  = LogFactory.getLog(PositionService.class);

	@Autowired
	private PositionDao  positionDao;
	@Autowired
	private PositionSkillModuleDao psDao;
	@Autowired
	private KnowledgeDao kDao;
	
	
	/**
	 * @return the positionDao
	 */
	public PositionDao getPositionDao() {
		return positionDao;
	}

	/**
	 * @param positionDao the positionDao to set
	 */
	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	/**
	 * @return the psDao
	 */
	public PositionSkillModuleDao getPsDao() {
		return psDao;
	}

	/**
	 * @param psDao the psDao to set
	 */
	public void setPsDao(PositionSkillModuleDao psDao) {
		this.psDao = psDao;
	}


	/**
	 * 
	 * @return
	 */
	public DataGridData queryPosition(Pager page){
		DataGridData  result  = new  DataGridData();
		try {
			List<Position> ls  = positionDao.queryPosition(page);
			result.setRows(ls);
			int cnt = positionDao.countPosition();
			result.setTotal(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public List  queryPositionForSelect(){
		List ls = null ;
		try {
			ls = positionDao.queryPositionForSelect();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return ls;
	}
	
	public Position queryPositionById(int  pid){
		Position position = null;
		try {
			position = positionDao.queryPositionById(pid);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return position;
	}

	public boolean  addPositionBasic(Position position){
		int result = 0 ;
		try {	
			result = positionDao.addPositionBasic(position);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ?true:false;
	}

	/**
	 * 查询岗位名称
	 * @author shadow
	 * @return List
	 */
	public List queryPositionName(){
		List list = null;
		try {
			list = positionDao.queryPositionName();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return list;
	}

	/**
	 * @param position
	 * @return
	 */
	public boolean editPosition(Position position) {
		int result = 0 ;
		try {
			result=positionDao.editPosition(position);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ?true:false;
	}
	
	public boolean deletePosition(int positionId){
		int result = 0 ;
		try {
			result= positionDao.deletePosition(positionId);;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ?true:false;
		
	}


}
