package com.qike.corelibrary.net;

import com.qike.corelibrary.net.domain.Pager;
/**
 * 
 *<p>TODO(类的概括性描述)</p><br/>
 * @since 1.0.0
 * @author xky
 * @param <T>
 */
public interface IBaseCallBack<T> {
	/**
	 * 
	 *<p>开始请求</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 */
	public void onStart();
	/**
	 * 
	 *<p>请求成功</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param successCode
	 */
	public void onSuccess(int successCode);
	/**
	 * 
	 *<p>请求失败</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param errorCode
	 */
	public void onFailed(int errorCode, boolean isCache);
	/**
	 * 
	 *<p>获取数据成功</p><br/>
	 *分为两种情况，一种是获取缓存数据成功 一种是获取网络数据成功
	 * @since 1.0.0
	 * @author xky
	 * @param isSuccess
	 * @param isCache
	 * @param result
	 */
	public void onFinish(boolean isSuccess,boolean isCache,T result);
}
