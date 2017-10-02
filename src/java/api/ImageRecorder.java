/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;



import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author nikhilv85
 */
@WebServlet(name = "ImageRecorder", urlPatterns = {"/ImageRecorder"})
@MultipartConfig(location="/api")
public class ImageRecorder extends HttpServlet {

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
            out.println("<title>Servlet ImageRecorder</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImageRecorder at " + request.getContextPath() + "</h1>");
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
      //  processRequest(request, response);
        System.out.println("error3");
        
        String imgSrcParam = request.getParameter("res1");
        System.out.println(imgSrcParam);
        String imgSrcParam1="http://api.grabz.it/services/getjspicture.ashx?id=YWE1YTViZjIzZjFlNDE3Yzk2ZGU1YTVjYWEzZjIyN2I=-d5e68b24ea5e413fbd42973dda9bcd2da";
        SaveImageFromUrl su=new SaveImageFromUrl();
       su.saveImage(imgSrcParam,"y2.png");
        byte[] b1=su.converttobyte(imgSrcParam);
        System.out.println(b1);
            
        //start trial
        
        Connection conn=null;
   
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
            "databaseName=Userdetails;user=jyteam;password=jyteam2016");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImageRecorder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ImageRecorder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ImageRecorder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ImageRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    

   PreparedStatement psImageInsertDatabase=null;
   PreparedStatement psImageInsertDatabase2=null;
   
   
   try{
      
      HttpSession session = request.getSession();   
      String temp=(String)session.getAttribute("myId");
       System.out.println("error check 2");
     
      String sqlImageInsertDatabase="insert into upload_image (bImage) values (?)";
      String sqlImageInsertDatabase2="UPDATE [dbo].[upload_image] SET [iImageID] = '"+temp+"' WHERE [iImageID] is null AND [bImage] is not null";
      
      
      
      psImageInsertDatabase=conn.prepareStatement(sqlImageInsertDatabase);
      System.out.println("error check 3");
     // DiskFileItemFactory factory = new DiskFileItemFactory();

   
    //  List items = sfu.parseRequest(request);

    


System.out.println("error check 6");
   //   System.out.println(b1);
     // psImageInsertDatabase.setBytes(1,b);
      
      psImageInsertDatabase.setBytes(1,b1);
      psImageInsertDatabase.executeUpdate();
      
      psImageInsertDatabase2=conn.prepareStatement(sqlImageInsertDatabase2);
      psImageInsertDatabase2.executeUpdate();
      
      RequestDispatcher view = request.getRequestDispatcher("transactions.jsp");
                view.forward(request, response);
   }
   catch(Exception e)
   {
     e.printStackTrace();
     //response.sendRedirect("addimage.jsp");
   }
   
   
        
        // end trial
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
