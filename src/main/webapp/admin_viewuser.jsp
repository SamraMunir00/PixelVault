<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    \
<%@ page import="java.util.*, classPackage.userExtended" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin search result</title>
<link rel="stylesheet" href="admin_viewUser.css">
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
			    	  out.println("user");
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
         <h2>View All Users</h2>
            <div class="buttons">
                <table border="1">
                <thead>
                	<tr>
                		<th>Personal Details</th><th>ImageDetails</th>
                		<th>Images</th>
                		<th>Options</th>
                		
                	</tr>
                <thead>
                <tbody>
                	<%
                	ArrayList <userExtended> userData =(ArrayList<userExtended>)request.getAttribute("userData");
                	
                	if(userData!=null){
                		for(userExtended u :userData){
                			String path="userData/"+u.getFilename();	
                		
                	%>
                	
                	<tr>
                	
                	<td class="info"><br>
	                		Username : <br> <%=u.getName() %> <br> 
	                		<hr>
	                		Password :<br> <%=u.getPassword() %></td> 
	                		<td class="de"  >
	                		<br>
	                		Name: <%=u.getiName() %> <br> 
	                		<hr>
	                		<%=u.getDesc() %></td>
	                		
	                		<td class="pic"><img id="picData" src="<%=path %> "  alt="image"></td>
	                			
	                		<td class="op">
	                		<form action="admin_del_servlet" method="post" >
	                		<input type="hidden" name="username" value="<%=u.getName() %>">
	                		<input type="hidden" name="filename" value="<%=u.getFilename() %>">
	                		
	                		<button type="submit" id="del">Delete Record</button>
	                 		</form>
	                		
	                		
	                		<br>
	                		
                		<form action="admin_changerequest" method="post" >
                		
                		<input type="hidden" name="username" value="<%=u.getName() %>">
                		<input type="hidden" name="password" value="<%=u.getPassword() %>">
                		<input type="hidden" name="file_name" value="<%=u.getFilename() %>">
                		<input type="hidden" name="imagename" value="<%=u.getiName() %>">
                		<input type="hidden" name="tags" value="<%=u.getTags() %>">
                		<input type="hidden" name="desc" value="<%=u.getDesc() %>">
                	
                 		<button type="submit" id="change">Update Data </button>
                 		</form>
                 		</td>
                	</tr>
                	
                	<% 
               			 }
                	
                	}else{
                		
                	%>
                			<tr>
                			
                				<td colspan =4>No Record Found</td>
                	
                	
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
    
<script type="text/javascript" src="admin_viewuser.js"></script>
</body>
</html>