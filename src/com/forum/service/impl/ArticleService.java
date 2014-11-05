package com.forum.service.impl;

import java.util.List;

import com.forum.dao.IArticleDao;
import com.forum.entity.Article;
import com.forum.service.IArticleService;

public class ArticleService implements IArticleService {
	private IArticleDao articleDao;

	@Override
	public void saveOrUpdate(Article article) {
		articleDao.saveOrUpdate(article);
	}

	@Override
	public void delete(Article article) {
		articleDao.delete(article);
	}

	@Override
	public List<Article> getAllArticle() {
		return articleDao.findAll();
	}

	@Override
	public Article getArticleById(Integer id) {
		return articleDao.findById(id);
	}

	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}

}
