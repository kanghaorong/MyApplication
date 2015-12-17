package com.qike.corelibrary.database.impl;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.qike.corelibrary.database.DataBaseOpenHelpr;
import com.qike.corelibrary.database.IDataBaseProvider;
/**
 * 
 *<p>数据库操作类</p><br/>
 * @since 1.0.0
 * @author xky
 */
public class DataBaseProviderimpl implements IDataBaseProvider{
	private DataBaseOpenHelpr helper;

	public DataBaseProviderimpl(String dbPath) {
		init(dbPath);
	}
	
	@Override
	public <T, Id> void save(T data) {
		try {
			if (data != null) {
				Dao<T, Id> dao = (Dao<T, Id>) helper.getDao(data.getClass());
				dao.createOrUpdate(data);
//				close();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}     
	}

	@Override
	public <T, Id> void delete(T data) {
		try {
			if (data != null) {
				@SuppressWarnings("unchecked")
				Dao<T, Id> dao = (Dao<T, Id>) helper.getDao(data.getClass());
				dao.delete(data);
//				close();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
//
//	public <T, Id> void deleteAll(T data){
//		try {
//			if (data != null) {
//				@SuppressWarnings("unchecked")
//				Dao<T, Id> dao = (Dao<T, Id>) helper.getDao(data.getClass());
//				
//			}
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//	}
	
	
	@Override
	public <T, Id> void update(T data) {
		try {
			if (data != null) {
				Dao<T, Id> dao = (Dao<T, Id>) helper.getDao(data.getClass());
				dao.update(data);
//				close();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T, Id> List<T> queryAll(Class<T> clazz) {
		try {
			Dao<T, Id> dao = (Dao<T, Id>) helper.getDao(clazz);
			List<T> items = dao.queryForAll();
//			close();
			return items;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close() {
		try {
			helper.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T, Id> T query(Class<T> clazz, Id key) {
		try {
			Dao<T, Id> dao = (Dao<T, Id>) helper.getDao(clazz);
			T item = dao.queryForId(key);
//			close();
			return item;
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void init(String databasepath) {
		helper = new DataBaseOpenHelpr(databasepath);
	}
	@Override
	public <T, ID> List<T> queryForEq(Class<T> clazz, String arg0, Object arg1) {
		try {
			Dao<T, ID> dao = (Dao<T, ID>) helper.getDao(clazz);
			List<T> list = dao.queryForEq(arg0, arg1);
//			close();
			return list;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return new ArrayList<T>();
	};

	public <T, ID> QueryBuilder<T, ID> queryBuilder(Class<T> clazz) {
		try {
			Dao<T, ID> dao = (Dao<T, ID>) helper.getDao(clazz);
			return dao.queryBuilder();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

}
