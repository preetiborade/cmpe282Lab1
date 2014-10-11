<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Product Catalogue</title>
<link href="resources/bootstrap.css" rel="stylesheet">

<script type="text/javascript">


function addtoCart(prod_name){

	alert('entered cart/product');
	var uri = "cart/product/"+prod_name;
	alert('uri' + uri);
	$.ajax({
	url : uri,
	type: "POST",
	
	success:function(data, textStatus, jqXHR){
	var uri = "rest/file/refresh";
	$.ajax({
	url : uri,
	type: "GET",
	datatype : "json",	
	success:function(data, textStatus, jqXHR){
	window.location.href="userPage.jsp";
	}
	});

	},

	error: function(jqXHR, textStatus, errorThrown){
	//alert('Could not process request.. ' + errorThrown);
	}
	});		
	
}

</script>
</head>

<body>
	<form action="cart", method="post">
    <table class="table table-striped">
    <thead>
    	<tr>
    		<th>Category</th>
    		<th>Details</th> 
  		</tr>
  	</thead>
  	<tbody>
  	   <c:forEach items="${list}" var="products">
			<tr>     
				<td>${products.category}</td>
				<td>${products.product_name}</td>
				<td>${products.details}</td>
				
				<td onclick="addtoCart('${products.getProduct_name()}');"><button
				class="btn btn-danger" type="button">Add to Cart</button></td>
			</tr>
		</c:forEach>
	</tbody>	
	</table>   
	</form>
</body>
</html>