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
		String passwd= req.getParameter("password");
		
		PrintWriter out= resp.getWriter();
	
		resp.setContentType("text/html");
		
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/Register?useSSL=false","root","shru3022");
			PreparedStatement pstm = c.prepareStatement("select * from users where username=? AND password=?");
			pstm.setString(1, username);
			pstm.setString(2, passwd);
			
			ResultSet rs=pstm.executeQuery();
			
			if(rs.next()) {
				System.out.println("Login Successfully");
				out.println("Login Successfully");
				RequestDispatcher rd= req.getRequestDispatcher("/Profile.html");
				rd.forward(req, resp);
			}else {
				System.out.println("Invalid credential");
				out.println("Invalid credential");
				RequestDispatcher rd= req.getRequestDispatcher("/Login.html");
				rd.include(req, resp);
				
			}
			
		} catch (Exception e) {
			
			
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