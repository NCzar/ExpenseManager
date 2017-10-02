/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
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
@WebServlet(name = "ComputeDistance", urlPatterns = {"/ComputeDistance"})
public class ComputeDistance extends HttpServlet {
  String var1,var2,var3,var4,origin1,str,str1;
     String lat1,long1,lat2,long2;
     String or="";
     String de="";
     int submit1=0;
     int submit2=0;
      DBPrint db1=new DBPrint();
      String tripno;
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
            out.println("<title>Servlet ComputeDistance</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComputeDistance at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
        
         request.setAttribute("origin5", ".");
         
        HttpSession session = request.getSession();  
      String useremailid=(String)session.getAttribute("useremail");
      if(useremailid==null){
          RequestDispatcher view = request.getRequestDispatcher("index.html");
                view.forward(request, response);
      }
        tripno=db1.gettripID(useremailid);
        int no=Integer.parseInt(tripno);
        
         String latout=db1.getlatitude(tripno);
        String longout=db1.getlongitude(tripno);
        System.out.println(latout+" "+longout);
        
       
        var3=request.getParameter("res3");
        var4=request.getParameter("res4");
        lat2=var3;
        long2=var4;
        
        Test t=new Test();
        try{
        String orig=t.getaddress(var3, var4);
        
        str=orig.substring(2);
        
        
       
        
        System.out.println(str);
        
        
       
        
        // start trial
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    // IMPORTANT: Save the old System.out!
    PrintStream old = System.out;
    // Tell Java to use your special stream
    System.setOut(ps);
    // Print some output: goes to your special stream
    System.out.println(str);
    // Put things back
    System.out.flush();
    System.setOut(old);
    // Show what happened
    System.out.println("Here: Nik " + baos.toString());
        
        System.out.println(orig);
        
        request.setAttribute("origin6", baos.toString());
        de=baos.toString();
        System.out.println("Orig="+ or);
        System.out.println("Des="+ de);
        
        
     //  if(or.isEmpty()==true || lat1.isEmpty()==true){
        if(latout.isEmpty()==true){
           request.setAttribute("distance1", "Please click Start Trip before Stop Trip");
       }
       else{
     
            System.out.println("first loop");
            
        String ipaddress=Inet4Address.getLocalHost().getHostAddress();
        db1.inserttripdestdata(no, lat2, long2, str);
        
       
        String latit1= (String)session.getAttribute("latitude1");
        String longit1= (String)session.getAttribute("longitude1");
           
          //  String distance=t.getloc(latit1, longit1, lat2, long2);
        String distance=t.getloc(latout, longout, lat2, long2);
        
        System.out.println(lat1+" "+long1+" "+lat2+" "+long2);
        System.out.println("Dist="+distance);
        System.out.println("first loop ends");
        request.setAttribute("distance1", distance);
        
         }
        }
        catch(Exception e){
            request.setAttribute("origin6", "Please press Stop Trip and wait to see message");
            request.setAttribute("distance1", "Distance has not been computed");
        }
        
        lat1="";
        lat2="";
        long1="";
        long2="";
        
        RequestDispatcher view = request.getRequestDispatcher("geoloc.jsp");
                view.forward(request, response);
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
       // processRequest(request, response);
      
        HttpSession session = request.getSession();
         String useremailid=(String)session.getAttribute("useremail"); 
         if(useremailid==null){
             
         }
         
        request.setAttribute("origin6", ".");
        request.setAttribute("distance1", ".");
        var1=request.getParameter("res1");
        var2=request.getParameter("res2");
         
          
        if (var1==null){
             session.setAttribute("latitude1", "");
        }
        if (var2==null){
             session.setAttribute("longitude1", "");
        }
       
        session.setAttribute("latitude1", var1);
        session.setAttribute("longitude1", var2);  
    
      
        
        lat1=var1;
        long1=var2;
        Test t=new Test();
        try{
        String orig=t.getaddress(var1, var2);
        
        str=orig.substring(2);
        
       
        String ipaddress=Inet4Address.getLocalHost().getHostAddress();
        db1.inserttriporigindata(useremailid, lat1, long1, str,ipaddress);
        
        
        
        System.out.println(str);
        
        
       
        
        // start trial
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    // IMPORTANT: Save the old System.out!
    PrintStream old = System.out;
    // Tell Java to use your special stream
    System.setOut(ps);
    // Print some output: goes to your special stream
    System.out.println(str);
    // Put things back
    System.out.flush();
    System.setOut(old);
    // Show what happened
    System.out.println("Here: Nik " + baos.toString());
        
        System.out.println(orig);
        or=baos.toString();
       
        
        request.setAttribute("origin5", baos.toString());
        }
        catch(Exception e){
            request.setAttribute("origin5", "Press Start Trip and wait to see message");
        }
        
        
        RequestDispatcher view = request.getRequestDispatcher("geoloc.jsp");
                view.forward(request, response);
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
