package com.forum.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T extends Serializable> {

	/**
	 * 儲存
	 */
	public Integer save(T object);

	/**
	 * 新增或修改
	 */
	public void saveOrUpdate(T object);

	/**
	 * 刪除
	 */
	public void delete(T object);

	/**
	 * 查詢全部，回傳陣列
	 */
	public List<T> findAll();

	/**
	 * 根據id查詢，回傳Entity
	 */
	public T findById(Integer id);

}
