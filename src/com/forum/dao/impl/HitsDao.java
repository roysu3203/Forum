package com.forum.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.forum.dao.IHitsDao;

public class HitsDao extends HibernateDaoSupport implements IHitsDao {

	@Override
	public void addHitsForForums(Integer forumsId) {
		String sql = new StringBuffer()
		.append("UPDATE Forums f ")
		.append("SET hits = (SELECT f.hits) + 1 ")
		.append("WHERE f.id = :forumsId")
		.toString();
	
		Query query = getSession().createSQLQuery(sql);
		query.setInteger("forumsId", forumsId);
		query.executeUpdate();
	}

	@Override
	public void addHitsForTheme(Integer themeId) {
		String sql = new StringBuffer()
			.append("UPDATE Theme t ")
			.append("SET hits = (SELECT t.hits) + 1 ")
			.append("WHERE id = :themeId")
			.toString();
		
		Query query = getSession().createSQLQuery(sql);
		query.setInteger("themeId", themeId);
		query.executeUpdate();
	}

}
