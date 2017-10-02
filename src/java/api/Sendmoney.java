/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Recipient;
import com.stripe.model.Transfer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nikhilv85
 */
@WebServlet(name = "Sendmoney", urlPatterns = {"/Sendmoney"})
public class Sendmoney extends HttpServlet {

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
            out.println("<title>Servlet Sendmoney</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Sendmoney at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        try {
            try {
                // processRequest(request, response);
                
                Stripe.apiKey = "sk_test_SxJjmpFZilGA0oiZfQDxqsqQ";
                
// Get the bank account details submitted by the form
                String tokenID = request.getParameter("stripeToken");
                
// Create a Recipient
                Map<String, Object> recipientParams = new HashMap<String, Object>();
                recipientParams.put("name", "John Doe");
                recipientParams.put("type", "individual");
                recipientParams.put("bank_account", tokenID);
                recipientParams.put("email", "payee@example.com");
                System.out.println("Hello " + tokenID);
                Recipient recipient = Recipient.create(recipientParams);
            } catch (AuthenticationException ex) {
                Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidRequestException ex) {
                Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
            } catch (APIConnectionException ex) {
                Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CardException ex) {
                Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
            } catch (APIException ex) {
                Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
            }
            String acc=request.getParameter("accountNumber");
            System.out.println("Hi"+acc);
            Map<String, Object> transferParams = new HashMap<String, Object>();
            transferParams.put("amount", 1000); // amount in cents
            transferParams.put("currency", "usd");
            transferParams.put("recipient", "Nikhil");
            transferParams.put("bank_account", acc);
            transferParams.put("statement_descriptor", "JULY SALES");
            
            Transfer transfer = Transfer.create(transferParams);
            
        } catch (AuthenticationException ex) {
            Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidRequestException ex) {
            Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
        } catch (APIConnectionException ex) {
            Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CardException ex) {
            Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
        } catch (APIException ex) {
            Logger.getLogger(Sendmoney.class.getName()).log(Level.SEVERE, null, ex);
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
