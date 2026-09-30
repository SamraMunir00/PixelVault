<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    \
<%@ page import="java.util.*, classPackage.userExtended" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin search result</title>
<link rel="stylesheet" href="admin_searchresult.css">
 </head>
<body>
<%
	boolean  redirected=false;
%>
<%if(!redirected){
	String type=(String)session.getAttribute("type");
				
				 if(type!=null) {
					 
					 
				      if(type.equals("user")) {
				    	  out.println("user");
				    	  redirected=true;
				    	  out.println("<html><body>");
			                out.println("<script type='text/javascript'>");
			                out.println("alert('access denied');");
			                out.println("window.location = 'index.jsp';");
			                out.println("</script>");
			                out.println("</body></html>");
				      }
					 
			      }else{
			    	 // out.println("user");
			    	  redirected=true;
			    	  out.println("<html><body>");
		                out.println("<script type='text/javascript'>");
		                out.println("alert('access denied');");
		                out.println("window.location = 'index.jsp';");
		                out.println("</script>");
		                out.println("</body></html>");
			      }
				 
}   
			String name=(String)session.getAttribute("name");
				
			
%>
<div class="home">
    
        <div class="profile">
           
            <div class="account" >
            
                <img src="profilepic.png" id="pic">
               <p  style="color:white"><%=name %></p>
                <button id="changepassword"  type="button">Change Password</button>
                
                <button id="logout" type="button">Log Out</button>
                
            </div>
        </div>
        
        
        <div class="content">
         <h2>Search Results</h2>
            <div class="data">
                <table border="1">
                <thead>
                	<tr>
                		<th>Username</th>
                		<th>Password</th>
                		<th>File_name</th>
                		<th>Name</th>
                		<th>Tags</th>
                		<th>Description</th>
                		
                	</tr>
                <thead>
                <tbody>
                	<%
                	ArrayList <userExtended> userData =(ArrayList<userExtended>)request.getAttribute("userData");
                	
                	if(userData!=null){
                		for(userExtended u :userData){
                			
                		
                	%>
                	
                	<tr>
                		<td><%=u.getName() %></td>
                		<td><%=u.getPassword() %></td>
                		<td><%=u.getFilename() %></td>
                		<td><%=u.getiName() %></td>
                		<td><%=u.getTags() %></td>
                		<td><%=u.getDesc() %></td>
                		<td>
                		<form action="admin_del_servlet" method="post" >
                		
                		<input type="hidden" name="name" value="<%=u.getName() %>">
                		<button type="submit" id="del">Delete User </button>
                 		</form>
                 		</td>
                 		
                 		<td>
                 		<form >
                		
                		
                		
                		<input type="hidden" name="user" value="<%=u.getName() %>">
                		<input type="hidden" name="pass" value="<%=u.getPassword() %>">
                		<input type="hidden" name="file_name" value="<%=u.getFilename() %>">
                		<input type="hidden" name="name" value="<%=u.getiName() %>">
                		<input type="hidden" name="tags" value="<%=u.getTags() %>">
                		<input type="hidden" name="desc" value="<%=u.getDesc() %>">
                		<button type="submit" id="change">Change Data </button>
                		
                		</form>
                		
                		</td>
                	</tr>
                	
                	<% 
               			 }
                	}else{
                		
                	%>
                			<tr>
                			
                				<td colspan =6>No User Found</td>
                	
                	
                			</tr>
                	<%
                	}
                	
                	%>
                	
                	
                	
                </tbody>
                </table>
                <button id="GoBack" type="submit">Go Back</button>
            </div>
            
        </div>
        
    </div>
    
<script type="text/javascript" src="admin_searchResult.js"></script>
</body>
</html>