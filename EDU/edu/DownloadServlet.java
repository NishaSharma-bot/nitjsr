package com.edu;


import java.io.FileOutputStream;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			response.setContentType("text/html");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection	conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sun;username=sa;password=Abc123;");
			PreparedStatement	ps=conn.prepareStatement("select	*	from	filelog");
			ResultSet	rs=ps.executeQuery();
			PrintWriter	out=response.getWriter();
			
			out.println("<html><body><form	action='FileDownload'	method='get'><table	style=width:'50%'	border='1'><tr><td	padding:15px>serial	no</td><td	padding:15px>name</td><td	padding:15px>file-name</td><td	padding:15px>file</td></tr>");
			while(rs.next())
			{
				//out.print("<div class='block1'><div class='card>..<div class='download'>	<img src='images/downloads-icon-png-25 (1).png' alt='downloading' /></div><!--end of download--> </div></div>");
				
				out.print("<tr><td>"+rs.getInt(4)+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getBlob(3)+"</td</tr>");
				
				out.println("<input	type='submit'	value='DOWNLOAD'>");
				
			}
			
			out.println("</table></body></html>");
		}
		catch(Exception	e)
		{
			e.printStackTrace();
		}
	}
}


