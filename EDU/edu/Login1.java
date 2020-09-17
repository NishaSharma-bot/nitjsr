package com.edu;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class Login1 extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();//prints	on	page
        
        String user = request.getParameter("username");
        String pass = request.getParameter("userpass");
        
        if(Validate2.checkUser(user, pass))
        {
        	
            RequestDispatcher rs = request.getRequestDispatcher("downDB.html");
            rs.forward(request, response);
     
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}