<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="resources/bootstrap.css" >
<link rel="stylesheet" type="text/css" href="resources/bootstrap.min.js" >
<link rel="stylesheet" type="text/css" href="resources/bootstrap-theme.min.css" >


<style>
    /* This element will == the height of the image */
    .container {
        position: relative;
    }

    /* This element is the background image */
    .background-image {
        width: 100%;
        height: auto;
        position: static;
    }

    /* This element contains the content which will be placed on top of the background image */
    .content {
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        z-index: 1;
    }
</style>


<body>
<div class="container">
    <img class="background-image" src="resources/images/shoppingBags.jpg" width="NATURAL WIDTH" height="NATURAL HEIGHT">
    <div class="content">
       <div class="panel panel-success panel-transparent">
   <div class="panel-heading">Departments</div>
      <div class="panel-body">
         <p>Explore through our departments to find a on-stop shop for your needs!
         </p>
   </div>
   <ul class="list-group">
      <li class="list-group-item"><a href="Category1">Apparel and Accessories</a></li>
      <li class="list-group-item">Health and Beauty</li>
      <li class="list-group-item">Magazine Subscriptions<span class="badge">Discounts</span></li>
      <li class="list-group-item">Gift Cards</li>
      <li class="list-group-item">Coming Soon<span class="badge">New</span></li>
   </ul>
</div>

</div>
</div>




</body>
</html>