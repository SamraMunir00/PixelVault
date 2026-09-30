
const Logout=document.querySelector("#logout");
const Cross=document.querySelector(".cross");
const change=document.querySelector("#changepassword")
const Current=document.querySelector("#current");

console.log("del")
changepassword.addEventListener('click',()=>{
   window.location.href="user_changepassword.jsp";
})
 
Cross.addEventListener('click',()=>{
   window.location.href="user_home.jsp";
})


Logout.addEventListener('click',()=>{
    window.location.href="user_logout_servlet";
})



function check(input,msg){
    console.log("checking")
    if(input.value===""){
        console.log(input ,"empty")
        input.placeholder=msg;
        input.classList.add('red-placeholder');
        return false;
    }
    return true;
}



function validation() {
    if (!check(Current,"*enter current password")){
		return false;
	}else{
		if(Current.value.length===8){
			return true;
		}else{
			Current.value="";
			Current.placeholder="'*must be 8 char long";
       		 Current.classList.add('red-placeholder');
       		 return false;
		}
	}
	
	
	
   
}

