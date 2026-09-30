<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="user_search.css">
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
<form action ="user_search_servlet" method="get" onsubmit="return validation()">
    <div class="home">
    
        <div class="profile">
           
            <div class="account" >
            
                <img src="profilepic.png" id="pic">
                <p  style="color:white"><%=name %></p>
                <button id="changepassword" type="button">Change Password</button>
                <button id="del" type="button">Delete Account</button>
                <button id="logout" type="button">Log Out</button>
                
            </div>
        </div>
        <div class="content">
         <h2>Welcome to Personal Portfolio</h2>
            <div class="dialogcontent">
                <span class="cross">&times;</span>
                <h2>Search Image</h2>
                <p>Enter image name</p>
                <input type="text" name="imagename" id="name">
                <p>Enter tags(optional)</p>
                <input type="text" name="tags" id="tags" placeholder="comma separated">
                <div class="searching">
            <button type="submit" id ="search" >Search </button>
            </div>
            </div>
            
            
            
        </div>
        
    </div>
    

</form>
    <script type="text/javascript" src="user_search.js"></script>
</body>
</html>
