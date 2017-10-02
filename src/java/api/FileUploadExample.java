/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;


import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import api.Getapproval;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;



/**
 *
 * @author nikhilv85
 */
@WebServlet(name = "FileUploadExample", urlPatterns = {"/FileUploadExample"})
public class FileUploadExample extends HttpServlet {

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
            out.println("<title>Servlet FileUploadExample</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FileUploadExample at " + request.getContextPath() + "</h1>");
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
        
        int count;
        byte[] b1=null;
        byte[] b2=null;
       // byte[][] b2=new byte[50][];
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	 
	        if (isMultipart) {
	        	// Create a factory for disk-based file items
	        	FileItemFactory factory = new DiskFileItemFactory();

	        	// Create a new file upload handler
	        	ServletFileUpload upload = new ServletFileUpload(factory);
	 
	            try {
	            	// Parse the request
	            	List /* FileItem */ items = upload.parseRequest(request);
	                Iterator iterator = items.iterator();
	                while (iterator.hasNext()) {
	                    FileItem item = (FileItem) iterator.next();
	                    if (!item.isFormField()) {
	                        String fileName = item.getName();	 
	                        String root = getServletContext().getRealPath("/");
                                
                                
	                        
                                File path = new File(root + "/uploads");
                                
                           
                                
	                        if (!path.exists()) {
	                            boolean status = path.mkdirs();
	                        }
	 
	                        File uploadedFile = new File(path + "/" + fileName);
                                
                                
                                
	                        System.out.println(uploadedFile.getAbsolutePath());
                                item.write(uploadedFile);
                                
                                     String root2 = getServletContext().getRealPath("/")+"/fileoutput";
                                PDFToPNG p1= new PDFToPNG();
                                b1 = p1.convert(uploadedFile,root2);
                                
                                count=p1.pageno(uploadedFile);
                               
                              //  t.pdftojpg(uploadedFile);
                               // t.pdftojpgconv(uploadedFile);
	                        // b1= t.pdftojpg(uploadedFile);
                                //item.write(path1);
                                
                                //trial starts
                                
                                // trial ends
                                
                                // System.out.println(b1);
                                System.out.println("error check 1");
                               
                                Connection conn=null;
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
    conn = DriverManager.getConnection("jdbc:sqlserver://expense.cv1nc2pzdpnv.us-west-2.rds.amazonaws.com:1433;" +
         "databaseName=Userdetails;user=jyteam;password=jyteam2016");

   PreparedStatement psImageInsertDatabase=null;
   PreparedStatement psImageInsertDatabase2=null;
   
   
  
   byte[] b=null;
   try{
      
      HttpSession session = request.getSession();   
      String temp=(String)session.getAttribute("myId");
       System.out.println("error check 2");
     
      String sqlImageInsertDatabase="insert into upload_image (bImage) values (?)";
      String sqlImageInsertDatabase2="UPDATE [dbo].[upload_image] SET [iImageID] = '"+temp+"' WHERE [iImageID] is null AND [bImage] is not null";
      
      
      
      psImageInsertDatabase=conn.prepareStatement(sqlImageInsertDatabase);
      System.out.println("error check 3");
     // DiskFileItemFactory factory = new DiskFileItemFactory();

      ServletFileUpload sfu = new ServletFileUpload(factory);
    //  List items = sfu.parseRequest(request);

      Iterator iter = items.iterator();
System.out.println("error check 4");

      while (iter.hasNext()) {
          item = (FileItem) iter.next();
         if (!item.isFormField()) {
              b = item.get();
              System.out.println("error check 5");
          }
      }


System.out.println("error check 6");
   //   System.out.println(b1);
     // psImageInsertDatabase.setBytes(1,b);
System.out.println(count);

      for(int i=0;i<count;i++){
        b2=p1.convertpages(uploadedFile,root2,i+1);
                
      //psImageInsertDatabase.setBytes(1,b1);
      psImageInsertDatabase.setBytes(1,b2);    
      psImageInsertDatabase.executeUpdate();
      
      psImageInsertDatabase2=conn.prepareStatement(sqlImageInsertDatabase2);
      psImageInsertDatabase2.executeUpdate();
      }
      RequestDispatcher view = request.getRequestDispatcher("transactions.jsp");
                view.forward(request, response);
   }
   catch(Exception e)
   {
     e.printStackTrace();
     //response.sendRedirect("addimage.jsp");
   }

	                    }
	                }
	            } catch (FileUploadException e) {
	                e.printStackTrace();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	     
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
