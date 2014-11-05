package com.forum.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.forum.entity.Theme;
import com.forum.service.IThemeService;

public class ThemeAction extends DispatchAction {
	private IThemeService themeService;

	/**
	 * 導向討論區內的文章主題列表, 分頁版, 每頁10則
	 */
	public ActionForward gotoArticleList(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int forumsId = Integer.valueOf(StringUtils
				.defaultIfBlank(request.getParameter("forumsId"), ""));
		int page = Integer.valueOf(StringUtils
				.defaultIfBlank(request.getParameter("page"), "1"));
		
		int total = themeService.getThemeRowByForumsId(forumsId);
		List<Theme> themeList = themeService
				.getThemeListByForumsIdLimitFirstAndMax(forumsId, page, 10);
		
		request.setAttribute("forumsId", forumsId);
		request.setAttribute("themeList", themeList);
		request.setAttribute("totalTheme", total);
		request.setAttribute("locationPage", page);
		return mapping.findForward("theme_list");
	}

	/**
	 * 搜尋文章主題
	 */
	public ActionForward searchTheme(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int forumsId = Integer.valueOf(StringUtils
				.defaultIfBlank(request.getParameter("forumsId"), ""));
		int page = Integer.valueOf(StringUtils
				.defaultIfBlank(request.getParameter("page"), "1"));
		String searchStr = StringUtils.defaultIfBlank(request.getParameter("searchStr"), "");
		
		int total = themeService.searchThemeRowByForumsId(forumsId, searchStr);
		List<Theme> themeList = themeService
				.searchThemeListByForumsIdLimitFirstAndMax(forumsId, searchStr, 
						page, 10);
		
		request.setAttribute("forumsId", forumsId);
		request.setAttribute("themeList", themeList);
		request.setAttribute("totalTheme", total);
		request.setAttribute("locationPage", page);
		request.setAttribute("searchStr", searchStr);
		return mapping.findForward("theme_search_result");
	}

	public void setThemeService(IThemeService themeService) {
		this.themeService = themeService;
	}

}
