<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<body>
<div class="top-header">
	<div class="container">
		<div class="top-header-main">
			<div class="col-md-4 top-header-left">
				<div class="search-bar">
				
					
				</div>
			</div>
			<div class="col-md-4 top-header-middle">
				<a href="index.html"><img src="/resources/images/logo-4.png" alt="" /></a>
			</div>
			<div class="col-md-4 top-header-right">
			<sec:authorize access="isAuthenticated()">
					<c:forEach items="${userLogIn}" var = "principal" >
					 <div class="col-md-2 col-xs-2">User ${principal} now logged in</div>
					</c:forEach>
					</sec:authorize>
				
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!--top-header-->
	<!--bottom-header-->
	<div class="header-bottom">
		<div class="container">
			<div class="top-nav">
				<ul class="memenu skyblue"><li class="active"><a href="/">Home</a></li>
					
		</div>
	</div>
	</body>