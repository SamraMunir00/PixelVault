

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

public class admin_adduser_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_adduser_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USER = "root";
	     String PASSWORD = "root";
	     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     
	     String username=request.getParameter("user");
	        String password=request.getParameter("new");
	        PrintWriter out=response.getWriter();
	        out.println("<html><body>");
	        out.println("<h5>Received username: " + username + "</h5>");
	        out.println("<h5>Received password: " + password + "</h5>");
	        out.println("</body></html>");
	        response.setContentType("text/html");
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        
	     
	   
	        try {
	            // Load MySQL JDBC Driver (Not necessary for newer versions of JDBC)
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
           	
	            String sql = "INSERT INTO register (username,password) VALUES (?, ?)";
	        	
				
	            out.println("<html><ody>");
           	out.println("<h5>getting staement<h5>");
           	out.println("</body></html>");
				stmt = con.prepareStatement(sql);
				out.println("<html><ody>");
           	out.println("<h5>setting paarmeters<h5>");
           	out.println("</body></html>");
				 
		            stmt.setString(1,username);
		            stmt.setString(2,password);
		           
		            int  rs = stmt.executeUpdate();
		            out.println("<html><ody>");
	            	out.println("<h5>query executed<h5>");
	            	out.println("</body></html>");
		            if(rs>0) {
		            	
		            	out.println("<html><body>");
		                out.println("<script type='text/javascript'>");
		                out.println("alert('User added successfully');");
		                out.println("window.location = 'admin_home.jsp';");
		                out.println("</script>");
		                out.println("</body></html>");
		            	
		            }
		            else {
		            	out.println("<html><body>");
		                out.println("<script type='text/javascript'>");
		                out.println("alert('Registration Failed');");
		                out.println("window.location = 'admin_home.jsp';");
		                out.println("</script>");
		                out.println("</body></html>");
		            	
		            }
		            
		            
           	   
		        }catch(SQLException e) {
		        	out.println("<html><ody>");
		        	out.println("<h5>sql excception addition Failed<h5>");
		        	out.println("<p>Error: " + e.getMessage() + "</p>");
		        	out.println("</body></html>");
		        
		        } catch (ClassNotFoundException e) {
		        	
		        	out.println("<html><body>");
		            out.println("<h5>Driver Not Found</h5>");
		            out.println("<p>Error: " + e.getMessage() + "</p>");
		            out.println("</body></html>");
		           
	        } catch (Exception s) {
	        	out.println("<html><body>");
	            out.println("<h5> exception addition failed</h2>");
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
