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
@WebServlet(name = "Getapproval", urlPatterns = {"/Getapproval"})
public class Getapproval extends HttpServlet {
    int approvalcheck=0;
    String name,detail;
    String expense="";
    float amt;
    String approvalemail;
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
            out.println("<title>Servlet Getapproval</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Getapproval at " + request.getContextPath() + "</h1>");
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
       
        String approval=request.getParameter("approval");
        
        if (approval.matches("Approve")) 
                {
                String text="Dear "+name+","+"\n\nYour document or expense of "+expense+" for "+detail+" has been approved.\n"+"\nRegards,"+"\nInspiredLiving";
        
                Javamail sa= new Javamail();
                sa.sendmail(text,approvalemail);
            }
        else{
            String text="Dear "+name+","+"\n\nYour expense of "+expense+" for "+detail+" has been rejected.\n"+"\nRegards,"+"\nInspiredLiving";
        
            Javamail sa= new Javamail();
            sa.sendmail(text,approvalemail);
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
        //processRequest(request, response);
        
       String str="1";
        
         HttpSession session = request.getSession(); 
        name = request.getParameter("name");
        String youremail=(String)session.getAttribute("useremail");
        expense=request.getParameter("expense");
        if (expense.isEmpty()==true){
            System.out.println("expense is null");
            //float amt=0;
            amt=0;
        } 
        else{
            System.out.println("expense is not null");
            //float amt=Float.valueOf(expense);
            amt=Float.valueOf(expense);
        }
        
        detail=request.getParameter("detail");
        String manageremail=request.getParameter("manageremail");
        approvalemail=youremail;
         
                DBPrint db=new DBPrint();
                db.getdata(name, detail, youremail, manageremail, amt, "");
                str=db.getID(name,youremail);
               // System.out.println("Hi"+str);
                ObjectReader o=new ObjectReader();
                String approvername=o.getnamefromemail(manageremail);
                System.out.println(approvername);
                if (approvername.isEmpty()==true){
                    approvername=manageremail;
                }
                
                Javamail sa= new Javamail();
                String text="";
                String text1="";
                 String link="http://usersubmission2-env.us-east-1.elasticbeanstalk.com/";
                 if (amt>0){
                     text="Dear "+name+","+"\n\nYour expense of "+amt+" referring to Transaction "+str+" for "+detail+" has been submitted to "+approvername+" for further action."+
                      "\n\nPlease find the document at: "+link+"Getimageid?docno="+str+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                 text1="Dear "+approvername+","+"\n\n"+name+" has sent an expense of "+amt+" referring to Transaction "+str+" related to "+detail+" for approval."+
                      "\n\nPlease find the document at: "+link+"Getimageid?docno="+str+"&submit=Enter"+                      
                          "\n\nPlease visit: "+link+"approvallogin.jsp to take further action on it."+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
              
                 }
                 else{
                      text="Dear "+name+","+"\n\nYour form referring to Transaction "+str+" for "+detail+" has been submitted to "+approvername+" for further action."+
                      "\n\nPlease find the document at: "+link+"Getimageid?docno="+str+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                 text1="Dear "+approvername+","+"\n\n"+name+" has sent a form referring to Transaction "+str+" related to "+detail+" for approval."+
                      "\n\nPlease find the document at: "+link+"Getimageid?docno="+str+"&submit=Enter"+                      
                          "\n\nPlease visit: "+link+"approvallogin.jsp to take further action on it."+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
              
                 }  
        // text="Dear "+name+","+"\n\nYour transaction for "+detail+" has been submitted.\n"+"Your transaction number is "+str+".\n\nRegards,"+"\nInspiredLiving";
               String subject = "Docuwind - "+str+" submitted";
               String subject1 = "Docuwind - "+str+" for approval";
              //   sa.sendmail(text,youremail);
                sa.sendmailwithsubject(youremail, text, subject);
                sa.sendmailwithsubject(manageremail, text1, subject1);
    session.setAttribute("myId",str);
    
    /*   
    text1="Hi,"+"\n\n"+name+" has submitted transaction no "+str+" for "+detail+".\n"+"Please visit the below link to approve or reassign or reject it.\n\n"
                  +"http://expensecheck-env.us-east-1.elasticbeanstalk.com/"+"\n\nRegards,"+"\nInspiredLiving";
                sa.sendmail(text1,manageremail);      
        */ 
               
              // request.setAttribute("expense",expense);
              RequestDispatcher view = request.getRequestDispatcher("docrouting.jsp");
                view.forward(request, response);
        /*
        if (name.matches("Approve")) 
                {
                String text="Your expense has been approved";
                System.out.println(text);
                Javamail sa= new Javamail();
                sa.sendmail(text,email);
            }
        else{
            String text="Your expense has been rejected";
            System.out.println(text);
        }
        */
        
        
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
