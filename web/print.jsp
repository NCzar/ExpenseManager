<%-- 
    Document   : print
    Created on : Jan 17, 2016, 12:56:29 AM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JY Expense approval</title>

</head>
<body>
<form>
    <br></br>
    Origin:
      <input type="text" name="origination" value="<%= session.getAttribute("orig3")%>" /> <br><br/>
      <input type="text" name="origi" value="<%= session.getAttribute("originnew")%>" /> <br><br/>
     <input type="text" name="youremail" value="<%= session.getAttribute("useremail")%>"> <br>  
  <img id="u9_img" class="img " src="images/home/u23.png" />  
<div align="left"><br>
    <p> Your Expense has been submitted </p>
    <img src="http://www.w3schools.com/images/lamp.gif" alt="Lamp" width="15" height="15">
    <br></br>
    <img id="u8_img" class="img " src="images/home/u23.png"/>
</div>
  
  <a href="images/home/u4.png" download>
  <img border="0" src="http://www.w3schools.com/images/lamp.gif" alt="W3Schools" width="15" height="15">
</a>
  
</form>
    <script type="text/javascript">
        function download() {
    var dt = canvas.toDataURL('image/jpeg');
    this.href = dt;
};
downloadLnk.addEventListener('click', download, false);
    </script>
</body>
</html>
