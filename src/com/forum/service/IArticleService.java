package com.forum.service;

import java.util.List;

import com.forum.entity.Article;

public interface IArticleService {
	
	public void saveOrUpdate(Article article);
	
	public void delete(Article article);
	
	public List<Article> getAllArticle();
	
	public Article getArticleById(Integer id);

}
