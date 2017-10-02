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

/**
 *
 * @author nikhilv85
 */
@WebServlet(name = "AdminRegistration", urlPatterns = {"/AdminRegistration"})
public class AdminRegistration extends HttpServlet {

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
            out.println("<title>Servlet AdminRegistration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminRegistration at " + request.getContextPath() + "</h1>");
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
      //  processRequest(request, response);
        String orgname=request.getParameter("orgname");
        String address=request.getParameter("address");
        String stripekey=request.getParameter("stripekey");
        String adminname=request.getParameter("adminname");
        String adminemail=request.getParameter("adminemail");
        String password=request.getParameter("password");
        String country=request.getParameter("country");
        String phoneno=request.getParameter("phoneno");
        String accountno=request.getParameter("accountno");
        String routingno=request.getParameter("routingno");
        
        ObjectReader o=new ObjectReader();
       String url="";
    
       String inst="52.91.188.107";
    String dfkey="5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8";
    
       url="http://"+inst+"/api/v2/expense/_table/Organization?fields=OrganizationName&api_key="+dfkey;
       boolean orgexists=o.checkfororg(url, orgname);
       if (orgexists==true){
           RequestDispatcher view = request.getRequestDispatcher("org_alreadyexists.jsp");
                view.forward(request, response);
       }
       
       url="http://"+inst+"/api/v2/expense/_table/Userregistration?fields=Email&api_key="+dfkey;
       boolean usernamexists= o.checkforuseremail(url, adminemail);
       if (usernamexists==true){
           RequestDispatcher view = request.getRequestDispatcher("username_alreadyexists.jsp");
                view.forward(request, response);
       }
       else{
           // email,name,pwd,level,manageremail,org
                 DBPrint db=new DBPrint();
                db.insertorgdata(orgname, address, stripekey, adminemail, adminname, phoneno, country, password);    
                db.insertuserdata(adminemail, adminname, password, "Level 4", "", orgname,accountno,routingno);
                RequestDispatcher view = request.getRequestDispatcher("register_confirmation.jsp");
                view.forward(request, response);
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
