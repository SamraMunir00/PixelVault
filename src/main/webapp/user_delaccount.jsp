<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user delete account</title>
<link rel="stylesheet" href="user_delaccount.css">
</head>
<body>
	
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
<form action ="user_delaccount" method="post" onsubmit="return validation()">
    <div class="home">
    
        <div class="profile">
           
            <div class="account" >
            
                <img src="profilepic.png" id="pic">
                 <p  style="color:white"><%=name %></p>
                <button id="changepassword" type="button">Change Password</button>
                
                <button id="logout"  type="buton">Log Out</button>
                
            </div>
        </div>
        <div class="content">
         <h2>Welcome to Personal Portfolio</h2>
            <div class="dialogcontent">
                <span class="cross">&times;</span>
                <h2>Delete Account permanently</h2>
                <p>Enter your password</p>
                <input type="password" name="pass" id="current">
                <div class="searching">
            <button type="submit" id ="change" >Delete </button>
            </div>
            </div>
            
            
            
        </div>
        
    </div>
    

</form>

<script type="text/javascript"  src="user_delAccount.js"></script>
</body>
</html>