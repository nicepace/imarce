package com.imarce.webadmin.entity;

import java.util.Date;

import com.imarce.core.utils.DateUtils;

/**
 * 
 * 2016年7月5日 下午6:39:15 
 * @author shadow 
 * 说明：意见表的实体类
 *
 */
public class Opinions {
	private Integer opinionId;
	private String opinion;
	private Integer userId;
	private Date releaseTime;

	// 意见概要
	private String brief = null;

	// 发布时间字符串
	private String releaseTimeStr;

	public Integer getOpinionId() {
		return opinionId;
	}

	public void setOpinionId(Integer opinionId) {
		this.opinionId = opinionId;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	/**
	 * 根据意见内容长度截取意见内容
	 * 
	 * @return String
	 */

	  public String getBrief(){ 
		  if(opinion!=null){
			  brief = opinion; 
			  if(opinion.length()>15){ 
				  brief = brief.substring(0, 15)+"......";
			  } 
		  }
		  return brief; 
	  }
 
	/**
	 * 根据意见内容长度截取意见内容，并过滤非法字符
	 * (springMVC已经处理，使用struts2时需手动过滤)
	 * @return String
	 */
/*	public String getBrief() {
		if(opinion!=null){
			brief = opinion;
			if (opinion.length() > 15) {
				brief = brief.substring(0, 15);
			}
			StringBuffer briefStr = new StringBuffer(brief);
			brief = "";		
			for (int i = 0; i < briefStr.length(); i++) {

				char c = briefStr.charAt(i);
				switch (c) {
					case ' ':
						brief = brief + "&nbsp;";
						break;
					case '>':
						brief = brief + "&gt;";
						break;
					case '<':
						brief = brief + "&lt;";
						break;
					case '\"':
						brief = brief + "&quot;";
						break;
					case '\\':
						brief = brief + "\\\\";
						break;
					case '/':
						brief = brief + "\\/";
						break;
					case '\b':
						brief = brief + "\\b";
						break;
					case '\f':
						brief = brief + "\\f";
						break;
					case '\n':
						brief = brief + "\\n";
						break;
					case '\r':
						brief = brief + "\\r";
						break;
					case '\t':
						brief = brief + "\\t";
						break;
					default:
						brief = brief + c;
						break;
				}
			}
			if(opinion.length()>15){
				brief = brief+"......";
			}
		}		
		return brief;
	}
*/
	/**
	 * 将Date格式的时间按需求格式化
	 * 
	 * @return String
	 */
	public String getReleaseTimeStr() {
		if (this.releaseTime != null) {
			releaseTimeStr = DateUtils.formatDate(releaseTime, "yyyy-MM-dd HH:mm:ss");
			return releaseTimeStr;
		} else
			return "";
	}
}
