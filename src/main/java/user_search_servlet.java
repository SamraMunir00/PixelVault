

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
import java.util.ArrayList;
import java.util.List;

import classPackage.userData;

/**
 * Servlet implementation class user_search_servlet
 */
public class user_search_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_search_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("name");
		String name=request.getParameter("imagename");
		String Tags=request.getParameter("tags");
		PrintWriter out=response.getWriter();
			    
			    String USER = "root";
			     String PASSWORD = "root";
			     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
			     response.setContentType("text/html");
			        Connection con = null;
			        PreparedStatement stmt = null;
			        
			        List<userData> data=new ArrayList<>();
			       
			        out.println(" tags  :"+Tags);
			        
			        
		try {
			            
			            Class.forName("com.mysql.cj.jdbc.Driver");

			            
			           
			            con = DriverManager.getConnection(URL, USER, PASSWORD);
			            String sql = "Select * FROM user_images Where username=? ";
	   					
			          	
	    				
		    	           
	    				stmt = con.prepareStatement(sql);
	    				
	    		            stmt.setString(1,username);
	    		           
	    		            ResultSet  s = stmt.executeQuery();
	    		          
	    		            if(s.next()) {
	    		            		if(!Tags.equals("") && !Tags.equals("N/A")){
	    		            			
	    		            			
	    		            			out.println("tags not empoty");
		    			            	String[] tagsArray =Tags.split(",");
		    				        
		    					String l = "Select * FROM user_images Where name=? or (FIND_IN_SET(?, TRIM(SUBSTRING_INDEX(tags,',',1) >0) or (FIND_IN_SET(?, TRIM(SUBSTRING(SUBSTRING_INDEX(tags,',',2),',',-1) >0 or (FIND_IN_SET(?, TRIM(SUBSTRING(SUBSTRING_INDEX(tags,',',3),',',-1) >0 or) or ( FIND_IN_SET(?, TRIM(SUBSTRING(tags,',',1) >0) or (FIND_IN_SET(?, TRIM(SUBSTRING(SUBSTRING_INDEX(tags,',',2),',',-1) >0) or (FIND_IN_SET(?, TRIM(SUBSTRING(SUBSTRING_INDEX(tags,',',3),',',-1) >0) or (FIND_IN_SET(?, TRIM(SUBSTRING(tags,',',1) >0) or (?, TRIM(SUBSTRING(SUBSTRING_INDEX(tags,',',2),',',-1) >0) or (FIND_IN_SET(?, TRIM(SUBSTRING(SUBSTRING_INDEX(tags,',',3),',',-1) >0)";
		    						   					
		    						          	
		    						   			out.println(" query deifned");
		    						    	           
		    						    				stmt = con.prepareStatement(l);
		    						    				
		    						    		            stmt.setString(1,name);
		    						    		           stmt.setString(2,tagsArray[0]);
		    						    		           
		    						    		           
		    						    		           stmt.setString(3,tagsArray[0]);
		    						    		           stmt.setString(4,tagsArray[0]);
		    						    		           stmt.setString(5,tagsArray[1]);
		    						    		           stmt.setString(6,tagsArray[1]);
		    						    		           stmt.setString(7,tagsArray[1]);
		    						    		           stmt.setString(8,tagsArray[2]);
		    						    		           stmt.setString(9,tagsArray[2]);
		    						    		           stmt.setString(10,tagsArray[2]);
		    						    		           
		    						    		           
		    						    		            ResultSet  s1 = stmt.executeQuery();
		    						    		          
		    						    		            
		    						    		            if(s1.next()) {
									    		            	out.println(" tags not empoty, found");
									    		            	do {
									    		            		
									    		            		data.add(new userData(s1.getString("file_name"),s1.getString("name"),s1.getString("tags"),s1.getString("description")));
									    		            		
									    		            		
									    		            	 	
									    		            	}while(s1.next());
									    		            	request.setAttribute("data", data);
									    					       request.getRequestDispatcher("user_searchresult.jsp").forward(request, response);
									    		            	
									    		            	
									    		            }else {
									    		            	out.println(" tags not  empoty,not found");
									    		            	 out.println("not found");
									    		            	out.println("<html><body>");
									    		                out.println("<script type='text/javascript'>");
									    		                out.println("alert('no match found');");
									    		                out.println("window.location = 'user_search.jsp';");
									    		                out.println("</script>");
									    		             
									    		            }

	    		            			
	    		            		 }else {
	 	    				        	out.println(" tags empoty");
	 	    				        	String sql1 = "Select * FROM user_images Where name=? ";
	 	    		   					
	 	    				          	
	 	    		    				
	 	    			    	           
	 	    		    				stmt = con.prepareStatement(sql1);
	 	    		    				
	 	    		    		            stmt.setString(1,name);
	 	    		    		           
	 	    		    		            ResultSet  t = stmt.executeQuery();
	 	    		    		          
	 	    		    		            if(t.next()) {
	 	    		    		            	out.println(" tags  empoty,found");
	 	    		    		            	do {
	 	    		    		            		
	 	    		    		            		data.add(new userData(t.getString("file_name"),t.getString("name"),t.getString("tags"),t.getString("description")));
	 	    		    		            		
	 	    		    		            		
	 	    		    		            	 	
	 	    		    		            	}while(t.next());
	 	    		    		            	
	 	    		    		            	request.setAttribute("data", data);
	 	    		    				       request.getRequestDispatcher("user_searchresult.jsp").forward(request, response);
	 	    		    		            	
	 	    		    		            } else {
	 	    		    		            	out.println(" tags not empoty,not found");
	 	    		    		            	 out.println("not found");
	 	    		    		            	out.println("<html><body>");
	 	    		    		                out.println("<script type='text/javascript'>");
	 	    		    		                out.println("alert('no match found');");
	 	    		    		                out.println("window.location = 'user_search.jsp';");
	 	    		    		                out.println("</script>");
	 	    		    		             
	 	    		    		            }
	 	    		    		            
	 	    		    		            
	 	    		    		            
	 	    		    		            
	 	    		    		            
	 	    		    		            
	 	    		    		            
	 	    		    		            
	 	    		    		            
	 	    		    		            
	 	    				        }
	    		            			
	    		            			
	    		            	
	    		            } else {
	    		            	
	    		            	 
	    		            	out.println("<html><body>");
	    		                out.println("<script type='text/javascript'>");
	    		                out.println("alert('You have nothin in your porfolio');");
	    		                out.println("window.location = 'user_home.jsp';");
	    		                out.println("</script>");
	    		             
            
	    		            	}
	    		            
		       
			            
						    		            	
	    				       
			              
				        }catch(SQLException e) {
				        	out.println("<html><body>");
			                out.println("<script type='text/javascript'>");
			                out.println("alert('sql!!can not search right now!!!');");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
