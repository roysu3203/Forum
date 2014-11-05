<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span12">
		<table class="table table-bordered">
			<tr>
				<th>討論區</th>
				<th>主題數</th>
				<th>文章數</th>
				<th>最新文章</th>
				<th>版主</th>
			</tr>
			<c:forEach var="forumsInfo" items="${forumsInfoList}">
				<tr>
					<td>
						<a href="theme.do?action=gotoArticleList&forumsId=${forumsInfo.id}">${forumsInfo.forumsName}</a>
					</td>
					<td>${forumsInfo.themeCount}</td>
					<td>${forumsInfo.articleCount}</td>
					<td>
						<a href="article.do?action=gotoArticleList&themeId=${forumsInfo.newThemeId}">
							${forumsInfo.newThemeTitle}
						</a>
					</td>
					<td>${forumsInfo.moderators}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>