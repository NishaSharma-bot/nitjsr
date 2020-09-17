package com.edu;

import java.sql.*;
public class Validate {
	
	
    public static boolean checkUser(String user,String pass) 
    {
    	
        boolean st =false;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sun;username=sa;password=Abc123;");
         
            PreparedStatement ps = con.prepareStatement("select * from teacherregisterlog where name=? and psw=?");
     
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
           
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }
}
