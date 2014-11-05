package com.forum.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/** 文章 */
@Entity
@Table(name = "article")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 文章編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/** 文章作者 */
	@ManyToOne()
	@JoinColumn(name = "users_id")
	private User user;
	
	/** 文章歸屬主題 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "theme_id")
	private Theme theme;
	
	/** 文章內容 */
	private String text;

	/** 文章建立時間 */
	@Column(name="create_time")
	private Timestamp createTime;

	/** 文章最後修改時間 */
	@Column(name="update_time")
	private Timestamp updateTime;
	
	/** 無參數建構子 */
	public Article() {
		
	}

	/** 接受id參數建構子 */
	public Article(Integer id) {
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

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

}
