package com.imarce.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.imarce.wechat.dao.OpinionDao;
import com.imarce.wechat.entity.Opinion;

/**
 * @version
 * @author zhoujb
 * @time 2016年6月21日下午5:02:47
 */
public class TestOpinionDao {
    
    ApplicationContext ac = null;
    
    @Before
    public void init() {
        
        ac = new ClassPathXmlApplicationContext( "spring*.xml" );
    }
    
    
    @Test
    public void testAddOpinion() {
        OpinionDao rrd = ac.getBean( OpinionDao.class );
        Opinion op = new Opinion();
        op.setOpinion( "die" );
        System.out.println( rrd.insertOpinion( op ) );
    }
}
