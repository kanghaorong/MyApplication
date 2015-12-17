package com.qike.corelibrary.store;

import java.io.File;
import java.util.List;

/**
 * 
 *<p>最基本的存储方法</p><br/>
 * @since 1.0.0
 * @author xky
 */
public interface IStore<T> {
	/**
	 * 
	 *<p>保存obj对象到 key文件下</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param obj 存储的对象
	 * @param key 文件名称
	 */
	public void save(T obj,String key);
	/**
	 * 
	 *<p>加载对象</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param key 要加载的文件名字
	 * @return
	 */
	public T load(String key);
	/**
	 * 
	 *<p>删除文件中的对象</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param key 文件名字
	 */
	public void delete(String key);
	/**
	 * 
	 *<p>更新对象</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param obj 目标对象
	 * @param key 文件名字
	 */
	public void update(T obj,String key);
	/**
	 * 
	 *<p>查询所有的对象</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @return
	 */
	public List<T> queryAll();
	/**
	 * 
	 *<p>删除所有的对象</p><br/>
	 * @since 1.0.0
	 * @author xky
	 */
	public void deleteAll();
	/**
	 * 
	 *<p>得到文件对象</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param key
	 * @return
	 */
	public File getStoreFile(String key);
}
