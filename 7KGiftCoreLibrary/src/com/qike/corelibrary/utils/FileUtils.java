package com.qike.corelibrary.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * 
 *<p>关于文件的一些操作方法</p><br/>
 * @since 1.0.0
 * @author xky
 */
public class FileUtils {
	/**
	 * 
	 *<p>将path目录下的文件写到字节数组中</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param path 
	 * @param bytes 目标
	 */
	public static void write(String path,byte[]bytes){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			fos.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(fos != null){
						try {
							fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	/**
	 * 
	 *<p>读取path文件下的数据到字节数组里</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param path
	 * @return
	 */
	public static byte[] read(String path){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buff = new byte[1024*10];
			int len = 0;
			while((len =fis.read(buff))!=-1){
				baos.write(buff, 0, len);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 *<p>删除指定的文件</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param file
	 */
	public static void deleteFile(File file) {
		try {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				if (files != null) {
					for (int i = 0; i < files.length; i++) {
						deleteFile(files[i]);
					}
				}
			}
			file.delete();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	/**
	 * 
	 *<p>存储对象</p><br/>
	 *该类必须序列化
	 * @since 1.0.0
	 * @author xky
	 * @param obj
	 * @param path
	 */
	public static void writeObject(Object obj,String path){
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(oos != null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 
	 *<p>读取对象</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param path
	 * @return
	 */
	
	public static <T extends Serializable> T readObject(String path){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			return (T) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(ois != null){
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 
	 *<p>检查文件是否存在</p><br/>
	 *如果文件不存在则创建
	 * @since 1.0.0
	 * @author xky
	 * @param path
	 */
	public static void checkAndMakeDirs(String path){
		File file = new File(path);
		if(!file.exists()){
			file.getParentFile().mkdirs();
		}
	}
	/**
	 * 
	 *<p>删除指定的文件</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param path
	 */
	public static void deleteFile(String path){
		File file = new File(path);
		if(file.exists()){
			file.delete();
		}
	}
	
	/**
	 * 获取屏幕density属性的等级 包括:low, mid, high, x
	 * 1.5为中间
	 */
	public static float getDensity(Context context) {
		WindowManager mWindowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
		DisplayMetrics mDisplayMetrics = new DisplayMetrics();
		mWindowManager.getDefaultDisplay().getMetrics(mDisplayMetrics);
		return mDisplayMetrics.density;
	}
	/**
	 * 
	 *<p>获取屏幕的宽和高</p><br/>
	 * @since 5.0.0
	 * @author xky
	 * @param activity
	 * @return int[]  int[0]=widht;int[1]=height
	 */
	public static  int[] getScreenWidthAndHeight(Activity activity){
		Display display = activity.getWindowManager().getDefaultDisplay();
		int[] wh ={display.getWidth(),display.getHeight()};
		return wh;
	}
}
