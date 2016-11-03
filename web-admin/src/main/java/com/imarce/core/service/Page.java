package com.imarce.core.service;
/*
* @ version:1.0
* @ 作者 ：zjf
* @ 时间：2016年6月18日下午3:49:19
*/
public class Page {
	/**
	 * 总记录数
	 */
	private int total;
	/**
	 * 总页码
	 */
	private int totalPage;
	/**
	 *  每页显示的行数,默认是5行
	 */
	private int pageNum =5;
	
	/**
	 * 当前的页码，默认第一页
	 */
	private int currentPage=1;
	
	/**
	 * 起始的行数
	 */
	private int pageStart;
	
	/**
	 * 结束的行数
	 */
	private int pageEnd;
	public Page() {
		// TODO Auto-generated constructor stub
	}
	public Page(int pageNum){
		super();
		this.pageNum = pageNum;
	}
	public Page(int total, int pageNum) {
		super();
		this.total = total;
		this.pageNum = pageNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		if(total%pageNum==0){
			this.totalPage = total/pageNum;
		}else{
			this.totalPage = total/pageNum+1;
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageStart() {
		setPageStart();
		return pageStart;
	}
	public void setPageStart() {
		this.pageStart = (currentPage-1)*pageNum;
	}
	public int getPageEnd() {
		setPageEnd();
		return pageEnd;
	}
	public void setPageEnd() {
		this.pageEnd = currentPage*pageNum;
	}
	
}
