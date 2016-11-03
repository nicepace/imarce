package com.imarce.webadmin.dao;

import java.util.List;

import com.imarce.webadmin.entity.Opinions;
import com.imarce.webadmin.util.Pager;

/**
 * 
 * 2016年7月5日 下午6:42:06
 * @author shadow
 * 说明：意见表的数据访问层
 *
 */
public interface OpinionsDao {
	/**
	 * 查询意见表
	 * @param page
	 * @return List
	 * @throws Exception
	 */
	public List queryOpinions(Pager page) throws Exception;
	
	/**
	 * 查询意见表意见数量
	 * @return Integer
	 * @throws Exception
	 */
	public int countOpinions() throws Exception;
	/**
	 * 根据意见id查询意见
	 * @param opinionId
	 * @return Opinions
	 * @throws Exception
	 */
	public Opinions queryOpinionById(int opinionId) throws Exception;
	
	public int deleteOpinion(int opinionId) throws Exception;
}
