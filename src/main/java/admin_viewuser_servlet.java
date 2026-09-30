
import classPackage.userExtended;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import classPackage.user;
import classPackage.userExtended;

import java.sql.SQLException;
/**
 * Servlet implementation class admin_viewuser_servlet
 */
public class admin_viewuser_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_viewuser_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USER = "root";
	     String PASSWORD = "root";
	     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     
	    
	        PrintWriter out=response.getWriter();
	      
	        
	        
	        response.setContentType("text/html");
	        Connection con = null;
	        PreparedStatement stmt = null;
	        ArrayList<userExtended>  userEData=new ArrayList<>();
	        try {
	           
	            Class.forName("com.mysql.cj.jdbc.Driver");

	           
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	            
            	String check="SELECT *  FROM register";
            	stmt = con.prepareStatement(check);
            	
            	ResultSet rs=stmt.executeQuery();
            	
	            if(rs.next() ){
	            	
	            	
	            			String u,p,f,t,d,n;
	            	do {
	            		u=rs.getString("username");
 	            		p=rs.getString("password");
 	            		
 	            		String q ="SELECT * FROM user_images where username=? ;";
		            	
		            	 stmt = con.prepareStatement(q);
		            	 stmt.setString(1,u);
		            	 ResultSet r= stmt.executeQuery();
		            	 if(r.next()) {
		            		 do {
		            			 f=r.getString("file_name");
			 	            		t=r.getString("tags");
			 	            		d=r.getString("description");
			 	            		n=r.getString("name");
			 	            		
			 	            		userEData.add(new userExtended(u,p,f,n,t,d));
		            			 
		            		 }while(r.next());
		            	 }
		            	 else {
		            		 userEData.add(new userExtended(u,p,"N/A","N/A","N/A","N/A"));
		            	 }
	            		
	            	}while(rs.next());
	            	
	            	
            		  	rs.close();
		 	            	stmt.close();
		 	            	con.close();
	            } 
	        else {
	        	
	        	out.println("<html><body>");
                out.println("<script type='text/javascript'>");
                out.println("alert('No user found ');");
                out.println("window.location = 'admin_home.jsp';");
                out.println("</script>");
                out.println("</body></html>");
		        }
	        }catch(SQLException e) {
		        	out.println("<html><ody>");
		        	out.println("<h5>sql excception geting users Failed<h5>");
		        	out.println("<p>Error: " + e.getMessage() + "</p>");
		        	out.println("</body></html>");
		        
		        } catch (ClassNotFoundException e) {
		        	
		        	out.println("<html><body>");
		            out.println("<h5>Driver Not Found</h5>");
		            out.println("<p>Error: " + e.getMessage() + "</p>");
		            out.println("</body></html>");
		           
	        } catch (Exception s) {
	        	out.println("<html><body>");
	            out.println("<h5> exception getting users failed</h2>");
	            out.println("<p>Error: " + s.getMessage() + "</p>");
	            out.println("</body></html>");
	            
	        }
	        
	        request.setAttribute("userData", userEData);
	        request.getRequestDispatcher("admin_viewuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}







