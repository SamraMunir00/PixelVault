

import jakarta.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classPackage.userData;
/**
 * Servlet implementation class user_view_servlet
 */
@WebServlet("/user_home.jsp")
public class user_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_view_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("name");
		
		
		PrintWriter out=response.getWriter();
	    out.println("user :"+username);
	    		String USER = "root";
	     String PASSWORD = "root";
	     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     response.setContentType("text/html");
	        Connection con = null;
	        PreparedStatement stmt = null;
	       
	        
	        
	        List<userData> data=new ArrayList<>();
	       
	        
	        
	        
	        
try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            
	           
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	            
	            
		        String sql = "Select * FROM user_images Where username=?";
	          	
				
 	           
				stmt = con.prepareStatement(sql);
				
		            stmt.setString(1,username);
		           
		            ResultSet  s = stmt.executeQuery();
		          
		            if(s.next()) {
		            	
		            	
		            	
		            	
		            	do {
		            		
		            		data.add(new userData(s.getString("file_name"),s.getString("name"),s.getString("tags"),s.getString("description")));
		            		
		            		
		            	 	
		            	}while(s.next());
		            	
		            	
		        			request.setAttribute("data", data);
		        	        request.getRequestDispatcher("user_view.jsp").forward(request, response);
		        			
		            	
		            }
		            else {
		            	 out.println("not found");
		            	out.println("<html><body>");
		                out.println("<script type='text/javascript'>");
		                out.println("alert('Nothing to show in your portfolio');");
		               out.println("window.location = 'user_home.jsp';");
		                out.println("</script>");
		                out.println("</body></html>");
		            	
		            
    
    

		        }
	              
		        }catch(SQLException e) {
		        	out.println("<html><body>");
	                out.println("<script type='text/javascript'>");
	                out.println("alert('sql!!can not view right now!!!');");
	                out.println("window.location = 'user_home.jsp';");
	                out.println("<p>Error: \" + e.getMessage() + \"</p>");
	                out.println("</script>");
	                out.println("</body></html>");
		        
		        } catch (ClassNotFoundException e) {
		        	
		        	out.println("<html><body>");
		            out.println("<h5>Driver Not Found</h5>");
		            out.println("<p>Error: " + e.getMessage() + "</p>");
		            out.println("</body></html>");
		           
	        } catch (Exception s) {
	        	out.println("<html><body>");
                out.println("<script type='text/javascript'>");
                out.println("alert('e can not search right now!!!');");
                out.println("window.location = 'user_home.jsp';");
                out.println("</script>");
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
