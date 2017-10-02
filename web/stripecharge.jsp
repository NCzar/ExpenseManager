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

    <title>Recharge Balance</title>
    
        <link rel="stylesheet" href="css/home.css">
    </head>
<body>

    
    
    <form id="myform" action="RechargeBalance" method="POST" >
        <div id="img1">
    <img src="images/home/logo1.jpg" alt="logo" style=" width:20%"> 
        </div>
        <div id="main">
            <h3> Recharge Stripe Balance </h3>
    <h4> Amount* </h4>
    <input type="text" name="amount" required > <br>

<h4> Stripe API Key  </h4>
<input type="text" name="apikey" value="<%= session.getAttribute("adminkey")%>" > <br></br><br>

        <div id="submit">   
       <input type="submit" name="Go" value="Add Money" style="height:25px;width:40%;max-width:150px">
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
