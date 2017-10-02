<%-- 
    Document   : saveImage
    Created on : Feb 23, 2016, 6:14:38 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="api.Getapproval" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.io.output.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%
Connection conn=null;
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
    conn = DriverManager.getConnection("jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016");

   PreparedStatement psImageInsertDatabase=null;
   PreparedStatement psImageInsertDatabase2=null;
   
   
  
   byte[] b=null;
   try{
      
      String temp=(String)session.getAttribute("myId");
      String sqlImageInsertDatabase="insert into upload_image (bImage) values (?)";
      String sqlImageInsertDatabase2="UPDATE [dbo].[upload_image] SET [iImageID] = '"+temp+"' WHERE [iImageID] is null AND [bImage] is not null";
      psImageInsertDatabase=conn.prepareStatement(sqlImageInsertDatabase);
      
      DiskFileItemFactory factory = new DiskFileItemFactory();

      ServletFileUpload sfu = new ServletFileUpload(factory);
      List items = sfu.parseRequest(request);

      Iterator iter = items.iterator();

      while (iter.hasNext()) {
         FileItem item = (FileItem) iter.next();
         if (!item.isFormField()) {
              b = item.get();
          }
      }

      psImageInsertDatabase.setBytes(1,b);
      psImageInsertDatabase.executeUpdate();
      
      psImageInsertDatabase2=conn.prepareStatement(sqlImageInsertDatabase2);
      psImageInsertDatabase2.executeUpdate();
   }
   catch(Exception e)
   {
     e.printStackTrace();
     response.sendRedirect("addimage.jsp");
   }

%>
<img src="images/home/logo1.jpg"  style="width:200px;height:100px;">
<p> User:
<input type="text" name="yourname" value="<%= session.getAttribute("username")%>" readonly> <br> 
        <p> Your expense has been submitted</p>
        
        <p>Please note the transaction number below </p>
        <br>
<input type="text" name="approver" value="<%= session.getAttribute("myId")%>" readonly/> <br></br>
<button type="button"  style="height:30px;width:20%" onclick="document.location.href='uploadimage.jsp'">Upload another document</button><br></br>
                    <button type="button"  style="height:30px;width:20%" onclick="document.location.href='formentry.jsp'">Submit another form</button><br></br>
                    

<form id="form1" action="Navigate" method="POST">
<input type="submit" style="height:30px;width:20%" value="Back to Submission Page" name="expense" />
</form>
                    <br>
<button type="button" class="btn btn-secondary" style="height:30px;width:20%" onclick="document.location.href='index.html'">Logout</button><br>
              
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
 

 function goBack() {
    window.history.back();
}
</script>