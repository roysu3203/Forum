<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span6 offset3">
		<form action="member.do?action=changePassword" method="POST" class="form-horizontal">			
			<div class="control-group">
				<label class="control-label" for="oldPassword">請輸入您目前的密碼</label>
				<div class="controls">
					<input type="text" name="oldPassword" 
						id="oldPassword" placeholder="目前密碼">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="newPassword">請輸入新密碼</label>
				<div class="controls">
					<input type="text" name="newPassword" 
						id="newPassword" placeholder="新密碼">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="newPasswordAgain">再次輸入新密碼</label>
				<div class="controls">
					<input type="text" name="newPasswordAgain" 
						id="newPasswordAgain" placeholder="新密碼">
				</div>
			</div>
			<span class="help-block text-center">
				<c:forEach var="message" items="${errorMessageList}">
					<font color="red">
						${message}<br/>
					</font>
				</c:forEach>
			</span>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-primary">送出</button>
					<button type="button" onclick="toHome();" class="btn">回首頁</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">	
	/*
	 *	導向首頁
	 */
	function toHome() {		
		location.href = "index.do";
	}
</script>