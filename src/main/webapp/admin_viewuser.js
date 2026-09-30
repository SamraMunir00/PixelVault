console.log("heeh")
const Logout=document.querySelector("#logout");
const Change=document.querySelector("#changepassword")
const back=document.querySelector("#GoBack");
const del=document.querySelectorAll("#del");
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
/*
changeData.forEach(btn=>{
	btn.addEventListener('click',()=>{
	console.log("schng clikced");
    window.location.href="admin_changerequest";
})
})

del.forEach(b=>{
	b.addEventListener('click',()=>{
	console.log("schng clikced");
    window.location.href="admin_del_servlet";
})
})

*/
