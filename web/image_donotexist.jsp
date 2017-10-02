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

    <title>Document do not exist </title>
    
        <link rel="stylesheet" href="css/home.css">
    </head>
<body>

    
    
    <form id="myform" >
        <div id="img1">
    <img src="images/home/logo1.jpg" alt="logo" style=" width:80%"> 
        </div>
        <div id="main">
            <h3> Sorry..we could not find a document with that transaction number  </h3><br>
         
            <input type="button" name="back" value ="Back" style="height:30px;width:40%;max-width:150px " onclick="goBack()" > <br></br></br>
     
            Please visit <A HREF = "http://www.docuwind.com/">Docuwind</A> and log in to view documents
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
<script type="text/javascript">
function goBack() { window.history.back(); }
</script> 
    </form>
    
</body>
</html>
