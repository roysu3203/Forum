<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span12">
	<a href="admin.do?action=forumsAddPage" class="btn btn-primary">新增</a><hr>
		<table class="table table-bordered">
			<tr>
				<th>討論區</th>
				<th>版主</th>
				<th>功能</th>
			</tr>
			<c:forEach var="forums" items="${forumsGroup}">
				<tr>
					<td>${forums.title}</td>
					<td>${forums.user.name}(${forums.user.account})</td>
					<td>
						<a href="admin.do?action=forumsUpdatePage&id=${forums.id}">更換版主</a> /
						<a href="admin.do?action=forumsDelete&id=${forums.id}">刪除討論區</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>