<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

		<link rel="stylesheet" href="admin_adduser.css">
</head>
<body>
<%
	boolean  redirected=false;
%>
<%if(!redirected){
	String type=(String)session.getAttribute("type");
				
				 if(type!=null) {
					 
					 
				      if(type.equals("user")) {
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


<form action ="admin_adduser_servlet" method="post" onsubmit="return validation()">
    <div class="home">
    
        <div class="profile">
           
            <div class="account" >
            
                <img src="profilepic.png" id="pic">
                <p  style="color:white"><%=name %></p>
                <button id="passwordchange" type="button">Change Password</button>
                <button id="logout" type="button">Log Out</button>
                
            </div>
        </div>
        <div class="content">
         <h2>Welcome to Personal Portfolio</h2>
            <div class="dialogcontent">
                <span class="cross">&times;</span>
                <h2>Add User </h2>
                <p>Enter gmail</p>
                <input type="text" name="user" id="user">
                <p>Enter password</p>
                <input type="password" name="new" id="new">
                <p>Enter password again</p>
                <input type="password" name="confirm" id="confirm">
                <div class="Add">
            <button type="submit" id ="add" >Add</button>
            </div>
            </div>
            
            
            
        </div>
        
    </div>
    

</form>


	<script type="text/javascript" src="admin_adduser.js"></script>
</body>
</html>