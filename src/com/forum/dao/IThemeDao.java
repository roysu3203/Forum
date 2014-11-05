package com.forum.dao;

import java.util.List;

import com.forum.entity.Theme;

public interface IThemeDao extends IBaseDao<Theme> {

	/**
	 * 根據討論版id查詢所有文章主題
	 */
	public List<Theme> findByForumsId(Integer id);

	/**
	 * 根據討論版id查詢所有文章主題數量
	 */
	public int findByForumsIdRow(int id);

	/**
	 * 根據討論版id查詢所有文章主題, first=開始筆數, size=查詢筆數
	 */
	public List<Theme> findByForumsIdLimitFirstAndMax(int id, int first, int size);

	/**
	 * 根據討論版id與搜尋字串查詢文章主題數量
	 */
	public int searchByForumsIdRow(int id, String searchStr);

	/**
	 * 根據討論版id搜尋文章主題,一 searchStr=搜尋文字, first=開始筆數, size=查詢筆數
	 */
	public List<Theme> searchByForumsIdLimitFirstAndMax(int id, String searchStr, 
			int first, int size);

}
