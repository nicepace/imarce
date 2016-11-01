/**
 * @Title: TestRegRecService.java
 * @Package com.imarce.service
 * @Description: TODO
 * Copyright: Copyright (c) 2015
 * Company:琅琊科技
 *
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月22日 下午5:58:31
 * @version V1.0
 */
package com.imarce.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.imarce.core.service.Page;
import com.imarce.core.service.Result;
import com.imarce.wechat.entity.Recommend;
import com.imarce.wechat.entity.StudentRegister;
import com.imarce.wechat.service.impl.RegRecService;

/**
 * @ClassName: TestRegRecService
 * @Description: TODO
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月22日 下午5:58:31
 *
 */
public class TestRegRecService {

    ApplicationContext ac = null;
    
    @Before
    public void init() {
        
        ac = new ClassPathXmlApplicationContext( "spring*.xml" );
    }
    
    @Test
    public void testSelectBest() {
        Page page = new Page(10,5);
        page.setCurrentPage( 1 );
        page.setPageStart();
        RegRecService rrs = ac.getBean( RegRecService.class );
        Result result = rrs.selectBestStudent(page);
        System.out.println( result.getCode() );
        System.out.println( result.getMsg() );
        System.out.println( result.getObjResult() );
    }
    
    @Test
    public void testAddNewStudent() {
        RegRecService rrs = ac.getBean( RegRecService.class );
        StudentRegister sr= new StudentRegister();
        sr.setStudentName( "" );
        sr.setStudentCity( "" );
        sr.setStudentPhone( "" );
        sr.setStudentQQ( "" );
        Result result = rrs.insertStudent( sr );
        System.out.println( result.getCode() );
        System.out.println( result.getMsg() );
    }
    
    @Test
    public void testAddRecommend() {
        RegRecService rrs = ac.getBean( RegRecService.class );
        Recommend rc= new Recommend();
        rc.setCandidateName( "" );
        rc.setCandidatePhone( "" );
        rc.setCandidatePosition( "" );
        rc.setRecommendName( "" );
        rc.setRecommendPhone( "" );
        Result result = rrs.insertRecommend( rc );
        System.out.println( result.getCode() );
        System.out.println( result.getMsg() );
    }
    

}
