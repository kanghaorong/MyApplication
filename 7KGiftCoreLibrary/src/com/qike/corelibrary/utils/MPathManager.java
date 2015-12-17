package com.qike.corelibrary.utils;

import java.io.File;

import com.qike.corelibrary.utils.FileUtils;
import com.qike.corelibrary.utils.SDCardUtils;
import com.qike.corelibrary.utils.SDCardUtils.StorageDriectory;

import android.content.Context;

/**
 * 
 *<p>管理一些路径【缓存路径】</p><br/>
 * @since 1.0.0
 * @author xky
 */
public class MPathManager {
	private static final  String PathSuffx = "/7kGetGiftbackup";
	/**
	 * 
	 *<p>获取json的缓存路径</p><br/>
	 *优先使用sd卡路径来缓存 
	 *如果sd卡不存在 在使用 cache路径来缓存
	 * @since 1.0.0
	 * @author xky
	 */
	public static String getBaseJsonPath(Context context){
		String BasePath = "";
		if(SDCardUtils.existSDcard(context)){
			StorageDriectory directory = SDCardUtils.getInnerStorageDirectory(context, true);
			BasePath = directory.getPath()+PathSuffx;
//			FileUtils.checkAndMakeDirs(BasePath);
		}else{
			String absolutePath = context.getCacheDir().getAbsolutePath();
			BasePath = absolutePath+PathSuffx;
		}
		return BasePath;
	}
	
	
	public static String getJsonCacheFile( Context context){
		
		String cachePath;
		if( SDCardUtils.existSDcard(context)){
			cachePath = context.getExternalFilesDir("json").getAbsolutePath();
		}else{
			cachePath = context.getCacheDir().getAbsolutePath();
		}
		return cachePath;
	}
	
	
}