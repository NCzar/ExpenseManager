package api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikhilv85
 */
import java.sql.*;
import java.io.*;
import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.lang.*;
import javax.servlet.http.HttpSession;






public class DBPrint {
    
       Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      int rslength;
      String[] jsonoutput= new String[10];
      String[] json2output= new String[10];
      StringWriter writer = new StringWriter();
      String id;
   public static void main(String[] args) throws IOException {
    DBPrint newcon = new DBPrint();
    String name="";
    String expense="";
    String email="";
    String manageremail="";
    String approval="";
    float amt=0;
    
      newcon.updatemanageremail("nikhil.chavista@gmail.com", "63");
      
   }
    
    public void getdata(String name,String expense,String email,String manageremail,float amt,String approval){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      // Declare the JDBC objects.
    //  Connection con = null;
    //  Statement stmt = null;
     // ResultSet rs = null;

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);

         // Create and execute an SQL statement that returns some data.
         //String SQL = "SELECT * FROM [Userdetails].[dbo].[Userentry] ";
         
         String SQL = "INSERT INTO [dbo].[Userentry]\n" +
"           ([Name]\n" +
"           ,[amount]\n" +
"           ,[email]\n" +
"           ,[manageremail]\n" +
"           ,[description]\n" +
"           ,[approved])\n" +
"     VALUES\n" +
"           ('"+name+"'\n" +
"           ,'"+amt+"'\n" +
"           ,'"+email+"'\n" +
"           ,'"+manageremail+"'\n" +
"           ,'"+expense+"'\n" +
"           ,'"+approval+"')";
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);

         // Iterate through the data in the result set and display it.
         /*
         while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5));
            rslength++;
            //jsonoutput[rslength]= rs.getString(1);
            //json2output[rslength]= rs.getString(2);
            
         }
         */
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
    
   public String getID(String name,String email){
       
        String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      // Declare the JDBC objects.
    //  Connection con = null;
    //  Statement stmt = null;
     // ResultSet rs = null;

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);

         // Create and execute an SQL statement that returns some data.
         //String SQL = "SELECT * FROM [Userdetails].[dbo].[Userentry] ";
         
         String SQL = "SELECT max (iImageID) \n" +
"  FROM [Userdetails].[dbo].[Userentry]\n" +
"\n" +
"  where Name='"+name+"' and email ='"+email+"'";
         
         System.out.println("This is the error 2.0");
         stmt = con.createStatement();
         rs = stmt.executeQuery(SQL);
         
 System.out.println("This is the error 2");
         // Iterate through the data in the result set and display it.
         
         while (rs.next()) {
            System.out.println(rs.getString(1));
            //+ " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5));
            rslength++;
            //jsonoutput[rslength]= rs.getString(1);
            //json2output[rslength]= rs.getString(2);
            id=rs.getString(1);
            System.out.println("This is the error 3");
         }
         
         System.out.println("Hello id="+id);
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {
         System.out.println("This is the error 4");
         }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
       
        return(id);
    }
   
   
   public void insertuserdata(String email,String name,String pwd,String level,String manageremail,String org,String accountno,String routingno){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      // Declare the JDBC objects.
    //  Connection con = null;
    //  Statement stmt = null;
     // ResultSet rs = null;

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);

         // Create and execute an SQL statement that returns some data.
         //String SQL = "SELECT * FROM [Userdetails].[dbo].[Userentry] ";
         
         
         String SQL = "INSERT INTO [dbo].[Userregistration]\n" +
