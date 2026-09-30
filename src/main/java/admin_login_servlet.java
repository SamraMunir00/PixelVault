import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class admin_login_servlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		 
	     String USER = "root";
	     String PASSWORD = "root";
	     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     
	     String username=request.getParameter("username");
	     String password=request.getParameter("password");
	      
	     PrintWriter out=response.getWriter();
	     
	     HttpSession session =request.getSession();
	     response.setContentType("text/html");
			
			
				
				
	      
	       
	        
	        Connection con = null;
	        PreparedStatement stmt = null;
	        try {
	        	
	            Class.forName("com.mysql.cj.jdbc.Driver");

	           
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	           
	            String sql ="SELECT * FROM adminData WHERE username =? AND password=?";
	        	
	            
				
	         
				stmt = con.prepareStatement(sql);
				
				 
		            stmt.setString(1,username);
		            stmt.setString(2,password);
		            
		            ResultSet rs= stmt.executeQuery();
		            
		            
		           

			            if(rs.next()) {
			            	session.setAttribute("name",username);
			            	session.setAttribute("type", "admin");
			            	session.setMaxInactiveInterval(60*60*60);
			            	out.println("<html><body>");
			                out.println("<script type='text/javascript'>");
			                out.println("alert('login successful');");
			                out.println("window.location = 'admin_home.jsp';");
			                out.println("</script>");
			                out.println("</body></html>");
			            	
			            }
			            else {
			            	out.println("<html><body>");
			                out.println("<script type='text/javascript'>");
			                out.println("alert('wrong password');");
			                out.println("window.location = 'index.jsp';");
			                out.println("</script>");
			                out.println("</body></html>");
			            	
			            }
			            
			            
	            	   
			        }catch(SQLException e) {
			        	out.println("<html><ody>");
			        	out.println("<h5>sql excception Registeraion Failed<h5>");
			        	out.println("<p>Error: " + e.getMessage() + "</p>");
			        	out.println("</body></html>");
			        
			        } catch (ClassNotFoundException e) {
			        	
			        	out.println("<html><body>");
			            out.println("<h5>Driver Not Found</h5>");
			            out.println("<p>Error: " + e.getMessage() + "</p>");
			            out.println("</body></html>");
			           
		        } catch (Exception s) {
		        	out.println("<html><body>");
		            out.println("<h5> exception login failed</h2>");
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



