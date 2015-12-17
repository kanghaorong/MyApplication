package com.qike.corelibrary.store.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.text.TextUtils;

import com.qike.corelibrary.serurity.StoreSecurity;
import com.qike.corelibrary.store.IStore;
import com.qike.corelibrary.utils.FileUtils;
/**
 * 
 *<p>对对象进行存储</p><br/>
 * @since 1.0.0
 * @author xky
 */
public class SerializeStore implements IStore<Serializable> {
	private String path ;
	private StoreSecurity sec;
	public <V extends StoreSecurity>SerializeStore(String path,V sec) {
		path += File.separator;
		this.path = path;
		File file = new File(this.path);
		if(!file.exists()){
			file.mkdirs();
		}
		this.sec = sec;
	}
	
	@Override
	public void save(Serializable obj, String key) {
		try {
			ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(byteOs);
			oos.writeObject(obj);
			oos.close();
			byte[] buff = byteOs.toByteArray();
			if(sec != null){
				buff =  sec.encrypt(buff);
			}
			File file = new File(path+key);
			File dir = file.getParentFile();
			if(dir!=null && !dir.exists()){
				dir.mkdirs();
			}
			FileUtils.write(path+key, buff);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Serializable load(String key) {
		byte[] buff = FileUtils.read(path+key);
		ObjectInputStream ois = null;
		try {
			if(sec != null){
				buff = sec.decrypt(buff);
			}
			ByteArrayInputStream bis = new ByteArrayInputStream(buff);
			ois = new ObjectInputStream(bis);
			return (Serializable) ois.readObject();
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
	public void update(Serializable obj, String key) {
		save(obj, key);
	}

	@Override
	public List<Serializable> queryAll() {
		List<Serializable> list = new ArrayList<Serializable>();

		File dire = new File(path);
		File[] files = dire.listFiles();
		for (File file : files) {
			Serializable t = load(file.getName());
			list.add(t);
		}
		return list;
	}

	@Override
	public void deleteAll() {
		File dire = new File(path);
		FileUtils.deleteFile(dire);
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
