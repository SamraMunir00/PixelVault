
const Cross=document.querySelector(".cross");
 const changepassword=document.querySelector("#changepassword");
const logout=document.querySelector("#logout");
const deletebtn=document.querySelector("#delete");	
              
  
Cross.addEventListener('click', () => {
	console.log("c pressed")
            window.location.href="user_home.jsp";
});


 logout.addEventListener('click',()=>{
	console.log("logout pressed")
            window.location.href="user_logout_servlet";
    })
  
 changepassword.addEventListener('click',()=>{
        console.log("chng pressed")
        window.location.href="user_changepassword.jsp";
        
    })

  deletebtn.addEventListener('click',()=>{
        console.log("del pressed")
        window.location.href="user_delaccount.jsp";
        
    })
    
 const Desc=document.querySelector("#description");
  const Count=document.querySelector("#count");
 Desc.addEventListener('input',()=>{
	console.log("input");
	Count.textContent=Desc.value.length;
 })   
function validation(){
    Named=document.querySelector("#imagename").value;
	Tag=document.querySelector("#tags").value;
	

	Image=document.querySelector("#newimage").files[0];
            
                    if(!Image || !Named || !Tag || !Desc.value){
                        console.log("not filled")
                        alert("Please fill all fields")
                        return false;
                    }else{
							console.log("tags");
						if(Tag.split(",").length >3){
							console.log("tags >3");
							alert("tags can not be more than 3")
                        			return false;
						}else{
							console.log("tags <3");
							return true;
						}
                            
                        }
}