

import jakarta.servlet.ServletException;
import java.util.List;

import classPackage.user;
import classPackage.userExtended;
import java.util.ArrayList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/admin_searchuser")
public class admin_searchuser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    
	    String USER = "root";
	    String PASSWORD = "root";
	    String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     
	    PrintWriter out=response.getWriter();
	    response.setContentType("text/html");
        
        Connection con = null;
        PreparedStatement stmt = null;
        
        ArrayList<userExtended>  userEData=new ArrayList<>();
        
       
	    String name=request.getParameter("name");
	    
	  
        
        try {
        	
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            
            
            String sql ="SELECT * FROM register WHERE username =?";
        	
  
			stmt = con.prepareStatement(sql);
			
			 
	            stmt.setString(1,name);
	          
	            
	            ResultSet rs= stmt.executeQuery();
	            
	           
	            if(rs.next())  {
	            	
	            	
	            	out.println("<html><ody>");
	            	out.println("alert('user not foundddddd')");
	            	out.println("</body></html>");
	            		String u,p;
	            		u=rs.getString("username");
	            		p=rs.getString("password");
	            		
	            		out.println("user "+u);
	            		out.println("p "+p);
			            	out.println("admin");
			            	String q ="SELECT * FROM user_images WHERE username =?";
			            	 stmt = con.prepareStatement(q);
			            	 stmt.setString(1,name);
			            	 ResultSet r= stmt.executeQuery();
			            	 out.println("r executed");
			            	
			            		 String f,n,t,d;
				 	            	if(r.next()) {
				 	            		
						 	            		 do{
							 	            		out.println("inserting data");
							 	            		
							 	            		f=r.getString("file_name");
							 	            		t=r.getString("tags");
							 	            		d=r.getString("description");
							 	            		n=r.getString("name");
							 	            		
							 	            		userEData.add(new userExtended(name,p,f,n,t,d));
						            	
							 	            		out.println("printing data");
								 	            		for (userExtended element : userEData) {
								 	                       out.println(element);
								 	                   }
								 	            		
						 	            		 	}while(r.next() );
						 	            		 
						 	            		 
						 	            		if(userEData!=null) {
						 	            	       	request.setAttribute("userData", userEData);
						 	            	            request.getRequestDispatcher("admin_searchresult.jsp").forward(request, response);
						 	            	       
						 	            	        }
				 	            	}else {
				 	            			out.println("extended not found");
				 	            			userEData.add(new userExtended(u,p,"N/A","N/A","N/A","N/A"));
				 	            		}
				 	            	 
			 	            	r.close();
			 	            	rs.close();
			 	            	stmt.close();
			 	            	con.close();
	
	            	 
	            }
	            else {
	            	
 	            	out.println("<html><body>");
 	                out.println("<script type='text/javascript'>");
 	                out.println("alert('user not found');");
 	                out.println("window.location = 'admin_searchuser.jsp';");
 	                out.println("</script>");
 	                out.println("</body></html>");
	            }
	            
	            
        }catch(SQLException e) {
        	out.println("<html><ody>");
        	out.println("<h5>sql excception search Failed<h5>");
        	out.println("<p>Error: " + e.getMessage() + "</p>");
        	out.println("</body></html>");
        
        } catch (ClassNotFoundException e) {
        	
        	out.println("<html><body>");
            out.println("<h5>Driver Not Found</h5>");
            out.println("<p>Error: " + e.getMessage() + "</p>");
            out.println("</body></html>");
           
    } catch (Exception s) {
    	out.println("<html><body>");
        out.println("<h5> exception search failed</h2>");
        out.println("<p>Error: " + s.getMessage() + "</p>");
        out.println("</body></html>");
        
    }
        
        
        
	}

}
