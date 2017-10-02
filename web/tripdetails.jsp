<%-- 
    Document   : geoloc
    Created on : Feb 27, 2016, 10:31:34 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta name="viewport" content="width=device-width, initial-scale=1"/> 
    <meta http-equiv="refresh" content="60" />  
   
    
        <link rel="stylesheet" href="css/home.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>    
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

</head>
<body >
    <div id="img1">
    <img src="images/home/logo1.jpg"  style="width:80%;">
    </div>
    <div id="main">
    <form name="myform">
        <h4> Your Trip details </h4>
   
        <br>
     <h5> Origin Address </h5>
     <input id="originatt" type="text" style="width:80%;max-width:400px"  value="<%=session.getAttribute("originaddress")%>"  >
     <h5> Destination Address </h5>
     <input id="destatt" type="text"  style="width:80%;max-width:400px"  value="<%=session.getAttribute("destinationaddress")%>"  >
     <h5> Distance traveled</h5>
     <input id="distance" type="text"   value="<%=session.getAttribute("distance")%>"  ><br><br>
     
    


    </form>
     <br>
     
            <input type="button" value="Back to Trip Recorder Page" name="back" onclick="document.location.href='navigator.jsp'" /> <br> <br/>
       
         </div>
</body>
</html>

