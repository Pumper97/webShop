<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form class="form-horizontal" action="/admin/sneaker" method="POST">

					<div class="form-group">
						<label for="nossId" class="col-sm-2 control-label">Brand</label>
						<div class="col-sm-10">
							<select class="form-control" name="brandId" id="brandId">
								<c:forEach items="${brands}" var="brand">
									<option value="${brand.id}">${brand.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="nossId" class="col-sm-2 control-label">Model</label>
						<div class="col-sm-10">
							<select class="form-control" name="modelId" id="modelId">
								<c:forEach items="${models}" var="model">
									<option value="${model.id}">${model.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>


					<div class="form-group">
						<label for="nossId" class="col-sm-2 control-label">Color</label>
						<div class="col-sm-10">
							<select class="form-control" name="colorId" id="colorId">
								<c:forEach items="${colors}" var="color">
									<option value="${color.id}">${color.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>







					<div class="form-group">
						<label for="nossId" class="col-sm-2 control-label">Season</label>
						<div class="col-sm-10">
							<select class="form-control" name="seasonId" id="seasonId">
								<c:forEach items="${seasons}" var="season">
									<option value="${season.id}">${season.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="nossId" class="col-sm-2 control-label">Gender</label>
						<div class="col-sm-10">
							<select class="form-control" name="genderId" id="genderId">
								<c:forEach items="${genders}" var="gender">
									<option value="${gender.id}">${gender.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Create</button>
				</div>
			</div>
			</form>
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
			<div class="col-md-4 col-xs-4">${sneaker}</div>
			<div class="col-md-4 col-xs-4">
				<a class="btn btn-warning"
					href="/admin/sneaker/update/${sneaker.id}">update</a>
			</div>
			<div class="col-md-4 col-xs-4">
				<a class="btn btn-danger" href="/admin/sneaker/delete/${sneaker.id}">delete</a>
			</div>
		</div>
	</c:forEach>
</div>
<div class="col-md-2 col-xs-12"></div>
