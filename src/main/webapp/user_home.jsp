<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user home</title>
<link rel="stylesheet" href="home_style.css" type="text/css">
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
         <h2>Welcome to Personal Portfolio</h2>
            <div class="buttons">
                <button id="view" type="buton">View Portfolio</button>
                <button id="search"  type="buton">Search Image</button>
                <button id="add"  type="buton">Add New</button>
            </div>
            
        </div>
        
    </div>
    
    
    
    <script type="text/javascript" src="user_home.js"></script>
</body>
</html>
