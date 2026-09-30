<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="admin_home_style.css">
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
         <h2>Welcome to Personal Portfolio</h2>
            <div class="buttons">
                <button type="button" id="viewuser" >View All Users</button>
                <button type="button" id="searchuser" >Search User</button>
                <button type="button" id="adduser" >Add New User</button>
                <button type="button" id="deluser" >Delete User</button>
                
            </div>
            
        </div>
        
    </div>
    


    <script type="text/javascript" src="admin_home_script.js"></script>
</body>
</html>