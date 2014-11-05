<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="/tags/struts-tiles"%>

<!DOCTYPE html>
<html lang="en">
	<head>	
	    <meta charset="utf-8">
	    
		<title>
			<tiles:getAsString name="title"/>
		</title>
	
	    <link href="css/bootstrap.css" rel="stylesheet">
	    <link href="css/bootstrap-responsive.css" rel="stylesheet">
	    
	    <script src="js/bootstrap.js"></script>
		<script src="js/common/jquery-1.9.0.min.js"></script>
		<script src="js/common/jquery.validate.js"></script>
	    
	    <style type="text/css">
	      body {
	        padding-top: 60px;
	        padding-bottom: 40px;
	      }
	    </style>	    
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
		    <div class="navbar-inner">
				<tiles:insert attribute="menu"/>
		    </div>
		</div>

	    <div class="container">
			<tiles:insert attribute="body"/><br>
	        <hr>
			<tiles:insert attribute="footer"/>	
	    </div>
	</body>
</html>