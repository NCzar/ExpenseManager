/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author nikhilv85
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nikhilv85
 */
public class Buildhtml {
   
        
  
     
   
     public  void writehtml(String str1) throws IOException {
     StringBuilder sb = new StringBuilder();
    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>Title Of the page");
    sb.append("</title>");
    sb.append("</head>");
    sb.append("<body> <b>");
    sb.append(str1);
    sb.append("</b>");
    sb.append("</body>");
    sb.append("</html>");
    
    
    
    FileWriter fstream = new FileWriter("web//MyHtml.html");
    
    BufferedWriter out = new BufferedWriter(fstream);
    
    out.write(sb.toString());
    out.close();
     }
}
