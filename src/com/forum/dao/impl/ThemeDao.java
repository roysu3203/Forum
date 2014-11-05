package com.forum.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.forum.dao.IThemeDao;
import com.forum.entity.Theme;

public class ThemeDao extends BaseDao<Theme> implements IThemeDao {
	
	public ThemeDao() {
		super(Theme.class);
	}

	@Override
	public List<Theme> findByForumsId(Integer id) {
        return super.findByReturnDescList("forums.id", id, "updateTime");
	}
	
	@SuppressWarnings("unchecked")
	public List<Theme> findByForumsIdLimitFirstAndMax(int id, int first, int size) {
		Criteria criteria = getSession().createCriteria(Theme.class);    
		criteria.add(Restrictions.in("forums.id", new Object[]{id}));
		criteria.setFirstResult(first);
		criteria.setMaxResults(size);
		return criteria.addOrder(Order.desc("updateTime")).list();
	}

	@Override
	public int findByForumsIdRow(int id) {
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.rowCount());
		Criteria criteria = getSession().createCriteria(Theme.class);    
		criteria.add(Restrictions.in("forums.id", new Object[]{id}));
		criteria.setProjection(projectionList);
		return (int) criteria.list().get(0);
	}

	@Override
	public int searchByForumsIdRow(int id, String searchStr) {
		String searchString = "%" + searchStr + "%";
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.rowCount());
		
		Criteria criteria = getSession().createCriteria(Theme.class);    
		criteria.add(Restrictions.in("forums.id", new Object[]{id})); 
		criteria.add(Restrictions.like("title", searchString));		
		criteria.setProjection(projectionList);
		return (int) criteria.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Theme> searchByForumsIdLimitFirstAndMax(int id,
			String searchStr, int first, int size) {
		String searchString = "%" + searchStr + "%";
		Criteria criteria = getSession().createCriteria(Theme.class);
		criteria.add(Restrictions.in("forums.id", new Object[]{id}));
		criteria.add(Restrictions.like("title", searchString));		
		criteria.setFirstResult(first);
		criteria.setMaxResults(size);
		return criteria.addOrder(Order.desc("updateTime")).list();
	}
	
}
