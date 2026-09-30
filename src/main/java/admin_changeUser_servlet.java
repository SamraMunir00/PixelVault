

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class admin_changeUser_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_changeUser_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
	    String pass = request.getParameter("password");
	    String file_name = request.getParameter("file_name");
	    String name = request.getParameter("name");
	    String tags = request.getParameter("tags");
	    String desc = request.getParameter("desc");
	   
	   
	   
	    PrintWriter out=response.getWriter();
	    out.println("servlet called");
	    String USER = "root";
	     String PASSWORD = "root";
	     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     response.setContentType("text/html");
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            
	           
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	            
           	String check="SELECT * FROM user_images WHERE file_name=?";
           	stmt = con.prepareStatement(check);
           	stmt.setString(1,file_name);
           	ResultSet r=stmt.executeQuery();
           	
           	if(r.next() ){
           		
        		
            	
            	
            	
            	String sql = "UPDATE user_images SET name=?,tags=?,description=? WHERE username=? && file_name=?";
	        	
				
    	           
				stmt = con.prepareStatement(sql);
				stmt.setString(1,name);
		            stmt.setString(2,tags);
		            stmt.setString(3,desc);
		            stmt.setString(4,user);
		            stmt.setString(5,file_name);
		            
		            int  row = stmt.executeUpdate();
		            out.println(" query executeed");	
		            
		            if(row>0) {
		            	
		            	 	out.println("<html><body>");
			                out.println("<script type='text/javascript'>");
			                out.println("alert('user updated successfully');");
			                out.println("window.location = 'admin_viewuser_servlet';");
			                out.println("</script>");
			                out.println("</body></html>");
			            	
		            	
		            }
		            else {
		            	out.println("not change password");
		            	out.println("<html><body>");
		                out.println("<script type='text/javascript'>");
		                out.println("alert('user can not be updated!!!');");
		                out.println("window.location = 'admin_viewuser_servlet';");
		                out.println("</script>");
		                out.println("</body></html>");
		            	
		            }
            	
            }
       	else {
       		
			           		
			           			String q = "INSERT INTO user_images(username,file_name,name,tags,description)Value(?,?,?,?,?)";
			    	        	
			    				
			    	           
			    				stmt = con.prepareStatement(q);
			    				
			    		            stmt.setString(1,user);
			    		            stmt.setString(2,file_name);
			    		            stmt.setString(3,name);
			    		            stmt.setString(4,tags);
			    		            stmt.setString(5,desc);
			    		            int s = stmt.executeUpdate();
			    		            out.println(" query executeed");	
			    		            
			    		            if(s>0) {
			    		            	
			    		            	 	out.println("<html><body>");
			    			                out.println("<script type='text/javascript'>");
			    			                out.println("alert('user updated successfully');");
			    			                out.println("window.location = 'admin_viewuser_servlet';");
			    			                out.println("</script>");
			    			                out.println("</body></html>");
			    			            	
			    		            	
			    		            }
			    		            else {
			    		            	out.println("not change password");
			    		            	out.println("<html><body>");
			    		                out.println("<script type='text/javascript'>");
			    		                out.println("alert('user can not be updated!!!');");
			    		                out.println("window.location = 'admin_viewuser_servlet';");
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
