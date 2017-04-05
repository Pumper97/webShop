<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<div class="row">
	<div class="col-md-2 col-xs-2 col-md-offset-1">
		<h3>Brand</h3>
	</div>
	<div class="col-md-2 col-xs-2">
		<h3>model</h3>
	</div>
	<div class="col-md-2 col-xs-2">
		<h3>Price</h3>
	</div>
	<div class="col-md-2 col-xs-2">
		<h3>Total</h3>
	</div>
	<div class="col-md-2 col-xs-2">
		<h3>Remove</h3>
	</div>


</div>
<div class="row">
	<c:forEach items="${items}" var="item">
       
		<div class="col-md-2 col-xs-2 col-md-offset-1">${item.sneakerBrand}</div>
		<div class="col-md-2 col-xs-2">${item.sneakerModel}</div>
		<div class="col-md-2 col-xs-2">${item.price}</div>
		<div class="col-md-2 col-xs-2" ><p>${totalPrice}</p></div>
		
	
		<div class="col-md-2 col-xs-2"><a href="/user/cart/remove/${item.id}" class="btn btn-warning text-center">REMOVE</a></div>
	
	</c:forEach>
	

</div>





<script type="text/javascript">
	document
			.getElementById('checkout')
			.addEventListener(
					'click',
					function() {
						alert("Thanks you for your order.\nWe will get in touch with you soon.\nYou also can check your e-mail for order details.")
					});
</script>