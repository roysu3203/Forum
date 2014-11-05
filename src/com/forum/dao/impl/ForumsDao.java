package com.forum.dao.impl;

import java.util.List;

import com.forum.dao.IForumsDao;
import com.forum.entity.Forums;
import com.forum.vo.ForumsInfo;

public class ForumsDao extends BaseDao<Forums> implements IForumsDao {
	
	public ForumsDao() {
		super(Forums.class);
	}

	@Override
	public Forums findByTitle(String title) {
		return super.findBy("title", title);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ForumsInfo> findForumsInfo() {
		String sql = "SELECT * FROM forumsInfo";		
		return getSession().createSQLQuery(sql).addEntity(ForumsInfo.class).list();
	}

}
