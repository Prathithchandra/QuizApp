package com.mphasis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mphasis.dao.UserDao;
import com.mphasis.models.User;

import java.io.IOException;

    @WebServlet("/register")
    public class RegisterServlet extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Get data from form
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Create User object
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole("USER");  // Default role

            // Save using DAO
            UserDao dao = new UserDao();
            boolean success = dao.register(user);

            if (success) {
                response.sendRedirect("login.jsp?register=success");
            } else {
                response.sendRedirect("register.jsp?error=true");
            }
        }
    }