"           ([Email]\n" +
"           ,[Name]\n" +
"           ,[Password]\n" +
"           ,[Level]\n" +
"           ,[manageremail]\n" +
"           ,[AccountNumber]\n" +
"           ,[RoutingNumber]\n" +                 
"           ,[Organization])\n" +
"     VALUES\n" +
"           ('"+email+"'\n" +
"           ,'"+name+"'\n" +
"           ,'"+pwd+"'\n" +
"           ,'"+level+"'\n" +
"           ,'"+manageremail+"'\n" +
"           ,'"+accountno+"'\n" +
"           ,'"+routingno+"'\n" +                 
"           ,'"+org+"')";
         
         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);

        
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public void updateuserdata(String email,String name,String pwd,String level,String manageremail,String org,String accountno,String routingno){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      // Declare the JDBC objects.
    //  Connection con = null;
    //  Statement stmt = null;
     // ResultSet rs = null;

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);

         // Create and execute an SQL statement that returns some data.
         //String SQL = "SELECT * FROM [Userdetails].[dbo].[Userentry] ";
         
         
         String SQL = "UPDATE [dbo].[Userregistration]\n" +
"   SET [Name] = '"+name+"',\n" +
"   [Password]='"+pwd+"',\n" +                
"   [Organization]='"+org+"',\n" +
"   [Level]='"+level+"',\n" +  
"   [AccountNumber]='"+accountno+"',\n" +  
"   [RoutingNumber]='"+routingno+"',\n" +                   
"   [manageremail]='"+manageremail+"'\n" +                  
"     \n" +
" WHERE Email='"+email+"'\n" ;


         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);
    
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public void updateadmindata(String email,String orgname,String address,String key,String name,String phone,String country){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      // Declare the JDBC objects.
    //  Connection con = null;
    //  Statement stmt = null;
     // ResultSet rs = null;

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);

         // Create and execute an SQL statement that returns some data.
         //String SQL = "SELECT * FROM [Userdetails].[dbo].[Userentry] ";
         
         
         String SQL = "UPDATE [dbo].[Organization]\n" +
"   SET [OrganizationName] = '"+orgname+"',\n" +
"   [Address]='"+address+"',\n" +                
"   [StripeKey]='"+key+"',\n" +
"   [AdminName]='"+name+"',\n" +  
"   [Country]='"+country+"',\n" +  
"   [PhoneNo]='"+phone+"'\n" +                  
"     \n" +
" WHERE AdminEmail='"+email+"'\n" ;


         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);
    
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public void insertorgdata(String orgname,String address,String stripekey,String adminemail,String adminname,String phoneno,String country,String password){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      // Declare the JDBC objects.
    //  Connection con = null;
    //  Statement stmt = null;
     // ResultSet rs = null;

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);

         // Create and execute an SQL statement that returns some data.
         //String SQL = "SELECT * FROM [Userdetails].[dbo].[Userentry] ";
         
         
         String SQL = "INSERT INTO [dbo].[Organization]\n" +
