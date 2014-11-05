package com.forum.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** 討論版 */
@Entity
@Table(name = "forums")
public class Forums implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 討論版編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/** 版主 */
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	/** 討論版名稱 */
	private String title;

	/** 討論版建立時間 */
	@Column(name="create_time")
	private Timestamp createTime;
	
	/** 點擊數 */
	private Integer hits;

	/** 無參數建構子 */
	public Forums() {
		
	}

	/** 接受id參數建構子 */
	public Forums(Integer id) {
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

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

}
