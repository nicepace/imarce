/**
 * @Title: Reg_RecDao.java
 * @Package com.imarce.wechat.dao
 * @Description: TODO
 * Copyright: Copyright (c) 2015
 * Company:琅琊科技
 *
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月16日 下午2:22:20
 * @version V1.0
 */
package com.imarce.webadmin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imarce.core.db.BaseDao;
import com.imarce.core.service.Page;
import com.imarce.wechat.entity.Position;
import com.imarce.wechat.entity.Recommend;
import com.imarce.wechat.entity.StudentRegister;
import com.imarce.wechat.vo.BestStudentVo;

@Repository("RegRecDao")
public interface RegRecDao extends BaseDao{
    /**
     * 
     * @Description: 注册成为i码士
     * @param    
     * @return   受影响行数
     * @throws
     */
    public int insertStudent(StudentRegister studentRegister);
    /**
     * 
     * @Description: 推荐候选人
     * @param    
     * @return   受影响行数
     * @throws
     */
    public int insertRecommend(Recommend recommend);
    /**
     * 
     * @Description: 查询已经就业的优秀学员
     * @param    
     * @return   BestStudentVo集合
     * @throws
     */
    public List<BestStudentVo> selectBestStudent(Page page);
    public int countBestStudent();
    public List<Position> selectPosition();
}
