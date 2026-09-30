

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//@WebServlet("/user_changepassword")
public class user_changepassword_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USER = "root";
	     String PASSWORD = "root";
	     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     
	     	String current=request.getParameter("current");
	        String New=request.getParameter("confirm");
	        PrintWriter out=response.getWriter();
	        HttpSession session=request.getSession();
			String user=(String)session.getAttribute("name");
	        out.println("Received current: " + current );
	        out.println("Received new: " + New );
	       
	        response.setContentType("text/html");
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        
	        //HttpSession session =request.getSession(true);
	       
	   
	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            
	           
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	            
           	String check="SELECT password FROM register WHERE username=?";
           	stmt = con.prepareStatement(check);
           	stmt.setString(1,user);
           	ResultSet r=stmt.executeQuery();
           	
	            if(!r.next() ){
	
	            		
	            	out.println("record not found");
	            	out.println("<html><body>");
	                out.println("<script type='text/javascript'>");
	                out.println("alert('record not found!!');");
	                out.println("window.location = 'user_changepassword.jsp';");
	                out.println("</script>");
	                out.println("</body></html>");
	            	
	            }
           	else {
           		
           		out.println(" record found");
				           		String p=r.getString("password");
				           		out.println(" etting password");
				           		out.println("  password"+p);
				           		if(p.equals(current)) {
				           			if(!p.equals(New)) {
				           			out.println(" correct password");
				           			String sql = "UPDATE register SET password =? WHERE username=?";
				    	        	
				    				
				    	           
				    				stmt = con.prepareStatement(sql);
				    				
				    		            stmt.setString(1,New);
				    		            stmt.setString(2,user);
				    		         
				    		            int  rs = stmt.executeUpdate();
				    		            out.println(" query executeed");	
				    		            
				    		            if(rs>0) {
				    		            	out.println(" chaned password");
				    		            	//session.setAttribute(username,password);
				    		            	 //session.setAttribute("type", "user");
				    		            	 //session.setMaxInactiveInterval(60);
				    		            	 out.println("<html><body>");
				    			                out.println("<script type='text/javascript'>");
				    			                out.println("alert('password updated successfully');");
				    			                out.println("window.location = 'user_home.jsp';");
				    			                out.println("</script>");
				    			                out.println("</body></html>");
				    			            	
				    		            	
				    		            }
				    		            else {
				    		            	out.println("not change password");
				    		            	out.println("<html><body>");
				    		                out.println("<script type='text/javascript'>");
				    		                out.println("alert('password can not be changed!!!');");
				    		                out.println("window.location = 'user_home.jsp';");
				    		                out.println("</script>");
				    		                out.println("</body></html>");
				    		            	
				    		            }
				           			}else {
				           				out.println("record not found");
						            	out.println("<html><body>");
						                out.println("<script type='text/javascript'>");
						                out.println("alert('passwod not updated,new password can be as the previous one!!');");
						                out.println("window.location = 'user_changepassword.jsp';");
						                out.println("</script>");
						                out.println("</body></html>");
				           			}
				    		            
				           		}else {
				           			out.println("record not found");
					            	out.println("<html><body>");
					                out.println("<script type='text/javascript'>");
					                out.println("alert('wrong password !!');");
					                out.println("window.location = 'user_changepassword.jsp';");
					                out.println("</script>");
					                out.println("</body></html>");
    		            
    		            
               	} 
           		}
	              
		        }catch(SQLException e) {
		        	out.println("<html><ody>");
		        	out.println("<h5>sql excception change Failed<h5>");
		        	out.println("<p>Error: " + e.getMessage() + "</p>");
		        	out.println("</body></html>");
		        
		        } catch (ClassNotFoundException e) {
		        	
		        	out.println("<html><body>");
		            out.println("<h5>Driver Not Found</h5>");
		            out.println("<p>Error: " + e.getMessage() + "</p>");
		            out.println("</body></html>");
		           
	        } catch (Exception s) {
	        	out.println("<html><body>");
	            out.println("<h5> exception change failed</h2>");
	            out.println("<p>Error: " + s.getMessage() + "</p>");
	            out.println("</body></html>");
	            
	        }finally {
	            try {
	                if (stmt != null) stmt.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                out.println("<h5>SQL Exception: Error closing resources</h5>");
	                out.println("<p>Error: " + e.getMessage() + "</p>");
	                e.printStackTrace(out);
	            }
	        }
	
	}

}
