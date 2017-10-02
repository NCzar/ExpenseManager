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

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.io.*;
import java.util.*;
public class images {
    public static byte[] getPhoto (Connection conn, int iNumPhoto)
       throws Exception, SQLException
  {
    String req = "" ;
    Blob img ;
    byte[] imgData = null ;
    Statement stmt = conn.createStatement ();
    
    // Query
    req = "SELECT  bImage FROM [Userdetails].[dbo].[upload_image] where iImageID=" + iNumPhoto ;
    
    ResultSet rset  = stmt.executeQuery ( req ); 
    
    while (rset.next ())
    {    
      img = rset.getBlob(1);
      imgData = img.getBytes(1,(int)img.length());
    }    
    
    rset.close();
    stmt.close();
    
    return imgData ;
  }
    
     public static byte[] getimage (Connection conn, int iNumPhoto)
       throws Exception, SQLException
  {
    String req = "" ;
    Blob img ;
    byte[] imgData = null ;
    Statement stmt = conn.createStatement ();
    
    // Query
    req = "SELECT  bImage FROM [Userdetails].[dbo].[upload_image] where Id_new=" + iNumPhoto ;
    
    ResultSet rset  = stmt.executeQuery ( req ); 
    
    while (rset.next ())
    {    
      img = rset.getBlob(1);
      imgData = img.getBytes(1,(int)img.length());
    }    
    
    rset.close();
    stmt.close();
    
    return imgData ;
  }
    
    public static BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
 
        return bufferedImage;
    }
    
}
