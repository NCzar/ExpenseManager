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

    <title>Password not matching </title>
    
        <link rel="stylesheet" href="css/home.css">
    </head>
<body>

    
    
    <form id="myform" action="Sendpassword" method="POST"  >
        <div id="img1">
    <img src="images/home/logo1.jpg" alt="logo" style=" width:80%"> 
        </div>
        <div id="main">
            <h3> Password does not match the one we have in record </h3><br>
            <h4> If you do not have an account please register </h4> 
            <input type="button" name="back" value ="Register" style="height:30px;width:40%;max-width:150px " onclick="document.location.href='register.jsp'" > <br></br><br>
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
