package com.qike.corelibrary.log;

import android.util.Log;
/**
 * 
 *<p>log管理器</p><br/>
 * @since 1.0.0
 * @author xky
 */
public class LogManager {
	private static LogManager INSTANCE = null;
	private boolean isDebug = false;
	private LogManager(){};
	public static LogManager getInstance(){
		if(INSTANCE == null){
			INSTANCE = new LogManager();
		}
		return INSTANCE;
	}
	
	public void setDebug(boolean isDebug){
		this.isDebug = isDebug;
	}
	/**
	 * 
	 *<p>打印log</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param leve Leve.[I,D,E,V,W] 不同的状态
	 * @param tag
	 * @param msg
	 */
	public void showLog(Leve leve,String tag,String msg){
		if(!isDebug){
			return;
		}
		switch (leve) {
		case I:
			Log.i(tag, msg);
			break;
		case D:
			Log.d(tag, msg);
			break;
		case E:
			Log.e(tag, msg);
			break;
		case V:
			Log.v(tag, msg);
			break;
		case W:
			Log.w(tag, msg);
			break;

		default:
			break;
		}
		
	}
	/**
	 * 
	 *<p>打印log</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param leve Leve.[I,D,E,V,W] 不同的状态
	 * @param Class  某个类的字节码对象，tag为该类名
	 * @param msg
	 */
	public void showLog(Leve leve,Class clazz,String msg){
		if(!isDebug){
			return;
		}
		String tag = "tag";
		if(clazz != null){
			 tag = clazz.getSimpleName();
		}
		switch (leve) {
		case I:
			Log.i(tag, msg);
			break;
		case D:
			Log.d(tag, msg);
			break;
		case E:
			Log.e(tag, msg);
			break;
		case V:
			Log.v(tag, msg);
			break;
		case W:
			Log.w(tag, msg);
			break;
			
		default:
			break;
		}
		
	}
	
	public enum Leve{
		I,D,E,V,W
	}
	
}
