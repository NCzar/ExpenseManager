/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nikhilv85
 */
@WebServlet(name = "ValidateApprover", urlPatterns = {"/ValidateApprover"})
public class ValidateApprover extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidateApprover</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidateApprover at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //processRequest(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //processRequest(request, response);
        
        String str2=request.getParameter("submitteremail1");
        String str3=request.getParameter("passcode1");
        
        HttpSession session = request.getSession();   
        ObjectReader o=new ObjectReader();
        String str4=o.getnamefromemail(str2);
    session.setAttribute("approveremail",str2);    
    session.setAttribute("approvername",str4);
    session.setAttribute("count","0");
    session.setAttribute("selector",".");
    String inst="52.91.188.107";
    String dfkey="5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8";
    //start trial
   // String url="https://df-inspiredliving.enterprise.dreamfactory.com/api/v2/expense/_table/Userregistration?fields=Name,Email,Organization,AccountNumber,RoutingNumber&api_key=ad21b893953d4469ba569526ff6cb6e83ab6fea46471b008593811b8c98a5722";
     
    String url="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Name,Email,Organization,AccountNumber,RoutingNumber&api_key="+dfkey;
        //String orgname=or.getorgname(url, "nik@bb");
       
        ObjectReader or=new ObjectReader();
       // String name=or.getfullname(url, str2);
        String accountnumber=or.getaccountnumber(url, str2);
        session.setAttribute("accountno1",accountnumber);
        String routingnumber=or.getroutingnumber(url, str2);
        session.setAttribute("routingno1",routingnumber);
    //end trial
        int c,d;
      c=0;
      d=0;
    String s="";
    String inputLine;
        String fullword="";
//username check
    
 String usernameoutput= "http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Email&api_key="+dfkey;     
  
  URL oracle1 = new URL(usernameoutput);
        try (BufferedReader in1 = new BufferedReader(
                new InputStreamReader(oracle1.openStream()))) {
           
             
while ((inputLine = in1.readLine()) != null)
          
        if(inputLine.contains(str2)){
            if(d==0){
            s=inputLine.substring(2);
         
            d=1;
            
            }
                /*        
                RequestDispatcher view = request.getRequestDispatcher("password_notmatch.jsp");
                view.forward(request, response);
            */
                              
        }
        in1.close();  
        
          if(d==0){
              RequestDispatcher view = request.getRequestDispatcher("username_donotexist.jsp");
                view.forward(request, response);
          }          
                    }                  
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
   
 //getname
    String namefromapi="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Name&api_key="+dfkey+"&filter=Email%20like%20%27"+str2+"%27";
     
    URL oracle2 = new URL(namefromapi);
        try (BufferedReader in2 = new BufferedReader(
                new InputStreamReader(oracle2.openStream()))) {
           
             

            while ((inputLine = in2.readLine()) != null)
          
        
            
            
            
            
            fullword=inputLine;
            int len1=fullword.length();
           String str11=fullword.substring(22, len1-4);
            
            System.out.println(str11);
            
            session.setAttribute("username1",str11);
        
        }
// get manager's email      
        
     String managerfromapi="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Manageremail&api_key="+dfkey+"&filter=Email%20like%20%27"+str2+"%27";
      URL oracle3 = new URL(managerfromapi);
        try (BufferedReader in3 = new BufferedReader(
                new InputStreamReader(oracle3.openStream()))) {
           
             

            while ((inputLine = in3.readLine()) != null)
          
        
            
            
            
            
            fullword=inputLine;
            int len2=fullword.length();
           String str12=fullword.substring(30, len2-4);
            
            
            if (str12.matches("ul")) {
                str12="";
            }
            System.out.println(str12);
            session.setAttribute("manageremail1",str12);
        
        } 
     
 // get organization's details     
        
     String orgfromapi="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Organization&api_key="+dfkey+"&filter=Email%20like%20%27"+str2+"%27";
      URL oracle4 = new URL(orgfromapi);
        try (BufferedReader in4 = new BufferedReader(
                new InputStreamReader(oracle4.openStream()))) {
           
             

            while ((inputLine = in4.readLine()) != null)
          
        
            
            
            
            
            fullword=inputLine;
            int len2=fullword.length();
           String str14=fullword.substring(30, len2-4);
            
            System.out.println(str14);
            
            session.setAttribute("organization1",str14);
        
        } 
      
 // get hierarchy details     
        
     String levelfromapi="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Level&api_key="+dfkey+"&filter=Email%20like%20%27"+str2+"%27";
      URL oracle5 = new URL(levelfromapi);
        try (BufferedReader in5 = new BufferedReader(
                new InputStreamReader(oracle5.openStream()))) {
           
             

            while ((inputLine = in5.readLine()) != null)
          
        
            
            
            
            
            fullword=inputLine;
            int len2=fullword.length();
           String str15=fullword.substring(23, len2-4);
            
            System.out.println("level:" + str15);
            
            session.setAttribute("level1",str15);
        
        }        
        
        
//password check//
     String apioutput="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Password&api_key="+dfkey+"&filter=Email%20like%20%27"+str2+"%27";
    
    
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
            
            System.out.println(str10);
            
            if(str3.matches(str10)==true){
                System.out.println("Password match");
             session.setAttribute("password1",str10);   
                    
                    RequestDispatcher view = request.getRequestDispatcher("approval.jsp");
                    view.forward(request, response);
                        
                
            }
            else{
                System.out.println("Password not match");
                RequestDispatcher view = request.getRequestDispatcher("password_notmatch.jsp");
                view.forward(request, response);
                
            }
            
        }
        }
        in.close();         
                       
                    }                  
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
