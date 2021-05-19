<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>Details are given below:</h1><hr>
<table>
<tr>
<td>Id</td>
<td>${id}</td>
</tr>
<tr>
<td>Name</td>
<td>${name}</td>
</tr>
<tr>
<td>Image</td>
<td><img src="data:image/jpg;base64,${image} alt="Girl in a jacket" style="width:100px;height:100px;"></img></td>
</tr>
</table>
</body>
</html>