/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
@WebServlet(name = "Getimageid", urlPatterns = {"/Getimageid"})
public class Getimageid extends HttpServlet {
    int counter;
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
            out.println("<title>Servlet Getimageid</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Getimageid at " + request.getContextPath() + "</h1>");
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
        
        
        String o=request.getParameter("docno");
        Integer no1 = Integer.parseInt(o);
        String no=String.valueOf(no1);
       
        HttpSession session = request.getSession();    
    session.setAttribute("myId",no);
    ArrayList output=new ArrayList(); 
    ObjectReader o1=new ObjectReader();
    output=o1.getimagesfromid(no);
            Object[] output2 = output.toArray();
            
             if(output2.length>0){
                 for(int i=0;i<output2.length;i++){
             //  System.out.println(output2[i].toString());
             }
                Arrays.sort(output2);       
            String imagedefault=output2[0].toString();
             for(int i=0;i<output2.length;i++){
               System.out.println(output2[i].toString());
             }
             
            session.setAttribute("imageno",imagedefault);
    RequestDispatcher view = request.getRequestDispatcher("test3.jsp");
           view.forward(request, response); 
             }
             else{
                  RequestDispatcher view = request.getRequestDispatcher("image_donotexist.jsp");
           view.forward(request, response); 
             }
            
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
        int c1;
        HttpSession session = request.getSession(); 
        String transid=(String)session.getAttribute("myId");
        String usercheck=(String)session.getAttribute("username");
        if (usercheck==null){
            RequestDispatcher view = request.getRequestDispatcher("imagelogin.jsp");
           view.forward(request, response);
            
        }
        System.out.println(transid+"=");
        ArrayList output=new ArrayList();
        ObjectReader o=new ObjectReader();
         output=o.getimagesfromid(transid);
        int c=output.size();
        for (int i=0;i<c;i++){
         //   System.out.println(output.get(i)+" "+counter);
            
        }
        
        if (request.getParameter("next") != null){
            String countno=(String)session.getAttribute("count");
            counter=Integer.parseInt(countno);
            if(counter<c-1){
              counter=counter+1;
             
              session.setAttribute("count", String.valueOf(counter));
            }
            
        }
        else if(counter>0){
         counter=counter-1;   
         
         session.setAttribute("count", String.valueOf(counter));
        }
        
        Object[] output2 = output.toArray();
        Arrays.sort(output2);
        
        String no=output2[counter].toString();
        
       // String no=(String)output.get(counter);
        System.out.print(no);
        
        session.setAttribute("imageno", no);
    RequestDispatcher view = request.getRequestDispatcher("test3.jsp");
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
