<%-- 
    Document   : uploadimage
    Created on : Feb 23, 2016, 6:17:24 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ page language="java"  errorPage="" %>
<html>
<head>
<title>Image Upload</title>
</head>

<body>
     <input type="text" name="yourname" style="border:none" value="<%= session.getAttribute("username")%>" readonly><br></br>
  
     <form id="form2" action="Navigate" method="GET">
     <input type="submit" name="skip" value="Skip this Step" /> <br> <br />
 </form>

 </br>

<form name="frm" action="saveImage.jsp" enctype="multipart/form-data" method="post">
    <br />
<b>Upload Receipt Copy</b>
(jpg,jpeg,png,bmp,gif only)
<br />
 <br />
 <fieldset style="width:21%"> 
 <legend>Upload Image</legend>
            <br> 
            <label for="fileName">Select File: </label>
  <input type="file" id="fileupload" name="uProperty" /> <br> <br />
 <input type="submit" name="goUpload" value="Upload" /> <br> <br />
</fieldset> 
 <div id="dvPreview">
 </div> <br>
 
</form>
 
<form id="myform" action="FileUploadExample" method="post" enctype="multipart/form-data">
            
  
    <b>Upload Receipt Copy</b> 
    (PDF only)
    <br />
 <br />
    <fieldset style="width:21%"> 
        
        
            <legend>Upload PDF File</legend>
            <br> 
            <label for="fileName">Select File ( max 10 MB ): </label>
            
            <input id="fileName" type="file" name="fileName" size="30"/><br/> 
            <br> 
            <input type="submit" value="Upload"/>
        
   </fieldset> 
        
    </form>
 
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script language="javascript" type="text/javascript">
$(function () {
    $("#fileupload").change(function () {
        if (typeof (FileReader) != "undefined") {
            var dvPreview = $("#dvPreview");
            dvPreview.html("");
            var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.jpeg|.gif|.png|.bmp)$/;
          
            $($(this)[0].files).each(function () {
                var file = $(this);
                if (regex.test(file[0].name.toLowerCase())) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        
                        var img = $("<img />");
                         
                        img.attr("style", "height:350px; width:450px");
                        img.attr("src", e.target.result);
                        dvPreview.append(img);
                        
                    }
                    reader.readAsDataURL(file[0]);
                } else {
                    alert(file[0].name + " is not a valid image file.");
                    dvPreview.html("");
                    return false;
                }
            });
        } else {
            alert("This browser does not support HTML5 FileReader.");
        }
    });
    
    $("#fileName").change(function () {
        if (typeof (FileReader) != "undefined") {
           
            var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.pdf)$/;
          
            $($(this)[0].files).each(function () {
                var file = $(this);
                var sourceString = file[0].name;
                
                var file[0].name = sourceString.replace(/[`~!@#$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/]/gi, '');
                if (regex.test(file[0].name.toLowerCase())) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        
                        alert(file[0].name + " is a valid pdf file.");
                        
                    }
                    reader.readAsDataURL(file[0]);
                } else {
                    alert(file[0].name + " is not a valid pdf file.");                 
                    return false;
                }
            });
        } else {
            alert("This browser does not support HTML5 FileReader.");
        }
    });
});

</script> 
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
 

 function goBack() {
    window.history.back();
}
</script>
</body>
</html>