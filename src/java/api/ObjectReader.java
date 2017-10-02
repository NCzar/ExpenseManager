/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nikhilv85
 */
public class ObjectReader {
          
    String inst="52.91.188.107";
    String dfkey="5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8";
    String url="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Name,Email,Organization&api_key="+dfkey;
    
       // JSONObject object = new JSONObject("HI");
//String syncresponse = object.getString("syncresponse");
    
        public void readoutput(String url,String email) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("Email").toString();
    int len2=emailinput.length();
            String str12=emailinput.substring(1, len2-1);
    
    if(str12.matches(email)==true) {
    
    String output=jsonObject.get("Organization").toString();
    
    int len1=output.length();
            String str11=output.substring(1, len1-1);
    System.out.println(str11);
    }
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
}
        
}
       
 public boolean checkforuseremail(String url,String email) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("Email").toString();
    int len2=emailinput.length();
            String str12=emailinput.substring(1, len2-1);
   
    if(str12.matches(email)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}
System.out.println(result+" "+match);
    return result;    
}        
        

public boolean checkfororg(String url,String org) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String orginput=jsonObject.get("OrganizationName").toString();
    int len2=orginput.length();
            String str12=orginput.substring(1, len2-1);
   
    if(str12.matches(org)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}
System.out.println(result+" "+match);
    return result;    
}    
 
public boolean checkforadminemail(String adminemail) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         String url="http://52.91.188.107/api/v2/expense/_table/Organization?fields=AdminEmail&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8";
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String orginput=jsonObject.get("AdminEmail").toString();
    int len2=orginput.length();
            String str12=orginput.substring(1, len2-1);
   
    if(str12.matches(adminemail)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}

    return result;    
} 
 
public String getorgname(String adminemail) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         String url="http://"+inst+"/api/v2/expense/_table/Organization?fields=AdminEmail,OrganizationName&api_key="+dfkey;
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str12="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String orginput=jsonObject.get("OrganizationName").toString();
    int len2=orginput.length();
            str12=orginput.substring(1, len2-1);
   
    if(str12.matches(adminemail)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}

    return str12;    
} 

public String getaddress(String adminemail) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         String url="http://"+inst+"/api/v2/expense/_table/Organization?fields=AdminEmail,Address&api_key="+dfkey;
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str12="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String orginput=jsonObject.get("Address").toString();
    int len2=orginput.length();
            str12=orginput.substring(1, len2-1);
   
    if(str12.matches(adminemail)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}

    return str12;    
} 

public String getkey(String adminemail) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         String url="http://"+inst+"/api/v2/expense/_table/Organization?fields=AdminEmail,StripeKey&api_key="+dfkey;
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str12="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String orginput=jsonObject.get("StripeKey").toString();
    int len2=orginput.length();
            str12=orginput.substring(1, len2-1);
   
    if(str12.matches(adminemail)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}

    return str12;    
} 

public String getadminname(String adminemail) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         String url="http://"+inst+"/api/v2/expense/_table/Organization?fields=AdminEmail,AdminName&api_key="+dfkey;
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str12="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String orginput=jsonObject.get("AdminName").toString();
    int len2=orginput.length();
            str12=orginput.substring(1, len2-1);
   
    if(str12.matches(adminemail)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}

    return str12;    
} 

public String getphoneno(String adminemail) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         String url="http://"+inst+"/api/v2/expense/_table/Organization?fields=AdminEmail,PhoneNo&api_key="+dfkey;
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str12="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String orginput=jsonObject.get("PhoneNo").toString();
    int len2=orginput.length();
            str12=orginput.substring(1, len2-1);
   
    if(str12.matches(adminemail)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}

    return str12;    
}

public String getcountry(String adminemail) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         String url="http://"+inst+"/api/v2/expense/_table/Organization?fields=AdminEmail,Country&api_key="+dfkey;
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str12="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String orginput=jsonObject.get("Country").toString();
    int len2=orginput.length();
            str12=orginput.substring(1, len2-1);
   
    if(str12.matches(adminemail)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}

    return str12;    
}

