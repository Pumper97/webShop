<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form"%>
<h2>Hello</h2>
<sec:authorize access="isAuthenticated()">
<a href="user/cart">Cart</a>
	<c:forEach items="${user}" var="users">
		<div class="col-md-4 col-xs-4">${users.email}</div>
	</c:forEach>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="/admin">admin</a>
	</sec:authorize>
	<form:form action="/logout" method="POST">
		<button type="submit" class="btn btn-danger">Logout</button>
	</form:form>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<a href="/login">Login</a>
	<a href="user/cart">Cart</a>
	<a href="/registration">Registration</a>
</sec:authorize>
<a href="/user/sneakerInShop">shop</a>