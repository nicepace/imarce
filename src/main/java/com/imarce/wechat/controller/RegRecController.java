/**
 * @Title: Reg_RecController.java
 * @Package com.imarce.wechat.controller
 * @Description: TODO Copyright: Copyright (c) 2015 Company:琅琊科技
 *              
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月16日 下午3:10:40
 * @version V1.0
 */
package com.imarce.wechat.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.core.controller.BaseController;
import com.imarce.core.service.Page;
import com.imarce.core.service.Result;
import com.imarce.wechat.entity.Position;
import com.imarce.wechat.entity.Recommend;
import com.imarce.wechat.entity.StudentRegister;
import com.imarce.wechat.service.impl.RegRecService;
import com.imarce.wechat.vo.BestStudentVo;

@Controller
@RequestMapping(value = "/reg_rec")
public class RegRecController extends BaseController{
    
    @Autowired
    private RegRecService regRecService;
    /**
     * 
     * @Description: 添加一个新学员
     * @param    
     * @return   String
     * @throws
     */
    @RequestMapping("/insert_stu")
    @ResponseBody
    public Result insertStudent(String RegName, String RegQQ, String RegPhone, String RegAddress){
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setStudentName( RegName ); 
        studentRegister.setStudentQQ( RegQQ ); 
        studentRegister.setStudentPhone( RegPhone );
        studentRegister.setStudentCity( RegAddress );
        return regRecService.insertStudent(studentRegister);
            
    }
    
    /**
     * 
     * @Description: 添加一个推荐候选人
     * @param    
     * @return   String
     * @throws
     */
    @RequestMapping("/insert_rec")
    @ResponseBody
    public Result insertRecommend( String candidateName,String candidatePosition,String candidatePhone,String recommendName,String recommendPhone) {
        Recommend rec = new Recommend();
        rec.setCandidateName( candidateName );
        rec.setCandidatePosition( candidatePosition );
        rec.setCandidatePhone( candidatePhone );
        rec.setRecommendName( recommendName );
        rec.setRecommendPhone( recommendPhone );
        return regRecService.insertRecommend(rec);
        
    }
    
    /**
     * 
     * @Description: 查询已就业的优秀学员
     * @param    
     * @return   String
     * @throws
     */
    @RequestMapping("/select_beststu")
    public String selectBestStudent( Model model , int currentPage)  {
        int total = regRecService.countBestStudent();
        Page page = new Page(total,5);
        page.setCurrentPage( currentPage );
        page.setPageStart();
        Result result = regRecService.selectBestStudent(page);
        if( result.getCode() == 1 ){
        List<BestStudentVo> student = ( List<BestStudentVo> )result.getObjResult();
        model.addAttribute( "BestStudents",student );
        return "/fragment/entry_student";
        }
        else
        return "error";
    }
    
    /**
     * 
     * @Description: 返回已入职学员条数
     * @param    
     * @return   int
     * @throws
     */
    @RequestMapping("/select_countstu")
    @ResponseBody
    public int countBestStudent(){
        return regRecService.countBestStudent();
    }
    
    @RequestMapping("/select_position")
    public String selectPosition(Model model){
        List<Position> positions = (List<Position>)regRecService.selectPosition().getObjResult();
        model.addAttribute( "Positions", positions );
        return "/fragment/positionPop";
    }

    
}
