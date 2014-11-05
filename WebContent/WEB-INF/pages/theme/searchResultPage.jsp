<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 計算總頁數 --%>
<c:choose>
	<%-- 如果總則數是10的倍數, 總頁數等於總則數/10 --%>
	<c:when test="${totalTheme % 10 == 0}">
		<fmt:formatNumber var="totalPage" value="${totalTheme / 10}" type="number"/> 
	</c:when>
	<%-- 如果總則數不是10的倍數, 總頁數等於總則數去掉個位數後/10再+1 --%>
	<c:otherwise>
		<fmt:formatNumber var="totalPage" value="${(totalTheme - (totalTheme % 10)) / 10 + 1}" type="number"/> 
	</c:otherwise>
</c:choose>

<%-- 計算分頁的開始與結束頁數 --%>
<c:choose>
	<%-- 如果總頁數在10頁以下, 直接顯示1到總頁數 --%>
	<c:when test="${totalPage <= 10}">
		<c:set var="beginPage" value="1"></c:set>
		<c:set var="endPage" value="${totalPage}"></c:set>
	</c:when>
	<%-- 到此表示以下總頁數都大於10 --%>			
	<%-- 如果目前頁數在5以下, 從第1頁開始, 到第10頁結束 --%>
	<c:when test="${locationPage <= 5}">
		<c:set var="beginPage" value="1"></c:set>
		<c:set var="endPage" value="10"></c:set>
	</c:when>			
	<%-- 如果總頁數-目前頁數小於4, 從總頁數-9開始, 到最後一頁結束 --%>
	<c:when test="${totalPage - locationPage < 4}">
		<c:set var="beginPage" value="${totalPage - 9}"></c:set>
		<c:set var="endPage" value="${totalPage}"></c:set>
	</c:when>			
	<%-- 從目前頁數-5頁開始, 到目前頁面+4頁結束 --%>
	<c:otherwise>
		<c:set var="beginPage" value="${locationPage - 5}"></c:set>
		<c:set var="endPage" value="${locationPage + 4}"></c:set>
	</c:otherwise>
</c:choose>
			
<div class="row">
	<div class="span12">
		<a href="article.do?action=articleAddPage&forumsId=${forumsId}" 
			class="btn btn-primary">發表文章</a>
		<a href="theme.do?action=gotoArticleList&forumsId=${forumsId}" 
			class="btn btn-primary">回討論區</a>
		<br><br>
		<%-- 搜尋 --%>
		<form action="theme.do" method="POST" class="form-search">
			<input type="hidden" name="action" value="searchTheme">
			<input type="hidden" name="forumsId" value="${forumsId}">
			<input type="text" name="searchStr" class="input-large search-query">
			<button type="submit" class="btn">搜尋</button>
		</form>
		<hr>
		<table class="table table-bordered">
			<tr>
				<th>文章</th>
				<th class="span2">回覆</th>
				<th class="span2">人氣</th>
				<th class="span3">最後回應</th>
			</tr>
			<c:forEach var="theme" items="${themeList}">
				<tr>
					<td>
						<a href="article.do?action=gotoArticleList&themeId=${theme.id}">${theme.title}</a>
					</td>
					<td>(未完成)</td>
					<td>(未完成)</td>
					<td>${theme.updateTime}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>


<%-- 分頁 --%>
<div class="pagination">
	<ul>
		<%-- 如果目前位於第一頁, 讓上一頁按鈕不可點選 --%>
		<c:choose>
			<c:when test="${locationPage == 1}">
				<li class="active"><a>«</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/Forums/theme.do?action=searchTheme&forumsId=${forumsId}&searchStr=${searchStr}&page=${locationPage - 1}">«</a></li>
			</c:otherwise>
		</c:choose>
		
		<%-- 顯示分頁迴圈 --%>
		<c:forEach var="i" begin="${beginPage}" end="${endPage}" step="1">
			<%-- 若為目前頁數顯示不可點選的按鈕 --%>
			<c:choose>
				<c:when test="${locationPage == i}">
					<li class="active"><a href="#">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/Forums/theme.do?action=searchTheme&forumsId=${forumsId}&searchStr=${searchStr}&page=${i}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<%-- 如果目前位於最後一頁, 讓下一頁按鈕不可點選 --%>
		<c:choose>
			<c:when test="${locationPage == totalPage}">
				<li class="active"><a>»</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/Forums/theme.do?action=searchTheme&forumsId=${forumsId}&searchStr=${searchStr}&page=${locationPage + 1}">»</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
	<p class="text-right">共查詢到${totalTheme}則討論主題。</p>
</div>