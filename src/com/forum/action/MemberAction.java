package com.forum.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.forum.entity.User;
import com.forum.service.IUserService;

public class MemberAction extends DispatchAction {
	private IUserService userService;
	Logger logger = Logger.getRootLogger();

	/**
	 * 前往修改密碼頁面
	 */
	public ActionForward goToChangePasswordView(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("goToChangePasswordView");
		return mapping.findForward("changePassword");
	}

	/**
	 * 修改密碼
	 */
	public ActionForward changePassword(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("changePassword");

		String oldPassword = StringUtils.defaultIfBlank(request.getParameter("oldPassword"), "");
		String newPassword = StringUtils.defaultIfBlank(request.getParameter("newPassword"), "");
		String newPasswordAgain = StringUtils.defaultIfBlank(request.getParameter("newPasswordAgain"), "");
		
		List<String> errorMessageList = new ArrayList<>();		
		if(StringUtils.isBlank(oldPassword)) {
			errorMessageList.add("目前密碼不能空白哦！");
		}
		if(StringUtils.isBlank(newPassword)) {
			errorMessageList.add("新密碼不能空白哦！");
		}
		if(StringUtils.isBlank(newPasswordAgain)) {
			errorMessageList.add("要再次輸入新密碼，不能空白哦！");
		}
		if(!(newPassword.equals(newPasswordAgain))) {
			errorMessageList.add("兩次輸入的密碼不一樣哦！");
		}
		// 若驗證失敗, 導回註冊頁面
		if(errorMessageList.size() > 0) {
			request.setAttribute("errorMessageList", errorMessageList);
			return mapping.findForward("changePassword");
		}

		User user = (User) request.getSession().getAttribute("user");
		user.setPassword(DigestUtils.md5Hex(newPassword));
		userService.saveOrUpdate(user);
		
		return mapping.findForward("changePasswordSuccess");
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
