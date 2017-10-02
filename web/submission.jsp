<%-- 
    Document   : submission
    Created on : Mar 2, 2016, 2:49:44 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1"/> 

    
        <link rel="stylesheet" href="css/home.css">
<title>Expense Submission</title>
</head>
<body>
    <div id="img1" >
<img src="images/home/logo1.jpg" style="width:80%">
    </div>

    <form name="myform" action="Getapproval" method="POST">
        <div id="main"
             <p><b>User:</b> <input type="text" name="youremail" style="border:none;font-weight:bold;" value="<%= session.getAttribute("useremail")%>" readonly> 
<input type="button" name="back" value ="Logout" style="height:10%;width:10%;max-width:95px " onclick="document.location.href='index.html'" > <br>

 </br> 
<input type="button" value="Trip Recorder" name="gettrip" style="height:10%;width:50%;max-width:150px" onclick="document.location.href='tripregister.jsp'" /> &nbsp;
<input type="button" value="My Submissions" name="gettrans" style="height:10%;width:40%;max-width:150px " onclick="document.location.href='allsubmissions.jsp'" /> <br> 
<br> 
<input type="button" value="Rejected Submissions" name="rejected" style="height:10%;width:40%;max-width:150px " onclick="document.location.href='rejected.jsp'" /> &nbsp; 
<input type="button" value="Approved Submissions" name="approved" style="height:10%;width:40%;max-width:150px " onclick="document.location.href='approved.jsp'" /> <br> 
<br>
<input type="button" value="Pending for Approval" name="pending" style="height:10%;width:40%;max-width:150px " onclick="document.location.href='pending.jsp'" /> &nbsp; 
<input type="button" value="My Account" name="account" style="height:10%;width:40%;max-width:150px " onclick="document.location.href='account.jsp'" /> 


            <div align="left"><br>
    <input type="text" name="name" value="<%= session.getAttribute("username")%>" readonly hidden> <br>
    <p> Approver/Re-assigner email address* </p> 
<input type="text" name="manageremail" value="<%= session.getAttribute("manageremail")%>" required> <br>
<p> Enter description(Travel,Rent,form)*</p>
<input type="text" name="detail" required > <br>

<h5> If submitting expense </h5>
    <p> Enter amount </p>
<input type="text" name="expense" > <br>


 <br>

<input type="submit" name="getinfo" value="Proceed to Next Step" /><br></br>
</div>
 <br /> 
 </div>
</form>


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
</body>
</html>
