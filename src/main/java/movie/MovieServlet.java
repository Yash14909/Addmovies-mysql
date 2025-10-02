package movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
/**
 * Servlet implementation class MovieServlet
 */
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("MovieServlet is running. Use POST to insert data.");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw;	
		response.setContentType("text/html");
		pw = response.getWriter();
		
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
			pstmt.setDate(5,java.sql.Date.valueOf(rDate));
			pstmt.setFloat(6, rating);
			
			int x=pstmt.executeUpdate();
			
			if(x==1)
				
			{
				pw.println("Values Inserted Successfully"+"<br>");
			}
			else
			{
				pw.println("Insertion failed!!"+"<br>");
			}
			
			String query1="select * from movie";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query1);
			while(rs.next())
			{
				pw.print("ID:"+rs.getInt("id")+"<br>");
				pw.print("Name:"+rs.getString("name")+"<br>");
				pw.print("Actor:"+rs.getString("actor")+"<br>");
				pw.print("Actress:"+rs.getString("actress")+"<br>");
				pw.print("Director:"+rs.getString("director")+"<br>");
				pw.print("Release Date:"+rs.getString("releaseDate")+"<br>");
				pw.print("RatePoint:"+rs.getFloat("ratePoint")+"<br>");
			}
		}
		
		catch(Exception e)
		
		{
			pw.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		
		pw.close();
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
