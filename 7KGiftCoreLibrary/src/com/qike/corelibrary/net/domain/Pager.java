package com.qike.corelibrary.net.domain;
/**
 * 
 *<p>用于分页数据</p><br/>
 * @since 1.0.0
 * @author xky
 */
public class Pager {
	/**每页多少条数据*/
	private int pageSize;
	/**当前页*/
	private int currentPage;
	/**总共多少页*/
	private int totalPage;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
