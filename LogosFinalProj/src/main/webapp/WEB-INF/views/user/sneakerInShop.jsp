<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy sneaker</title>
</head>
<body>
	<div class="row">
		<div class="col-md-3 col-xs-12">
			<form:form class="form-horizontal filter"
				action="/user/sneakerInShop" method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="min, max, brandId, sizeId, _modelId, _seasonId, _genderId, _colorId" />

				<div class="form-group">
					<div class="col-sm-6">
						<form:input path="min" class="form-control" placeholder="Min" />
					</div>
					<div class="col-sm-6">
						<form:input path="max" class="form-control" placeholder="Max" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Brands</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${brands}" itemValue="id"
							itemLabel="name" path="brandId" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Models</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${models}" itemValue="id"
							itemLabel="name" path="modelId" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Sizes</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${sizes}" itemValue="id"
							itemLabel="size" path="sizeId" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Colors</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${colors}" itemValue="id"
							itemLabel="name" path="colorId" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Gender</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${genders}" itemValue="id"
							itemLabel="name" path="genderId" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Season</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${seasons}" itemValue="id"
							itemLabel="name" path="seasonId" />
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>
			</form:form>
		</div>



		<div class="row">
			 <div class="col-md-4">
			 <table>
				<tr class="tdPadding">
					<td><h3>Price</h3></td>
					<td><h3>Photo</h3></td>
					<td><h3>Collection name</h3></td>
					<td><h3>Type furniture</h3></td>
					<td><h3>Denomination</h3></td>
					<td><h3>Colors</h3></td>
					
				</tr>
				<c:forEach items="${brands}" var="brand">
				<c:forEach items="${page.content}" var="sneaker">
					<tr>
						
						<td><img src="/images/brand/${brand.id}.jpg?version=${brand.version}"
						width="100%"></td>
						<td>${sneaker.brand.name}</td>
						<td><p>Model:</p>${sneaker.model.name}</td>
						<td><p>Color:</p>
				${sneaker.color.name}</td>
						<td><p>Size:</p>${sneaker.size.size}<p>sm</p></td>
						<td><p>Gender:</p>
				${sneaker.gender.name}</td>
						<td><span class="item_price">$ ${sneaker.price}</span></td>
						<td><p>Size:</p>${sneaker.size.size}<p>sm</p></td>
						<sec:authorize access="isAuthenticated()">
						<td><a href="/user/sneakerInShop/buy/${sneaker.id}"
							class="btn btn-primary">Add on Cart</a></td>
							</sec:authorize>
					</tr>
				</c:forEach>
				</c:forEach>
			</table>
				<%-- <c:forEach items="${brands}" var="brand">


					<c:forEach items="${page.content}" var="sneaker">

					<img src="/images/brand/${brand.id}.jpg?version=${brand.version}"
						width="100%">
						<p>${sneaker.brand.name}</p>
						<p>Model:</p>${sneaker.model.name}
				<br>
						<p>Color:</p>
				${sneaker.color.name} <br>
						<p>Size:</p>${sneaker.size.size}<p>sm</p>
						<br>
						<p>Gender:</p>
				${sneaker.gender.name} <br>
						<span class="item_price">$ ${sneaker.price}</span>
						<a href="/user/sneakerInShop/buy/${sneaker.id}"
							class="btn btn-primary">Add on Cart</a>
					</c:forEach>
				</c:forEach> --%>

			</div> 
			<%-- <table>
				<tr class="tdPadding">
					<td><h3>Price</h3></td>
					<td><h3>Photo</h3></td>
					<td><h3>Collection name</h3></td>
					<td><h3>Type furniture</h3></td>
					<td><h3>Denomination</h3></td>
					<td><h3>Colors</h3></td>
					<td><h3>Options</h3></td>
				</tr>
				<c:forEach items="${page.content}" var="furniture">
					<tr>
						
						<td><img src="/images/brand/${brand.id}.jpg?version=${brand.version}"
						width="100%"></td>
						<td>${sneaker.brand.name}</td>
						<td><p>Model:</p>${sneaker.model.name}</td>
						<td><p>Color:</p>
				${sneaker.color.name}</td>
						<td><p>Size:</p>${sneaker.size.size}<p>sm</p></td>
						<td><p>Gender:</p>
				${sneaker.gender.name}</td>
						<td><span class="item_price">$ ${sneaker.price}</span></td>
						<td><p>Size:</p>${sneaker.size.size}<p>sm</p></td>
						<td><a class="btn btn-warning"
							href="/admin/furniture/update/${furniture.id}<custom:allParams/>">update</a><a
							class="btn btn-danger"
							href="/admin/furniture/delete/${furniture.id}<custom:allParams/>">delete</a></td>
					</tr>
				</c:forEach>
			</table> --%>

		</div>
	</div>
	</div>

<div class="col-md-2 col-xs-12">
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Amount asc" paramValue="sneaekr" />
								<custom:sort innerHtml="Amount desc" paramValue="sneaekr,desc" />
								<custom:sort innerHtml="Ingredient name asc" paramValue="color.name" />
								<custom:sort innerHtml="Ingredient name desc" paramValue="color.name,desc" />
								<custom:sort innerHtml="System name asc" paramValue="brand.name" />
								<custom:sort innerHtml="System name desc" paramValue="brand.name,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
				</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
<script>
	$('label').each(function(){
		if(!$(this).html()) $(this).parent().hide();
	});
	
</script>
</body>
</html>