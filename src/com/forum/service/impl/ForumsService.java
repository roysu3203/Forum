package com.forum.service.impl;

import java.util.List;

import com.forum.dao.IForumsDao;
import com.forum.entity.Forums;
import com.forum.service.IForumsService;
import com.forum.vo.ForumsInfo;

public class ForumsService implements IForumsService {
	private IForumsDao forumsDao;

	@Override
	public void saveOrUpdate(Forums forums) {
		forumsDao.saveOrUpdate(forums);
	}

	@Override
	public void delete(Forums forums) {
		forumsDao.delete(forums);
	}

	@Override
	public List<Forums> getAllForums() {
		return forumsDao.findAll();
	}

	@Override
	public Forums getForumsById(Integer id) {
		return forumsDao.findById(id);
	}

	@Override
	public Forums getForumsByTitle(String title) {
		return forumsDao.findByTitle(title);
	}

	@Override
	public List<ForumsInfo> getForumsInfoShowInHome() {
		return forumsDao.findForumsInfo();
	}

	public void setForumsDao(IForumsDao forumsDao) {
		this.forumsDao = forumsDao;
	}

}
