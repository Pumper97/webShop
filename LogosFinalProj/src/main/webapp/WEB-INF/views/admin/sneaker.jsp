<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/sneaker" method="POST" modelAttribute="sneaker">
					
					<div class="form-group">
						<label for="brand" class="col-sm-2 control-label">Brand</label>
						<div class="col-sm-10">
						<form:select class="form-control" path="brand" id="brand" items="${brands}" itemValue="id" itemLabel="name"/>
							
						</div>
					</div>
					
					<div class="form-group">
						<label for="nossId" class="col-sm-2 control-label">Model</label>
						<div class="col-sm-10">
						<form:select class="form-control" path="model" id="model" items="${models}" itemValue="id" itemLabel="name"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="nossId" class="col-sm-2 control-label">Color</label>
						<div class="col-sm-10">
						<form:select class="form-control" path="color" id="color" items="${colors}" itemValue="id" itemLabel="name"/>
						</div>
					</div>
					<div class="form-group">
					
						<label for="nossId" class="col-sm-2 control-label">Season</label>
						<div class="col-sm-10">
						<form:select class="form-control" path="season" id="season" items="${seasons}" itemValue="id" itemLabel="name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="nossId" class="col-sm-2 control-label">Gender</label>
						<div class="col-sm-10">
						<form:select class="form-control" path="gender" id="gender" items="${genders}" itemValue="id" itemLabel="name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="nossId" class="col-sm-2 control-label">Size</label>
						<div class="col-sm-10">
						<form:select class="form-control" path="size" id="size" items="${sizes}" itemValue="id" itemLabel="size"/>
						</div>
					</div>
					
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Create</button>
				</div>
			</div>
			</form:form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-xs-4">
			<h3>Sneaker</h3>
		</div>
		<div class="col-md-4 col-xs-4">
			<h3>Update</h3>
		</div>
		<div class="col-md-4 col-xs-4">
			<h3>Delete</h3>
		</div>
	</div>
	<c:forEach items="${sneakers}" var="sneaker">
		<div class="row">
			<div class="col-md-1 col-xs-1">${sneaker.brand.name}</div>
			<div class="col-md-1 col-xs-1">${sneaker.model.name}</div>
			<div class="col-md-1 col-xs-1">${sneaker.color.name}</div>
			<div class="col-md-1 col-xs-1">${sneaker.season.name}</div>
			<div class="col-md-1 col-xs-1">${sneaker.gender.name}</div>
			<div class="col-md-1 col-xs-1">${sneaker.size.size}</div>
			<div class="col-md-3 col-xs-3">
				<a class="btn btn-warning"
					href="/admin/sneaker/update/${sneaker.id}">update</a>
			</div>
			<div class="col-md-3 col-xs-3">
				<a class="btn btn-danger" href="/admin/sneaker/delete/${sneaker.id}">delete</a>
			</div>
		</div>
	</c:forEach>
</div>
<div class="col-md-2 col-xs-12"></div>
