<%-- 
    Document   : transactions
    Created on : Mar 1, 2016, 9:37:25 AM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Page</title>
    </head>
    <body>
        <img src="images/home/logo1.jpg"  style="width:200px;height:100px;">
        <p> User:
            <input type="text" name="youremail" value="<%= session.getAttribute("useremail")%>" readonly> <br> 
        <p> Your transaction has been submitted</p>
        
        <p>Please note the transaction number below </p>
        
<input type="text" name="approver" value="<%= session.getAttribute("myId")%>" readonly /> <br>
<br>
<form id="form1" action="Navigate" method="POST">
<input type="submit" value="Back to Submission Page" name="expense" />
</form>
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