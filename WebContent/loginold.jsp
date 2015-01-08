<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Servlet"/>
USERNAME:<input type="text" name="username"/><br></br>
PASSWORD:<input type="password" name="password"/><br></br>
CATEGORY:<select name="category" >
<option value="select an option">select an option</option>
<option value="librarian"> librarian</option>
<option value="user">user</option></select>
<input type="hidden" name="pavani" value="login"/>
<input type="submit" value="login"/>
<input type="reset" name="reset"/>
</form>

</body>
</html>