public String getpassword(String adminemail) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         String url="http://"+inst+"/api/v2/expense/_table/Organization?fields=AdminEmail,Password&api_key="+dfkey;
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str12="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String orginput=jsonObject.get("Password").toString();
    int len2=orginput.length();
            str12=orginput.substring(1, len2-1);
   
    if(str12.matches(adminemail)==true) {
    match=1;
    result=true;
    }
    
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
    
}

    return str12;    
}

public String getaccountnumber(String url,String email) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("Email").toString();
    int len2=emailinput.length();
            String str12=emailinput.substring(1, len2-1);
    
    if(str12.matches(email)==true) {
    
    String output=jsonObject.get("AccountNumber").toString();
    
    int len1=output.length();
             str11=output.substring(1, len1-1);
 
    }
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
}
      return str11;  
}
 
 public String getroutingnumber(String url,String email) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
         
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("Email").toString();
    int len2=emailinput.length();
            String str12=emailinput.substring(1, len2-1);
    
    if(str12.matches(email)==true) {
    
    String output=jsonObject.get("RoutingNumber").toString();
    
    int len1=output.length();
             str11=output.substring(1, len1-1);
 
    }
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
}
      return str11;  
}

public String gettripstatus(int id) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
        String url="http://"+inst+"/api/v2/expense/_table/Triprecorder?fields=tripid,tripstatus&api_key="+dfkey; 
        String tripid=Integer.toString(id);
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("tripid").toString();
    //System.out.println(emailinput);
    
    int len2=emailinput.length();
      //      String str12=emailinput.substring(1, len2-1);
    String str12=emailinput;
    if(str12.matches(tripid)==true) {
    
    String output=jsonObject.get("tripstatus").toString();
    
    int len1=output.length();
             str11=output.substring(1, len1-1);
 
    }
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
}
      return str11;  
}
 
public String getlatfromno(String no) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
        String url="http://"+inst+"/api/v2/expense/_table/Tripdetail?fields=no,latitude,longitude&api_key="+dfkey+"&filter=no%20like%20"+no;
        String tripid=no;
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("no").toString();
    
    
    int len2=emailinput.length();
    String str12=emailinput.substring(1, len2-1);
   // String str12=emailinput;
    if(str12.matches(tripid)==true) {
    
    String output=jsonObject.get("latitude").toString();
    
    int len1=output.length();
             str11=output.substring(1, len1-1);
 
    }
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
}
      return str11;  
}

public String getlongfromno(String no) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
        String url="http://"+inst+"/api/v2/expense/_table/Tripdetail?fields=no,latitude,longitude&api_key="+dfkey+"&filter=no%20like%20"+no;
        String tripid=no;
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   // String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("no").toString();
    
    
    int len2=emailinput.length();
    String str12=emailinput.substring(1, len2-1);
   // String str12=emailinput;
    if(str12.matches(tripid)==true) {
    
    String output=jsonObject.get("longitude").toString();
    
    int len1=output.length();
             str11=output.substring(1, len1-1);
 
    }
   /* 
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
      */  
}
      return str11;  
}

public String getfirstlat(int id) throws MalformedURLException, IOException{
      
        String url="http://"+inst+"/api/v2/expense/_table/Tripdetail?fields=tripid,no,latitude&api_key="+dfkey+"&filter=tripid%20like%20"+id+"%20";
        
        String tripid=Integer.toString(id);
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   
 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
  
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
    String firstlat="";
    int arraysize=jArray.size();
    Item[] items = new Item[arraysize];
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String str15=jsonObject.get("no").toString();
    String str16=str15.substring(1, str15.length()-1);
    int number=Integer.parseInt(str16);
    	
	items[i] = new Item(number);
	   
}
Arrays.sort(items);
String firstno=(items[0]).toString();



for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String str15=jsonObject.get("no").toString();
    String str16=str15.substring(1, str15.length()-1);
    int number=Integer.parseInt(str16);
    
    
    if(number==Integer.parseInt(firstno)){
        String str17=jsonObject.get("latitude").toString();
        int len1=str17.length();
           firstlat=str17.substring(1, len1-1);
    }
     
}

      return firstlat;  
} 

