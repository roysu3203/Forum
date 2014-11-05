package com.forum.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.forum.dao.IBaseDao;

public abstract class BaseDao<T extends Serializable> extends HibernateDaoSupport implements IBaseDao<T> {
	private Class<T> persistentClass;
	
	public BaseDao(){
		
	}

	public BaseDao(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Integer save(T object) {
		return (Integer) getHibernateTemplate().save(object);
	}

	@Override
	public void saveOrUpdate(T object) {
		getHibernateTemplate().saveOrUpdate(object);
	}

	@Override
	public void delete(T object) {
		getHibernateTemplate().delete(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createCriteria(persistentClass).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Integer id) {
		return (T) getHibernateTemplate().get(persistentClass, id);
	}
	
	/**
	 * 根據欄位名稱與查詢條件，回傳Entity
	 */
	@SuppressWarnings("unchecked")
	public T findBy(String name, Object value) {
		T t = null;
        Criteria criteria = getSession().createCriteria(persistentClass);    
        criteria.add(Restrictions.in(name, new Object[]{value}));
        if(criteria.list().size() > 0) {
        	t = (T) criteria.list().get(0); 
        }
        return t;
    }
	
	/**
	 * 根據欄位名稱與查詢條件，回傳陣列
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByReturnList(String name, Object value) {
        Criteria criteria = getSession().createCriteria(persistentClass);    
        criteria.add(Restrictions.in(name, new Object[]{value}));
        return criteria.list();
    }
	
	/**
	 * 根據欄位名稱、查詢條件與倒序屬性，回傳倒序陣列
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByReturnDescList(String name, Object value, String propertyName) {
        Criteria criteria = getSession().createCriteria(persistentClass);    
        criteria.add(Restrictions.in(name, new Object[]{value}));
        return criteria.addOrder(Order.desc(propertyName)).list();
    }

}
