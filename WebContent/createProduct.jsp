 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <title>Image Upload</title>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <form action="Admin" method="post" enctype="multipart/form-data">
    <table width="400px" align="center" border=0>
       <tr>
           <td align="center" colspan=2>
            Product Details</td>
       </tr>
       <tr>
           <td>Product Name </td>
           <td>
               <input type="text" name="productname"/>
           </td>
       </tr>
       <tr>
           <td>Product Type </td>
           <td>
               <input type="text" name="productType"/>
           </td>
       </tr>
       <tr>
           <td>Image Link: </td>
           <td>
               <input type="file" name="productImage">
           </td>
       </tr>
        <tr>
           <td>Product Description </td>
           <td>
               <input type="text" name="productDescription"/>
           </td>
       </tr>
        <tr>
           <td>Manufacturing Cost </td>
           <td>
               <input type="text" name="productManufacturingCost"/>
           </td>
       </tr>
       <tr>
           <td>Selling Cost </td>
           <td>
               <input type="text" name="productSellingCost"/>
           </td>
       </tr>
       <tr>
           <td>Quantity </td>
           <td>
               <input type="text" name="productQuantity"/>
           </td>
       </tr>
       <tr>
           <td></td>
           <td>
              <input type="submit" name="submit" value="Submit">
               <input type="hidden" name="hiddenVar" value="createProductlogic" />
           </td>
       </tr>
   </table>
</form>
</body>
</html>