package com.qike.corelibrary.store.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.qike.corelibrary.serurity.StoreSecurity;
import com.qike.corelibrary.store.IStore;
import com.qike.corelibrary.utils.FileUtils;
/**
 * 
 *<p>以json格式管理对象</p><br/>
 * @since 1.0.0
 * @author xky
 */
public class JsonStore implements IStore<Object>{
	private String path;
	private StoreSecurity security ;//加密方式
	
	public <V extends StoreSecurity>JsonStore(String path,V security){
		path += File.separator;
		this.path = path;
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		this.security = security;
	}
	@Override
	public void save(Object obj, String key) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		File file = new File(path+key);
		File dir = file.getParentFile();
		if(dir != null && !dir.exists()){
			dir.mkdirs();
		}
		try {
			byte[] bytes = json.getBytes("UTF-8");
			if(security != null){
				bytes = security.encrypt(bytes);
			}
			FileUtils.write(path+key, bytes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Deprecated
	@Override
	public Object load(String key) {
		return null;
	}
	public <T> T load(Class<T> clazz,String key){
		byte[] buf = FileUtils.read(path+key);
		try {
			if(security != null){
				buf = security.decrypt(buf);
			}
			String json = new String(buf,"UTF-8");
			Gson gson = new Gson();
			T fromJson = gson.fromJson(json, clazz);
			return fromJson;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(String key) {
		FileUtils.deleteFile(path+key);
	}

	
	@Override
	public void update(Object obj, String key) {
		save(obj, key);
	}
	
	@Deprecated
	@Override
	public List<Object> queryAll() {
		return null;
	}
	/**
	 * 
	 *<p>加载path目录下所有的json对象</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param clazz
	 * @return
	 */
	public <T> List<T> loadAll(Class<T> clazz){
		List<T> list = new ArrayList<T>();
		File dire = new File(path);
		File[] files = dire.listFiles();
		if(files != null){
			for (File file : files) {
				if(!file.isDirectory()){
					T t = load(clazz, file.getName());
					if(t != null){
						list.add(t);
					}
				}
			}
		}
		return list;
	}

	@Override
	public void deleteAll() {
		File dire = new File(path);
		FileUtils.deleteFile(dire);		
	}
	
	public String getPath(){
		return path;
	}
	

	@Override
	public File getStoreFile(String key) {
		String filePath = path + key;
		if (!TextUtils.isEmpty(filePath)) {
			return new File(filePath);
		}
		return null;
	}

}
