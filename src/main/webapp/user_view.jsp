<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, classPackage.userData" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user view data</title>
<link rel="stylesheet" href="user_view.css">
</head>
<body>
<%
	boolean  redirected=false;
%>
<%if(!redirected){
	String type=(String)session.getAttribute("type");
				
				 if(type!=null) {
					 
					 
				      if(type.equals("admin")) {
				    	  //out.println("user");
				    	  redirected=true;
				    	  out.println("<html><body>");
			                out.println("<script type='text/javascript'>");
			                out.println("alert('access denied');");
			                out.println("window.location = 'index.jsp';");
			                out.println("</script>");
			                out.println("</body></html>");
				      }
					 
			      }else{
			    	  //out.println("user");
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
                <button id="changepassword" type="'button">Change Password</button>
                <button id="delete" type="buton" >Delete Account</button>
                <button id="logout"  type="buton">Log Out</button>
                
            </div>
        </div>
        <div class="content">
         <h2>View Portfolio</h2>
            <div class="buttons">
                <table border="1">
                <thead>
                	<th >Details</th>
                	<th  >Images</th>
                	
                <thead>
                <tbody>
                	<%
                	ArrayList <userData> Data =(ArrayList<userData>)request.getAttribute("data");
                	
                	if(Data!=null){
                		for(userData u :Data){
                			
                		String path="userData/"+u.getfile();
                	%>
                	
                	<tr>
	                		<td class="de"  >
	                		<br>
	                		Name: <%=u.getName() %> <br> 
	                		<hr>
	                		<%=u.getdesc() %></td>
	                		
	                		<td class="pic"><img id="picData" src="<%=path %> "  alt="image"></td>
	                			
	                		<td class="op">
	                		<form action="user_delData_servlet" method="post" >
	                		
	                		<input type="hidden" name="filename" value="<%=u.getfile() %>">
	                		
	                		<button type="submit" id="del">Delete Image </button>
	                 		</form>
	                		
	                		
	                		<br>
	                		
                		<form action="user_changedata_servlet" method="post" >
                		
                		
                		<input type="hidden" name="file_name" value="<%=u.getfile() %>">
                		<input type="hidden" name="imagename" value="<%=u.getName() %>">
                		<input type="hidden" name="tags" value="<%=u.gettags() %>">
                		<input type="hidden" name="desc" value="<%=u.getdesc() %>">
                	
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
    
 
<script type="text/javascript" src="user_view.js"></script>
</body>
</html>