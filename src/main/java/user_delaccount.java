

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

/**
 * Servlet implementation class user_delaccount
 */

@WebServlet("user_delaccount")
public class user_delaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USER = "root";
	     String PASSWORD = "root";
	     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     
	     String pass=request.getParameter("pass");
	     HttpSession session=request.getSession();
			String user=(String)session.getAttribute("name");
	        PrintWriter out=response.getWriter();
	        
	       
	        response.setContentType("text/html");
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        
	       // HttpSession session =request.getSession(true);
	       
	   
	        out.println("servelt called");
	        
try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	            String q="SELECT * FROM register WHERE username=?";
	        	stmt = con.prepareStatement(q);
	        	
	        	stmt.setString(1,user);
	        	ResultSet s=stmt.executeQuery();
	        	
	            
	            if(s.next()) {
	            	
	            	if(pass.equals(s.getString("password"))){
	            		
	            		
	            		String check="DELETE FROM register WHERE username=?";
				       	stmt = con.prepareStatement(check);
				       	stmt.setString(1,user);
				       	int r=stmt.executeUpdate();
				       	
					            if(r>0 ){
					
					            		
					            	
					            	out.println("<html><body>");
					                out.println("<script type='text/javascript'>");
					                out.println("alert('Account deleted successfully');");
					               out.println("window.location.href='reg.jsp'");
					                out.println("</script>");
					                out.println("</body></html>");
					               
					            	
					            }
				       	else {
				       		
				       		out.println("<html><body>");
				             out.println("<script type='text/javascript'>");
				             out.println("alert('error in deleting account');");
				             out.println("window.location = 'user_delaccount.jsp';");
				             out.println("</script>");
				             out.println("</body></html>");
						            
				           	 
				       		}
	            		
	            	}
            	else {
            		
            		
            		out.println("<html><body>");
	                out.println("<script type='text/javascript'>");
	                out.println("alert('wrong password');");
	                out.println("window.location = 'user_delaccount.jsp';");
	                out.println("</script>");
	                out.println("</body></html>");
            	}
	            			
	            	
	            
	            }else {
	            	out.println("<html><body>");
	                out.println("<script type='text/javascript'>");
	                out.println("alert('error in deleting account');");
	                out.println("window.location = 'user_delaccount.jsp';");
	                out.println("</script>");
	                out.println("</body></html>");
	            }
		        }catch(SQLException e) {
		        	out.println("<html><ody>");
		        	out.println("<h5>sql excception deletion Failed<h5>");
		        	out.println("<p>Error: " + e.getMessage() + "</p>");
		        	out.println("</body></html>");
		        
		        } catch (ClassNotFoundException e) {
		        	
		        	out.println("<html><body>");
		            out.println("<h5>Driver Not Found</h5>");
		            out.println("<p>Error: " + e.getMessage() + "</p>");
		            out.println("</body></html>");
		           
	        } catch (Exception s) {
	        	out.println("<html><body>");
	            out.println("<h5> exception deletion failed</h2>");
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
