package com.imarce.core.service;
/*
*@version 
*@author xsc
*@ time 2016年6月17日上午11:13:30
* 业务逻辑层返回值公共类
*/
public class Result {

	/**
	 * 业务逻辑层方法是否成功，1表示成功，0表示失败
	 */
	private Integer code = 0;
	/**
	 * 返回的结果信息
	 */
	private String msg;
	/**
	 * 返回的结果值
	 */
	private Object objResult;
	
	public Result(){
		
	}

	public Result(Integer code, String msg, Object objResult) {
		super();
		this.code = code;
		this.msg = msg;
		this.objResult = objResult;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObjResult() {
		return objResult;
	}

	public void setObjResult(Object objResult) {
		this.objResult = objResult;
	}
	
}
