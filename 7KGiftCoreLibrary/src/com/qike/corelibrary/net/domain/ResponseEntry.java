package com.qike.corelibrary.net.domain;

public class ResponseEntry<T> {
	private int code;
	private Pager page;
	private T result;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Pager getPage() {
		return page;
	}
	public void setPage(Pager page) {
		this.page = page;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	
	
}

