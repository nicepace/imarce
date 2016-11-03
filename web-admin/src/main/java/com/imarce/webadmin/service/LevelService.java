package com.imarce.webadmin.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.LevelDao;
import com.imarce.webadmin.entity.Level;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;

@Service
public class LevelService {

	Log  log  = LogFactory.getLog(LevelService.class);
	@Autowired
	private LevelDao levelDao;
	
	public DataGridData queryLevel(Pager page){
		DataGridData  result  = new  DataGridData();
		try {
			List<Level> ls=levelDao.queryLevel(page);
			result.setRows(ls);
			int count = levelDao.countLevel();	
			result.setTotal(count);
			} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result;
	}
	
	public List<Level> levelForSelect(){
		List<Level> ls=null;
		try {
			ls=levelDao.levelForSelect();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return ls;
	}
	/**
	 * 
	 * @param lid
	 * @return
	 */
	public Level queryLevelById(int  lid){
		Level level = null;
		try {
			level = levelDao.queryLevelById(lid);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return level;
	}
	
	
	public boolean updateLevel(Level level){
		int result = 0 ;
		try {
			result=levelDao.updateLevel(level);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ?true:false;
	}
	
	public boolean insertLevel(Level level){
		int result = 0 ;
		try {
			result=levelDao.insertLevel(level);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ?true:false;
	}
	
	public boolean deleteLevel(int levelId){
		int result = 0 ;
		try {
			result=levelDao.deleteLevel(levelId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ?true:false;
	}
	
	
	
	
		
}