public String getlastlat(int id) throws MalformedURLException, IOException{
      
        String url="http://"+inst+"/api/v2/expense/_table/Tripdetail?fields=tripid,no,latitude&api_key="+dfkey+"&filter=tripid%20like%20"+id+"%20";
        
        String tripid=Integer.toString(id);
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   
 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
  
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
    String firstlat="";
    int arraysize=jArray.size();
    Item[] items = new Item[arraysize];
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String str15=jsonObject.get("no").toString();
    String str16=str15.substring(1, str15.length()-1);
    int number=Integer.parseInt(str16);
    	
	items[i] = new Item(number);
	   
}
Arrays.sort(items);
String firstno=(items[arraysize-1]).toString();



for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String str15=jsonObject.get("no").toString();
    String str16=str15.substring(1, str15.length()-1);
    int number=Integer.parseInt(str16);
    
    
    if(number==Integer.parseInt(firstno)){
        String str17=jsonObject.get("latitude").toString();
        int len1=str17.length();
           firstlat=str17.substring(1, len1-1);
    }
     
}

      return firstlat;  
} 

public String getfirstlong(int id) throws MalformedURLException, IOException{
      
        String url="http://"+inst+"/api/v2/expense/_table/Tripdetail?fields=tripid,no,longitude&api_key="+dfkey+"&filter=tripid%20like%20"+id+"%20";
        
        String tripid=Integer.toString(id);
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   
 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
  
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
    String firstlat="";
    int arraysize=jArray.size();
    Item[] items = new Item[arraysize];
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String str15=jsonObject.get("no").toString();
    String str16=str15.substring(1, str15.length()-1);
    int number=Integer.parseInt(str16);
    	
	items[i] = new Item(number);
	   
}
Arrays.sort(items);
String firstno=(items[0]).toString();



for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String str15=jsonObject.get("no").toString();
    String str16=str15.substring(1, str15.length()-1);
    int number=Integer.parseInt(str16);
    
    
    if(number==Integer.parseInt(firstno)){
        String str17=jsonObject.get("longitude").toString();
        int len1=str17.length();
           firstlat=str17.substring(1, len1-1);
    }
     
}

      return firstlat;  
} 

public String getlastlong(int id) throws MalformedURLException, IOException{
      
        String url="http://"+inst+"/api/v2/expense/_table/Tripdetail?fields=tripid,no,longitude&api_key="+dfkey+"&filter=tripid%20like%20"+id+"%20";
        
        String tripid=Integer.toString(id);
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
   
 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
  
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
    String firstlat="";
    int arraysize=jArray.size();
    Item[] items = new Item[arraysize];
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String str15=jsonObject.get("no").toString();
    String str16=str15.substring(1, str15.length()-1);
    int number=Integer.parseInt(str16);
    	
	items[i] = new Item(number);
	   
}
Arrays.sort(items);
String firstno=(items[arraysize-1]).toString();



for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String str15=jsonObject.get("no").toString();
    String str16=str15.substring(1, str15.length()-1);
    int number=Integer.parseInt(str16);
    
    
    if(number==Integer.parseInt(firstno)){
        String str17=jsonObject.get("longitude").toString();
        int len1=str17.length();
           firstlat=str17.substring(1, len1-1);
    }
     
}

      return firstlat;  
} 

public String gettransfromindex(int index,String url) throws MalformedURLException, IOException{
      //  String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
  // String url="http://52.91.188.107/api/v2/expense/_table/Userentry?fields=Name,Email,iImageID,description&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8&filter=(approved%20NE%20N)%20AND%20(approved%20NE%20Y)%20AND%20(manageremail="+session.getAttribute("approveremail"))";

        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}

 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
    // System.out.println(str10);        
 boolean result=false;
 int match=0;
    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    
    String str13="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
       
    if(i==index) {
        
     String stripeinput=jsonObject.get("iImageID").toString();
     
    int len3=stripeinput.length();
            str13=stripeinput.substring(0, len3);
            
    match=1;
    result=true;
    }
    
}

    return str13;    
}      

public String getnamefromemail(String email) throws MalformedURLException, IOException{
    
    String url="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Name,Email&api_key="+dfkey; 
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("Email").toString();
   
    
    int len2=emailinput.length();
    String str12=emailinput.substring(1, len2-1);  
    if(str12.matches(email)==true) {
    
    String output=jsonObject.get("Name").toString();
    
    int len1=output.length();
             str11=output.substring(1, len1-1);
 
    }
    
}
      return str11;  
}