"           ([OrganizationName]\n" +
"           ,[Address]\n" +
"           ,[StripeKey]\n" +
"           ,[AdminEmail]\n" +
"           ,[AdminName]\n" +
"           ,[PhoneNo]\n" +
"           ,[Country]\n" +                 
"           ,[Password])\n" +
"     VALUES\n" +
"           ('"+orgname+"'\n" +
"           ,'"+address+"'\n" +
"           ,'"+stripekey+"'\n" +
"           ,'"+adminemail+"'\n" +
"           ,'"+adminname+"'\n" +
"           ,'"+phoneno+"'\n" +
"           ,'"+country+"'\n" +                 
"           ,'"+password+"')";
         
         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);

         // Iterate through the data in the result set and display it.
         /*
         while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5));
            rslength++;
            //jsonoutput[rslength]= rs.getString(1);
            //json2output[rslength]= rs.getString(2);
            
         }
         */
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public void inserttriporigindata(String email,String lat1,String long1,String origaddress,String ipaddress){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = 
"INSERT INTO [dbo].[Triprecorder]\n" +
"           ([Email]\n" +
"           ,[Latitude1]\n" +
"           ,[Longitude1]\n" +
"           ,[ipaddress]\n" +
"           ,[Startaddress]\n" +
"          )\n" +
"     VALUES\n" +
"           ('"+email+"'\n" +
"           ,'"+lat1+"'\n" +
"           ,'"+long1+"'\n" +
"           ,'"+ipaddress+"'\n" +                 
"           ,'"+origaddress+"'\n" +
"           )";
         
         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);
    
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public void updatetriporigindata(int tripid,String tripstatus){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = "UPDATE [dbo].[TripRecorder]\n" +
"   SET [tripstatus] = '"+tripstatus+"'\n" +
"     \n" +
" WHERE tripid='"+tripid+"'\n" ;
         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);
    
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public void updatetriporigindata1(int tripid,String tripstatus,String lat,String lon){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         System.out.println(tripid+"/"+tripstatus+"/"+lat+"/"+lon);
         String SQL = "UPDATE [dbo].[TripRecorder]\n" +
"   SET [tripstatus] = '"+tripstatus+"',\n" +
"   [Latitude1] = '"+lat+"',\n" +  
"   [Longitude1] = '"+lon+"'\n" + 
"     \n" +
" WHERE tripid='"+tripid+"'\n" ;
         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);
    
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public void updatetriporigindata2(int tripid,String originaddress){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = "UPDATE [dbo].[TripRecorder]\n" +
"   SET [Startaddress] = '"+originaddress+"'\n" +
"     \n" +
" WHERE tripid='"+tripid+"'\n" ;
         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);
    
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public void inserttripdestdata(int tripid,String lat2,String long2,String destaddress){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = 
"UPDATE [dbo].[Triprecorder]\n" +
"          set latitude2='"+lat2+"',longitude2='"+long2+"',stopaddress='"+destaddress+"'\n" +
"           \n" +
"\n" +
"where tripid='"+tripid+"'";
         
         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);
    
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public void inserttripdata(int tripid,String lat1,String long1){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = 
"INSERT INTO [dbo].[Tripdetail]\n" +
"           ([tripid]\n" +
"           ,[latitude]\n" +
"           ,[longitude]\n" +
"          )\n" +
"     VALUES\n" +
"           ('"+tripid+"'\n" +
"           ,'"+lat1+"'\n" +
"           ,'"+long1+"'\n" +
"           )";
         
         
         stmt = con.createStatement();
       //  rs = stmt.executeQuery(SQL);
        // stmt.executeQuery(SQL);
         stmt.execute(SQL);
    
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {
        System.out.println("This is the error 1");
        }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    }
   
   public String gettripID(String email){
       
        String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";


      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = "SELECT max (tripid) \n" +
"  FROM [Userdetails].[dbo].[Triprecorder]\n" +
"\n" +
"  where email ='"+email+"'";
         
        // System.out.println("This is the error 2.0");
         stmt = con.createStatement();
         rs = stmt.executeQuery(SQL);
         
 
         // Iterate through the data in the result set and display it.
         
         while (rs.next()) {
           // System.out.println(rs.getString(1));
            rslength++;
            id=rs.getString(1);

         }
         
        // System.out.println("Hello id="+id);
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {
         System.out.println("This is the error 4");
         }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
        if(id==null){
            id="";
        }
        return(id);
    }
  
   public String getrecenttripno(String email){
       
        String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";


      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = "SELECT MAX(no) from Userdetails.dbo.Tripdetail where tripid=(\n" +
"SELECT MAX(tripid) from Userdetails.dbo.Triprecorder where Email='"+email+"'\n" +
")";
                 
         
        // System.out.println("This is the error 2.0");
         stmt = con.createStatement();
         rs = stmt.executeQuery(SQL);
         
 
         // Iterate through the data in the result set and display it.
         
         while (rs.next()) {
           // System.out.println(rs.getString(1));
            rslength++;
            id=rs.getString(1);

         }
         
        // System.out.println("Hello id="+id);
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {
         System.out.println("This is the error 4");
         }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
        if(id==null){
            id="";
        }
        return(id);
    }

   
   public String getemailfromID(String tripid){
       
        String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";


      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = "SELECT email \n" +
"  FROM [Userdetails].[dbo].[Triprecorder]\n" +
"\n" +
"  where tripid ='"+tripid+"'";
         
        // System.out.println("This is the error 2.0");
         stmt = con.createStatement();
         rs = stmt.executeQuery(SQL);
         
 
         // Iterate through the data in the result set and display it.
         
         while (rs.next()) {
           // System.out.println(rs.getString(1));
            rslength++;
            id=rs.getString(1);

         }
         
        // System.out.println("Hello id="+id);
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {
       //  System.out.println("This is the error 4");
         }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
        if(id==null){
            id="";
        }
        return(id);
    }

   
   public String gettripIDfromip(String ipaddress){
       
        String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";


      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = "SELECT max (tripid) \n" +
"  FROM [Userdetails].[dbo].[Triprecorder]\n" +
"\n" +
"  where ipaddress ='"+ipaddress+"'";
         
        // System.out.println("This is the error 2.0");
         stmt = con.createStatement();
         rs = stmt.executeQuery(SQL);
         
 
         // Iterate through the data in the result set and display it.
         
         while (rs.next()) {
           // System.out.println(rs.getString(1));
            rslength++;
            id=rs.getString(1);

         }
         
        // System.out.println("Hello id="+id);
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {
         System.out.println("This is the error 4");
         }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
        if(id==null){
            id="";
        }
        return(id);
    }
   
    public String getlatitude(String no){
       
        String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

        String lat="";
      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = "SELECT [Latitude1]\n" +
"      \n" +
"  FROM [Userdetails].[dbo].[Triprecorder]\n" +
"\n" +
"  where tripid='"+no+"'";
         
         
         stmt = con.createStatement();
         rs = stmt.executeQuery(SQL);
         
 
         // Iterate through the data in the result set and display it.
         
         while (rs.next()) {
            System.out.println(rs.getString(1));
            rslength++;
            lat=rs.getString(1);

         }
         
        
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {
         System.out.println("This is the error 4");
         }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
       
        return(lat);
    }
   
     public String getlongitude(String no){
       
        String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

        String longit="";
      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         String SQL = "SELECT [Longitude1]\n" +
"      \n" +
"  FROM [Userdetails].[dbo].[Triprecorder]\n" +
"\n" +
"  where tripid='"+no+"'";
         
         
         stmt = con.createStatement();
         rs = stmt.executeQuery(SQL);
         
 
         // Iterate through the data in the result set and display it.
         
         while (rs.next()) {
            System.out.println(rs.getString(1));
            rslength++;
            longit=rs.getString(1);

         }
         
        
         
         
          
        
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {
         System.out.println("This is the error 4");
         }
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
       
        return(longit);
    }
   
    public void updatetrans(String approval,String trans){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);

  
         String SQL = "UPDATE [dbo].[Userentry]\n" +
"   SET [approved] = '"+approval+"'\n" +
" WHERE iImageID='"+trans+"'";        
         stmt = con.createStatement();
         stmt.executeQuery(SQL);
      
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         //e.printStackTrace();
      }
      finally {
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    } 
    
    public void updatemanageremail(String manageremail,String trans){
            String connectionUrl = "jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016";

      try {
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);

  
         String SQL = "UPDATE [dbo].[Userentry]\n" +
"   SET [manageremail] = '"+manageremail+"'\n" +
" WHERE iImageID='"+trans+"'";        
         stmt = con.createStatement();
         stmt.executeQuery(SQL);
      
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
         //e.printStackTrace();
      }
      finally {
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
    } 
    
    public void buildJsonUsingStreamingApi() {

    

    JsonGenerator generator = Json.createGenerator(writer);

 

    generator.writeStartArray()
            
              .writeStartObject()
            
                .write("City", jsonoutput[1])

                .write("Billing",json2output[1])

            

              .writeEnd()
                     
            

            .writeEnd();


    generator.flush();
    
    
        

    System.out.println(writer.toString());

  }

 

}
