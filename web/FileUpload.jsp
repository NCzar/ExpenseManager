<%-- 
    Document   : FileUpload
    Created on : Mar 9, 2016, 10:33:58 AM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/home.css">
    </head>
<body>
    <form id="myform" action="FileUploadExample" method="post" enctype="multipart/form-data">
            <div id="img1">
    <img src="images/home/logo1.jpg" alt="logo" style=" width:80%"> 
        </div>
       
    <h3>File Upload Form</h3> 
    <fieldset>
        
        
            <legend>Upload PDF File</legend>
            <br> 
            <label for="fileName">Select File: </label>
            
            <input id="fileName" type="file" name="fileName" size="30"/><br/> 
            <br> 
            <input type="submit" value="Upload"/>
        
    </fieldset>
        
    </form>
</body>
</html>
