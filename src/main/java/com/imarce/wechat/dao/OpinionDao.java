/**
 * @Title: OpinionDao.java
 * @Package com.imarce.wechat.dao
 * @Description: TODO
 * Copyright: Copyright (c) 2015
 * Company:琅琊科技
 *
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月16日 下午2:08:33
 * @version V1.0
 */
package com.imarce.wechat.dao;

import org.springframework.stereotype.Repository;

import com.imarce.core.db.BaseDao;
import com.imarce.wechat.entity.Opinion;

@Repository("OpinionDao")
public interface OpinionDao extends BaseDao{
   /**
    * 
    * @Description: 插入一条意见
    * @param    
    * @return   int
    * @throws
    */
    public int insertOpinion(Opinion opinion);

}
