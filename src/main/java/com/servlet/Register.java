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

@WebServlet("/registerServlet")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Register?useSSL=false", "root", "shru3022");

            PreparedStatement ps = c.prepareStatement(
                "INSERT INTO users(username, email, password, confirm_password) VALUES (?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, confirm_password);
            ps.executeUpdate();

            // ✅ Redirect to login on success
            resp.sendRedirect("Login.html");
 
        } catch (Exception e) {
            // ❌ Redirect to register again on failure
            resp.sendRedirect("Register.html");
        }
    }
}