package com.qike.corelibrary.net.impl;

import android.content.Context;

import com.qike.corelibrary.net.IPagerBaseCallBack;
import com.qike.corelibrary.net.domain.Pager;
/**
 * 
 *<p>带有分页的get请求</p><br/>
 * @since 1.0.0
 * @author xky
 * @param <T>
 */
public class PageGetClient<T> extends BaseGetClient<T>{
	private int mCurrentPage = 1;//当前页
	boolean mIsLoadNext = true;//是否可以加载下一页
	private Pager mPager;
	IPagerBaseCallBack<T> mPagerCallBack;
	
	public PageGetClient(String url,  Class<T> clazz,Context context) {
		super(url, clazz,context);
	}
	
	public void initParams(){
		putParams("pagenum", mCurrentPage);
	}
	/**
	 * 
	 *<p>加载第一页数据</p><br/>
	 * @since 1.0.0
	 * @author xky
	 */
	public void loadData(){
		mCurrentPage = 1;
		if(mIsLoadNext){
			mIsLoadNext = false;
			initParams();
			asyncDoApi();
		}
	}
	public void nextData(){
//		loadData();
		if(mIsLoadNext){
			mIsLoadNext = false;
			initParams();
			asyncDoApi();
		}
	}
	@Override
	public void onStart_() {
		mIsLoadNext = false;
		super.onStart_();
	}
	@Override
	public void onFinish_(boolean isSuccess, boolean isCache, T result) {
		super.onFinish_(isSuccess, isCache, result);
		mIsLoadNext = true;
		mCurrentPage++;
	}
	
	public void registPagerCallBack(IPagerBaseCallBack<T> pagerCallBack){
		this.mPagerCallBack = pagerCallBack;
	}
	

}
