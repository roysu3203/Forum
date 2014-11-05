package com.forum.dao;

public interface IHitsDao {
	
	/**
	 * 增加討論區點閱率
	 */
	public void addHitsForForums(Integer forumsId);
	
	/**
	 * 增加討論主題點閱率
	 */
	public void addHitsForTheme(Integer themeId);

}
