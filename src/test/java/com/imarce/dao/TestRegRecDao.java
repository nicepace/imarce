package com.imarce.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.imarce.core.service.Page;
import com.imarce.wechat.dao.RegRecDao;
import com.imarce.wechat.entity.Recommend;
import com.imarce.wechat.entity.StudentRegister;

/**
 * @version
 * @author zhoujb
 * @time 2016年6月21日下午5:02:47
 */
public class TestRegRecDao {
    
    ApplicationContext ac = null;
    
    @Before
    public void init() {
        
        ac = new ClassPathXmlApplicationContext( "spring*.xml" );
    }
    
    @Test
    public void testSelectBest() {
        Page page = new Page();
        page.setPageNum( 1 );
        page.setPageEnd();
        page.setPageStart();
        page.setCurrentPage( 2 );
        RegRecDao rrd = ac.getBean( RegRecDao.class );
        System.out.println( rrd.selectBestStudent( page ) );
    }
    
    @Test
    public void testAddRecommend() {
        
        RegRecDao rrd = ac.getBean( RegRecDao.class );
        Recommend recommend = new Recommend();
        recommend.setCandidateName( "周俊斌" );
        recommend.setCandidatePhone( "1" );
        recommend.setCandidatePosition( "1" );
        recommend.setRecommendName( "1" );
        recommend.setRecommendPhone( "1" );
        rrd.insertRecommend( recommend );
    }
    
    @Test
    public void testAddNewStudent() {
        
        RegRecDao rrd = ac.getBean( RegRecDao.class );
        StudentRegister sr = new StudentRegister();
        sr.setStudentName( "周" );
        System.out.println( rrd.insertStudent( sr ) );
    }
}
