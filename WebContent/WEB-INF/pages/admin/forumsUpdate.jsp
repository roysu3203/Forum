<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span6 offset3">
		<form action="admin.do?action=forumsUpdate" method="POST" class="form-horizontal">
			<input type="hidden" name="id" value="${id}">
			<input type="hidden" name="oldAccount" value="${oldAccount}">
			
			<div class="control-group">
				<label class="control-label">原版主帳號</label>
				<div class="controls">
					<input type="text" value="${oldAccount}" disabled>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputAccount">新版主帳號</label>
				<div class="controls">
					<input type="text" name="newAccount" id="inputAccount" placeholder="新版主帳號">
				</div>
			</div>
			<span class="help-block text-center">
				<c:forEach var="message" items="${errorMessage}">
					<font color="red">
						${message}<br/>
					</font>
				</c:forEach>
			</span>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-primary">送出</button>
					<button type="button" onclick="toAdminHome();" class="btn">回管理者首頁</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">	
	/*
	 *	導向至管理者首頁
	 */
	function toAdminHome() {		
		location.href = "admin.do?action=forumsDisplay";
	}
</script>