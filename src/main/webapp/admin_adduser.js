


const Logout=document.querySelector("#logout");
const Cross=document.querySelector(".cross");
const change=document.querySelector("#passwordchange");
const gmail=document.querySelector("#user");
const password=document.querySelector("#new");
const confirmp=document.querySelector("#confirm");


Cross.addEventListener('click',()=>{
   window.location.href="admin_home.jsp";
})


Logout.addEventListener('click',()=>{
    window.location.href="admin_logout";
})

change.addEventListener('click',()=>{
    window.location.href="admi_passwordchange.jsp";
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
    console.log("checking gamil")

    if (check(gmail, "Enter gmail*")) {
        if (!emailValidation(gmail)) {
            console.log("validating...")
            gmail.value = "";
            gmail.placeholder = "*enter valid email";
            gmail.classList.add('red-placeholder');

            return false;
        } else {
            gmail.classList.remove('red-placeholder');
        }
    } else {
        return false;
    }


    console.log("checking gpss")
    if (check(password, "Enter password*")) {

        if (password.value.length === 8) {

            if (check(confirmp, "enter password again*")) {

                if (password.value !== confirmp.value) {
                    confirmp.value = "";
                    confirmp.placeholder = "password not match";
                    confirmp.classList.add('red-placeholder');
                    return false;
                }
            } else {

                confirmp.value = "";
                confirmp.placeholder = "password not match";
                confirmp.classList.add('red-placeholder');
                return false;
            }

        } else {
            password.value = "";
            password.placeholder = "it must be 8 char long";
            password.classList.add('red-placeholder');
            confirmp.value = "";
            confirmp.placeholder = "enter password again";

            return false;
        }


    } else {
        confirmp.value = "";
        confirmp.placeholder = "password not match";
        confirmp.classList.add('red-placeholder');
        return false;
    }
    return true;
}