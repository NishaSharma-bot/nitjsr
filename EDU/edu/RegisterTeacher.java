package com.edu;

import	java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterTeacher extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
          throws ServletException, IOException {  

response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
PreparedStatement ps;
        

String n=request.getParameter("name");  
String p=request.getParameter("psw");  
String e=request.getParameter("email");  
String c=request.getParameter("phone");  
        
try{  
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sun;username=sa;password=Abc123;");


ps=con.prepareStatement(  
"insert into teacherregisterlog values(?,?,?,?)");  

ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c);  
        
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
    
        
}catch (Exception e2) {System.out.println(e2);}  
        
out.close();  
}  

}  