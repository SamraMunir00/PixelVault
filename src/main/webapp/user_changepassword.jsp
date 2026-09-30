<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="user_changepassword.css">
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
<form action ="user_changepassword_servlet" method="post" onsubmit="return validation()">
    <div class="home">
    
        <div class="profile">
           
            <div class="account" >
            
                <img src="profilepic.png" id="pic">
                 <p  style="color:white"><%=name %></p>
                <button id="del" type="button">Delete Account</button>
                <button id="logout" type="button">Log Out</button>
                
            </div>
        </div>
        <div class="content">
         <h2>Welcome to Personal Portfolio</h2>
            <div class="dialogcontent">
                <span class="cross">&times;</span>
                <h2>Change password</h2>
                <p>Enter current passwprd</p>
                <input type="password" name="current" id="current">
                <p>Enter new password</p>
                <input type="password" name="new" id="new">
                <p>Enter new password again</p>
                <input type="password" name="confirm" id="confirm">
                <div class="searching">
            <button type="submit" id ="change" >Change </button>
            </div>
            </div>
            
            
            
        </div>
        
    </div>
    

</form>


<script type="text/javascript" src="user_changepassword.js"></script>
</body>
</html>
