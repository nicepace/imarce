package com.imarce.webadmin.dao;



import java.util.List;

import com.imarce.webadmin.entity.Level;
import com.imarce.webadmin.util.Pager;

public interface LevelDao {

	public List<Level> queryLevel(Pager page) throws Exception;
	public List<Level> levelForSelect() throws Exception;
	public int countLevel() throws Exception;
	
	public Level queryLevelById(int lid) throws Exception;
	
	public int updateLevel(Level level) throws Exception;
	
	public int insertLevel(Level level) throws Exception; 
	public int deleteLevel(int levelId) throws Exception;
	 
	
	
}
