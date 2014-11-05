package com.forum.api;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.forum.service.IUserService;
import com.forum.service.impl.UserService;

public class ValidateAccount extends Action {
	private IUserService userService;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String account = StringUtils.defaultString(request.getParameter("account"), "");
		
		boolean result = userService.validateAccount(account);

		PrintWriter out = response.getWriter();
		out.println(result);		
		return null;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
