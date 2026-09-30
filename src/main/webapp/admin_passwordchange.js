
const Logout=document.querySelector("#logout");
const Cross=document.querySelector(".cross");

const Current=document.querySelector("#current");
const New=document.querySelector("#new");
const Confirm=document.querySelector("#confirm");


Cross.addEventListener('click',()=>{
   window.location.href="admin_home.jsp";
})


Logout.addEventListener('click',()=>{
    window.location.href="admin_logout";
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
    console.log("checking name")

    if(check(Current,"*Enter current password")){
															if(Current.value.length===8){
																																			if (check(New, "*Enter new  password")) {
																													
																																		        if (New.value.length === 8) {
																																										if(Current.value!==New.value){
																																							
																																												            if (check(Confirm, "*enter new password again")) {
																																												
																																																								                if (New.value !== Confirm.value) {
																																																								                    Confirm.value = "";
																																																								                    Confirm.placeholder = "password not match";
																																																								                    Confirm.classList.add('red-placeholder');
																																																								                    return false;
																																																								                }
																																															} else {
																																																								
																																																	Confirm.value = "";
																																																	 Confirm.placeholder = "password not match";
																																																	 Confirm.classList.add('red-placeholder');
																																																	return false;
																																														}
																																												
																																												        } else {
																																															New.value = "";
																																												            New.placeholder = "it should not be curreent password";
																																												            New.classList.add('red-placeholder');
																																												            Confirm.value = "";
																																												            Confirm.placeholder = "*enter password again";
																																												
																																												            return false;
																																												           
																																												        }
																																		
																																		
																																		    } else {
																																				
																																		             					New.value = "";
																																							            New.placeholder = "it must be 8 char long";
																																							            New.classList.add('red-placeholder');
																																							            Confirm.value = "";
																																							            Confirm.placeholder = "enter password again";
																																							
																																							            return false;
																																		       
																																		    }
																													    }else{
																															
																															 Confirm.value = "";
																													       Confirm.placeholder = "password not match";
																													        Confirm.classList.add('red-placeholder');
																													        return false;
																													        }
														
													
															}else{
																
															Current.value = "";
												       		Current.placeholder = "*must not same as current";
												        	Current.classList.add('red-placeholder');
												        	Confirm.value = "";
															Confirm.placeholder = "password not match";
														Confirm.classList.add('red-placeholder');
														return false;
												        		
												        
															}
	}else{
		
		
		Current.value = "";
		Current.placeholder = "*enter current password";
		Current.classList.add('red-placeholder');
		return false;
	}
    
    return true;
}
