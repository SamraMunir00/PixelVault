login=document.querySelector("#login");
reg=document.querySelector("#reg")
submitbtn=document.querySelector("#submitbtn")
forget=document.querySelector("#forget")
username=document.querySelector("#username")
password=document.querySelector("#password")
regbtn=document.querySelector("#reg");
form=document.querySelector("#formlogin")
checkbox=document.querySelector("#admin")


regbtn.addEventListener('click',()=>{
	console.log("move to registr")
	window.location.href='reg.jsp';
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

function emailValidation(element){
    x=element.value;
    at=x.indexOf('@')
    
    if(at > 0 ){
        s1=x.substring(0,at+1);
        s2=x.substring(at+2,x.length)
        dot=x.indexOf('.',at+1);
        if(dot > at+1){
            
            return true;
        }
        else{
            return false;
        }
    }
    else{
        return false;
    }

}
function validation(){
	
    if(check(username,"*enter usernmae ")){
		if(!emailValidation(username)){
			username.value=""
			username.placeholder="*enter valid email";
        	username.classList.add('red-placeholder');
			return false;
		}
		
	}
	else{
		return false;
	}
	
    if(!check(password,"*enter password")){
        return false;
 	}
 	
 	return true;
}
  
  
   
submitbtn.addEventListener('click',(event)=>{
	console.log("submitted")
	event.preventDefault();
	if(validation()){
		if (checkbox.checked){
			console.log("redirecting the page")
			form.action="admin_login_servlet"
			console.log(form.action);
		}
		else{
			console.log("normal user")
			form.action="loginservlet"
			console.log(form.action);
		}
		form.submit();
	}
})
