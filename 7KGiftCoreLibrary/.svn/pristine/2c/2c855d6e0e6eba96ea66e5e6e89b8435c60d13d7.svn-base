package com.qike.corelibrary.net.impl;

import android.content.Context;

import com.qike.corelibrary.net.AClient;
import com.qike.corelibrary.net.ICacheManager;
import com.qike.corelibrary.net.domain.NetConstants;
import com.qike.corelibrary.net.domain.RequestEntry;
import com.qike.corelibrary.utils.MPathManager;
/**
 * 
 *<p>post请求 暂时不做</p><br/>
 * @since 1.0.0
 * @author xky
 * @param <T>
 */
public class AbstractPostClient<T> extends AClient<T> implements ICacheManager{

	private RequestEntry mRequestEntry;
	public AbstractPostClient(String url, Class<T> clazz,Context context) {
		super(url, clazz,context);
	}

	@Override
	public int getRequetMethod() {
		return NetConstants.HTTPPOST;
	}

	@Override
	public RequestEntry getCacheEntry() {
		initEntry();
		return mRequestEntry;
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
		mRequestEntry.setJsonBasePath(MPathManager.getBaseJsonPath(mContext));
		return mRequestEntry;
	}

	@Override
	public void setNoCache() {
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
