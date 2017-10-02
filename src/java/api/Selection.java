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
@WebServlet(name = "Selection", urlPatterns = {"/Selection"})
public class Selection extends HttpServlet {

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
            out.println("<title>Servlet Selection</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Selection at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();  
       
        String output1=request.getParameter("selection");
        String str=request.getParameter("load");
        String mail1=request.getParameter("t4");
        String mail2=request.getParameter("t5");
        String mail3=request.getParameter("t6");
        ObjectReader o1=new ObjectReader();
        
        ArrayList output=new ArrayList();       
        
        
        if (request.getParameter("approved") != null){
       // do something
            String url="http://52.91.188.107/api/v2/expense/_table/Userentry?fields=Name,Email,iImageID,description&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8&filter=(approved%20EQ%20Y)%20AND%20(Email="+session.getAttribute("useremail")+")";
            String transno=o1.gettransfromindex(Integer.parseInt(output1),url);
            session.setAttribute("count","0");
            session.setAttribute("myId",transno);
            output=o1.getimagesfromid(transno);
            Object[] output2 = output.toArray();
            
             if(output2.length>0){
                Arrays.sort(output2);       
            String imagedefault=output2[0].toString();
            session.setAttribute("imageno",imagedefault);
    RequestDispatcher view = request.getRequestDispatcher("test3.jsp");
           view.forward(request, response); 
             }
             else{
                  RequestDispatcher view = request.getRequestDispatcher("image_donotexist.jsp");
           view.forward(request, response); 
             }
            
          
        }
        
        else if (request.getParameter("rejected") != null){
       // do something
            String url="http://52.91.188.107/api/v2/expense/_table/Userentry?fields=Name,Email,iImageID,description&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8&filter=(approved%20EQ%20N)%20AND%20(Email="+session.getAttribute("useremail")+")";
            String transno=o1.gettransfromindex(Integer.parseInt(output1),url);
            session.setAttribute("count","0");
            session.setAttribute("myId",transno);
            output=o1.getimagesfromid(transno);
            Object[] output2 = output.toArray();
           if(output2.length>0){
                Arrays.sort(output2);       
            String imagedefault=output2[0].toString();
            session.setAttribute("imageno",imagedefault);
    RequestDispatcher view = request.getRequestDispatcher("test3.jsp");
           view.forward(request, response); 
             }
             else{
                  RequestDispatcher view = request.getRequestDispatcher("image_donotexist.jsp");
           view.forward(request, response); 
             }
            
        }
        
        else if (request.getParameter("pending") != null){
       // do something
            String url="http://52.91.188.107/api/v2/expense/_table/Userentry?fields=Name,Email,iImageID,description&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8&filter=(approved%20NE%20N)%20AND%20(approved%20NE%20Y)%20AND%20(Email="+session.getAttribute("useremail")+")";
            String transno=o1.gettransfromindex(Integer.parseInt(output1),url);
            session.setAttribute("count","0");
            session.setAttribute("myId",transno);
            output=o1.getimagesfromid(transno);
            Object[] output2 = output.toArray();
            if(output2.length>0){
                Arrays.sort(output2);       
            String imagedefault=output2[0].toString();
            session.setAttribute("imageno",imagedefault);
    RequestDispatcher view = request.getRequestDispatcher("test3.jsp");
           view.forward(request, response); 
             }
             else{
                  RequestDispatcher view = request.getRequestDispatcher("image_donotexist.jsp");
           view.forward(request, response); 
             }
            
        }
        
        else if (request.getParameter("allsubmissions") != null){
       // do something
            String url="http://52.91.188.107/api/v2/expense/_table/Userentry?fields=Name,Email,iImageID,description&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8&filter=(Email="+session.getAttribute("useremail")+")";
            String transno=o1.gettransfromindex(Integer.parseInt(output1),url);
            session.setAttribute("count","0");
            session.setAttribute("myId",transno);
            output=o1.getimagesfromid(transno);
            Object[] output2 = output.toArray();
            
            if(output2.length>0){
                Arrays.sort(output2);       
            String imagedefault=output2[0].toString();
            System.out.println(imagedefault);
            session.setAttribute("imageno",imagedefault);
    RequestDispatcher view = request.getRequestDispatcher("test3.jsp");
           view.forward(request, response); 
             }
             else{
                  RequestDispatcher view = request.getRequestDispatcher("image_donotexist.jsp");
           view.forward(request, response); 
             }
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
        HttpSession session = request.getSession();  
       
        String output1=request.getParameter("selection");
        String str=request.getParameter("load");
        String mail1=request.getParameter("t4");
        String mail2=request.getParameter("t5");
        String mail3=request.getParameter("t6");
        ObjectReader o1=new ObjectReader();
        DBPrint d=new DBPrint();
        String url="http://52.91.188.107/api/v2/expense/_table/Userentry?fields=Name,Email,iImageID,description&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8&filter=(approved%20NE%20N)%20AND%20(approved%20NE%20Y)%20AND%20(manageremail="+session.getAttribute("approveremail")+")";
        String transno=o1.gettransfromindex(Integer.parseInt(output1),url);
        session.setAttribute("myId",transno);
       
        ArrayList output=new ArrayList();       
        output=o1.getimagesfromid(transno);
        Object[] output2 = output.toArray();
        System.out.println(output2.length);
        if(output2.length>0){
            
             Arrays.sort(output2);
        
        String imagedefault=output2[0].toString();
        session.setAttribute("imageno",imagedefault);
        }
        
        if (request.getParameter("receipt") != null){
       // do something
            session.setAttribute("count","0");
            session.setAttribute("selector",".");
            if(output2.length>0){
                RequestDispatcher view = request.getRequestDispatcher("test2.jsp");
            view.forward(request, response);                 
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("image_donotexist.jsp");
           view.forward(request, response);  
            }
           
        }
        
        else{
        String str1="The transaction "+transno+" has been "+str;
        
        
        String submitteremail=o1.getemailfromid(transno);
        String name=o1.getnamefromemail(submitteremail);
        String approveremail=o1.getapproveremailfromid(transno);
        Double useramount=Double.parseDouble(o1.getamountfromid(transno));
        String doctype=o1.getdescriptionfromid(transno);
        String text="";
        String text1="";
        String text2="";
        String link="http://usersubmission2-env.us-east-1.elasticbeanstalk.com/";
        if (str.matches("approved")) 
                {
                if(useramount > 0){
                  text="Dear "+name+","+"\n\nYour expense of "+useramount+" referring to Transaction "+transno+" for "+doctype+" has been approved.\n"+
                           "Please find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                  text1="Hi,"+"\n\nThe expense of "+useramount+" referring to Transaction "+transno+" for "+doctype+" has been approved.\n"+
                           "Please find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                            
                }
                else{
                  text="Dear "+name+","+"\n\nYour document referring to Transaction "+transno+" for "+doctype+" has been approved.\n"+
                         "Please find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                  text1="Hi,"+"\n\nThe document referring to Transaction "+transno+" for "+doctype+" has been approved.\n"+
                           "Please find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                                         
                }
                String subject="Docuwind - transaction " + transno+" approved";
                Javamail sa= new Javamail();
                
                sa.sendmailwithsubject(submitteremail, text, subject);
                sa.sendmailwithsubject(mail1, text1, subject);
                sa.sendmailwithsubject(mail2, text1, subject);
                sa.sendmailwithsubject(mail3, text1, subject);
                /*
                //start section-send money through stripe
                ObjectReader o=new ObjectReader();
                o.payment(dbemail, intamt);
                    */
                //end section
                String str6="Y";
                d.updatetrans(str6, transno);
                
                }
        
        if (str.matches("rejected")) 
                {
                if(useramount > 0){
                  text="Dear "+name+","+"\n\nYour expense of "+useramount+" referring to Transaction "+transno+" for "+doctype+" has been rejected.\n"+
                           "Please find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                  text1="Hi,"+"\n\nThe expense of "+useramount+" referring to Transaction "+transno+" for "+doctype+" has been rejected.\n"+
                           "Please find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                        
                }
                else{
                  text="Dear "+name+","+"\n\nYour document referring to Transaction "+transno+" for "+doctype+" has been rejected.\n"+
                          "Please find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                  text1="Hi,"+"\n\nThe document referring to Transaction "+transno+" for "+doctype+" has been rejected.\n"+
                           "Please find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                   
                }
                String subject="Docuwind - transaction " + transno+" rejected";
                Javamail sa= new Javamail();
                
                sa.sendmailwithsubject(submitteremail, text, subject);
                sa.sendmailwithsubject(mail1, text1, subject);
                sa.sendmailwithsubject(mail2, text1, subject);
                sa.sendmailwithsubject(mail3, text1, subject);
                
                String str6="N";
                d.updatetrans(str6, transno);
              
                }
        
        if (str.matches("reassigned")) 
            {

                String updatedapproveremail=request.getParameter("t7");
                d.updatemanageremail(updatedapproveremail, transno);
                ObjectReader o=new ObjectReader();
                String approvername=o.getnamefromemail(updatedapproveremail);
                System.out.println(approvername);
                if (approvername.isEmpty()==true){
                    approvername=updatedapproveremail;
                }
                str1="The transaction "+transno+" has been "+str+" to "+approvername+" for further action";
                
                if(useramount > 0){
                  text="Dear "+name+","+"\n\nYour expense of "+useramount+" referring to Transaction "+transno+" for "+doctype+" has been reassigned to "+approvername+" for further action."+
                      "\nPlease find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                  text1="Hi,"+"\n\nThe expense of "+useramount+" referring to Transaction "+transno+" for "+doctype+" has been reassigned to "+approvername+" for further action."+
                      "\nPlease find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                  text2="Dear "+approvername+","+"\n\n"+name+" has sent an expense of "+useramount+" referring to Transaction "+transno+" related to "+doctype+" for approval."+
                      "\nPlease find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+                      
                          "\n\nPlease visit: "+link+"approvallogin.jsp to take further action on it."+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                 
                }
                else{
                  text="Dear "+name+","+"\n\nYour document referring to Transaction "+transno+" for "+doctype+" has been reassigned to "+approvername+" for further action."
                     +"\nPlease find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nThe Docuwind team,\nwww.docuwind.com";         
                  text1="Hi,"+"\n\nThe document referring to Transaction "+transno+" for "+doctype+" has been reassigned to "+approvername+" for further action."+
                      "\nPlease find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";         
                  text2="Dear "+approvername+","+"\n\n"+name+" has sent a document referring to Transaction "+transno+" related to "+doctype+" for approval."+
                       "\nPlease find the document at: "+link+"Getimageid?docno="+transno+"&submit=Enter"+                                
                          "\n\nPlease visit: "+link+"approvallogin.jsp to take further action on it."+"\n\nRegards,"+"\n\nTeam Docuwind,\nwww.docuwind.com";                          
                }
                String subject="Docuwind - transaction " + transno+" reassigned";
                Javamail sa= new Javamail();
                
                sa.sendmailwithsubject(submitteremail, text, subject);
                sa.sendmailwithsubject(mail1, text1, subject);
                sa.sendmailwithsubject(mail2, text1, subject);
                sa.sendmailwithsubject(mail3, text1, subject);
                sa.sendmailwithsubject(updatedapproveremail, text2, subject);
            }
        
        session.setAttribute("selector",str1);
        RequestDispatcher view = request.getRequestDispatcher("approval.jsp");
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
