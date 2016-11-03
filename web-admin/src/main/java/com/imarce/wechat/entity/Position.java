package com.imarce.wechat.entity;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48
 * 职位类
 */
public class Position {
    /**
     * 岗位ID
     */
	private Integer positionId;
	/**
     * 职位名称
     */
    private String positionName;
    
    public Position() {
        // TODO Auto-generated constructor stub
    }
    
    public Position(Integer positionId, String positionName) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
	}


	public String getPositionName() {
        
        return positionName;
    }
    
    public void setPositionName( String positionName ) {
        
        this.positionName = positionName;
    }

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
    
}
