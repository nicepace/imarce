package com.imarce.wechat.entity;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48 
 * 技能模块类
 */
public class Skillmodule {
    
    /**
     * 技能模块ID
     */
    private String skillmodule;
    /**
     * 技能模块名称
     */
    private String skillmoduleName;
    
    public Skillmodule() {
        // TODO Auto-generated constructor stub
    }
    
    public Skillmodule(String skillmoduleName) {
        super();
        this.skillmoduleName = skillmoduleName;
    }
    
    public String getSkillmodule() {
        
        return skillmodule;
    }
    
    public void setSkillmodule( String skillmodule ) {
        
        this.skillmodule = skillmodule;
    }
    
    public String getSkillmoduleName() {
        
        return skillmoduleName;
    }
    
    public void setSkillmoduleName( String skillmoduleName ) {
        
        this.skillmoduleName = skillmoduleName;
    }
    
}
