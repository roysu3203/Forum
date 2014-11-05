package com.forum.service;

public interface IHitsService {
	
	/**
	 * 增加討論區點閱率
	 */
	public void addHitsForForums(Integer forumsId);
	
	/**
	 * 增加討論主題點閱率
	 */
	public void addHitsForTheme(Integer themeId);
	
	/**
	 * 同時增加討論區與討論主題點閱率
	 */
	public void addHitsForForumsAndTheme(Integer forumsId, Integer themeId);

}
