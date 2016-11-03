package com.imarce.webadmin.util;

/**
  2016年7月5日 下午3:53:59
  @kriss
    说明：aaaaaa
    版本：
*/
public class Pager {
 
	private int page = 1 ;
	
	private int rows = 10;
	
	private boolean isQueryAll=false;
	
	
	public boolean getIsQueryAll() {
		return isQueryAll;
	}

	public void setIsQueryAll(boolean isQueryAll) {
		this.isQueryAll = isQueryAll;
	}

	public int getStart(){
		
		return (page-1)*rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
}
