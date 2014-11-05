package com.forum.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.forum.constants.ConstUser;
import com.forum.entity.User;
import com.forum.form.UserForm;
import com.forum.service.IForumsService;
import com.forum.service.IUserService;

public class LoginAndOutAction extends DispatchAction {
	private IUserService userService;
	private IForumsService forumsService;

	/**
	 * 使用者登入
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserForm userForm = (UserForm) form;		
		String account = userForm.getAccount();
		String password = DigestUtils.md5Hex(userForm.getPassword());
		
		User user = userService.getUserByAccount(account);
		
		// 驗證帳號與密碼，通過給予使用者憑證
		if(user != null && user.getPassword().equals(password)) {
			// 驗證身份，若為管理者給予管理者憑證
			if(user.getIdentity().equals(ConstUser.IDENTITY_ADMIN)) {
				request.getSession().setAttribute("valid_admin", account);
			}
			request.getSession().setAttribute("valid_user", account);
			request.getSession().setAttribute("user", user);
		}

		request.setAttribute("forumsInfoList", forumsService.getForumsInfoShowInHome());
		return mapping.findForward("index");
	}

	/**
	 * 使用者登出
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.getSession().invalidate();
		request.setAttribute("forumsInfoList", forumsService.getForumsInfoShowInHome());
		return mapping.findForward("index");
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setForumsService(IForumsService forumsService) {
		this.forumsService = forumsService;
	}

}
