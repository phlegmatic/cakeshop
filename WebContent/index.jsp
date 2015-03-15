<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>DapurKue</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="styles/960.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/reset.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/text.css" />
<link rel="stylesheet" type="text/css" media="all" href="style.css" />
<link rel="stylesheet" type="text/css" media="all" href="themes/brown/style.css" />
<script type="text/javascript" src="scripts/jquery-1.4.2.js"></script>
<script type="text/javascript" src="scripts/jquery.tools.min.js"></script>
<script type="text/javascript" src="scripts/dapur.js"></script>
</head>
<body>
<div id="warp">
  <div id="main" class="container_16">
    <div id="header" class="grid_16">
      <div id="logo" class="grid_4 alpha">
        <h1><a href="index.html">DapurKue</a></h1>
        <h2>Famously Delicious</h2>
      </div>
      <div id="headright" class="grid_7 prefix_5 omega">
        <h3 class="login"><a href="login.jsp">Sign up</a> / <a href="login.jsp">Login</a></h3>
        <p><span class="vChart"><a href="/CakeShopPortal/Cart">View Cart</a></span></p>
      </div>
    </div>
    <div id="mainMenu" class="grid_16">
      <ul>
        <li><a href="index.jsp" class="aActive">Home</a></li>
        <li><a href="cakes">Cakes</a></li>
        <li><a href="#">Order &amp; Delivery</a></li>
      </ul>
    </div>
    <div id="stickySearch" class="grid_16">
      <!-- <div class="stickyNews grid_12 alpha">
        <p>Valentine’s BrownieCheese Special Package. <em>Free Delivery.</em> <a href="#" class="bookMan">More &raquo;</a></p>
      </div>
      <div class="search grid_4 omega">
        <form action="#" method="get">
          <input type="text" value="Type your keyword" id="s" name="s" onfocus="if (this.value == 'Type your keyword') {this.value = '';}" onblur="if (this.value == '') {this.value = 'Type your keyword';}" />
        </form>
      </div> -->
    </div>
    <div class="products grid_16">
      <div class="productsWarp">
        <ul>
          <li><a href="/CakeShopPortal/cakes"><img src="images/cake1.jpg" alt="" width="938" height="398" /></a></li>
          <li><a href="/CakeShopPortal/cakes"><img src="images/cake2.jpg" alt="" width="938" height="398" /></a></li>
          <li><a href="/CakeShopPortal/cakes"><img src="images/cake3.jpg" alt="" width="938" height="398" /></a></li>
          <li><a href="/CakeShopPortal/cakes"><img src="images/cake3.jpg" alt="" width="938" height="398" /></a></li>
          <li><a href="/CakeShopPortal/cakes"><img src="images/cake3.jpg" alt="" width="938" height="398" /></a></li>
        </ul>
      </div>
    </div>
    <div class="productThumb grid_10 prefix_3 suffix_3">
      <ul>
        <li class="grid_2 alpha"><a href="#"><img src="images/thumb1.jpg" alt="" width="100" height="60" /></a></li>
        <li class="grid_2"><a href="#"><img src="images/thumb2.jpg" alt="" width="100" height="60" /></a></li>
        <li class="grid_2"><a href="#"><img src="images/thumb1.jpg" alt="" width="100" height="60" /></a></li>
        <li class="grid_2"><a href="#"><img src="images/thumb2.jpg" alt="" width="100" height="60" /></a></li>
        <li class="grid_2 omega"><a href="#"><img src="images/thumb1.jpg" alt="" width="100" height="60" /></a></li>
      </ul>
    </div>
  </div>
  <div class="clear"></div>
</div>
<div id="fresh">
  <div class="container_16">
    <div id="freshCake" class="grid_16">
      <div class="grid_1 alpha"> <a class="prevButton">&laquo;</a></div>
      <div class="headLine grid_14">
        <h3>Fresh from the oven</h3>
      </div>
      <div class="grid_1 omega"> <a class="nextButton">&raquo;</a></div>
    </div>
    <div class="newCakes">
      <div class="scroller">
        <div class="newCake"><a href="product-details.html" class="grid_4"><img src="images/freshCake1.jpg" alt="" width="220" height="120" /></a></div>
        <div class="newCake"><a href="product-details.html" class="grid_4"><img src="images/freshCake2.jpg" alt="" width="220" height="120" /></a></div>
        <div class="newCake"><a href="product-details.html" class="grid_4"><img src="images/freshCake3.jpg" alt="" width="220" height="120" /></a></div>
        <div class="newCake"><a href="product-details.html" class="grid_4"><img src="images/freshCake4.jpg" alt="" width="220" height="120" /></a></div>
        <div class="newCake"><a href="product-details.html" class="grid_4"><img src="images/freshCake2.jpg" alt="" width="220" height="120" /></a></div>
        <div class="newCake"><a href="product-details.html" class="grid_4"><img src="images/freshCake3.jpg" alt="" width="220" height="120" /></a></div>
        <div class="newCake"><a href="product-details.html" class="grid_4"><img src="images/freshCake4.jpg" alt="" width="220" height="120" /></a></div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>


<div id="footer">
  <div class="container_16">
    <div class="copyright grid_16">
      <p class="left">Copyright &copy; 2010, Your Company Here, All Rights Reserved</p>
      <p class="right">Design by <a href="http://tokokoo.com/">Tokokoo</a> &amp; <a href="http://www.instantshift.com/">instantShift</a></p>
      <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>
</div>
</body>
</html>