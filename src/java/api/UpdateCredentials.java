/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.IOException;
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
@WebServlet(name = "UpdateCredentials", urlPatterns = {"/UpdateCredentials"})
public class UpdateCredentials extends HttpServlet {

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
            out.println("<title>Servlet UpdateCredentials</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCredentials at " + request.getContextPath() + "</h1>");
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
        
        HttpSession session = request.getSession();   
        String email=(String)session.getAttribute("useremail");
        
        String str2=request.getParameter("organization");      
        String str3=request.getParameter("address");
        String str4=request.getParameter("key");
        
        String str5=request.getParameter("fullname");
        String str6=request.getParameter("phone");
        String str7=request.getParameter("country");
       
        
        //System.out.println(str2 + " "+ str3 + " "+ str4 + " "+ str5 + " "+ str6 + " "+ str7);
         
         DBPrint db1=new DBPrint();
         db1.updateadmindata(email,str2, str3, str4, str5, str6, str7);
        
        RequestDispatcher view = request.getRequestDispatcher("account_confirmation.jsp");
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
        //processRequest(request, response);
        
        HttpSession session = request.getSession();   
        
        String str2=(String)session.getAttribute("useremail");
        
        String str3=request.getParameter("fullname");
        String str4=request.getParameter("password");
        String str5=request.getParameter("level");
        String str6=request.getParameter("manageremail");
        String str7=request.getParameter("organization");
        
        String str8=request.getParameter("accountno");
        String str9=request.getParameter("routingno");
        
       // System.out.println(str2 + " "+ str3 + " "+ str4 + " "+ str5 + " "+ str6 + " "+ str7);
        
        DBPrint db1=new DBPrint();
        db1.updateuserdata(str2, str3, str4, str5, str6, str7,str8,str9);
        
        RequestDispatcher view = request.getRequestDispatcher("account_confirmation.jsp");
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
