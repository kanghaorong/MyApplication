package com.qike.corelibrary.net.impl;

import android.content.Context;

import com.qike.corelibrary.net.AClient;
import com.qike.corelibrary.net.ICacheManager;
import com.qike.corelibrary.net.domain.NetConstants;
import com.qike.corelibrary.net.domain.RequestEntry;
import com.qike.corelibrary.utils.MPathManager;

public  class AbstractGetClient<T> extends AClient<T> implements ICacheManager{
	private RequestEntry mCacheEntry;
	private RequestEntry mRequestEntry;
	
	public AbstractGetClient(String url, Class<T> clazz,Context context) {
		super(url, clazz,context);
		putCommonParams();
	}
	
	/**
	 * 
	 *<p>上传通用参数</p><br/>
	 * @since 1.0.0
	 * @author xky
	 */
	private void putCommonParams() {
//		putParams(key, value);
//		putParams("token", "8c7bedc91ca7cf063816d2db98f78030");
	}

	@Override
	public int getRequetMethod() {
		return NetConstants.HTTPGET;
	}

	@Override
	public RequestEntry getCacheEntry() {
		mCacheEntry = initEntry();
		return mCacheEntry;
	}
	/**
	 * 
	 *<p>初始化实体</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @return
	 */
	private RequestEntry initEntry() {
		mRequestEntry = new RequestEntry();
		mRequestEntry.setCache(true);
		mRequestEntry.setSec(null);
		mRequestEntry.setDecode(false);
		mRequestEntry.setJsonBasePath(MPathManager.getJsonCacheFile(mContext));
		return mRequestEntry;
	}
	
	/**
	 * 
	 *<p>设置不使用缓存</p><br/>
	 * @since 1.0.0
	 * @author xky
	 */
	@Override
	public void setNoCache(){
		if(mRequestEntry != null){
			mRequestEntry.setCache(false);
		}
	}

	@Override
	public void setCache() {
		if(mRequestEntry != null){
			mRequestEntry.setCache(true);
		}
	}

	@Override
	public void setTTL(long ttl) {
		if(mRequestEntry != null){
			mRequestEntry.setTtl(ttl);
		}
	}

}
