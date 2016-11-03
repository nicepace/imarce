/**
 * @Title: BestStudentVo.java
 * @Package com.imarce.wechat.vo
 * @Description: TODO
 * Copyright: Copyright (c) 2015
 * Company:琅琊科技
 *
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月21日 上午11:44:06
 * @version V1.0
 */
package com.imarce.wechat.vo;


/**
 * @ClassName: BestStudentVo
 * @Description: 已入职的优秀学员对象
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月21日 上午11:44:06
 *
 */
public class BestStudentVo {
    /**
     * 头像照片地址
     */
    private String headPicture;
    /**
     * 学员姓名
     */
    private String studentName;
    /**
     * 职位名称
     */
    private String positionName;
    /**
     * 入职公司
     */
    private String employed;
    /**
     * 薪资
     */
    private String salary;
    /**
     * 等级ID
     */
    private String levelId;
    /**
     * 等级名称
     */
    private String levelName;
    /**
     * 等级图片地址
     */
    private String levelPicture;
    
    public String getHeadPicture() {
        
        return headPicture;
    }
    
    public void setHeadPicture( String headPicture ) {
        
        this.headPicture = headPicture;
    }
    
    public String getStudentName() {
        
        return studentName;
    }
    
    public void setStudentName( String studentName ) {
        
        this.studentName = studentName;
    }
    
    public String getPositionName() {
        
        return positionName;
    }
    
    public void setPositionName( String positionName ) {
        
        this.positionName = positionName;
    }
    
    public String getEmployed() {
        
        return employed;
    }
    
    public void setEmployed( String employed ) {
        
        this.employed = employed;
    }
    
    public String getSalary() {
        
        return salary;
    }
    
    public void setSalary( String salary ) {
        
        this.salary = salary;
    }
    public String getLevelId() {
        
        return levelId;
    }

    
    public void setLevelId( String levelId ) {
        
        this.levelId = levelId;
    }
    
    public String getLevelName() {
        
        return levelName;
    }
    
    public void setLevelName( String levelName ) {
        
        this.levelName = levelName;
    }
    
    public String getLevelPicture() {
        
        return levelPicture;
    }
    
    public void setLevelPicture( String levelPicture ) {
        
        this.levelPicture = levelPicture;
    }


    @Override
    public String toString() {
        
        return "BestStudentVo [headPicture=" + headPicture + ", studentName=" + studentName + ", positionName=" + positionName + ", employed="
                + employed + ", salary=" + salary + ", levelId=" + levelId + ", levelName=" + levelName + ", levelPicture=" + levelPicture + "]";
    }


}
