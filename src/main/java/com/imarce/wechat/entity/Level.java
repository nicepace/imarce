package com.imarce.wechat.entity;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48
 * 等级类
 */
public class Level {
	/**
	 * 等级ID
	 */
	private Integer levelId;
    
    /**
     * 等级名称
     */
    private String levelName;
    /**
     * 等级图片地址
     */
    private String levelPicture;
    
    public Level() {
        // TODO Auto-generated constructor stub
    }
    
    public Level(String levelName, String levelPicture) {
        super();
        this.levelName = levelName;
        this.levelPicture = levelPicture;
    }
    
    
    public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
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
    
}
