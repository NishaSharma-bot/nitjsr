package com.edu;

import	java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
          throws ServletException, IOException {  

response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
PreparedStatement ps;
        
String	r=request.getParameter("userNo");
String n=request.getParameter("userName");  
String p=request.getParameter("userPass");  
String e=request.getParameter("userEmail");  
String c=request.getParameter("userSem");  
        
try{  
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sun;username=sa;password=Abc123;");


ps=con.prepareStatement(  
"insert into registerlog values(?,?,?,?,?)");  


ps.setString(1,r);  
ps.setString(2,n);  
ps.setString(3,p);  
ps.setString(4,e);  
ps.setString(5,c);        
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
    
        
}catch (Exception e2) {System.out.println(e2);}  
        
out.close();  
}  

}  