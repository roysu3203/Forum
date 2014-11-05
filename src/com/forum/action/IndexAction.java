package com.forum.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.forum.service.IForumsService;

public class IndexAction extends Action {
	private IForumsService forumsService;

	/**
	 * 導向首頁
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("forumsInfoList", forumsService.getForumsInfoShowInHome());
		return mapping.findForward("index");
	}

	public void setForumsService(IForumsService forumsService) {
		this.forumsService = forumsService;
	}
	
}
