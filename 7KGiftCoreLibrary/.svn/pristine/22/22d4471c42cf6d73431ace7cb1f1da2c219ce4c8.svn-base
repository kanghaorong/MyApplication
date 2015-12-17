package com.qike.corelibrary.database;

import java.util.List;

/**
 * 
 *<p>数据库基本操作类</p><br/>
 *<p>提供数据库的增删改查方法</p>
 * @since 1.0.0
 * @author xky
 */
public interface IDataBaseProvider {
	/**
	 * 
	 *<p>存储数据对象到数据库</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param data 要存储的数据对象
	 */
	public <T,Id>void save(T data);
	/**
	 * 
	 *<p>删除数据对象</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param data 要从数据库中删除的数据对象
	 */
	public <T,Id>void delete(T data);
	/**
	 * 
	 *<p>更新数据表</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param data 需要更新的数据类型对象
	 */
	public <T,Id>void update(T data);
	/**
	 * 
	 *<p>查询某个表中所有的数据对象</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param clazz　需要查询对象的类型
	 * @return　该对象的集合，如果没有则为null
	 */
	public <T,Id> List<T> queryAll(Class<T> clazz);
	/**
	 * 
	 *<p>关闭资源</p><br/>
	 * @since 1.0.0
	 * @author xky
	 */
	public void close();
	/**
	 * 
	 *<p>根据主键查询对应数据对象</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param clazz
	 * @param key 主键
	 * @return
	 */
	public <T,Id> T query(Class<T> clazz,Id key);
	/**
	 * 
	 *<p>初始化数据库</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param databasepath 数据库路径
	 */
	public void init(String databasepath);
	
	public <T, ID> List<T>  queryForEq(Class<T> clazz, String arg0, Object arg1);
	
}
