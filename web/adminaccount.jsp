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

    <title>Edit Admin Account</title>
    
        <link rel="stylesheet" href="css/home.css">
    </head>
<body>

  
 </br> 
    
    <form id="myform" action="UpdateCredentials" method="GET" >
        <div id="img1">
    <img src="images/home/logo1.jpg" alt="logo" style=" width:80%"> 
        </div>
        <div id="main"> 
            
            <input type="button" name="back" value ="Click to Add Stripe Balance" style="height:10%;width:40%;max-width:190px " onclick="document.location.href='stripecharge.jsp'" > <br>

            
            <h4> Edit Admin Account Details </h3>
   
<h5> Name </h5>
<input type="text" name="fullname" value="<%= session.getAttribute("adminname")%>"  > <br>

<h5> Stripe Key </h5>
<input type="text" name="key" value="<%= session.getAttribute("adminkey")%>" > 

<h5> Address </h5>
<input type="text" name="address" value="<%= session.getAttribute("adminaddress")%>" > <br>

<h5> Organization </h5>
<input type="text" name="organization" value="<%= session.getAttribute("adminorg")%>" > <br></br>

<h5> Phone No </h5>
<input type="text" name="phone" value="<%= session.getAttribute("adminphone")%>" > <br>

<h5> Country </h5>
<input type="text" name="country" value="<%= session.getAttribute("admincountry")%>" > <br></br>

        <div id="submit">   
       <input type="submit" name="Go" value="Submit Changes" style="height:25px;width:40%;max-width:150px">
        </div>
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
