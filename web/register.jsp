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

    <title>Registration</title>
    
        <link rel="stylesheet" href="css/home.css">
    </head>
<body>

    
    
    <form id="myform" action="ValidateCredentials" method="GET" >
        <div id="img1">
    <img src="images/home/logo1.jpg" alt="logo" style=" width:80%"> 
        </div>
        <div id="main">
            <h3> Registration Page </h3>
            <a class="link" href="adminregister.jsp" >If you are an Organization Admin Click here</a>
    <h4> Email Address* </h4>
    <input type="text" name="registeremail" required > <br>


<h4> Full Name* </h4>
<input type="text" name="fullname" required > <br>

  
<h4> Password* </h4>
<input type="password" name="password" required> <br>


<h4> Level </h4>

<select name="level" onfocus="this.select()" type="text">
  <option value="Level 1">Level 1</option>
  <option value="Level 2">Level 2</option>
  <option value="Level 3">Level 3</option>
  <option value="Level 4">Level 4</option>
</select><br>

<h4> Manager's email </h4>
<input type="text" name="manageremail"  > 
<h4> Organization  </h4>
<input type="text" name="organization"  > 
<h4> Account Number  </h4>
<input type="text" name="accountno"  > 
<h4> Routing Number  </h4>
<input type="text" name="routingno"  > 
<br></br>

        <div id="submit">   
       <input type="submit" name="Go" value="Register" style="height:25px;width:40%;max-width:150px">
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
