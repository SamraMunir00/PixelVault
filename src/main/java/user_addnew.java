

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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



@MultipartConfig
@WebServlet("/user_addnew")
public class user_addnew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_addnew() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//String user = request.getParameter("user");
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("name");
	    String name = request.getParameter("imageName");
	    String tags = request.getParameter("tags");
	    String desc = request.getParameter("description");
	   String record=request.getParameter("record");
	    PrintWriter out=response.getWriter();
	    
	    String USER = "root";
	     String PASSWORD = "root";
	     String URL="jdbc:mysql://localhost:3306/project?characterEncoding=utf8";
	     response.setContentType("text/html");
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        
	        Part image=request.getPart("image");
	        String path=image.getSubmittedFileName();
	        String uploadPath="C:/workspace/initialproject/src/main/webapp/userData/"+path;
	        out.println(uploadPath);
	        out.println(path);
	        
	        try {
	        	
	        	int count;
	        FileOutputStream fos=new FileOutputStream(uploadPath);
	        InputStream is=image.getInputStream();
	        byte[]data=new byte[is.available()];
	        //while((count=is.read(data))!=-1) {
	        //	fos.write(data,0,count);
	        //}
	        is.read(data);
	        fos.write(data);
	        fos.close();
	        
	        
try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            
	           
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	            String q = "Select * FROM user_images Where username=? && file_name=? ";
					
	          	
				
 	           
				stmt = con.prepareStatement(q);
				
		            stmt.setString(1,user);
		            stmt.setString(2,path);
		           
		            ResultSet  t = stmt.executeQuery();
		          
		           
	            
	            
       if(t.next()) {
    	   out.println("<html><body>");
           out.println("<script type='text/javascript'>");
           out.println("alert('can not add images with same filename');");
           out.println("window.location = 'user_addnew.jsp';");
           out.println("</script>");
           out.println("</body></html>");
    	   
       }
       else {
				   			String sql = "INSERT INTO user_images(username,file_name,name,tags,description)Value(?,?,?,?,?)";
				          	
				    				
				    	           
				    				stmt = con.prepareStatement(sql);
				    				
				    		            stmt.setString(1,user);
				    		            stmt.setString(2,path);
				    		            stmt.setString(3,name);
				    		            stmt.setString(4,tags);
				    		            stmt.setString(5,desc);
				    		            int  s = stmt.executeUpdate();
				    		           
				    		            if(s>0) {
				    		            	
				    		            	 	out.println("<html><body>");
				    			                out.println("<script type='text/javascript'>");
				    			                out.println("alert('record added successfully');");
				    			                out.println("window.location = 'user_home.jsp';");
				    			                out.println("</script>");
				    			                out.println("</body></html>");
				    			            	
				    		            	
				    		            }
				    		            else {
				    		            	
				    		            	out.println("<html><body>");
				    		                out.println("<script type='text/javascript'>");
				    		                out.println("alert('Duplicate image can not be added!!!');");
				    		                out.println("window.location = 'user_home.jsp';");
				    		                out.println("</script>");
				    		                out.println("</body></html>");
				    		            	
				    		            
    		            
				    		            }           
               	} 
           		
	              
		        }catch(SQLException e) {
		        	out.println("<html><body>");
	                out.println("<script type='text/javascript'>");
	                out.println("alert('sql!!record could not be added!!!');");
	                out.println("window.location = 'user_addnew.jsp';");
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
                out.println("alert('e record could not be added!!!');");
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
	catch(IOException e) {
		
    	out.println("<html><body>");
        out.println("<script type='text/javascript'>");
        out.println("alert('error in uploading image!!!');");
        out.println("window.location = 'user_addnew.jsp';");
        out.println("</script>");
        out.println("</body></html>");
    	
	}

	}}
