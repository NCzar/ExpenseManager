<%-- 
    Document   : display
    Created on : Feb 23, 2016, 11:08:08 PM
    Author     : nikhilv85
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@ page import="com.itextpdf.text.Document"%>
<%@ page import="com.itextpdf.text.DocumentException"%>
<%@ page import="com.itextpdf.text.Element"%>
<%@ page import="org.apache.pdfbox.pdmodel.PDDocument"%> 
<%@ page import="org.apache.pdfbox.util.PDFTextStripper"%>
<%@ page import="org.apache.pdfbox.util.PDFTextStripperByArea"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.lang.*" %> 
<%@ page import="com.itextpdf.*" %>


<jsp:useBean id="photo" class="api.images" scope="session" />
<body onload="setTimeout(function(){window.location = 'test2.jsp';}, 1000)">
<% 

  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); 
  Connection con = DriverManager.getConnection("jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016");
  String temp=(String)session.getAttribute("imageno");
  //String temp="222";
  //String strSQL = "SELECT  bImage FROM [Userdetails].[dbo].[upload_image] where iImageID='"+temp+"'";
  
  try
    {  
       
       int iNumPhoto ;
       
       iNumPhoto=Integer.parseInt(temp);
       con.setAutoCommit (false);  
  
       // get the image from the database
      byte[] imgData = photo.getimage( con,iNumPhoto ) ;   
       
       // display the image
       
       response.setContentType("image/gif");
       
       OutputStream o = response.getOutputStream();
       o.write(imgData);
       o.flush(); 
       o.close();
               

    
    
           
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
   

%> 

</body>

<script>
    setTimeout(function(){
       window.location='test2.jsp';
    }, 5000);
</script>

