$(document).ready(function(){
	
	// 表單驗證
	$("#registerForm").validate({
		rules: {
			account: {
				required: true,
				rangelength: [6, 20],
				remote: "validateAccount.do"
			},
			password: {
				required: true,
				rangelength: [6, 20]
			},
			email: {
				required: true,
				email: true
			}
		}, // end rules
		messages: {
			account: {
				required: "帳號不能空白哦！",
				rangelength: "帳號長度只能介於六到二十哦！",
				remote: "這帳號被別人註冊囉，請您更換一個帳號。"
			},
			password: {
				required: "密碼不能空白哦！",
				rangelength: "密碼長度只能介於六到二十哦！"
			},
			email: {
				required: "Email不能空白哦！",
				email: "Email格式不符哦！"
			}
		} // end messages
	}); // end validate
	
	// 驗證帳號是否重覆
	$('#inputAccount').blur(function() {
		
	}); // end blur
	
	
	// 回首頁
	$('#toHome').click(function() {
		location.href = "index.do";
	}); // end click
	
}); // end ready