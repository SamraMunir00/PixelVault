

const Logout=document.querySelector("#logout");
const Password=document.querySelector("#changepassword");
const user=document.querySelector("#user")
const pass=document.querySelector("#pass")
const fileN=document.querySelector("#file_name")
const named=document.querySelector("#name")
const tags=document.querySelector("#tags")
const desc=document.querySelector("#desc")
const Cross=document.querySelector(".cross");
console.log("script running ")
console.log(user ,pass,fileN,name);

Logout.addEventListener('click',()=>{
    window.location.href="admin_logout";
})

Password.addEventListener('click',()=>{
	console.log("passowrd chaneg clicked");
   window.location.href="admi_passwordchange.jsp";
})
Cross.addEventListener('click',()=>{
	alert("going back without changing!!!")
   window.location.href="admin_viewuser_servlet";
})
console.log("got events ")





 const Count=document.querySelector("#count");
 Count.textContent=desc.value.length;
 desc.addEventListener('input',()=>{
	console.log("input");
	Count.textContent=desc.value.length;
 }) 
 
 
function validation(){

	console.log("validating")
	
	
	
			 if( !named.value || !tags.value || !desc.value){
				
				
                     
                        alert("Please fill all fields")
                        return false;
             }else{
						if(tags.value.split(",").length >3){
							console.log("tags >3");
							alert("tags can not be more than 3")
                        			return false;
						}else{
							console.log("tags <3");
							return true;}
			}
                            
                        
			
		
		
		
		
		
	
	
	
}