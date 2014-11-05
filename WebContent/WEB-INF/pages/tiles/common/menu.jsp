<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="brand" href="index.do">程式語言討論區</a>
    <div class="nav-collapse collapse">
        <ul class="nav">
        
			<%-- 根據使用者所在位置顯示不同狀態的按鍵 --%>
			<c:choose>
				<%-- 顯示被選取的Home(亮) --%>
				<c:when test="${location == 'home'}">
            		<li class="active"><a href="index.do">Home</a></li>
				</c:when>
				<%-- 顯示未被選取的Home(暗) --%>
				<c:otherwise>
            		<li><a href="index.do">Home</a></li>
				</c:otherwise>
			</c:choose>
			
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            
			<%-- 若已登入顯示會員管理 --%>
            <c:if test="${valid_user != null}">
	            <li class="dropdown">
	                <a href="#" class="dropdown-toggle" data-toggle="dropdown">會員管理<b class="caret"></b></a>
	                <ul class="dropdown-menu">
	                    <li><a href="/Forums/member.do?action=goToChangePasswordView">修改密碼</a></li>
	                    <li><a href="#">Another action</a></li>
	                    <li><a href="#">Something else here</a></li>
	                    <li class="divider"></li>
	                    <li class="nav-header">Nav header</li>
	                    <li><a href="#">Separated link</a></li>
	                    <li><a href="#">One more separated link</a></li>
	                </ul>
	            </li>
            </c:if>
            
			<%-- 若身份為管理者顯示管理功能 --%>
            <c:if test="${valid_admin != null}">
	            <li class="dropdown">
	                <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理功能<b class="caret"></b></a>
	                <ul class="dropdown-menu">
	                    <li><a href="admin.do?action=forumsDisplay">討論版管理</a></li>
	                    <li><a href="#">會員管理</a></li>
	                </ul>
	            </li>
			</c:if>
			
			<%-- 若未登入顯示註冊連結 --%>
            <c:if test="${valid_user == null}">
				<%-- 根據使用者所在位置顯示不同狀態的按鍵 --%>
				<c:choose>
					<%-- 顯示被選取的註冊(亮) --%>
					<c:when test="${location == 'register'}">
	            		<li class="active"><a href="register.do?action=registerPage">註冊</a></li>
					</c:when>
					<%-- 顯示未被選取的註冊(暗) --%>
					<c:otherwise>
	            		<li><a href="register.do?action=registerPage">註冊</a></li>
					</c:otherwise>
				</c:choose>
			</c:if>
        </ul>
        
		<c:choose>
			<%-- 若已登入顯示登出按鍵 --%>
			<c:when test="${valid_user != null}">
		        <form action="loginAndOut.do" method="POST" class="navbar-form pull-right">
		        	<input type="hidden" name="action" value="logout">
		            <button id="logout" type="submit" class="btn">登出</button>
		        </form>
			</c:when>
			<%-- 若未登入顯示帳號密碼輸入欄位與登入按鍵 --%>
			<c:otherwise>
		        <form action="loginAndOut.do" method="POST" class="navbar-form pull-right">
		        	<input type="hidden" name="action" value="login">
		            <input type="text" name="account" class="span2" placeholder="帳號">
		            <input type="password" name="password" class="span2" placeholder="密碼">
		            <button type="submit" class="btn">登入</button>
		        </form>
			</c:otherwise>
		</c:choose>
    </div>
</div>