// profile.java

// Profile.java 

package com.servlet;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/submitform")
public class Profile extends HttpServlet{
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  String id1 =request.getParameter("empId");
    	  int id11=Integer.parseInt(id1);
    	  String name1 =request.getParameter("empName");
    	  String email1 =request.getParameter("empEmail");
    	  String empPhoneStr = request.getParameter("empPhone");
    	  long empPhone1 = Long.parseLong(empPhoneStr);

    	  String empDept1 =request.getParameter("empDept");
    	  String empPosition1 =request.getParameter("empPosition");
    	  String empSalaryStr =request.getParameter("empSalary");
    	  float empSalary1 =Float.parseFloat(empSalaryStr);
    	  String empDOB1 =request.getParameter("empDOB");
    	  String empGender1 =request.getParameter("empGender");
    	  String empAddress1 =request.getParameter("empAddress");
    	  String empCity1 =request.getParameter("empCity");
    	  String empState1 =request.getParameter("empState");
    	  String empPinString =request.getParameter("empPin");
    	  int empPin1 =Integer.parseInt(empPinString);
    	  String empJoinDate1 =request.getParameter("empJoinDate");
    	  String empQualification1 =request.getParameter("empQualification");
    	  
    	  
    	  
    	  System.out.println(id11);
    	  System.out.println(name1);
    	  System.out.println(email1);
    	  System.out.println(empPhone1);
    	  System.out.println(empDept1);
    	  System.out.println(empPosition1);
    	  System.out.println(empSalary1);
    	  System.out.println(empDOB1);
    	  System.out.println(empGender1);
    	  System.out.println(empAddress1);
    	  System.out.println(empCity1);
    	  System.out.println(empState1);
    	  System.out.println(empPin1);
    	  System.out.println(empJoinDate1);
    	  System.out.println(empQualification1);
    	  
    	      	 
    	  
    	 try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/batch215?useSSL=false","root","shru3022");
    		PreparedStatement ps= c.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		ps.setInt(1,id11);
    		ps.setString(2,name1);
    		ps.setString(3,email1);
    		ps.setLong(4,empPhone1);
    		ps.setString(5,empDept1);
    		ps.setString(6,empPosition1);
    		ps.setFloat(7,empSalary1);
    		ps.setString(8,empDOB1);
    		ps.setString(9,empGender1);
    		ps.setString(10,empAddress1);
    		ps.setString(11,empCity1);
    		ps.setString(12,empState1);
    		ps.setInt(13,empPin1);
    		ps.setString(14,empJoinDate1);
    		ps.setString(15,empQualification1);
    		
    		ps.executeUpdate();
    		response.setContentType("text/html");

    		System.out.println("Data is Inserted.....");
    		 
    		request.setAttribute("id", id11);
    		request.setAttribute("name", name1);
    		request.setAttribute("email", email1);
    		request.setAttribute("phone", empPhone1);
    		request.setAttribute("dept", empDept1);
    		request.setAttribute("position", empPosition1);
    		request.setAttribute("salary", empSalary1);
    		request.setAttribute("dob", empDOB1);
    		request.setAttribute("gender", empGender1);
    		request.setAttribute("address", empAddress1);
    		request.setAttribute("city", empCity1);
    		request.setAttribute("state", empState1);
    		request.setAttribute("pin", empPin1);
    		request.setAttribute("joinDate", empJoinDate1);
    		request.setAttribute("qualification", empQualification1);

    		request.getRequestDispatcher("Profile.jsp").forward(request, response);

    		
    		
    		
    		
    		
    		
    		
    		
    	} catch (Exception e) {
    		
    	}
    	  
    	  
    }
}