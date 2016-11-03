/**
 * 
 */
package com.imarce.webadmin.dao;

import java.util.List;

import com.imarce.webadmin.entity.Position;
import com.imarce.webadmin.entity.Student;
import com.imarce.webadmin.util.Pager;

/**
 * @author JianqMQ
 * 2016年7月6日 下午2:09:03
 */
public interface PositionDao {

	public List<Position> queryPosition(Pager page) throws Exception;
	
	public int countPosition() throws Exception;
	
	public List queryPositionForSelect()  throws Exception;

	public Position queryPositionById(int pid) throws Exception;
	
	public int addPositionBasic(Position position)  throws Exception;
	
	public List queryPositionName() throws Exception;

	/**
	 * @param position
	 * @return
	 */
	public int editPosition(Position position) throws Exception;
	public int deletePosition(int positionId) throws Exception;
}
