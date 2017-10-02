<%-- 
    Document   : imagelogin
    Created on : Jun 11, 2016, 9:54:45 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"/> 
<title>Image Viewing Login</title>
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="assets/css/custom.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
    
    <!-- Login container -->
    <div class="col-lg-5 col-lg-offset-1 mg-top-20">
        <div class="col-lg-8">
            <form id="myform" action="ValidateCredentials" method="POST">
               <h4>Please login and then click document link</h4><br></br>
                <!-- Email -->
                <div class="form-group">
                  <label for="submitteremail">Email address</label>
                  <input type="email" class="form-control" name="submitteremail" placeholder="Email">
                </div>
                <!-- /Email -->
                <!-- Password -->
                <div class="form-group">
                  <label for="passcode">Password</label>
                  <input type="password" class="form-control" name="passcode" placeholder="Password">
                </div>
                <!-- /Password -->
                <button type="submit" class="btn btn-primary">Login</button>
                <p></p>
                <div class="form-group">
                    <a class="link" href="register.jsp" >Don't have an account? Register here</a>
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