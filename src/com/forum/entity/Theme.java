package com.forum.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/** 文章主題 */
@Entity
@Table(name = "theme")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 主題編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/** 主題作者 */
	@ManyToOne()
	@JoinColumn(name = "users_id")
	private User user;
	
	/** 主題歸屬討論版 */
	@ManyToOne()
	@JoinColumn(name = "forums_id")
	private Forums forums;
	
	/** 主題標題 */
	private String title;

	/** 主題建立時間 */
	@Column(name="create_time")
	private Timestamp createTime;

	/** 主題點擊數 */
	private Integer hits;

	/** 主題最後回應時間 */
	@Column(name="update_time")
	private Timestamp updateTime;
	
	/** 一個主題對應多篇文章 */
	@OneToMany(mappedBy = "theme")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Article> articleList;
	
	/** 無參數建構子 */
	public Theme() {
		
	}

	/** 接受id參數建構子 */
	public Theme(Integer id) {
		this.id = id;
	}

	/** 以下get與set */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Forums getForums() {
		return forums;
	}

	public void setForums(Forums forums) {
		this.forums = forums;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

}
