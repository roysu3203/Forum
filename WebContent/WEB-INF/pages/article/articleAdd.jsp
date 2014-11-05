<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span8 offset2">
		<form action="article.do?action=articleSave" method="POST" class="form-horizontal">
			<input type="hidden" name="forumsId" value="${forumsId}">
			<div class="control-group">
				<label class="control-label" for="inputTitle">文章標題</label>
				<div class="controls">
					<input type="text" name="title" id="inputTitle" class="input-xxlarge" placeholder="文章標題">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputText">文章內容</label>
				<div class="controls">
					<textarea rows="10" name="text" id="inputText" class="input-xxlarge" placeholder="文章內容"></textarea>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-primary">送出</button>
					<button type="button" onclick="toThemeList();" class="btn">回討論版</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">	
	/*
	 *	導向至討論版
	 */
	function toThemeList() {		
		location.href = "theme.do?action=gotoArticleList&forumsId=${forumsId}";
	}
</script>