package com.forum.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.forum.entity.Article;
import com.forum.entity.Forums;
import com.forum.entity.Theme;
import com.forum.entity.User;
import com.forum.service.IArticleService;
import com.forum.service.IHitsService;
import com.forum.service.IThemeService;
import com.forum.service.IUserService;

public class ArticleAction extends DispatchAction {
	private IUserService userService;
	private IThemeService themeService;
	private IArticleService articleService;
	private IHitsService hitsService;

	/**
	 * 導向新增文章頁面
	 */
	public ActionForward articleAddPage(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String forumsId = request.getParameter("forumsId");
		
		request.setAttribute("forumsId", forumsId);
		return mapping.findForward("article_add");
	}

	/**
	 * 儲存文章
	 */
	public ActionForward articleSave(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String forumsId = request.getParameter("forumsId");
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String account = (String) request.getSession().getAttribute("valid_user");

		User user = userService.getUserByAccount(account);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Forums forums = new Forums(Integer.valueOf(forumsId));
		
		// 新增文章主題
		Theme theme = new Theme();
		theme.setUser(user);
		theme.setForums(forums);
		theme.setTitle(title);
		theme.setCreateTime(now);
		theme.setUpdateTime(now);
		theme.setHits(0);
		
		Integer themeId = themeService.save(theme);
		
		theme.setId(themeId);
		
		// 新增文章
		Article article = new Article();
		article.setUser(user);
		article.setTheme(theme);
		article.setText(text);
		article.setCreateTime(now);
		article.setUpdateTime(now);
		
		articleService.saveOrUpdate(article);
		
		request.setAttribute("forumsId", forumsId);
		return mapping.findForward("article_saveSuccess");
	}

	/**
	 * 顯示文章內容
	 */
	public ActionForward gotoArticleList(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Integer themeId = Integer.valueOf(StringUtils.defaultIfBlank(request.getParameter("themeId"), "0"));		
		
		Theme theme = themeService.getThemeById(themeId);
		
		// 儲存點擊率
		hitsService.addHitsForForumsAndTheme(theme.getForums().getId(), themeId);

		request.setAttribute("articleList", theme.getArticleList());
		request.setAttribute("themeId", themeId);
		request.setAttribute("theme", theme);
		return mapping.findForward("article_list");
	}

	/**
	 * 回應文章頁面
	 */
	public ActionForward articleRespondPage(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String articleId = request.getParameter("articleId");
		
		Article article = articleService.getArticleById(Integer.valueOf(articleId));

		request.setAttribute("article", article);
		return mapping.findForward("article_respond");
	}

	/**
	 * 回應文章儲存頁面
	 */
	public ActionForward articleRespondSave(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Integer themeId = Integer.valueOf(StringUtils.defaultIfBlank(request.getParameter("themeId"), "0"));
		String text = StringUtils.defaultIfBlank(request.getParameter("text"), "");
		String account = StringUtils.defaultIfBlank((String) request.getSession().getAttribute("valid_user"), "");
		
		User user = userService.getUserByAccount(account);
		Theme theme = new Theme(themeId);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		Article article = new Article();
		article.setUser(user);
		article.setTheme(theme);
		article.setText(text);
		article.setCreateTime(now);
		article.setUpdateTime(now);
		
		articleService.saveOrUpdate(article);
		
		return gotoArticleList(mapping, form, request, response);
	}

	/**
	 * 刪除文章
	 */
	public ActionForward articleDelete(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Integer articleId = Integer.valueOf(StringUtils.defaultIfBlank(request.getParameter("articleId"), "0"));
		
		Article acticle = new Article(articleId);

		articleService.delete(acticle);
		
		return gotoArticleList(mapping, form, request, response);
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setThemeService(IThemeService themeService) {
		this.themeService = themeService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	public void setHitsService(IHitsService hitsService) {
		this.hitsService = hitsService;
	}

}
