package com.forum.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.forum.entity.Forums;
import com.forum.entity.User;
import com.forum.service.IForumsService;
import com.forum.service.IUserService;

public class AdminAction extends DispatchAction {
	private IForumsService forumsService;
	private IUserService userService;

	/**
	 * 顯示所有討論版
	 */
	public ActionForward forumsDisplay(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception { 
		
		List<Forums> forumsGroup = forumsService.getAllForums();
		
		request.setAttribute("forumsGroup", forumsGroup);
		return mapping.findForward("forums_display");
	}

	/**
	 * 導向新增討論版頁面
	 */
	public ActionForward forumsAddPage(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("forums_add");
	}

	/**
	 * 儲存討論版
	 */
	public ActionForward forumsSave(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = null;
		Forums checkForums = null;
		List<String> errorMessage = new ArrayList<>();
		
		String account = request.getParameter("account");
		String title = request.getParameter("title");
		
		// 驗證資料完整性
		if(StringUtils.isBlank(account)) {
			errorMessage.add("版主帳號不能為空。");
		}
		if(StringUtils.isBlank(title)) {
			errorMessage.add("討論版名稱不能為空。");
		}
		
		// 驗證資料正確性
		if(StringUtils.isNotBlank(account)) {
			user = userService.getUserByAccount(account);
			if(user == null) {
				errorMessage.add("此版主帳號不存在。");
			}
		}
		if(StringUtils.isNotBlank(title)) {
			checkForums = forumsService.getForumsByTitle(title);
			if(checkForums != null) {
				errorMessage.add("此討論版已存在。");
			}
		}
		
		// 若有錯誤訊息，導回新增討論區頁面
		if(errorMessage.size() > 0) {
			request.setAttribute("errorMessage", errorMessage);
			return mapping.findForward("forums_add");
		}
			
		Forums forums = new Forums();
		forums.setUser(user);
		forums.setTitle(title);
		forums.setCreateTime(new Timestamp(System.currentTimeMillis()));
				
		forumsService.saveOrUpdate(forums);
		
		return forumsDisplay(mapping, form, request, response);
	}

	/**
	 * 導向修改討論版頁面
	 */
	public ActionForward forumsUpdatePage(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		
		Forums forums = forumsService.getForumsById(Integer.valueOf(id));

		request.setAttribute("id", forums.getId());
		request.setAttribute("oldAccount", forums.getUser().getAccount());
		return mapping.findForward("forums_update");
	}

	/**
	 * 修改討論版
	 */
	public ActionForward forumsUpdate(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception { 

		User user = null;
		List<String> errorMessage = new ArrayList<>();

		String id = request.getParameter("id");
		String oldAccount = request.getParameter("oldAccount");
		String newAccount = request.getParameter("newAccount");
		
		// 驗證資料完整性
		if(StringUtils.isBlank(newAccount)) {
			errorMessage.add("帳號不能為空。");
		}
		
		// 驗證資料正確性
		if(StringUtils.isNotBlank(newAccount)) {
			user = userService.getUserByAccount(newAccount);
			if(user == null) {
				errorMessage.add("此帳號不存在。");
			}
		}
		
		// 若有錯誤訊息，導回新增討論區頁面
		if(errorMessage.size() > 0) {
			request.setAttribute("id", id);
			request.setAttribute("oldAccount", oldAccount);
			request.setAttribute("errorMessage", errorMessage);
			return mapping.findForward("forums_update");
		}

		Forums forums = forumsService.getForumsById(Integer.valueOf(id));
		forums.setUser(user);
				
		forumsService.saveOrUpdate(forums);

		return forumsDisplay(mapping, form, request, response);
	}

	/**
	 * 刪除討論版
	 */
	public ActionForward forumsDelete(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception { 
		
		String id = request.getParameter("id");
		String token = (String) request.getSession().getAttribute("valid_admin");
		
		// 驗證管理者身份
		if(null != token && !"".equals(token)) {
			// 確認id有值
			if(null != id && !"".equals(id)) {
				Forums forums = new Forums();
				forums.setId(Integer.valueOf(id));
				
				forumsService.delete(forums);
			}
		}
		
		return forumsDisplay(mapping, form, request, response);
	}

	public void setForumsService(IForumsService forumsService) {
		this.forumsService = forumsService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
