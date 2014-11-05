package com.forum.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.forum.constants.ConstPageLocation;
import com.forum.constants.ConstUser;
import com.forum.entity.User;
import com.forum.exception.DataValidateException;
import com.forum.form.UserForm;
import com.forum.service.IUserService;

public class RegisterAction extends DispatchAction {
	private IUserService userService;

	/**
	 * 使用者註冊
	 */
	public ActionForward registerPage(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception { 
		
		request.setAttribute("location", ConstPageLocation.REGISTER);
		return mapping.findForward("register");
	}

	/**
	 * 儲存使用者
	 */
	public ActionForward save(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String enterCheckCode = request.getParameter("checkCode");
		String checkCode = (String) request.getSession().getAttribute("checkCode");		
		String upperEnterCheckCode = enterCheckCode.toUpperCase();

		// 驗證資料完整性
		List<String> errorMessageList = validateUserForm((UserForm) form);

		if(!checkCode.equals(upperEnterCheckCode)) {
			errorMessageList.add("驗證碼打錯囉！");
		}
		
		// 若驗證失敗, 導回註冊頁面
		if(errorMessageList.size() > 0) {
			request.setAttribute("userForm", form);
			request.setAttribute("errorMessageList", errorMessageList);
			return mapping.findForward("register");
		}

		try {
			userService.register(userFormConversionUser((UserForm) form));
		} catch(DataValidateException e) {
			errorMessageList.add(e.getErrorMessage());
			request.setAttribute("errorMessageList", errorMessageList);
			request.setAttribute("userForm", form);
			return mapping.findForward("register");
		}		   
        
		return mapping.findForward("success");
	}
	
	/**
	 * 驗證 UserForm, 如果驗證失敗回傳錯誤訊息
	 */
	private List<String> validateUserForm(UserForm userForm) {
		List<String> errorMessageList = new ArrayList<>();
		
		// 驗證帳號
		String validateAccount = userForm.getAccount();
		if(StringUtils.isBlank(validateAccount)) {
			errorMessageList.add("帳號不能空白哦！");
		}
		if(validateAccount.length() < 6 || validateAccount.length() > 20) {
			errorMessageList.add("帳號長度只能介於六到二十哦！");
		}
		// 驗證密碼
		String validatePassword = userForm.getPassword();
		if(StringUtils.isBlank(validatePassword)) {
			errorMessageList.add("密碼不能空白哦！");
		}
		if(validatePassword.length() < 6 || validatePassword.length() > 20) {
			errorMessageList.add("密碼長度只能介於六到二十哦！");
		}
		// 驗證Email
		String validateEmail = userForm.getEmail();
		if(StringUtils.isBlank(validateEmail)) {
			errorMessageList.add("Email不能空白哦！");
		}
		
		return errorMessageList;
	}
	
	/**
	 * UserForm 轉換成 User
	 */
	private User userFormConversionUser(UserForm userForm) {
		User user = new User();		
		user.setAccount(userForm.getAccount());
		user.setPassword(DigestUtils.md5Hex(userForm.getPassword()));
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setPhone(userForm.getPhone());
		user.setAddress(userForm.getAddress());
		user.setBirthday(userForm.getBrithday());
		user.setIdentity(ConstUser.IDENTITY_USER);
		return user;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
