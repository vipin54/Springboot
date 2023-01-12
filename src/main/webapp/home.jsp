<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<p> Enter the deatials for which you want to add</p>
		<form action="addAlien">
		<input type="text" name="aid"> <br>
		<input type="text" name ="aname"> <br>
		<input type="text" name ="tech"> <br>
		<input type ="submit"> <br>
		</form>
		
		<p> Enter the Id for which you want to see details</p>
		
		<form action="getAlien">
		<input type="text" name="aid"> <br>
		<input type ="submit"> <br>
		</form>
		
		<p> Enter the Id for which you want to delete details</p>
		
		<form action="delAlien">
		<input type="text" name="aid"> <br>
		<input type ="submit"> <br>
		</form>
	
</body>
</html>