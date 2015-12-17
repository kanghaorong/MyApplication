package com.qike.corelibrary.net.domain;

import com.qike.corelibrary.serurity.StoreSecurity;

/**
 * 
 *<p>请求数据</p><br/>
 * @since 1.0.0
 * @author xky
 */
public class RequestEntry {
	/**是否需要缓存*/
	private boolean isCache;
	/**是否需要解密*/
	private boolean isDecode;
	/**json存储的跟目录*/
	private String jsonBasePath;
	/**存储json是否需要加密*/
	private StoreSecurity sec;
	/**设置过期时间[持久化存储]*/
	private long ttl;
	
	
	public long getTtl() {
		return ttl;
	}
	public void setTtl(long ttl) {
		this.ttl = ttl+System.currentTimeMillis();
	}
	public String getJsonBasePath() {
		return jsonBasePath;
	}
	public void setJsonBasePath(String jsonBasePath) {
		this.jsonBasePath = jsonBasePath;
	}
	public StoreSecurity getSec() {
		return sec;
	}
	public void setSec(StoreSecurity sec) {
		this.sec = sec;
	}
	public boolean isCache() {
		return isCache;
	}
	public void setCache(boolean isCache) {
		this.isCache = isCache;
	}
	public boolean isDecode() {
		return isDecode;
	}
	public void setDecode(boolean isDecode) {
		this.isDecode = isDecode;
	}

	/**
	 * 
	 *<p>是否过期</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @return false :没有过期 ，true:过期
	 */
	public boolean isTTL(){
		return ttl<System.currentTimeMillis();
	}
	
	
}
