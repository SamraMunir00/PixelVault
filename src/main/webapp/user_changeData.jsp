<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*,java.util.*" %>
    <%@ page import="java.util.*, classPackage.userData" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>change user data</title>
<link rel="stylesheet" href="user_changeData.css">

</head>
<body>


<%
	boolean  redirected=false;
%>
<%if(!redirected){
	String type=(String)session.getAttribute("type");
				
				 if(type!=null) {
					 
					 
				      if(type.equals("admin")) {
				    	 
				    	  redirected=true;
				    	  out.println("<html><body>");
			                out.println("<script type='text/javascript'>");
			                out.println("alert('access denied');");
			                out.println("window.location = 'index.jsp';");
			                out.println("</script>");
			                out.println("</body></html>");
				      }
					 
			      }else{
			    	 
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
                <button id="delete" type="buton" >Delete Account</button>
                <button id="logout" type="button">Log Out</button>
                
            </div>
        </div>
        
        
        <div class="content">
        <div class="dialogcontent">
        <span class="cross">&times;</span>
         <h2>Update Data</h2>
         <form action="user_change_servlet" method="post" onsubmit="return validation()">
         			
         			
         			<% 

    
	ArrayList <userData> userData =(ArrayList<userData>)request.getAttribute("userData");
	
	if(userData!=null){
		for(userData u :userData){
			String path="userData/"+u.getfile();
			
		
	%>
					<img id="picData" src="<%=path%>"  alt="image">
					
         			<input id="file" type ="hidden" name="id" value="<%= u.getfile() %>" readonly>
         			<p >File_name</p>
         			<input id="file_name"type ="text" name="file_name" value="<%=u.getfile() %>"readonly>
         			<p >Image_name</p>
         			<input id="name" type ="text" name="name" value="<%=u.getName() %>">
         			<p >tags</p>
         			<input id="tags" type ="text" name="tags" value="<%=u.gettags() %>">
         			<p >Description</p>
         			<textarea maxlength="500" id="desc" type ="text"  name="desc"><%=u.getdesc() %> </textarea>
         			<p>Char count :<span id="count" >0</span>/500</p>
         	<%
         	}
         	}%>		
         			
         
		
		<button type ="submit" id="change" type="submit"> Submit Changes</button>
         </form>
           </div> 
            
        </div>
        
    </div>
    


    <script type="text/javascript" src="user_changeData.js"></script>
</body>
</html>
