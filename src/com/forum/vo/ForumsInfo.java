package com.forum.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/** 用於首頁顯示所有討論版資訊 */
@Entity
public class ForumsInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 討論版編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** 討論版名稱 */
	private String forumsName;
	
	/** 討論版主題數量 */
	private String themeCount;
	
	/** 討論版文章數量 */
	private String articleCount;
	
	/** 討論版最新主題名稱 */
	private String newThemeTitle;
	
	/** 討論版最新主題編號 */
	private String newThemeId;
	
	/** 版主 */
	private String moderators;

	/** 無參數建構子 */
	public ForumsInfo() {
		
	}
	
	/** 以下get與set */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getForumsName() {
		return forumsName;
	}

	public void setForumsName(String forumsName) {
		this.forumsName = forumsName;
	}

	public String getThemeCount() {
		return themeCount;
	}

	public void setThemeCount(String themeCount) {
		this.themeCount = themeCount;
	}

	public String getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(String articleCount) {
		this.articleCount = articleCount;
	}

	public String getNewThemeTitle() {
		return newThemeTitle;
	}

	public void setNewThemeTitle(String newThemeTitle) {
		this.newThemeTitle = newThemeTitle;
	}

	public String getNewThemeId() {
		return newThemeId;
	}

	public void setNewThemeId(String newThemeId) {
		this.newThemeId = newThemeId;
	}

	public String getModerators() {
		return moderators;
	}

	public void setModerators(String moderators) {
		this.moderators = moderators;
	}

}
