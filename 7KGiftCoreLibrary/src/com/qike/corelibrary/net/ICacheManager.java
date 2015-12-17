package com.qike.corelibrary.net;
/**
 * 
 *<p>缓存操作借口</p><br/>
 * @since 1.0.0
 * @author xky
 */
public interface ICacheManager {
	/**
	 * 
	 *<p>设置不使用缓存</p><br/>
	 * @since 1.0.0
	 * @author xky
	 */
	public void setNoCache();
	/**
	 * 
	 *<p>设置使用缓存</p><br/>
	 * @since 1.0.0
	 * @author xky
	 */
	public void setCache();

	/**
	 * 
	 *<p>设置缓存过期时间</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param ttl
	 */
	public void setTTL(long ttl);
}
