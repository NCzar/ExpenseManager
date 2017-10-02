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

    <title>Admin Registration</title>
    
        <link rel="stylesheet" href="css/home.css">
    </head>
<body>

    
    
    <form id="myform" action="AdminRegistration" method="POST">
        <div id="img1">
    <img src="images/home/logo1.jpg" alt="logo" style="width:80%"> 
        </div>
        <div id="main">
            <h3> Registration Page </h3>
            
    <h4> Organization Name* </h4>
    <input type="text" name="orgname" required > <br>
    
    <h4> Address </h4>
    <input type="text" name="address"  > <br>
    
    <h4> Organization Stripe Key </h4>
    <input type="text" name="stripekey" > <br>

<h4> Admin Name </h4>
<input type="text" name="adminname"  > <br>

<h4> Admin Email* </h4>
<input type="text" name="adminemail" required > <br>
 
<h4> Password* </h4>
<input type="password" name="password" required> <br>

<h4> Country </h4>
<input type="text" name="country"> <br>

<h4> Phone No  </h4>
<input type="text" name="phoneno"> <br>
    
<h4> Admin's Account Number  </h4>
<input type="text" name="accountno"  > 
<h4> Admin's Routing Number  </h4>
<input type="text" name="routingno"  > 

</br></br>

        <div id="submit">   
       <input type="submit" name="Go" value="Register" style="height:25px;width:40%;max-width:170px">
        </div>
<br></br>
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
