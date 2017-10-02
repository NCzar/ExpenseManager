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

    <title>Edit Account</title>
    
        <link rel="stylesheet" href="css/home.css">
    </head>
<body>

    
    
    <form id="myform" action="UpdateCredentials" method="POST" >
        <div id="img1">
    <img src="images/home/logo1.jpg" alt="logo" style=" width:80%"> 
        </div>
        <div id="main">
            <h4> Edit Account Details </h3>
   
<h5> Name </h5>
<input type="text" name="fullname" value="<%= session.getAttribute("username")%>"  > <br>

<h5> Manager's email </h5>
<input type="text" name="manageremail" value="<%= session.getAttribute("manageremail")%>" > 

<h5> Password </h5>
<input type="password" name="password" value="<%= session.getAttribute("password")%>" > <br>

<h5> Present Level </h5>
<input type="text" list="hierarchy" value="<%= session.getAttribute("level")%>" > 
<datalist id="hierarchy" onfocus="this.select()" >
  <option value="Level 1">
  <option value="Level 2">
  <option value="Level 3">
  <option value="level 4">

</datalist> 
change to
<select name="level" onfocus="this.select()" type="text"  >
  <option value="Level1">Level 1</option>
  <option value="Level2">Level 2</option>
  <option value="Level3">Level 3</option>
  <option value="Level4" selected >Level 4</option>
  
</select><br>

<h5> Organization </h5>
<input type="text" name="organization" value="<%= session.getAttribute("organization")%>" > <br></br>

<h5> Account Number </h5>
<input type="text" name="accountno" value="<%= session.getAttribute("accountno")%>" > <br></br>

<h5> Routing Number </h5>
<input type="text" name="routingno" value="<%= session.getAttribute("routingno")%>" > <br></br>

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
