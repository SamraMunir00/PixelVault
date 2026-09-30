

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
 * Servlet implementation class user_change_servlet
 */
public class user_change_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_change_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("name");
		
	    String file_name = request.getParameter("id");
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
	            
        		
            	
            	
            	
            	String sql = "UPDATE user_images SET name=?,tags=?,description=? WHERE file_name=?";
	        	
				
    	           
				stmt = con.prepareStatement(sql);
				
		            
		            stmt.setString(1,file_name);
		            stmt.setString(2,tags);
		            stmt.setString(3,desc);
		            stmt.setString(4,name);
		            int  row = stmt.executeUpdate();
		            out.println(" query executeed");	
		            
		            if(row>0) {
		            	
		            	 	out.println("<html><body>");
			                out.println("<script type='text/javascript'>");
			                out.println("alert('record updated successfully');");
			                out.println("window.location = 'user_view_servlet';");
			                out.println("</script>");
			                out.println("</body></html>");
			            	
		            	
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
