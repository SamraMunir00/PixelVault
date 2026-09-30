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


public class loginservlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		 
	     String USER = "root";
	     String PASSWORD = "root";
	     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     
	     String username=request.getParameter("username");
	        String password=request.getParameter("password");
	        
	        
		     HttpSession session =request.getSession();
		     response.setContentType("text/html");
				
	        
	   
	        PrintWriter out=response.getWriter();
	       
	       
	        
	     
			
				String type=(String)session.getAttribute("type");
				/*
				if(type==null) {
					 out.println("new bnda");
			    	  
			      }
			      else if(type.equals("admin")) {
			    	  out.println("admin");
			    	  response.sendRedirect("admin_home.jsp");
			      }
			      else if(type.equals("user")) {
			    	  out.println("user");
			    	  response.sendRedirect("user_home.jsp");
			      }
			
			*/
		      
	       
	  
	        
	        
	        
	        Connection con = null;
	        PreparedStatement stmt = null;
	        try {
	        	out.println("<html><ody>");
            	out.println("<h5>loading driver<h5>");
            	out.println("</body></html>");
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish the connection
	            out.println("<html><ody>");
            	out.println("<h5>getting conncetion<h5>");
            	out.println("</body></html>");
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	            out.println("<html><ody>");
            	out.println("<h5>connection sussceful<h5>");
            	out.println("</body></html>");
	            
	            String sql ="SELECT * FROM register WHERE username =? AND password=?";
	        	
	        	
				
	            out.println("<html><ody>");
            	out.println("<h5>geeting staement<h5>");
            	out.println("</body></html>");
				stmt = con.prepareStatement(sql);
				out.println("<html><ody>");
            	out.println("<h5>setting paarmeters<h5>");
            	out.println("</body></html>");
				 
		            stmt.setString(1,username);
		            stmt.setString(2,password);
		            out.println("<html><ody>");
	            	out.println("<h5>execting query<h5>");
	            	out.println("</body></html>");
		            ResultSet rs= stmt.executeQuery();
		            out.println("<html><ody>");
	            	out.println("<h5>query executed<h5>");
	            	out.println("</body></html>");
		            
		           

		            if(rs.next())  {
		            	session.setAttribute("name",username);
		            	session.setAttribute("type", "user");
		            	session.setMaxInactiveInterval(30*60);
		            	out.println("<html><body>");
		                out.println("<script type='text/javascript'>");
		                out.println("alert('login successful');");
		                out.println("window.location = 'user_home.jsp';");
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
	        	out.println("<h5>sql excception login Failed<h5>");
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
