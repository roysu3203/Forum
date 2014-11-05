package com.forum.service;

import java.util.List;

import com.forum.entity.Theme;

public interface IThemeService {
	
	public Integer save(Theme theme);
	
	public void saveOrUpdate(Theme theme);
	
	public void delete(Theme theme);
	
	public List<Theme> getAllTheme();
	
	public Theme getThemeById(Integer id);
	
	/** 根據討論版id取得該討論版下所有文章主題 */
	public List<Theme> getThemeListByForumsId(Integer id);
	
	/**
	 * 根據討論版id取得文章主題總數
	 */
	public int getThemeRowByForumsId(Integer id);
	
	/**
	 * 根據討論版id取得該討論版下所有文章主題, page=目標頁數, themeSize=每頁顯示筆數
	 */
	public List<Theme> getThemeListByForumsIdLimitFirstAndMax(
			int id, int page, int themeSize);
	
	/**
	 * 根據討論版id與搜尋字串取得文章主題總數
	 */
	public int searchThemeRowByForumsId(Integer id, String searchStr);
	
	/**
	 * 根據討論版id搜尋該討論版下所有文章主題, searchStr=搜尋文字, page=目標頁數, themeSize=每頁顯示筆數
	 */
	public List<Theme> searchThemeListByForumsIdLimitFirstAndMax(
			int id, String searchStr, int page, int themeSize);

}
