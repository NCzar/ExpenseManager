<%-- 
    Document   : transactions
    Created on : Mar 1, 2016, 9:37:25 AM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"/> 
<title>Transaction Confirmation</title>
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="assets/css/custom.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
    
    <!-- Login container -->
    <div class="col-lg-5 col-lg-offset-1 mg-top-20">
        <div class="col-lg-8">
            <form id="myform">
                <h4>Transaction Confirmation</h4><br></br>
                <p> User:
            <input type="text" name="yourname" style="border:none" value="<%= session.getAttribute("username")%>" readonly> <br> 
        <p> Your transaction has been submitted</p>        
        <p>Please note the transaction number below </p>
        
        <input type="text" name="approver" value="<%= session.getAttribute("myId")%>" readonly /> <br></br>
                <div class="btn-group-vertical" role="group" aria-label="Next Action">
                    <button type="button" class="btn btn-secondary" style="height:30px" onclick="document.location.href='uploadimage.jsp'">Upload another document</button><br>
                    <button type="button" class="btn btn-secondary" style="height:30px" onclick="document.location.href='formentry.jsp'">Submit another form</button><br>
                    <button type="button" class="btn btn-secondary" style="height:30px" onclick="document.location.href='submission.jsp'">Back to Submissions</button><br>
                    <button type="button" class="btn btn-secondary" style="height:30px" onclick="document.location.href='index.html'">Logout</button><br>
              
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
<script type="text/javascript">
    var dictionary = {"data":[{"id":"0","name":"ABC"},{"id":"1", "name":"DEF"}], "images": [{"id":"0","name":"PQR"},{"id":"1","name":"xyz"}]};

for (item in dictionary) {
  for (subItem in dictionary[item]) {
     console.log(dictionary[item][subItem]);
  }
}
    </script>