public String getemailfromid(String id) throws MalformedURLException, IOException{
    
    String url="http://"+inst+"/api/v2/expense/_table/Userentry?fields=Name,Email,iImageID&api_key="+dfkey; 
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("iImageID").toString();
   
    
    int len2=emailinput.length();
    //String str12=emailinput.substring(1, len2-1);
    String str12=emailinput;
    if(str12.matches(id)==true) {
    
    String output=jsonObject.get("email").toString();
    
    int len1=output.length();
             str11=output.substring(1, len1-1);
 
    }
    
}
      return str11;  
}

public String getapproveremailfromid(String id) throws MalformedURLException, IOException{
    
    String url="http://"+inst+"/api/v2/expense/_table/Userentry?fields=Name,manageremail,iImageID&api_key="+dfkey; 
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("iImageID").toString();
   
    
    int len2=emailinput.length();
    //String str12=emailinput.substring(1, len2-1);
    String str12=emailinput;
    if(str12.matches(id)==true) {
    
    String output=jsonObject.get("manageremail").toString();
    
    int len1=output.length();
             str11=output.substring(1, len1-1);
 
    }
    
}
      return str11;  
}

public String getamountfromid(String id) throws MalformedURLException, IOException{
    
    String url="http://"+inst+"/api/v2/expense/_table/Userentry?fields=Name,amount,iImageID&api_key="+dfkey; 
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("iImageID").toString();
   
    
    int len2=emailinput.length();
    //String str12=emailinput.substring(1, len2-1);
    String str12=emailinput;
    if(str12.matches(id)==true) {
    
    String output=jsonObject.get("amount").toString();
    
    int len1=output.length();
           //  str11=output.substring(1, len1-1);
           str11=output;
    }
    
}
      return str11;  
}

public String getdescriptionfromid(String id) throws MalformedURLException, IOException{
    
    String url="http://"+inst+"/api/v2/expense/_table/Userentry?fields=Name,description,iImageID&api_key="+dfkey; 
      
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
 String fullword=wholeoutput;
            int len=fullword.length();
            String str10=fullword.substring(12, len-1);
        

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("iImageID").toString();
   
    
    int len2=emailinput.length();
    //String str12=emailinput.substring(1, len2-1);
    String str12=emailinput;
    if(str12.matches(id)==true) {
    
    String output=jsonObject.get("description").toString();
    
    int len1=output.length();
             str11=output.substring(1, len1-1);
 
    }
    
}
      return str11;  
}

public ArrayList getimagesfromid(String id) throws MalformedURLException, IOException{
    
    String url="http://"+inst+"/api/v2/expense/_table/upload_image?fields=iImageID,Id_new&api_key="+dfkey+"&filter=iImageID%20like%20"+id; 
      ArrayList array=new ArrayList();
      int c=0;
        URL oracle = new URL(url);
BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,wholeoutput;
        wholeoutput="";
while ((inputLine = in.readLine()) != null){
    //System.out.println(inputLine);
    wholeoutput=wholeoutput+inputLine;
}
   
 String fullword=wholeoutput;
            int len=fullword.length();
           // String str10=fullword.substring(12, len-1);
            ObjectReader o2=new ObjectReader();
        String str10=o2.testformeta(fullword);

    JsonArray jArray = new JsonParser().parse(str10).getAsJsonArray();
    System.out.println(jArray.size());
    String str11="";
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    
    String emailinput=jsonObject.get("iImageID").toString();
   
    
    int len2=emailinput.length();
    //String str12=emailinput.substring(1, len2-1);
    String str12=emailinput;
    if(str12.matches(id)==true) {
    
    String output=jsonObject.get("Id_new").toString();
    
    int len1=output.length();
    
           //  str11=output.substring(1, len1-1);
           array.add(output);
           c=c+1;
    }
    
}
  
      return array;  
}

public String testformeta(String str) throws MalformedURLException, IOException {
    
   
 String fullword=str;
    boolean result=false;
    String strwithmeta="";
    int len=fullword.length();
            
    if (fullword.contains(",\"meta\":")==true){
         int len5=fullword.indexOf(",\"meta\":");
         strwithmeta=fullword.substring(12, len5);
    }
    else{
         strwithmeta=fullword.substring(12, len-1);
    }
    return strwithmeta;
}

}
