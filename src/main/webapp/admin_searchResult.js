
const Logout=document.querySelector("#logout");
const Change=document.querySelector("#changepassword")
const back=document.querySelector("#GoBack");

const del=document.querySelector("#del");
const changeData=document.querySelectorAll("#change");

Change.addEventListener('click',()=>{
	
   window.location.href="admi_passwordchange.jsp";
})


Logout.addEventListener('click',()=>{
    window.location.href="admin_logout";
})

back.addEventListener('click',()=>{
    window.location.href="admin_home.jsp";
})

del.addEventListener('click',()=>{
    window.location.href="admin_del_servlet";
})


