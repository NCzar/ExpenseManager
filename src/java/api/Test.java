/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;


import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;
import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.RemoteException;
import android.os.IBinder;
//import android.os.ServiceManager;
import android.util.Log;
import java.io.InputStream;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.simple.JSONArray;

import com.google.gson.Gson; 
import com.google.gson.reflect.TypeToken;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;
import java.lang.*;
import static java.lang.System.in;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONValue;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.fontbox.afm.AFMParser;
   
//import org.apache.pdfbox.util.ImageIOUtil;



/**
 *
 * @author nikhilv85
 */
public class Test {
    
    //private static final String filePath = "C:\\Users\\nikhilv85\\Desktop\\json.json";
    //private static final String filePath = "web\\jsondata\\apidata.json";
    File x1=new File("C:\\Users\\nikhilv85\\Downloads\\jotform2");
    FileReader reader1;
    
    String inst="52.91.188.107";
    String dfkey="5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8";
    public String getloc(String loc,String loc2,String loc3,String loc4) throws IOException{
        
         
      String s="";
        int c=0;
FileReader reader;
        try {
           
String urladd= "http://maps.googleapis.com/maps/api/directions/json?origin="+loc+","+loc2+"&destination="+loc3+","+loc4+"&sensor=false";
   URL oracle = new URL(urladd);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        
while ((inputLine = in.readLine()) != null)
           
        if(inputLine.contains("text")){
            if(c==0){
            s=inputLine.substring(28, 33);
            c=1;
        }
        }
        in.close();
        

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 

    return s;
   
    }
 
    
    public String getaddress(String lat, String lng) throws IOException {

      
      String s="";
        int c=0;
FileReader reader;
        try {
            
String url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=__LAT__,__LNG__&sensor=false";

    url = url.replaceAll("__LAT__", lat);
    url = url.replaceAll("__LNG__", lng);
    
URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        
while ((inputLine = in.readLine()) != null)
          
        if(inputLine.contains("formatted_address")){
            if(c==0){
                int len=inputLine.length();
            s=inputLine.substring(32,len-2);
           // System.out.println(inputLine);
            c=1;
        }
        }
        in.close();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
  
    return s;
    
}
    
    public static void main(String[] args) throws ParseException {
        try{
        
        ObjectReader o=new ObjectReader();
        Test t=new Test();
        System.out.println("hello world");
        /*
        String url="http://52.91.188.107/api/v2/expense/_table/Userentry?fields=Name,Email,iImageID,description&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8";
        ArrayList output=new ArrayList();
        output=o.getimagesfromid("362");
        Object[] output1 = output.toArray();
        Arrays.sort(output1);
        int c=output.size();
        for (int i=0;i<c;i++){
            System.out.println(output1[i].toString());
            
        }
        */
        }
        
            catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public String getPublicIpAddress() throws MalformedURLException,IOException {
   
    URL connection = new URL("http://checkip.amazonaws.com/");
    URLConnection con = connection.openConnection();
    String str = null;
    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
    str = reader.readLine();
    //System.out.println(str);
     
    return str;
}
    
    public static Object fromJson(String jsonString, Type type) {
    return new Gson().fromJson(jsonString, type);
}
    
    String usernamecheck(String username) throws IOException{
        String s="false";
        
         int c,d;
      c=0;
      d=0;
    
    String inputLine;
        String fullword="";
//username check
    
 String usernameoutput= "http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Email&api_key="+dfkey;      
  
  URL oracle1 = new URL(usernameoutput);
  
        try (BufferedReader in1 = new BufferedReader(
                new InputStreamReader(oracle1.openStream()))) {
           
             
while ((inputLine = in1.readLine()) != null)
          
        if(inputLine.contains(username)){
            if(d==0){
            s="true";
            d=1;
            
            }
                       
        }
        in1.close();  
                          
                    }                 
    
        catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
               
        return s;
    }
    
    String passwordcheck(String username) throws IOException{
        String s="";
        
         int c,d;
      c=0;
      d=0;
    
    String inputLine;
        String fullword="";
//get password
    
  String apioutput="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Password&api_key="+dfkey+"&filter=Email%20like%20%27"+username+"%27";
    
    
     URL oracle = new URL(apioutput);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()))) {
           
             
while ((inputLine = in.readLine()) != null)
          
        if(inputLine.contains("Password")){
            if(c==0){
            s=inputLine.substring(26);
            
            c=1;
            
            fullword=inputLine;
            int len=fullword.length();
            String str10=fullword.substring(26, len-4);
            s=str10;
            System.out.println(str10);              
                    }           
                }
            in.close();      
        }
          
                       
                                     
        
        catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        return s;
    }
    
