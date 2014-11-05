<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="row">
	<div class="span12">
		<a href="theme.do?action=gotoArticleList&forumsId=${theme.forums.id}" 
			class="btn btn-primary">回討論區</a>
		<br><br>
		<table class="table table-bordered">
			<c:forEach var="article" items="${articleList}">
				<tr>
					<th class="span2">${article.user.name}</th>
					<th>${article.theme.title}</th>
				</tr>
				<tr>
					<td class="span2">
						<fmt:formatDate value="${article.updateTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<td>
						${article.text}
						<p class="text-right">
							<a href="article.do?action=articleRespondPage&articleId=${article.id}" 
								class="btn btn-primary">回應</a>
							<%-- 版主才顯示刪除按鈕 --%>
							<c:if test="${requestScope.theme.forums.user.account == sessionScope.valid_user}">
								<a href="article.do?action=articleDelete&articleId=${article.id}&themeId=${requestScope.theme.id}" 
									class="btn btn-primary">刪除</a>
							</c:if>
						</p>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>