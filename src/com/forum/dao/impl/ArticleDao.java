package com.forum.dao.impl;

import com.forum.dao.IArticleDao;
import com.forum.entity.Article;

public class ArticleDao extends BaseDao<Article> implements IArticleDao {
	
	public ArticleDao() {
		super(Article.class);
	}

}
