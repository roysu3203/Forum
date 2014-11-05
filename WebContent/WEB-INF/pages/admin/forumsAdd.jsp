<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span6 offset3">
		<form action="admin.do?action=forumsSave" method="POST" class="form-horizontal">
			<div class="control-group">
				<label class="control-label" for="inputAccount">版主帳號</label>
				<div class="controls">
					<input type="text" name="account" id="inputAccount" placeholder="版主帳號">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputTitle">討論版名稱</label>
				<div class="controls">
					<input type="text" name="title" id="inputTitle" placeholder="討論版名稱">
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
					<button type="submit" class="btn btn-primary">建立</button>
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