package com.forum.service.impl;

import com.forum.dao.IHitsDao;
import com.forum.service.IHitsService;

public class HitsService implements IHitsService {
	private IHitsDao hitsDao;

	@Override
	public void addHitsForForums(Integer forumsId) {
		hitsDao.addHitsForForums(forumsId);
	}

	@Override
	public void addHitsForTheme(Integer themeId) {
		hitsDao.addHitsForTheme(themeId);
	}

	@Override
	public void addHitsForForumsAndTheme(Integer forumsId, Integer themeId) {
		hitsDao.addHitsForForums(forumsId);
		hitsDao.addHitsForTheme(themeId);
	}

	public void setHitsDao(IHitsDao hitsDao) {
		this.hitsDao = hitsDao;
	}

}
