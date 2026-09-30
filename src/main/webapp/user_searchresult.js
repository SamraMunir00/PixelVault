




const changepassword=document.querySelector("#changepassword");
const logout=document.querySelector("#logout");
const deletebtn=document.querySelector("#delete");
const back=document.querySelector("#GoBack");
const delData=document.querySelectorAll("#del");
const changeData=document.querySelectorAll("#change");        


 back.addEventListener('click',()=>{
	console.log("backere");
            window.location.href="user_home.jsp";
    })  
    
    logout.addEventListener('click',()=>{
            window.location.href="user_logout_servlet";
    })
        
    
 changepassword.addEventListener('click',()=>{
        
        window.location.href="user_changepassword.jsp";
        
    })
	
	
  deletebtn.addEventListener('click',()=>{
        
        window.location.href="user_delaccount.jsp";
        
    })