<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="user_addnew.css" type="text/css">
    <title>Document</title>
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
    <form action="user_addnew" method="post" onsubmit="return validation()" enctype="multipart/form-data">
    <div class="home">
    
        <div class="profile">
           
            <div class="account" >
            
                <img src="profilepic.png" id="pic">
                <p  style="color:white"><%=name %></p>
                <button id="changepassword" type="button">Change Password</button>
                <button id="delete" type="button">Delete Account</button>
                <button id="logout" type="button">Log Out</button>
                
            </div>
        </div>
        

        <div class="content">
            <div class="dialogcontent">
                <span class="cross">&times;</span>
                <h2>Add new image</h2>
                <input type="file" id="newimage" accept="image/*" name="image"">
                <p>Name</p>
                <input type="text" id="imagename" placeholder="without extension" name="imageName">
                <p>Tags</p>
                <input type="text" id="tags" placeholder="enter tags (comma separated)" name="tags">
                <p>Description</p>
                <textarea id="description" maxlength="500" placeholder="Add a description for the image (max 500 characters)" name="description" ></textarea>
                <p>Char count :<span id="count" >0</span>/500</p>
                <button id="addnew">ADD</button>
            </div>
       
    
      </div>
        
    </div>
    
    </form>
    
    <script type="text/javascript" src="user_addNew.js"></script>
</body>
</html>






            
            
                
                