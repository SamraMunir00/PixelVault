document.addEventListener("DOMContentLoaded", function() {

const Deluser=document.querySelector("#deluser");
const Searchuser=document.querySelector("#searchuser");
const Adduser=document.querySelector("#adduser");
const Viewuser=document.querySelector("#viewuser");
const Logout=document.querySelector("#logout");
const Password=document.querySelector("#changepassword");
console.log("script running ")


console.log("heheh");
Logout.addEventListener('click',()=>{
	//alert("redirecting");
   window.location.href="admin_logout";
})

Password.addEventListener('click',()=>{
	console.log("passowrd chaneg clicked");
   window.location.href="admi_passwordchange.jsp";
})

Viewuser.addEventListener('click',()=>{
    window.location.href="admin_viewuser_servlet";
 })
Searchuser.addEventListener('click',()=>{
    window.location.href="admin_searchuser.jsp";
 })
 
 
 Deluser.addEventListener('click',()=>{
    window.location.href="admin_deluser.jsp";
 })
 
 
 Adduser.addEventListener('click',()=>{
    window.location.href="admin_adduser.jsp";
 })


});

