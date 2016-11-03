/**
 * @Title: Reg_RecService.java
 * @Package com.imarce.wechat.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2015
 * Company:琅琊科技
 *
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月16日 下午2:57:19
 * @version V1.0
 */
package com.imarce.webadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imarce.core.service.BaseService;
import com.imarce.core.service.Page;
import com.imarce.core.service.Result;
import com.imarce.core.utils.Validation;
import com.imarce.webadmin.dao.RegRecDao;
import com.imarce.wechat.entity.Recommend;
import com.imarce.wechat.entity.StudentRegister;

@Service("RegRecService")
@Transactional
public class RegRecService extends BaseService{
    @Autowired
    private RegRecDao regRecDao;
    /**
     * 
     * @Description: 注册成为i码士
     * @param    
     * @return   Result
     * @throws
     */
    public Result insertStudent(StudentRegister studentRegister){
        Result result = new Result();
        if(Validation.StrNotNull( studentRegister.getStudentName() ) || Validation.StrNotNull( studentRegister.getStudentPhone() )){
            if(Validation.isChinese( studentRegister.getStudentName() )){
                if(Validation.isMobile( studentRegister.getStudentPhone()) || Validation.isPhone( studentRegister.getStudentPhone())){
                    if(Validation.StrNotNull( studentRegister.getStudentQQ() )){
                        if(Validation.isQQ( studentRegister.getStudentQQ() )){
                            
                        }
                        else{
                            result.setCode( 0 );
                            result.setMsg( "QQ号填写有误" );
                            return result;
                        }
                    }
                    if (Validation.StrNotNull( studentRegister.getStudentCity() )){
                        if(Validation.isCity( studentRegister.getStudentCity() )){
                            
                        }
                        else{
                            result.setCode( 0 );
                            result.setMsg( "城市不能为中文以外字符" );
                            return result;
                        }
                    }
                    if (regRecDao.insertStudent(studentRegister)>=1){
                        result.setCode( 1 );
                        result.setMsg( "您已成功注册，成为i码士</br>我们将尽快与您联系" );
                        return result;
                    }
                    else{
                        result.setCode( 0 );
                        result.setMsg( "数据库写入错误" );
                        return result;  
                    }
                }else{
                    result.setCode( 0 );
                    result.setMsg( "手机号码格式有误" );
                    return result; 
                }    
            }else{
                result.setCode( 0 );
                result.setMsg( "姓名不能为中文以外字符" );
                return result;
            }    
        }else{
            result.setCode( 0 );
            result.setMsg( "姓名和手机不能为空" );
            return result;
        }       
    }
    
    /**
     * 
     * @Description: 推荐候选人
     * @param    
     * @return   Result
     * @throws
     */
    public Result insertRecommend(Recommend recommend){
        Result result = new Result();
        if(Validation.StrNotNull( recommend.getCandidateName() ) && Validation.StrNotNull( recommend.getCandidatePhone() ) 
                && Validation.StrNotNull( recommend.getCandidatePosition() ) && Validation.StrNotNull( recommend.getRecommendName() )
                && Validation.StrNotNull( recommend.getRecommendPhone() )){
            if(Validation.isChinese( recommend.getCandidateName() ) && Validation.isChinese( recommend.getCandidatePosition() ) 
                    && Validation.isChinese( recommend.getRecommendName() )){
                
            }
            else if(!Validation.isChinese( recommend.getCandidateName() )){
                result.setCode( 0 );
                result.setMsg( "候选人姓名必须是中文" );
                return result;
            }
            /*else if(!Validation.( recommend.getCandidatePosition() )){
                result.setCode( 0 );
                result.setMsg( "候选人岗位不能包含特殊字符" );
                return result;
            }*/
            else if(!Validation.isChinese( recommend.getRecommendName())){
                result.setCode( 0 );
                result.setMsg( "推荐人姓名必须是中文" );
                return result;
            }
            
            if(Validation.isMobile( recommend.getCandidatePhone() ) && Validation.isMobile( recommend.getRecommendPhone())){
                if (regRecDao.insertRecommend(recommend)>=1){
                    result.setCode( 1 );
                    result.setMsg( "您已成功推荐了候选人\n十分感谢您对i码士的支持" );
                    return result; 
                }
                else{
                    result.setCode( 0 );
                    result.setMsg( "数据库写入发生错误" );
                    return result;
                }
            }else if(Validation.isPhone( recommend.getCandidatePhone() ) && Validation.isPhone( recommend.getRecommendPhone())){
                if (regRecDao.insertRecommend(recommend)>=1){
                    result.setCode( 1 );
                    result.setMsg( "您已成功推荐了候选人\n十分感谢您对i码士的支持" );
                    return result; 
                }
                else{
                    result.setCode( 0 );
                    result.setMsg( "数据库写入发生错误" );
                    return result;
                }
            }else{
                result.setCode( 0 );
                result.setMsg( "候选人或推荐人手机电话格式有误" );
                return result;
            }
        }
        else{
            result.setCode( 0 );
            result.setMsg( "此页信息均为必填，不能为空" );
            return result;
        }
    }
    
    /**
     * 
     * @Description: 查询已经就业的优秀学员
     * @param    
     * @return   Result
     * @throws
     */
    public Result selectBestStudent(Page page){
        Result result = new Result();
        result.setCode( 1 );
        result.setObjResult( regRecDao.selectBestStudent(page) );
        return result;
    }
    
    /**
     * 
     * @Description: 查询所有已入职的学员数
     * @param    
     * @return   int
     * @throws
     */
    public int countBestStudent (){
        return regRecDao.countBestStudent();
    }
    
    public Result selectPosition(){
        Result result = new Result();
        result.setObjResult( regRecDao.selectPosition() );
        return result;
    }
}
