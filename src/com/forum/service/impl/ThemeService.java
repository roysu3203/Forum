package com.forum.service.impl;

import java.util.List;

import com.forum.dao.IThemeDao;
import com.forum.entity.Theme;
import com.forum.service.IThemeService;

public class ThemeService implements IThemeService {
	private IThemeDao themeDao;

	@Override
	public Integer save(Theme theme) {
		return themeDao.save(theme);
	}

	@Override
	public void saveOrUpdate(Theme theme) {
		themeDao.saveOrUpdate(theme);
	}

	@Override
	public void delete(Theme theme) {
		themeDao.delete(theme);
	}

	@Override
	public List<Theme> getAllTheme() {
		return themeDao.findAll();
	}

	@Override
	public Theme getThemeById(Integer id) {
		return themeDao.findById(id);
	}

	@Override
	public List<Theme> getThemeListByForumsId(Integer id) {
		return themeDao.findByForumsId(id);
	}

	@Override
	public List<Theme> getThemeListByForumsIdLimitFirstAndMax(
			int id, int page, int themeSize) {
		int first = (page - 1) * themeSize;
		return themeDao.findByForumsIdLimitFirstAndMax(id, first, themeSize);
	}

	@Override
	public int getThemeRowByForumsId(Integer id) {
		return themeDao.findByForumsIdRow(id);
	}

	@Override
	public int searchThemeRowByForumsId(Integer id, String searchStr) {
		return themeDao.searchByForumsIdRow(id, searchStr);
	}

	@Override
	public List<Theme> searchThemeListByForumsIdLimitFirstAndMax(int id,
			String searchStr, int page, int themeSize) {
		int first = (page - 1) * themeSize;
		return themeDao.searchByForumsIdLimitFirstAndMax(id, searchStr, first, themeSize);
	}

	public void setThemeDao(IThemeDao themeDao) {
		this.themeDao = themeDao;
	}

}
