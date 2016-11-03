package com.imarce.webadmin.entity;

/**
  2016年7月5日 下午3:00:53
  @kriss
    说明：
    版本：
*/
public class Position {
   
	private Integer positionId;
	private String positionName;
	private String positionDesc;
	
	public String getPositionDesc() {
		return positionDesc;
	}
	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	
}
