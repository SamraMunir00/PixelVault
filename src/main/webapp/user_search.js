
Search=document.querySelector("#search");
Logout=document.querySelector("#logout");
Password=document.querySelector("#changepassword");
pname=document.querySelector("#name")
tags=document.querySelector("#tags")
Cross=document.querySelector(".cross");

Cross.addEventListener('click',()=>{
   window.location.href="user_home.jsp";
})


Logout.addEventListener('click',()=>{
    window.location.href="user_logout_servlet";
})

Password.addEventListener('click',()=>{
   window.location.href="user_passwordchange.jsp";
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
   
    
    if(x.indexOf('@') > 0 ){
		 at=x.indexOf('@')
        s1=x.substring(0,at+1);
        s2=x.substring(at+2,x.length)
        dot=x.indexOf('.',at+1);
        if(dot > at+1){
            console.log(x.indexOf('.'))
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
function validation() {
    console.log("checking name")

    if (!check(pname, "*Enter name")) {
		return false;
        }

    
    return true;
}






