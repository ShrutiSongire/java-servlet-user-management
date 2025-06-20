//Login.java

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		
		PrintWriter out= resp.getWriter();
	
		resp.setContentType("text/html");
		
		
		
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Register?useSSL=false", "root", "shru3022");

		    System.out.println("Input Username: " + username);
		    System.out.println("Input Password: " + password);

		    PreparedStatement pstm = c.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
		    pstm.setString(1, username);
		    pstm.setString(2, password);

		    ResultSet rs = pstm.executeQuery();

		    if (rs.next()) {
		        System.out.println("Login Successful");
		        out.println("Login Successful");
		        RequestDispatcher rd = req.getRequestDispatcher("/home.html");
		        rd.forward(req, resp);
		    } else {
		        System.out.println("Invalid Credentials");
		        out.println("Invalid Credentials");
		        RequestDispatcher rd = req.getRequestDispatcher("/Login.html");
		        rd.include(req, resp);
		    }
		} catch (Exception e) {
		    e.printStackTrace(); // Debug here
		}

		
//		if(username.equals("shru@gmail.com") && passwd.equals("shru@123")) {
//			System.out.println("Login Successfuly");
//			out.print("Login Successfuly");
//			
//			RequestDispatcher rd= req.getRequestDispatcher("/Profile.html");
//			rd.forward(req, resp);
//		}else {
//			System.out.println("Invalid credential ..");
//			out.println("Invalid credential ..");
//			
//			RequestDispatcher rd =req.getRequestDispatcher("/Register.html");
//			rd.include(req, resp);
//		}
		
		
		
	}

}