<%-- 
    Document   : tripregister
    Created on : May 21, 2016, 2:06:22 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"/> 
<title>Trip Registration</title>
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="assets/css/custom.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
    
    <!-- Login container -->
    <div class="col-lg-5 col-lg-offset-1 mg-top-20">
        <div class="col-lg-8">
            <form id="myform" action="NavAddress" method="POST">
               <h4>Enter email to get Location</h4><br></br>
                <!-- Email -->
                <div class="form-group">
                  <label for="submitteremail">Email</label>
                  <input type="email" class="form-control" name="submitteremail"  placeholder="Email">
                  
                </div>
                <!-- /Email -->
                <label for="address">Most Recent Location</label>
                  <input type="text"  class="form-control" name="address" placeholder="Location" value="<%= request.getAttribute("address")%>">
                  <button type="submit"  id="s1" hidden></button> <br></br>
                <button type="button" class="btn btn-primary" onclick="getLocation()">Get Location</button> &nbsp;&nbsp;
                <button type="button" class="btn btn-primary" onclick="document.location.href='https://www.docuwind.com'">Back</button><br></br>
                <p id="demo"></p>
                <p></p>
                
            </form>
        </div>
    </div>
    <!-- /Login container -->
    <div class="col-lg-6 mg-top-20">
        <img src="assets/images/logo1.jpg" class="img-circle" alt="inspired living logo" width="300" />
    </div>
    <div class="navbar navbar-default navbar-fixed-bottom">
        <div class="container">
            <p class="navbar-text">
                <a class="link" href="http://www.inspiredliving.company">Inspired Living</a>
            </p>
        </div>
    </div>
    <!-- chat script -->  
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
  

function getLocation()
  {
 document.getElementById("s1").click();
  }

</script>
    <!-- chat script -->   
</body>
</html>
