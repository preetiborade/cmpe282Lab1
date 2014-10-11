 <%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Apparel</title>
</head>

<link rel="stylesheet" type="text/css" href="resources/bootstrap.css" >
<link rel="stylesheet" type="text/css" href="resources/bootstrap.min.js" >
<link rel="stylesheet" type="text/css" href="resources/bootstrap-theme.min.css" >


<style>
img {
    width: 200px;
    height: 200px;
}
</style>


<body>

Welcome ${user} 
<table id="example" class="table table-hover">
					<thead>
						<tr>
							<th>Product_ID</th>
							<th>Category</th>
							<th>Details</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.getProductid()}</td>
							
							<td>${item.getCategory()} </td>
							
						
						</tr>
					</c:forEach>
								 
</table>
</body>

</html>