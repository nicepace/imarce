/**
 * @Title: TestOpinionService.java
 * @Package com.imarce.service
 * @Description: TODO
 * Copyright: Copyright (c) 2015
 * Company:琅琊科技
 *
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月22日 下午5:57:58
 * @version V1.0
 */
package com.imarce.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.imarce.core.service.Result;
import com.imarce.wechat.entity.Opinion;
import com.imarce.wechat.service.impl.OpinionService;

/**
 * @ClassName: TestOpinionService
 * @Description: TODO
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月22日 下午5:57:58
 *
 */
public class TestOpinionService {
    
    ApplicationContext ac = null;
    
    @Before
    public void init() {
        
        ac = new ClassPathXmlApplicationContext( "spring*.xml" );
    }
    
    @Test
    public void testAddOpinion() {
        OpinionService os = ac.getBean( OpinionService.class );
        Opinion op = new Opinion();
        op.setOpinion( "" );
        Result result = os.insertOpinion( op );
        System.out.println( result.getCode() );
        System.out.println( result.getMsg() );
    }
}
