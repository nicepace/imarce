package com.imarce.webadmin.entity;

import java.util.Date;

import com.imarce.core.utils.DateUtils;

public class Recommend {

	private int recommendId;
	private String candidateName;
	private String candidatePosition;
	private String candidatePhone;
	private String recommendName;
	private String recommendPhone;
	private int userId;
	private Date releaseTime;
	private String releaseTimeStr;
	
	public String getReleaseTimeStr() {
		if(this.releaseTime!=null){
			releaseTimeStr=DateUtils.formatDate(releaseTime,"yyyy-MM-dd HH:mm");
			return releaseTimeStr;
		}else{
			return "";
		}
		
	}
	public int getRecommendId() {
		return recommendId;
	}
	public void setRecommendId(int recommendId) {
		this.recommendId = recommendId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCandidatePosition() {
		return candidatePosition;
	}
	public void setCandidatePosition(String candidatePosition) {
		this.candidatePosition = candidatePosition;
	}
	public String getCandidatePhone() {
		return candidatePhone;
	}
	public void setCandidatePhone(String candidatePhone) {
		this.candidatePhone = candidatePhone;
	}
	public String getRecommendName() {
		return recommendName;
	}
	public void setRecommendName(String recommendName) {
		this.recommendName = recommendName;
	}
	public String getRecommendPhone() {
		return recommendPhone;
	}
	public void setRecommendPhone(String recommendPhone) {
		this.recommendPhone = recommendPhone;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	
}
