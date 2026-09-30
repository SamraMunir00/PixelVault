<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*,java.util.*" %>
    <%@ page import="java.util.*, classPackage.userExtended" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>change user data</title>
<link rel="stylesheet" href="admin_changeuser.css">

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
        <div class="dialogcontent">
        <span class="cross">&times;</span>
         <h2>Change User Data</h2>
         <form action="admin_changeUser_servlet" method="post" onsubmit="return validation()">
         			
         			
         			<% 

    
	ArrayList <userExtended> userData =(ArrayList<userExtended>)request.getAttribute("userData");
	
	
		

				if(userData!=null){
				for(userExtended u :userData){
				String path="userData/"+u.getFilename();


%>
		<img id="picData" src="<%=path %>" alt="image" readonly>
		<br>
		Username : <input id="file_name"type ="text" name="username" value="<%=u.getName() %>"readonly>
		<br> 
		Password : <input id="file" type ="text" name="password" value="<%= u.getPassword() %>" readonly>
		<br>
		Filename :<input id="file_name"type ="text" name="file_name" value="<%=u.getFilename() %>"readonly>
		<br>
		Image_name :<input id="name" type ="text" name="name" value="<%=u.getiName() %>">
		<br>
		<p >tags</p>
		<input id="tags" type ="text" name="tags" value="<%=u.getTags() %>">
		<p >Description</p>
		<textarea maxlength="500" id="desc" type ="text"  name="desc"><%=u.getDesc() %> </textarea>
		<p>Char count :<span id="count" >0</span>/500</p>
<%
}
}%>		
			
         
		
		<button type ="submit" id="change" type="submit"> Submit Changes</button>
         </form>
           </div> 
            
        </div>
        
    </div>
    


    <script type="text/javascript" src="admin_changeUser.js"></script>
</body>
</html>
