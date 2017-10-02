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
@WebServlet(name = "Geodistance", urlPatterns = {"/Geodistance"})
public class Geodistance extends HttpServlet {
     String var1,var2,var3,var4,origin1,str,str1;
     String lat1,long1,lat2,long2;
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
            out.println("<title>Servlet Geodistance</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Geodistance at " + request.getContextPath() + "</h1>");
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
        System.out.println(lat1+" "+long1+" "+lat2+" "+long2);
        Test t=new Test();
        String dis=t.getloc(lat1, long1, lat2, long2);
        if (request.getParameter("submit3")!=null){
            String[] km=dis.split(" ");
            double k=Float.parseFloat(km[0]);
            double kilo;
            if(km[1].contains("f")){
                 kilo=k*1.60934/1000;
            }
            else{
                 kilo=k*1.60934;
            }
           
           String finalkm=String.valueOf(kilo);
           HttpSession session = request.getSession();
        session.setAttribute("dis", finalkm);
        }
        else{
            HttpSession session = request.getSession();
        session.setAttribute("dis", dis);
        }
            
        
        
        RequestDispatcher view = request.getRequestDispatcher("geo1.jsp");
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
        var1=request.getParameter("res1");
        var2=request.getParameter("res2");
        var3=request.getParameter("res3");
        var4=request.getParameter("res4");
        
        
        
        System.out.println(var1+"hi "+var2+"hi "+var3+"hi "+var4);
    
        Test t=new Test();
        //String dist=t.getloc(var1,var2,var3,var4);
        if(var1.isEmpty() && var3.isEmpty()){
            System.out.println("Hello both strings are empty");
        }
        if(var3.isEmpty() && var1.isEmpty()==false){
            
            lat1=var1;
            long1=var2;
         origin1=t.getaddress(var1,var2);
          str=origin1.substring(2);
        
        int len=origin1.length();
       
        String origin="Hello";
        System.out.println(str);
        System.out.println(origin1);
        
       
        
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
    
    HttpSession session = request.getSession();
        session.setAttribute("orig3", baos.toString());
     }
        else if(var1.isEmpty() && var3.isEmpty()==false)
        {
            lat2=var3;
            long2=var4;
           origin1=t.getaddress(var3,var4); 
            str1=origin1.substring(2);
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
    
    HttpSession session = request.getSession();
        session.setAttribute("orig4", baos.toString());
        }   
        
        //end trial
      // session.setAttribute("dis",dist);
    
        RequestDispatcher view = request.getRequestDispatcher("geo1.jsp");
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
