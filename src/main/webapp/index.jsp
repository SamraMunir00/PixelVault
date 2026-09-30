<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>portfolio </title>
    <link rel="stylesheet" href="login_style.css">
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
			                out.println("alert('session found');");
			                out.println("window.location = 'admin_home.jsp';");
			                out.println("</script>");
			                out.println("</body></html>");
				      }else if(type.equals("user")) {
				    	  //out.println("user");
				    	  redirected=true;
				    	  out.println("<html><body>");
			                out.println("<script type='text/javascript'>");
			                out.println("alert('session found');");
			                out.println("window.location = 'user_home.jsp';");
			                out.println("</script>");
			                out.println("</body></html>");
				      }
				      
					 
			      }
				 
}   
			
			
%>
<form id="formlogin" action="loginservlet" method="post" onsubmit="return validation()">
    <h1>Personal Photography Portfolio</h1>
    <div class="form">
        <div class="option">
            <button type="buton" id="login">Login</button>
            <button  type="buton" id="reg" >Register</button>
        </div>
        <div class="credentials">
            <p>Username</p>
            <input id="username" type="text" placeholder="your registered gmail" name="username">
            <p>Password</p>
            <input id="password" type="password" name="password">

        </div>
        
        
       		
            
            <div class="admin-checkbox">
                <input type="checkbox" id="admin" name="admin-box">
                <label for="admin">Login as Admin</label>
            </div>
            
         
        <div class="selection">
            <button type="submit" id="submitbtn" >Login</button>
         <button  type="buton" id ="forget">Forgot password?</button>
        </div>
        
        
    </div>
	</form>
    <script type="text/javascript" src="login_script.js"></script>
</body>
</html>