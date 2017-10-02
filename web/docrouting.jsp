<%-- 
    Document   : docrouting
    Created on : Jun 7, 2016, 4:19:35 AM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"/> 
<title>Document Routing</title>
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="assets/css/custom.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
    
    <!-- Login container -->
    <div class="col-lg-5 col-lg-offset-1 mg-top-20">
        <div class="col-lg-8">
            <form id="myform">
                 <input type="text" name="name" style="border:none" value="<%= session.getAttribute("username")%>" readonly>
                 <input type="button" name="back" value ="Logout" style="height:10%;" onclick="document.location.href='index.html'" > <br></br>

   
                <h4>Next Action</h4><br>
               
                <div class="btn-group-vertical" role="group" aria-label="Next Action">
                    <button type="button" class="btn btn-secondary" style="height:50px" onclick="document.location.href='uploadimage.jsp'">Upload document</button><br>
                    <button type="button" class="btn btn-secondary" style="height:50px" onclick="document.location.href='formentry.jsp'">Proceed to forms</button><br>
                    <button type="button" class="btn btn-secondary" style="height:50px" onclick="document.location.href='transactions.jsp'">Skip to next step</button>
                </div>
            </form>
        </div>
    </div>
    <!-- /Login container -->
    <div class="col-lg-6 mg-top-20">
        <img src="assets/images/logo.jpg" class="img-circle" alt="inspired living logo" width="600" />
    </div>
    <div class="navbar navbar-default navbar-fixed-bottom">
        <div class="container">
            <p class="navbar-text">
                <a class="link" href="http://www.docuwind.com">Docuwind</a>
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
    </script>
    <!-- chat script -->   
</body>
</html>

