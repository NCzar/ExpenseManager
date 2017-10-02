<%-- 
    Document   : register
    Created on : Mar 6, 2016, 10:43:23 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/> 

    <title>Username already exists</title>
    
        <link rel="stylesheet" href="css/home.css">
    </head>
<body>

    
    
    <form id="myform" action="Sendpassword" method="POST" >
        <div id="img1">
    <img src="images/home/logo1.jpg" alt="logo" style=" width:80%"> 
        </div>
        <div id="main">
            <h3> Username already exists.Please choose a different email address as username  </h3><br>
            <h4> Please go to Login page to sign in with your credentials </h4> 
    <input type="button" name="back" value ="Login" style="height:30px;width:40%;max-width:150px " onclick="document.location.href='index.html'" > <br>
            <h4> Go back to Admin Registration Page </h4> 
    <input type="button" name="admin" value ="Admin Registration" style="height:30px;width:40%;max-width:150px " onclick="document.location.href='adminregister.jsp'" > <br>
             <h4> Go back to non-admin Registration Page </h4> 
    <input type="button" name="nonadmin" value ="Non-admin Registration" style="height:30px;width:40%;max-width:150px " onclick="document.location.href='register.jsp'" > <br>
   
    <h4> If you have forgotten your password click below to send password to registered email address </h4> 
    <input type="Submit" name="passwordsend" value ="Send Password" style="height:30px;width:40%;max-width:150px"  > <br>
  
    </div>   
<script type="text/javascript">
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/56ba95f4496019e65d7929f3/default';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script> 
    </form>
    
</body>
</html>