    /*
    byte[] pdftojpg(File f){
       byte[] b1=null;
        try {
        String sourceDir = "C:\\Users\\nikhilv85\\Desktop\\jotformupload.pdf"; // Pdf files are read from this folder
           
           
            String destinationDir = "C:\\Users\\nikhilv85\\Desktop\\InspiredLiving\\output\\"; // converted images from pdf document are saved here
        // System.out.println(f.getName());
         
      // File sourceFile = new File(sourceDir);
         File sourceFile = f; 
          
        File destinationFile = new File(destinationDir);
        if (!destinationFile.exists()) {
            destinationFile.mkdir();
            System.out.println("Folder Created -> "+ destinationFile.getAbsolutePath());
        }
        if (sourceFile.exists()) {
            System.out.println("Images copied to Folder: "+ destinationFile.getName());             
                try (PDDocument document = PDDocument.load(sourceFile)) {
                    List<PDPage> list = document.getDocumentCatalog().getAllPages();
                    System.out.println("Total files to be converted -> "+ list.size());
                    
                    String fileName = sourceFile.getName().replace(".pdf", "");
                    int pageNumber = 1;
                    for (PDPage page : list) {
                        BufferedImage image = page.convertToImage();
                        File outputfile = new File(destinationDir + fileName +"_"+ pageNumber +".png");
                        File x3 = new File(destinationDir+fileName +"_0"+ pageNumber +".jpg");
                        System.out.println("Image Created -> "+ outputfile.getName());
                        ImageIO.write(image, "png", outputfile);
                        
                       // ImageIOUtil.writeImage(image,destinationDir+fileName +"_0"+ pageNumber +".jpg", 72);
                        ImageIO.write(image, "jpg", x3);
                        
        // start trial                
                        BufferedImage originalImage=ImageIO.read(x3);
                        ByteArrayOutputStream baos=new ByteArrayOutputStream();
                        ImageIO.write(originalImage, "jpg", baos );
                        b1=baos.toByteArray();
                        
         //end trial               
                        
                        pageNumber++;
                    }   }
            System.out.println("Converted Images are saved at -> "+ destinationFile.getAbsolutePath());
        } else {
            System.err.println(sourceFile.getName() +" File does not exist");
        }
         

    } catch (Exception e) {
        e.printStackTrace();
    }
        
      
       return b1;  
    }
    */
    
    byte[] pdftojpgconv(File f) throws IOException{
        byte[] b2= null;
        String fileName = f.getName().replace(".pdf", "");
         String destinationDir = "C:\\Users\\nikhilv85\\Desktop\\InspiredLiving\\output\\"; // converted images from pdf document are saved here
       
        //PDDocument document = PDDocument.loadNonSeq(f, null);
        PDDocument document = PDDocument.load(f);
PDDocumentCatalog catalog = document.getDocumentCatalog();
@SuppressWarnings("unchecked")
//List<PDPage> pages = catalog.getAllPages();

PDFRenderer renderer = new PDFRenderer(document);

//for (int i = 0; i < pages.size(); i++)
int i=0;
{
    BufferedImage image = renderer.renderImage(i);
    //ImageIOUtil.writeImage(image,destinationDir+fileName +"_0"+".jpg", 72);
    ImageIO.write(image, "png", new File(destinationDir+fileName +"_0"+".jpg"));
}
        return b2;
    }
    
    
       public void urlrun() throws IOException{
        String s="false";
        
         int c,d;
      c=0;
      d=0;
    
    String inputLine;
        String fullword="";
//username check
    
// String usernameoutput= "http://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";      
  String usernameoutput= "https://www.easypdfcloud.com/oauth2/token%20HTTP/1.1%20Content-Type:%20application/x-www-form-urlencoded%20grant_type=client_credentials&client_id=32173bc3ceda4993bb5083638ffa6862&client_secret=07792DC105D631B540ECD90056F6FEDE3CF9DEAA6045A05A2125625CCDE4A6B1&scope=epc.api";
   
  URL oracle1 = new URL(usernameoutput);
  
        try (BufferedReader in1 = new BufferedReader(
                new InputStreamReader(oracle1.openStream()))) {
           
             
while ((inputLine = in1.readLine()) != null)
          
        System.out.println(inputLine);
        in1.close();  
                          
                    }                 
    
        catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
                
    }
 
    
}

