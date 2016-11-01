/**
 * @Title: OpinionService.java
 * @Package com.imarce.wechat.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2015
 * Company:琅琊科技
 *
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月16日 下午2:48:46
 * @version V1.0
 */
package com.imarce.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imarce.core.service.BaseService;
import com.imarce.core.service.Result;
import com.imarce.core.utils.Validation;
import com.imarce.wechat.dao.OpinionDao;
import com.imarce.wechat.entity.Opinion;

/**
 * @ClassName: OpinionService
 * @Description: TODO
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月16日 下午2:48:46
 *
 */
@Service("OpinionService")
@Transactional
public class OpinionService extends BaseService{
    @Autowired
    private OpinionDao opinionDao;
    
    /**
     * 
     * @Description: 提交一条意见
     * @param    
     * @return   Result
     * @throws
     */
    public Result insertOpinion(Opinion opinion){
        Result result = new Result();
        if(Validation.StrisNull( opinion.getOpinion() ) ){
            result.setCode( 0 );
            result.setMsg( "意见不能为空！" );
            return result;
        }
        
        else if(opinionDao.insertOpinion( opinion ) == 1 ){
            result.setCode( 1 );
            result.setMsg( "您的意见已提交，</br>感谢您对本公司的支持！" );
            return result;
        }
        else 
        {
            result.setCode( 0 );
            result.setMsg( "数据库写入错误" );
            return result;
        }
    }
}
