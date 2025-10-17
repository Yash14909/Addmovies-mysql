<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie database JSP</title>
</head>
<body>
<%

String name=request.getParameter("name");
String actor=request.getParameter("actor");
String actress=request.getParameter("actress");
String director=request.getParameter("director");
String rDate=request.getParameter("rDate");
String rPoint=request.getParameter("rPoint");

try {
	
	float rating = Float.parseFloat(rPoint);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/bcapracticals";
	String user="root";
	String password="password";
	
	Connection con=DriverManager.getConnection(url,user,password);
	String query="insert into movie (name,actor,actress,director,releaseDate,ratePoint) values (?,?,?,?,?,?)";
	
	PreparedStatement pstmt=con.prepareStatement(query);
	
	pstmt.setString(1, name);
	pstmt.setString(2, actor);
	pstmt.setString(3, actress);
	pstmt.setString(4, director);
	pstmt.setString(5,rDate);
	pstmt.setFloat(6, rating);
	
	int x=pstmt.executeUpdate();
	
	if(x==1)
		
	{
		out.println("Values Inserted Successfully (JSP)"+"<br>");
	}
	else
	{
		out.println("Insertion failed!!"+"<br>");
	}
	con.close();
}	

catch(Exception e)

{
	out.println("Error: " + e.getMessage());
	e.printStackTrace();
}

%>
</body>
</html>