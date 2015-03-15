<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>DapurKue | Checkout</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="styles/960.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/reset.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/text.css" />
<link rel="stylesheet" type="text/css" media="all" href="style.css" />
<link rel="stylesheet" type="text/css" media="all" href="themes/brown/style.css" />
<link rel="stylesheet" type="text/css" href="styles/datepicker.css" /> 
<script type="text/javascript" src="scripts/datepicker.js"></script>
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
        <h3 class="login"><span class="hiUser">Hi, ${userInSessionList.get(0).getFirstname()}  ${userInSessionList.get(0).getLastname()}  |</span><a href="/CakeShopPortal/Cart">Logout</a></h3>
        <p>Total: Rs. ${totalCost}</p>
        <p><span class="vChart"><a href="/CakeShopPortal/Cart?cartAtrrib=view">View Cart</a></span></p>
      </div>
    </div>
    <div id="mainMenu" class="grid_16">
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="#">Cakes</a></li>
        <li><a href="#">Order &amp; Delivery</a></li>
        <li><a href="#">Blog</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
    </div>
    <div id="stickySearch" class="grid_16">
      <div class="stickyNews grid_12 alpha">
        <p>Valentine’s BrownieCheese Special Package. <em>Free Delivery.</em> <a href="#" class="bookMan">More &raquo;</a></p>
      </div>
      <div class="search grid_4 omega">
        <form action="#" method="get">
          <input type="text" value="Type your keyword" id="s" name="s" onfocus="if (this.value == 'Type your keyword') {this.value = '';}" onblur="if (this.value == '') {this.value = 'Type your keyword';}" />
        </form>
      </div>
    </div>
    <div class="pageInfo grid_16">
      <div class="dapurBlog grid_11 alpha">
        <h3>Checkout</h3>
      </div>
    </div>
    <div class="checkout grid_16">
      <div class="billInfo grid_11 alpha">
        <h4>Billing Information</h4>
        <form method="post" action="Order" id="comment_form">
          <fieldset>
            <label for="firstName">First Name: </label>
            <input type="text" tabindex="1" size="22" value="${userInSessionList.get(0).getFirstname()}" id="firstName" name="firstName" class="text" />
            <br />
            <label for="lastName">Last Name: </label>
            <input type="text" tabindex="2" size="22" value="${userInSessionList.get(0).getLastname()}" id="lastName" name="lastName" class="text" />
            <br />
            <label for="address">Address:</label>
            <input type="text" tabindex="4" size="50" value="" id="address" name="address" class="text" />
            <br />
            <label for="city">City:</label>
            <input type="text" tabindex="7" size="22" value="" id="city" name="city" class="text" />
            <br />
            <label for="pin">Pin Code:</label>
            <input type="text" tabindex="9" size="22" value="" id="pin" name="pin" class="text" />
            <br />
            <label for="phone">Contact No:</label>
            <input type="text" tabindex="11" size="22" value="" id="phone" name="phone" class="text" />
            <br />
             <label class="delivery">Deliver on this specific date:</label>
            <input id="start_dt" name="deliveryDate" class='datepicker' size='11' /> 
            <br />
            <label class="delivery">Deliver on this specific time:</label>
            <select tabindex="4" name="deliveryTime">
              <option value="Any Time"> Any Time</option>
              <option value="Morning - 7.00 - 12.00 PM"> Morning - 7.00 - 12.00 PM</option>
              <option value="Mid-day - 12.00 - 5.00 PM"> Mid-day - 12.00 - 5.00 PM</option>
              <option value="Night - 5.00 - 9.00 PM"> Night - 5.00 - 9.00 PM</option>
            </select>
             <br />
           	<label class="payment">Payment Option</label>
            <select tabindex="4" name="paymentMethod">
              <option value="Bank transfer"> Bank transfer</option>
              <option value="Credit Card"> Credit Card</option>
              <option value="Cash On Delivery"> Cash On Delivery</option>
            </select>
            <div class="clear"></div>
             <input type="hidden" value="${totalCost}" name="totalCost" />
          </fieldset>
          <p> <input type="submit" value="Place Order" id="checkout" name="checkout" class="button" />
        </p>
         
        </form>
      </div>
      <div class="summary grid_5 omega">
        <h4>Summary</h4>
        <div class="sumWarp">
          <ul>
            <li><a href="#" class="down">Shopping Cart <span><img src="images/done.png" alt="" /></span></a>
              <ul>
                <li class="info">Cost of items in your cart</li>
                <li class="total">Rs ${totalCost}</li>
                <li class="clear"></li>
              </ul>
            </li>
            <li><a href="#" class="billActive">Billing Information</a></li>
            <li><a href="#" class="billDie">Shipping Information</a></li>
            <li><a href="#" class="billDie">Delivery Option</a></li>
            <li><a href="#" class="billDie">Payment Option</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
<div id="richContent2">
  <div class="container_16">
    <div class="lastTweet grid_4">
      <h4>Latest Tweets</h4>
      <p><a href="#">@someone</a> yes indeed this is one hell of a free css template! <a href="#">Read More</a> <span><em>15 minutes ago</em></span></p>
      <p><a href="#">@someone</a> yes indeed this is one hell of a free css template! <a href="#">Read More</a> <span><em>15 minutes ago</em></span></p>
    </div>
    <div class="corporateInfo grid_4">
      <h4>Corporate Info</h4>
      <ul>
        <li><a href="#">Privacy Policy</a></li>
        <li><a href="#">Term &amp; Conditions</a></li>
        <li><a href="#">Franchise</a></li>
        <li><a href="#">About us</a></li>
        <li><a href="#">FAQ</a></li>
      </ul>
    </div>
    <div class="storeDelivery grid_4">
      <h4>Store &amp; Delivery</h4>
      <ul>
        <li><a href="#">Store Locator</a></li>
        <li><a href="#">Delivery Terms &amp;amp Pricing</a></li>
        <li><a href="#">Delivery Coverage</a></li>
        <li><a href="#">Gift Services</a></li>
        <li><a href="#">Track my order</a></li>
      </ul>
    </div>
    <div class="socialNet grid_4">
      <h4>Keep in touch</h4>
      <ul>
        <li><a href="#" class="facebook">Facebook</a></li>
        <li><a href="#" class="twitter">Twitter</a></li>
        <li><a href="#" class="feed">Feed</a></li>
      </ul>
    </div>
    <div class="clear"></div>
  </div>
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