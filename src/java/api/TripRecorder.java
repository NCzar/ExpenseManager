/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.IOException;
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
@WebServlet(name = "TripRecorder", urlPatterns = {"/TripRecorder"})
public class TripRecorder extends HttpServlet {

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
            out.println("<title>Servlet TripRecorder</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TripRecorder at " + request.getContextPath() + "</h1>");
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
        String str1=request.getParameter("res1");
        String str2=request.getParameter("res2");
        System.out.println("mycoord="+str1+"/"+str2);
        
        HttpSession session = request.getSession();   
      String email=(String)session.getAttribute("trip_email");
       // String email="nikhil@inspiredliving.company";
        
        ObjectReader o=new ObjectReader();
        DBPrint d1=new DBPrint();
        Test t1=new Test();
        String checkid="";
        
         if (email==null){
            //String ipaddress=Inet4Address.getLocalHost().getHostAddress();
            String ipaddress=t1.getPublicIpAddress();
            System.out.println(ipaddress+" get");
             checkid=d1.gettripIDfromip(ipaddress);
            }
            else{
             checkid=d1.gettripID(email);  
            }
        //String checkid=d1.gettripID(email);
          
        if (checkid.isEmpty()==false){
            int checkidno=Integer.parseInt(checkid);
            String status=o.gettripstatus(checkidno);
            System.out.println(status);
        
            if(status.matches("start")==true){
                if(str1.isEmpty()==false){
                d1.inserttripdata(checkidno, str1, str2);
                }
            }
        }
        
        if (request.getParameter("submit1") != null){
       // do something
            session.setAttribute("status","Trip recording in progress");
            Test t=new Test();
            DBPrint d=new DBPrint();
            String add=t.getaddress(str1, str2);
            // String ipaddress=Inet4Address.getLocalHost().getHostAddress();
            String ipaddress=t.getPublicIpAddress();
            String id="";
           if(email==null){
               String id1=d.gettripIDfromip(ipaddress);
               String email1=d.getemailfromID(id1);
               d.inserttriporigindata(email1, str1, str2, add,ipaddress);
               id=d.gettripID(email1);
           }
           else{
               d.inserttriporigindata(email, str1, str2, add,ipaddress);       
               id=d.gettripID(email);
           }
            
            int idno=Integer.parseInt(id);
            d.updatetriporigindata(idno, "start");
            
            
         }
        
         if (request.getParameter("submit2") != null){
       // do something
            
            session.setAttribute("status","Trip recording has stopped");
            Test t=new Test();
            DBPrint d=new DBPrint();
            
             String id="";
            if (email==null){
            // String ipaddress=Inet4Address.getLocalHost().getHostAddress();
            String ipaddress=t.getPublicIpAddress();
                id=d.gettripIDfromip(ipaddress);
            }
            else{
             id=d.gettripID(email);  
            }
            
            int idno=Integer.parseInt(id);
                              
            String lat1=o.getfirstlat(idno);
            String long1=o.getfirstlong(idno);
            d.updatetriporigindata1(idno,"stop",lat1,long1);
            String lat2=o.getlastlat(idno);
            String long2=o.getlastlong(idno);
            
            
            String add=t.getaddress(lat1, long1);
            
            d.updatetriporigindata2(idno, add);
            session.setAttribute("originaddress",add);
           
            String add1=t.getaddress(lat2, long2);
            d.inserttripdestdata(idno, lat2, long2, add1);
           
            session.setAttribute("destinationaddress",add1);
            
            String dist=t.getloc(lat1, long1, lat2, long2);
            session.setAttribute("distance",dist);
         }
         
        RequestDispatcher view = request.getRequestDispatcher("navigator.jsp");
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
        String str1=request.getParameter("res1");
        String str2=request.getParameter("res2");
        System.out.println("coord="+str1+"/"+str2);
        
        HttpSession session = request.getSession();   
      String email=(String)session.getAttribute("trip_email");
        //String email="nikhil@inspiredliving.company";
        System.out.println(email);
        ObjectReader o=new ObjectReader();
        DBPrint d1=new DBPrint();
        Test t1=new Test();
        String checkid="";
        
         if (email==null){
            //String ipaddress=Inet4Address.getLocalHost().getHostAddress();
            String ipaddress=t1.getPublicIpAddress();
            System.out.println(ipaddress+" post");
             checkid=d1.gettripIDfromip(ipaddress);
            }
            else{
             checkid=d1.gettripID(email);  
            }  
       // String checkid=d1.gettripID(email);
        
        if (checkid.isEmpty()==false){
            int checkidno=Integer.parseInt(checkid);
        String status=o.gettripstatus(checkidno);
        System.out.println(status);
            if(status.matches("start")==true){
                if(str1.isEmpty()==false){
                 d1.inserttripdata(checkidno, str1, str2);
                }           
            }
        }
        
         if (request.getParameter("submit1") != null){
       // do something
            
            session.setAttribute("status","Trip recording in progress");
            Test t=new Test();
            DBPrint d=new DBPrint();
            String add=t.getaddress(str1, str2);
           // String ipaddress=Inet4Address.getLocalHost().getHostAddress();
            String ipaddress=t.getPublicIpAddress();
            String id="";
           if(email==null){
               String id1=d.gettripIDfromip(ipaddress);
               String email1=d.getemailfromID(id1);
               d.inserttriporigindata(email1, str1, str2, add,ipaddress);
               id=d.gettripID(email1);
           }
           else{
               d.inserttriporigindata(email, str1, str2, add,ipaddress);       
               id=d.gettripID(email);
           }
            
            int idno=Integer.parseInt(id);
            d.updatetriporigindata(idno, "start");
           // HttpSession session = request.getSession();
            session.setAttribute("originaddress",add);
            
         }
         
         if (request.getParameter("submit2") != null){
       // do something
            
            session.setAttribute("status","Trip recording has stopped");
            Test t=new Test();
            DBPrint d=new DBPrint();
            
            String id="";
            if (email==null){
           // String ipaddress=Inet4Address.getLocalHost().getHostAddress();
            String ipaddress=t.getPublicIpAddress();
             id=d.gettripIDfromip(ipaddress);
            }
            else{
             id=d.gettripID(email);  
            }
            
            int idno=Integer.parseInt(id);
            
            
            String lat1=o.getfirstlat(idno);
            String long1=o.getfirstlong(idno);
            d.updatetriporigindata1(idno,"stop",lat1,long1);
            String lat2=o.getlastlat(idno);
            String long2=o.getlastlong(idno);
            
            
           // HttpSession session = request.getSession();
            String add=t.getaddress(lat1, long1);
            d.updatetriporigindata2(idno, add);
            session.setAttribute("originaddress",add);
            
            String add1=t.getaddress(lat2, long2);
            d.inserttripdestdata(idno, lat2, long2, add1);
           
            session.setAttribute("destinationaddress",add1);
            
            String dist=t.getloc(lat1, long1, lat2, long2);
            session.setAttribute("distance",dist);
            
         }
        RequestDispatcher view = request.getRequestDispatcher("navigator_1.jsp");
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
