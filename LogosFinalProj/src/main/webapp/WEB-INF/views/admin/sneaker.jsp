<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
	.filter .control-label{
		text-align: left;
	}
</style>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				
					<li class="active"><a href="/admin/sneaker<custom:allParams/>">Sneaker</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12">
		<form:form class="form-horizontal filter" action="/admin/sneaker" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="min, max, brandId, sizeId, _modelId, _seasonId, _genderId, _colorId"/>
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="min" class="form-control" placeholder="Min"/>
				</div>
				<div class="col-sm-6">
					<form:input path="max" class="form-control" placeholder="Max"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Brands</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${brands}" itemValue="id" itemLabel="name" path="brandId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Models</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${models}" itemValue="id" itemLabel="name" path="modelId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Sizes</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${sizes}" itemValue="id" itemLabel="size" path="sizeId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Colors</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${colors}" itemValue="id" itemLabel="name" path="colorId"/>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/sneaker" method="POST" modelAttribute="sneaker">
					<custom:hiddenInputs excludeParams="sneaker, color, model, size, season, gender"/>
					<div class="form-group">
						<label style="color:red;text-align:left;" for="brand" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="brand"/></label>
					</div>
					<div class="form-group">
    					<label for="brand" class="col-sm-2 control-label">Brand</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="brand" id="brand" items="${brands}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="model" class="col-sm-2 control-label">Model</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="model" id="model" items="${models}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
  					<div class="form-group">
						<label style="color:red;text-align:left;" for="name" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="color"/></label>
					</div>
					<div class="form-group">
    					<label for="model" class="col-sm-2 control-label">Color</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="color" id="color" items="${colors}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="ms" class="col-sm-2 control-label">Size</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="size" id="size" items="${sizes}" itemLabel="size" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="brand" class="col-sm-2 control-label">Gender</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="gender" id="gender" items="${genders}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="brand" class="col-sm-2 control-label">Season</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="season" id="season" items="${seasons}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="price" class="col-sm-2 control-label">Price</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="price" id="price"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-primary">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-xs-2"><h3>Brand</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Model</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Color</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Size</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Gender</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Season</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Price</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Options</h3></div>
		</div>
			<c:forEach items="${page.content}" var="sneaker">
				<div class="row">
					<div class="col-md-2 col-xs-2">${sneaker.brand.name}</div>
					<div class="col-md-2 col-xs-2">${sneaker.model.name}</div>
					<div class="col-md-1 col-xs-1">${sneaker.color.name}</div>
					<div class="col-md-1 col-xs-1">${sneaker.size.size}</div>
					<div class="col-md-2 col-xs-2">${sneaker.gender.name}</div>
					<div class="col-md-1 col-xs-1">${sneaker.season.name}</div>
					<div class="col-md-1 col-xs-1">${sneaker.price}</div>
					
					<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/sneaker/update/${sneaker.id}<custom:allParams/>">update</a>
					<a class="btn btn-danger" href="/admin/sneaker/delete/${sneaker.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
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