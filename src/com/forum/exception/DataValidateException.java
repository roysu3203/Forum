package com.forum.exception;

/**
 * 驗證資料正確性例外（使用者輸入的資料是否可用）
 * @author Roy
 */
public class DataValidateException extends Exception {
	private static final long serialVersionUID = 1L;
	private int id;
	private String errorMessage;
	
	public DataValidateException(int id) {
		this.id = id;
	}

	public String getErrorMessage() {
		switch(id) {
		case 1:
			errorMessage = "這帳號被別人註冊囉，請您更換一個帳號。";
			break;
		case 2:
			errorMessage = "這Email被別人註冊囉，請您更換一個Email。";
			break;
		default:
			errorMessage = "資料驗證錯誤。";
			break;
		}
		
		return errorMessage;
	}

}
