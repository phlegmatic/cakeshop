<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>DapurKue | Product Overview</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="styles/960.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="styles/reset.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="styles/text.css" />
<link rel="stylesheet" type="text/css" media="all" href="style.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="themes/brown/style.css" />
</head>
<body>
	<div id="warp">
		<div id="main" class="container_16">
			<div id="header" class="grid_16">
				<div id="logo" class="grid_4 alpha">
					<h1>
						<a href="index.html">DapurKue</a>
					</h1>
					<h2>Famously Delicious</h2>
				</div>
				<div id="headright" class="grid_7 prefix_5 omega">
					<h3 class="login">
						<a href="login.html">Sign up</a> / <a href="login.html">Login</a>
					</h3>
					<p>Subtotal: $ 00.00</p>
					<p>
						<span class="vChart"><a href="shoppingcart.html">View
								Cart</a>
						</span> <span class="cOut"><a href="checkout.html">Checkout</a>
						</span>
					</p>
				</div>
			</div>
			<div id="mainMenu" class="grid_16">
				<ul>
					<li><a href="index.jsp">Home</a>
					</li>
					<li><a href="#">Cakes</a>
					</li>
					<li><a href="#">Order &amp; Delivery</a>
					</li>
				<!-- 	<li><a href="#">Blog</a>
					</li>
					<li><a href="#">About</a>
					</li>
					<li><a href="#">Contact</a>
					</li> -->
				</ul>
			</div>
			<div id="stickySearch" class="grid_16">
				<!-- <div class="stickyNews grid_12 alpha">
					<p>
						Valentine’s BrownieCheese Special Package. <em>Free
							Delivery.</em> <a href="#" class="bookMan">More</a>
					</p>
				</div>
				<div class="search grid_4 omega">
					<form action="#" method="get">
						<input type="text" value="Type your keyword" id="s" name="s"
							onfocus="if (this.value == 'Type your keyword') {this.value = '';}"
							onblur="if (this.value == '') {this.value = 'Type your keyword';}" />
					</form>
				</div> -->
			</div>
			<div class="prodNav grid_16">
				<div class="prodHeadline grid_12 alpha">
					<h3>Cakes</h3>
				</div>
			</div>

			<div class="bodyContent grid_16">
				<c:forEach items="${productMap}" var="productCategory">
				<div class="products grid_16 alpha">
					<div class="prodMenu">
						<h4>
							${productCategory.key} <a href="#" class="viewAll">View All &raquo;</a>
						</h4>
							
							<c:forEach var="products" items="${productCategory.value}">
							<div class="menu grid_4 alpha">
								<p>
									<a href="/CakeShopPortal/cakes?id=${products.productId}" class="grid_4 alpha"><img
										src="${products.filepath}" alt="" width="220" height="120" />
									</a><br /> <a href="/CakeShopPortal/cakes?id=${products.productId}"> <c:out value="${products.productName}" />
									</a>
								</p>
							</div>
						</c:forEach>
					</div>
				</div>
				</c:forEach>
			<!-- 	<div class="commentPages grid_16">
					<ul>
						<li><a href="#">&laquo; Prev</a>
						</li>
						<li><a href="#" class="commentPageActive">1</a>
						</li>
						<li><a href="#">2</a>
						</li>
						<li><a href="#">3</a>
						</li>
						<li><a href="#">4</a>
						</li>
						<li><a href="#">Next &raquo;</a>
						</li>
					</ul>
				</div> -->
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">
		<div class="container_16">
			<div class="copyright grid_16">
				<p class="left">Copyright &copy; 2010, Your Company Here, All
					Rights Reserved</p>
				<p class="right">
					Design by <a href="http://tokokoo.com/">Tokokoo</a> &amp; <a
						href="http://www.instantshift.com/">instantShift</a>
				</p>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>