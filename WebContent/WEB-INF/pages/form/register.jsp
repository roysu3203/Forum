<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span6 offset3">
		<form action="register.do?action=save" method="POST" id="registerForm" class="form-horizontal">
			<div class="control-group">
				<label class="control-label" for="inputAccount">帳號</label>
				<div class="controls">
					<input type="text" name="account" id="inputAccount" placeholder="帳號" value="${requestScope.userForm.account}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">密碼</label>
				<div class="controls">
					<input type="password" name="password" id="inputPassword" placeholder="密碼" value="${requestScope.userForm.password}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputEmail">Email</label>
				<div class="controls">
					<input type="text" name="email" id="inputEmail" placeholder="Email" value="${requestScope.userForm.email}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputName">姓名</label>
				<div class="controls">
					<input type="text" name="name" id="inputName" placeholder="姓名" value="${requestScope.userForm.name}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPhone">電話</label>
				<div class="controls">
					<input type="text" name="phone" id="inputPhone" placeholder="電話" value="${requestScope.userForm.phone}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputAddress">地址</label>
				<div class="controls">
					<input type="text" name="address" id="inputAddress" placeholder="地址" value="${requestScope.userForm.address}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputBrithday">生日</label>
				<div class="controls">
					<input type="text" name="brithday" id="inputBrithday" placeholder="生日" value="${requestScope.userForm.brithday}">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<img src="/Forum/CheckCodeImage">
					<input type="text" name="checkCode" class="input-small" placeholder="驗證碼">
				</div>
			</div>
			<c:if test="${requestScope.errorMessageList != null}">
				<div class="control-group">
					<c:forEach var="errorMessage" items="${requestScope.errorMessageList}">
						<div class="controls text-error">${errorMessage}</div>
					</c:forEach>
				</div>
			</c:if>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-primary">註冊</button>
					<button id="toHome" type="button" class="btn">回首頁</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script src="/Forums/js/register/register.js"></script>