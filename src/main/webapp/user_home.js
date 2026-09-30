



const view=document.querySelector("#view");
const search=document.querySelector("#search");
const add=document.querySelector("#add");
const changepassword=document.querySelector("#changepassword");
const logout=document.querySelector("#logout");
const deletebtn=document.querySelector("#delete");

        
  
    
    
    logout.addEventListener('click',()=>{
            window.location.href="user_logout_servlet";
    })
        
    add.addEventListener('click',()=>{
        console.log("add clicked");
        window.location.href="user_addnew.jsp";
        
    })
 changepassword.addEventListener('click',()=>{
        
        window.location.href="user_changepassword.jsp";
        
    })
	
	search.addEventListener('click',()=>{
        
        window.location.href="user_search.jsp";
        
    })
    view.addEventListener('click',()=>{
        
        window.location.href="user_view_servlet";
        
    })
  deletebtn.addEventListener('click',()=>{
        
        window.location.href="user_delaccount.jsp";
        
    })